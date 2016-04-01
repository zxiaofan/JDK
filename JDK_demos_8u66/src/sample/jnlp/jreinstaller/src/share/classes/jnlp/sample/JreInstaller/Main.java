package sample.jnlp.jreinstaller.src.share.classes.jnlp.sample.JreInstaller;
/*
 * Copyright (c) 2006, 2010, Oracle and/or its affiliates. All rights reserved.
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

import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.MessageFormat;
import javax.jnlp.DownloadService;
import javax.jnlp.DownloadServiceListener;
import javax.jnlp.ExtensionInstallerService;
import java.security.*;

/**
 *  Main class for JRE installer
 */
public class Main {
    private static final String JAVAWS_MERLIN_KEY = "Software\\JavaSoft\\Java Web Start\\1.0.1_02";
    private static final String JAVAWS_HOPPER_KEY = "Software\\JavaSoft\\Java Web Start\\1.2";
    private static final int BUFFER_SIZE = 32 * 1024;

    // Keep track of installer window
    private static JFrame _installerFrame;
    private static  JLabel[]  _stepLabels = null;

    private static final int STEP_LICENSE  = 0;
    private static final int STEP_DOWNLOAD = 1;
    private static final int STEP_UNPACK   = 2;
    private static final int STEP_INSTALL  = 3;
    private static final int STEP_DONE     = 4;

    /** Does install of JRE */
    public static void install() {

        // Hide the JNLP Clients installer window and show own
        Config.getInstallService().hideStatusWindow();
        showInstallerWindow();


        // Make sure the destination exists.
        String path = Config.getInstallService().getInstallPath();
        if (Config.isWindowsInstall()) {
            String defaultLocation = "C:\\Program Files\\Java\\j2re" +
                Config.getJavaVersion() + "\\";
            File defaultDir = new File(defaultLocation);
            if (!defaultDir.exists()) {
                defaultDir.mkdirs();
            }
            if (defaultDir.exists() && defaultDir.canWrite()) {
                path = defaultLocation; // use default if you can
            }
        }

        File installDir = new File(path);

        if (!installDir.exists()) {
            installDir.mkdirs();
            if (!installDir.exists()) {
                // The installFailed string is only for debugging. No localization needed
                installFailed("couldntCreateDirectory", null);
                return;
            }
        }

        // Show license if neccesary
        enableStep(STEP_LICENSE);
        if (!showLicensing()) {
            // The installFailed string is only for debugging. No localization needed
            installFailed("Licensing was not accepted", null);
        };

        // Make sure that the data JAR is downloaded
        enableStep(STEP_DOWNLOAD);
        if (!downloadInstallerComponent()) {
            // The installFailed string is only for debugging. No localization needed
            installFailed("Unable to download data component", null);
        }

        String nativeLibName = Config.getNativeLibName();
        File installerFile = null;

        try {
            // Load native library into process if found
            if (nativeLibName != null && !Config.isSolarisInstall()) {
                System.loadLibrary(nativeLibName);
            }

            // Unpack installer
            enableStep(STEP_UNPACK);
            String installResource = Config.getInstallerResource();
            Config.trace("Installer resource: " + installResource);
            installerFile = unpackInstaller(installResource);

            // To clean-up downloaded files
            Config.trace("Unpacked installer to: " + installerFile);
            if (installerFile == null) {
                // The installFailed string is only for debugging. No localization needed
                installFailed("Could not unpack installer components", null);
                return;
            }

            enableStep(STEP_INSTALL);
            setStepText(STEP_INSTALL, Config.getWindowStepWait(STEP_INSTALL));

            boolean success = false;
            if (Config.isSolarisInstall()) {
                success = runSolarisInstaller(path, installerFile);
            } else {
                success = runWindowsInstaller(path, installerFile);
            }

            if (!success) {
                // The installFailed string is only for debugging. No localization needed
                installFailed("Could not run installer", null);
                return;
            }
        } catch(UnsatisfiedLinkError ule) {
            // The installFailed string is only for debugging. No localization needed
            installFailed("Unable to load library: " + nativeLibName, null);
            return;
        } finally {
            if (installerFile != null) {
                installerFile.delete();
            }
        }

        setStepText(STEP_INSTALL, Config.getWindowStep(STEP_INSTALL));
        enableStep(STEP_DONE);

        String execPath = path + Config.getJavaPath();
        Config.trace(execPath);

        /** Remove installer JAR from cache */
        removeInstallerComponent();

        // If we're running anything after 1.0.1 or not on Windows, just call
        // finishedInstall.  Otherwise, deny ExitVM permission so that we can
        // return here and do a reboot.  We have to do this because we need to
        // call ExtensionInstallerService.finishedInstall(), which registers
        // that our extension (the JRE) is installed.  Unfortunately pre-1.2 it
        // also does not understand that we are requesting a reboot, and calls
        // System.exit().  So for pre 1.2 we want to deny the permission to
        // exit the VM so we can return here and perform a reboot.
        boolean ispre12 = false;
        String version = Config.getJavaWSVersion();
        // get first tuple
        String v = version.substring(version.indexOf('-')+1);
        int i2 = v.indexOf('.');
        int v1 = Integer.parseInt(v.substring(0, i2));
        // get second tuple
        v = v.substring(i2+1);
        i2 = v.indexOf('.');
        if (i2 == -1) i2 = v.indexOf('-');
        if (i2 == -1) i2 = v.indexOf('[');
        if (i2 == -1) i2 = v.length();
        int v2 = Integer.parseInt(v.substring(0,i2));
        // are we pre 1.2?
        if (v1 < 1 || (v1 == 1 && v2 < 2)) ispre12 = true;

        if (Config.isWindowsInstall() && ispre12 && Config.isHopper()) {
            // deny ExitVM permission then call finishedInstall
            ProtectionDomain pd = (new Object()).getClass().getProtectionDomain();
            CodeSource cs = pd.getCodeSource();
            AllPermissionExceptExitVM perm = new AllPermissionExceptExitVM();
            PermissionCollection newpc = perm.newPermissionCollection();
            newpc.add (perm);

            // run finishedInstall within the new context which excluded
            // just the ExitVM permission
            ProtectionDomain newpd = new ProtectionDomain(cs, newpc);
            AccessControlContext newacc =
                new AccessControlContext(new ProtectionDomain[] {newpd});
            final String fExecPath = execPath;
            try {
                AccessController.doPrivileged(new PrivilegedExceptionAction() {
                    public Object run() throws SecurityException {
                        finishedInstall(fExecPath);
                        return null;
                    }
                }, newacc);
            } catch (PrivilegedActionException pae) {
                // swallow the exception because we want ExitVM to fail silent
            } catch (SecurityException se) {
                // swallow the exception because we want ExitVM to fail silent
            }
        } else {
            // just call finished Install
            finishedInstall(execPath);
        }

        if (Config.isWindowsInstall() &&
            WindowsInstaller.IsRebootNecessary()) {
            // reboot
            if (!WindowsInstaller.askUserForReboot()) System.exit(0);
        } else {
            System.exit(0);
        }
    }

