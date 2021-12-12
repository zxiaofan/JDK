/*
 * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.action;

import java.security.AccessController;

/**
 * A convenience class for retrieving the boolean value of a system property
 * as a privileged action.
 *
 * <p>An instance of this class can be used as the argument of
 * <code>AccessController.doPrivileged</code>.
 *
 * <p>The following code retrieves the boolean value of the system
 * property named <code>"prop"</code> as a privileged action:
 *
 * <pre>
 * boolean b = java.security.AccessController.doPrivileged
 *              (new GetBooleanAction("prop")).booleanValue();
 * </pre>
 *
 * @author Roland Schemers
 * @see java.security.PrivilegedAction
 * @see java.security.AccessController
 * @since 1.2
 */

public class GetBooleanAction
        implements java.security.PrivilegedAction<Boolean> {
    private String theProp;

    /**
     * Constructor that takes the name of the system property whose boolean
     * value needs to be determined.
     *
     * @param theProp the name of the system property.
     */
    public GetBooleanAction(String theProp) {
        this.theProp = theProp;
    }

    /**
     * Determines the boolean value of the system property whose name was
     * specified in the constructor.
     *
     * @return the <code>Boolean</code> value of the system property.
     */
    public Boolean run() {
        return Boolean.getBoolean(theProp);
    }

    /**
     * Convenience method to get a property without going through doPrivileged
     * if no security manager is present. This is unsafe for inclusion in a
     * public API but allowable here since this class is now encapsulated.
     *
     * Note that this method performs a privileged action using caller-provided
     * inputs. The caller of this method should take care to ensure that the
     * inputs are not tainted and the returned property is not made accessible
     * to untrusted code if it contains sensitive information.
     *
     * @param theProp the name of the system property.
     */
    @SuppressWarnings("removal")
    public static boolean privilegedGetProperty(String theProp) {
        if (System.getSecurityManager() == null) {
            return Boolean.getBoolean(theProp);
        } else {
            return AccessController.doPrivileged(
                    new GetBooleanAction(theProp));
        }
    }
}
