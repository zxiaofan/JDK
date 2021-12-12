/*
 * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
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

import jdk.internal.access.JavaLangInvokeAccess;
import jdk.internal.access.SharedSecrets;

import java.lang.StackWalker.StackFrame;
import java.lang.invoke.MethodType;

class StackFrameInfo implements StackFrame {
    private static final JavaLangInvokeAccess JLIA =
        SharedSecrets.getJavaLangInvokeAccess();

    private final boolean retainClassRef;
    private final Object memberName;    // MemberName initialized by VM
    private int bci;                    // initialized by VM to >= 0
    private volatile StackTraceElement ste;

    /*
     * Construct an empty StackFrameInfo object that will be filled by the VM
     * during stack walking.
     *
     * @see StackStreamFactory.AbstractStackWalker#callStackWalk
     * @see StackStreamFactory.AbstractStackWalker#fetchStackFrames
     */
    StackFrameInfo(StackWalker walker) {
        this.retainClassRef = walker.retainClassRef;
        this.memberName = JLIA.newMemberName();
    }

    // package-private called by StackStreamFactory to skip
    // the capability check
    Class<?> declaringClass() {
        return JLIA.getDeclaringClass(memberName);
    }

    // ----- implementation of StackFrame methods

    @Override
    public String getClassName() {
        return declaringClass().getName();
    }

    @Override
    public Class<?> getDeclaringClass() {
        ensureRetainClassRefEnabled();
        return declaringClass();
    }

    @Override
    public String getMethodName() {
        return JLIA.getName(memberName);
    }

    @Override
    public MethodType getMethodType() {
        ensureRetainClassRefEnabled();
        return JLIA.getMethodType(memberName);
    }

    @Override
    public String getDescriptor() {
        return JLIA.getMethodDescriptor(memberName);
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

    private void ensureRetainClassRefEnabled() {
        if (!retainClassRef) {
            throw new UnsupportedOperationException("No access to RETAIN_CLASS_REFERENCE");
        }
    }
}
