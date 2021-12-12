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

package sun.print;

import java.awt.print.PrinterJob;

public class PlatformPrinterJobProxy {

   public static PrinterJob getPrinterJob() {
       return new sun.awt.windows.WPrinterJob();
   }
}


