/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang.reflect;

import java.security.AccessController;
import sun.reflect.ReflectionFactory;
import java.lang.annotation.Annotation;

/**
 * The AccessibleObject class is the base class for Field, Method and
 * Constructor objects.  It provides the ability to flag a reflected
 * object as suppressing default Java language access control checks
 * when it is used.  The access checks--for public, default (package)
 * access, protected, and private members--are performed when Fields,
 * Methods or Constructors are used to set or get fields, to invoke
 * methods, or to create and initialize new instances of classes,
 * respectively.
 *
 * <p>Setting the <tt>accessible</tt> flag in a reflected object
 * permits sophisticated applications with sufficient privilege, such
 * as Java Object Serialization or other persistence mechanisms, to
 * manipulate objects in a manner that would normally be prohibited.
 *
 * @see Field
 * @see Method
 * @see Constructor
 * @see ReflectPermission
 *
 * @since 1.2
 */
public class AccessibleObject implements AnnotatedElement {

    /**
     * The Permission object that is used to check whether a client
     * has sufficient privilege to defeat Java language access
     * control checks.
     */
    static final private java.security.Permission ACCESS_PERMISSION =
	new ReflectPermission("suppressAccessChecks");

    /**
     * Convenience method to set the <tt>accessible</tt> flag for an
     * array of objects with a single security check (for efficiency).
     *
     * <p>First, if there is a security manager, its
     * <code>checkPermission</code> method is called with a
     * <code>ReflectPermission("suppressAccessChecks")</code> permission.
     *
     * <p>A <code>SecurityException</code> is raised if <code>flag</code> is
     * <code>true</code> but accessibility of any of the elements of the input
     * <code>array</code> may not be changed (for example, if the element
     * object is a {@link Constructor} object for the class {@link
     * java.lang.Class}).  In the event of such a SecurityException, the
     * accessibility of objects is set to <code>flag</code> for array elements
     * upto (and excluding) the element for which the exception occurred; the
     * accessibility of elements beyond (and including) the element for which
     * the exception occurred is unchanged.
     *
     * @param array the array of AccessibleObjects
     * @param flag  the new value for the <tt>accessible</tt> flag
     *              in each object
     * @throws SecurityException if the request is denied.
     * @see SecurityManager#checkPermission
     * @see java.lang.RuntimePermission
     */
    public static void setAccessible(AccessibleObject[] array, boolean flag)
	throws SecurityException {
	SecurityManager sm = System.getSecurityManager();
	if (sm != null) sm.checkPermission(ACCESS_PERMISSION);
	for (int i = 0; i < array.length; i++) {
	    setAccessible0(array[i], flag);
	}
    }

    /**
     * Set the <tt>accessible</tt> flag for this object to
     * the indicated boolean value.  A value of <tt>true</tt> indicates that
     * the reflected object should suppress Java language access
     * checking when it is used.  A value of <tt>false</tt> indicates 
     * that the reflected object should enforce Java language access checks.
     *
     * <p>First, if there is a security manager, its
     * <code>checkPermission</code> method is called with a
     * <code>ReflectPermission("suppressAccessChecks")</code> permission.
     * 
     * <p>A <code>SecurityException</code> is raised if <code>flag</code> is
     * <code>true</code> but accessibility of this object may not be changed
     * (for example, if this element object is a {@link Constructor} object for
     * the class {@link java.lang.Class}).
     *
     * <p>A <code>SecurityException</code> is raised if this object is a {@link
     * java.lang.reflect.Constructor} object for the class
     * <code>java.lang.Class</code>, and <code>flag</code> is true.
     *
     * @param flag the new value for the <tt>accessible</tt> flag
     * @throws SecurityException if the request is denied.
     * @see SecurityManager#checkPermission
     * @see java.lang.RuntimePermission
     */
    public void setAccessible(boolean flag) throws SecurityException {
	SecurityManager sm = System.getSecurityManager();
	if (sm != null) sm.checkPermission(ACCESS_PERMISSION);
	setAccessible0(this, flag);
    }

    /* Check that you aren't exposing java.lang.Class.<init>. */
    private static void setAccessible0(AccessibleObject obj, boolean flag)
	throws SecurityException
    {
	if (obj instanceof Constructor && flag == true) {
	    Constructor c = (Constructor)obj;
	    if (c.getDeclaringClass() == Class.class) {
		throw new SecurityException("Can not make a java.lang.Class" +
					    " constructor accessible");
	    }
	}
	obj.override = flag;
    }

    /**
     * Get the value of the <tt>accessible</tt> flag for this object.
     *
     * @return the value of the object's <tt>accessible</tt> flag
     */
    public boolean isAccessible() {
	return override;
    }

    /**
     * Constructor: only used by the Java Virtual Machine.
     */
    protected AccessibleObject() {}

    // Indicates whether language-level access checks are overridden
    // by this object. Initializes to "false". This field is used by
    // Field, Method, and Constructor.
    //
    // NOTE: for security purposes, this field must not be visible
    // outside this package.
    boolean override;

    // Reflection factory used by subclasses for creating field,
    // method, and constructor accessors. Note that this is called
    // very early in the bootstrapping process.
    static final ReflectionFactory reflectionFactory = (ReflectionFactory)
        AccessController.doPrivileged
            (new sun.reflect.ReflectionFactory.GetReflectionFactoryAction());

    /**
     * @throws NullPointerException {@inheritDoc}
     * @since 1.5
     */
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        throw new AssertionError("All subclasses should override this method");
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     * @since 1.5
     */
    public boolean isAnnotationPresent(
        Class<? extends Annotation> annotationClass) {
        return getAnnotation(annotationClass) != null;
    }

    /**
     * @since 1.5
     */
    public Annotation[] getAnnotations() { 
        return getDeclaredAnnotations();
    }

    /**
     * @since 1.5
     */
    public Annotation[] getDeclaredAnnotations()  {
        throw new AssertionError("All subclasses should override this method");
    }
}
