/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nio.mapmode;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * JDK-specific map modes.
 *
 * @since 14
 * @see java.nio.channels.FileChannel#map
 */
public class ExtendedMapMode {
    private ExtendedMapMode() { }

    /**
     * File mapping mode for a read-only mapping of a file backed by
     * non-volatile RAM.
     *
     * <p> The {@linkplain FileChannel#map map} method throws
     * {@linkplain UnsupportedOperationException} when this map mode
     * is used on an implementation that does not support it.
     *
     * @implNote On Linux, the {@code MAP_SYNC} and {@code
     * MAP_SHARED_VALIDATE} flags are specified to {@code mmap} when
     * mapping the file into memory.
     */
    public static final MapMode READ_ONLY_SYNC = jdk.internal.misc.ExtendedMapMode.READ_ONLY_SYNC;

    /**
     * File mapping mode for a read-write mapping of a file backed by
     * non-volatile RAM. {@linkplain MappedByteBuffer#force force}
     * operations on a buffer created with this mode will be performed
     * using cache line writeback rather than proceeding via a file
     * device flush.
     *
     * <p> The {@linkplain FileChannel#map map} method throws
     * {@linkplain UnsupportedOperationException} when this map mode
     * is used on an implementation that does not support it.
     *
     * @implNote On Linux, the {@code MAP_SYNC} and {@code
     * MAP_SHARED_VALIDATE} flags are specified to {@code mmap} when
     * mapping the file into memory.
     */
    public static final MapMode READ_WRITE_SYNC = jdk.internal.misc.ExtendedMapMode.READ_WRITE_SYNC;

}
