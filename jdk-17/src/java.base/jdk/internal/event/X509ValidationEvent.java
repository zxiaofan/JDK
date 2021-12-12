/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.event;

/**
 * Event recording details of X.509 Certificate serial numbers
 * used in X509 cert path validation.
 */

public final class X509ValidationEvent extends Event {
    public long certificateId;
    public int certificatePosition;
    public long validationCounter;
}
