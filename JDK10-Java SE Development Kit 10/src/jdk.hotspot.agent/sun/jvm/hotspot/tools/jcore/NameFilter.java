/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.tools.jcore;

import sun.jvm.hotspot.oops.*;
import java.util.regex.*;

public class NameFilter implements ClassFilter
{
    public Pattern includePattern;

    public NameFilter() {
        this(System.getProperty("sun.jvm.hotspot.tools.jcore.NameFilter.pattern"));
    }

    public NameFilter(String pattern) {
        if (pattern == null) pattern = "*";
        includePattern = Pattern.compile(pattern);
    }

    public boolean canInclude(InstanceKlass kls) {
        String klassName = kls.getName().asString().replace('/', '.');
        Matcher m = includePattern.matcher(klassName);
        return m.matches();
    }
}
