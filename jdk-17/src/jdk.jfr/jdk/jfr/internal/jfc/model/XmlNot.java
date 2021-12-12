/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.internal.jfc.model;

import java.text.ParseException;
import java.util.List;

// Corresponds to <not>
final class XmlNot extends XmlExpression {

    @Override
    boolean isEntity() {
        return false;
    }

    @Override
    protected void validateChildConstraints() throws ParseException {
        if (getExpressions().size() != 1) {
            throw new ParseException("Expected <not> to have a single child", 0);
        }
    }

    @Override
    protected Result evaluate() {
        List<XmlElement> producers = getProducers();
        if (!producers.isEmpty()) {
            Result r = producers.get(0).evaluate();
            if (!r.isNull()) {
                return r.isTrue() ? Result.FALSE : Result.TRUE;
            }
        }
        return Result.NULL;
    }
}
