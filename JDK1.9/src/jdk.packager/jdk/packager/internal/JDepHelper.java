/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.packager.internal;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.sun.tools.jdeps.Main;
import java.io.PrintWriter;
import java.util.Collection;

import com.oracle.tools.packager.Log;


public final class JDepHelper {

    private JDepHelper() {}

    private static int execute(String[] args, PrintWriter out) {
        return com.sun.tools.jdeps.Main.run(args, out);
    }

    public static Set<String> calculateModules(Collection<String> Files, List<Path> modulePath) {
        Set<String> result = null;

        if (!Files.isEmpty()) {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintWriter writer = new PrintWriter(baos)) {

                List<String> arguments = new ArrayList<>();
                arguments.add("-s");

                // TODO Uncomment out once JDK-8151729 is fixed
                /*if (modulePath != null || !modulePath.isEmpty()) {
                    arguments.add("-modulepath");
                    arguments.add(ListOfPathToString(modulePath));
                }*/

                arguments.addAll(Files);

                execute(arguments.toArray(new String[arguments.size()]), writer);

                // Output format is multiple lines of "this.jar -> that.module.name"
                // we only care about what is to the right of the arrow.
                result = Arrays.stream(baos.toString().split("\\s*\\S+\\s+->\\s+"))
                                       .map(String::trim)
                                       .filter(s -> !s.isEmpty() && !arguments.contains(s) && !"not found".equals(s))
                                       .collect(Collectors.toSet());
            } catch (IOException exception) {
                Log.verbose(exception);
            }
        }

        if (result == null) {
            result = new LinkedHashSet();
        }

        return result;
    }

    private static String ListOfPathToString(List<Path> Value) {
        String result = "";

        for (Path path : Value) {
            if (result.isEmpty()) {
                result = path.toString();
            }
            else {
                result = File.pathSeparator + path.toString();
            }
        }

        return result;
    }
}
