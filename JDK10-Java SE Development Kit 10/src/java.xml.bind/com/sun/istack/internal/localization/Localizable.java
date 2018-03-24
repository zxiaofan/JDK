/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.istack.internal.localization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Localizable message.
 *
 * @author WS Development Team
 */
public interface Localizable {
    /**
     * Gets the key in the resource bundle.
     *
     * @return
     *      if this method returns {@link #NOT_LOCALIZABLE},
     *      that means the message is not localizable, and
     *      the first item of {@link #getArguments()} array
     *      holds a String.
     */
    public String getKey();

    /**
     * Returns the arguments for message formatting.
     *
     * @return
     *      can be an array of length 0 but never be null.
     */
    public Object[] getArguments();
    public String getResourceBundleName();

    public ResourceBundle getResourceBundle(Locale locale);

    /**
     * Special constant that represents a message that
     * is not localizable.
     *
     * <p>
     * Use of "new" is to create an unique instance.
     */
    public static final String NOT_LOCALIZABLE = "\u0000";
}
