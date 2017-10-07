/*
 * Copyright (c) 1998, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

/**
 * This interface can be implemented on a Graphics object to allow
 * the lightweight component code to permanently install a rectangular
 * maximum clip that cannot be extended with setClip and which works in
 * conjunction with the hit() and getTransform() methods of Graphics2D
 * to make it appear as if there really was a component with these
 * dimensions.
 */
public interface ConstrainableGraphics {
    /**
     * Constrain this graphics object to have a permanent device space
     * origin of (x, y) and a permanent maximum clip of (x,y,w,h).
     * Calling this method is roughly equivalent to:
     *    g.translate(x, y);
     *    g.clipRect(0, 0, w, h);
     * except that the clip can never be extended outside of these
     * bounds, even with setClip() and for the fact that the (x,y)
     * become a new device space coordinate origin.
     *
     * These methods are recursive so that you can further restrict
     * the object by calling the constrain() method more times, but
     * you can never enlarge its restricted maximum clip.
     */
    public void constrain(int x, int y, int w, int h);
}
