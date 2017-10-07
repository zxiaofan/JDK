/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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



/**
 * Interface that indicates a Font2D that is not a Composite but has the
 * property that it internally behaves like one, substituting glyphs
 * from another font at render time.
 * In this case the Font must provide a way to behave like a regular
 * composite when that behaviour is not wanted.
 */
public interface FontSubstitution {
    public CompositeFont getCompositeFont2D();
}
