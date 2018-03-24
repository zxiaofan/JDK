/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.runtime;

/** An instance of this exception is thrown when debuggee VM version
    is not supported current version of SA. */
public class VMVersionMismatchException extends RuntimeException {
    public VMVersionMismatchException(String supported, String target) {
        super();
        supportedVersions = supported;
        targetVersion = target;
    }

    public String getMessage() {
        StringBuffer msg = new StringBuffer();
        msg.append("Supported versions are ");
        msg.append(supportedVersions);
        msg.append(". Target VM is ");
        msg.append(targetVersion);
        return msg.toString();
    }

    public String getSupportedVersions() {
        return supportedVersions;
    }

    public String getTargetVersion() {
        return targetVersion;
    }

    private String supportedVersions;
    private String targetVersion;
}
