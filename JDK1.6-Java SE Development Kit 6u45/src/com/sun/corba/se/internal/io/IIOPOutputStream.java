/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.internal.io;


public class IIOPOutputStream {
    
    /* Create a pending exception.  This is needed to get around
     * the fact that the *Delegate methods do not explicitly
     * declare that they throw exceptions.
     *
     * This native method creates an exception of the given type with
     * the given message string and posts it to the pending queue.
     */
    private static native void throwExceptionType(Class c, String message);

    private static native Object getObjectFieldOpt(Object o, long fieldID);
    private static native boolean getBooleanFieldOpt(Object o, long fieldID);
    private static native byte getByteFieldOpt(Object o, long fieldID);
    private static native char getCharFieldOpt(Object o, long fieldID);
    private static native short getShortFieldOpt(Object o, long fieldID);
    private static native int getIntFieldOpt(Object o, long fieldID);
    private static native long getLongFieldOpt(Object o, long fieldID);
    private static native float getFloatFieldOpt(Object o, long fieldID);
    private static native double getDoubleFieldOpt(Object o, long fieldID);

    private static native void writeObject(Object obj, Class asClass, Object oos) throws IllegalAccessException;
}
