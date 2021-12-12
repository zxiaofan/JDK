/*
 * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jpackage.internal;

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Dotted numeric version string.
 * E.g.: 1.0.37, 10, 0.5
 */
final class DottedVersion implements Comparable<String> {

    DottedVersion(String version) {
        greedy = true;
        components = parseVersionString(version, greedy);
        value = version;
    }

    private DottedVersion(String version, boolean greedy) {
        this.greedy = greedy;
        components = parseVersionString(version, greedy);
        value = version;
    }

    static DottedVersion greedy(String version) {
        return new DottedVersion(version);
    }

    static DottedVersion lazy(String version) {
        return new DottedVersion(version, false);
    }

    @Override
    public int compareTo(String o) {
        int result = 0;
        BigInteger[] otherComponents = parseVersionString(o, greedy);
        for (int i = 0; i < Math.max(components.length, otherComponents.length)
                && result == 0; ++i) {
            final BigInteger x;
            if (i < components.length) {
                x = components[i];
            } else {
                x = BigInteger.ZERO;
            }

            final BigInteger y;
            if (i < otherComponents.length) {
                y = otherComponents[i];
            } else {
                y = BigInteger.ZERO;
            }
            result = x.compareTo(y);
        }

        return result;
    }

    private static BigInteger[] parseVersionString(String version, boolean greedy) {
        Objects.requireNonNull(version);
        if (version.isEmpty()) {
            if (!greedy) {
                return new BigInteger[] {BigInteger.ZERO};
            }
            throw new IllegalArgumentException(I18N.getString(
                    "error.version-string-empty"));
        }

        int lastNotZeroIdx = -1;
        List<BigInteger> components = new ArrayList<>();
        for (var component : version.split("\\.", -1)) {
            if (component.isEmpty()) {
                if (!greedy) {
                    break;
                }

                throw new IllegalArgumentException(MessageFormat.format(
                        I18N.getString(
                                "error.version-string-zero-length-component"),
                        version));
            }

            if (!DIGITS.matcher(component).matches()) {
                // Catch "+N" and "-N"  cases.
                if (!greedy) {
                    break;
                }

                throw new IllegalArgumentException(MessageFormat.format(
                        I18N.getString(
                                "error.version-string-invalid-component"),
                        version, component));
            }

            final BigInteger num;
            try {
                num = new BigInteger(component);
            } catch (NumberFormatException ex) {
                if (!greedy) {
                    break;
                }

                throw new IllegalArgumentException(MessageFormat.format(
                        I18N.getString(
                                "error.version-string-invalid-component"),
                        version, component));
            }

            if (num != BigInteger.ZERO) {
                lastNotZeroIdx = components.size();
            }
            components.add(num);
        }

        if (lastNotZeroIdx + 1 != components.size()) {
            // Strip trailing zeros.
            components = components.subList(0, lastNotZeroIdx + 1);
        }

        if (components.isEmpty()) {
            components.add(BigInteger.ZERO);
        }
        return components.toArray(BigInteger[]::new);
    }

    @Override
    public String toString() {
        return value;
    }

    BigInteger[] getComponents() {
        return components;
    }

    private final BigInteger[] components;
    private final String value;
    private final boolean greedy;

    private static final Pattern DIGITS = Pattern.compile("\\d+");
}
