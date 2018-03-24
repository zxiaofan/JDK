/*
 * Copyright (c) 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.ch;

/**
 * Represents the level/name of a socket option
 */

class OptionKey {
    private int level;
    private int name;

    OptionKey(int level, int name) {
        this.level = level;
        this.name = name;
    }

    int level() {
        return level;
    }

    int name() {
        return name;
    }
}
