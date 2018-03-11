/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.beans;

import java.lang.ref.Reference;

import java.lang.reflect.Method;

/**
 * An IndexedPropertyDescriptor describes a property that acts like an
 * array and has an indexed read and/or indexed write method to access
 * specific elements of the array.
 * <p>
 * An indexed property may also provide simple non-indexed read and write
 * methods.  If these are present, they read and write arrays of the type
 * returned by the indexed read method.
 */

public class IndexedPropertyDescriptor extends PropertyDescriptor {

    private Reference indexedPropertyTypeRef;
    private Reference indexedReadMethodRef;
    private Reference indexedWriteMethodRef;

    private String indexedReadMethodName;
    private String indexedWriteMethodName;

    /**
     * This constructor constructs an IndexedPropertyDescriptor for a property
     * that follows the standard Java conventions by having getFoo and setFoo 
     * accessor methods, for both indexed access and array access.
     * <p>
     * Thus if the argument name is "fred", it will assume that there
     * is an indexed reader method "getFred", a non-indexed (array) reader
     * method also called "getFred", an indexed writer method "setFred",
     * and finally a non-indexed writer method "setFred".
     *
     * @param propertyName The programmatic name of the property.
     * @param beanClass The Class object for the target bean.
     * @exception IntrospectionException if an exception occurs during
     *              introspection.
     */
    public IndexedPropertyDescriptor(String propertyName, Class<?> beanClass)
		throws IntrospectionException {
	this(propertyName, beanClass,
			 "get" + capitalize(propertyName),
			 "set" + capitalize(propertyName),
			 "get" + capitalize(propertyName),
			 "set" + capitalize(propertyName));
    }

    /**
     * This constructor takes the name of a simple property, and method
     * names for reading and writing the property, both indexed
     * and non-indexed.
     *
     * @param propertyName The programmatic name of the property.
     * @param beanClass  The Class object for the target bean.
     * @param readMethodName The name of the method used for reading the property
     *		 values as an array.  May be null if the property is write-only
     *		 or must be indexed.
     * @param writeMethodName The name of the method used for writing the property
     *		 values as an array.  May be null if the property is read-only
     *		 or must be indexed.
     * @param indexedReadMethodName The name of the method used for reading
     *		an indexed property value.
     *		May be null if the property is write-only.
     * @param indexedWriteMethodName The name of the method used for writing
     *		an indexed property value.  
     *		May be null if the property is read-only.
     * @exception IntrospectionException if an exception occurs during
     *              introspection.
     */
    public IndexedPropertyDescriptor(String propertyName, Class<?> beanClass,
		String readMethodName, String writeMethodName,
		String indexedReadMethodName, String indexedWriteMethodName)
		throws IntrospectionException {
	super(propertyName, beanClass, readMethodName, writeMethodName);

	this.indexedReadMethodName = indexedReadMethodName;
	if (indexedReadMethodName != null && getIndexedReadMethod() == null) {
	    throw new IntrospectionException("Method not found: " + indexedReadMethodName);
	}

	this.indexedWriteMethodName = indexedWriteMethodName;
	if (indexedWriteMethodName != null && getIndexedWriteMethod() == null) {
	    throw new IntrospectionException("Method not found: " + indexedWriteMethodName);
	}
	// Implemented only for type checking.
	findIndexedPropertyType(getIndexedReadMethod(), getIndexedWriteMethod());
    }

    /**
     * This constructor takes the name of a simple property, and Method
     * objects for reading and writing the property.
     *
     * @param propertyName The programmatic name of the pro
perty.
     * @param readMethod The method used for reading the property values as an array.
     *		May be null if the property is write-only or must be indexed.
     * @param writeMethod The method used for writing the property values as an array.
     *		May be null if the property is read-only or must be indexed.
     * @param indexedReadMethod The method used for reading an indexed property value.
     *		May be null if the property is write-only.
     * @param indexedWriteMethod The method used for writing an indexed property value.  
     *		May be null if the property is read-only.
     * @exception IntrospectionException if an exception occurs during
     *              introspection.
     */
    public IndexedPropertyDescriptor(String propertyName, Method readMethod, Method writeMethod,
 					    Method indexedReadMethod, Method indexedWriteMethod)
		throws IntrospectionException {
	super(propertyName, readMethod, writeMethod);

	setIndexedReadMethod0(indexedReadMethod);
	setIndexedWriteMethod0(indexedWriteMethod);

	// Type checking
	setIndexedPropertyType(findIndexedPropertyType(indexedReadMethod, indexedWriteMethod));
    }
    
