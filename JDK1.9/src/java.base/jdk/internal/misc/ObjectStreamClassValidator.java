/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.io.ObjectStreamClass;

/**
 * A callback used by {@code ObjectInputStream} to do descriptor validation.
 *
 * @author sjiang
 */
public interface ObjectStreamClassValidator {
    /**
     * This method will be called by ObjectInputStream to
     * check a descriptor just before creating an object described by this descriptor.
     * The object will not be created if this method throws a {@code RuntimeException}.
     * @param descriptor descriptor to be checked.
     */
    public void validateDescriptor(ObjectStreamClass descriptor);
}
