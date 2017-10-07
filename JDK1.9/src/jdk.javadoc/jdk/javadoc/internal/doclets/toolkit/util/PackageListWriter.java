/*
 * Copyright (c) 1998, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.util;

import java.io.*;

import javax.lang.model.element.PackageElement;

import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.internal.doclets.toolkit.Configuration;


/**
 * Write out the package index.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Atul M Dambalkar
 */
public class PackageListWriter {

    private final Configuration configuration;
    private final Utils utils;
    private final DocFile file;

    /**
     * Constructor.
     *
     * @param configuration the current configuration of the doclet.
     */
    public PackageListWriter(Configuration configuration) {
        file = DocFile.createFileForOutput(configuration, DocPaths.PACKAGE_LIST);
        this.configuration = configuration;
        this.utils = configuration.utils;
    }

    /**
     * Generate the package index.
     *
     * @param configuration the current configuration of the doclet.
     * @throws DocFileIOException if there is a problem writing the output
     */
    public static void generate(Configuration configuration) throws DocFileIOException {
        PackageListWriter packgen = new PackageListWriter(configuration);
        packgen.generatePackageListFile(configuration.docEnv);
    }

    protected void generatePackageListFile(DocletEnvironment docEnv) throws DocFileIOException {
        try (BufferedWriter out = new BufferedWriter(file.openWriter())) {
            for (PackageElement pkg : configuration.packages) {
                // if the -nodeprecated option is set and the package is marked as
                // deprecated, do not include it in the packages list.
                if (!(configuration.nodeprecated && utils.isDeprecated(pkg))) {
                    out.write(pkg.toString());
                    out.newLine();
                }
            }
        } catch (IOException e) {
            throw new DocFileIOException(file, DocFileIOException.Mode.WRITE, e);
        }
    }
}
