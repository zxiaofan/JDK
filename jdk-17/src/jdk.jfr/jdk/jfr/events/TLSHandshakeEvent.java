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

import jdk.jfr.Category;
import jdk.jfr.Description;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.internal.MirrorEvent;

@Category({"Java Development Kit", "Security"})
@Label("TLS Handshake")
@Name("jdk.TLSHandshake")
@Description("Parameters used in TLS Handshake")
@MirrorEvent(className = "jdk.internal.event.TLSHandshakeEvent")
public final class TLSHandshakeEvent extends AbstractJDKEvent {
    @Label("Peer Host")
    public String peerHost;

    @Label("Peer Port")
    public int peerPort;

    @Label("Protocol Version")
    public String protocolVersion;

    @Label("Cipher Suite")
    public String cipherSuite;

    @Label("Certificate Id")
    @Description("Peer Certificate Id")
    @CertificateId
    public long certificateId;
}
