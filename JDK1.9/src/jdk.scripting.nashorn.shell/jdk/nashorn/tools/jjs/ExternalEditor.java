/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.tools.jjs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.function.Consumer;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

final class ExternalEditor {
    private final Consumer<String> errorHandler;
    private final Consumer<String> saveHandler;
    private final Console input;

    private WatchService watcher;
    private Thread watchedThread;
    private Path dir;
    private Path tmpfile;

    ExternalEditor(final Consumer<String> errorHandler, final Consumer<String> saveHandler, final Console input) {
        this.errorHandler = errorHandler;
        this.saveHandler = saveHandler;
        this.input = input;
    }

    private void edit(final String cmd, final String initialText) {
        try {
            setupWatch(initialText);
            launch(cmd);
        } catch (IOException ex) {
            errorHandler.accept(ex.getMessage());
        }
    }

    /**
     * Creates a WatchService and registers the given directory
     */
    private void setupWatch(final String initialText) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.dir = Files.createTempDirectory("REPL");
        this.tmpfile = Files.createTempFile(dir, null, ".js");
        Files.write(tmpfile, initialText.getBytes(Charset.forName("UTF-8")));
        dir.register(watcher,
                ENTRY_CREATE,
                ENTRY_DELETE,
                ENTRY_MODIFY);
        watchedThread = new Thread(() -> {
            for (;;) {
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (final ClosedWatchServiceException ex) {
                    break;
                } catch (final InterruptedException ex) {
                    continue; // tolerate an intrupt
                }

                if (!key.pollEvents().isEmpty()) {
                    if (!input.terminalEditorRunning()) {
                        saveFile();
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    errorHandler.accept("Invalid key");
                    break;
                }
            }
        });
        watchedThread.start();
    }

    private void launch(final String cmd) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(cmd, tmpfile.toString());
        pb = pb.inheritIO();

        try {
            input.suspend();
            Process process = pb.start();
            process.waitFor();
        } catch (final IOException ex) {
            errorHandler.accept("process IO failure: " + ex.getMessage());
        } catch (final InterruptedException ex) {
            errorHandler.accept("process interrupt: " + ex.getMessage());
        } finally {
            try {
                watcher.close();
                watchedThread.join(); //so that saveFile() is finished.
                saveFile();
            } catch (InterruptedException ex) {
                errorHandler.accept("process interrupt: " + ex.getMessage());
            } finally {
                input.resume();
            }
        }
    }

    private void saveFile() {
        List<String> lines;
        try {
            lines = Files.readAllLines(tmpfile);
        } catch (final IOException ex) {
            errorHandler.accept("Failure read edit file: " + ex.getMessage());
            return ;
        }
        StringBuilder sb = new StringBuilder();
        for (String ln : lines) {
            sb.append(ln);
            sb.append('\n');
        }
        saveHandler.accept(sb.toString());
    }

    static void edit(final String cmd, final Consumer<String> errorHandler, final String initialText,
            final Consumer<String> saveHandler, final Console input) {
        ExternalEditor ed = new ExternalEditor(errorHandler,  saveHandler, input);
        ed.edit(cmd, initialText);
    }
}
