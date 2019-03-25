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

import java.net.SocketAddress;

/**
 * Notification emitted when a destination address on a multi-homed peer
 * encounters a change.
 *
 * @since 1.7
 */
public abstract class PeerAddressChangeNotification
    implements Notification
{
    /**
     * Defines the type of address change event that occurred to the destination
     * address on a multi-homed peer when it encounters a change of interface
     * details.
     *
     * <P> Some of these events types are only generated when the association
     * supports dynamic address reconfiguration, e.g. {@code SCTP_ADDR_ADDED},
     * {@code SCTP_ADDR_REMOVED}, etc.
     *
     * @since 1.7
     */
    public enum AddressChangeEvent {
        /**
         * This address is now reachable.
         */
       ADDR_AVAILABLE,

       /**
        * The address specified can no longer be reached. Any data sent to this
        * address is rerouted to an alternate until this address becomes reachable.
        */
       ADDR_UNREACHABLE,

       /**
        * The address is no longer part of the association.
        */
       ADDR_REMOVED,

       /**
        * The address is now part of the association.
        */
       ADDR_ADDED,

       /**
        * This address has now been made to be the primary destination address.
        */
       ADDR_MADE_PRIMARY,

       /**
        * This address has now been confirmed as a valid address.
        */
       ADDR_CONFIRMED;
    }

    /**
     * Initializes a new instance of this class.
     */
    protected PeerAddressChangeNotification() {}

    /**
     * Returns the peer address.
     *
     * @return  The peer address
     */
    public abstract SocketAddress address();

    /**
     * Returns the association that this notification is applicable to.
     *
     * @return  The association whose peer address changed
     */
    public abstract Association association();

    /**
     * Returns the type of change event.
     *
     * @return  The event
     */
    public abstract AddressChangeEvent event();
}
