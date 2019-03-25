/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.tools.classfile.Attribute;
import com.sun.tools.classfile.Code_attribute;
import com.sun.tools.classfile.TypeAnnotation;
import com.sun.tools.classfile.TypeAnnotation.Position;
import com.sun.tools.classfile.Instruction;
import com.sun.tools.classfile.Method;
import com.sun.tools.classfile.RuntimeInvisibleTypeAnnotations_attribute;
import com.sun.tools.classfile.RuntimeTypeAnnotations_attribute;
import com.sun.tools.classfile.RuntimeVisibleTypeAnnotations_attribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sun.tools.javac.util.StringUtils;

/**
 * Annotate instructions with details about type annotations.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class TypeAnnotationWriter extends InstructionDetailWriter {
    public enum NoteKind { VISIBLE, INVISIBLE }

    public static class Note {
        Note(NoteKind kind, TypeAnnotation anno) {
            this.kind = kind;
            this.anno = anno;
        }
        public final NoteKind kind;
        public final TypeAnnotation anno;
    }

    static TypeAnnotationWriter instance(Context context) {
        TypeAnnotationWriter instance = context.get(TypeAnnotationWriter.class);
        if (instance == null)
            instance = new TypeAnnotationWriter(context);
        return instance;
    }

    protected TypeAnnotationWriter(Context context) {
        super(context);
        context.put(TypeAnnotationWriter.class, this);
        annotationWriter = AnnotationWriter.instance(context);
        classWriter = ClassWriter.instance(context);
    }

    public void reset(Code_attribute attr) {
        Method m = classWriter.getMethod();
        pcMap = new HashMap<>();
        check(NoteKind.VISIBLE, (RuntimeVisibleTypeAnnotations_attribute) m.attributes.get(Attribute.RuntimeVisibleTypeAnnotations));
        check(NoteKind.INVISIBLE, (RuntimeInvisibleTypeAnnotations_attribute) m.attributes.get(Attribute.RuntimeInvisibleTypeAnnotations));
    }

    private void check(NoteKind kind, RuntimeTypeAnnotations_attribute attr) {
        if (attr == null)
            return;

        for (TypeAnnotation anno: attr.annotations) {
            Position p = anno.position;
            Note note = null;
            if (p.offset != -1)
                addNote(p.offset, note = new Note(kind, anno));
            if (p.lvarOffset != null) {
                for (int i = 0; i < p.lvarOffset.length; i++) {
                    if (note == null)
                        note = new Note(kind, anno);
                    addNote(p.lvarOffset[i], note);
                }
            }
        }
    }

    private void addNote(int pc, Note note) {
        List<Note> list = pcMap.get(pc);
        if (list == null)
            pcMap.put(pc, list = new ArrayList<>());
        list.add(note);
    }

    @Override
    void writeDetails(Instruction instr) {
        String indent = space(2); // get from Options?
        int pc = instr.getPC();
        List<Note> notes = pcMap.get(pc);
        if (notes != null) {
            for (Note n: notes) {
                print(indent);
                print("@");
                annotationWriter.write(n.anno, false, true);
                print(", ");
                println(StringUtils.toLowerCase(n.kind.toString()));
            }
        }
    }

    private AnnotationWriter annotationWriter;
    private ClassWriter classWriter;
    private Map<Integer, List<Note>> pcMap;
}
