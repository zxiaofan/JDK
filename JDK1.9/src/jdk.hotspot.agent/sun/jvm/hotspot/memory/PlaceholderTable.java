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

package sun.jvm.hotspot.memory;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.utilities.*;

public class PlaceholderTable extends TwoOopHashtable {
  public PlaceholderTable(Address addr) {
    super(addr);
  }

  // this is overriden here so that Hashtable.bucket will return
  // object of PlacholderEntry.class
  protected Class getHashtableEntryClass() {
    return PlaceholderEntry.class;
  }

  /** All array classes of primitive type, and their class loaders */
  public void primArrayClassesDo(SystemDictionary.ClassAndLoaderVisitor v) {
    ObjectHeap heap = VM.getVM().getObjectHeap();
    int tblSize = tableSize();
    for (int index = 0; index < tblSize; index++) {
      for (PlaceholderEntry probe = (PlaceholderEntry) bucket(index); probe != null;
                                          probe = (PlaceholderEntry) probe.next()) {
        Symbol sym = probe.klass();
        // array of primitive arrays are stored in system dictionary as placeholders
        FieldType ft = new FieldType(sym);
        if (ft.isArray()) {
          FieldType.ArrayInfo info = ft.getArrayInfo();
          if (info.elementBasicType() != BasicType.getTObject()) {
            Klass arrayKlass = heap.typeArrayKlassObj(info.elementBasicType());
            arrayKlass = arrayKlass.arrayKlassOrNull(info.dimension());
            v.visit(arrayKlass, probe.loader());
          }
        }
      }
    }
  }
}
