/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.utilities.soql;

import javax.script.ScriptException;

/**
 * This interface is used to represent "function" valued
 * properties in ScriptObjects.
 */
public interface Callable {
  /**
   * Call the underlying function passing the given
   * arguments and return the result.
   */
  public Object call(Object[] args) throws ScriptException;
}
