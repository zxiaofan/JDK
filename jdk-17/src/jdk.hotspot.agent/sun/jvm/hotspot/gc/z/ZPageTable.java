/*
 * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.gc.z;

import java.util.Iterator;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMObject;
import sun.jvm.hotspot.runtime.VMObjectFactory;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class ZPageTable extends VMObject {
    private static long mapFieldOffset;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    static private synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZPageTable");

        mapFieldOffset = type.getAddressField("_map").getOffset();
    }

    public ZPageTable(Address addr) {
        super(addr);
    }

    private ZGranuleMapForPageTable map() {
        return (ZGranuleMapForPageTable)VMObjectFactory.newObject(ZGranuleMapForPageTable.class, addr.addOffsetTo(mapFieldOffset));
    }

    private ZPageTableEntry getEntry(Address o) {
        return new ZPageTableEntry(map().get(o));
    }

    ZPage get(Address o) {
        return VMObjectFactory.newObject(ZPage.class, map().get(VM.getVM().getDebugger().newAddress(ZAddress.offset(o))));
    }

    boolean is_relocating(Address o) {
        return getEntry(o).relocating();
    }

    private class ZPagesIterator implements Iterator<ZPage> {
        private ZGranuleMapForPageTable.Iterator mapIter;
        private ZPage next;

        ZPagesIterator() {
            mapIter = map().new Iterator();
            positionToNext();
        }

        private ZPage positionToNext() {
            ZPage current = next;

            // Find next
            ZPage found = null;
            while (mapIter.hasNext()) {
                ZPageTableEntry entry = new ZPageTableEntry(mapIter.next());
                if (!entry.isEmpty()) {
                    ZPage page = entry.page();
                    // Medium pages have repeated entries for all covered slots,
                    // therefore we need to compare against the current page.
                    if (page != null && !page.equals(current)) {
                        found = page;
                        break;
                    }
                }
            }

            next = found;

            return current;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public ZPage next() {
            return positionToNext();
        }

        @Override
        public void remove() {
            /* not supported */
        }
    }

    abstract class ZPageFilter {
        public abstract boolean accept(ZPage page);
    }

    class ZPagesFilteredIterator implements Iterator<ZPage> {
        private ZPage next;
        private ZPagesIterator iter = new ZPagesIterator();
        private ZPageFilter filter;

        ZPagesFilteredIterator(ZPageFilter filter) {
            this.filter = filter;
            positionToNext();
        }

        public ZPage positionToNext() {
            ZPage current = next;

            // Find next
            ZPage found = null;
            while (iter.hasNext()) {
                ZPage page = iter.next();
                if (filter.accept(page)) {
                    found = page;
                    break;
                }
            }

            next = found;

            return current;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public ZPage next() {
            return positionToNext();
        }

        @Override
        public void remove() {
            /* not supported */
        }
    }

    public Iterator<ZPage> iterator() {
        return new ZPagesIterator();
    }

    public Iterator<ZPage> activePagesIterator() {
        return new ZPagesFilteredIterator(new ZPageFilter() {
            public boolean accept(ZPage page) {
                return page != null;
            }
        });
    }
}
