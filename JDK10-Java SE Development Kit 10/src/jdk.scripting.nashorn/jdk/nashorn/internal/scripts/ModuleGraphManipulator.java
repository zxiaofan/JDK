/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.scripts;

import jdk.nashorn.api.scripting.JSObject;

/**
 * Nashorn's StructureLoader and ScriptLoader instances load
 * this class in the respective dynamic modules created. This
 * class is never loaded by Nashorn's own class loader. The
 * .class bytes of this class are loaded as resource by the
 * {@link jdk.nashorn.internal.runtime.NashornLoader} class. This class
 * exists in this package because nashorn structures and scripts
 * modules use this package name for the only exported package
 * from those modules.
 *
 * Note that this class may be dynamically generated at runtime.
 * But, this java source is used for ease of reading.
 */
final class ModuleGraphManipulator {
    private ModuleGraphManipulator() {}

    private static final Module MY_MODULE;
    private static final String MY_PKG_NAME;

    static {
        final Class<?> myClass = ModuleGraphManipulator.class;
        MY_MODULE = myClass.getModule();
        final String myName = myClass.getName();
        MY_PKG_NAME = myName.substring(0, myName.lastIndexOf('.'));

        // nashorn's module is the module of the class loader of current class
        final Module nashornModule = myClass.getClassLoader().getClass().getModule();

        // Make sure this class was not loaded by Nashorn's own loader!
        if (MY_MODULE == nashornModule) {
            throw new IllegalStateException(myClass + " loaded by wrong loader!");
        }

        // open package to nashorn module
        MY_MODULE.addOpens(MY_PKG_NAME, nashornModule);
    }

    // The following method is reflectively invoked from Nashorn
    // to add required module export edges. Because this package
    // itself is qualified exported only to nashorn and this
    // method is private, unsafe calls are not possible.

    private static void addExport(final Module otherMod) {
        MY_MODULE.addExports(MY_PKG_NAME, otherMod);
    }
}
