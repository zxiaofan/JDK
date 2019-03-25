/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.utilities.soql;

/**
   This visitor is supplied to SOQLEngine.executeQuery
   to receive result set objects one by one.
*/

public interface ObjectVisitor {
   public void visit(Object o);
}
