/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.internal.dcmd;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jdk.jfr.FlightRecorder;
import jdk.jfr.Recording;
import jdk.jfr.internal.JVM;
import jdk.jfr.internal.SecuritySupport;
import jdk.jfr.internal.SecuritySupport.SafePath;
import jdk.jfr.internal.Utils;

/**
 * Base class for JFR diagnostic commands
 *
 */
abstract class AbstractDCmd {

    private final StringWriter result;
    private final PrintWriter log;

    protected AbstractDCmd() {
        result = new StringWriter();
        log = new PrintWriter(result);
    }

    protected final FlightRecorder getFlightRecorder() {
        return FlightRecorder.getFlightRecorder();
    }

    public final String getResult() {
        return result.toString();
    }

    public String getPid() {
        // Invoking ProcessHandle.current().pid() would require loading more
        // classes during startup so instead JVM.getJVM().getPid() is used.
        // The pid will not be exposed to running Java application, only when starting
        // JFR from command line (-XX:StartFlightRecordin) or jcmd (JFR.start and JFR.check)
        return JVM.getJVM().getPid();
    }

    protected final SafePath resolvePath(Recording recording, String filename) throws InvalidPathException {
        if (filename == null) {
            return makeGenerated(recording, Paths.get("."));
        }
        Path path = Paths.get(filename);
        if (Files.isDirectory(path)) {
            return makeGenerated(recording, path);
        }
        return new SafePath(path.toAbsolutePath().normalize());
    }

    private SafePath makeGenerated(Recording recording, Path directory) {
        return new SafePath(directory.toAbsolutePath().resolve(Utils.makeFilename(recording)).normalize());
    }

    protected final Recording findRecording(String name) throws DCmdException {
        try {
            return findRecordingById(Integer.parseInt(name));
        } catch (NumberFormatException nfe) {
            // User specified a name, not an id.
            return findRecordingByName(name);
        }
    }

    protected final void reportOperationComplete(String actionPrefix, String name, SafePath file) {
        print(actionPrefix);
        print(" recording");
        if (name != null) {
            print(" \"" + name + "\"");
        }
        if (file != null) {
            print(",");
            try {
                print(" ");
                long bytes = SecuritySupport.getFileSize(file);
                printBytes(bytes);
            } catch (IOException e) {
                // Ignore, not essential
            }
            println(" written to:");
            println();
            printPath(file);
        } else {
            println(".");
        }
    }

    protected final List<Recording> getRecordings() {
        List<Recording> list = new ArrayList<>(getFlightRecorder().getRecordings());
        Collections.sort(list, Comparator.comparing(Recording::getId));
        return list;
    }

    static String quoteIfNeeded(String text) {
        if (text.contains(" ")) {
            return "\\\"" + text + "\\\"";
        } else {
            return text;
        }
    }

    protected final void println() {
        log.println();
    }

    protected final void print(String s) {
        log.print(s);
    }

    protected final void print(String s, Object... args) {
        log.printf(s, args);
    }

    protected final void println(String s, Object... args) {
        print(s, args);
        println();
    }

    protected final void printBytes(long bytes) {
        print(Utils.formatBytes(bytes));
    }

    protected final void printTimespan(Duration timespan, String separator) {
        print(Utils.formatTimespan(timespan, separator));
    }

    protected final void printPath(SafePath path) {
        if (path == null) {
            print("N/A");
            return;
        }
        try {
            printPath(SecuritySupport.getAbsolutePath(path).toPath());
        } catch (IOException ioe) {
            printPath(path.toPath());
        }
    }

    protected final void printPath(Path path) {
        try {
            println(path.toAbsolutePath().toString());
        } catch (SecurityException e) {
            // fall back on filename
            println(path.toString());
        }
    }

    private Recording findRecordingById(int id) throws DCmdException {
        for (Recording r : getFlightRecorder().getRecordings()) {
            if (r.getId() == id) {
                return r;
            }
        }
        throw new DCmdException("Could not find %d.\n\nUse JFR.check without options to see list of all available recordings.", id);
    }

    private Recording findRecordingByName(String name) throws DCmdException {
        for (Recording recording : getFlightRecorder().getRecordings()) {
            if (name.equals(recording.getName())) {
                return recording;
            }
        }
        throw new DCmdException("Could not find %s.\n\nUse JFR.check without options to see list of all available recordings.", name);
    }
}
