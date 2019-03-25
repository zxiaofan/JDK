/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.cs.ext;

import java.nio.charset.Charset;
import sun.nio.cs.*;

public class MS50221 extends MS50220
{
    public MS50221() {
        super("x-windows-50221",
              ExtendedCharsets.aliasesFor("x-windows-50221"));
    }

    public String historicalName() {
        return "MS50221";
    }

    public boolean contains(Charset cs) {
      return super.contains(cs) ||
             (cs instanceof JIS_X_0212) ||
             (cs instanceof MS50221);
    }

    protected boolean doSBKANA() {
        return true;
    }
}
