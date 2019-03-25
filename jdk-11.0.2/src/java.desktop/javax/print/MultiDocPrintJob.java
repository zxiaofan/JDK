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

import javax.print.attribute.PrintRequestAttributeSet;

/**
 * Obtained from a {@code MultiDocPrintService}, a {@code MultiDocPrintJob} can
 * print a specified collection of documents as a single print job with a set of
 * job attributes.
 */
public interface MultiDocPrintJob extends DocPrintJob {

    /**
     * Print a {@code MultiDoc} with the specified job attributes. This method
     * should only be called once for a given print job. Calling it again will
     * not result in a new job being spooled to the printer. The service
     * implementation will define policy for service interruption and recovery.
     * Application clients which want to monitor the success or failure should
     * register a {@code PrintJobListener}.
     *
     * @param  multiDoc the documents to be printed. ALL must be a flavor
     *         supported by the PrintJob {@literal &} PrintService.
     * @param  attributes the job attributes to be applied to this print job. If
     *         this parameter is {@code null} then the default attributes are
     *         used.
     * @throws PrintException the exception additionally may implement an
     *         interfaces which more precisely describes the cause of the
     *         exception
     *         <ul>
     *           <li>{@code FlavorException}. If the document has a flavor not
     *           supported by this print job.
     *           <li>{@code AttributeException}. If one or more of the
     *           attributes are not valid for this print job.
     *         </ul>
     */
    public void print(MultiDoc multiDoc, PrintRequestAttributeSet attributes)
                throws PrintException;
}
