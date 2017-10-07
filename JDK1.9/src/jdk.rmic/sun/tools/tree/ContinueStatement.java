/*
 * Copyright (c) 1994, 2003, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

package sun.tools.tree;

import sun.tools.java.*;
import sun.tools.asm.Assembler;
import sun.tools.asm.Label;
import java.io.PrintStream;
import java.util.Hashtable;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public
class ContinueStatement extends Statement {
    Identifier lbl;

    /**
     * Constructor
     */
    public ContinueStatement(long where, Identifier lbl) {
        super(CONTINUE, where);
        this.lbl = lbl;
    }

    /**
     * Check statement
     */

    Vset check(Environment env, Context ctx, Vset vset, Hashtable<Object, Object> exp) {
        checkLabel(env, ctx);
        reach(env, vset);
        // A new context is established here because the 'continue' statement
        // itself may be labelled, however erroneously.  A 'CheckContext' must
        // be used here, as 'getContinueContext' is expected to return one.
        CheckContext destctx = (CheckContext)new CheckContext(ctx, this).getContinueContext(lbl);
        if (destctx != null) {
            switch (destctx.node.op) {
              case FOR:
              case DO:
              case WHILE:
                if (destctx.frameNumber != ctx.frameNumber) {
                    env.error(where, "branch.to.uplevel", lbl);
                }
                destctx.vsContinue = destctx.vsContinue.join(vset);
                break;
              default:
                env.error(where, "invalid.continue");
            }
        } else {
            if (lbl != null) {
                env.error(where, "label.not.found", lbl);
            } else {
                env.error(where, "invalid.continue");
            }
        }
        CheckContext exitctx = ctx.getTryExitContext();
        if (exitctx != null) {
            exitctx.vsTryExit = exitctx.vsTryExit.join(vset);
        }
        return DEAD_END;
    }

    /**
     * The cost of inlining this statement
     */
    public int costInline(int thresh, Environment env, Context ctx) {
        return 1;
    }

    /**
     * Code
     */
    public void code(Environment env, Context ctx, Assembler asm) {
        CodeContext destctx = (CodeContext)ctx.getContinueContext(lbl);
        codeFinally(env, ctx, asm, destctx, null);
        asm.add(where, opc_goto, destctx.contLabel);
    }

    /**
     * Print
     */
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        out.print("continue");
        if (lbl != null) {
            out.print(" " + lbl);
        }
        out.print(";");
    }
}
