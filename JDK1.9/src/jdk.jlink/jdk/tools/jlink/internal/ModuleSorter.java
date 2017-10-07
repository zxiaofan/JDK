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
package jdk.tools.jlink.internal;

import jdk.tools.jlink.plugin.PluginException;
import jdk.tools.jlink.plugin.ResourcePoolEntry;
import jdk.tools.jlink.plugin.ResourcePoolModule;
import jdk.tools.jlink.plugin.ResourcePoolModuleView;

import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleDescriptor.Requires.Modifier;

import java.nio.ByteBuffer;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Helper class to sort modules in topological order
 */
public final class ModuleSorter {
    private final Deque<ResourcePoolModule> nodes = new LinkedList<>();
    private final Map<String, Set<ResourcePoolModule>> edges = new HashMap<>();
    private final Deque<ResourcePoolModule> result = new LinkedList<>();

    private final ResourcePoolModuleView moduleView;

    public ModuleSorter(ResourcePoolModuleView moduleView) {
        this.moduleView = moduleView;

        moduleView.modules().forEach(this::addModule);
    }

    private ModuleDescriptor readModuleDescriptor(ResourcePoolModule module) {
        String p = "/" + module.name() + "/module-info.class";
        ResourcePoolEntry content = module.findEntry(p).orElseThrow(() ->
            new PluginException("module-info.class not found for " +
                module.name() + " module")
        );
        ByteBuffer bb = ByteBuffer.wrap(content.contentBytes());
        return ModuleDescriptor.read(bb);
    }

    private ModuleSorter addModule(ResourcePoolModule module) {
        addNode(module);
        readModuleDescriptor(module).requires().forEach(req -> {
            ResourcePoolModule dep = moduleView.findModule(req.name()).orElse(null);
            if (dep != null) {
                addNode(dep);
                edges.get(module.name()).add(dep);
            } else if (!req.modifiers().contains(Modifier.STATIC)) {
                throw new PluginException(req.name() + " not found");
            }
        });
        return this;
    }

    private void addNode(ResourcePoolModule module) {
        nodes.add(module);
        edges.computeIfAbsent(module.name(), _n -> new HashSet<>());
    }

    private synchronized void build() {
        if (!result.isEmpty() || nodes.isEmpty())
            return;

        Deque<ResourcePoolModule> visited = new LinkedList<>();
        Deque<ResourcePoolModule> done = new LinkedList<>();
        ResourcePoolModule node;
        while ((node = nodes.poll()) != null) {
            if (!visited.contains(node)) {
                visit(node, visited, done);
            }
        }
    }

    public Stream<ResourcePoolModule> sorted() {
        build();
        return result.stream();
    }

    private void visit(ResourcePoolModule node,
                       Deque<ResourcePoolModule> visited,
                       Deque<ResourcePoolModule> done) {
        if (visited.contains(node)) {
            if (!done.contains(node)) {
                throw new IllegalArgumentException("Cyclic detected: " +
                    node + " " + edges.get(node.name()));
            }
            return;
        }
        visited.add(node);
        edges.get(node.name())
             .forEach(x -> visit(x, visited, done));
        done.add(node);
        result.addLast(node);
    }
}
