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

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.nio.file.Files;
import java.util.function.Function;
import java.util.stream.Collectors;
import jdk.internal.jline.NoInterruptUnixTerminal;
import jdk.internal.jline.Terminal;
import jdk.internal.jline.TerminalFactory;
import jdk.internal.jline.TerminalFactory.Flavor;
import jdk.internal.jline.WindowsTerminal;
import jdk.internal.jline.console.ConsoleReader;
import jdk.internal.jline.console.KeyMap;
import jdk.internal.jline.extra.EditingHistory;
import jdk.internal.misc.Signal;
import jdk.internal.misc.Signal.Handler;

class Console implements AutoCloseable {
    private static final String DOCUMENTATION_SHORTCUT = "\033\133\132"; //Shift-TAB
    private final ConsoleReader in;
    private final File historyFile;

    Console(final InputStream cmdin, final PrintStream cmdout, final File historyFile,
            final NashornCompleter completer, final Function<String, String> docHelper) throws IOException {
        this.historyFile = historyFile;

        TerminalFactory.registerFlavor(Flavor.WINDOWS, isCygwin()? JJSUnixTerminal::new : JJSWindowsTerminal::new);
        TerminalFactory.registerFlavor(Flavor.UNIX, JJSUnixTerminal::new);
        in = new ConsoleReader(cmdin, cmdout);
        in.setExpandEvents(false);
        in.setHandleUserInterrupt(true);
        in.setBellEnabled(true);
        in.setCopyPasteDetection(true);
        final Iterable<String> existingHistory = historyFile.exists() ? Files.readAllLines(historyFile.toPath()) : null;
        in.setHistory(new EditingHistory(in, existingHistory) {
            @Override protected boolean isComplete(CharSequence input) {
                return completer.isComplete(input.toString());
            }
        });
        in.addCompleter(completer);
        Runtime.getRuntime().addShutdownHook(new Thread((Runnable)this::saveHistory));
        bind(DOCUMENTATION_SHORTCUT, (ActionListener)evt -> showDocumentation(docHelper));
        try {
            Signal.handle(new Signal("CONT"), new Handler() {
                @Override public void handle(Signal sig) {
                    try {
                        in.getTerminal().reset();
                        in.redrawLine();
                        in.flush();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        } catch (IllegalArgumentException ignored) {
            //the CONT signal does not exist on this platform
        }
    }

    String readLine(final String prompt) throws IOException {
        return in.readLine(prompt);
    }

    @Override
    public void close() {
        saveHistory();
    }

    private void saveHistory() {
        try (Writer out = Files.newBufferedWriter(historyFile.toPath())) {
            String lineSeparator = System.getProperty("line.separator");

            out.write(getHistory().save()
                                  .stream()
                                  .collect(Collectors.joining(lineSeparator)));
        } catch (final IOException exp) {}
    }

    EditingHistory getHistory() {
        return (EditingHistory) in.getHistory();
    }

    boolean terminalEditorRunning() {
        Terminal terminal = in.getTerminal();
        if (terminal instanceof JJSUnixTerminal) {
            return ((JJSUnixTerminal) terminal).isRaw();
        }
        return false;
    }

    void suspend() {
        try {
            in.getTerminal().restore();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    void resume() {
        try {
            in.getTerminal().init();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    static final class JJSUnixTerminal extends NoInterruptUnixTerminal {
        JJSUnixTerminal() throws Exception {
        }

        boolean isRaw() {
            try {
                return getSettings().get("-a").contains("-icanon");
            } catch (IOException | InterruptedException ex) {
                return false;
            }
        }

        @Override
        public void disableInterruptCharacter() {
        }

        @Override
        public void enableInterruptCharacter() {
        }
    }

    static final class JJSWindowsTerminal extends WindowsTerminal {
        public JJSWindowsTerminal() throws Exception {
        }

        @Override
        public void init() throws Exception {
            super.init();
            setAnsiSupported(false);
        }
    }

    private static boolean isCygwin() {
        return System.getenv("SHELL") != null;
    }

    private void bind(String shortcut, Object action) {
        KeyMap km = in.getKeys();
        for (int i = 0; i < shortcut.length(); i++) {
            final Object value = km.getBound(Character.toString(shortcut.charAt(i)));
            if (value instanceof KeyMap) {
                km = (KeyMap) value;
            } else {
                km.bind(shortcut.substring(i), action);
            }
        }
    }

    private void showDocumentation(final Function<String, String> docHelper) {
        final String buffer = in.getCursorBuffer().buffer.toString();
        final int cursor = in.getCursorBuffer().cursor;
        final String doc = docHelper.apply(buffer.substring(0, cursor));
        try {
            if (doc != null) {
                in.println();
                in.println(doc);
                in.redrawLine();
                in.flush();
            } else {
                in.beep();
            }
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