    private static final Permission exitVMPermission = new RuntimePermission("exitVM");

    private static final class AllPermissionExceptExitVM extends Permission {
        public AllPermissionExceptExitVM() {
            super("<all permissions except Exit VM>");
        }

        public AllPermissionExceptExitVM(String name, String actions) {
            this();
        }

        public boolean implies(Permission p) {
            if (p instanceof RuntimePermission &&
                p.equals(exitVMPermission)) {
                return false;
            } else return true;
        }

        public boolean equals(Object o) {
            return (o instanceof AllPermissionExceptExitVM);
        }

        public String getActions() {
            return new String("<all actions>");
        }

        public int hashCode() {
            return 1;
        }

        public PermissionCollection newPermissionCollection() {
            return new AllPermissionExceptExitVMCollection();
        }


    }

    private static final class AllPermissionExceptExitVMCollection
    extends PermissionCollection implements java.io.Serializable
    {
        private boolean all_allowed; // true if any all permissions have been added

        /**
         * Create an empty AllPermissions object.
         *
         */

        public AllPermissionExceptExitVMCollection() {
            all_allowed = false;
        }

        /**
         * Adds a permission to the AllPermissions. The key for the hash is
         * permission.path.
         *
         * @param permission the Permission object to add.
         *
         * @exception IllegalArgumentException - if the permission is not a
         *                                       AllPermission
         *
         * @exception SecurityException - if this AllPermissionCollection object
         *                                has been marked readonly
         */

        public void add(Permission permission)
        {
            if (! (permission instanceof AllPermissionExceptExitVM))
                throw new IllegalArgumentException("invalid permission: "+
                                                   permission);
            if (isReadOnly())
                throw new SecurityException("attempt to add a Permission to a readonly PermissionCollection");

            all_allowed = true;
        }

        /**
         * Check and see if this set of permissions implies the permissions
         * expressed in "permission".
         *
         * @param p the Permission object to compare
         *
         * @return always returns true.
         */

        public boolean implies(Permission permission)
        {
            return ((permission instanceof RuntimePermission &&
                    permission.equals(exitVMPermission)) ?
                    false : all_allowed);
        }

        /**
         * Returns an enumeration of all the AllPermission objects in the
         * container.
         *
         * @return an enumeration of all the AllPermission objects.
         */
        public Enumeration elements()
        {
            return new Enumeration() {
                private boolean hasMore = all_allowed;

                public boolean hasMoreElements() {
                    return hasMore;
                }

                public Object nextElement() {
                    hasMore = false;
                    return new AllPermissionExceptExitVM();
                }
            };
        }
    }

