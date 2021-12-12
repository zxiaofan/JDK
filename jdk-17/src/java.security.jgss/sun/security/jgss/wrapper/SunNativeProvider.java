/*
 * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.jgss.wrapper;

import java.util.HashMap;
import java.security.Provider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import org.ietf.jgss.Oid;
import sun.security.action.PutAllAction;
import static sun.security.util.SecurityConstants.PROVIDER_VER;

/**
 * Defines the Sun NativeGSS provider for plugging in the
 * native GSS mechanisms to Java GSS.
 *
 * List of supported mechanisms depends on the local
 * machine configuration.
 *
 * @author Yu-Ching Valerie Peng
 */

public final class SunNativeProvider extends Provider {

    private static final long serialVersionUID = -238911724858694204L;

    private static final String NAME = "SunNativeGSS";
    private static final String INFO = "Sun Native GSS provider";
    private static final String MF_CLASS =
        "sun.security.jgss.wrapper.NativeGSSFactory";
    static boolean DEBUG;
    static void debug(String message) {
        if (DEBUG) {
            if (message == null) {
                throw new NullPointerException();
            }
            System.out.println(NAME + ": " + message);
        }
    }

    @SuppressWarnings("removal")
    private static final HashMap<String, String> MECH_MAP =
            AccessController.doPrivileged(
                new PrivilegedAction<>() {
                    public HashMap<String, String> run() {
                        DEBUG = Boolean.parseBoolean(
                            System.getProperty("sun.security.nativegss.debug"));
                        try {
                            // Ensure the InetAddress class is loaded before
                            // loading j2gss. The library will access this class
                            // and a deadlock might happen. See JDK-8210373.
                            Class.forName("java.net.InetAddress");
                            System.loadLibrary("j2gss");
                        } catch (ClassNotFoundException | Error err) {
                            debug("No j2gss library found!");
                            if (DEBUG) err.printStackTrace();
                            return null;
                        }
                        String[] gssLibs;
                        String defaultLib
                                = System.getProperty("sun.security.jgss.lib");
                        if (defaultLib == null || defaultLib.trim().equals("")) {
                            String osname = System.getProperty("os.name");
                            if (osname.startsWith("Linux")) {
                                gssLibs = new String[]{
                                    "libgssapi.so",
                                    "libgssapi_krb5.so",
                                    "libgssapi_krb5.so.2",
                                };
                            } else if (osname.contains("OS X")) {
                                gssLibs = new String[]{
                                    "libgssapi_krb5.dylib",
                                    "/usr/lib/sasl2/libgssapiv2.2.so",
                               };
                            } else if (osname.contains("Windows")) {
                                // Full path needed, DLL is in jre/bin
                                gssLibs = new String[]{ System.getProperty("java.home")
                                        + "\\bin\\sspi_bridge.dll" };
                            } else {
                                gssLibs = new String[0];
                            }
                        } else {
                            gssLibs = new String[]{ defaultLib };
                        }
                        for (String libName: gssLibs) {
                            if (GSSLibStub.init(libName, DEBUG)) {
                                debug("Loaded GSS library: " + libName);
                                Oid[] mechs = GSSLibStub.indicateMechs();
                                HashMap<String,String> map = new HashMap<>();
                                for (int i = 0; i < mechs.length; i++) {
                                    debug("Native MF for " + mechs[i]);
                                    map.put("GssApiMechanism." + mechs[i],
                                            MF_CLASS);
                                }
                                return map;
                            }
                        }
                        return null;
                    }
                });

    // initialize INSTANCE after MECH_MAP is constructed
    static final Provider INSTANCE = new SunNativeProvider();

    @SuppressWarnings("removal")
    public SunNativeProvider() {
        /* We are the Sun NativeGSS provider */
        super(NAME, PROVIDER_VER, INFO);

        if (MECH_MAP != null) {
            AccessController.doPrivileged(new PutAllAction(this, MECH_MAP));
        }
    }
}