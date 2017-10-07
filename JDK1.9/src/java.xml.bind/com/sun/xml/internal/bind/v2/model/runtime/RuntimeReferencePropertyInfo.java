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

package com.sun.xml.internal.bind.v2.model.runtime;

import java.lang.reflect.Type;
import java.util.Set;

import com.sun.xml.internal.bind.v2.model.core.ReferencePropertyInfo;

/**
 * @author Kohsuke Kawaguchi
 */
public interface RuntimeReferencePropertyInfo extends ReferencePropertyInfo<Type,Class>, RuntimePropertyInfo {
    Set<? extends RuntimeElement> getElements();
}
