/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene;

/**
 * Cache hints for use with {@code Node.cacheHint}
 *
 * @see Node#cacheHintProperty
 * @since JavaFX 2.0
 */
public enum CacheHint {
   /**
    * No additional hint. The system will determine the best use of the bitmap
    * cache.
    */
    DEFAULT,

   /**
    * A hint to tell the bitmap caching mechanism that this node is animating,
    * and should be painted from the bitmap cache whenever possible in order to
    * maintain smooth animation. The trade-off is that this may result in
    * decreased visual quality.
    */
    SPEED,

   /**
    * A hint to tell the bitmap caching mechanism that this node should appear
    * on screen at the highest visual quality. The cached bitmap will only be
    * used when it will not degrade the node's appearance on screen.
    * <p>
    * The trade-off is that animations may cause subtle variations in the way
    * that a node would be rendered, and so a node with a cacheHint of QUALITY
    * may be required to re-render a node even when such subtle variations would
    * not be visible in the midst of an animation.  As such, a node with a
    * cacheHint of QUALITY will often benefit from having its cacheHint
    * replaced with a more permissive value (such as {@code SPEED}) during the
    * period of the animation.
    */
    QUALITY,

   /**
    * A hint to tell the bitmap caching mechanism that if the node is scaled up
    * or down, it is acceptable to paint it by scaling the cached bitmap (rather
    * than re-rendering the node).
    */
    SCALE,

   /**
    * A hint to tell the bitmap caching mechanism that if the node is rotated,
    * it is acceptable to paint it by rotating the cached bitmap (rather
    * than re-rendering the node).
    */
    ROTATE,

   /**
    * A hint to tell the bitmap caching mechanism that if the node is scaled
    * and/or rotated, it is acceptable to paint it by scaling and/or rotating
    * the cached bitmap (rather than re-rendering the node).
    */
    SCALE_AND_ROTATE,
}
