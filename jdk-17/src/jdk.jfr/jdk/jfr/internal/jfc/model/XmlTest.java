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

// Corresponds to <test>
final class XmlTest extends XmlExpression {

    public String getName() {
        return attribute("name");
    }

    public String getOperator() {
        return attribute("operator");
    }

    public String getValue() {
        return attribute("value");
    }

    @Override
    boolean isEntity() {
        return false;
    }

    @Override
    protected List<String> attributes() {
        return List.of("name", "operator", "value");
    }

    @Override
    protected void validateChildConstraints() throws ParseException {
        if (!getExpressions().isEmpty()) {
            throw new ParseException("Expected <test> to not have child elements", 0);
        }
    }

    @Override
    protected void validateAttributes() throws ParseException {
        super.validateAttributes();
        if (!getOperator().equalsIgnoreCase("equal")) {
            throw new ParseException("Unknown operator '" + getOperator() + "', only supported is 'equal'", 0);
        }
    }

    @Override
    protected Result evaluate() {
        Result ret = Result.NULL;
        List<XmlElement> producers = getProducers();
        if (!producers.isEmpty()) {
            XmlElement producer = producers.get(0);
            Result r = producer.evaluate();
            if (!r.isNull()) {
                ret = getValue().equals(r.value()) ? Result.TRUE : Result.FALSE;
            }

        }
        return ret;
    }
}
