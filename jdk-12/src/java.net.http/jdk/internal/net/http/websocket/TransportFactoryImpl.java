/*
 * Copyright (c) 2017, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http.websocket;

public class TransportFactoryImpl implements TransportFactory {

    private final RawChannel channel;

    public TransportFactoryImpl(RawChannel channel) {
        this.channel = channel;
    }

    @Override
    public Transport createTransport(MessageQueue queue,
                                     MessageStreamConsumer consumer) {
        return new TransportImpl(queue, consumer, channel);
    }
}
