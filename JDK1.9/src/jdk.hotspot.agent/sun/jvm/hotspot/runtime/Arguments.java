/*
 * Copyright (c) 2004, 2006, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime;

import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;

/** This class represent VM's Arguments class -- command line args, flags etc.*/
public class Arguments {
    static {
        VM.registerVMInitializedObserver(new Observer() {
            public void update(Observable o, Object data) {
                initialize(VM.getVM().getTypeDataBase());
            }
        });
    }

    public static String getJVMFlags() {
        return buildString(jvmFlagsField, jvmFlagsCount);
    }

    public static String getJVMArgs() {
        return buildString(jvmArgsField, jvmArgsCount);
    }

    public static String getJavaCommand() {
        return getString(javaCommandField);
    }

    // Internals only below this point

    // Fields
    private static AddressField jvmFlagsField;
    private static AddressField jvmArgsField;
    private static AddressField javaCommandField;
    private static long jvmFlagsCount;
    private static long jvmArgsCount;

    private static synchronized void initialize(TypeDataBase db) {
        Type argumentsType = db.lookupType("Arguments");
        jvmFlagsField = argumentsType.getAddressField("_jvm_flags_array");
        jvmArgsField = argumentsType.getAddressField("_jvm_args_array");
        javaCommandField = argumentsType.getAddressField("_java_command");

        jvmArgsCount = argumentsType.getCIntegerField("_num_jvm_args").getValue();
        jvmFlagsCount = argumentsType.getCIntegerField("_num_jvm_flags").getValue();
    }

    private static String buildString(AddressField arrayField, long count) {
        StringBuilder sb = new StringBuilder();
        if (count > 0) {
            sb.append(getStringAt(arrayField, 0));
            for (long i = 1; i < count; i++) {
                sb.append(" ");
                sb.append(getStringAt(arrayField, i));
            }
        }
        return sb.toString();
    }

    private static String getString(AddressField field) {
        Address addr = field.getAddress();
        return CStringUtilities.getString(addr);
    }

    private static String getStringAt(AddressField field, long index) {
        Address addr = field.getAddress();
        return CStringUtilities.getString(addr.getAddressAt(index * VM.getVM().getAddressSize()));
    }
}
