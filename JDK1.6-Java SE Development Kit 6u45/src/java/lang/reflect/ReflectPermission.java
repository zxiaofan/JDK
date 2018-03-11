/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang.reflect;

/**
 * The Permission class for reflective operations.  A
 * ReflectPermission is a <em>named permission</em> and has no
 * actions.  The only name currently defined is <tt>suppressAccessChecks</tt>,
 * which allows suppressing the standard Java language access checks
 * -- for public, default (package) access, protected, and private
 * members -- performed by reflected objects at their point of use.
 * <P>
 * The following table
 * provides a summary description of what the permission allows,
 * and discusses the risks of granting code the permission.
 * <P>
 *
 * <table border=1 cellpadding=5 summary="Table shows permission target name, what the permission allows, and associated risks">
 * <tr>
 * <th>Permission Target Name</th>
 * <th>What the Permission Allows</th>
 * <th>Risks of Allowing this Permission</th>
 * </tr>
 *
 * <tr>
 *   <td>suppressAccessChecks</td>
 *   <td>ability to access
 * fields and invoke methods in a class. Note that this includes
 * not only public, but protected and private fields and methods as well.</td>
 *   <td>This is dangerous in that information (possibly confidential) and
 * methods normally unavailable would be accessible to malicious code.</td>
 * </tr>
 *
 * </table>
 *
 * @see java.security.Permission
 * @see java.security.BasicPermission
 * @see AccessibleObject
 * @see Field#get
 * @see Field#set
 * @see Method#invoke
 * @see Constructor#newInstance
 *
 * @since 1.2
 */
public final
class ReflectPermission extends java.security.BasicPermission {

    private static final long serialVersionUID = 7412737110241507485L;

    /**
     * Constructs a ReflectPermission with the specified name.
     *
     * @param name the name of the ReflectPermission
     *
     * @throws NullPointerException if <code>name</code> is <code>null</code>.
     * @throws IllegalArgumentException if <code>name</code> is empty.
     */
    public ReflectPermission(String name) {
	super(name);
    }

    /**
     * Constructs a ReflectPermission with the specified name and actions.
     * The actions should be null; they are ignored.
     *
     * @param name the name of the ReflectPermission
     *
     * @param actions should be null
     *
     * @throws NullPointerException if <code>name</code> is <code>null</code>.
     * @throws IllegalArgumentException if <code>name</code> is empty.
     */
    public ReflectPermission(String name, String actions) {
	super(name, actions);
    }

}
