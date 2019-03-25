/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.microbenchmarks.graal;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Warmup;

import org.graalvm.compiler.graph.Graph;
import org.graalvm.compiler.microbenchmarks.graal.util.GraalState;
import org.graalvm.compiler.microbenchmarks.graal.util.GraphState;
import org.graalvm.compiler.microbenchmarks.graal.util.MethodSpec;
import org.graalvm.compiler.nodes.StructuredGraph;

/**
 * Benchmarks the performance of {@link Graph#copy(org.graalvm.compiler.debug.DebugContext)}.
 */
public class GraphCopyBenchmark extends GraalBenchmark {

    @MethodSpec(declaringClass = ConditionalEliminationBenchmark.class, name = "nullnessSnippet")
    public static class Nullness extends GraphState {
    }

    @SuppressWarnings("unused")
    public static int nullnessSnippet(Object a, Object b) {
        if (a == null) {
            if (a == b) {
                if (b == null) {
                    return 1;
                } else {
                    return -2;
                }
            } else {
                if (b == null) {
                    return -3;
                } else {
                    return 4;
                }
            }
        } else {
            if (a == b) {
                if (b == null) {
                    return -5;
                } else {
                    return 6;
                }
            } else {
                if (b == null) {
                    return 7;
                } else {
                    return 8;
                }
            }
        }
    }

    @Benchmark
    @Warmup(iterations = 20)
    public StructuredGraph nullness(Nullness s, GraalState g) {
        return (StructuredGraph) s.graph.copy(g.debug);
    }

    @MethodSpec(declaringClass = GraphCopyBenchmark.class, name = "searchSnippet")
    public static class Search extends GraphState {
    }

    static class Entry {
        final String name;

        Entry(String name) {
            this.name = name;
        }
    }

    static class EntryWithNext extends Entry {
        EntryWithNext(String name, Entry next) {
            super(name);
            this.next = next;
        }

        final Entry next;
    }

    public static Entry searchSnippet(Entry start, String name, Entry alternative) {
        Entry current = start;
        do {
            while (current instanceof EntryWithNext) {
                if (name != null && current.name == name) {
                    current = null;
                } else {
                    Entry next = ((EntryWithNext) current).next;
                    current = next;
                }
            }

            if (current != null) {
                if (current.name.equals(name)) {
                    return current;
                }
            }
            if (current == alternative) {
                return null;
            }
            current = alternative;

        } while (true);
    }

    @Benchmark
    @Warmup(iterations = 20)
    public StructuredGraph search(Search s, GraalState g) {
        return (StructuredGraph) s.graph.copy(g.debug);
    }
}
