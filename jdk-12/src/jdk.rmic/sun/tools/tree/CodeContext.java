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
import sun.tools.asm.Label;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
class CodeContext extends Context {
    Label breakLabel;
    Label contLabel;

    /**
     * Create a new nested context, for a block statement
     */
    CodeContext(Context ctx, Node node) {
        super(ctx, node);
        switch (node.op) {
          case DO:
          case WHILE:
          case FOR:
          case FINALLY:
          case SYNCHRONIZED:
            this.breakLabel = new Label();
            this.contLabel = new Label();
            break;
          case SWITCH:
          case TRY:
          case INLINEMETHOD:
          case INLINENEWINSTANCE:
            this.breakLabel = new Label();
            break;
          default:
            if ((node instanceof Statement) && (((Statement)node).labels != null)) {
                this.breakLabel = new Label();
            }
        }
    }
}
