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

package com.sun.tools.internal.xjc.model;

import com.sun.tools.internal.xjc.model.nav.NClass;
import com.sun.tools.internal.xjc.model.nav.NType;
import com.sun.xml.internal.bind.v2.model.core.Element;

/**
 * Either {@link CElementInfo}, {@link CClassInfo}, or {@link CClassRef}.
 *
 * @author Kohsuke Kawaguchi
 */
public interface CElement extends CTypeInfo, Element<NType,NClass> {
    /**
     * Marks this element as an abstract element.
     */
    void setAbstract();

    /**
     * Returns true iff this element is an abstract element.
     */
    boolean isAbstract();
}
