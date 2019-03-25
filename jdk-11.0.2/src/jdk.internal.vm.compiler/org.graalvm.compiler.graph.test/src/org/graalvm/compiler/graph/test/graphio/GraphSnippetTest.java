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
 */


package org.graalvm.compiler.graph.test.graphio;

import java.io.File;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import org.junit.Assume;
import org.junit.Test;

public class GraphSnippetTest {
    @Test
    public void dumpTheFile() throws Exception {
        Class<?> snippets = null;
        try {
            snippets = Class.forName("org.graalvm.graphio.GraphSnippets");
        } catch (ClassNotFoundException notFound) {
            Assume.assumeNoException("The snippets class has to be around", notFound);
        }
        Method dump = null;
        try {
            dump = snippets.getDeclaredMethod("dump", File.class);
            dump.setAccessible(true);
        } catch (RuntimeException ex) {
            Assume.assumeTrue("Only run the test, if the method is accessible", dump != null && dump.isAccessible());
        }
        File diamond = File.createTempFile("diamond", ".bgv");
        dump.invoke(null, diamond);
        assertTrue("File .bgv created: " + diamond, diamond.length() > 50);
    }
}
