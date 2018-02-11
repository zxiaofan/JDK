/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.org.jvnet.mimepull;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Configuration for MIME message parsing and storing.
 *
 * @author Jitendra Kotamraju
 */
public class MIMEConfig {

    private static final int DEFAULT_CHUNK_SIZE = 8192;
    private static final long DEFAULT_MEMORY_THRESHOLD = 1048576L;
    private static final String DEFAULT_FILE_PREFIX = "MIME";

    private static final Logger LOGGER = Logger.getLogger(MIMEConfig.class.getName());

    // Parses the entire message eagerly
    boolean parseEagerly;

    // Approximate Chunk size
    int chunkSize;

    // Maximum in-memory data per attachment
    long memoryThreshold;

    // temp Dir to store large files
    File tempDir;
    String prefix;
    String suffix;

    private MIMEConfig(boolean parseEagerly, int chunkSize,
                       long inMemoryThreshold, String dir, String prefix, String suffix) {
        this.parseEagerly = parseEagerly;
        this.chunkSize = chunkSize;
        this.memoryThreshold = inMemoryThreshold;
        this.prefix = prefix;
        this.suffix = suffix;
        setDir(dir);
    }

    public MIMEConfig() {
        this(false, DEFAULT_CHUNK_SIZE, DEFAULT_MEMORY_THRESHOLD, null,
                DEFAULT_FILE_PREFIX, null);
    }

    boolean isParseEagerly() {
        return parseEagerly;
    }

    public void setParseEagerly(boolean parseEagerly) {
        this.parseEagerly = parseEagerly;
    }

    int getChunkSize() {
        return chunkSize;
    }

    void setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    long getMemoryThreshold() {
        return memoryThreshold;
    }

    /**
     * If the attachment is greater than the threshold, it is
     * written to the disk.
     *
     * @param memoryThreshold no of bytes per attachment
     *        if -1, then the whole attachment is kept in memory
     */
    public void setMemoryThreshold(long memoryThreshold) {
        this.memoryThreshold = memoryThreshold;
    }

    boolean isOnlyMemory() {
        return memoryThreshold == -1L;
    }

    File getTempDir() {
        return tempDir;
    }

    String getTempFilePrefix() {
        return prefix;
    }

    String getTempFileSuffix() {
        return suffix;
    }

    /**
     * @param directory
     *          temp directory
     */
    public final void setDir(String directory) {
        if (tempDir == null && directory != null && !directory.equals("")) {
            tempDir = new File(directory);
        }
    }

    /**
     * Validates if it can create temporary files. Otherwise, it stores
     * attachment contents in memory.
     */
    public void validate() {
        if (!isOnlyMemory()) {
            try {
                File tempFile = (tempDir == null)
                        ? File.createTempFile(prefix, suffix)
                        : File.createTempFile(prefix, suffix, tempDir);
                boolean deleted = tempFile.delete();
                if (!deleted) {
                    if (LOGGER.isLoggable(Level.INFO)) {
                        LOGGER.log(Level.INFO, "File {0} was not deleted", tempFile.getAbsolutePath());
                    }
                }
            } catch(RuntimeException e) {
                memoryThreshold = -1L;      // whole attachment will be in-memory
            } catch(Exception e) {
                memoryThreshold = -1L;      // whole attachment will be in-memory
            }
        }
    }

}
