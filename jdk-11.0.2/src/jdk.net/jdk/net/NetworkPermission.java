/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.net;

import java.security.BasicPermission;

/**
 * Represents permission to access the extended networking capabilities
 * defined in the jdk.net package. These permissions contain a target
 * name, but no actions list. Callers either possess the permission or not.
 * <p>
 * The following targets are defined:
 *
 * <table class="striped"><caption style="display:none">permission target name,
 *  what the target allows,and associated risks</caption>
 * <thead>
 * <tr>
 *   <th scope="col">Permission Target Name</th>
 *   <th scope="col">What the Permission Allows</th>
 *   <th scope="col">Risks of Allowing this Permission</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 *   <th scope="row">setOption.SO_FLOW_SLA</th>
 *   <td>set the {@link ExtendedSocketOptions#SO_FLOW_SLA SO_FLOW_SLA} option
 *       on any socket that supports it</td>
 *   <td>allows caller to set a higher priority or bandwidth allocation
 *       to sockets it creates, than they might otherwise be allowed.</td>
 * </tr>
 * <tr>
 *   <th scope="row">getOption.SO_FLOW_SLA</th>
 *   <td>retrieve the {@link ExtendedSocketOptions#SO_FLOW_SLA SO_FLOW_SLA}
 *       setting from any socket that supports the option</td>
 *   <td>allows caller access to SLA information that it might not
 *       otherwise have</td>
 * </tr>
 * </tbody>
 * </table>
 *
 * @see jdk.net.ExtendedSocketOptions
 *
 * @since 1.8
 */

public final class NetworkPermission extends BasicPermission {

    private static final long serialVersionUID = -2012939586906722291L;

    /**
     * Creates a NetworkPermission with the given target name.
     *
     * @param name the permission target name
     * @throws NullPointerException if {@code name} is {@code null}.
     * @throws IllegalArgumentException if {@code name} is empty.
     */
    public NetworkPermission(String name)
    {
        super(name);
    }

    /**
     * Creates a NetworkPermission with the given target name.
     *
     * @param name the permission target name
     * @param actions should be {@code null}. Is ignored if not.
     * @throws NullPointerException if {@code name} is {@code null}.
     * @throws IllegalArgumentException if {@code name} is empty.
     */
    public NetworkPermission(String name, String actions)
    {
        super(name, actions);
    }
}
