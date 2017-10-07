/*
 * Copyright (c) 1998, 2006, Oracle and/or its affiliates. All rights reserved.
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
}
