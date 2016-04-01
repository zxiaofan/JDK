package sample.jnlp.jreinstaller.src.share.classes.jnlp.sample.JreInstaller;
/*
 * Copyright (c) 2006, 2012, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * Neither the name of Oracle nor the names of contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MICROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */
import java.util.ResourceBundle;
import java.util.PropertyResourceBundle;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.MissingResourceException;
import java.text.MessageFormat;
import javax.jnlp.ServiceManager;
import javax.jnlp.BasicService;
import javax.jnlp.ExtensionInstallerService;
import javax.jnlp.DownloadService;
import javax.jnlp.UnavailableServiceException;


/** Contains configuration information for an
 *  installer.
 *
 *  Part of the configuration is read as properties
 *  set in the JNLP file - other information is
 *  currently hard-coded as strings - they should
 *  properly be moved to resources.
 *
 */
public class Config {

    /** Localization */
    static private ResourceBundle _resources = null;

    /** JNLP services */
    static private ExtensionInstallerService _eiService;
    static private BasicService _basicService;
    static private DownloadService _downloadService;

    /** Initialize basic services class */
    static private synchronized void initServices() {
        if (_eiService == null) {
            try {
                _eiService = (ExtensionInstallerService)ServiceManager.lookup("javax.jnlp.ExtensionInstallerService");
                _basicService = (BasicService)ServiceManager.lookup("javax.jnlp.BasicService");
                _downloadService = (DownloadService)ServiceManager.lookup("javax.jnlp.DownloadService");
            } catch(UnavailableServiceException use) {
                Config.trace("Unable to locate service: " + use);
            }
        }

        // We cannot really use this, since it breaks lazy loading. When resources for all locales
        // are in place it should be ok. Or we need another solution.
        //_resources = ResourceBundle.getBundle("jnlp/JreInstaller/resources/strings");
        try {
            URL bundle = (new Config()).getClass().getClassLoader().getResource("jnlp/sample/JreInstaller/resources/strings.properties");
            _resources = new PropertyResourceBundle(bundle.openStream());
        } catch(Throwable t) {
            Config.trace("Unable to load resources: " + t);
        }
    }

    static public BasicService getBasicService() {
        if (_basicService == null) {
            initServices();
        }
        return _basicService;
    }

    static public ExtensionInstallerService getInstallService() {
        if (_eiService == null) {
            initServices();
        }
        return _eiService;
    }

    static public DownloadService getDownloadService() {
        if (_downloadService == null) {
            initServices();
        }
        return _downloadService;
    }

    /*
     * Configuration for JNLP file
     */

    static public String getJavaWSVersion() {
        return System.getProperty("javawebstart.version");
    }

    // Win/Solaris
    static public String getInstallerResource() {
        return System.getProperty("installerEntry");
    }

    static public String getLicenseResource() {
        return System.getProperty("licenseEntry");
    }

    // Win/Solaris
    static public String getInstallerLocation() {
        return System.getProperty("installerLocation");
    }

    // Win/Solaris
    static public String getInstallerVersion() {
        String ver = System.getProperty("installerVersion");
        return (ver != null && ver.trim().length() == 0) ? null : ver;
    }

    // Win-only
    static public String getNativeLibName() {
        return System.getProperty("lib");
    }

    // Win/Solaris
    static public String getExecString() {
        return System.getProperty("execString");
    }

    // Solaris-only
    static public String getWaitString(int i) {
        return System.getProperty("waitString." + i);
    }

    // Solaris-only
    static public String getResponseString(int i) {
        return System.getProperty("responseString." + i);
    }

    // Win/Solaris
    static public String getJavaPath() {
        return System.getProperty("javaPath");
    }

    // Solaris-only
    static public boolean isSolarisInstall() {
        String result = System.getProperty("isSolarisInstall");
        return (result != null && result.length() > 0);
    }

    static public boolean isWindowsInstall() {
        String result = System.getProperty("isWindowsInstall");
        return (result != null && result.length() > 0);
    }

    // Win/Solaris
    static public boolean isVerbose() {
        String result = System.getProperty("verbose");
        return (result != null && result.length() > 0);
    }

    // Win-only
    static public boolean isMerlin() {
        String result = System.getProperty("merlin");
        return (result != null && result.length() > 0);
    }

    // Win-only
    static public boolean isHopper() {
        String result = System.getProperty("hopper");
        return (result != null && result.length() > 0);
    }

    // Win-only
    static public String getJavaVersion() {
        return System.getProperty("javaVersion");
    }

    static public String getPlatformVersion() {
        return System.getProperty("platformVersion");
    }


