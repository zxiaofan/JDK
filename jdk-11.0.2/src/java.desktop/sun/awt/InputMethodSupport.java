/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

import java.awt.AWTException;
import java.awt.Window;
import java.awt.im.spi.InputMethodDescriptor;
import java.util.Locale;
import sun.awt.im.InputContext;

/**
 * Input method support for toolkits
 */
public interface InputMethodSupport {
    /**
     * Returns a new input method adapter descriptor for native input methods.
     */
    InputMethodDescriptor getInputMethodAdapterDescriptor()
        throws AWTException;
    /**
     * Returns a new input method window for the platform
     */
    Window createInputMethodWindow(String title, InputContext context);

    /**
     * Returns whether input methods are enabled on the platform
     */
    boolean enableInputMethodsForTextComponent();

    /**
     * Returns the default keyboard locale of the underlying operating system.
     */
    Locale getDefaultKeyboardLocale();
}
