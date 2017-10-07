/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.tools.packager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdk.packager.internal.JLinkBundlerHelper;


import static com.oracle.tools.packager.StandardBundlerParam.*;

/**
 * Common utility methods used by app image bundlers.
 */
public abstract class AbstractImageBundler extends AbstractBundler {

    private static final ResourceBundle I18N =
            ResourceBundle.getBundle(AbstractImageBundler.class.getName());

    public void imageBundleValidation(Map<String, ? super Object> p) throws ConfigException {
        StandardBundlerParam.validateMainClassInfoFromAppResources(p);

        Map<String, String> userJvmOptions = USER_JVM_OPTIONS.fetchFrom(p);
        if (userJvmOptions != null) {
            for (Map.Entry<String, String> entry : userJvmOptions.entrySet()) {
                if (entry.getValue() == null || entry.getValue().isEmpty()) {
                    throw new ConfigException(
                            MessageFormat.format(I18N.getString("error.empty-user-jvm-option-value"), entry.getKey()),
                            I18N.getString("error.empty-user-jvm-option-value.advice"));
                }
            }
        }

        boolean hasMainJar = MAIN_JAR.fetchFrom(p) != null;
        boolean hasMainModule = StandardBundlerParam.MODULE.fetchFrom(p) != null;

        if (!hasMainJar && !hasMainModule) {
            if (!hasMainJar) {
                throw new ConfigException(
                        I18N.getString("error.no-application-jar"),
                        I18N.getString("error.no-application-jar.advice"));
            }
            else {
                throw new ConfigException(
                        I18N.getString("error.no-main-module"),
                        I18N.getString("error.no-main-module.advice"));
            }
        }

        if (ENABLE_APP_CDS.fetchFrom(p)) {
            if (!UNLOCK_COMMERCIAL_FEATURES.fetchFrom(p)) {
                throw new ConfigException(
                        I18N.getString("error.app-cds-no-commercial-unlock"),
                        I18N.getString("error.app-cds-no-commercial-unlock.advice"));
            }
        }
    }

    public static void extractFlagsFromVersion(Map<String, ? super Object> params, String versionOutput) {
        Pattern bitArchPattern = Pattern.compile("(\\d*)[- ]?[bB]it");
        Matcher matcher = bitArchPattern.matcher(versionOutput);
        if (matcher.find()) {
            params.put(".runtime.bit-arch", matcher.group(1));
        } else {
            // presume 32 bit on no match
            params.put(".runtime.bit-arch", "32");
        }

        Pattern oldVersionMatcher = Pattern.compile("java version \"((\\d+.(\\d+).\\d+)(_(\\d+)))?(-(.*))?\"");
        matcher = oldVersionMatcher.matcher(versionOutput);
        if (matcher.find()) {
            params.put(".runtime.version", matcher.group(1));
            params.put(".runtime.version.release", matcher.group(2));
            params.put(".runtime.version.major", matcher.group(3));
            params.put(".runtime.version.update", matcher.group(5));
            params.put(".runtime.version.minor", matcher.group(5));
            params.put(".runtime.version.security", matcher.group(5));
            params.put(".runtime.version.patch", "0");
            params.put(".runtime.version.modifiers", matcher.group(7));
        } else {
            Pattern newVersionMatcher = Pattern.compile("java version \"((\\d+).(\\d+).(\\d+).(\\d+))(-(.*))?(\\+[^\"]*)?\"");
            matcher = newVersionMatcher.matcher(versionOutput);
            if (matcher.find()) {
                params.put(".runtime.version", matcher.group(1));
                params.put(".runtime.version.release", matcher.group(1));
                params.put(".runtime.version.major", matcher.group(2));
                params.put(".runtime.version.update", matcher.group(3));
                params.put(".runtime.version.minor", matcher.group(3));
                params.put(".runtime.version.security", matcher.group(4));
                params.put(".runtime.version.patch", matcher.group(5));
                params.put(".runtime.version.modifiers", matcher.group(7));
            } else {
                params.put(".runtime.version", "");
                params.put(".runtime.version.release", "");
                params.put(".runtime.version.major", "");
                params.put(".runtime.version.update", "");
                params.put(".runtime.version.minor", "");
                params.put(".runtime.version.security", "");
                params.put(".runtime.version.patch", "");
                params.put(".runtime.version.modifiers", "");
            }
        }
    }
}
