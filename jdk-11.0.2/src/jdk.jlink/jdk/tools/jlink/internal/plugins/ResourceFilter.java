/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package jdk.tools.jlink.internal.plugins;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import jdk.tools.jlink.internal.Utils;

/**
 *
 * Filter resource resources using path matcher.
 */
public class ResourceFilter implements Predicate<String> {
    private final static List<String> EMPTY_LIST = Collections.emptyList();

    private final List<PathMatcher> matchers;
    private final boolean include;
    private final boolean otherwise;

    private ResourceFilter(List<String> patterns, boolean exclude) {
        Objects.requireNonNull(patterns);
        this.matchers = new ArrayList<>();

        for (String pattern : patterns) {
            if (pattern.startsWith("@")) {
                File file = new File(pattern.substring(1));

                if (file.exists()) {
                    List<String> lines;

                    try {
                        lines = Files.readAllLines(file.toPath());
                    } catch (IOException ex) {
                        throw new UncheckedIOException(ex);
                    }

                    lines.stream().forEach((line) -> {
                        matchers.add(Utils.getJRTFSPathMatcher(line.trim()));
                    });
                } else {
                    System.err.println("warning - the filter file " + file +
                                       " is empty or not present.");
                }
            } else {
                matchers.add(Utils.getJRTFSPathMatcher(pattern));
            }
        }

        this.include = !exclude;
        this.otherwise = exclude || this.matchers.isEmpty();
    }

    public static ResourceFilter includeFilter(List<String> patterns) {
        Objects.requireNonNull(patterns);
        return new ResourceFilter(patterns, false);
    }

    public static ResourceFilter includeFilter(String patterns) {
        if (patterns == null) {
            return includeFilter(EMPTY_LIST);
        }

        return includeFilter(Utils.parseList(patterns));
    }

    public static ResourceFilter excludeFilter(List<String> patterns) {
        Objects.requireNonNull(patterns);
        return new ResourceFilter(patterns, true);
    }

    public static ResourceFilter excludeFilter(String patterns) {
        if (patterns == null) {
            return excludeFilter(EMPTY_LIST);
        }

        return excludeFilter(Utils.parseList(patterns));
    }

    @Override
    public boolean test(String name) {
        Objects.requireNonNull(name);
        Path path = Utils.getJRTFSPath(name);

        for (PathMatcher matcher : matchers) {
            if (matcher.matches(path)) {
                return include;
            }
        }

        return otherwise;
    }
}
