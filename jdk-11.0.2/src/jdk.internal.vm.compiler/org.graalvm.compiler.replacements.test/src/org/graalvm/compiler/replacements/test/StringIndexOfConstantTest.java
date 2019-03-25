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


package org.graalvm.compiler.replacements.test;

import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.replacements.ConstantBindingParameterPlugin;
import org.junit.Test;

import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public class StringIndexOfConstantTest extends StringIndexOfTestBase {

    /*
     * These test definitions could live in the superclass except that the mx junit individual test
     * runner can't find tests in superclasses.
     */
    @Override
    @Test
    public void testStringIndexOfConstant() {
        super.testStringIndexOfConstant();
    }

    @Override
    @Test
    public void testStringIndexOfConstantOffset() {
        super.testStringIndexOfConstantOffset();
    }

    @Override
    @Test
    public void testStringBuilderIndexOfConstant() {
        super.testStringBuilderIndexOfConstant();
    }

    @Override
    @Test
    public void testStringBuilderIndexOfConstantOffset() {
        super.testStringBuilderIndexOfConstantOffset();
    }

    Object[] constantArgs;

    @Override
    protected GraphBuilderConfiguration editGraphBuilderConfiguration(GraphBuilderConfiguration conf) {
        if (constantArgs != null) {
            ConstantBindingParameterPlugin constantBinding = new ConstantBindingParameterPlugin(constantArgs, this.getMetaAccess(), this.getSnippetReflection());
            conf.getPlugins().appendParameterPlugin(constantBinding);
        }
        return super.editGraphBuilderConfiguration(conf);
    }

    @Override
    protected Result test(OptionValues options, ResolvedJavaMethod method, Object receiver, Object... args) {
        constantArgs = new Object[args.length + 1];
        for (int i = 0; i < args.length; i++) {
            if (args[i] == constantString) {
                constantArgs[i + 1] = constantString;
            }
        }
        return super.test(options, method, receiver, args);
    }

    @Override
    protected InstalledCode getCode(final ResolvedJavaMethod installedCodeOwner, StructuredGraph graph0, boolean ignoreForceCompile, boolean ignoreInstallAsDefault, OptionValues options) {
        // Force recompile if constant binding should be done
        return super.getCode(installedCodeOwner, graph0, /* forceCompile */true, /* installAsDefault */false, options);
    }
}
