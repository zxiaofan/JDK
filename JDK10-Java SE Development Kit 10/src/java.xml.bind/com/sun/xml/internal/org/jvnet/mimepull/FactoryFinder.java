/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.org.jvnet.mimepull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

class FactoryFinder {

    private static ClassLoader cl = FactoryFinder.class.getClassLoader();

    static Object find(String factoryId) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        String systemProp = System.getProperty(factoryId);
        if (systemProp != null) {
            return newInstance(systemProp);
        }

        String providerName = findJarServiceProviderName(factoryId);
        if (providerName != null && providerName.trim().length() > 0) {
            return newInstance(providerName);
        }

        return null;
    }

    static Object newInstance(String className) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        Class providerClass = cl.loadClass(className);
        Object instance = providerClass.newInstance();
        return instance;
    }

    private static String findJarServiceProviderName(String factoryId) {
        String serviceId = "META-INF/services/" + factoryId;
        InputStream is;
        is = cl.getResourceAsStream(serviceId);

        if (is == null) {
            return null;
        }

        String factoryClassName;
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            try {
                factoryClassName = rd.readLine();
            } catch (IOException x) {
                return null;
            }
        } finally {
            if (rd != null) {
                try {
                    rd.close();
                } catch (IOException ex) {
                    Logger.getLogger(FactoryFinder.class.getName()).log(Level.INFO, null, ex);
                }
            }
        }

        return factoryClassName;
    }

}
