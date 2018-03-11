/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * Use and Distribution is subject to the Java Research License available
 * at <http://wwws.sun.com/software/communitysource/jrl.html>.
 */

package com.sun.source.tree;

import java.util.List;
import javax.tools.JavaFileObject;
import com.sun.source.tree.LineMap;

/**
 * Represents the abstract syntax tree for compilation units (source
 * files) and package declarations (package-info.java).
 *
 * @see "The Java Language Specification, 3rd ed, sections 7.3, and 7.4"
 *
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public interface CompilationUnitTree extends Tree {
    List<? extends AnnotationTree> getPackageAnnotations();
    ExpressionTree getPackageName();
    List<? extends ImportTree> getImports();
    List<? extends Tree> getTypeDecls();
    JavaFileObject getSourceFile();
    
    /**
     * Gets the line map for this compilation unit, if available.
     * Returns null if the line map is not available.
     * @return the line map for this compilation unit
     */
    LineMap getLineMap();
}
