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
/*
 */


package org.graalvm.compiler.core.test.deopt;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.FrameState;
import org.junit.Test;

public final class RethrowDeoptMaterializeTest extends GraalCompilerTest {

    private static final Object RETURN_VALUE = "1 2 3";
    private static final RuntimeException DUMMY_EXCEPTION = new RuntimeException();

    static class MyException extends RuntimeException {
        private static final long serialVersionUID = 0L;

        MyException(Throwable cause) {
            super(cause);
        }

        @SuppressWarnings("sync-override")
        @Override
        public final Throwable fillInStackTrace() {
            return null;
        }
    }

    public static Object executeDeoptRethrow(int action) {

        try {
            if (action != 0) {
                throw new MyException(DUMMY_EXCEPTION);
            } else if (action == 1) {
                throw new MyException(null);
            }
        } catch (RuntimeException t) {
            Throwable e = t.getCause();
            GraalDirectives.deoptimize();
            if (e != DUMMY_EXCEPTION) {
                throw t;
            }
        }
        return RETURN_VALUE;
    }

    /**
     * This tests that a state with {@link FrameState#rethrowException()} set to true can properly
     * throw an exception that must be rematerialized.
     */
    @Test
    public void testDeoptRethrow() {
        test("executeDeoptRethrow", 1);
    }
}
