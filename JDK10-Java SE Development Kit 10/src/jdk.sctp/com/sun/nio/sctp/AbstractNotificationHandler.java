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

/**
 * A skeletal handler that consumes notifications and continues.
 *
 * <P> This class trivially implements the {@code handleNotification} methods to
 * return {@link HandlerResult#CONTINUE CONTINUE} so that all notifications are
 * consumed and the channel continues to try and receive a message.
 *
 * <P> It also provides overloaded versions of the {@code handleNotification}
 * methods, one for each of the required supported notification types, {@link
 * AssociationChangeNotification}, {@link PeerAddressChangeNotification},
 * {@link SendFailedNotification}, and {@link ShutdownNotification}. The
 * appropriate method will be invoked when the notification is received.
 *
 * @since 1.7
 */
public class AbstractNotificationHandler<T>
    implements NotificationHandler<T>
{
    /**
     * Initializes a new instance of this class.
     */
    protected AbstractNotificationHandler() {}

    /**
     * Invoked when an implementation specific notification is received from the
     * SCTP stack.
     *
     * @param  notification
     *         The notification
     *
     * @param  attachment
     *         The object attached to the {@code receive} operation when it was
     *         initiated.
     *
     * @return  The handler result
     */
    @Override
    public HandlerResult handleNotification(Notification notification,
                                            T attachment) {
        return HandlerResult.CONTINUE;
    }

    /**
     * Invoked when an {@link AssociationChangeNotification} is received from
     * the SCTP stack.
     *
     * @param  notification
     *         The notification
     *
     * @param  attachment
     *         The object attached to the {@code receive} operation when it was
     *         initiated.
     *
     * @return  The handler result
     */
    public HandlerResult handleNotification(AssociationChangeNotification notification,
                                            T attachment) {
        return HandlerResult.CONTINUE;
    }

    /**
     * Invoked when an {@link PeerAddressChangeNotification} is received from
     * the SCTP stack.
     *
     * @param  notification
     *         The notification
     *
     * @param  attachment
     *         The object attached to the {@code receive} operation when it was
     *         initiated.
     *
     * @return  The handler result
     */
    public HandlerResult handleNotification(PeerAddressChangeNotification notification,
                                            T attachment) {
        return HandlerResult.CONTINUE;
    }

    /**
     * Invoked when an {@link SendFailedNotification} is received from
     * the SCTP stack.
     *
     * @param  notification
     *         The notification
     *
     * @param  attachment
     *         The object attached to the {@code receive} operation when it was
     *         initiated.
     *
     * @return  The handler result
     */
    public HandlerResult handleNotification(SendFailedNotification notification,
                                            T attachment) {
        return HandlerResult.CONTINUE;
    }

    /**
     * Invoked when an {@link ShutdownNotification} is received from
     * the SCTP stack.
     *
     * @param  notification
     *         The notification
     *
     * @param  attachment
     *         The object attached to the {@code receive} operation when it was
     *         initiated.
     *
     * @return  The handler result
     */
    public HandlerResult handleNotification(ShutdownNotification notification,
                                            T attachment) {
        return HandlerResult.CONTINUE;
    }
}
