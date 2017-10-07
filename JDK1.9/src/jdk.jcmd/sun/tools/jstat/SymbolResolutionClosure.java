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

import java.text.*;
import sun.jvmstat.monitor.MonitorException;

/**
 * A class implementing the Closure interface which is used to resolve
 * all the symbols in the expressions contained in ColumnFormat objects.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class SymbolResolutionClosure implements Closure {
    private static final boolean debug =
            Boolean.getBoolean("SymbolResolutionClosure.debug");

    private ExpressionEvaluator ee;

    public SymbolResolutionClosure(ExpressionEvaluator ee) {
        this.ee = ee;
    }

    public void visit(Object o, boolean hasNext) throws MonitorException {
        if (! (o instanceof ColumnFormat)) {
            return;
        }

        ColumnFormat c = (ColumnFormat)o;
        Expression e = c.getExpression();
        String previous = e.toString();
        e = (Expression)ee.evaluate(e);
        if (debug) {
            System.out.print("Expression: " + previous + " resolved to "
                             + e.toString());
        }
        c.setExpression(e);
    }
}
