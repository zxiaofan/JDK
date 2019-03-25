/*
 * Copyright (c) 2007, 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d;

import sun.java2d.pipe.hw.*;

/**
 * Classes implementing this interface provide access to their
 * destination surfaces.
 */
public interface DestSurfaceProvider {
    /**
     * Returns a surface currently used as a destination surface for rendering.
     *
     * @return destination surface
     */
    public Surface getDestSurface();
}