    // Win-only
    static public String getMsvcrtVersionMS() {
        return System.getProperty("msvcrt.versionMS");
    }

    // Win-only
    static public String getMsvcrtVersionLS() {
        return System.getProperty("msvcrt.versionLS");
    }

    /*
     *  String resources
     */
    public static String getJavaWSConfirmMessage() {
        return getString("webstart.msg");
    }

    public static String getJavaWSConfirmTitle() {
        return getString("webstart.title");
    }

    public static String getRebootMessage() {
        return getString("reboot.msg");
    }

    public static String getRebootTitle() {
        return getString("reboot.title");
    }

    public static String getRebootNowString() {
        return getString("reboot.button.now");
    }

    public static String getRebootLaterString() {
        return getString("reboot.button.later");
    }

    public static String getLicenseDialogTitle() {
        return getString("license.title");
    }

    public static String getLicenseDialogQuestionString() {
        return getString("license.question");
    }

    public static String getLicenseDialogAcceptString() {
        return getString("license.button.accept");
    }

    public static String getLicenseDialogExitString() {
        return getString("license.button.exit");
    }

    public static String getWindowTitle() {
        return getString("window.title");
    }

    public static String getWindowHeading() {
        return getString("window.heading");
    }

    public static String getWindowLogo() {
        return "resources/sunlogo.png";
    }

    public static String getWindowStep(int i) {
        return getString("window.step." + i);
    }

    public static String getWindowAbortButton() {
        return getString("window.button.abort");
    }

    public static int getWindowAbortMnemonic() {
        return getMnemonic("window.button.abort");
    }

    public static String getWindowHiddenLabel() {
        return getString("window.hiddenLabel");
    }

    public static String getWindowStepProgress(int step, int percent) {
        Object args[] = { getWindowStep(step), new Integer(percent) };
        return applyPattern("window.step.progress", args);
    }

    public static String getWindowStepWait(int step) {
        Object args[] = { getWindowStep(step) };
        return applyPattern("window.step.wait", args);
    }

    /** Resource bundle stuff */

    // Returns a string from the resources
    static private String getRawString(String key) {
        try {
            return _resources.getString(key);
        } catch (MissingResourceException mre) {
            return "Missing resource for: " + key;
        }
    }
    // Returns a string from the resources with mnemonic removed
    static private String getString(String key) {
        try {
            return removeMnemonic(_resources.getString(key));
        } catch (MissingResourceException mre) {
            return "Missing resource for: " + key;
        }
    }

    private static String removeMnemonics(String s) {
        int i = s.indexOf("&");
        int len = s.length();
        if (i < 0 || i == (len - 1)) {
            return s;
        }
        int j = s.indexOf("&", i+1);
        if (j == i+1) {
            if (j+1 == len) {
                return s.substring(0, i);   // string ends with &&
            } else {
                return s.substring(0, i) + removeMnemonics(s.substring(j+1));
            }
        }
        // ok first & not double &&
        if (i == 0) {
            return removeMnemonics(s.substring(1));
        } else {
            return (s.substring(0, i) + removeMnemonics(s.substring(i+1)));
        }
    }

    public static String extractMnemonic(String s) {
        if (s != null) try {
            int i = s.indexOf("&");
            int len = s.length();
            if (i < 0 || i == (len - 1)) {
                return null;
            }
            int j = s.indexOf("&", i+1);
            if (j == i+1) {
                if (j+1 == len) {
                    return null;
                } else {
                    return extractMnemonic(s.substring(j+1));
                }
            }
            // ok first & not double && and not at end
            return s.substring(i+1, i+2);
        } catch (Exception e) {
            Trace.ignored(e);
        }
        return null;
    }

    static Class _keyEventClazz = null;
    static private int getMnemonic(String key) {
        String resource = rb.getString(key);
        String s = extractMnemonic(resource);
        if ( s == null || s.length() != 1) {
            return 0;
        }
        String vkString = "VK_" + s.toUpperCase();

        try {
            if (_keyEventClazz == null) {
                _keyEventClazz= Class.forName("java.awt.event.KeyEvent");
            }
            Field field = _keyEventClazz.getDeclaredField(vkString);
            int value = field.getInt(null);
            return value;
        } catch (Exception e) {
            Trace.ignoredException(e);
        }
        return 0;
    }

    /** Helper function that applies the messageArguments to a message from the resource object */
    static private String applyPattern(String key, Object[] messageArguments) {
        String message = getString(key);
        MessageFormat formatter = new MessageFormat(message);
        String output = formatter.format(message, messageArguments);
        return output;
    }

    /** debugging method. No localized */
    static public void trace(String msg) {
        if (isVerbose()) {
            System.out.println(msg);
        }
    }
}
