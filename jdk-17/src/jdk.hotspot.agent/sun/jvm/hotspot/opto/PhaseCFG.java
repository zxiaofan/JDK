/*
 * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.opto;

import java.util.*;
import java.io.PrintStream;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class PhaseCFG extends Phase {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("PhaseCFG");
    numBlocksField = new CIntField(type.getCIntegerField("_number_of_blocks"), 0);
    blocksField = type.getAddressField("_blocks");
    bbsField = type.getAddressField("_node_to_block_mapping");
    brootField = type.getAddressField("_root_block");
  }

  private static CIntField numBlocksField;
  private static AddressField blocksField;
  private static AddressField bbsField;
  private static AddressField brootField;

  public PhaseCFG(Address addr) {
    super(addr);
  }

  public void dump(PrintStream out) {
    int addressSize = (int)VM.getVM().getAddressSize();
    int numBlocks = (int)numBlocksField.getValue(getAddress());
    Block_List blocks = new Block_List(getAddress().addOffsetTo(blocksField.getOffset()));
    int offset = 0;
    for (int i  = 0; i < numBlocks; i++) {
      blocks.at(i).dump(out);
    }
  }
}
