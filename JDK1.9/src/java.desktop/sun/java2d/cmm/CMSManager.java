/*
 * Copyright (c) 2006, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.cmm;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.CMMException;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.security.action.GetPropertyAction;

public class CMSManager {
    public static ColorSpace GRAYspace;       // These two fields allow access
    public static ColorSpace LINEAR_RGBspace; // to java.awt.color.ColorSpace
                                              // private fields from other
                                              // packages.  The fields are set
                                              // by java.awt.color.ColorSpace
                                              // and read by
                                              // java.awt.image.ColorModel.

    private static PCMM cmmImpl = null;

    public static synchronized PCMM getModule() {
        if (cmmImpl != null) {
            return cmmImpl;
        }

        GetPropertyAction gpa = new GetPropertyAction("sun.java2d.cmm");
        String cmmProviderClass = AccessController.doPrivileged(gpa);
        CMMServiceProvider provider = null;
        if (cmmProviderClass != null) {
            try {
                Class<?> cls = Class.forName(cmmProviderClass);
                provider = (CMMServiceProvider)cls.getConstructor().newInstance();
            } catch (ReflectiveOperationException e) {
            }
        }
        if (provider == null) {
            provider = new sun.java2d.cmm.lcms.LcmsServiceProvider();
        }

        cmmImpl = provider.getColorManagementModule();

        if (cmmImpl == null) {
            throw new CMMException("Cannot initialize Color Management System."+
                                   "No CM module found");
        }

        gpa = new GetPropertyAction("sun.java2d.cmm.trace");
        String cmmTrace = AccessController.doPrivileged(gpa);
        if (cmmTrace != null) {
            cmmImpl = new CMMTracer(cmmImpl);
        }

        return cmmImpl;
    }

    static synchronized boolean canCreateModule() {
        return (cmmImpl == null);
    }

    /* CMM trace routines */

    public static class CMMTracer implements PCMM {
        PCMM tcmm;
        String cName ;

        public CMMTracer(PCMM tcmm) {
            this.tcmm = tcmm;
            cName = tcmm.getClass().getName();
        }

        public Profile loadProfile(byte[] data) {
            System.err.print(cName + ".loadProfile");
            Profile p = tcmm.loadProfile(data);
            System.err.printf("(ID=%s)\n", p.toString());
            return p;
        }

        public void freeProfile(Profile p) {
            System.err.printf(cName + ".freeProfile(ID=%s)\n", p.toString());
            tcmm.freeProfile(p);
        }

        public int getProfileSize(Profile p) {
            System.err.print(cName + ".getProfileSize(ID=" + p + ")");
            int size = tcmm.getProfileSize(p);
            System.err.println("=" + size);
            return size;
        }

        public void getProfileData(Profile p, byte[] data) {
            System.err.print(cName + ".getProfileData(ID=" + p + ") ");
            System.err.println("requested " + data.length + " byte(s)");
            tcmm.getProfileData(p, data);
        }

        public int getTagSize(Profile p, int tagSignature) {
            System.err.printf(cName + ".getTagSize(ID=%x, TagSig=%s)",
                              p, signatureToString(tagSignature));
            int size = tcmm.getTagSize(p, tagSignature);
            System.err.println("=" + size);
            return size;
        }

        public void getTagData(Profile p, int tagSignature,
                               byte[] data) {
            System.err.printf(cName + ".getTagData(ID=%x, TagSig=%s)",
                              p, signatureToString(tagSignature));
            System.err.println(" requested " + data.length + " byte(s)");
            tcmm.getTagData(p, tagSignature, data);
        }

        public void setTagData(Profile p, int tagSignature,
                               byte[] data) {
            System.err.print(cName + ".setTagData(ID=" + p +
                             ", TagSig=" + tagSignature + ")");
            System.err.println(" sending " + data.length + " byte(s)");
            tcmm.setTagData(p, tagSignature, data);
        }

        /* methods for creating ColorTransforms */
        public ColorTransform createTransform(ICC_Profile profile,
                                              int renderType,
                                              int transformType) {
            System.err.println(cName + ".createTransform(ICC_Profile,int,int)");
            return tcmm.createTransform(profile, renderType, transformType);
        }

        public ColorTransform createTransform(ColorTransform[] transforms) {
            System.err.println(cName + ".createTransform(ColorTransform[])");
            return tcmm.createTransform(transforms);
        }

        private static String signatureToString(int sig) {
            return String.format("%c%c%c%c",
                                 (char)(0xff & (sig >> 24)),
                                 (char)(0xff & (sig >> 16)),
                                 (char)(0xff & (sig >>  8)),
                                 (char)(0xff & (sig      )));
        }
    }
}
