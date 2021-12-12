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
import java.util.Optional;

// Corresponds <condition>
final class XmlCondition extends XmlExpression implements ControlElement {

    @Override
    public String getName() {
        return attribute("name");
    }

    public Result getTrueValue() {
        return Result.of(attribute("true"));
    }

    public Result getFalseValue() {
        return Result.of(attribute("false"));
    }

    @Override
    protected void validateChildConstraints() throws ParseException {
        if (getExpressions().size() > 1) {
            throw new ParseException("Expected <condition> to not have more than one child", -1);
        }
    }

    @Override
    protected List<String> attributes() {
        return List.of("name");
    }

    @Override
    protected Result evaluate() {
        Optional<String> trueValue = optional("true");
        Optional<String> falseValue = optional("false");
        for (XmlElement producer : getProducers()) {
            Result r = producer.evaluate();
            if (trueValue.isPresent() && r.isTrue()) {
                return getTrueValue();
            }
            if (falseValue.isPresent() && r.isFalse()) {
                return getFalseValue();
            }
        }
        return Result.NULL;
    }
}
