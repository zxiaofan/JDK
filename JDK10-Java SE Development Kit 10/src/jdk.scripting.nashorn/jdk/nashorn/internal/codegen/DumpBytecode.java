/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.codegen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import jdk.nashorn.internal.runtime.ECMAErrors;
import jdk.nashorn.internal.runtime.ScriptEnvironment;
import jdk.nashorn.internal.runtime.logging.DebugLogger;

/**
 * Class that facilitates printing bytecode and dumping it to disk.
 */
public final class DumpBytecode {
    /**
     * Dump bytecode to console and potentially disk.
     * @param env the script environment defining options for printing bytecode
     * @param logger a logger used to write diagnostics about bytecode dumping
     * @param bytecode the actual code to dump
     * @param className the name of the class being dumped
     */
    public static void dumpBytecode(final ScriptEnvironment env, final DebugLogger logger, final byte[] bytecode, final String className) {
        File dir = null;
        try {
            // should could be printed to stderr for generate class?
            if (env._print_code) {

                final StringBuilder sb = new StringBuilder();
                sb.append("class: ").append(className).
                    append('\n').
                    append(ClassEmitter.disassemble(bytecode)).
                    append("=====");

                if (env._print_code_dir != null) {

                    String name = className;
                    final int dollar = name.lastIndexOf('$');
                    if (dollar != -1) {
                        name = name.substring(dollar + 1);
                    }

                    dir = new File(env._print_code_dir);
                    if (!dir.exists() && !dir.mkdirs()) {
                        throw new IOException(dir.toString());
                    }

                    File file;
                    String fileName;
                    int uniqueId = 0;
                    do {
                        fileName = name + (uniqueId == 0 ? "" : "_" + uniqueId) + ".bytecode";
                        file = new File(env._print_code_dir, fileName);
                        uniqueId++;
                    } while (file.exists());

                    try (final PrintWriter pw = new PrintWriter(new FileOutputStream(file))) {
                        pw.print(sb.toString());
                        pw.flush();
                    }
                } else {
                    env.getErr().println(sb);
                }
            }


            // should code be dumped to disk
            if (env._dest_dir != null) {
                final String fileName = className.replace('.', File.separatorChar) + ".class";
                final int    index    = fileName.lastIndexOf(File.separatorChar);

                if (index != -1) {
                    dir = new File(env._dest_dir, fileName.substring(0, index));
                } else {
                    dir = new File(env._dest_dir);
                }

                if (!dir.exists() && !dir.mkdirs()) {
                    throw new IOException(dir.toString());
                }
                final File file = new File(env._dest_dir, fileName);
                try (final FileOutputStream fos = new FileOutputStream(file)) {
                    fos.write(bytecode);
                }
                logger.info("Wrote class to '" + file.getAbsolutePath() + '\'');
            }
        } catch (final IOException e) {
            logger.warning("Skipping class dump for ",
                    className,
                    ": ",
                    ECMAErrors.getMessage(
                        "io.error.cant.write",
                        dir.toString()));
        }
    }
}
