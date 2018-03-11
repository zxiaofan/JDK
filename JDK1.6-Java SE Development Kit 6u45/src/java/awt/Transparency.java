/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.awt;

/**
 * The <code>Transparency</code> interface defines the common transparency
 * modes for implementing classes.
 * @version %I%, %G%
 */
public interface Transparency {

    /**
     * Represents image data that is guaranteed to be completely opaque,
     * meaning that all pixels have an alpha value of 1.0.
     */
    public final static int OPAQUE            = 1;

    /**
     * Represents image data that is guaranteed to be either completely
     * opaque, with an alpha value of 1.0, or completely transparent,
     * with an alpha value of 0.0.
     */
    public final static int BITMASK = 2;

    /**
     * Represents image data that contains or might contain arbitrary
     * alpha values between and including 0.0 and 1.0.
     */
    public final static int TRANSLUCENT        = 3;

    /**
     * Returns the type of this <code>Transparency</code>.
     * @return the field type of this <code>Transparency</code>, which is
     *		either OPAQUE, BITMASK or TRANSLUCENT. 
     */
    public int getTransparency();
}
