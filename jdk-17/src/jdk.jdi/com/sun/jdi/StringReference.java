/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi;

/**
 * A string object from the target VM.
 * A StringReference is an {@link ObjectReference} with additional
 * access to string-specific information from the target VM.
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */
public interface StringReference extends ObjectReference {

    /**
     * Returns the StringReference as a String. The returned string
     * is the equivalent of the mirrored string, but is an entity in the
     * client VM and can be manipulated like any other string.
     *
     * @return the string value.
     */
    String value();
}
