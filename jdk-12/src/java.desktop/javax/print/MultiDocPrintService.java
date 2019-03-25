/*
 * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.print;

/**
 * Interface {@code MultiPrintService} is the factory for a
 * {@code MultiDocPrintJob}. A {@code MultiPrintService} describes the
 * capabilities of a printer and can be queried regarding a printer's supported
 * attributes.
 */
public interface MultiDocPrintService extends PrintService {

    /**
     * Create a job which can print a multiDoc.
     *
     * @return a {@code MultiDocPrintJob}
     */
    public MultiDocPrintJob createMultiDocPrintJob();
}
