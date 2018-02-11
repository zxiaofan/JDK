/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.es2;

import com.sun.prism.impl.PrismTrace;

class ES2RTTextureData extends ES2TextureData {
    private int fboID;
    private int dbID;
    private int rbID;

    ES2RTTextureData(ES2Context context, int texID, int fboID,
                     int w, int h, long size)
    {
        super(context, texID, size);
        this.fboID = fboID;
        PrismTrace.rttCreated(fboID, w, h, size);
    }

    public int getFboID() {
        return fboID;
    }

    public int getMSAARenderBufferID() {
        return this.rbID;
    }

    void setMSAARenderBufferID(int rbID) {
        // Texture ID and multisample render buffer are mutually excusive
        assert getTexID() == 0;
        this.rbID = rbID;
    }

    public int getDepthBufferID() {
        return dbID;
    }

    void setDepthBufferID(int dbID) {
        this.dbID = dbID;
    }

    @Override
    void traceDispose() {
        PrismTrace.rttDisposed(fboID);
    }

    @Override
    public void dispose() {
        super.dispose();
        if (fboID != 0) {
            context.getGLContext().deleteFBO(fboID);
            if (dbID != 0) {
                context.getGLContext().deleteRenderBuffer(dbID);
                dbID = 0;
            }
            if (rbID != 0) {
                context.getGLContext().deleteRenderBuffer(rbID);
                rbID = 0;
            }
            fboID = 0;
        }
    }
}
