/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package java.lang;

import jdk.internal.misc.JavaLangInvokeAccess;
import jdk.internal.misc.SharedSecrets;

import static java.lang.StackWalker.Option.*;
import java.lang.StackWalker.StackFrame;

class StackFrameInfo implements StackFrame {
    private final static JavaLangInvokeAccess JLIA =
        SharedSecrets.getJavaLangInvokeAccess();

    // Footprint improvement: MemberName::clazz can replace
    // StackFrameInfo::declaringClass.

    private final StackWalker walker;
    private final Class<?> declaringClass;
    private final Object memberName;
    private final short bci;
    private volatile StackTraceElement ste;

    /*
     * Create StackFrameInfo for StackFrameTraverser and LiveStackFrameTraverser
     * to use
     */
    StackFrameInfo(StackWalker walker) {
        this.walker = walker;
        this.declaringClass = null;
        this.bci = -1;
        this.memberName = JLIA.newMemberName();
    }

    // package-private called by StackStreamFactory to skip
    // the capability check
    Class<?> declaringClass() {
        return declaringClass;
    }

    // ----- implementation of StackFrame methods

    @Override
    public String getClassName() {
        return declaringClass.getName();
    }

    @Override
    public Class<?> getDeclaringClass() {
        walker.ensureAccessEnabled(RETAIN_CLASS_REFERENCE);
        return declaringClass;
    }

    @Override
    public String getMethodName() {
        return JLIA.getName(memberName);
    }

    @Override
    public int getByteCodeIndex() {
        // bci not available for native methods
        if (isNativeMethod())
            return -1;

        return bci;
    }

    @Override
    public String getFileName() {
        return toStackTraceElement().getFileName();
    }

    @Override
    public int getLineNumber() {
        // line number not available for native methods
        if (isNativeMethod())
            return -2;

        return toStackTraceElement().getLineNumber();
    }


    @Override
    public boolean isNativeMethod() {
        return JLIA.isNative(memberName);
    }

    @Override
    public String toString() {
        return toStackTraceElement().toString();
    }

    @Override
    public StackTraceElement toStackTraceElement() {
        StackTraceElement s = ste;
        if (s == null) {
            synchronized (this) {
                s = ste;
                if (s == null) {
                    ste = s = StackTraceElement.of(this);
                }
            }
        }
        return s;
    }
}
