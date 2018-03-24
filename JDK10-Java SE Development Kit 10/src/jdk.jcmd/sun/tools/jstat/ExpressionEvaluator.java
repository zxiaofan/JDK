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
 * An interface to allow an object to visit an Expression object and
 * evaluate based on some context.
 *
 * @author Brian Doherty
 * @since 1.5
 */
interface ExpressionEvaluator {
    Object evaluate(Expression e) throws MonitorException;
}
