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

/**
 * An Expression subclass that describes the constant operands of an
 * expression. Objects of this type are always leaves of an expression tree.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class Literal extends Expression {

    private Object value;

    public Literal(Object value) {
        super();
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String toString() {
        return value.toString();
    }
}
