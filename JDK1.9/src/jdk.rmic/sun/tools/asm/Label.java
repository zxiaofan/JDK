/*
 * Copyright (c) 1994, 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.asm;

import sun.tools.java.MemberDefinition;
import java.io.OutputStream;

/**
 * A label instruction. This is a 0 size instruction.
 * It is the only valid target of a branch instruction.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public final
class Label extends Instruction {
    static int labelCount = 0;
    int ID;
    int depth;
    MemberDefinition locals[];

    /**
     * Constructor
     */
    public Label() {
        super(0, opc_label, null);
        this.ID = ++labelCount;
    }

    /**
     * Get the final destination, eliminate jumps gotos, and jumps to
     * labels that are immediately folowed by another label. The depth
     * field is used to leave bread crumbs to avoid infinite loops.
     */
    Label getDestination() {
        Label lbl = this;
        if ((next != null) && (next != this) && (depth == 0)) {
            depth = 1;

            switch (next.opc) {
              case opc_label:
                lbl = ((Label)next).getDestination();
                break;

              case opc_goto:
                lbl = ((Label)next.value).getDestination();
                break;

              case opc_ldc:
              case opc_ldc_w:
                if (next.value instanceof Integer) {
                    Instruction inst = next.next;
                    if (inst.opc == opc_label) {
                        inst = ((Label)inst).getDestination().next;
                    }

                    if (inst.opc == opc_ifeq) {
                        if (((Integer)next.value).intValue() == 0) {
                            lbl = (Label)inst.value;
                        } else {
                            lbl = new Label();
                            lbl.next = inst.next;
                            inst.next = lbl;
                        }
                        lbl = lbl.getDestination();
                        break;
                    }
                    if (inst.opc == opc_ifne) {
                        if (((Integer)next.value).intValue() == 0) {
                            lbl = new Label();
                            lbl.next = inst.next;
                            inst.next = lbl;
                        } else {
                            lbl = (Label)inst.value;
                        }
                        lbl = lbl.getDestination();
                        break;
                    }
                }
                break;
            }
            depth = 0;
        }
        return lbl;
    }

    public String toString() {
        String s = "$" + ID + ":";
        if (value != null)
            s = s + " stack=" + value;
        return s;
    }
}
