/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package sun.util.resources;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Implements ResourceBundle for LocaleNames bundles that don't provide
 * the complete set of locale names.
 */
public abstract class LocaleNamesBundle extends OpenListResourceBundle {

    protected LocaleNamesBundle() {
    }
}
