/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.test;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.replacements.ReplacementsImpl;
import org.graalvm.compiler.replacements.classfile.ClassfileBytecodeProvider;

import jdk.vm.ci.meta.MetaAccessProvider;

public abstract class ReplacementsTest extends GraalCompilerTest {

    /**
     * Gets a {@link ClassfileBytecodeProvider} that enables snippets and intrinsics to be loaded
     * from the system class path (instead of from the JVMCI class path or Graal module).
     */
    protected final ClassfileBytecodeProvider getSystemClassLoaderBytecodeProvider() {
        ReplacementsImpl d = (ReplacementsImpl) getReplacements();
        MetaAccessProvider metaAccess = d.providers.getMetaAccess();
        ClassfileBytecodeProvider bytecodeProvider = new ClassfileBytecodeProvider(metaAccess, d.snippetReflection, ClassLoader.getSystemClassLoader());
        return bytecodeProvider;
    }

}
