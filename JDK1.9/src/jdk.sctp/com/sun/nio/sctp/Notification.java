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
 * A notification from the SCTP stack.
 *
 * <P> Objects of this type are passed to the {@link NotificationHandler} when
 * a notification is received.
 *
 * <P> An SCTP channel supports the following notifications: {@link
 * AssociationChangeNotification}, {@link PeerAddressChangeNotification},
 * {@link SendFailedNotification}, {@link ShutdownNotification}, and may support
 * additional implementation specific notifications.
 *
 * @since 1.7
 */
public interface Notification {
    /**
     * Returns the association that this notification is applicable to.
     *
     * @return  The association
     */
    public Association association();
}
