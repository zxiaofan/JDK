/*
 * Copyright (c) 2002, 2020, Oracle and/or its affiliates. All rights reserved.
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
import java.util.*;

public class PackageNameFilter implements ClassFilter
{
    public String[] pkgList;

    public PackageNameFilter() {
        // give comma separated list of package names to include
        this(System.getProperty("sun.jvm.hotspot.tools.jcore.PackageNameFilter.pkgList"));
    }

    public PackageNameFilter(String pattern) {
        try {
            StringTokenizer st = new StringTokenizer(pattern, ",");
            List<String> l = new LinkedList<>();
            while (st.hasMoreTokens()) {
                l.add(st.nextToken());
            }
            pkgList = l.toArray(new String[0]);
        } catch (Exception exp) {
           exp.printStackTrace();
        }
    }

    public boolean canInclude(InstanceKlass kls) {
        if (pkgList == null) {
            // Dump everything
            return true;
        }
        final int len = pkgList.length;
        if (len == 0)
            return true;
        String klassName = kls.getName().asString().replace('/', '.');
        for (int i=0; i < len; i++)
            if (klassName.startsWith(pkgList[i] )) return true;
        return false;
    }
}
