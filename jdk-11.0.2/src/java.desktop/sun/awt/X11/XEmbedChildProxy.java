/*
 * Copyright (c) 2003, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.X11;

import java.awt.Component;
import java.awt.Toolkit;
import sun.awt.AWTAccessor;

@SuppressWarnings("serial") // JDK-implementation class
public class XEmbedChildProxy extends Component {
    long handle;
    XEmbeddingContainer container;
    public XEmbedChildProxy(XEmbeddingContainer container, long handle) {
        this.handle = handle;
        this.container = container;
    }

    public void addNotify() {
        synchronized(getTreeLock()) {
            if (AWTAccessor.getComponentAccessor().getPeer(this) == null) {
                AWTAccessor.getComponentAccessor().
                    setPeer(this,((XToolkit)Toolkit.getDefaultToolkit()).createEmbedProxy(this));
            }
            super.addNotify();
        }
    }

    XEmbeddingContainer getEmbeddingContainer() {
        return container;
    }
    long getHandle() {
        return handle;
    }
}