    /**
     * Gets the method that should be used to read an indexed
     * property value.
     *
     * @return The method that should be used to read an indexed
     * property value.
     * May return null if the property isn't indexed or is write-only.
     */
    public synchronized Method getIndexedReadMethod() {
	Method indexedReadMethod = getIndexedReadMethod0();
	if (indexedReadMethod == null) {
	    Class cls = getClass0();
	    if (cls == null || 
		(indexedReadMethodName == null && indexedReadMethodRef == null)) {
		// the Indexed readMethod was explicitly set to null.
		return null;
	    }
	    if (indexedReadMethodName == null) {
		Class type = getIndexedPropertyType0();
		if (type == boolean.class || type == null) {
		    indexedReadMethodName = "is" + getBaseName();
		} else {
		    indexedReadMethodName = "get" + getBaseName();
		}
	    }
	    
	    Class[] args = { int.class };
	    
	    indexedReadMethod = Introspector.findMethod(cls, indexedReadMethodName, 
							1, args);
	    if (indexedReadMethod == null) {
		// no "is" method, so look for a "get" method.
		indexedReadMethodName = "get" + getBaseName();
		indexedReadMethod = Introspector.findMethod(cls, indexedReadMethodName, 
							    1, args);
	    }
	    setIndexedReadMethod0(indexedReadMethod);
	}
	return indexedReadMethod;
    }

    /**
     * Sets the method that should be used to read an indexed property value.
     *
     * @param readMethod The new indexed read method.
     */
    public synchronized void setIndexedReadMethod(Method readMethod) 
	throws IntrospectionException {

	// the indexed property type is set by the reader.
	setIndexedPropertyType(findIndexedPropertyType(readMethod, 
						       getIndexedWriteMethod0()));
	setIndexedReadMethod0(readMethod);
    }

    private void setIndexedReadMethod0(Method readMethod) {
	if (readMethod == null) {
	    indexedReadMethodName = null;
	    indexedReadMethodRef = null;
	    return;
	}
	setClass0(readMethod.getDeclaringClass());

	indexedReadMethodName = readMethod.getName();
	indexedReadMethodRef = createReference(readMethod);
    }


    /**
     * Gets the method that should be used to write an indexed property value.
     *
     * @return The method that should be used to write an indexed
     * property value.
     * May return null if the property isn't indexed or is read-only.
     */
    public synchronized Method getIndexedWriteMethod() {
	Method indexedWriteMethod = getIndexedWriteMethod0();
	if (indexedWriteMethod == null) {
	    Class cls = getClass0();
	    if (cls == null || 
		(indexedWriteMethodName == null && indexedWriteMethodRef == null)) {
		// the Indexed writeMethod was explicitly set to null.
		return null;
	    }

	    // We need the indexed type to ensure that we get the correct method.
	    // Cannot use the getIndexedPropertyType method since that could 
	    // result in an infinite loop.
	    Class type = getIndexedPropertyType0();
	    if (type == null) {
		try {
		    type = findIndexedPropertyType(getIndexedReadMethod(), null);
		    setIndexedPropertyType(type);
		} catch (IntrospectionException ex) {
		    // Set iprop type to be the classic type
		    Class propType = getPropertyType();
		    if (propType.isArray()) {
			type = propType.getComponentType();
		    }
		}
	    }
		
	    if (indexedWriteMethodName == null) {
		indexedWriteMethodName = "set" + getBaseName();
	    }
	    indexedWriteMethod = Introspector.findMethod(cls, indexedWriteMethodName, 
			 2, (type == null) ? null : new Class[] { int.class, type });
	    setIndexedWriteMethod0(indexedWriteMethod);
	}
	return indexedWriteMethod;
    }

