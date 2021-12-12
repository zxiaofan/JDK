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
package jdk.jpackage.internal;

import java.math.BigInteger;


final class MsiVersion {
    /**
     * Parse the given string as Windows MSI Product version.
     * https://msdn.microsoft.com/en-us/library/aa370859%28v=VS.85%29.aspx The
     * format of the string is as follows: major.minor.build. The first field is
     * the major version and has a maximum value of 255. The second field is the
     * minor version and has a maximum value of 255. The third field is called
     * the build version or the update version and has a maximum value of
     * 65,535.
     * @throws IllegalArgumentException
     */
    static DottedVersion of(String value) {
        DottedVersion ver = new DottedVersion(value);

        BigInteger[] components = ver.getComponents();
        if (components.length > 3) {
            throw new IllegalArgumentException(I18N.getString(
                    "error.msi-product-version-too-many-components"));
        }

        if (BigInteger.valueOf(255).compareTo(components[0]) < 0) {
            throw new IllegalArgumentException(I18N.getString(
                    "error.msi-product-version-major-out-of-range"));
        }

        if (components.length > 1 && BigInteger.valueOf(255).compareTo(
                components[1]) < 0) {
            throw new IllegalArgumentException(I18N.getString(
                    "error.msi-product-version-minor-out-of-range"));
        }

        if (components.length > 2 && BigInteger.valueOf(65535).compareTo(
                components[2]) < 0) {
            throw new IllegalArgumentException(I18N.getString(
                    "error.msi-product-version-build-out-of-range"));
        }

        return ver;
    }
}
