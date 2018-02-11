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

package jdk.packager.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public final class Module {
    private String filename;
    private ModuleType moduleType;

    public enum JarType {All, UnnamedJar, ModularJar}
    public enum ModuleType {Unknown, UnnamedJar, ModularJar, Jmod, ExplodedModule}

    public Module(File AFile) {
        super();
        filename = AFile.getPath();
        moduleType = getModuleType(AFile);
    }

    public String getModuleName() {
        File file = new File(getFileName());
        return getFileWithoutExtension(file.getName());
    }

    public String getFileName() {
        return filename;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    private static ModuleType getModuleType(File AFile) {
        ModuleType result = ModuleType.Unknown;
        String filename = AFile.getAbsolutePath();

        if (AFile.isFile()) {
            if (filename.endsWith(".jmod")) {
                result = ModuleType.Jmod;
            }
            else if (filename.endsWith(".jar")) {
                JarType status = isModularJar(filename);

                if (status == JarType.ModularJar) {
                    result = ModuleType.ModularJar;
                }
                else if (status == JarType.UnnamedJar) {
                    result = ModuleType.UnnamedJar;
                }
            }
        }
        else if (AFile.isDirectory()) {
            File moduleInfo = new File(filename + File.separator + "module-info.class");

            if (moduleInfo.exists()) {
                result = ModuleType.ExplodedModule;
            }
        }

        return result;
    }

    private static JarType isModularJar(String FileName) {
        JarType result = JarType.All;
        List<String> classNames = new ArrayList<String>();

        try {
            ZipInputStream zip = new ZipInputStream(new FileInputStream(FileName));
            result = JarType.UnnamedJar;

            try {
                for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                    if (entry.getName().matches("module-info.class")) {
                        result = JarType.ModularJar;
                        break;
                    }
                }

                zip.close();
            } catch (IOException ex) {
            }
        } catch (FileNotFoundException e) {
        }

        return result;
    }

    private static String getFileWithoutExtension(String FileName) {
        return FileName.replaceFirst("[.][^.]+$", "");
    }
}