    /**
     * Sets the method that should be used to write an indexed property value.
     *
     * @param writeMethod The new indexed write method.
     */
    public synchronized void setIndexedWriteMethod(Method writeMethod) 
	throws IntrospectionException {

	// If the indexed property type has not been set, then set it.
	Class type = findIndexedPropertyType(getIndexedReadMethod(), 
					     writeMethod);
	setIndexedPropertyType(type);
	setIndexedWriteMethod0(writeMethod);
    }

    private void setIndexedWriteMethod0(Method writeMethod) {
	if (writeMethod == null) {
	    indexedWriteMethodName = null;
	    indexedWriteMethodRef = null;
	    return;
	}
	setClass0(writeMethod.getDeclaringClass());

	indexedWriteMethodName = writeMethod.getName();
	indexedWriteMethodRef = createReference(writeMethod);
    }

    /**
     * Gets the <code>Class</code> object of the indexed properties' type.
     * The returned <code>Class</code> may describe a primitive type such as <code>int</code>.
     *
     * @return The <code>Class</code> for the indexed properties' type; may return <code>null</code>
     *         if the type cannot be determined.
     */
    public synchronized Class<?> getIndexedPropertyType() {
	Class type = getIndexedPropertyType0();
	if (type == null) {
	    try {
		type = findIndexedPropertyType(getIndexedReadMethod(), 
					       getIndexedWriteMethod());
		setIndexedPropertyType(type);
	    } catch (IntrospectionException ex) {
		// fall
	    }
	}
	return type;
    }

    // Private methods which set get/set the Reference objects

    private void setIndexedPropertyType(Class type) {
	indexedPropertyTypeRef = createReference(type);
    }

    private Class getIndexedPropertyType0() {
	return (Class)getObject(indexedPropertyTypeRef);
    }

    private Method getIndexedReadMethod0() {
	return (Method)getObject(indexedReadMethodRef);
    }

    private Method getIndexedWriteMethod0() {
	return (Method)getObject(indexedWriteMethodRef);
    }

    private Class findIndexedPropertyType(Method indexedReadMethod,
					  Method indexedWriteMethod) 
	throws IntrospectionException {
	Class indexedPropertyType = null;

	if (indexedReadMethod != null) {
	    Class params[] = indexedReadMethod.getParameterTypes();
	    if (params.length != 1) {
		throw new IntrospectionException("bad indexed read method arg count");
	    }
	    if (params[0] != Integer.TYPE) {
		throw new IntrospectionException("non int index to indexed read method");
	    }
	    indexedPropertyType = indexedReadMethod.getReturnType();
	    if (indexedPropertyType == Void.TYPE) {
		throw new IntrospectionException("indexed read method returns void");
	    }
	}
	if (indexedWriteMethod != null) {
	    Class params[] = indexedWriteMethod.getParameterTypes();
	    if (params.length != 2) {
		throw new IntrospectionException("bad indexed write method arg count");
	    }
	    if (params[0] != Integer.TYPE) {
		throw new IntrospectionException("non int index to indexed write method");
	    }
	    if (indexedPropertyType != null && indexedPropertyType != params[1]) {
		throw new IntrospectionException(
						 "type mismatch between indexed read and indexed write methods: " 
						 + getName());
	    }
	    indexedPropertyType = params[1];
	}
	Class propertyType = getPropertyType();
	if (propertyType != null && (!propertyType.isArray() ||
				     propertyType.getComponentType() != indexedPropertyType)) {
	    throw new IntrospectionException("type mismatch between indexed and non-indexed methods: " 
					     + getName());
	}
	return indexedPropertyType;
    }

