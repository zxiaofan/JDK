/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * <dl>
 *   <dt>publishEndpoint
 * </dl>
 * The {@code publishEndpoint} permission allows publishing a
 * web service endpoint using the {@code publish} methods
 * defined by the {@code javax.xml.ws.Endpoint} class.
 * <p>
 * Granting {@code publishEndpoint} allows the application to be
 * exposed as a network service. Depending on the security of the runtime and
 * the security of the application, this may introduce a security hole that
 * is remotely exploitable.
 *
 * @see javax.xml.ws.Endpoint
 * @see java.security.BasicPermission
 * @see java.security.Permission
 * @see java.security.Permissions
 * @see java.lang.SecurityManager
 * @see java.net.SocketPermission
 * @since 1.6
 */
public final class WebServicePermission extends BasicPermission {

    private static final long serialVersionUID = -146474640053770988L;

    /**
     * Creates a new permission with the specified name.
     *
     * @param name the name of the {@code WebServicePermission}
     */
    public WebServicePermission(String name) {
        super(name);
    }

    /**
     * Creates a new permission with the specified name and actions.
     *
     * The {@code actions} parameter is currently unused and
     * it should be {@code null}.
     *
     * @param name the name of the {@code WebServicePermission}
     * @param actions should be {@code null}
     */
    public WebServicePermission(String name, String actions) {
        super(name, actions);
    }

}
