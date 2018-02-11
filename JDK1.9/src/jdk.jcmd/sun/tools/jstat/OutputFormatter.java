/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jstat;

import sun.jvmstat.monitor.MonitorException;

/**
 * An interface for the JStatLogger formatting.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public interface OutputFormatter {

    /**
     * get the header row that describes the data in the columns
     */
    String getHeader() throws MonitorException;

    /**
     * get the data row.
     */
    String getRow() throws MonitorException;
}
