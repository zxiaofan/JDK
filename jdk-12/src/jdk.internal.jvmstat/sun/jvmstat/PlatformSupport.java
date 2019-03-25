/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
package sun.jvmstat;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.List;
import jdk.internal.vm.VMSupport;

/*
 * Support routines handling temp directory locating
 * and process ID extraction.
 */
public class PlatformSupport {
    private static final String tmpDirName;
    static {
        /*
         * For this to work, the target VM and this code need to use
         * the same directory. Instead of guessing which directory the
         * VM is using, we will ask.
         */
        String tmpdir = VMSupport.getVMTemporaryDirectory();

        /*
         * Assure that the string returned has a trailing File.separator
         * character. This check was added because the Linux implementation
         * changed such that the java.io.tmpdir string no longer terminates
         * with a File.separator character.
         */
        if (tmpdir.lastIndexOf(File.separator) != (tmpdir.length()-1)) {
            tmpdir = tmpdir + File.separator;
        }
        tmpDirName = tmpdir;
    }

    public static PlatformSupport getInstance() {
        try {
            Class<?> c = Class.forName("sun.jvmstat.PlatformSupportImpl");
            @SuppressWarnings("unchecked")
            Constructor<PlatformSupport> cntr = (Constructor<PlatformSupport>) c.getConstructor();
            return cntr.newInstance();
        } catch (ClassNotFoundException e) {
            return new PlatformSupport();
        } catch (ReflectiveOperationException e) {
            throw new InternalError(e);
        }
    }

    // package-private
    PlatformSupport() {}

    /*
     * Return the OS specific temporary directory
     */
    public static String getTemporaryDirectory() {
        return tmpDirName;
    }

    /*
     * Return a list of the temporary directories that the VM uses
     * for the attach and perf data files.  This function returns
     * the traditional temp directory in addition to any paths
     * accessible by the host which map to temp directories used
     * by containers. The container functionality is only currently
     * supported on Linux platforms.
     *
     * It is important that this directory is well-known and the
     * same for all VM instances. It cannot be affected by configuration
     * variables such as java.io.tmpdir.
     */
    public List<String> getTemporaryDirectories(int vmid) {
        // Add the default temporary directory only
        return List.of(tmpDirName);
    }

    /*
     * Extract the host PID from a file path.
     */
    public int getLocalVmId(File file) throws NumberFormatException {
        return Integer.parseInt(file.getName());
    }


    /*
     * Return the inner most namespaced PID if there is one,
     * otherwise return the original PID.
     */
    public int getNamespaceVmId(int pid) {
        return pid;
    }
}
