/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.nio.sctp;

import java.nio.ByteBuffer;
import java.net.SocketAddress;

/**
 * Notification emitted when a send failed notification has been received.
 *
 * <P> A send failed notification indicates that a message cannot be delivered.
 * Typically this is because the association has been shutdown with unsent data
 * in the socket output buffer, or in the case of a {@link SctpMultiChannel}
 * the association failed to setup.
 *
 * @since 1.7
 */
public abstract class SendFailedNotification implements Notification {
    /**
     * Initializes a new instance of this class.
     */
    protected SendFailedNotification() {}

    /**
     * Returns the association that this notification is applicable to.
     *
     * @return  The association that failed to send, or {@code null} if
     *          there is no association, that is, the notification follows a
     *          {@linkplain
     *          com.sun.nio.sctp.AssociationChangeNotification.AssocChangeEvent#CANT_START}
     */
    @Override
    public abstract Association association();

    /**
     * Returns the address.
     *
     * @return  The peer primary address of the association or the address that
     *          the message was sent to
     */
    public abstract SocketAddress address();

    /**
     * Returns the data that was to be sent.
     *
     * @return  The user data. The buffers position will be {@code 0} and its
     *          limit will be set to the end of the data.
     */
    public abstract ByteBuffer buffer();

    /**
     * Returns the error code.
     *
     * <P> The errorCode gives the reason why the send failed, and if set, will
     * be a SCTP protocol error code as defined in RFC2960 section 3.3.10
     *
     * @return  The error code
     */
    public abstract int errorCode();

    /**
     * Returns the stream number that the messge was to be sent on.
     *
     * @return  The stream number
     */
    public abstract int streamNumber();
}
