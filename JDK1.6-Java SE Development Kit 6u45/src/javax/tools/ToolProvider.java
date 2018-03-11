/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.tools;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.MalformedURLException;

/**
 * Provides methods for locating tool providers, for example,
 * providers of compilers.  This class complements the
 * functionality of {@link java.util.ServiceLoader}.
 *
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public class ToolProvider {

    private ToolProvider() {}

    /**
     * Gets the Java&trade; programming language compiler provided with this platform.
     * @return the compiler provided with this platform or {@code
     * null} if no compiler is provided
     */
    public static JavaCompiler getSystemJavaCompiler() {
        if (Lazy.compilerClass == null)
            return null;
        try {
            return Lazy.compilerClass.newInstance();
        } catch (Throwable e) {
            return null;
        }
    }

    /**
     * Returns the class loader for tools provided with this platform.
     * This does not include user-installed tools.  Use the
     * {@linkplain java.util.ServiceLoader service provider mechanism}
     * for locating user installed tools.
     *
     * @return the class loader for tools provided with this platform
     * or {@code null} if no tools are provided
     */
    public static ClassLoader getSystemToolClassLoader() {
        if (Lazy.compilerClass == null)
            return null;
        return Lazy.compilerClass.getClassLoader();
    }

    /**
     * This class will not be initialized until one of the above
     * methods are called.  This ensures that searching for the
     * compiler does not affect platform start up.
     */
    static class Lazy  {
        private static final String defaultJavaCompilerName
            = "com.sun.tools.javac.api.JavacTool";
        private static final String[] defaultToolsLocation
            = { "lib", "tools.jar" };
        static final Class<? extends JavaCompiler> compilerClass;
        static {
            Class<? extends JavaCompiler> c = null;
            try {
                c = findClass().asSubclass(JavaCompiler.class);
            } catch (Throwable t) {
                // ignored
            }
            compilerClass = c;
        }

        private static Class<?> findClass()
            throws MalformedURLException, ClassNotFoundException
        {
            try {
                return enableAsserts(Class.forName(defaultJavaCompilerName, false, null));
            } catch (ClassNotFoundException e) {
                // ignored, try looking else where
            }
            File file = new File(System.getProperty("java.home"));
            if (file.getName().equalsIgnoreCase("jre"))
                file = file.getParentFile();
            for (String name : defaultToolsLocation)
                file = new File(file, name);
            URL[] urls = {file.toURI().toURL()};
            ClassLoader cl = URLClassLoader.newInstance(urls);
            cl.setPackageAssertionStatus("com.sun.tools.javac", true);
            return Class.forName(defaultJavaCompilerName, false, cl);
        }

        private static Class<?> enableAsserts(Class<?> cls) {
            try {
                ClassLoader loader = cls.getClassLoader();
                if (loader != null)
                    loader.setPackageAssertionStatus("com.sun.tools.javac", true);
            } catch (SecurityException ex) {
                // ignored
            }
            return cls;
        }
    }
}
