/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Set;

import javafx.geometry.Rectangle2D;

import javafx.print.JobSettings;
import javafx.print.Printer;
import javafx.print.Collation;
import javafx.print.PageRange;
import javafx.print.Paper;
import javafx.print.PaperSource;
import javafx.print.PrintColor;
import javafx.print.PageOrientation;
import javafx.print.PrintQuality;
import javafx.print.PrintResolution;
import javafx.print.PrintSides;

/*
 * This is called 'PrinterImpl' not because it is a class implementing
 * features of a superclass, but because its defines the interfaces
 * required of the delegate implementation class for a Printer.
 * The actual implementation class needs to be discovered at runtime.
 */
public interface PrinterImpl {

    public void setPrinter(Printer printer);

    public String getName();

    public JobSettings getDefaultJobSettings();

    public Rectangle2D printableArea(Paper paper);

    public int defaultCopies();
    public int maxCopies();

    public Collation defaultCollation();
    public Set<Collation> supportedCollations();

    public PrintSides defaultSides();
    public Set<PrintSides> supportedSides();

    public PageRange defaultPageRange();
    public boolean supportsPageRanges();

    public PrintResolution defaultPrintResolution();
    public Set<PrintResolution> supportedPrintResolution();

    public PrintColor defaultPrintColor();
    public Set<PrintColor> supportedPrintColor();

    public PrintQuality defaultPrintQuality();
    public Set<PrintQuality> supportedPrintQuality();

    public PageOrientation defaultOrientation();
    public Set<PageOrientation> supportedOrientation();

    public Paper defaultPaper();
    public Set<Paper> supportedPapers();

    public PaperSource defaultPaperSource();
    public Set<PaperSource> supportedPaperSources();

}
