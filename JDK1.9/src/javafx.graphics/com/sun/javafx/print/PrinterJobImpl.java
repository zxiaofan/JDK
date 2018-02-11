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

import javafx.print.PageLayout;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.stage.Window;

/**
 * Printer implementations implement these methods.
 */
public interface PrinterJobImpl {

    public PrinterImpl getPrinterImpl();
    public void setPrinterImpl(PrinterImpl printerImpl);

    public boolean showPrintDialog(Window owner);
    public boolean showPageDialog(Window owner);

    public PageLayout validatePageLayout(PageLayout pageLayout);
    public boolean print(PageLayout pageLayout, Node node);

    public boolean endJob();
    public void cancelJob();
}