    /** Download data component JAR */
    static public boolean downloadInstallerComponent() {
        DownloadService downloadService = Config.getDownloadService();
        DownloadServiceListener listener = downloadService.getDefaultProgressWindow();
        String compName = Config.getInstallerLocation();
        String compVer = Config.getInstallerVersion();
        try {
            URL codebase = Config.getBasicService().getCodeBase();
            URL url = new URL(codebase, compName);
            String urlstr = url.toString();

            if (!downloadService.isResourceCached(url, compVer)) {
                // The installFailed string is only for debugging. No localization needed
                Config.trace("Downloading: " + urlstr);
                // Do download
                downloadService.loadResource(url,  compVer, listener);
            }
        } catch(IOException ioe) {
            Config.trace("Unable to download: " + compName + "/" + compVer);
            return false;
        }
        return true;
    }

    /** Remove data component data JAR from cache */
    static public void removeInstallerComponent() {
        DownloadService downloadService = Config.getDownloadService();
        if (downloadService != null) {
            String component = Config.getInstallerLocation();
            String version   = Config.getInstallerVersion();
            try {
                URL codebase = Config.getBasicService().getCodeBase();
                URL url = new URL(codebase, component);
                component = url.toString();
                Config.trace("Removing: " + component + "/" + version);
                downloadService.removeResource(url, version);
            } catch(IOException ioe) {
                Config.trace("Unable to remove " + component + "/" + version);
            }
        } else {
            Config.trace("No download service found");
        }
    }

    /** Runs a Solaris installer */
    static public boolean runSolarisInstaller(String installPath, File installFile) {

        /** Build temp. script file */
        File script = null;
        boolean success = false;
        try {
            script = SolarisInstaller.createTempShellScript();

            String[] args = new String[3];
            args[0] = installPath;
            args[1] = script.getAbsolutePath();
            args[2] = installFile.getAbsolutePath();
            String execString = getExecuteString(args);
            success = SolarisInstaller.execute(execString);
        } catch(IOException ioe) {
            Config.trace("Got ioe: " + ioe);
            return false;
        } finally {
            if (script != null) script.delete();
        }
        return success;
    }


