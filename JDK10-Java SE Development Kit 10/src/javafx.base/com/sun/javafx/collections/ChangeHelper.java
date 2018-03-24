/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.collections;

import java.util.Arrays;
import java.util.List;

public class ChangeHelper {
    public static String addRemoveChangeToString(int from, int to, List<?> list, List<?> removed) {
        StringBuilder b = new StringBuilder();

        if (removed.isEmpty()) {
            b.append(list.subList(from, to));
            b.append(" added at ").append(from);
        } else {
            b.append(removed);
            if (from == to) {
                b.append(" removed at ").append(from);
            } else {
                b.append(" replaced by ");
                b.append(list.subList(from, to));
                b.append(" at ").append(from);
            }
        }
        return b.toString();
    }

    public static String permChangeToString(int[] permutation) {
        return "permutated by " + Arrays.toString(permutation);
    }

    public static String updateChangeToString(int from, int to) {
        return "updated at range [" + from + ", " + to + ")";
    }
}
