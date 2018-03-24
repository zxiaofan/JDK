/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.misc;

import java.io.ObjectInputFilter;

/**
 * Access to the alternative ObjectInputFilter.Config.createFilter2 for RMI.
 */
public interface JavaObjectInputFilterAccess {
    /**
     * Creates a filter from the pattern.
     */
    ObjectInputFilter createFilter2(String pattern);
}
