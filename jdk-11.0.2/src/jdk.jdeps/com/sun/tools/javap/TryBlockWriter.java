/*
 * Copyright (c) 2009, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javap;

import com.sun.tools.classfile.Code_attribute;
import com.sun.tools.classfile.Code_attribute.Exception_data;
import com.sun.tools.classfile.Instruction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Annotate instructions with details about try blocks.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class TryBlockWriter extends InstructionDetailWriter {
    public enum NoteKind {
        START("try") {
            public boolean match(Exception_data entry, int pc) {
                return (pc == entry.start_pc);
            }
        },
        END("end try") {
            public boolean match(Exception_data entry, int pc) {
                return (pc == entry.end_pc);
            }
        },
        HANDLER("catch") {
            public boolean match(Exception_data entry, int pc) {
                return (pc == entry.handler_pc);
            }
        };
        NoteKind(String text) {
            this.text = text;
        }
        public abstract boolean match(Exception_data entry, int pc);
        public final String text;
    }

    static TryBlockWriter instance(Context context) {
        TryBlockWriter instance = context.get(TryBlockWriter.class);
        if (instance == null)
            instance = new TryBlockWriter(context);
        return instance;
    }

    protected TryBlockWriter(Context context) {
        super(context);
        context.put(TryBlockWriter.class, this);
        constantWriter = ConstantWriter.instance(context);
    }

    public void reset(Code_attribute attr) {
        indexMap = new HashMap<>();
        pcMap = new HashMap<>();
        for (int i = 0; i < attr.exception_table.length; i++) {
            Exception_data entry = attr.exception_table[i];
            indexMap.put(entry, i);
            put(entry.start_pc, entry);
            put(entry.end_pc, entry);
            put(entry.handler_pc, entry);
        }
    }

    public void writeDetails(Instruction instr) {
        writeTrys(instr, NoteKind.END);
        writeTrys(instr, NoteKind.START);
        writeTrys(instr, NoteKind.HANDLER);
    }

    public void writeTrys(Instruction instr, NoteKind kind) {
        String indent = space(2); // get from Options?
        int pc = instr.getPC();
        List<Exception_data> entries = pcMap.get(pc);
        if (entries != null) {
            for (ListIterator<Exception_data> iter =
                    entries.listIterator(kind == NoteKind.END ? entries.size() : 0);
                    kind == NoteKind.END ? iter.hasPrevious() : iter.hasNext() ; ) {
                Exception_data entry =
                        kind == NoteKind.END ? iter.previous() : iter.next();
                if (kind.match(entry, pc)) {
                    print(indent);
                    print(kind.text);
                    print("[");
                    print(indexMap.get(entry));
                    print("] ");
                    if (entry.catch_type == 0)
                        print("finally");
                    else {
                        print("#" + entry.catch_type);
                        print(" // ");
                        constantWriter.write(entry.catch_type);
                    }
                    println();
                }
            }
        }
    }

    private void put(int pc, Exception_data entry) {
        List<Exception_data> list = pcMap.get(pc);
        if (list == null) {
            list = new ArrayList<>();
            pcMap.put(pc, list);
        }
        if (!list.contains(entry))
            list.add(entry);
    }

    private Map<Integer, List<Exception_data>> pcMap;
    private Map<Exception_data, Integer> indexMap;
    private ConstantWriter constantWriter;
}
