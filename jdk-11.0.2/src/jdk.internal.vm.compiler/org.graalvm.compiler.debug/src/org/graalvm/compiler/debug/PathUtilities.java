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
 */


package org.graalvm.compiler.debug;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.graalvm.compiler.options.OptionKey;
import org.graalvm.compiler.options.OptionValues;

/**
 * Miscellaneous methods for modifying and generating file system paths.
 */
public class PathUtilities {

    /**
     * Gets a value based on {@code name} that can be passed to {@link Paths#get(String, String...)}
     * without causing an {@link InvalidPathException}.
     *
     * @return {@code name} with all characters invalid for the current file system replaced by
     *         {@code '_'}
     */
    public static String sanitizeFileName(String name) {
        try {
            Path path = Paths.get(name);
            if (path.getNameCount() == 0) {
                return name;
            }
        } catch (InvalidPathException e) {
            // fall through
        }
        StringBuilder buf = new StringBuilder(name.length());
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c != File.separatorChar && c != ' ' && !Character.isISOControl(c)) {
                try {
                    Paths.get(String.valueOf(c));
                    buf.append(c);
                    continue;
                } catch (InvalidPathException e) {
                }
            }
            buf.append('_');
        }
        return buf.toString();
    }

    /**
     * A maximum file name length supported by most file systems. There is no platform independent
     * way to get this in Java. Normally it is 255. But for AUFS it is 242. Refer AUFS_MAX_NAMELEN
     * in http://aufs.sourceforge.net/aufs3/man.html.
     */
    private static final int MAX_FILE_NAME_LENGTH = 242;

    private static final String ELLIPSIS = "...";

    static Path createUnique(OptionValues options, OptionKey<String> baseNameOption, String id, String label, String ext, boolean createDirectory) throws IOException {
        String uniqueTag = "";
        int dumpCounter = 1;
        String prefix;
        if (id == null) {
            prefix = baseNameOption.getValue(options);
            int slash = prefix.lastIndexOf(File.separatorChar);
            prefix = prefix.substring(slash + 1);
        } else {
            prefix = id;
        }
        for (;;) {
            int fileNameLengthWithoutLabel = uniqueTag.length() + ext.length() + prefix.length() + "[]".length();
            int labelLengthLimit = MAX_FILE_NAME_LENGTH - fileNameLengthWithoutLabel;
            String fileName;
            if (labelLengthLimit < ELLIPSIS.length()) {
                // This means `id` is very long
                String suffix = uniqueTag + ext;
                int idLengthLimit = Math.min(MAX_FILE_NAME_LENGTH - suffix.length(), prefix.length());
                fileName = sanitizeFileName(prefix.substring(0, idLengthLimit) + suffix);
            } else {
                if (label == null) {
                    fileName = sanitizeFileName(prefix + uniqueTag + ext);
                } else {
                    String adjustedLabel = label;
                    if (label.length() > labelLengthLimit) {
                        adjustedLabel = label.substring(0, labelLengthLimit - ELLIPSIS.length()) + ELLIPSIS;
                    }
                    fileName = sanitizeFileName(prefix + '[' + adjustedLabel + ']' + uniqueTag + ext);
                }
            }
            Path dumpDir = DebugOptions.getDumpDirectory(options);
            Path result = Paths.get(dumpDir.toString(), fileName);
            try {
                if (createDirectory) {
                    return Files.createDirectory(result);
                } else {
                    return Files.createFile(result);
                }
            } catch (FileAlreadyExistsException e) {
                uniqueTag = "_" + dumpCounter++;
            }
        }
    }

}