    /** Runs a Windows installer */
    static public boolean runWindowsInstaller(String installPath, File installFile) {
        boolean deleteHopperKey = false;
        boolean deleteMerlinKey = false;
        // If Hopper, and JavaWS can update, ask the user if they want
        // to update.
        if (Config.isHopper() &&
            !WinRegistry.doesSubKeyExist(WinRegistry.HKEY_LOCAL_MACHINE,
                                         JAVAWS_HOPPER_KEY)) {
            int res =
                JOptionPane.showConfirmDialog(_installerFrame,
                                              Config.getJavaWSConfirmMessage(),
                                              Config.getJavaWSConfirmTitle(),
                                              JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.NO_OPTION) {
                // create the registry key so that JavaWS will not install
                WinRegistry.setStringValue(WinRegistry.HKEY_LOCAL_MACHINE,
                                           JAVAWS_HOPPER_KEY,
                                           "Home", "");
                // flag to delete the key later
                deleteHopperKey = true;
            }
        }

        // If Merlin, never update JavaWS.  1.0.1_02 bundled with Merlin does
        // not have the ability to update while JavaWS is running.  So just
        // prevent the update by spoofing the registry key.
        if (Config.isMerlin()) {
            WinRegistry.setStringValue(WinRegistry.HKEY_LOCAL_MACHINE,
                                       JAVAWS_MERLIN_KEY,
                                       "Home", "");
            deleteMerlinKey = true;
        }

        /** Build temp. script file */
        boolean success = false;
        File iss = null;
        try {
            String[] args = new String[2];
            args[0] = installFile.getAbsolutePath();
            if (Config.getJavaVersion().startsWith("1.4.2")) {
                args[1] = "/s /v\"/qn WEBSTARTICON=1 INSTALLDIR=\\\""+installPath +"\\\"\"";

            }
            else {
                iss = WindowsInstaller.createTempISSScript(
                        installPath,
                        Config.getJavaVersion());
                args[1] = iss.getAbsolutePath();
            }
            String execString = getExecuteString(args);
            success = WindowsInstaller.execute(execString);
        } catch(IOException ioe) {
            return false;
        } finally {
            if (iss != null) iss.delete();
        }

        // delete any spoofed keys we created earlier
        if (deleteHopperKey) {
            WinRegistry.deleteKey(WinRegistry.HKEY_LOCAL_MACHINE,
                                  JAVAWS_HOPPER_KEY);
        }
        if (deleteMerlinKey) {
            WinRegistry.deleteKey(WinRegistry.HKEY_LOCAL_MACHINE,
                                  JAVAWS_MERLIN_KEY);
        }

        // 4662215 cannot reboot here because the config hasn't been written
        // by JavaWS yet.  Reboot later, after installSucceeded has been
        // called.
        // WindowsInstaller.rebootIfNecessary();

        return success;
    }

    /**
     * Returns the string to execute, which is determined
     * from the property <code>install.execString</code>. MessageFormat
     * is used to reformat the string. The first argument is the
     * the install path, with the remaining arguments the paths to the
     * extracted files that were downloaded.
     */
    static private String getExecuteString(String[] args) {
        String execString = Config.getExecString();
        if (execString == null) {
            Config.trace("No exec string specified");
            return null;
        }
        String apply  = MessageFormat.format(execString, args);
        Config.trace("exec string !" + apply + "!");
        return apply;
    }

    /** Unpacks a resource to a temp. file
     */
    static public File unpackInstaller(String resourceName) {
        // Array to hold all results (this code is slightly more
        // generally that it needs to be)
        File[] results = new File[1];
        URL[] urls = new URL[1];

        // Determine size of download
        ClassLoader cl = Main.class.getClassLoader();
        urls[0] = cl.getResource(Config.getInstallerResource());
        if (urls[0] == null) {
            Config.trace("Could not find resource: " + Config.getInstallerResource());
            return null;
        }

        int totalSize = 0;
        int totalRead = 0;
        for(int i = 0; i < urls.length; i++) {
            if (urls[i] != null) {
                try {
                    URLConnection connection = urls[i].openConnection();
                    totalSize += connection.getContentLength();
                } catch(IOException ioe) {
                    Config.trace("Got exception: " + ioe);
                    return null;
                }
            }
        }

        // Unpack each file
        for(int i = 0; i < urls.length; i++) {
            if (urls[i] != null) {
                // Create temp. file to store unpacked file in
                InputStream in = null;
                OutputStream out = null;
                try {
                    // Use extension from URL (important for dll files)
                    String extension = new File(urls[i].getFile()).getName();
                    int lastdotidx = (extension != null) ? extension.lastIndexOf('.') : -1;
                    if (lastdotidx == -1) {
                        extension = ".dat";
                    } else {
                        extension = extension.substring(lastdotidx);
                    }

                    // Create output stream
                    results[i] = File.createTempFile("jre", extension);
                    results[i].deleteOnExit();
                    out  = new FileOutputStream(results[i]);

                    // Create inputstream
                    URLConnection connection = urls[i].openConnection();
                    in = connection.getInputStream();

                    int read = 0;
                    byte[] buf = new byte[BUFFER_SIZE];
                    while ((read = in.read(buf)) != -1) {
                        out.write(buf, 0, read);
                        // Notify delegate
                        totalRead += read;
                        if (totalRead > totalSize && totalSize != 0) totalSize = totalRead;

                        // Update UI
                        if (totalSize != 0) {
                            int percent = (100 * totalRead) / totalSize;
                            setStepText(STEP_UNPACK,
                                        Config.getWindowStepProgress(STEP_UNPACK, percent));
                        }
                    }
                } catch(IOException ie) {
                    Config.trace("Got exception while downloading resource: " + ie);
                    for(int j = 0; j < results.length; j++) {
                        if (results[j] != null) results[j].delete();
                    }
                    return null;
                } finally {
                    try {
                        if (in != null)  in.close();
                        if (out != null) out.close();
                    } catch(IOException io) { /* ignore */ }
                }
            }
        }

        setStepText(STEP_UNPACK, Config.getWindowStep(STEP_UNPACK));
        return results[0];
    }

