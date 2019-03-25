/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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



package org.graalvm.compiler.hotspot.replacements.arraycopy;

import static org.graalvm.compiler.hotspot.GraalHotSpotVMConfigBase.INJECTED_VMCONFIG;

import org.graalvm.compiler.hotspot.replacements.HotSpotReplacementsUtil;
import org.graalvm.compiler.hotspot.word.KlassPointer;
import org.graalvm.compiler.replacements.arraycopy.ArrayCopySnippets;
import org.graalvm.compiler.word.Word;
import jdk.internal.vm.compiler.word.Pointer;
import jdk.internal.vm.compiler.word.WordFactory;

public class HotSpotArraycopySnippets extends ArrayCopySnippets {

    @Override
    public Pointer loadHub(Object nonNullSrc) {
        return HotSpotReplacementsUtil.loadHub(nonNullSrc).asWord();
    }

    @Override
    public Word getSuperCheckOffset(Pointer destElemKlass) {
        return WordFactory.signed(destElemKlass.readInt(HotSpotReplacementsUtil.superCheckOffsetOffset(INJECTED_VMCONFIG), HotSpotReplacementsUtil.KLASS_SUPER_CHECK_OFFSET_LOCATION));
    }

    @Override
    public int getReadLayoutHelper(Pointer srcHub) {
        return HotSpotReplacementsUtil.readLayoutHelper(KlassPointer.fromWord(srcHub));
    }

    @Override
    public Pointer getDestElemClass(Pointer destKlassPointer) {
        KlassPointer destKlass = (KlassPointer.fromWord(destKlassPointer));
        return destKlass.readKlassPointer(HotSpotReplacementsUtil.arrayClassElementOffset(INJECTED_VMCONFIG),
                        HotSpotReplacementsUtil.OBJ_ARRAY_KLASS_ELEMENT_KLASS_LOCATION).asWord();
    }

    @Override
    protected int heapWordSize() {
        return HotSpotReplacementsUtil.getHeapWordSize(INJECTED_VMCONFIG);
    }
}
