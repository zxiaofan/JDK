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

package jdk.jfr.events;

import jdk.jfr.*;
import jdk.jfr.internal.MirrorEvent;

@Category({"Java Development Kit", "Security"})
@Label("X509 Certificate")
@Name("jdk.X509Certificate")
@Description("Details of X.509 Certificate parsed by JDK")
@MirrorEvent(className = "jdk.internal.event.X509CertificateEvent")
public final class X509CertificateEvent extends AbstractJDKEvent {
    @Label("Signature Algorithm")
    public String algorithm;

    @Label("Serial Number")
    public String serialNumber;

    @Label("Subject")
    public String subject;

    @Label("Issuer")
    public String issuer;

    @Label("Key Type")
    public String keyType;

    @Label("Key Length")
    public int keyLength;

    @Label("Certificate Id")
    @CertificateId
    public long certificateId;

    @Label("Valid From")
    @Timestamp(Timestamp.MILLISECONDS_SINCE_EPOCH)
    public long validFrom;

    @Label("Valid Until")
    @Timestamp(Timestamp.MILLISECONDS_SINCE_EPOCH)
    public long validUntil;
}
