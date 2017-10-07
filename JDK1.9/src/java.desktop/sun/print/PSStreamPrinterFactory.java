/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

import java.io.OutputStream;

import javax.print.DocFlavor;
import javax.print.StreamPrintService;
import javax.print.StreamPrintServiceFactory;

public class PSStreamPrinterFactory extends StreamPrintServiceFactory {

    static final String psMimeType = "application/postscript";

    static final DocFlavor[] supportedDocFlavors = {
         DocFlavor.SERVICE_FORMATTED.PAGEABLE,
         DocFlavor.SERVICE_FORMATTED.PRINTABLE,
         DocFlavor.BYTE_ARRAY.GIF,
         DocFlavor.INPUT_STREAM.GIF,
         DocFlavor.URL.GIF,
         DocFlavor.BYTE_ARRAY.JPEG,
         DocFlavor.INPUT_STREAM.JPEG,
         DocFlavor.URL.JPEG,
         DocFlavor.BYTE_ARRAY.PNG,
         DocFlavor.INPUT_STREAM.PNG,
         DocFlavor.URL.PNG,
    };

    public  String getOutputFormat() {
        return psMimeType;
    }

    public DocFlavor[] getSupportedDocFlavors() {
        return getFlavors();
    }

    static DocFlavor[] getFlavors() {
        DocFlavor[] flavors = new DocFlavor[supportedDocFlavors.length];
        System.arraycopy(supportedDocFlavors, 0, flavors, 0, flavors.length);
        return flavors;
    }

    public StreamPrintService getPrintService(OutputStream out) {
        return new PSStreamPrintService(out);
    }

}
