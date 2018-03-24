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
 */

package sun.jvm.hotspot.utilities;

import java.util.Iterator;

/** An Iterator which wraps another and prevents the "remove" method
    from being called */

public class ConstIterator implements Iterator {
  private Iterator iter;

  public ConstIterator(Iterator iter) {
    this.iter = iter;
  }

  public boolean hasNext() {
    return iter.hasNext();
  }

  public Object next() {
    return iter.next();
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }
}
