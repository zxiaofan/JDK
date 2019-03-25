/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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
package sun.nio.ch.sctp;

import com.sun.nio.sctp.Association;
import com.sun.nio.sctp.Notification;

/**
 * All Notification implemenations MUST implement this interface to provide
 * access to the native association identidier.
 */
interface SctpNotification extends Notification {
    int assocId();
    void setAssociation(Association association);
}
