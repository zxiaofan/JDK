/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.tools;

import java.io.File;
import java.nio.file.Path;
import java.util.Iterator;

/**
 * Package-private utility methods to convert between files and paths.
 *
 * @since 9
 */
class FileManagerUtils {
    private FileManagerUtils() { }

    static Iterable<Path> asPaths(final Iterable<? extends File> files) {
        return () -> new Iterator<Path>() {
            Iterator<? extends File> iter = files.iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Path next() {
                return iter.next().toPath();
            }
        };
    }

    static Iterable<File> asFiles(final Iterable<? extends Path> paths) {
        return () -> new Iterator<File>() {
            Iterator<? extends Path> iter = paths.iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public File next() {
                Path p = iter.next();
                try {
                    return p.toFile();
                } catch (UnsupportedOperationException e) {
                    throw new IllegalArgumentException(p.toString(), e);
                }
            }
        };
    }
}
