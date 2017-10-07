/*
 * Copyright (c) 2007, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.font;

@SuppressWarnings("serial") // JDK-implementation class
public class FontScalerException extends Exception {
    public FontScalerException() {
      super("Font scaler encountered runtime problem.");
    }

    public FontScalerException(String reason) {
      super (reason);
    }
}
