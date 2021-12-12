/*
 * Copyright (c) 2004, 2019, Oracle and/or its affiliates. All rights reserved.
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

/**
 * ExceptionProxy for TypeNotPresentException.
 *
 * @author  Josh Bloch
 * @since   1.5
 */
public class TypeNotPresentExceptionProxy extends ExceptionProxy {
    @java.io.Serial
    private static final long serialVersionUID = 5565925172427947573L;
    final String typeName;
    final Throwable cause;

    public TypeNotPresentExceptionProxy(String typeName, Throwable cause) {
        this.typeName = typeName;
        this.cause = cause;
    }

    protected RuntimeException generateException() {
        return new TypeNotPresentException(typeName, cause);
    }

    public String typeName() {
        return typeName;
    }

    public Throwable getCause() {
        return cause;
    }

    @Override
    public String toString() {
        return typeName + ".class /* Warning: type not present! */";
    }
}
