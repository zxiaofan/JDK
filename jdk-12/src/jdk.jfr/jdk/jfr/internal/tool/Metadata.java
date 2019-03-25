/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

import jdk.jfr.consumer.RecordingFile;
import jdk.jfr.internal.Type;
import jdk.jfr.internal.consumer.RecordingInternals;

final class Metadata extends Command {

    private static class TypeComparator implements Comparator<Type> {

        @Override
        public int compare(Type t1, Type t2) {
            int g1 = groupValue(t1);
            int g2 = groupValue(t2);
            if (g1 == g2) {
                String n1 = t1.getName();
                String n2 = t2.getName();
                String package1 = n1.substring(0, n1.lastIndexOf('.') + 1);
                String package2 = n2.substring(0, n2.lastIndexOf('.') + 1);

                if (package1.equals(package2)) {
                    return n1.compareTo(n2);
                } else {
                    // Ensure that jdk.* are printed first
                    // This makes it easier to find user defined events at the end.
                    if (Type.SUPER_TYPE_EVENT.equals(t1.getSuperType()) && !package1.equals(package2)) {
                        if (package1.equals("jdk.jfr")) {
                            return -1;
                        }
                        if (package2.equals("jdk.jfr")) {
                            return 1;
                        }
                    }
                    return package1.compareTo(package2);
                }
            } else {
                return Integer.compare(groupValue(t1), groupValue(t2));
            }
        }

        int groupValue(Type t) {
            String superType = t.getSuperType();
            if (superType == null) {
                return 1;
            }
            if (Type.SUPER_TYPE_ANNOTATION.equals(superType)) {
                return 3;
            }
            if (Type.SUPER_TYPE_SETTING.equals(superType)) {
                return 4;
            }
            if (Type.SUPER_TYPE_EVENT.equals(superType)) {
                return 5;
            }
            return 2; // reserved for enums in the future
        }
    }

    @Override
    public String getName() {
        return "metadata";
    }

    @Override
    public List<String> getOptionSyntax() {
        return Collections.singletonList("<file>");
    }

    @Override
    public String getDescription() {
        return "Display event metadata, such as labels, descriptions and field layout";
    }

    @Override
    public void execute(Deque<String> options) throws UserSyntaxException, UserDataException {
        Path file = getJFRInputFile(options);

        boolean showIds = false;
        int optionCount = options.size();
        while (optionCount > 0) {
            if (acceptOption(options, "--ids")) {
                showIds = true;
            }
            if (optionCount == options.size()) {
                // No progress made
                throw new UserSyntaxException("unknown option " + options.peek());
            }
            optionCount = options.size();
        }

        try (PrintWriter pw = new PrintWriter(System.out)) {
            PrettyWriter prettyWriter = new PrettyWriter(pw);
            prettyWriter.setShowIds(showIds);
            try (RecordingFile rf = new RecordingFile(file)) {
                List<Type> types = RecordingInternals.INSTANCE.readTypes(rf);
                Collections.sort(types, new TypeComparator());
                for (Type type : types) {
                    prettyWriter.printType(type);
                }
                prettyWriter.flush(true);
            } catch (IOException ioe) {
                couldNotReadError(file, ioe);
            }
        }
    }
}
