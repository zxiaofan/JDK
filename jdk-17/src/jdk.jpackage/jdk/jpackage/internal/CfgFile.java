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

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static jdk.jpackage.internal.StandardBundlerParam.LAUNCHER_DATA;
import static jdk.jpackage.internal.StandardBundlerParam.APP_NAME;
import static jdk.jpackage.internal.StandardBundlerParam.JAVA_OPTIONS;
import static jdk.jpackage.internal.StandardBundlerParam.ARGUMENTS;
import static jdk.jpackage.internal.StandardBundlerParam.VERSION;

/**
 * App launcher's config file.
 */
final class CfgFile {
    CfgFile() {
        appLayout = ApplicationLayout.platformAppImage();
    }

    CfgFile initFromParams(Map<String, ? super Object> params) {
        launcherData = LAUNCHER_DATA.fetchFrom(params);
        launcherName = APP_NAME.fetchFrom(params);
        javaOptions = JAVA_OPTIONS.fetchFrom(params);
        arguments = ARGUMENTS.fetchFrom(params);
        version = VERSION.fetchFrom(params);
        return this;
    }

    void create(Path appImage) throws IOException {
        List<Map.Entry<String, Object>> content = new ArrayList<>();

        ApplicationLayout appCfgLayout = createAppCfgLayout();

        content.add(Map.entry("[Application]", SECTION_TAG));

        if (launcherData.isModular()) {
            content.add(Map.entry("app.mainmodule", launcherData.moduleName()
                    + "/" + launcherData.qualifiedClassName()));
        } else {
            // If the app is contained in an unnamed jar then launch it the
            // legacy way and the main class string must be
            // of the format com/foo/Main
            if (launcherData.mainJarName() != null) {
                content.add(Map.entry("app.classpath",
                        appCfgLayout.appDirectory().resolve(
                                launcherData.mainJarName())));
            }
            content.add(Map.entry("app.mainclass",
                    launcherData.qualifiedClassName()));
        }

        for (var value : launcherData.classPath()) {
            content.add(Map.entry("app.classpath",
                    appCfgLayout.appDirectory().resolve(value).toString()));
        }

        ApplicationLayout appImagelayout = appLayout.resolveAt(appImage);
        Path modsDir = appImagelayout.appModsDirectory();

        content.add(Map.entry("[JavaOptions]", SECTION_TAG));

        // always let app know it's version
        content.add(Map.entry(
                "java-options", "-Djpackage.app-version=" + version));

        // add user supplied java options if there are any
        for (var value : javaOptions) {
            content.add(Map.entry("java-options", value));
        }

        // add module path if there is one
        if (Files.isDirectory(modsDir)) {
            content.add(Map.entry("java-options", "--module-path"));
            content.add(Map.entry("java-options",
                    appCfgLayout.appModsDirectory()));
        }

        if (!arguments.isEmpty()) {
            content.add(Map.entry("[ArgOptions]", SECTION_TAG));
            for (var value : arguments) {
                content.add(Map.entry("arguments", value));
            }
        }

        Path cfgFile = appImagelayout.appDirectory().resolve(launcherName + ".cfg");
        Files.createDirectories(IOUtils.getParent(cfgFile));

        boolean[] addLineBreakAtSection = new boolean[1];
        Stream<String> lines = content.stream().map(entry -> {
            if (entry.getValue() == SECTION_TAG) {
                if (!addLineBreakAtSection[0]) {
                    addLineBreakAtSection[0] = true;
                    return entry.getKey();
                }
                return "\n" + entry.getKey();
            }
            return entry.getKey() + "=" + entry.getValue();
        });
        Files.write(cfgFile, (Iterable<String>) lines::iterator);
    }

    private ApplicationLayout createAppCfgLayout() {
        ApplicationLayout appCfgLayout = appLayout.resolveAt(Path.of("$ROOTDIR"));
        appCfgLayout.pathGroup().setPath(ApplicationLayout.PathRole.APP,
                Path.of("$APPDIR"));
        appCfgLayout.pathGroup().setPath(ApplicationLayout.PathRole.MODULES,
                appCfgLayout.appDirectory().resolve(appCfgLayout.appModsDirectory().getFileName()));
        return appCfgLayout;
    }

    private String launcherName;
    private String version;
    private LauncherData launcherData;
    List<String> arguments;
    List<String> javaOptions;
    private final ApplicationLayout appLayout;

    private static final Object SECTION_TAG = new Object();
}
