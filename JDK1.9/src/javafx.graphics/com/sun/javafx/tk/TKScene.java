/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk;

import java.security.AccessControlContext;
import com.sun.javafx.sg.prism.NGCamera;
import com.sun.javafx.sg.prism.NGLightBase;
import com.sun.javafx.sg.prism.NGNode;

/**
 * TKScene
 *
 */
public interface TKScene {

    /**
      * This method is called from Scene, when it is being destroyed.
      */
    public void dispose();

    public void waitForRenderingToComplete();

    /**
     * Waits until the render thread is available for synchronization
     * from the scene graph. Once this method returns, the caller has
     * the lock, and will continue to hold the lock until releaseSynchronization
     * is called.
     */
    public void waitForSynchronization();

    /**
     * Releases the synchronization lock previously held. If the updateState
     * flag is set then the glass scene state is updated prior to releasing
     * the lock.
     */
    public void releaseSynchronization(boolean updateState);

    public void setTKSceneListener(TKSceneListener listener);
    public void setTKScenePaintListener(final TKScenePaintListener listener);

    public void setRoot(NGNode root);

    public void markDirty();

    public void setCamera(NGCamera camera);

    NGLightBase[] getLights();
    public void setLights(NGLightBase[] lights);

    /**
     * Set the background fill for the scene
     *
     * @param fillPaint This must be a paint class as returned from Toolkit.createPaint(...)
     */
    public void setFillPaint(Object fillPaint);

    public void setCursor(Object cursor);

    public void enableInputMethodEvents(boolean enable);

    public void finishInputMethodComposition();

    public void entireSceneNeedsRepaint();

    public TKClipboard createDragboard(boolean isDragSource);

    public AccessControlContext getAccessControlContext();
}
