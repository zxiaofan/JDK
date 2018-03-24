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
 *
 *
 */

package jdk.nashorn.tools.jjs;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import jdk.nashorn.internal.runtime.Context;

/**
 * A java packages helper that uses jrt file system.
 */
final class JrtPackagesHelper extends PackagesHelper {
    private final FileSystem jrtfs;

    /**
     * Construct a new JrtPackagesHelper.
     *
     * @param context the current Nashorn Context
     */
    JrtPackagesHelper(final Context context) throws IOException {
        super(context);
        jrtfs = FileSystems.getFileSystem(URI.create("jrt:/"));
    }

    @Override
    void close() throws IOException {
    }

    @Override
    Set<String> listPackage(final String pkg) throws IOException {
        final Set<String> props = new HashSet<>();
        // look for the /packages/<package_name> directory
        Path pkgDir = jrtfs.getPath("/packages/" + pkg);
        if (Files.exists(pkgDir)) {
            String pkgSlashName = pkg.replace('.', '/');
            try (DirectoryStream<Path> ds = Files.newDirectoryStream(pkgDir)) {
                // it has module links under which this package occurs
                for (Path mod : ds) {
                    // get the package directory under /modules
                    Path pkgUnderMod = jrtfs.getPath(mod.toString() + "/" + pkgSlashName);
                    try (DirectoryStream<Path> ds2 = Files.newDirectoryStream(pkgUnderMod)) {
                        for (Path p : ds2) {
                            String str = p.getFileName().toString();
                            // get rid of ".class", if any
                            if (str.endsWith(".class")) {
                                final String clsName = str.substring(0, str.length() - ".class".length());
                                if (clsName.indexOf('$') == -1 && isClassAccessible(pkg + "." + clsName)) {
                                    props.add(str);
                                }
                            } else if (isPackageAccessible(pkg + "." + str)) {
                                props.add(str);
                            }
                        }
                    }
                }
            }
        }
        return props;
    }
}
