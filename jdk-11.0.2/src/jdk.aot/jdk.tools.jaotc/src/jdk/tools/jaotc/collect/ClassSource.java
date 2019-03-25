/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 */

package jdk.tools.jaotc.collect;

import java.nio.file.Path;
import java.util.function.BiConsumer;

public interface ClassSource {
    static boolean pathIsClassFile(Path entry) {
        String fileName = entry.getFileName().toString();
        return fileName.endsWith(".class") && !fileName.endsWith("module-info.class");
    }

    static String stripRoot(Path path) {
        if (path.getRoot() != null) {
            String root = path.getRoot().toString();
            String filename = path.toString().substring(root.length());
            String separator = path.getFileSystem().getSeparator();
            while (filename.startsWith(separator)) {
                filename = filename.substring(separator.length());
            }
            return filename;
        }

        return path.toString();
    }

    static String makeClassName(Path path) {
        String fileName = path.toString();

        if (!fileName.endsWith(".class")) {
            throw new IllegalArgumentException("File doesn't end with .class: '" + fileName + "'");
        }

        fileName = stripRoot(path);

        String className = fileName.substring(0, fileName.length() - ".class".length());
        className = className.replace(path.getFileSystem().getSeparator(), ".");
        return className;
    }

    void eachClass(BiConsumer<String, ClassLoader> consumer);
}
