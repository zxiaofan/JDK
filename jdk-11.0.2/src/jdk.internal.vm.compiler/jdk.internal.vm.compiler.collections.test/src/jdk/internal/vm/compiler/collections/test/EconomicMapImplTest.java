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

import java.util.Arrays;
import java.util.Iterator;

import jdk.internal.vm.compiler.collections.EconomicMap;
import jdk.internal.vm.compiler.collections.EconomicSet;
import jdk.internal.vm.compiler.collections.Equivalence;
import jdk.internal.vm.compiler.collections.UnmodifiableEconomicSet;
import org.junit.Assert;
import org.junit.Test;

public class EconomicMapImplTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveNull() {
        EconomicMap<Integer, Integer> map = EconomicMap.create(10);
        map.removeKey(null);
    }

    @Test
    public void testInitFromHashSet() {
        UnmodifiableEconomicSet<Integer> set = new UnmodifiableEconomicSet<Integer>() {

            @Override
            public boolean contains(Integer element) {
                return element == 0;
            }

            @Override
            public int size() {
                return 1;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {

                    private boolean visited = false;

                    @Override
                    public boolean hasNext() {
                        return !visited;
                    }

                    @Override
                    public Integer next() {
                        if (visited) {
                            return null;
                        } else {
                            visited = true;
                            return 1;
                        }
                    }
                };
            }
        };

        EconomicSet<Integer> newSet = EconomicSet.create(Equivalence.DEFAULT, set);
        Assert.assertEquals(newSet.size(), 1);
    }

    @Test
    public void testCopyHash() {
        EconomicSet<Integer> set = EconomicSet.create(Equivalence.IDENTITY);
        set.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        EconomicSet<Integer> newSet = EconomicSet.create(Equivalence.IDENTITY, set);
        Assert.assertEquals(newSet.size(), 10);
        newSet.remove(8);
        newSet.remove(9);
        Assert.assertEquals(newSet.size(), 8);
    }

    @Test
    public void testNewEquivalence() {
        EconomicSet<Integer> set = EconomicSet.create(new Equivalence() {
            @Override
            public boolean equals(Object a, Object b) {
                return false;
            }

            @Override
            public int hashCode(Object o) {
                return 0;
            }
        });
        set.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertTrue(set.add(new Integer(0)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMapPutNull() {
        EconomicMap<Integer, Integer> map = EconomicMap.create();
        map.put(null, null);
    }

}
