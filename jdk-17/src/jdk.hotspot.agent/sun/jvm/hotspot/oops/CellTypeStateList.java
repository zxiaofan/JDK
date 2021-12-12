/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.oops;

import java.util.*;

/** Auxiliary class for GenerateOopMap */
public class CellTypeStateList {
  public CellTypeStateList(int size) {
    list = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      list.add(i, CellTypeState.makeBottom());
    }
  }

  public int size() {
    return list.size();
  }

  public CellTypeState get(int i) {
    return list.get(i);
  }

  public CellTypeStateList subList(int fromIndex, int toIndex) {
    return new CellTypeStateList(list.subList(fromIndex, toIndex));
  }

  //----------------------------------------------------------------------
  private List<CellTypeState> list;
  private CellTypeStateList(List<CellTypeState> list) {
    this.list = list;
  }
}
