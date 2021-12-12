/*
 * Copyright (c) 2020, Azul Systems, Inc. All rights reserved.
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
package sun.security.jgss.krb5.internal;

import org.ietf.jgss.ChannelBinding;

/**
 * TLS Channel Binding wrapper class to determine internal
 * tls channel binding implementation.
 */
public class TlsChannelBindingImpl extends ChannelBinding {
    public TlsChannelBindingImpl(byte[] appData) {
        super(appData);
    }
}
