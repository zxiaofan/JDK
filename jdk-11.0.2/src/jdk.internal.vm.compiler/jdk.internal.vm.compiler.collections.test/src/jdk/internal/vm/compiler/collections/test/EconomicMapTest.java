/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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


package jdk.internal.vm.compiler.collections.test;

import java.util.LinkedHashMap;

import jdk.internal.vm.compiler.collections.EconomicMap;
import jdk.internal.vm.compiler.collections.UnmodifiableEconomicMap;
import org.junit.Assert;
import org.junit.Test;

public class EconomicMapTest {

    @Test
    public void testMapGetDefault() {
        EconomicMap<Integer, Integer> map = EconomicMap.create();
        map.put(0, 1);
        Assert.assertEquals(map.get(0, 2), Integer.valueOf(1));
        Assert.assertEquals(map.get(1, 2), Integer.valueOf(2));
    }

    @Test
    public void testMapPutAll() {
        EconomicMap<Integer, Integer> map = EconomicMap.create();
        EconomicMap<Integer, Integer> newMap = EconomicMap.wrapMap(new LinkedHashMap<>());
        newMap.put(1, 1);
        newMap.put(2, 4);
        map.putAll(newMap);
        Assert.assertEquals(map.size(), 2);

        UnmodifiableEconomicMap<Integer, Integer> unmodifiableEconomicMap = EconomicMap.create(newMap);

        map.removeKey(1);
        map.put(2, 2);
        map.put(3, 9);

        map.putAll(unmodifiableEconomicMap);
        Assert.assertEquals(map.size(), 3);
        Assert.assertEquals(map.get(2), Integer.valueOf(4));
    }

    @Test
    public void testToString() {
        EconomicMap<Integer, Integer> map = EconomicMap.create();
        map.put(0, 0);
        map.put(1, 1);
        Assert.assertEquals(map.toString(), "map(size=2, {(0,0),(1,1)})");
    }

}
