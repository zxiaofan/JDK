/*
 * Copyright (c) 2004, 2013, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.tools.soql;

import sun.jvm.hotspot.debugger.JVMDebugger;
import sun.jvm.hotspot.tools.*;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.utilities.soql.*;

/** This is command line JavaScript debugger console */
public class JSDB extends Tool {

    public JSDB() {
        super();
    }

    public JSDB(JVMDebugger d) {
        super(d);
    }

    public static void main(String[] args) {
        JSDB jsdb = new JSDB();
        jsdb.execute(args);
    }

    public void run() {
        JSJavaScriptEngine engine = new JSJavaScriptEngine() {
                private ObjectReader objReader = new ObjectReader();
                private JSJavaFactory factory = new JSJavaFactoryImpl();

                public ObjectReader getObjectReader() {
                    return objReader;
                }

                public JSJavaFactory getJSJavaFactory() {
                    return factory;
                }
            };
        engine.startConsole();
    }
}
