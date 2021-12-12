/*
 * Copyright (c) 2004, 2020, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

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
        return buildString(jvmFlagsArrayField, numJvmFlags);
    }

    public static String getJVMArgs() {
        return buildString(jvmArgsArrayField, numJvmArgs);
    }

    public static String getJavaCommand() {
        return getString(javaCommandField);
    }

    // Internals only below this point

    // Fields
    private static AddressField jvmFlagsArrayField;
    private static AddressField jvmArgsArrayField;
    private static AddressField javaCommandField;
    private static long numJvmFlags;
    private static long numJvmArgs;

    private static synchronized void initialize(TypeDataBase db) {
        Type argumentsType = db.lookupType("Arguments");
        jvmFlagsArrayField = argumentsType.getAddressField("_jvm_flags_array");
        jvmArgsArrayField = argumentsType.getAddressField("_jvm_args_array");
        javaCommandField = argumentsType.getAddressField("_java_command");

        numJvmArgs = argumentsType.getCIntegerField("_num_jvm_args").getValue();
        numJvmFlags = argumentsType.getCIntegerField("_num_jvm_flags").getValue();
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
