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

package com.sun.javafx.tk;

import java.lang.reflect.Method;
import javafx.collections.ObservableSet;
import javafx.print.Printer;
import javafx.print.PrinterJob;

import javafx.print.Printer;
import com.sun.javafx.print.PrinterJobImpl;

public abstract class PrintPipeline {

    private static PrintPipeline ppl = null;

    public static PrintPipeline getPrintPipeline() {
        if (ppl != null) {
            return ppl;
        }
        try {
            String className = "com.sun.prism.j2d.PrismPrintPipeline";
            Class klass = Class.forName(className);
            Method m = klass.getMethod("getInstance", (Class[])null);
            ppl = (PrintPipeline)m.invoke(null, (Object[])null);
            return ppl;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public abstract Printer getDefaultPrinter();
    public abstract ObservableSet<Printer> getAllPrinters();
    public abstract PrinterJobImpl createPrinterJob(PrinterJob job);
}
