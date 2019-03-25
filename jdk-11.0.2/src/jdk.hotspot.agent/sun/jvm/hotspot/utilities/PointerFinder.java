/*
 * Copyright (c) 2000, 2018, Oracle and/or its affiliates. All rights reserved.
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

import sun.jvm.hotspot.code.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.gc.shared.*;
import sun.jvm.hotspot.interpreter.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.memory.*;

/** This class, only intended for use in the debugging system,
    provides the functionality of find() in the VM. */

public class PointerFinder {
  public static PointerLocation find(Address a) {
    PointerLocation loc = new PointerLocation(a);

    CollectedHeap heap = VM.getVM().getUniverse().heap();
    if (heap instanceof GenCollectedHeap) {
      GenCollectedHeap genheap = (GenCollectedHeap) heap;
      if (genheap.isIn(a)) {
        for (int i = 0; i < genheap.nGens(); i++) {
          Generation g = genheap.getGen(i);
          if (g.isIn(a)) {
            loc.gen = g;
            break;
          }
        }

          if (Assert.ASSERTS_ENABLED) {
          Assert.that(loc.gen != null, "Should have found this in a generation");
        }

        if (VM.getVM().getUseTLAB()) {
          // Try to find thread containing it
          for (JavaThread t = VM.getVM().getThreads().first(); t != null; t = t.next()) {
            ThreadLocalAllocBuffer tlab = t.tlab();
            if (tlab.contains(a)) {
              loc.inTLAB = true;
              loc.tlabThread = t;
              loc.tlab = tlab;
              break;
            }
          }
        }

        return loc;
      }
    } else {
      if (heap.isIn(a)) {
        loc.heap = heap;
        return loc;
      }
    }

    Interpreter interp = VM.getVM().getInterpreter();
    if (interp.contains(a)) {
      loc.inInterpreter = true;
      loc.interpreterCodelet = interp.getCodeletContaining(a);
      return loc;
    }

    if (!VM.getVM().isCore()) {
      CodeCache c = VM.getVM().getCodeCache();
      if (c.contains(a)) {
        loc.inCodeCache = true;
        loc.blob = c.findBlobUnsafe(a);
        if (Assert.ASSERTS_ENABLED) {
          Assert.that(loc.blob != null, "Should have found CodeBlob");
        }
        loc.inBlobCode = loc.blob.codeContains(a);
        loc.inBlobData = loc.blob.dataContains(a);

        if (loc.blob.isNMethod()) {
            NMethod nm = (NMethod) loc.blob;
            loc.inBlobOops = nm.oopsContains(a);
        }

        loc.inBlobUnknownLocation = (!(loc.inBlobCode ||
                                       loc.inBlobData ||
                                       loc.inBlobOops));
        return loc;
      }
    }

    // Check JNIHandles; both local and global
    JNIHandles handles = VM.getVM().getJNIHandles();

    // --- looking in oopstorage should model OopStorage::allocation_status?
    // --- that is, if in a block but not allocated, then not valid.

    // Look in global handles
    OopStorage storage = handles.globalHandles();
    if ((storage != null) && storage.findOop(a)) {
      loc.inStrongGlobalJNIHandles = true;
      return loc;
    }
    // Look in weak global handles
    storage = handles.weakGlobalHandles();
    if ((storage != null) && storage.findOop(a)) {
      loc.inWeakGlobalJNIHandles = true;
      return loc;
    }
    // Look in thread-local handles
    for (JavaThread t = VM.getVM().getThreads().first(); t != null; t = t.next()) {
      JNIHandleBlock handleBlock = t.activeHandles();
      if (handleBlock != null) {
        handleBlock = handleBlock.blockContainingHandle(a);
        if (handleBlock != null) {
          loc.inLocalJNIHandleBlock = true;
          loc.handleBlock = handleBlock;
          loc.handleThread = t;
          return loc;
        }
      }
    }

    // Fall through; have to return it anyway.
    return loc;
  }
}
