/*
 * Copyright (c) 1998, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.internal.toolkit.util;

import java.io.*;
import java.util.*;

import com.sun.javadoc.*;
import com.sun.tools.doclets.internal.toolkit.*;

/**
 * Write out the package index.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @see com.sun.javadoc.PackageDoc
 * @author Atul M Dambalkar
 */
@Deprecated
public class PackageListWriter extends PrintWriter {

    private final Configuration configuration;
    private final Utils utils;

    /**
     * Constructor.
     *
     * @param configuration the current configuration of the doclet.
     */
    public PackageListWriter(Configuration configuration) throws IOException {
        super(DocFile.createFileForOutput(configuration, DocPaths.PACKAGE_LIST).openWriter());
        this.configuration = configuration;
        this.utils = configuration.utils;
    }

    /**
     * Generate the package index.
     *
     * @param configuration the current configuration of the doclet.
     * @throws DocletAbortException
     */
    public static void generate(Configuration configuration) {
        PackageListWriter packgen;
        try {
            packgen = new PackageListWriter(configuration);
            packgen.generatePackageListFile(configuration.root);
            packgen.close();
        } catch (IOException exc) {
            configuration.message.error("doclet.exception_encountered",
                exc.toString(), DocPaths.PACKAGE_LIST);
            throw new DocletAbortException(exc);
        }
    }

    protected void generatePackageListFile(RootDoc root) {
        ArrayList<String> names = new ArrayList<>();
        for (PackageDoc pkg : configuration.packages) {
            // if the -nodeprecated option is set and the package is marked as
            // deprecated, do not include it in the packages list.
            if (!(configuration.nodeprecated && utils.isDeprecated(pkg)))
                names.add(pkg.name());
        }
        Collections.sort(names);
        for (String name : names) {
            println(name);
        }
    }
}
