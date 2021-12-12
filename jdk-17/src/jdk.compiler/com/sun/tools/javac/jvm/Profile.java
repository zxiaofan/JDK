/*
 * Copyright (c) 2002, 2019, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.jvm;

import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Options;
import java.util.EnumSet;
import java.util.Set;

import static com.sun.tools.javac.main.Option.PROFILE;

/** The target profile.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public enum Profile {
    COMPACT1("compact1", 1, Target.JDK1_8),
    COMPACT2("compact2", 2, Target.JDK1_8),
    COMPACT3("compact3", 3, Target.JDK1_8),

    DEFAULT {
        @Override
        public boolean isValid(Target t) {
            return true;
        }
    };

    private static final Context.Key<Profile> profileKey = new Context.Key<>();

    public static Profile instance(Context context) {
        Profile instance = context.get(profileKey);
        if (instance == null) {
            Options options = Options.instance(context);
            String profileString = options.get(PROFILE);
            if (profileString != null) instance = lookup(profileString);
            if (instance == null) instance = DEFAULT;
            context.put(profileKey, instance);
        }
        return instance;
    }

    public final String name;
    public final int value;
    final Set<Target> targets;

    Profile() {
        name = null;
        value = Integer.MAX_VALUE;
        targets = null;
    }

    Profile(String name, int value, Target t, Target... targets) {
        this.name = name;
        this.value = value;
        this.targets = EnumSet.of(t, targets);
    }

    public static Profile lookup(String name) {
        // the set of values is small enough to do linear search
        for (Profile p: values()) {
            if (name.equals(p.name))
                return p;
        }
        return null;
    }

    public static Profile lookup(int value) {
        // the set of values is small enough to do linear search
        for (Profile p: values()) {
            if (value == p.value)
                return p;
        }
        return null;
    }

    public boolean isValid(Target t) {
        return targets.contains(t);
    }
}
