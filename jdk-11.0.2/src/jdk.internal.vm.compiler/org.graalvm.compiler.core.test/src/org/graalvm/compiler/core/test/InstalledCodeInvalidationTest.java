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


package org.graalvm.compiler.core.test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.junit.Test;

import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.code.InvalidInstalledCodeException;

public class InstalledCodeInvalidationTest extends GraalCompilerTest {

    public void recurse(InstalledCode code, int depth) throws InvalidInstalledCodeException {
        if (depth > 1) {
            /*
             * Recurse a few times to ensure there are multiple activations.
             */
            code.executeVarargs(this, code, depth - 1);
        } else {
            /*
             * Deoptimize this activation and make the compiled code no longer usable.
             */

            GraalDirectives.deoptimizeAndInvalidate();
            assert code.isAlive() && !code.isValid();
            code.invalidate();
            assert !code.isAlive();
        }
        if (GraalDirectives.inCompiledCode()) {
            /*
             * If this still in compiled code then the deoptimizeAndInvalidate call above didn't
             * remove all existing activations.
             */
            throw new InternalError();
        }
    }

    /**
     * Test that after uncommon trapping in an installed code it's still possible to invalidate all
     * existing activations of that installed code.
     *
     * @throws InvalidInstalledCodeException
     */
    @Test
    public void testInstalledCodeInvalidation() throws InvalidInstalledCodeException {
        InstalledCode code = getCode(getMetaAccess().lookupJavaMethod(getMethod("recurse")));
        code.executeVarargs(this, code, 3);
    }
}
