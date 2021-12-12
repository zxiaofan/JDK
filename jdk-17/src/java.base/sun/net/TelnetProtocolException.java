/*
 * Copyright (c) 1994, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.net;

import java.io.*;

/**
 * An unexpected result was received by the client when talking to the
 * telnet server.
 *
 * @author      Jonathan Payne
 */

public class TelnetProtocolException extends IOException {
    @java.io.Serial
    private static final long serialVersionUID = 8509127047257111343L;

    public TelnetProtocolException(String s) {
        super(s);
    }
}
