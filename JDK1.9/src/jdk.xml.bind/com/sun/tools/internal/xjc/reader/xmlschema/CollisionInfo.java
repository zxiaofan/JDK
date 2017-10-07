/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.xmlschema;

import org.xml.sax.Locator;

/**
 * Details of a name collision.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
final class CollisionInfo {
    private final String name;
    private final Locator source1;
    private final Locator source2;

    public CollisionInfo(String name, Locator source1, Locator source2) {
        this.name = name;
        this.source1 = source1;
        this.source2 = source2;
    }

    /**
     * Returns a localized message that describes the collision.
     */
    public String toString() {
        return Messages.format( Messages.MSG_COLLISION_INFO,
                name, printLocator(source1), printLocator(source2) );
    }

    private String printLocator(Locator loc) {
        if( loc==null )     return "";

        int line = loc.getLineNumber();
        String sysId = loc.getSystemId();
        if(sysId==null)     sysId = Messages.format(Messages.MSG_UNKNOWN_FILE);

        if( line!=-1 )
            return Messages.format( Messages.MSG_LINE_X_OF_Y,
                    Integer.toString(line), sysId );
        else
            return sysId;
    }
}
