/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.code;

import jdk.vm.ci.code.CodeCacheProvider;
import jdk.vm.ci.code.InstalledCode;

/**
 * Interface providing capability for disassembling machine code.
 */
public interface DisassemblerProvider {

    /**
     * Gets a textual disassembly of a given compilation result.
     *
     * @param codeCache the object used for code {@link CodeCacheProvider#addCode code installation}
     * @param compResult a compilation result
     * @return a non-zero length string containing a disassembly of {@code compResult} or null it
     *         could not be disassembled
     */
    default String disassembleCompiledCode(CodeCacheProvider codeCache, CompilationResult compResult) {
        return null;
    }

    /**
     * Gets a textual disassembly of a given installed code.
     *
     * @param codeCache the object used for code {@link CodeCacheProvider#addCode code installation}
     * @param compResult a compiled code that was installed to produce {@code installedCode}. This
     *            will be null if not available.
     * @param installedCode
     * @return a non-zero length string containing a disassembly of {@code installedCode} or null if
     *         {@code installedCode} is {@link InstalledCode#isValid() invalid} or it could not be
     *         disassembled for some other reason
     */
    default String disassembleInstalledCode(CodeCacheProvider codeCache, CompilationResult compResult, InstalledCode installedCode) {
        return null;
    }

    /**
     * Gets the name denoting the format of the disassembly returned by this object.
     */
    String getName();
}
