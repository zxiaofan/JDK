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

import java.io.File;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class RelativeFileSet {

    public enum Type {
        UNKNOWN, jnlp, jar, nativelib, icon, license, data
    }

    private Type type = Type.UNKNOWN;
    private String mode;
    private String os;
    private String arch;

    private File basedir;
    private Set<String> files = new LinkedHashSet<>();

    public RelativeFileSet(RelativeFileSet copy) {
        type = copy.type;
        mode = copy.mode;
        os = copy.os;
        arch = copy.arch;
        basedir = copy.basedir;
        files = new LinkedHashSet<>(copy.files);
    }

    public RelativeFileSet(File base, Collection<File> files) {
        basedir = base;
        String baseAbsolute = basedir.getAbsolutePath();
        for (File f: files) {
            String absolute = f.getAbsolutePath();
            if (!absolute.startsWith(baseAbsolute)) {
                throw new RuntimeException("File " + f.getAbsolutePath() +
                        " does not belong to " + baseAbsolute);
            }
            if (!absolute.equals(baseAbsolute)) { //possible in javapackager case
                this.files.add(absolute.substring(baseAbsolute.length()+1));
            }
        }
    }

    public void upshift() {
        String root = basedir.getName();
        basedir = basedir.getParentFile();
        Set<String> newFiles = new LinkedHashSet<>();
        for (String s : files) {
            newFiles.add(root + File.separator + s);
        }
        files = newFiles;
    }

    public RelativeFileSet(File base, Set<File> files) {
        this(base, (Collection<File>) files);
    }

    public boolean contains(String[] requiredFiles) {
        boolean result = true;

        for(String fname: requiredFiles) {
            if (!files.contains(fname)) {
                Log.debug("  Runtime does not contain [" + fname + "]");
                result = false;
            }
        }

        return result;
    }

    public boolean contains(String requiredFile) {
        if (files.contains(requiredFile)) {
            return true;
        } else {
            Log.debug("  Runtime does not contain [" + requiredFile + "]");
            return false;
        }
    }

    public File getBaseDirectory() {
        return basedir;
    }

    public Set<String> getIncludedFiles() {
        return files;
    }

    public void dump() {
        Log.verbose("\n=========\nBasedir: " + basedir + "\n");
        for (String fname : files) {
            Log.verbose("  " + fname);
        }
        Log.verbose("\n========");
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    @Override
    public String toString() {
        return "RelativeFileSet{basedir:" + basedir + ", files:" + files + "}";
    }

}
