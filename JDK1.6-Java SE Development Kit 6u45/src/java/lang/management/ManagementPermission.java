/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang.management;

/**
 * The permission which the SecurityManager will check when code
 * that is running with a SecurityManager calls methods defined
 * in the management interface for the Java platform.
 * <P>
 * The following table
 * provides a summary description of what the permission allows,
 * and discusses the risks of granting code the permission.
 * <P>
 *
 * <table border=1 cellpadding=5 summary="Table shows permission target name, wh
at the permission allows, and associated risks">
 * <tr>
 * <th>Permission Target Name</th>
 * <th>What the Permission Allows</th>
 * <th>Risks of Allowing this Permission</th>
 * </tr>
 *
 * <tr>
 *   <td>control</td>
 *   <td>Ability to control the runtime characteristics of the Java virtual
 *       machine, for example, setting the -verbose:gc and -verbose:class flag,
 *       setting the threshold of a memory pool, and enabling and disabling
 *       the thread contention monitoring support. 
 *   </td>
 *   <td>This allows an attacker to control the runtime characteristics
 *       of the Java virtual machine and cause the system to misbehave.
 *   </td>
 * </tr>
 * <tr>
 *   <td>monitor</td>
 *   <td>Ability to retrieve runtime information about 
 *       the Java virtual machine such as thread
 *       stack trace, a list of all loaded class names, and input arguments
 *       to the Java virtual machine.</td>
 *   <td>This allows malicious code to monitor runtime information and
 *       uncover vulnerabilities.</td>
 * </tr>
 *
 * </table>
 *
 * <p>
 * Programmers do not normally create ManagementPermission objects directly.
 * Instead they are created by the security policy code based on reading
 * the security policy file.
 *
 * @author  Mandy Chung
 * @version %I%, %G% 
 * @since   1.5
 *
 * @see java.security.BasicPermission
 * @see java.security.Permission
 * @see java.security.Permissions
 * @see java.security.PermissionCollection
 * @see java.lang.SecurityManager
 *
 */

public final class ManagementPermission extends java.security.BasicPermission {

    /**
     * Constructs a ManagementPermission with the specified name.
     *
     * @param name Permission name. Must be either "monitor" or "control".
     *
     * @throws NullPointerException if <code>name</code> is <code>null</code>.
     * @throws IllegalArgumentException if <code>name</code> is empty or invalid.
     */
    public ManagementPermission(String name) {
        super(name);
	if (!name.equals("control") && !name.equals("monitor")) {
	    throw new IllegalArgumentException("name: " + name);
	}
    }

    /**
     * Constructs a new ManagementPermission object.
     *
     * @param name Permission name. Must be either "monitor" or "control".
     * @param actions Must be either null or the empty string.
     *
     * @throws NullPointerException if <code>name</code> is <code>null</code>.
     * @throws IllegalArgumentException if <code>name</code> is empty or
     * if arguments are invalid.
     */
    public ManagementPermission(String name, String actions) 
        throws IllegalArgumentException {
        super(name);
	if (!name.equals("control") && !name.equals("monitor")) {
	    throw new IllegalArgumentException("name: " + name);
	}
	if (actions != null && actions.length() > 0) {
	    throw new IllegalArgumentException("actions: " + actions);
	}
    }
}
