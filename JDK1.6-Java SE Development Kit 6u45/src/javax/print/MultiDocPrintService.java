/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.print;

import java.util.Map;

import javax.print.attribute.Attribute;
import javax.print.event.PrintServiceAttributeListener;


 /** Interface MultiPrintService is the factory for a MultiDocPrintJob.
  * A MultiPrintService
  * describes the capabilities of a Printer and can be queried regarding
  * a printer's supported attributes.
  */
public interface MultiDocPrintService extends PrintService {
     
    /**
     * Create a job which can print a multiDoc.
     * @return a MultiDocPrintJob
     */
    public MultiDocPrintJob createMultiDocPrintJob();

}
