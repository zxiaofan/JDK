/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.cmd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringJoiner;

import jdk.jfr.AnnotationElement;
import jdk.jfr.ValueDescriptor;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordedObject;
import jdk.jfr.consumer.RecordingFile;
import jdk.jfr.internal.PrivateAccess;
import jdk.jfr.internal.Type;
import jdk.jfr.internal.consumer.ChunkHeader;
import jdk.jfr.internal.consumer.RecordingInput;

public final class PrettyWriter extends StructuredWriter {

    public PrettyWriter(PrintWriter destination) {
        super(destination);
    }

    void print(Path source) throws FileNotFoundException, IOException {
        try (RecordingInput input = new RecordingInput(source.toFile())) {
            HashSet<Type> typeSet = new HashSet<>();
            for (ChunkHeader ch = new ChunkHeader(input); !ch.isLastChunk(); ch = ch.nextHeader()) {
                typeSet.addAll(ch.readMetadata().getTypes());
            }
            List<Type> types = new ArrayList<>(typeSet);
            Collections.sort(types, (c1, c2) -> Long.compare(c1.getId(), c2.getId()));
            for (Type t : types) {
                printType(t);
            }
            flush();
        }

        try (RecordingFile es = new RecordingFile(source)) {
            while (es.hasMoreEvents()) {
                print(es.readEvent());
                flush();
            }
        }
        flush();
    }

    public void printType(Type t) throws IOException {
        print("// id: ");
        println(String.valueOf(t.getId()));
        int commentIndex = t.getName().length() + 10;
        String typeName = t.getName();
        int index = typeName.lastIndexOf(".");
        if (index != -1) {
            println("package " + typeName.substring(0, index) + ";");
        }
        printAnnotations(commentIndex, t.getAnnotationElements());
        print("class " + typeName.substring(index + 1));
        String superType = t.getSuperType();
        if (superType != null) {
            print(" extends " + superType);
        }
        println(" {");
        indent();
        for (ValueDescriptor v : t.getFields()) {
            printField(commentIndex, v);
        }
        retract();
        println("}");
        println();
    }

    private void printField(int commentIndex, ValueDescriptor v) throws IOException {
        println();
        printAnnotations(commentIndex, v.getAnnotationElements());
        printIndent();
        Type vType = PrivateAccess.getInstance().getType(v);
        if (Type.SUPER_TYPE_SETTING.equals(vType.getSuperType())) {
            print("static ");
        }
        print(makeSimpleType(v.getTypeName()));
        if (v.isArray()) {
            print("[]");
        }
        print(" ");
        print(v.getName());
        print(";");
        printCommentRef(commentIndex, v.getTypeId());
    }

    private void printCommentRef(int commentIndex, long typeId) throws IOException {
        int column = getColumn();
        if (column > commentIndex) {
            print("  ");
        } else {
            while (column < commentIndex) {
                print(" ");
                column++;
            }
        }
        println(" // id=" + typeId);
    }

    private void printAnnotations(int commentIndex, List<AnnotationElement> annotations) throws IOException {
        for (AnnotationElement a : annotations) {
            printIndent();
            print("@");
            print(makeSimpleType(a.getTypeName()));
            List<ValueDescriptor> vs = a.getValueDescriptors();
            if (!vs.isEmpty()) {
                printAnnotation(a);
                printCommentRef(commentIndex, a.getTypeId());
            } else {
                println();
            }
        }
    }

    private void printAnnotation(AnnotationElement a) throws IOException {
        StringJoiner sj = new StringJoiner(", ", "(", ")");
        List<ValueDescriptor> vs = a.getValueDescriptors();
        for (ValueDescriptor v : vs) {
            Object o = a.getValue(v.getName());
            if (vs.size() == 1 && v.getName().equals("value")) {
                sj.add(textify(o));
            } else {
                sj.add(v.getName() + "=" + textify(o));
            }
        }
        print(sj.toString());
    }

    private String textify(Object o) {
        if (o.getClass().isArray()) {
            Object[] array = (Object[]) o;
            if (array.length == 1) {
                return quoteIfNeeded(array[0]);
            }
            StringJoiner s = new StringJoiner(", ", "{", "}") ;
            for (Object ob : array) {
                s.add(quoteIfNeeded(ob));
            }
            return s.toString();
        } else {
            return quoteIfNeeded(o);
        }
    }

    private String quoteIfNeeded(Object o) {
        if (o instanceof String) {
            return "\"" + o + "\"";
        } else {
            return String.valueOf(o);
        }
    }

    private String makeSimpleType(String typeName) {
        int index = typeName.lastIndexOf(".");
        return typeName.substring(index + 1);
    }

    public void print(RecordedEvent event) throws IOException {
        print(makeSimpleType(event.getEventType().getName()), " ");
        print((RecordedObject) event, "");
    }

    public void print(RecordedObject struct, String postFix) throws IOException {
        println("{");
        indent();
        for (ValueDescriptor v : struct.getFields()) {
            printIndent();
            print(v.getName(), " = ");
            printValue(struct.getValue(v.getName()), "");
        }
        retract();
        printIndent();
        println("}" + postFix);
    }

    private void printArray(Object[] array) throws IOException {
        println("[");
        indent();
        for (int i = 0; i < array.length; i++) {
            printIndent();
            printValue(array[i], i + 1 < array.length ? ", " : "");
        }
        retract();
        printIndent();
        println("]");
    }

    private void printValue(Object value, String postFix) throws IOException {
        if (value == null) {
            println("null" + postFix);
        } else if (value instanceof RecordedObject) {
            print((RecordedObject) value, postFix);
        } else if (value.getClass().isArray()) {
            printArray((Object[]) value);
        } else {
            String text = String.valueOf(value);
            if (value instanceof String) {
                text = "\"" + text + "\"";
            }
            println(text);
        }
    }
}
