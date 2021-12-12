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
 * Event recording details of X.509 Certificate.
 */

public final class X509CertificateEvent extends Event {
    public String algorithm;
    public String serialNumber;
    public String subject;
    public String issuer;
    public String keyType;
    public int keyLength;
    public long certificateId;
    public long validFrom;
    public long validUntil;
}
