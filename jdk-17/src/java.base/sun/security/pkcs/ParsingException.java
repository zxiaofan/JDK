/*
 * Copyright (c) 1996, 2019, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Generic PKCS Parsing exception.
 *
 * @author Benjamin Renaud
 */

package sun.security.pkcs;

import java.io.IOException;

public class ParsingException extends IOException {

    @java.io.Serial
    private static final long serialVersionUID = -6316569918966181883L;

    public ParsingException() {
        super();
    }

    public ParsingException(String s) {
        super(s);
    }
}
