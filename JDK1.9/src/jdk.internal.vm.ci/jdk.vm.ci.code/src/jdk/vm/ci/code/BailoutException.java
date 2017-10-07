/*
 * Copyright (c) 2009, 2011, Oracle and/or its affiliates. All rights reserved.
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
 */
package jdk.vm.ci.code;

import java.util.Locale;

/**
 * Exception thrown when the compiler refuses to compile a method because of problems with the
 * method. e.g. bytecode wouldn't verify, too big, JSR/ret too complicated, etc. This exception is
 * <i>not</i> meant to indicate problems with the compiler itself.
 */
public class BailoutException extends RuntimeException {

    public static final long serialVersionUID = 8974598793458772L;
    private final boolean permanent;

    /**
     * Creates a new {@link BailoutException}.
     *
     *
     * @param args parameters to the formatter
     */
    public BailoutException(String format, Object... args) {
        super(String.format(Locale.ENGLISH, format, args));
        this.permanent = true;
    }

    /**
     * Creates a new {@link BailoutException}.
     *
     *
     * @param args parameters to the formatter
     */
    public BailoutException(Throwable cause, String format, Object... args) {
        super(String.format(Locale.ENGLISH, format, args), cause);
        this.permanent = true;
    }

    /**
     * Creates a new {@link BailoutException}.
     *
     * @param permanent specifies whether this exception will occur again if compilation is retried
     * @param args parameters to the formatter
     */
    public BailoutException(boolean permanent, String format, Object... args) {
        super(String.format(Locale.ENGLISH, format, args));
        this.permanent = permanent;
    }

    /**
     * @return whether this exception will occur again if compilation is retried
     */
    public boolean isPermanent() {
        return permanent;
    }
}
