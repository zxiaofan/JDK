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

import java.util.*;

/**
 * Dummy implementation for ScriptObject interface. This class
 * supports empty set of named and indexed properties. Returns
 * false always for "has" calls. And ignores "delete" and "put"
 * calls.
 */
public class DefaultScriptObject implements ScriptObject {
  public Object[] getIds() {
    return EMPTY_ARRAY;
  }

  public Object get(String name) {
    return UNDEFINED;
  }

  public Object get(int index) {
    return UNDEFINED;
  }

  public void put(String name, Object value) {
  }

  public void put(int index, Object value) {
  }

  public boolean has(String name) {
    return false;
  }

  public boolean has(int index) {
    return false;
  }

  public boolean delete(String name) {
    return false;
  }

  public boolean delete(int index) {
    return false;
  }
}
