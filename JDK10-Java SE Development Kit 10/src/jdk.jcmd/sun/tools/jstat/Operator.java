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


/**
 * A typesafe enumeration for describing mathematical operators.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public abstract class Operator {

    private static int nextOrdinal = 0;
    private static HashMap<String, Operator> map = new HashMap<String, Operator>();

    private final String name;
    private final int ordinal = nextOrdinal++;

    private Operator(String name) {
        this.name = name;
        map.put(name, this);
    }

    protected abstract double eval(double x, double y);

    /* Operator '+' */
    public static final Operator PLUS = new Operator("+") {
        protected double eval(double x, double y) {
            return x + y;
        }
    };

    /* Operator '-' */
    public static final Operator MINUS = new Operator("-") {
        protected double eval(double x, double y) {
            return x - y;
        }
    };

    /* Operator '/' */
    public static final Operator DIVIDE = new Operator("/") {
        protected double eval(double x, double y) {
            if (y == 0) {
                return Double.NaN;
            }
            return x / y;
        }
    };

    /* Operator '*' */
    public static final Operator MULTIPLY = new Operator("*") {
        protected double eval(double x, double y) {
            return x * y;
        }
    };

    /**
     * Returns the string representation of this Operator object.
     *
     * @return  the string representation of this Operator object
     */
    public String toString() {
        return name;
    }

    /**
     * Maps a string to its corresponding Operator object.
     *
     * @param   s  an string to match against Operator objects.
     * @return     The Operator object matching the given string.
     */
    public static Operator toOperator(String s) {
        return map.get(s);
    }

    /**
     * Returns an enumeration of the keys for this enumerated type
     *
     * @param   s  an string to match against Operator objects.
     * @return     The Operator object matching the given string.
     */
    protected static Set<?> keySet() {
        return map.keySet();
    }
}
