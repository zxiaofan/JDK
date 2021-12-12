/*
 * Copyright (c) 2016, 2019, Oracle and/or its affiliates. All rights reserved.
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
 */
package jdk.vm.ci.hotspot;

import jdk.vm.ci.meta.Signature;

/**
 * Describes a method for which the VM has an intrinsic implementation.
 */
public final class VMIntrinsicMethod {

    /**
     * The name of the class declaring the intrinsified method. The name is in
     * <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.2.1">class
     * file format</a> (e.g., {@code "java/lang/Thread"} instead of {@code "java.lang.Thread"}).
     */
    public final String declaringClass;

    /**
     * The name of the intrinsified method. This is not guaranteed to be a legal method name (e.g.,
     * there is a HotSpot intrinsic with the name {@code "<compiledLambdaForm>"}).
     */
    public final String name;

    /**
     * The {@link Signature#toMethodDescriptor() descriptor} of the intrinsified method. This is not
     * guaranteed to be a legal method descriptor (e.g., intrinsics for signature polymorphic
     * methods have a descriptor of {@code "*"}).
     */
    public final String descriptor;

    /**
     * The unique VM identifier for the intrinsic.
     */
    public final int id;

    @VMEntryPoint
    VMIntrinsicMethod(String declaringClass, String name, String descriptor, int id) {
        this.declaringClass = declaringClass;
        this.name = name;
        this.descriptor = descriptor;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VMIntrinsicMethod) {
            VMIntrinsicMethod that = (VMIntrinsicMethod) obj;
            if (that.id == this.id) {
                assert that.name.equals(this.name) &&
                                that.declaringClass.equals(this.declaringClass) &&
                                that.descriptor.equals(this.descriptor);
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("IntrinsicMethod[declaringClass=%s, name=%s, descriptor=%s, id=%d]", declaringClass, name, descriptor, id);
    }
}
