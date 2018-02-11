/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.print;

import javafx.print.JobSettings;
import javafx.print.Paper;
import javafx.print.PaperSource;
import javafx.print.PrintResolution;
import javafx.print.Printer;

/**
 * An internal class which provides a way for implementation code to
 * access to package level protected constructors (etc).
 * All entry points to the printing API need to ensure this class is
 * loaded and initialized.
 */
public class PrintHelper {
    private static PrintAccessor printAccessor;

    static {
        forceInit(Printer.class);
    }

    private PrintHelper() {
    }

    public static PrintResolution createPrintResolution(int fr, int cfr) {
        return printAccessor.createPrintResolution(fr, cfr);
    }

    public static Paper createPaper(String paperName,
                             double paperWidth,
                             double paperHeight,
                             Units units) {
        return printAccessor.createPaper(paperName, paperWidth, paperHeight, units);
    }

    public static PaperSource createPaperSource(String name) {
        return printAccessor.createPaperSource(name);
    }

    public static JobSettings createJobSettings(Printer printer) {
        return printAccessor.createJobSettings(printer);
    }

    public static Printer createPrinter(PrinterImpl impl) {
        return printAccessor.createPrinter(impl);
    }

    public static PrinterImpl getPrinterImpl(Printer printer) {
        return printAccessor.getPrinterImpl(printer);
    }

    public static void setPrintAccessor(final PrintAccessor newAccessor) {
        if (printAccessor != null) {
            throw new IllegalStateException();
        }

        printAccessor = newAccessor;
    }

    public interface PrintAccessor {
        PrintResolution createPrintResolution(int fr, int cfr);

        Paper createPaper(String paperName,
                                          double paperWidth,
                                          double paperHeight,
                                          Units units);

        PaperSource createPaperSource(String name);

        JobSettings createJobSettings(Printer printer);

        Printer createPrinter(PrinterImpl impl);

        PrinterImpl getPrinterImpl(Printer printer);
    }

    private static void forceInit(final Class<?> classToInit) {
        try {
            Class.forName(classToInit.getName(), true,
                          classToInit.getClassLoader());
        } catch (final ClassNotFoundException e) {
            throw new AssertionError(e);  // Can't happen
        }
    }
}
