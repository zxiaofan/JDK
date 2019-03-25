/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.api.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class GraalAPITest {

    @Test
    public void testRuntimeAvailable() {
        assertNotNull(Graal.getRuntime());
    }

    @Test
    public void testRuntimeNamed() {
        assertNotNull(Graal.getRuntime().getName());
    }
}
