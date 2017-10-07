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

package com.sun.java.scene.web;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.PickRay;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.ParentHelper;
import com.sun.javafx.scene.input.PickResultChooser;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.scene.web.WebView;
import javafx.scene.Node;

/**
 * Used to access internal methods of WebView.
 */
public class WebViewHelper extends ParentHelper {

    private static final WebViewHelper theInstance;
    private static WebViewAccessor webViewAccessor;

    static {
        theInstance = new WebViewHelper();
        Utils.forceInit(WebView.class);
    }

    private static WebViewHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(WebView webView) {
        setHelper(webView, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return webViewAccessor.doCreatePeer(node);
    }

    @Override
    protected void updatePeerImpl(Node node) {
        super.updatePeerImpl(node);
        webViewAccessor.doUpdatePeer(node);
    }

    protected void transformsChangedImpl(Node node) {
        super.transformsChangedImpl(node);
        webViewAccessor.doTransformsChanged(node);
    }

    @Override
    protected BaseBounds computeGeomBoundsImpl(Node node, BaseBounds bounds,
            BaseTransform tx) {
        return webViewAccessor.doComputeGeomBounds(node, bounds, tx);
    }

    @Override
    protected boolean computeContainsImpl(Node node, double localX, double localY) {
        return webViewAccessor.doComputeContains(node, localX, localY);
    }

    @Override
    protected void pickNodeLocalImpl(Node node, PickRay localPickRay,
            PickResultChooser result) {
        webViewAccessor.doPickNodeLocal(node, localPickRay, result);
    }

    public static void setWebViewAccessor(final WebViewAccessor newAccessor) {
        if (webViewAccessor != null) {
            throw new IllegalStateException();
        }

        webViewAccessor = newAccessor;
    }

    public interface WebViewAccessor {
        NGNode doCreatePeer(Node node);
        void doUpdatePeer(Node node);
        void doTransformsChanged(Node node);
        BaseBounds doComputeGeomBounds(Node node, BaseBounds bounds, BaseTransform tx);
        boolean doComputeContains(Node node, double localX, double localY);
        void doPickNodeLocal(Node node, PickRay localPickRay, PickResultChooser result);
    }

}
