/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.management.jfr;
/**
 * Helper class for generating toString()
 *
 */
final class Stringifier {
    private final StringBuilder sb = new StringBuilder();
    private boolean first = true;

    public void add(String name, Object value) {
        if (first) {
            first = false;
        } else {
            sb.append(" ");
        }
        boolean isString = value instanceof String;
        sb.append(name).append("=");
        if (value == null) {
            sb.append("null");
        } else {
            if (isString) {
                sb.append("\"");
            }
            sb.append(value);
            if (isString) {
                sb.append("\"");
            }
        }
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