    /**
     * Invoked when the install finishes.
     */
    public static void finishedInstall(final String execPath) {
        // Use a runnable as more than likely we've queued up a bunch of
        // Runnables
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    // do nothing
                }
            });
        } catch(java.lang.reflect.InvocationTargetException ite) {
            Config.trace("Unexpected exception: " + ite);
        } catch(InterruptedException ie) {
            Config.trace("Unexpected exception: " + ie);
        }
        String platformVersion = Config.getPlatformVersion();
        Config.getInstallService().setJREInfo(platformVersion, execPath);
        Config.getInstallService().
            installSucceeded(Config.isWindowsInstall() &&
                             WindowsInstaller.IsRebootNecessary());
    }

    /**
     * Invoked when the installer has failed.
     */
    public static void installFailed(final String description, Throwable th) {
        Config.trace("installFailed: " + description + " " + th);
        if (SwingUtilities.isEventDispatchThread()) {
            Config.getInstallService().installFailed();
            System.exit(-1);
        } else {
            try {
                SwingUtilities.invokeAndWait(new Runnable() {
                            public void run() {
                                Config.getInstallService().installFailed();
                                System.exit(-1);
                            }
                        });
            } catch(java.lang.reflect.InvocationTargetException ite) {
                Config.trace("Unexpected exception: " + ite);
            } catch(InterruptedException ie) {
                Config.trace("Unexpected exception: " + ie);
            }
        }
    }

    /** Main method. Invokes installer or uninstaller */
    public static void main(String[] args) {
        // Only supports install
        if (args.length > 0 && args[0].equals("install")) {
            install();
        }
    }

    public static boolean showLicensing() {
        if (Config.getLicenseResource() == null) return true;
        ClassLoader cl = Main.class.getClassLoader();
        URL url = cl.getResource(Config.getLicenseResource());
        if (url == null) return true;

        String license = null;
        try {
            URLConnection con = url.openConnection();
            int size = con.getContentLength();
            byte[] content = new byte[size];
            InputStream in = new BufferedInputStream(con.getInputStream());
            in.read(content);
            license = new String(content);
        } catch(IOException ioe) {
            Config.trace("Got exception when reading " + Config.getLicenseResource() + ": " + ioe);
            return false;
        }

        // Build dialog
        JTextArea ta = new JTextArea(license);
        ta.setEditable(false);
        final JDialog jd = new JDialog(_installerFrame, true);
        Container comp = jd.getContentPane();
        jd.setTitle(Config.getLicenseDialogTitle());
        comp.setLayout(new BorderLayout(10, 10));
        comp.add(new JScrollPane(ta), "Center");
        Box box = new Box(BoxLayout.X_AXIS);
        box.add(box.createHorizontalStrut(10));
        box.add(new JLabel(Config.getLicenseDialogQuestionString()));
        box.add(box.createHorizontalGlue());
        JButton acceptButton = new JButton(Config.getLicenseDialogAcceptString());
        JButton exitButton = new JButton(Config.getLicenseDialogExitString());
        box.add(acceptButton);
        box.add(box.createHorizontalStrut(10));
        box.add(exitButton);
        box.add(box.createHorizontalStrut(10));
        jd.getRootPane().setDefaultButton(acceptButton);
        Box box2 = new Box(BoxLayout.Y_AXIS);
        box2.add(box);
        box2.add(box2.createVerticalStrut(5));
        comp.add(box2, "South");
        jd.pack();

        final boolean accept[] = new boolean[1];
        acceptButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        accept[0] = true;
                        jd.hide();
                        jd.dispose();
                    }
                });

        exitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        accept[0] = false;
                        jd.hide();
                        jd.dispose();
                    }
                });

        // Apply any defaults the user may have, constraining to the size
        // of the screen, and default (packed) size.
        Rectangle size =  new Rectangle(0, 0, 500, 300);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        size.width = Math.min(screenSize.width, size.width);
        size.height = Math.min(screenSize.height, size.height);
        // Center the window
        jd.setBounds((screenSize.width - size.width) / 2,
                         (screenSize.height - size.height) / 2,
                     size.width, size.height);

        // Show dialog
        jd.show();

        return accept[0];
    }

    //
    // Build installer window
    //
    static public void showInstallerWindow() {
        _installerFrame = new JFrame(Config.getWindowTitle());

        Container cont = _installerFrame.getContentPane();
        cont.setLayout(new BorderLayout());

        // North pane
        Box topPane = new Box(BoxLayout.X_AXIS);
        JLabel title = new JLabel(Config.getWindowHeading());
        Font titleFont  = new Font("SansSerif", Font.BOLD, 22);
        title.setFont(titleFont);
        title.setForeground(Color.black);

        // Create Sun logo
        URL urlLogo = Main.class.getResource(Config.getWindowLogo());
        Image img = Toolkit.getDefaultToolkit().getImage(urlLogo);
        MediaTracker md = new MediaTracker(_installerFrame);
        md.addImage(img, 0);
        try { md.waitForAll();
        } catch(Exception ioe) { Config.trace(ioe.toString()); }
        if (md.isErrorID(0)) Config.trace("Error loading image");
        Icon sunLogo = new ImageIcon(img);
        JLabel logoLabel = new JLabel(sunLogo);
        logoLabel.setOpaque(true);
        topPane.add(topPane.createHorizontalStrut(5));
        topPane.add(title);
        topPane.add(topPane.createHorizontalGlue());
        topPane.add(logoLabel);
        topPane.add(topPane.createHorizontalStrut(5));

        // West Pane
        Box westPane = new Box(BoxLayout.X_AXIS);
        westPane.add(westPane.createHorizontalStrut(10));

        // South Pane
        Box bottomPane = new Box(BoxLayout.X_AXIS);
        bottomPane.add(bottomPane.createHorizontalGlue());
        JButton abortButton = new JButton(Config.getWindowAbortButton());
        abortButton.setMnemonic(Config.getWindowAbortMnemonic());
        bottomPane.add(abortButton);
        bottomPane.add(bottomPane.createHorizontalGlue());
        bottomPane.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));

        // Center Pane
        Box centerPane = new Box(BoxLayout.Y_AXIS);
        JLabel hidden = new JLabel(Config.getWindowHiddenLabel());
        hidden.setVisible(false);
        centerPane.add(hidden);
        _stepLabels = new JLabel[5];
        for(int i = 0; i < _stepLabels.length; i++) {
            _stepLabels[i] = new JLabel(Config.getWindowStep(i));
            _stepLabels[i].setEnabled(false);
            centerPane.add(_stepLabels[i]);

            // install label's length will expand,so set a longer size.
            if(i == STEP_INSTALL) {
                Dimension dim = new JLabel(Config.
                        getWindowStepWait(STEP_INSTALL)).getPreferredSize();
                _stepLabels[i].setPreferredSize(dim);
            }
        }
        hidden = new JLabel(Config.getWindowHiddenLabel());
        hidden.setVisible(false);
        centerPane.add(hidden);

        // Setup box layout
        cont.add(topPane, "North");
        cont.add(westPane, "West");
        cont.add(bottomPane, "South");
        cont.add(centerPane, "Center");

        _installerFrame.pack();
        Dimension dim = _installerFrame.getSize();

        // hard code to ensure title is completely visible on Sol/lin.
        if(dim.width < 400) {
            dim.width = 400;
            _installerFrame.setSize(dim);
        }

        Rectangle size =  _installerFrame.getBounds();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        size.width = Math.min(screenSize.width, size.width);
        size.height = Math.min(screenSize.height, size.height);
        // Put window at 1/4, 1/4 of screen resoluion
        _installerFrame.setBounds((screenSize.width - size.width) / 4,
                                      (screenSize.height - size.height) / 4,
                                  size.width, size.height);

        // Setup event listners
        _installerFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        installFailed("Window closed", null);
                    }
                });

        abortButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        installFailed("Abort pressed", null);
                    }
                });

        // Show window
        _installerFrame.show();
    }


    public static void enableStep(final int s) {
        SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        for(int i = 0; i < _stepLabels.length; i++) {
                            _stepLabels[i].setEnabled(i == s);
                        }
                    }
                });
    }

    public static void setStepText(final int step, final String text) {
        SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        _stepLabels[step].setText(text);
                    }
                });
    }
}
