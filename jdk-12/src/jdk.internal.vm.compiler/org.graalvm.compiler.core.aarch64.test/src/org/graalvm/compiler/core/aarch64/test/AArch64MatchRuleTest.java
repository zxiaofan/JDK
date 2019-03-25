/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018, Arm Limited and affiliates. All rights reserved.
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



package org.graalvm.compiler.core.aarch64.test;

import jdk.vm.ci.aarch64.AArch64;
import org.graalvm.compiler.core.test.MatchRuleTest;
import org.junit.Before;

import static org.junit.Assume.assumeTrue;

public abstract class AArch64MatchRuleTest extends MatchRuleTest {
    @Before
    public void checkAArch64() {
        assumeTrue("skipping AArch64 specific test", getTarget().arch instanceof AArch64);
    }

}
