/*
 * Copyright (c) 1994, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.asm;

import sun.tools.java.*;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Arrays;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public final
class SwitchData {
    int minValue, maxValue;
    Label defaultLabel = new Label();
    Hashtable<Integer, Label> tab = new Hashtable<>();
// JCOV
    Hashtable<Integer, Long> whereCaseTab = null;
// end JCOV

    /**
     * Get a label
     */
    public Label get(int n) {
        return tab.get(n);
    }

    /**
     * Get a label
     */
    public Label get(Integer n) {
        return tab.get(n);
    }

    /**
     * Add a label
     */
    public void add(int n, Label lbl) {
        if (tab.size() == 0) {
            minValue = n;
            maxValue = n;
        } else {
            if (n < minValue) {
                minValue = n;
            }
            if (n > maxValue) {
                maxValue = n;
            }
        }
        tab.put(Integer.valueOf(n), lbl);
    }

    /**
     * Get the default label
     */
    public Label getDefaultLabel() {
        return defaultLabel;
    }

    /**
     * Return the keys of this enumaration sorted in ascending order
     */
    public synchronized Enumeration<Integer> sortedKeys() {
        return new SwitchDataEnumeration(tab);
    }

// JCOV
    public void initTableCase() {
        whereCaseTab = new Hashtable<Integer, Long>();
    }
    public void addTableCase(int index, long where) {
        if (whereCaseTab != null)
            whereCaseTab.put(Integer.valueOf(index), Long.valueOf(where));
    }
    // this puts String key into Hashtable<Integer, Long>
    @SuppressWarnings("unchecked")
    public void addTableDefault(long where) {
        if (whereCaseTab != null)
            ((Hashtable)whereCaseTab).put("default", Long.valueOf(where));
    }
    public long whereCase(Object key) {
        Long i = whereCaseTab.get(key);
        return (i == null) ? 0L : i.longValue();
    }
    public boolean getDefault() {
         return (whereCase("default") != 0L);
    }
// end JCOV
}

class SwitchDataEnumeration implements Enumeration<Integer> {
    private Integer table[];
    private int current_index = 0;

    /**
     * Create a new enumeration from the hashtable.  Each key in the
     * hash table will be an Integer, with the value being a label.  The
     * enumeration returns the keys in sorted order.
     */
    SwitchDataEnumeration(Hashtable<Integer, Label> tab) {
        table = new Integer[tab.size()];
        int i = 0;
        for (Enumeration<Integer> e = tab.keys() ; e.hasMoreElements() ; ) {
            table[i++] = e.nextElement();
        }
        Arrays.sort(table);
        current_index = 0;
    }

    /**
     * Are there more keys to return?
     */
    public boolean hasMoreElements() {
        return current_index < table.length;
    }

    /**
     * Return the next key.
     */
    public Integer nextElement() {
        return table[current_index++];
    }
}
