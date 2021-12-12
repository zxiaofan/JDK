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

package jdk.tools.jlink.internal.plugins;

import jdk.tools.jlink.plugin.Plugin;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public abstract class AbstractPlugin implements Plugin {

    static final String DESCRIPTION = "description";
    static final String USAGE = "usage";

    private static final ResourceBundle standardPluginsBundle;

    static {
        Locale locale = Locale.getDefault();
        try {
            standardPluginsBundle = ResourceBundle.getBundle("jdk.tools.jlink."
                    + "resources.plugins", locale);
        } catch (MissingResourceException e) {
            throw new InternalError("Cannot find jlink resource bundle for "
                    + "locale " + locale);
        }
    }

    private final ResourceBundle pluginsBundle;
    private final String name;

    protected AbstractPlugin(String name) {
        this.name = name;
        this.pluginsBundle = standardPluginsBundle;
    }

    protected AbstractPlugin(String name, ResourceBundle bundle) {
        this.name = name;
        this.pluginsBundle = bundle;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return getMessage(getName() + "." + DESCRIPTION, getName());
    }

    @Override
    public String getUsage() {
        return getMessage(getName() + "." + USAGE, getName());
    }

    @Override
    public String getArgumentsDescription() {
        return PluginsResourceBundle.getArgument(getName());
    }

    protected String getMessage(String key, Object...args) {
       return PluginsResourceBundle.getMessage(this.pluginsBundle, key, args);
    }
}
