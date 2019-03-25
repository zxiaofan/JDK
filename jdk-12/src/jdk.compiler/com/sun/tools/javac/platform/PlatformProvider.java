/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.platform;

/** A collection of platform descriptions that can be selected using {@code --release name}
 *  command line option.
 *  Register in {@code META-INF/services/com.sun.tools.javac.platform.PlatformProvider}.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public interface PlatformProvider {

    /**Names of platforms supported by this provider. Each returned name can be used as the key for --release.
     *
     * @return the platform keys
     */
    Iterable<String> getSupportedPlatformNames();

    /**Create a description of a selected platform.
     *
     * @param platformName the name of the selected platform
     * @param options additional parameter, which can be specified after ':' on the command line
     * @return a PlatformDescription
     * @throws PlatformNotSupported if the given platform is not supported
     */
    PlatformDescription getPlatform(String platformName, String options) throws PlatformNotSupported;

    /**Throw if the given platform is not supported.
     */
    public class PlatformNotSupported extends Exception {
        private static final long serialVersionUID = 1L;
    }

}
