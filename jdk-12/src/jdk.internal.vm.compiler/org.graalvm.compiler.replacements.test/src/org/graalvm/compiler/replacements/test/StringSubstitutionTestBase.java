/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
import org.junit.Assert;
import org.junit.Assume;

import jdk.vm.ci.amd64.AMD64;
import jdk.vm.ci.aarch64.AArch64;
import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Tests compareTo method intrinsic.
 */
public class StringSubstitutionTestBase extends MethodSubstitutionTest {

    protected ResolvedJavaMethod realMethod = null;
    protected ResolvedJavaMethod testMethod = null;
    protected InstalledCode testCode = null;

    protected final String[] testData = new String[]{
                    "A", "\uFF21", "AB", "A", "a", "Ab", "AA", "\uFF21",
                    "A\uFF21", "ABC", "AB", "ABcD", "ABCD\uFF21\uFF21", "ABCD\uFF21", "ABCDEFG\uFF21", "ABCD",
                    "ABCDEFGH\uFF21\uFF21", "\uFF22", "\uFF21\uFF22", "\uFF21A",
                    "\uFF21\uFF21",
                    "\u043c\u0430\u043c\u0430\u0020\u043c\u044b\u043b\u0430\u0020\u0440\u0430\u043c\u0443\u002c\u0020\u0440\u0430\u043c\u0430\u0020\u0441\u044a\u0435\u043b\u0430\u0020\u043c\u0430\u043c\u0443",
                    "crazy dog jumps over laszy fox",
                    "some-string\0xff",
                    "XMM-XMM-YMM-YMM-ZMM-ZMM-ZMM-ZMM-",
                    "XMM-XMM+YMM-YMM-ZMM-ZMM-ZMM-ZMM-",
                    "XMM-XMM-YMM-YMM+ZMM-ZMM-ZMM-ZMM-",
                    "XMM-XMM-YMM-YMM-ZMM-ZMM-ZMM-ZMM+",
                    "XMM-XMM-XMM-XMM-YMM-YMM-YMM-YMM-ZMM-ZMM-ZMM-ZMM-ZMM-ZMM-ZMM-ZMM-",
                    "XMM-XMM-XMM-XMM+YMM-YMM-YMM-YMM-ZMM-ZMM-ZMM-ZMM-ZMM-ZMM-ZMM-ZMM-",
                    "XMM-XMM-XMM-XMM-YMM-YMM-YMM-YMM+ZMM-ZMM-ZMM-ZMM-ZMM-ZMM-ZMM-ZMM-",
                    "XMM-XMM-XMM-XMM-YMM-YMM-YMM-YMM-ZMM-ZMM-ZMM-ZMM-ZMM-ZMM-ZMM-ZMM+",
                    ""
    };

    protected void initSubstitution(ResolvedJavaMethod theRealMethod,
                    ResolvedJavaMethod theTestMethod, Class<?> expectedNode) {
        Assume.assumeTrue((getTarget().arch instanceof AMD64) || (getTarget().arch instanceof AArch64));

        realMethod = theRealMethod;
        testMethod = theTestMethod;

        StructuredGraph graph = testGraph(testMethod.getName());

        // Check to see if the resulting graph contains the expected node
        StructuredGraph replacement = getReplacements().getSubstitution(realMethod, -1, false, null);
        if (replacement == null) {
            assertInGraph(graph, expectedNode);
        }

        // Force compilation
        testCode = getCode(testMethod);
        Assert.assertNotNull(testCode);
    }

    private void executeSubstitution(String s0, String s1) {
        Object expected = invokeSafe(realMethod, s0, s1);
        // Verify that the original method and the substitution produce the same value
        assertDeepEquals(expected, invokeSafe(testMethod, null, s0, s1));
        // Verify that the generated code and the original produce the same value
        assertDeepEquals(expected, executeVarargsSafe(testCode, s0, s1));
    }

    protected void testEqualString() {
        String s = "equal-string";
        executeSubstitution(s, new String(s.toCharArray()));
    }

    protected void testDifferentString() {
        // Smoke test for primary cases
        executeSubstitution("AAAAAAAA", "");
        // LL
        executeSubstitution("some-stringA", "some-string\0xff");
        // UU
        executeSubstitution("\u2241AAAAAAAB", "\u2241\u0041\u0041\u0041\u0041\u0041\u0041\u0041\uFF41");
        // LU
        executeSubstitution("AAAAAAAAB", "\u0041\u0041\u0041\u0041\u0041\u0041\u0041\u0041\uFF41");
    }

    protected void testAllStrings() {
        for (String s0 : testData) {
            for (String s1 : testData) {
                try {
                    executeSubstitution(s0, s1);
                } catch (AssertionError ex) {
                    System.out.println("FAIL: '" + ex + "'");
                    System.out.println(" ***: s0 '" + s0 + "'");
                    System.out.println(" ***: s1 '" + s1 + "'");
                    throw ex;
                }
            }
        }
    }
}
