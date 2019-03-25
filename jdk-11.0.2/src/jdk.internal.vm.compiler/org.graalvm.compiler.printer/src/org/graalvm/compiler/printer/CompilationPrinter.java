/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.printer;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.graalvm.compiler.core.common.CompilationIdentifier;
import org.graalvm.compiler.debug.LogStream;
import org.graalvm.compiler.debug.TTY;
import org.graalvm.compiler.lir.util.IndexedValueMap;

import jdk.vm.ci.code.BytecodeFrame;
import jdk.vm.ci.code.BytecodePosition;
import jdk.vm.ci.code.ReferenceMap;
import jdk.vm.ci.code.Register;
import jdk.vm.ci.code.RegisterSaveLayout;
import jdk.vm.ci.code.VirtualObject;
import jdk.vm.ci.meta.JavaMethod;
import jdk.vm.ci.meta.JavaValue;
import jdk.vm.ci.meta.MetaUtil;

/**
 * Utility for printing compilation related data structures at various compilation phases. The
 * output format is such that it can then be fed to the
 * <a href="https://c1visualizer.dev.java.net/">C1 Visualizer</a>.
 */
public class CompilationPrinter implements Closeable {

    public static final String COLUMN_END = " <|@";
    public static final String HOVER_START = "<@";
    public static final String HOVER_SEP = "|@";
    public static final String HOVER_END = ">@";

    private static OutputStream globalOut;

    /**
     * Gets a global output stream on a file in the current working directory. This stream is first
     * opened if necessary. The name of the file is
     * {@code "compilations-" + System.currentTimeMillis() + ".cfg"}.
     *
     * @return the global output stream or {@code null} if there was an error opening the file for
     *         writing
     */
    public static synchronized OutputStream globalOut() {
        if (globalOut == null) {
            File file = new File("compilations-" + System.currentTimeMillis() + ".cfg");
            try {
                globalOut = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                TTY.println("WARNING: Could not open " + file.getAbsolutePath());
            }
        }
        return globalOut;
    }

    protected final LogStream out;

    /**
     * Creates a control flow graph printer.
     *
     * @param os where the output generated via this printer will be sent
     */
    public CompilationPrinter(OutputStream os) {
        out = new LogStream(os);
    }

    /**
     * Flushes all buffered output to the underlying output stream.
     */
    public void flush() {
        out.flush();
    }

    @Override
    public void close() {
        out.out().close();
    }

    protected void begin(String string) {
        out.println("begin_" + string);
        out.adjustIndentation(2);
    }

    protected void end(String string) {
        out.adjustIndentation(-2);
        out.println("end_" + string);
    }

    /**
     * Prints a compilation timestamp for a given method.
     *
     * @param javaMethod the method for which a timestamp will be printed
     */
    public void printCompilation(JavaMethod javaMethod) {
        printCompilation(javaMethod.format("%H::%n"), javaMethod.format("%f %r %H.%n(%p)"));
    }

    /**
     * Prints a compilation id.
     *
     * @param compilationId the compilation method for which an id will be printed
     */
    public void printCompilation(CompilationIdentifier compilationId) {
        printCompilation(compilationId.toString(CompilationIdentifier.Verbosity.DETAILED), compilationId.toString(CompilationIdentifier.Verbosity.DETAILED));
    }

    private void printCompilation(final String name, String method) {
        begin("compilation");
        out.print("name \" ").print(name).println('"');
        out.print("method \"").print(method).println('"');
        out.print("date ").println(System.currentTimeMillis());
        end("compilation");
    }

    /**
     * Formats given debug info as a multi line string.
     */
    protected String debugInfoToString(BytecodePosition codePos, ReferenceMap refMap, IndexedValueMap liveBasePointers, RegisterSaveLayout calleeSaveInfo) {
        StringBuilder sb = new StringBuilder();
        if (refMap != null) {
            sb.append("reference-map: ");
            sb.append(refMap.toString());
            sb.append("\n");
        }
        if (liveBasePointers != null) {
            sb.append("live-base-pointers: ");
            sb.append(liveBasePointers);
            sb.append("\n");
        }

        if (calleeSaveInfo != null) {
            sb.append("callee-save-info:");
            for (Map.Entry<Register, Integer> e : calleeSaveInfo.registersToSlots(true).entrySet()) {
                sb.append(" " + e.getKey() + " -> s" + e.getValue());
            }
            sb.append("\n");
        }

        if (codePos != null) {
            BytecodePosition curCodePos = codePos;
            List<VirtualObject> virtualObjects = new ArrayList<>();
            do {
                sb.append(MetaUtil.toLocation(curCodePos.getMethod(), curCodePos.getBCI()));
                sb.append('\n');
                if (curCodePos instanceof BytecodeFrame) {
                    BytecodeFrame frame = (BytecodeFrame) curCodePos;
                    if (frame.numStack > 0) {
                        sb.append("stack: ");
                        for (int i = 0; i < frame.numStack; i++) {
                            sb.append(valueToString(frame.getStackValue(i), virtualObjects)).append(' ');
                        }
                        sb.append("\n");
                    }
                    sb.append("locals: ");
                    for (int i = 0; i < frame.numLocals; i++) {
                        sb.append(valueToString(frame.getLocalValue(i), virtualObjects)).append(' ');
                    }
                    sb.append("\n");
                    if (frame.numLocks > 0) {
                        sb.append("locks: ");
                        for (int i = 0; i < frame.numLocks; ++i) {
                            sb.append(valueToString(frame.getLockValue(i), virtualObjects)).append(' ');
                        }
                        sb.append("\n");
                    }

                }
                curCodePos = curCodePos.getCaller();
            } while (curCodePos != null);

            for (int i = 0; i < virtualObjects.size(); i++) {
                VirtualObject obj = virtualObjects.get(i);
                sb.append(obj).append(" ").append(obj.getType().getName()).append(" ");
                for (int j = 0; j < obj.getValues().length; j++) {
                    sb.append(valueToString(obj.getValues()[j], virtualObjects)).append(' ');
                }
                sb.append("\n");

            }
        }
        return sb.toString();
    }

    protected String valueToString(JavaValue value, List<VirtualObject> virtualObjects) {
        if (value == null) {
            return "-";
        }
        if (value instanceof VirtualObject && !virtualObjects.contains(value)) {
            virtualObjects.add((VirtualObject) value);
        }
        return value.toString();
    }

    public void printMachineCode(String code, String label) {
        if (code == null || code.length() == 0) {
            return;
        }
        if (label != null) {
            begin("cfg");
            out.print("name \"").print(label).println('"');
            end("cfg");
        }
        begin("nmethod");
        out.print(code);
        out.println(" <|@");
        end("nmethod");
    }

    public void printBytecodes(String code) {
        if (code == null || code.length() == 0) {
            return;
        }
        begin("bytecodes");
        out.print(code);
        out.println(" <|@");
        end("bytecodes");
    }
}
