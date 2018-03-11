/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.rmi;

import java.security.*;

/**
 * A subclass of {@link SecurityManager} used by RMI applications that use
 * downloaded code.  RMI's class loader will not download any classes from
 * remote locations if no security manager has been set.
 * <code>RMISecurityManager</code> does not apply to applets, which run
 * under the protection of their browser's security manager.
 *
 * <code>RMISecurityManager</code> implements a policy that
 * is no different than the policy implemented by {@link SecurityManager}.
 * Therefore an RMI application should use the <code>SecurityManager</code>
 * class or another application-specific <code>SecurityManager</code>
 * implementation instead of this class.
 *
 * <p>To use a <code>SecurityManager</code> in your application, add
 * the following statement to your code (it needs to be executed before RMI
 * can download code from remote hosts, so it most likely needs to appear
 * in the <code>main</code> method of your application):
 *
 * <pre>
 * System.setSecurityManager(new SecurityManager());
 * </pre>
 *
 * @version %I%, %G%
 * @author  Roger Riggs
 * @author  Peter Jones
 * @since JDK1.1
 **/
public class RMISecurityManager extends SecurityManager {

    /**
     * Constructs a new <code>RMISecurityManager</code>.
     * @since JDK1.1
     */
    public RMISecurityManager() {
    }
}
