/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
 *
 */

package com.sun.tools.jdeps;

import java.io.PrintWriter;
import java.lang.module.ModuleDescriptor;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.lang.module.ModuleDescriptor.Requires.Modifier.*;
import static com.sun.tools.jdeps.Module.*;

/**
 * A builder to create a Graph<Module>
 */
public class ModuleGraphBuilder extends Graph.Builder<Module> {
    final JdepsConfiguration config;

    ModuleGraphBuilder(JdepsConfiguration config) {
        this.config = config;
    }

    /**
     * Adds a module to the graph.
     */
    ModuleGraphBuilder addModule(Module module) {
        addNode(module);
        return this;
    }

    /**
     * Apply transitive reduction on the resulting graph
     */
    public Graph<Module> reduced() {
        Graph<Module> graph = build();
        // transitive reduction
        Graph<Module> newGraph = buildGraph(graph.edges()).reduce();

        if (DEBUG) {
            PrintWriter log = new PrintWriter(System.err);
            System.err.println("before transitive reduction: ");
            graph.printGraph(log);
            System.err.println("after transitive reduction: ");
            newGraph.printGraph(log);
        }

        return newGraph;
    }

    public Graph<Module> buildGraph() {
        Graph<Module> graph = build();
        return buildGraph(graph.edges());
    }

    /**
     * Build a graph of module from the given dependences.
     *
     * It transitively includes all implied read edges.
     */
    private Graph<Module> buildGraph(Map<Module, Set<Module>> edges) {
        Graph.Builder<Module> builder = new Graph.Builder<>();
        Set<Module> visited = new HashSet<>();
        Deque<Module> deque = new LinkedList<>();
        edges.entrySet().stream().forEach(e -> {
            Module m = e.getKey();
            deque.add(m);
            e.getValue().stream().forEach(v -> {
                deque.add(v);
                builder.addEdge(m, v);
            });
        });

        // read requires transitive from ModuleDescriptor
        Module source;
        while ((source = deque.poll()) != null) {
            if (visited.contains(source))
                continue;

            visited.add(source);
            builder.addNode(source);
            Module from = source;
            requiresTransitive(from).forEach(m -> {
                deque.add(m);
                builder.addEdge(from, m);
            });
        }
        return builder.build();
    }

    /*
     * Returns a stream of modules upon which the given module `requires transitive`
     */
    public Stream<Module> requiresTransitive(Module m) {
        // find requires transitive
        return m.descriptor()
                .requires().stream()
                .filter(req -> req.modifiers().contains(TRANSITIVE))
                .map(ModuleDescriptor.Requires::name)
                .map(config::findModule)
                .flatMap(Optional::stream);
    }
}
