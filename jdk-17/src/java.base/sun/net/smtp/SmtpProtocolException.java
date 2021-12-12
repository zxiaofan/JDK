/*
 * Copyright (c) 1995, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.smtp;

import java.io.IOException;

/**
 * This exception is thrown when unexpected results are returned during
 * an SMTP session.
 */
public class SmtpProtocolException extends IOException {
    @java.io.Serial
    private static final long serialVersionUID = -7547136771133814908L;

    SmtpProtocolException(String s) {
        super(s);
    }
}
