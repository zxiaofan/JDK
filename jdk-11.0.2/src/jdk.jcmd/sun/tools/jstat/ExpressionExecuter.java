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

import java.util.*;
import sun.jvmstat.monitor.*;

/**
 * A class implementing the ExpressionEvaluator to evaluate an expression
 * in the context of the available monitoring data.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class ExpressionExecuter implements ExpressionEvaluator {
    private static final boolean debug =
            Boolean.getBoolean("ExpressionEvaluator.debug");
    private MonitoredVm vm;
    private HashMap<String, Object> map = new HashMap<String, Object>();

    ExpressionExecuter(MonitoredVm vm) {
        this.vm = vm;
    }

    /*
     * evaluate the given expression.
     */
    public Object evaluate(Expression e) {
        if (e == null) {
            return null;
        }

        if (debug) {
            System.out.println("Evaluating expression: " + e);
        }

        if (e instanceof Literal) {
            return ((Literal)e).getValue();
        }

        if (e instanceof Identifier) {
            Identifier id = (Identifier)e;
            if (map.containsKey(id.getName())) {
                return map.get(id.getName());
            } else {
                // cache the data values for coherency of the values over
                // the life of this expression executer.
                Monitor m = (Monitor)id.getValue();
                Object v = m.getValue();
                map.put(id.getName(), v);
                return v;
            }
        }

        Expression l = e.getLeft();
        Expression r = e.getRight();

        Operator op = e.getOperator();

        if (op == null) {
            return evaluate(l);
        } else {
            double lval = ((Number)evaluate(l)).doubleValue();
            double rval = ((Number)evaluate(r)).doubleValue();
            double result = op.eval(lval, rval);
            if (debug) {
                System.out.println("Performed Operation: " + lval + op + rval
                                   + " = " + result);
            }
            return Double.valueOf(result);
        }
    }
}
