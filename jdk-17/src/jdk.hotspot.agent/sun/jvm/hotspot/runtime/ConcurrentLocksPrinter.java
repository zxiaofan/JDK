/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.oops.*;

public class ConcurrentLocksPrinter {
    private Map<JavaThread, List<Oop>> locksMap = new HashMap<>();

    public ConcurrentLocksPrinter() {
        fillLocks();
    }

    public void print(JavaThread jthread, PrintStream tty) {
        List<Oop> locks = locksMap.get(jthread);
        tty.println("Locked ownable synchronizers:");
        if (locks == null || locks.isEmpty()) {
            tty.println("    - None");
        } else {
            for (Iterator<Oop> itr = locks.iterator(); itr.hasNext();) {
                Oop oop = itr.next();
                tty.println("    - <" + oop.getHandle() + ">, (a " +
                       oop.getKlass().getName().asString() + ")");
            }
        }
    }

    //-- Internals only below this point
    private JavaThread getOwnerThread(Oop oop) {
        Oop threadOop = OopUtilities.abstractOwnableSynchronizerGetOwnerThread(oop);
        if (threadOop == null) {
            return null;
        } else {
            return OopUtilities.threadOopGetJavaThread(threadOop);
        }
    }

    private void fillLocks() {
        VM vm = VM.getVM();
        SystemDictionary sysDict = vm.getSystemDictionary();
        Klass absOwnSyncKlass = sysDict.getAbstractOwnableSynchronizerKlass();
        ObjectHeap heap = vm.getObjectHeap();
        // may be not loaded at all
        if (absOwnSyncKlass != null) {
            heap.iterateObjectsOfKlass(new DefaultHeapVisitor() {
                    public boolean doObj(Oop oop) {
                        JavaThread thread = getOwnerThread(oop);
                        if (thread != null) {
                            List<Oop> locks = locksMap.get(thread);
                            if (locks == null) {
                                locks = new LinkedList<>();
                                locksMap.put(thread, locks);
                            }
                            locks.add(oop);
                        }
                        return false;
                    }

                }, absOwnSyncKlass, true);
        }
    }
}
