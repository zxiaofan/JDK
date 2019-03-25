/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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

import javax.lang.model.element.ModuleElement;
import javax.lang.model.element.PackageElement;

import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.internal.doclets.toolkit.BaseConfiguration;


/**
 * Write out the element index.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Atul M Dambalkar
 */
public class ElementListWriter {

    private final BaseConfiguration configuration;
    private final Utils utils;
    private final DocFile file;

    /**
     * Constructor.
     *
     * @param configuration the current configuration of the doclet.
     */
    public ElementListWriter(BaseConfiguration configuration) {
        file = DocFile.createFileForOutput(configuration, DocPaths.ELEMENT_LIST);
        this.configuration = configuration;
        this.utils = configuration.utils;
    }

    /**
     * Generate the element index.
     *
     * @param configuration the current configuration of the doclet.
     * @throws DocFileIOException if there is a problem writing the output
     */
    public static void generate(BaseConfiguration configuration) throws DocFileIOException {
        ElementListWriter elemgen = new ElementListWriter(configuration);
        elemgen.generateElementListFile(configuration.docEnv);
    }

    protected void generateElementListFile(DocletEnvironment docEnv) throws DocFileIOException {
        try (BufferedWriter out = new BufferedWriter(file.openWriter())) {
            if (configuration.showModules) {
                for (ModuleElement mdle : configuration.modulePackages.keySet()) {
                    if (!(configuration.nodeprecated && utils.isDeprecated(mdle))) {
                        out.write(DocletConstants.MODULE_PREFIX + mdle.toString());
                        out.newLine();
                        for (PackageElement pkg : configuration.modulePackages.get(mdle)) {
                            out.write(pkg.toString());
                            out.newLine();
                        }
                    }
                }
            } else {
                for (PackageElement pkg : configuration.packages) {
                    // if the -nodeprecated option is set and the package is marked as
                    // deprecated, do not include it in the packages list.
                    if (!(configuration.nodeprecated && utils.isDeprecated(pkg))) {
                        out.write(pkg.toString());
                        out.newLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new DocFileIOException(file, DocFileIOException.Mode.WRITE, e);
        }
    }
}
