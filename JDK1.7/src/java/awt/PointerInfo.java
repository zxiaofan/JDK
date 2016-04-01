/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package java.awt;

/**
 * A class that describes the pointer position.
 * It provides the <code>GraphicsDevice</code> where the
 * pointer is and the <code>Point</code> that represents
 * the coordinates of the pointer.
 * <p>
 * Instances of this class should be obtained via
 * {@link MouseInfo#getPointerInfo}.
 * The <code>PointerInfo</code> instance is not updated dynamically
 * as the mouse moves. To get the updated location, you must call
 * {@link MouseInfo#getPointerInfo} again.
 *
 * @see MouseInfo#getPointerInfo
 * @author      Roman Poborchiy
 * @since       1.5
 */

public class PointerInfo {

    private GraphicsDevice device;
    private Point location;

    /**
     * Package-private constructor to prevent instantiation.
     */
    PointerInfo(GraphicsDevice device, Point location) {
        this.device = device;
        this.location = location;
    }

    /**
     * Returns the <code>GraphicsDevice</code> where the mouse pointer
     * was at the moment this <code>PointerInfo</code> was created.
     *
     * @return   <code>GraphicsDevice</code> corresponding to the pointer
     * @since    1.5
     */
    public GraphicsDevice getDevice() {
        return device;
    }

    /**
     * Returns the <code>Point</code> that represents the coordinates
     * of the pointer on the screen. See {@link MouseInfo#getPointerInfo}
     * for more information about coordinate calculation for multiscreen
     * systems.
     *
     * @see MouseInfo
     * @see MouseInfo#getPointerInfo
     * @return   coordinates of mouse pointer
     * @since    1.5
     */
    public Point getLocation() {
        return location;
    }

}
