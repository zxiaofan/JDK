/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import jdk.jfr.internal.SecuritySupport.SafePath;

// This class keeps track of files that can't be deleted
// so they can a later staged be removed.
final class FilePurger {

    private static final Set<SafePath> paths = new LinkedHashSet<>();

    public synchronized static void add(SafePath p) {
        paths.add(p);
        if (paths.size() > 1000) {
            removeOldest();
        }
    }

    public synchronized static void purge() {
        if (paths.isEmpty()) {
            return;
        }

        for (SafePath p : new ArrayList<>(paths)) {
            if (delete(p)) {
                paths.remove(p);
            }
        }
    }

    private static void removeOldest() {
        SafePath oldest = paths.iterator().next();
        paths.remove(oldest);
    }

    private static boolean delete(SafePath p) {
        try {
            SecuritySupport.delete(p);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
