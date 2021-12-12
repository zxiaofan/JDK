/*
 * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.awt;

import java.io.Serial;

/**
 * Thrown by method createFont in the {@code Font} class to indicate
 * that the specified font is bad.
 *
 * @author  Parry Kejriwal
 * @see     java.awt.Font
 * @since   1.3
 */
public
class FontFormatException extends Exception {

    /**
     * Use serialVersionUID from JDK 1.6 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -4481290147811361272L;

    /**
     * Report a FontFormatException for the reason specified.
     * @param reason a {@code String} message indicating why
     *        the font is not accepted.
     */
    public FontFormatException(String reason) {
      super (reason);
    }
}
