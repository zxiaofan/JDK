/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.d3d;

class D3DFrameStats {

    public int numTrianglesDrawn;
    public int numDrawCalls;
    public int numBufferLocks;
    public int numTextureLocks;
    public int numTextureTransferBytes;
    public int numSetTexture;
    public int numSetPixelShader;
    public int numRenderTargetSwitch;

    static int divr(int x, int d) {
        return (x + d / 2) / d;
    }

    public String toDebugString(int nFrames) {
        return "D3D Statistics per last " + nFrames + " frame(s) :\n"
                + "\tnumTrianglesDrawn=" + divr(numTrianglesDrawn, nFrames)
                + ", numDrawCalls=" + divr(numDrawCalls, nFrames)
                + ", numBufferLocks=" + divr(numBufferLocks, nFrames)
                + "\n\tnumTextureLocks=" + divr(numTextureLocks, nFrames)
                + ", numTextureTransferKBytes=" + divr(numTextureTransferBytes / 1024, nFrames)
                + "\n\tnumRenderTargetSwitch=" + divr(numRenderTargetSwitch, nFrames)
                + ", numSetTexture=" + divr(numSetTexture, nFrames)
                + ", numSetPixelShader=" + divr(numSetPixelShader, nFrames);
    }
};
