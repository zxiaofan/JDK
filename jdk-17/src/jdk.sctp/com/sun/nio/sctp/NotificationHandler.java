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
 * A handler for consuming notifications from the SCTP stack.
 *
 * <P> The SCTP channels defined in this package allow a notification handler to
 * be specified to consume notifications from the SCTP stack. When a
 * notification is received the {@linkplain #handleNotification
 * handleNotification} method of the handler is invoked to handle that
 * notification.
 *
 * <P> Additionally, an attachment object can be attached to the {@code receive}
 * operation to provide context when consuming the notification. The
 * attachment is important for cases where a <i>state-less</i> {@code
 * NotificationHandler} is used to consume the result of many {@code receive}
 * operations.
 *
 * <P> Handler implementations are encouraged to extend the {@link
 * AbstractNotificationHandler} class which implements this interface and
 * provide notification specific methods. However, an API should generally use
 * this handler interface as the type for parameters, return type, etc. rather
 * than the abstract class.
 *
 * @param  <T>  The type of the object attached to the receive operation
 *
 * @since 1.7
 */
public interface NotificationHandler<T> {
    /**
     * Invoked when a notification is received from the SCTP stack.
     *
     * @param  notification
     *         The notification
     *
     * @param  attachment
     *         The object attached to the receive operation when it was initiated.
     *
     * @return  The handler result
     */
    HandlerResult handleNotification(Notification notification, T attachment);
}
