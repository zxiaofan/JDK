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

package sun.print;

import java.awt.print.PrinterJob;
import javax.print.attribute.Attribute;
import javax.print.attribute.PrintRequestAttribute;

public class PrinterJobWrapper implements PrintRequestAttribute {

    private static final long serialVersionUID = -8792124426995707237L;

    private PrinterJob job;

    public PrinterJobWrapper(PrinterJob job) {
        this.job = job;
    }

    public PrinterJob getPrinterJob() {
        return job;
    }

    public final Class<? extends Attribute> getCategory() {
        return PrinterJobWrapper.class;
    }

    public final String getName() {
        return "printerjob-wrapper";
    }

    public String toString() {
       return "printerjob-wrapper: " + job.toString();
    }

    public int hashCode() {
        return job.hashCode();
    }
}
