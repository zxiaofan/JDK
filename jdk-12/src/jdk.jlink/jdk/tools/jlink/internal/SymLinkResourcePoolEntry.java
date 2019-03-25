/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jlink.internal;

import jdk.tools.jlink.plugin.ResourcePoolEntry;

import java.io.InputStream;
import java.util.Objects;

/**
 * A symbolic link ResourcePoolEntry.  It will be created in the image
 * as a symbolic link to the target when the target platform supports
 * symbolic links; otherwise, it will create a file containing the
 * path to the target file.
 */
public class SymLinkResourcePoolEntry extends AbstractResourcePoolEntry {
    private final ResourcePoolEntry target;

    /**
     * Create a new SymLinkResourcePoolEntry.
     *
     * @param module The module name.
     * @param path   The path for the resource content.
     * @param type   The data type.
     * @param target Target entry in the image
     */
    public SymLinkResourcePoolEntry(String module,
                                    String path,
                                    ResourcePoolEntry.Type type,
                                    ResourcePoolEntry target) {
        super(module, path, type);
        this.target = Objects.requireNonNull(target);
    }

    @Override
    public long contentLength() {
        return target.contentLength();
    }

    @Override
    public InputStream content() {
        return target.content();
    }

    @Override
    public ResourcePoolEntry linkedTarget() {
        return target;
    }
}
