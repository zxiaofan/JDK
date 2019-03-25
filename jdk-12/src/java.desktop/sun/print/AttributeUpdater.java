/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package sun.print;

import javax.print.attribute.PrintServiceAttributeSet;

/*
 * For use in updating listeners on attribute set changes.
 * Services which support this will report just the attributes changed
 * since the last call on this method. There should only be one client of
 * this method on a particular print service.
 * It is used to reduce the work in event notification: ie the callee can
 * better optimise the returned value than could the caller by sifting
 * through all attributes.
 */
interface AttributeUpdater {
  PrintServiceAttributeSet getUpdatedAttributes();
}
