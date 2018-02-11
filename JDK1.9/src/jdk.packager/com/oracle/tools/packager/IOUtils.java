/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.oracle.tools.packager;

import com.oracle.tools.packager.Log;
import java.io.*;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class IOUtils {

    public static boolean deleteRecursive(File path) throws FileNotFoundException {
        boolean ret = true;
        if (!path.exists()) { //nothing to do
            return true;
        }
        if (path.isDirectory()) {
            File[] children = path.listFiles();
            if (children != null) {
                for (File f : children) {
                    ret = ret && deleteRecursive(f);
                }
            }
        }
        return ret && path.delete();
    }

    public static void copyFromURL(URL location, File file) throws IOException {
        copyFromURL(location, file, false);
    }

    public static void copyFromURL(URL location, File file, boolean append) throws IOException {
        if (location == null) {
            throw new IOException("Missing input resource!");
        }
        if (file.exists() && !append) {
           file.delete();
        }
        InputStream in = location.openStream();
        FileOutputStream out = new FileOutputStream(file, append);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
        file.setReadOnly();
        file.setReadable(true, false);
    }

    public static void copyFile(File sourceFile, File destFile)
            throws IOException {
        destFile.getParentFile().mkdirs();

        //recreate the file as existing copy may have weird permissions
        destFile.delete();
        destFile.createNewFile();

        FileChannel source = null;
        FileChannel destination = null;
        source = new FileInputStream(sourceFile).getChannel();
        destination = new FileOutputStream(destFile).getChannel();
        if (destination != null && source != null) {
            destination.transferFrom(source, 0, source.size());
        }
        if (source != null) {
            source.close();
        }
        if (destination != null) {
            destination.close();
        }

        //preserve executable bit!
        if (sourceFile.canExecute()) {
            destFile.setExecutable(true, false);
        }
        if (!sourceFile.canWrite()) {
            destFile.setReadOnly();
        }
        destFile.setReadable(true, false);
    }

    public static long getFolderSize(File folder) {
        long foldersize = 0;

        File[] children = folder.listFiles();
        if (children != null) {
            for (File f : children) {
                if (f.isDirectory()) {
                    foldersize += getFolderSize(f);
                } else {
                    foldersize += f.length();
                }
            }
        }

        return foldersize;
    }

    //run "launcher paramfile" in the directory where paramfile is kept
    public static void run(String launcher, File paramFile, boolean verbose)
            throws IOException {
        if (paramFile != null && paramFile.exists()) {
            ProcessBuilder pb = new ProcessBuilder(launcher, paramFile.getName());
            pb = pb.directory(paramFile.getParentFile());
            exec(pb, verbose);
        }
    }

    public static void exec(ProcessBuilder pb, boolean verbose) throws IOException {
        exec(pb, verbose, false);
    }


    public static void exec(ProcessBuilder pb, boolean verbose,
            boolean testForPresenseOnly) throws IOException {
        exec(pb, verbose, testForPresenseOnly, null);
    }

    public static void exec(ProcessBuilder pb, boolean verbose,
            boolean testForPresenseOnly, PrintStream consumer) throws IOException {
        pb.redirectErrorStream(true);
        Log.verbose("Running " + Arrays.toString(pb.command().toArray(new String[0]))
                                + (pb.directory() != null ? (" in " + pb.directory()) : ""));
        Process p = pb.start();
        InputStreamReader isr = new InputStreamReader(p.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String lineRead;
        while ((lineRead = br.readLine()) != null) {
            if (consumer != null) {
                consumer.print(lineRead + '\n');
            } else if (verbose) {
               Log.info(lineRead);
            } else {
               Log.debug(lineRead);
            }
        }
        try {
            int ret = p.waitFor();
            if (ret != 0 && !(testForPresenseOnly && ret != 127)) {
                throw new IOException("Exec failed with code " + ret +
                        " command [" + Arrays.toString(pb.command().toArray(new String[0])) +
                        " in " + (pb.directory() != null ?
                           pb.directory().getAbsolutePath() : "unspecified directory"));
            }
        } catch (InterruptedException ex) {
        }
    }

    //no good test if we are running pre-JRE7
    //use heuristic approach
    // "false positive" is better than wrong answer
    public static boolean isNotSymbolicLink(File file) {
        //no symlinks on windows
        if (Platform.getPlatform() == Platform.WINDOWS) {
            return true;
        }
        try {
            if (file == null || file.getParent() == null) {
                return false;
            }
            File file_canonical = new File(
                    file.getParentFile().getCanonicalFile(), file.getName());
            if (file_canonical.getCanonicalFile().equals(
                       file_canonical.getAbsoluteFile())) {
                return true;
            }
        } catch (IOException ioe) {}
        return false;
    }

    public static byte[] readFully(File f) throws IOException {
        InputStream inp = new FileInputStream(f);
        //read fully into memory
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inp.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        baos.close();
        return baos.toByteArray();
    }
}
