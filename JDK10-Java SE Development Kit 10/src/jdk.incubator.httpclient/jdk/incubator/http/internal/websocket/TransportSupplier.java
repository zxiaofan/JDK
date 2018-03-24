/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package jdk.incubator.http.internal.websocket;

import java.io.IOException;

/*
 * Abstracts out I/O channel for the WebSocket implementation. The latter then
 * deals with input and output streams of messages and does not have to
 * understand the state machine of channels (e.g. how exactly they are closed).
 * Mocking this type will allow testing WebSocket message exchange in isolation.
 */
public class TransportSupplier {

    protected final RawChannel channel; /* Exposed for testing purposes */
    private final Object lock = new Object();
    private Transmitter transmitter;
    private Receiver receiver;
    private boolean receiverShutdown;
    private boolean transmitterShutdown;
    private boolean closed;

    public TransportSupplier(RawChannel channel) {
        this.channel = channel;
    }

    public Receiver receiver(MessageStreamConsumer consumer) {
        synchronized (lock) {
            if (receiver == null) {
                receiver = newReceiver(consumer);
            }
            return receiver;
        }
    }

    public Transmitter transmitter() {
        synchronized (lock) {
            if (transmitter == null) {
                transmitter = newTransmitter();
            }
            return transmitter;
        }
    }

    protected Receiver newReceiver(MessageStreamConsumer consumer) {
        return new Receiver(consumer, channel) {
            @Override
            public void close() throws IOException {
                synchronized (lock) {
                    if (!closed) {
                        try {
                            super.close();
                        } finally {
                            receiverShutdown = true;
                            if (transmitterShutdown) {
                                closed = true;
                                channel.close();
                            }
                        }
                    }
                }
            }
        };
    }

    protected Transmitter newTransmitter() {
        return new Transmitter(channel) {
            @Override
            public void close() throws IOException {
                synchronized (lock) {
                    if (!closed) {
                        try {
                            super.close();
                        } finally {
                            transmitterShutdown = true;
                            if (receiverShutdown) {
                                closed = true;
                                channel.close();
                            }
                        }
                    }
                }
            }
        };
    }
}
