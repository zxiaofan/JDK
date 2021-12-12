/*
 * Copyright (c) 2018, 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.util.ResourceBundle;
import java.io.File;
import java.text.MessageFormat;


/**
 * CLIHelp
 *
 * Generate and show the command line interface help message(s).
 */
public class CLIHelp {

    private static final ResourceBundle I18N = ResourceBundle.getBundle(
            "jdk.jpackage.internal.resources.HelpResources");

    // generates --help for jpackage's CLI
    public static void showHelp(boolean noArgs) {

        if (noArgs) {
            Log.info(I18N.getString("MSG_Help_no_args"));
        } else {
            Platform platform = (Log.isVerbose()) ?
                    Platform.UNKNOWN : Platform.getPlatform();
            String types;
            String pLaunchOptions;
            String pInstallOptions;
            String pInstallDir;
            switch (platform) {
                case MAC:
                    types = "{\"app-image\", \"dmg\", \"pkg\"}";
                    pLaunchOptions = I18N.getString("MSG_Help_mac_launcher");
                    pInstallOptions = "";
                    pInstallDir
                            = I18N.getString("MSG_Help_mac_linux_install_dir");
                    break;
                case LINUX:
                    types = "{\"app-image\", \"rpm\", \"deb\"}";
                    pLaunchOptions = "";
                    pInstallOptions = I18N.getString("MSG_Help_linux_install");
                    pInstallDir
                            = I18N.getString("MSG_Help_mac_linux_install_dir");
                    break;
                case WINDOWS:
                    types = "{\"app-image\", \"exe\", \"msi\"}";
                    pLaunchOptions = I18N.getString("MSG_Help_win_launcher");
                    pInstallOptions = I18N.getString("MSG_Help_win_install");
                    pInstallDir
                            = I18N.getString("MSG_Help_win_install_dir");
                    break;
                default:
                    types = "{\"app-image\", \"exe\", \"msi\", \"rpm\", \"deb\", \"pkg\", \"dmg\"}";
                    pLaunchOptions = I18N.getString("MSG_Help_win_launcher")
                            + I18N.getString("MSG_Help_mac_launcher");
                    pInstallOptions = I18N.getString("MSG_Help_win_install")
                            + I18N.getString("MSG_Help_linux_install");
                    pInstallDir
                            = I18N.getString("MSG_Help_default_install_dir");
                    break;
            }
            Log.info(MessageFormat.format(I18N.getString("MSG_Help"),
                    File.pathSeparator, types, pLaunchOptions,
                    pInstallOptions, pInstallDir));
        }
    }
}
