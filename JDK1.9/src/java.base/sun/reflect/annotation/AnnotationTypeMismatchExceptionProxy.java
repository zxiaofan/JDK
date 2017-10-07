/*
 * Copyright (c) 2004, 2016, Oracle and/or its affiliates. All rights reserved.
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

package sun.reflect.annotation;
import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * ExceptionProxy for AnnotationTypeMismatchException.
 *
 * @author  Josh Bloch
 * @since   1.5
 */
class AnnotationTypeMismatchExceptionProxy extends ExceptionProxy {
    private static final long serialVersionUID = 7844069490309503934L;
    private Method member;
    private final String foundType;

    /**
     * It turns out to be convenient to construct these proxies in
     * two stages.  Since this is a private implementation class, we
     * permit ourselves this liberty even though it's normally a very
     * bad idea.
     */
    AnnotationTypeMismatchExceptionProxy(String foundType) {
        this.foundType = foundType;
    }

    AnnotationTypeMismatchExceptionProxy setMember(Method member) {
        this.member = member;
        return this;
    }

    protected RuntimeException generateException() {
        return new AnnotationTypeMismatchException(member, foundType);
    }

    @Override
    public String toString() {
        return "/* Warning type mismatch! \"" + foundType + "\" */" ;
    }
}
