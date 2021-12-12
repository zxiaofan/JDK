/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal;

import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static java.util.ResourceBundle.getBundle;

public final class Versions {

    private Versions() { throw new AssertionError(); }

    /**
     * Returns the version of the {@code javadoc} tool and the Standard doclet.
     *
     * <p> This is typically the same as the version of the JDK platform being
     * used to run the tool, but may be different when running the tool on an
     * older version of the platform.
     *
     * @throws RuntimeException in an unlikely event of the version info
     *                          not being available
     *
     * @apiNote This method does not return {@code null}, has the return type of
     * {@code Optional<Runtime.Version>}, or throw a checked exception. Those
     * would warp the API to cater for something that is probably a result of
     * a build error anyway. Hence, {@code RuntimeException}.
     *
     * @return the version
     */
    public static Runtime.Version javadocVersion() throws RuntimeException {
        /*
         * The "jdk.javadoc.internal.tool.resources.version" resource bundle is
         * non-localized and represented by a class compiled from a source like this:
         *
         * $ cat build/.../support/gensrc/jdk.javadoc/jdk/javadoc/internal/tool/resources/version.java
         * package jdk.javadoc.internal.tool.resources;
         *
         * public final class version extends java.util.ListResourceBundle {
         *     protected final Object[][] getContents() {
         *         return new Object[][] {
         *             { "full", "15-internal+0-2020-06-02-1426246.duke..." },
         *             { "jdk", "15" },
         *             { "release", "15-internal" },
         *         };
         *     }
         * }
         *
         * The string keyed by "full" should be parseable by Runtime.Version.parse()
         */
        ResourceBundle bundle = getBundle("jdk.javadoc.internal.tool.resources.version");
        return Runtime.Version.parse(bundle.getString("full"));
    }

    /**
     * Returns a short string representation of the provided version.
     *
     * <p> The string contains the dotted representation of the version number,
     * followed by the prerelease info, if any.
     * For example, "15", "15.1", "15.0.1", "15-internal".
     *
     * @return a short string representation of the provided version
     *
     * @throws NullPointerException if {@code v == null}
     */
    public static String shortVersionStringOf(Runtime.Version v) {
        String svstr = v.version().stream()
                .map(Object::toString)
                .collect(Collectors.joining("."));
        if (v.pre().isPresent()) {
            svstr += "-" + v.pre().get();
        }
        return svstr;
    }

    /**
     * Returns a full string representation of the provided version.
     *
     * <p> Examples of strings returned from this method are "14+36-1461" and
     * "15-internal+0-2020-06-02-1426246.duke...".
     *
     * @return a full string representation of the provided version
     *
     * @throws NullPointerException if {@code v == null}
     */
    public static String fullVersionStringOf(Runtime.Version v) {
        return v.toString();
    }
}
