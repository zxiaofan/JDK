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
 * Notification emitted when an association has either opened or closed.
 *
 * @since 1.7
 */
public abstract class AssociationChangeNotification
    implements Notification
{
    /**
     * Defines the type of change event that happened to the association.
     *
     * @since 1.7
     */
    public enum AssocChangeEvent
    {
        /**
         * A new association is now ready and data may be exchanged with this peer.
         */
        COMM_UP,

        /**
         * The association has failed. A series of SCTP send failed notifications
         * will follow this notification, one for each outstanding message.
         */
       COMM_LOST,

        /**
         * SCTP has detected that the peer has restarted.
         */
       RESTART,

        /**
         * The association has gracefully closed.
         */
       SHUTDOWN,

        /**
         * The association failed to setup. If a message was sent on a {@link
         * SctpMultiChannel} in non-blocking mode, an
         * SCTP send failed notification will follow this notification for the
         * outstanding message.
         */
       CANT_START
    }

    /**
     * Initializes a new instance of this class.
     */
    protected AssociationChangeNotification() {}

    /**
     * Returns the association that this notification is applicable to.
     *
     * @return  The association whose state has changed, or {@code null} if
     *          there is no association, that is {@linkplain
     *          AssocChangeEvent#CANT_START CANT_START}
     */
    public abstract Association association();

    /**
     * Returns the type of change event.
     *
     * @return  The event
     */
    public abstract AssocChangeEvent event();
}
