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

package com.sun.javafx.scene.web;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.prism.Graphics;
import com.sun.webkit.WebPage;
import com.sun.webkit.graphics.WCGraphicsContext;
import com.sun.webkit.graphics.WCGraphicsManager;
import javafx.scene.Node;

public final class Printable extends Node {
    static {
        PrintableHelper.setPrintableAccessor(new PrintableHelper.PrintableAccessor() {
            @Override
            public NGNode doCreatePeer(Node node) {
                return ((Printable) node).doCreatePeer();
            }

            @Override
            public BaseBounds doComputeGeomBounds(Node node,
                    BaseBounds bounds, BaseTransform tx) {
                return ((Printable) node).doComputeGeomBounds(bounds, tx);
            }

            @Override
            public boolean doComputeContains(Node node, double localX, double localY) {
                return ((Printable) node).doComputeContains(localX, localY);
            }

            @Override
            public Object doProcessMXNode(Node node, MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
                return ((Printable) node).doProcessMXNode(alg, ctx);
            }
        });
    }

    private final WebPage page;
    private final NGNode peer;

    public Printable(WebPage page, int pageIndex, float width) {
        this.page = page;
        peer = new Peer(pageIndex, width);
        PrintableHelper.initHelper(this);
    }

    private NGNode doCreatePeer() {
        return peer;
    }

    /*
     * Note: This method MUST only be called via its accessor method.
     */
    private Object doProcessMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return null;
    }

    /*
     * Note: This method MUST only be called via its accessor method.
     */
    private BaseBounds doComputeGeomBounds(BaseBounds bounds, BaseTransform tx) {
        return bounds;
    }

    /*
     * Note: This method MUST only be called via its accessor method.
     */
    private boolean doComputeContains(double d, double d1) {
        return false;
    }

    private final class Peer extends NGNode {
        private final int pageIndex;
        private final float width;

        Peer(int pageIndex, float width) {
            this.pageIndex = pageIndex;
            this.width = width;
        }

        @Override protected void renderContent(Graphics g) {
            WCGraphicsContext gc = WCGraphicsManager.getGraphicsManager().
                    createGraphicsContext(g);
            page.print(gc, pageIndex, width);
        }

        @Override protected boolean hasOverlappingContents() {
            return false;
        }
    }
}
