/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.xml.ws;

import java.security.BasicPermission;

/**
 * This class defines web service permissions.
 * <p>
 * Web service Permissions are identified by name (also referred to as
 * a "target name") alone. There are no actions associated
 * with them.
 * <p>
 * The following permission target name is defined:
 * <p>
 * <dl>
 *   <dt>publishEndpoint
 * </dl>
 * <p>
 * The <code>publishEndpoint</code> permission allows publishing a
 * web service endpoint using the <code>publish</code> methods
 * defined by the <code>javax.xml.ws.Endpoint</code> class.
 *
 * @see javax.xml.ws.Endpoint
 * @see java.security.BasicPermission
 * @see java.security.Permission
 * @see java.security.Permissions
 * @see java.lang.SecurityManager
 */
public final class WebServicePermission extends BasicPermission {

    private static final long serialVersionUID = -146474640053770988L;

    /**
     * Creates a new permission with the specified name.
     *
     * @param name the name of the <code>WebServicePermission</code>
     */
    public WebServicePermission(String name) {
        super(name);
    }

    /**
     * Creates a new permission with the specified name and actions.
     *
     * The <code>actions</code> parameter is currently unused and
     * it should be <code>null</code>.
     *
     * @param name the name of the <code>WebServicePermission</code>
     * @param actions should be <code>null</code>
     */
    public WebServicePermission(String name, String actions) {
        super(name, actions);
    }

}
