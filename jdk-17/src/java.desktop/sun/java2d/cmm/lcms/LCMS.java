/*
 * Copyright (c) 2007, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.cmm.lcms;

import java.awt.color.CMMException;
import java.awt.color.ICC_Profile;

import sun.java2d.cmm.ColorTransform;
import sun.java2d.cmm.PCMM;
import sun.java2d.cmm.Profile;

final class LCMS implements PCMM {

    /* methods invoked from ICC_Profile */
    @Override
    public Profile loadProfile(byte[] data) {
        final Object disposerRef = new Object();

        final long ptr = loadProfileNative(data, disposerRef);

        if (ptr != 0L) {
            return new LCMSProfile(ptr, disposerRef);
        }
        return null;
    }

    private static LCMSProfile getLcmsProfile(Profile p) {
        if (p instanceof LCMSProfile) {
            return (LCMSProfile)p;
        }
        throw new CMMException("Invalid profile: " + p);
    }

    /**
     * Writes supplied data as a tag into the profile.
     * Destroys old profile, if new one was successfully
     * created.
     *
     * Returns valid pointer to new profile.
     *
     * Throws CMMException if operation fails, preserve old profile from
     * destruction.
     */
    static native void setTagDataNative(long ptr, int tagSignature, byte[] data);
    static native byte[] getProfileDataNative(long ptr);
    static native byte[] getTagNative(long profileID, int signature);
    private static native long loadProfileNative(byte[] data, Object ref);

    @Override
    public byte[] getProfileData(Profile p) {
        return getLcmsProfile(p).getProfileData();
    }

    @Override
    public byte[] getTagData(Profile p, int tagSignature) {
        return getLcmsProfile(p).getTag(tagSignature);
    }

    @Override
    public synchronized void setTagData(Profile p, int tagSignature, byte[] data) {
        getLcmsProfile(p).setTag(tagSignature, data);
    }

    static synchronized native LCMSProfile getProfileID(ICC_Profile profile);

    /* Helper method used from LCMSColorTransfrom */
    static long createTransform(
        LCMSProfile[] profiles, int renderType,
        int inFormatter, boolean isInIntPacked,
        int outFormatter, boolean isOutIntPacked,
        Object disposerRef)
    {
        long[] ptrs = new long[profiles.length];

        for (int i = 0; i < profiles.length; i++) {
            if (profiles[i] == null) throw new CMMException("Unknown profile ID");

            ptrs[i] = profiles[i].getLcmsPtr();
        }

        return createNativeTransform(ptrs, renderType, inFormatter,
                isInIntPacked, outFormatter, isOutIntPacked, disposerRef);
    }

    private static native long createNativeTransform(
        long[] profileIDs, int renderType,
        int inFormatter, boolean isInIntPacked,
        int outFormatter, boolean isOutIntPacked,
        Object disposerRef);

   /**
     * Constructs ColorTransform object corresponding to an ICC_profile
     */
    public ColorTransform createTransform(ICC_Profile profile,
                                                       int renderType,
                                                       int transformType)
    {
        return new LCMSTransform(profile, renderType, renderType);
    }

    /**
     * Constructs an ColorTransform object from a list of ColorTransform
     * objects
     */
    public synchronized ColorTransform createTransform(
        ColorTransform[] transforms)
    {
        return new LCMSTransform(transforms);
    }

    /* methods invoked from LCMSTransform */
    public static native void colorConvert(LCMSTransform trans,
                                           LCMSImageLayout src,
                                           LCMSImageLayout dest);

    public static native void initLCMS(Class<?> Trans, Class<?> IL, Class<?> Pf);

    private LCMS() {};

    private static LCMS theLcms = null;

    @SuppressWarnings("removal")
    static synchronized PCMM getModule() {
        if (theLcms != null) {
            return theLcms;
        }

        java.security.AccessController.doPrivileged(
                new java.security.PrivilegedAction<Object>() {
                    public Object run() {
                        /* We need to load awt here because of usage trace and
                         * disposer frameworks
                         */
                        System.loadLibrary("awt");
                        System.loadLibrary("lcms");
                        return null;
                    }
                });

        initLCMS(LCMSTransform.class, LCMSImageLayout.class, ICC_Profile.class);

        theLcms = new LCMS();

        return theLcms;
    }
}
