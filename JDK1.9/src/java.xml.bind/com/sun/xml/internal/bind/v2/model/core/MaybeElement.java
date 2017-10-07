/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.model.core;

import javax.xml.namespace.QName;

/**
 * Some {@link NonElement} can optionally be an {@link Element}.
 *
 * This interface captures such characteristics.
 *
 * @author Kohsuke Kawaguchi
 */
public interface MaybeElement<T,C> extends NonElement<T,C> {
    /**
     * If the class is bound to an element, return true.
     *
     * <p>
     * Note that when this is true, the class is bound to both an element
     * and a type.
     */
    boolean isElement();

    /**
     * Gets the element name of the class, if the class is bound
     * to an element.
     *
     * @return
     *      non-null iff {@link #isElement()}.
     */
    QName getElementName();

    /**
     * Returns the {@link Element} aspect of this {@link ClassInfo}.
     *
     * @return
     *      null if {@link #isElement()}==false, non-null if {@link #isElement()}==true.
     */
    Element<T,C> asElement();
}
