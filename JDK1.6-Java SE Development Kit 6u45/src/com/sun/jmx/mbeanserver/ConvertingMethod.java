/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.jmx.mbeanserver;
import java.io.InvalidObjectException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.management.Descriptor;
import javax.management.MBeanException;
import javax.management.ReflectionException;
import javax.management.RuntimeErrorException;
import javax.management.RuntimeMBeanException;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;

/**
   @author Eamonn McManus
*/
final class ConvertingMethod {
    static ConvertingMethod from(Method m) {
	try {
	    return new ConvertingMethod(m);
	} catch (OpenDataException ode) {
	    final String msg = "Method " + m.getDeclaringClass().getName() +
		"." + m.getName() + " has parameter or return type that " +
		"cannot be translated into an open type";
	    throw new IllegalArgumentException(msg, ode);
	}
    }

    Method getMethod() {
	return method;
    }
    
    Descriptor getDescriptor() {
        return Introspector.descriptorForElement(method);
    }

    Type getGenericReturnType() {
        return method.getGenericReturnType();
    }

    Type[] getGenericParameterTypes() {
        return method.getGenericParameterTypes();
    }

    String getName() {
	return method.getName();
    }

    OpenType getOpenReturnType() {
	return returnConverter.getOpenType();
    }

    OpenType[] getOpenParameterTypes() {
	final OpenType[] types = new OpenType[paramConverters.length];
	for (int i = 0; i < paramConverters.length; i++)
	    types[i] = paramConverters[i].getOpenType();
	return types;
    }
    
    /* Check that this method will be callable when we are going from
     * open types to Java types, for example when we are going from
     * an MXBean wrapper to the underlying resource.
     * The parameters will be converted to
     * Java types, so they must be "reconstructible".  The return
     * value will be converted to an Open Type, so if it is convertible
     * at all there is no further check needed.
     */
    void checkCallFromOpen() throws IllegalArgumentException {
        try {
            for (OpenConverter paramConverter : paramConverters)
                paramConverter.checkReconstructible();
        } catch (InvalidObjectException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* Check that this method will be callable when we are going from
     * Java types to open types, for example when we are going from
     * an MXBean proxy to the open types that it will be mapped to.
     * The return type will be converted back to a Java type, so it
     * must be "reconstructible".  The parameters will be converted to
     * open types, so if it is convertible at all there is no further
     * check needed.
     */    
    void checkCallToOpen() throws IllegalArgumentException {
        try {
            returnConverter.checkReconstructible();
        } catch (InvalidObjectException e) {
            throw new IllegalArgumentException(e);
        }
    }

    String[] getOpenSignature() {
	if (paramConverters.length == 0)
	    return noStrings;

	String[] sig = new String[paramConverters.length];
	for (int i = 0; i < paramConverters.length; i++)
	    sig[i] = paramConverters[i].getOpenClass().getName();
	return sig;
    }

    final Object toOpenReturnValue(MXBeanLookup lookup, Object ret)
            throws OpenDataException {
	return returnConverter.toOpenValue(lookup, ret);
    }

    final Object fromOpenReturnValue(MXBeanLookup lookup, Object ret)
            throws InvalidObjectException {
	return returnConverter.fromOpenValue(lookup, ret);
    }

    final Object[] toOpenParameters(MXBeanLookup lookup, Object[] params)
            throws OpenDataException {
	if (paramConversionIsIdentity || params == null)
	    return params;
	final Object[] oparams = new Object[params.length];
	for (int i = 0; i < params.length; i++)
	    oparams[i] = paramConverters[i].toOpenValue(lookup, params[i]);
	return oparams;
    }

    final Object[] fromOpenParameters(MXBeanLookup lookup, Object[] params)
            throws InvalidObjectException {
	if (paramConversionIsIdentity || params == null)
	    return params;
	final Object[] jparams = new Object[params.length];
	for (int i = 0; i < params.length; i++)
	    jparams[i] = paramConverters[i].fromOpenValue(lookup, params[i]);
	return jparams;
    }

    final Object toOpenParameter(MXBeanLookup lookup,
                                 Object param,
                                 int paramNo)
        throws OpenDataException {
        return paramConverters[paramNo].toOpenValue(lookup, param);
    }

    final Object fromOpenParameter(MXBeanLookup lookup,
                                   Object param,
                                   int paramNo)
        throws InvalidObjectException {
        return paramConverters[paramNo].fromOpenValue(lookup, param);
    }

    Object invokeWithOpenReturn(MXBeanLookup lookup,
                                Object obj, Object[] params)
	    throws MBeanException, IllegalAccessException,
                   InvocationTargetException {
	final Object[] javaParams;
	try {
	    javaParams = fromOpenParameters(lookup, params);
	} catch (InvalidObjectException e) {
	    // probably can't happen
	    final String msg = methodName() + ": cannot convert parameters " +
		"from open values: " + e;
	    throw new MBeanException(e, msg);
	}
	final Object javaReturn = method.invoke(obj, javaParams);
	try {
	    return returnConverter.toOpenValue(lookup, javaReturn);
	} catch (OpenDataException e) {
	    // probably can't happen
	    final String msg = methodName() + ": cannot convert return " +
		"value to open value: " + e;
	    throw new MBeanException(e, msg);
	}
    }

    private String methodName() {
	return method.getDeclaringClass() + "." + method.getName();
    }

    private ConvertingMethod(Method m) throws OpenDataException {
	this.method = m;
	returnConverter = OpenConverter.toConverter(m.getGenericReturnType());
	Type[] params = m.getGenericParameterTypes();
	paramConverters = new OpenConverter[params.length];
	boolean identity = true;
	for (int i = 0; i < params.length; i++) {
	    paramConverters[i] = OpenConverter.toConverter(params[i]);
	    identity &= paramConverters[i].isIdentity();
	}
	paramConversionIsIdentity = identity;
    }

    private static final OpenType[] noOpenTypes = new OpenType[0];
    private static final String[] noStrings = new String[0];

    private final Method method;
    private final OpenConverter returnConverter;
    private final OpenConverter[] paramConverters;
    private final boolean paramConversionIsIdentity;
}
