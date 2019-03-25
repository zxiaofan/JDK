/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.consumer;

import java.lang.reflect.Modifier;
import java.util.List;

import jdk.jfr.ValueDescriptor;
import jdk.jfr.internal.Type;

/**
 * A recorded method.
 *
 * @since 9
 */
public final class RecordedMethod extends RecordedObject {

    static ObjectFactory<RecordedMethod> createFactory(Type type, TimeConverter timeConverter) {
        return new ObjectFactory<RecordedMethod>(type) {
            @Override
            RecordedMethod createTyped(List<ValueDescriptor> desc, long id, Object[] object) {
                return new RecordedMethod(desc, object, timeConverter);
            }
        };
    }

    private RecordedMethod(List<ValueDescriptor> descriptors, Object[] objects, TimeConverter timeConverter) {
        super(descriptors, objects, timeConverter);
    }

    /**
     * Returns the class this method belongs to, if it belong to a Java frame.
     * <p>
     * To ensure this is a Java frame, use the {@link RecordedFrame#isJavaFrame()}
     * method.
     *
     * @return the class, may be {@code null} if not a Java frame
     *
     * @see RecordedFrame#isJavaFrame()
     */
    public RecordedClass getType() {
        return getTyped("type", RecordedClass.class, null);
    }

    /**
     * Returns the name of this method, for example {@code "toString"}.
     * <p>
     * If this method doesn't belong to a Java frame the result is undefined.
     *
     * @return method name, or {@code null} if doesn't exist
     *
     * @see RecordedFrame#isJavaFrame()
     */
    public String getName() {
        return getTyped("name", String.class, null);
    }

    /**
     * Returns the method descriptor for this method (for example,
     * {@code "(Ljava/lang/String;)V"}).
     * <p>
     * See Java Virtual Machine Specification, 4.3
     * <p>
     * If this method doesn't belong to a Java frame then the the result is undefined.
     *
     * @return method descriptor.
     *
     * @see RecordedFrame#isJavaFrame()
     */
    public String getDescriptor() {
        return getTyped("descriptor", String.class, null);
    }

    /**
     * Returns the modifiers for this method.
     * <p>
     * If this method doesn't belong to a Java frame, then the result is undefined.
     *
     * @return the modifiers
     *
     * @see Modifier
     * @see RecordedFrame#isJavaFrame
     */
    public int getModifiers() {
        return getTyped("modifiers", Integer.class, Integer.valueOf(0));
    }

    /**
     * Returns whether this method is hidden (for example, wrapper code in a lambda
     * expressions).
     *
     * @return {@code true} if method is hidden, {@code false} otherwise
     */
    public boolean isHidden() {
        return getTyped("hidden", Boolean.class, Boolean.FALSE);
    }
}
