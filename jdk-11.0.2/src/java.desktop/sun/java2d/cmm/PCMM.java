/*
 * Copyright (c) 2006, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.color.ICC_Profile;

/* Pluggable CMM interface */

public interface PCMM {

    /* methods invoked from ICC_Profile */
    public Profile loadProfile(byte[] data);
    public void freeProfile(Profile p);
    public int  getProfileSize(Profile p);
    public void getProfileData(Profile p, byte[] data);
    public void getTagData(Profile p, int tagSignature, byte[] data);
    public int getTagSize(Profile p, int tagSignature);
    public void setTagData(Profile p, int tagSignature, byte[] data);

    /* methods for creating ColorTransforms */
    public ColorTransform createTransform(ICC_Profile profile, int renderType,
                                          int transformType);

    public ColorTransform createTransform(ColorTransform[] transforms);
}
