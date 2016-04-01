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


/**
 * A simple cover class for the Windows registry.  The API is
 * similar to the Windows C registry API.
 */
public class WinRegistry
{
    public static final int HKEY_CLASSES_ROOT = 0x80000000;
    public static final int HKEY_CURRENT_USER = 0x80000001;
    public static final int HKEY_LOCAL_MACHINE = 0x80000002;
    public static final int HKEY_USERS = 0x80000003;
    public static final int HKEY_PERFORMANCE_DATA = 0x80000004;
    public static final int HKEY_CURRENT_CONFIG = 0x80000005;
    public static final int HKEY_DYN_DATA = 0x80000006;

    static final int KEY_QUERY_VALUE = 0x1;
    static final int KEY_SET_VALUE = 0x2;
    static final int KEY_CREATE_SUB_KEY = 0x4;
    static final int KEY_ENUMERATE_SUB_KEYS = 0x8;
    static final int KEY_NOTIFY = 0x10;
    static final int KEY_CREATE_LINK = 0x20;
    static final int KEY_READ = 0x20019;
    static final int KEY_WRITE = 0x20006;

    static final int KEY_EXECUTE = 0x20019;
    static final int KEY_ALL_ACCESS = 0xf003f;
    static final int REG_OPTION_RESERVED = 0x0;
    static final int REG_OPTION_NON_VOLATILE = 0x0;
    static final int REG_OPTION_VOLATILE = 0x1;
    static final int REG_OPTION_CREATE_LINK = 0x2;
    static final int REG_OPTION_BACKUP_RESTORE = 0x4;
    static final int REG_OPTION_OPEN_LINK = 0x8;
    static final int REG_LEGAL_OPTION = 0xf;
    static final int REG_CREATED_NEW_KEY = 0x1;
    static final int REG_OPENED_EXISTING_KEY = 0x2;
    static final int REG_WHOLE_HIVE_VOLATILE = 0x1;
    static final int REG_REFRESH_HIVE = 0x2;
    static final int REG_NO_LAZY_FLUSH = 0x4;
    static final int REG_NOTIFY_CHANGE_NAME = 0x1;
    static final int REG_NOTIFY_CHANGE_ATTRIBUTES = 0x2;
    static final int REG_NOTIFY_CHANGE_LAST_SET = 0x4;
    static final int REG_NOTIFY_CHANGE_SECURITY = 0x8;
    static final int REG_LEGAL_CHANGE_FILTER = 0xf;
    static final int REG_NONE = 0x0;
    static final int REG_SZ = 0x1;
    static final int REG_EXPAND_SZ = 0x2;
    static final int REG_BINARY = 0x3;
    static final int REG_DWORD = 0x4;
    static final int REG_DWORD_LITTLE_ENDIAN = 0x4;
    static final int REG_DWORD_BIG_ENDIAN = 0x5;
    static final int REG_LINK = 0x6;
    static final int REG_MULTI_SZ = 0x7;
    static final int REG_RESOURCE_LIST = 0x8;
    static final int REG_FULL_RESOURCE_DESCRIPTOR = 0x9;
    static final int REG_RESOURCE_REQUIREMENTS_LIST = 0xa;

    /**
     * Registry values are represented by an integer type code, e.g.
     * REG_SZ for a string, and an array of bytes.  This class combines
     * the two and provides a method, getValue(), that converts the array
     * of bytes into an appropriate java obejct.
     * <p>
     * KeyValue objects are created by native methods, see
     */
    static class KeyValue {
        private final int type;
        private final byte[] data;
        private Object value = null;

        KeyValue(int type, byte[] data) {
            this.type = type;
            this.data = data;
        }

        public int getType() {
            return type;
        }

        public byte[] getData() {
            return data;
        }

        public Object getValue() {
            switch (type) {
            case REG_SZ:
                // fix for 4634008, 4506366
                // make sure (data.length - 1) is a positive number
                if (data.length - 1 < 0) return null;
                return new String(data, 0, data.length - 1);

            case REG_DWORD:
                {
                    int n = 0;
                    for(int i = 0; (i < 4) && (i < data.length); i++) {
                        n += data[i] << (i * 8);
                    }
                    return new Integer(n);
                }

            default:
                return getData();
            }
        }
    }

    static native void initIDs();
    static native int sysOpenKey(int hKey, String subKey, int sam);
    static native int sysCloseKey(int hKey);
    static native KeyValue sysQueryKey(int hKey, String name);
    static native int sysCreateKey(int hKey, String name, int sam);
    static native boolean sysSetStringValue(int hKey, String name,
                                            String value);
    static native boolean sysDeleteKey(int hKey, String subKey);
    static native boolean sysReboot();

    /**
     * [TBD] This should move to another class.
     */
    public static native String getWindowsDirectory();

    static {
        // Library should have already been loaded by Main
        initIDs();
    }


    public static Object get(int hKey, String path, String name) {
        int key = sysOpenKey(hKey, path, KEY_READ);
        if (key != 0) {
            KeyValue kv = sysQueryKey(key, name);
            sysCloseKey(key);
            if (kv != null) {
                return kv.getValue();
            }
        }
        return null;
    }

    public static String getString(int hKey, String path, String name) {
        Object rv = get(hKey, path, name);
        return (rv instanceof String) ? (String)rv : null;
    }

    public static Integer getInteger(int hKey, String path, String name) {
        Object rv = get(hKey, path, name);
        if (rv instanceof Integer) {
            return (Integer)rv;
        } else if (rv instanceof byte[]){
            byte[] b = (byte[])rv;
            if (b.length == 4 && b[1] == 0 && b[2] == 0 && b[3] == 0) {
                return new Integer(b[0]);
            } else {
                return null;
            }
        }
        return null;
    }

    public static boolean setStringValue(int hKey, String path, String name,
                                         String value) {
        boolean retValue = false;
        int key = sysCreateKey(hKey, path, KEY_WRITE);
        if (key != 0) {
            retValue = sysSetStringValue(key, name, value);
            sysCloseKey(key);
        }
        return retValue;
    }

    /**
     * Returns true if the subkey <code>path</code> exists in
     * <code>hkey</code>.
     */
    public static boolean doesSubKeyExist(int hKey, String path) {
        int key = sysOpenKey(hKey, path, KEY_READ);
        if (key != 0) {
            sysCloseKey(key);
            return true;
        }
        return false;
    }

    public static boolean deleteKey(int hKey, String path) {
        return sysDeleteKey(hKey, path);
    }

    public static boolean doReboot() {
        return sysReboot();
    }
}
