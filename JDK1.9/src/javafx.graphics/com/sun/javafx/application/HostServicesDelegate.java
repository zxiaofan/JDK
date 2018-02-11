/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.application;

import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import javafx.application.Application;
import netscape.javascript.JSObject;


public abstract class HostServicesDelegate {

    private static Method getInstanceMeth = null;

    public static HostServicesDelegate getInstance(final Application app) {
        // Call into the deploy code to get the delegate class
        HostServicesDelegate instance = null;
        try {
            instance = AccessController.doPrivileged(
                    (PrivilegedExceptionAction<HostServicesDelegate>) () -> {
                        if (getInstanceMeth == null) {
                            try {
                                final String factoryClassName =
                                        "com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory";

                                Class factoryClass = Class.forName(factoryClassName,
                                        true,
                                        HostServicesDelegate.class.getClassLoader());
                                getInstanceMeth = factoryClass.getMethod(
                                        "getInstance", Application.class);
                            } catch (Exception ex) {
                                return null;
                            }
                        }
                        return (HostServicesDelegate)
                                getInstanceMeth.invoke(null, app);
                    }
            );
        } catch (PrivilegedActionException pae) {
            System.err.println(pae.getException().toString());
            return null;
        }
        if (instance == null) {
            // in this case we are in standalone mode
            instance = StandaloneHostService.getInstance(app);
        }
        return instance;
    }

    protected HostServicesDelegate() {
    }

    public abstract String getCodeBase();

    public abstract String getDocumentBase();

    public abstract void showDocument(String uri);

    public abstract JSObject getWebContext();

    // StandaloneHostService implementation
    private static class StandaloneHostService extends HostServicesDelegate {

        private static HostServicesDelegate instance = null;

        private Class appClass = null;

        public static HostServicesDelegate getInstance(Application app) {
            synchronized (StandaloneHostService.class) {
                if (instance == null) {
                    instance = new StandaloneHostService(app);
                }
                return instance;
            }
        }

        private StandaloneHostService(Application app) {
             appClass = app.getClass();
        }

        @Override
        public String getCodeBase() {
            // If the application was launched in standalone mode, this method
            // returns the directory containing the application jar file.
            // If the application is not packaged in a jar file, this method
            // returns the empty string.
            String theClassFile = appClass.getName();
            int idx = theClassFile.lastIndexOf(".");
            if (idx >= 0) {
                // Strip off package name prefix in class name if exists
                // getResoruce will automatically add in package name during
                // lookup; see Class.getResource javadoc for more details
                theClassFile = theClassFile.substring(idx + 1);
            }
            theClassFile = theClassFile + ".class";

            String classUrlString = appClass.getResource(theClassFile).toString();
            if (!classUrlString.startsWith("jar:file:") ||
                    classUrlString.indexOf("!") == -1) {
                return "";
            }
            // Strip out the "jar:" and everything after and including the "!"
            String urlString = classUrlString.substring(4,
                    classUrlString.lastIndexOf("!"));
            File jarFile = null;
            try {
                jarFile = new File(new URI(urlString).getPath());
            } catch (Exception e) {
                // should not happen
            }
            if (jarFile != null) {
                String codebase = jarFile.getParent();
                if (codebase != null) {
                    return toURIString(codebase);
                }
            }

            return "";
        }

        private String toURIString(String filePath) {
            try {
                return new File(filePath).toURI().toString();
            } catch (Exception e) {
                // should not happen
                // dump stack for debug purpose
                e.printStackTrace();
            }
            return "";
        }

        @Override public String getDocumentBase() {
            // If the application was launched in standalone mode,
            // this method returns the URI of the current directory.
            return toURIString(System.getProperty("user.dir"));
        }

        static final String[] browsers = {"google-chrome", "firefox", "opera",
            "konqueror", "mozilla"};

        @Override
        public void showDocument(final String uri) {
            String osName = System.getProperty("os.name");
            try {
                if (osName.startsWith("Mac OS")) {
                    Desktop.getDesktop().browse(URI.create(uri));
                } else if (osName.startsWith("Windows")) {
                    Runtime.getRuntime().exec(
                            "rundll32 url.dll,FileProtocolHandler " + uri);
                } else { //assume Unix or Linux
                    String browser = null;
                    for (String b : browsers) {
                        if (browser == null && Runtime.getRuntime().exec(
                                new String[]{"which", b}).getInputStream().read() != -1) {
                            Runtime.getRuntime().exec(new String[]{browser = b, uri});
                        }
                    }
                    if (browser == null) {
                        throw new Exception("No web browser found");
                    }
                }
            } catch (Exception e) {
                // should not happen
                // dump stack for debug purpose
                e.printStackTrace();
            }
        }

        @Override public JSObject getWebContext() {
            return null;
        }
    }
}
