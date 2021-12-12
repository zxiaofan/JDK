/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.access;

import java.io.FilePermission;

public interface JavaIOFilePermissionAccess {

    /**
     * Returns a new FilePermission plus an alternative path.
     *
     * @param input the input
     * @return the new FilePermission plus the alt path (as npath2)
     *         or the input itself if no alt path is available.
     */
    FilePermission newPermPlusAltPath(FilePermission input);

    /**
     * Returns a new FilePermission using an alternative path.
     *
     * @param input the input
     * @return the new FilePermission using the alt path (as npath)
     *         or null if no alt path is available
     */
    FilePermission newPermUsingAltPath(FilePermission input);
}
