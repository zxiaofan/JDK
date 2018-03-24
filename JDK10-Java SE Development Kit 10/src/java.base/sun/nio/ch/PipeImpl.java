/*
 * Copyright (c) 2002, 2016, Oracle and/or its affiliates. All rights reserved.
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

/*
 */

package sun.nio.ch;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.*;
import java.nio.channels.*;
import java.nio.channels.spi.*;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.security.PrivilegedActionException;
import java.security.SecureRandom;
import java.util.Random;


/**
 * A simple Pipe implementation based on a socket connection.
 */

class PipeImpl
    extends Pipe
{
    // Number of bytes in the secret handshake.
    private static final int NUM_SECRET_BYTES = 16;

    // Random object for handshake values
    private static final Random RANDOM_NUMBER_GENERATOR = new SecureRandom();

    // Source and sink channels
    private SourceChannel source;
    private SinkChannel sink;

    private class Initializer
        implements PrivilegedExceptionAction<Void>
    {

        private final SelectorProvider sp;

        private IOException ioe = null;

        private Initializer(SelectorProvider sp) {
            this.sp = sp;
        }

        @Override
        public Void run() throws IOException {
            LoopbackConnector connector = new LoopbackConnector();
            connector.run();
            if (ioe instanceof ClosedByInterruptException) {
                ioe = null;
                Thread connThread = new Thread(connector) {
                    @Override
                    public void interrupt() {}
                };
                connThread.start();
                for (;;) {
                    try {
                        connThread.join();
                        break;
                    } catch (InterruptedException ex) {}
                }
                Thread.currentThread().interrupt();
            }

            if (ioe != null)
                throw new IOException("Unable to establish loopback connection", ioe);

            return null;
        }

        private class LoopbackConnector implements Runnable {

            @Override
            public void run() {
                ServerSocketChannel ssc = null;
                SocketChannel sc1 = null;
                SocketChannel sc2 = null;

                try {
                    // Create secret with a backing array.
                    ByteBuffer secret = ByteBuffer.allocate(NUM_SECRET_BYTES);
                    ByteBuffer bb = ByteBuffer.allocate(NUM_SECRET_BYTES);

                    // Loopback address
                    InetAddress lb = InetAddress.getByName("127.0.0.1");
                    assert(lb.isLoopbackAddress());
                    InetSocketAddress sa = null;
                    for(;;) {
                        // Bind ServerSocketChannel to a port on the loopback
                        // address
                        if (ssc == null || !ssc.isOpen()) {
                            ssc = ServerSocketChannel.open();
                            ssc.socket().bind(new InetSocketAddress(lb, 0));
                            sa = new InetSocketAddress(lb, ssc.socket().getLocalPort());
                        }

                        // Establish connection (assume connections are eagerly
                        // accepted)
                        sc1 = SocketChannel.open(sa);
                        RANDOM_NUMBER_GENERATOR.nextBytes(secret.array());
                        do {
                            sc1.write(secret);
                        } while (secret.hasRemaining());
                        secret.rewind();

                        // Get a connection and verify it is legitimate
                        sc2 = ssc.accept();
                        do {
                            sc2.read(bb);
                        } while (bb.hasRemaining());
                        bb.rewind();

                        if (bb.equals(secret))
                            break;

                        sc2.close();
                        sc1.close();
                    }

                    // Create source and sink channels
                    source = new SourceChannelImpl(sp, sc1);
                    sink = new SinkChannelImpl(sp, sc2);
                } catch (IOException e) {
                    try {
                        if (sc1 != null)
                            sc1.close();
                        if (sc2 != null)
                            sc2.close();
                    } catch (IOException e2) {}
                    ioe = e;
                } finally {
                    try {
                        if (ssc != null)
                            ssc.close();
                    } catch (IOException e2) {}
                }
            }
        }
    }

    PipeImpl(final SelectorProvider sp) throws IOException {
        try {
            AccessController.doPrivileged(new Initializer(sp));
        } catch (PrivilegedActionException x) {
            throw (IOException)x.getCause();
        }
    }

    public SourceChannel source() {
        return source;
    }

    public SinkChannel sink() {
        return sink;
    }

}
