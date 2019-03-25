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
 * Event recording details of successful TLS handshakes.
 */

public final class TLSHandshakeEvent extends Event {
    public String peerHost;
    public int peerPort;
    public String protocolVersion;
    public String cipherSuite;
    public long certificateId;
}
