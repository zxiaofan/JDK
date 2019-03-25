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

import org.graalvm.compiler.microbenchmarks.graal.util.GraalState;
import org.graalvm.compiler.microbenchmarks.graal.util.GraphState;
import org.graalvm.compiler.microbenchmarks.graal.util.MethodSpec;
import org.graalvm.compiler.phases.common.ConditionalEliminationPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;
import org.openjdk.jmh.annotations.Benchmark;

public class ConditionalEliminationBenchmark extends GraalBenchmark {

    @MethodSpec(declaringClass = ConditionalEliminationBenchmark.class, name = "nullnessSnippet")
    public static class Nullness extends GraphState {
    }

    @SuppressWarnings("unused")
    public static int nullnessSnippet(Object a, Object b, int n, int m) {
        int result = 0;
        if (a == null) {
            if (a == b) {
                if (b == null) {
                    for (int i = 0; i < n; ++i) {
                        if (i % 3 == 0) {
                            break;
                        }
                        result <<= 1;
                        if (i % 7 == 0) {
                            break;
                        }
                    }
                    return 1;
                } else {
                    return -2;
                }
            } else {
                if (b == null) {
                    for (int i = 0; i < n; ++i) {
                        if (i % 4 == 0) {
                            break;
                        }
                        result <<= 1;
                        if (i % 7 == 0) {
                            break;
                        }
                    }
                    return result;
                } else {
                    return 4;
                }
            }
        } else {
            if (a == b) {
                if (b == null) {
                    for (int i = 0; i < n; ++i) {
                        if (i % 5 == 0) {
                            break;
                        }
                        result <<= 1;
                        if (i % 7 == 0) {
                            break;
                        }
                    }
                    return result;
                } else {
                    return 6;
                }
            } else {
                if (b == null) {
                    for (int i = 0; i < n; ++i) {
                        if (i % 6 == 0) {
                            break;
                        }
                        result <<= 1;
                        if (i % 7 == 0) {
                            break;
                        }
                    }
                    return result;
                } else {
                    return 8;
                }
            }
        }
    }

    @Benchmark
    public void nullness(Nullness s, GraalState g) {
        new ConditionalEliminationPhase(false).apply(s.graph, new PhaseContext(g.providers));
    }

    @Benchmark
    public void newDominatorConditionalElimination(Nullness s, GraalState g) {
        new ConditionalEliminationPhase(false).apply(s.graph, new PhaseContext(g.providers));
    }

    @MethodSpec(declaringClass = ConditionalEliminationBenchmark.class, name = "searchSnippet")
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
    public void search(Search s, GraalState g) {
        new ConditionalEliminationPhase(false).apply(s.graph, new PhaseContext(g.providers));
    }
}
