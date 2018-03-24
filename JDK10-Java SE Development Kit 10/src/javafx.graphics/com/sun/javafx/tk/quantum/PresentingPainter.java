/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk.quantum;

import com.sun.javafx.logging.PulseLogger;
import static com.sun.javafx.logging.PulseLogger.PULSE_LOGGING_ENABLED;
import com.sun.prism.Graphics;
import com.sun.prism.GraphicsPipeline;
import com.sun.prism.impl.Disposer;

/**
 * The PresentingPainter is used when we are rendering to the main screen.
 * UploadingPainter is used when we need to render into an offscreen buffer.
 */
final class PresentingPainter extends ViewPainter {

    PresentingPainter(ViewScene view) {
        super(view);
    }

    @Override public void run() {
        renderLock.lock();

        boolean locked = false;
        boolean valid = false;
        boolean errored = false;

        try {
            valid = validateStageGraphics();
            if (!valid) {
                if (QuantumToolkit.verbose) {
                    System.err.println("PresentingPainter: validateStageGraphics failed");
                }
                paintImpl(null);
                return;
            }

            /*
             * As Glass is responsible for creating the rendering contexts,
             * locking should be done prior to the Prism calls.
             */
            sceneState.lock();
            locked = true;

            if (factory == null) {
                factory = GraphicsPipeline.getDefaultResourceFactory();
            }
            if (factory == null || !factory.isDeviceReady()) {
                sceneState.getScene().entireSceneNeedsRepaint();
                return;
            }

            if (presentable != null && presentable.lockResources(sceneState)) {
                disposePresentable();
            }
            if (presentable == null) {
                presentable = factory.createPresentable(sceneState);
                penWidth  = viewWidth;
                penHeight = viewHeight;
                freshBackBuffer = true;
            }

            if (presentable != null) {
                Graphics g = presentable.createGraphics();

                ViewScene vs = (ViewScene) sceneState.getScene();
                if (g != null) {
                    paintImpl(g);
                    freshBackBuffer = false;
                }

                if (PULSE_LOGGING_ENABLED) {
                    PulseLogger.newPhase("Presenting");
                }
                if (!presentable.prepare(null)) {
                    disposePresentable();
                    sceneState.getScene().entireSceneNeedsRepaint();
                    return;
                }

                /* present for vsync buffer swap */
                if (vs.getDoPresent()) {
                    if (!presentable.present()) {
                        disposePresentable();
                        sceneState.getScene().entireSceneNeedsRepaint();
                    }
                }
            }
        } catch (Throwable th) {
            errored = true;
            th.printStackTrace(System.err);
        } finally {
            Disposer.cleanUp();

            if (locked) {
                sceneState.unlock();
            }

            ViewScene viewScene = (ViewScene)sceneState.getScene();
            viewScene.setPainting(false);

            if (factory != null) {
                factory.getTextureResourcePool().freeDisposalRequestedAndCheckResources(errored);
            }

            renderLock.unlock();
        }
    }
}
