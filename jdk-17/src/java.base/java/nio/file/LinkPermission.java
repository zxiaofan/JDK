/*
 * Copyright (c) 2007, 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.nio.file;

import java.security.BasicPermission;

/**
 * The {@code Permission} class for link creation operations.
 *
 * <p> The following table provides a summary description of what the permission
 * allows, and discusses the risks of granting code the permission.
 *
 * <table class="striped">
 * <caption style="display:none">Table shows permission target name, what the permission allows, and associated risks</caption>
 * <thead>
 * <tr>
 * <th scope="col">Permission Target Name</th>
 * <th scope="col">What the Permission Allows</th>
 * <th scope="col">Risks of Allowing this Permission</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 *   <th scope="row">hard</th>
 *   <td> Ability to add an existing file to a directory. This is sometimes
 *   known as creating a link, or hard link. </td>
 *   <td> Extreme care should be taken when granting this permission. It allows
 *   linking to any file or directory in the file system thus allowing the
 *   attacker access to all files. </td>
 * </tr>
 * <tr>
 *   <th scope="row">symbolic</th>
 *   <td> Ability to create symbolic links. </td>
 *   <td> Extreme care should be taken when granting this permission. It allows
 *   linking to any file or directory in the file system thus allowing the
 *   attacker to access to all files. </td>
 * </tr>
 * </tbody>
 * </table>
 *
 * @since 1.7
 *
 * @see Files#createLink
 * @see Files#createSymbolicLink
 */
public final class LinkPermission extends BasicPermission {
    @java.io.Serial
    static final long serialVersionUID = -1441492453772213220L;

    private void checkName(String name) {
        if (!name.equals("hard") && !name.equals("symbolic")) {
            throw new IllegalArgumentException("name: " + name);
        }
    }

    /**
     * Constructs a {@code LinkPermission} with the specified name.
     *
     * @param   name
     *          the name of the permission. It must be "hard" or "symbolic".
     *
     * @throws  IllegalArgumentException
     *          if name is empty or invalid
     */
    public LinkPermission(String name) {
        super(name);
        checkName(name);
    }

    /**
     * Constructs a {@code LinkPermission} with the specified name.
     *
     * @param   name
     *          the name of the permission; must be "hard" or "symbolic".
     * @param   actions
     *          the actions for the permission; must be the empty string or
     *          {@code null}
     *
     * @throws  IllegalArgumentException
     *          if name is empty or invalid, or actions is a non-empty string
     */
    public LinkPermission(String name, String actions) {
        super(name);
        checkName(name);
        if (actions != null && !actions.isEmpty()) {
            throw new IllegalArgumentException("actions: " + actions);
        }
    }
}
