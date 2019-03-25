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


package org.graalvm.compiler.core.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import org.graalvm.compiler.debug.DebugOptions;
import org.graalvm.compiler.debug.PathUtilities;
import org.graalvm.compiler.options.OptionKey;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.test.AddExports;
import org.junit.Assume;
import org.junit.Test;

@AddExports("jdk.internal.vm.compiler/org.graalvm.compiler.printer")
public class GraalDebugHandlersFactoryTest extends GraalCompilerTest {

    @Test
    public void createUniqueTest() throws Exception {
        Field maxFileNameLengthField = PathUtilities.class.getDeclaredField("MAX_FILE_NAME_LENGTH");
        try {
            maxFileNameLengthField.setAccessible(true);
        } catch (RuntimeException ex) {
            Assume.assumeFalse("If InaccessibleObjectException is thrown, skip the test, we are on JDK9", ex.getClass().getSimpleName().equals("InaccessibleObjectException"));
        }
        int maxFileNameLength = maxFileNameLengthField.getInt(null);
        Method createUniqueMethod = PathUtilities.class.getDeclaredMethod("createUnique", OptionValues.class, OptionKey.class, String.class, String.class, String.class, boolean.class);
        createUniqueMethod.setAccessible(true);
        Path tmpDir = Files.createTempDirectory(Paths.get("."), "createUniqueTest");
        OptionValues options = new OptionValues(OptionValues.asMap(DebugOptions.DumpPath, tmpDir.toString()));
        try {
            for (boolean createDirectory : new boolean[]{true, false}) {
                for (String ext : new String[]{"", ".bgv", ".graph-strings"}) {
                    for (int i = 0; i < maxFileNameLength + 5; i++) {
                        String id = new String(new char[i]).replace('\0', 'i');
                        String label = "";
                        createUniqueMethod.invoke(null, options, null, id, label, ext, createDirectory);

                        id = "";
                        label = new String(new char[i]).replace('\0', 'l');
                        createUniqueMethod.invoke(null, options, null, id, label, ext, createDirectory);
                    }
                }
            }
        } finally {
            deleteTree(tmpDir);
        }
    }

    private static void deleteTree(Path root) throws IOException {
        Files.walk(root).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
    }
}