    /**
     * Compares this <code>PropertyDescriptor</code> against the specified object.
     * Returns true if the objects are the same. Two <code>PropertyDescriptor</code>s
     * are the same if the read, write, property types, property editor and
     * flags  are equivalent.
     *
     * @since 1.4
     */
    public boolean equals(Object obj) {
	// Note: This would be identical to PropertyDescriptor but they don't
	// share the same fields.
	if (this == obj) {
	    return true;
	}

	if (obj != null && obj instanceof IndexedPropertyDescriptor) {
	    IndexedPropertyDescriptor other = (IndexedPropertyDescriptor)obj;
	    Method otherIndexedReadMethod = other.getIndexedReadMethod();
	    Method otherIndexedWriteMethod = other.getIndexedWriteMethod();

	    if (!compareMethods(getIndexedReadMethod(), otherIndexedReadMethod)) {
		return false;
	    }

	    if (!compareMethods(getIndexedWriteMethod(), otherIndexedWriteMethod)) {
		return false;
	    }

	    if (getIndexedPropertyType() != other.getIndexedPropertyType()) {
		return false;
	    }
	    return super.equals(obj);
	}
	return false;
    }

    /**
     * Package-private constructor.
     * Merge two property descriptors.  Where they conflict, give the
     * second argument (y) priority over the first argumnnt (x).
     *
     * @param x  The first (lower priority) PropertyDescriptor
     * @param y  The second (higher priority) PropertyDescriptor
     */

    IndexedPropertyDescriptor(PropertyDescriptor x, PropertyDescriptor y) {
	super(x,y);
	if (x instanceof IndexedPropertyDescriptor) {
	    IndexedPropertyDescriptor ix = (IndexedPropertyDescriptor)x;
	    try {
		Method xr = ix.getIndexedReadMethod();
		if (xr != null) {
		    setIndexedReadMethod(xr);
		}
		
		Method xw = ix.getIndexedWriteMethod();
		if (xw != null) {
		    setIndexedWriteMethod(xw);
		}
	    } catch (IntrospectionException ex) {
		// Should not happen
		throw new AssertionError(ex);
	    }
	}
	if (y instanceof IndexedPropertyDescriptor) {
	    IndexedPropertyDescriptor iy = (IndexedPropertyDescriptor)y;
	    try {
		Method yr = iy.getIndexedReadMethod();
		if (yr != null && yr.getDeclaringClass() == getClass0()) {
		    setIndexedReadMethod(yr);
		}
		
		Method yw = iy.getIndexedWriteMethod();
		if (yw != null && yw.getDeclaringClass() == getClass0()) {
		    setIndexedWriteMethod(yw);
		}
	    } catch (IntrospectionException ex) {
		// Should not happen
		throw new AssertionError(ex);
	    }
	}
    }

    /*
     * Package-private dup constructor
     * This must isolate the new object from any changes to the old object.
     */
    IndexedPropertyDescriptor(IndexedPropertyDescriptor old) {
	super(old);
	indexedReadMethodRef = old.indexedReadMethodRef;
	indexedWriteMethodRef = old.indexedWriteMethodRef;
	indexedPropertyTypeRef = old.indexedPropertyTypeRef;
	indexedWriteMethodName = old.indexedWriteMethodName;
	indexedReadMethodName = old.indexedReadMethodName;
    }

    /**
     * Returns a hash code value for the object. 
     * See {@link java.lang.Object#hashCode} for a complete description.
     *
     * @return a hash code value for this object.
     * @since 1.5
     */
    public int hashCode() {
	int result = super.hashCode();

	result = 37 * result + ((indexedWriteMethodName == null) ? 0 : 
				indexedWriteMethodName.hashCode());
	result = 37 * result + ((indexedReadMethodName == null) ? 0 : 
				indexedReadMethodName.hashCode());
	result = 37 * result + ((getIndexedPropertyType() == null) ? 0 : 
				getIndexedPropertyType().hashCode());
	
	return result;
    }

    /*
    public String toString() {
	String message = super.toString();

	message += ", indexedType=";
	message += getIndexedPropertyType();

	message += ", indexedWriteMethod=";
	message += indexedWriteMethodName;

	message += ", indexedReadMethod=";
	message += indexedReadMethodName;
	
	return message;
    }
    */
}
