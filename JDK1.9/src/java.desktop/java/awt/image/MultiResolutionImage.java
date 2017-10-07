/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package java.awt.image;

import java.awt.Image;
import java.util.List;

/**
 * This interface is designed to be an optional additional API supported by
 * some implementations of {@link java.awt.Image} to allow them to provide
 * alternate images for various rendering resolutions. The various
 * {@code Graphics.drawImage(...)} variant methods will consult the methods
 * of this interface if it is implemented on the argument {@code Image} object
 * in order to choose the best representation to use for each rendering operation.
 * <p>
 * The {@code MultiResolutionImage} interface should be implemented by any
 * subclass of {@code java.awt.Image} whose instances are intended to provide
 * image resolution variants according to the given image width and height.
 * For convenience, toolkit images obtained from
 * {@code Toolkit.getImage(String name)} and {@code Toolkit.getImage(URL url)}
 * will implement this interface on platforms that support naming conventions
 * for resolution variants of stored image media and the
 * {@code AbstractMultiResolutionImage} and {@code BaseMultiResolutionImage}
 * classes are provided to facilitate easy construction of custom multi-resolution
 * images from a list of related images.
 *
 * @see java.awt.Image
 * @see java.awt.image.AbstractMultiResolutionImage
 * @see java.awt.image.BaseMultiResolutionImage
 * @see java.awt.Toolkit#getImage(java.lang.String filename)
 * @see java.awt.Toolkit#getImage(java.net.URL url)
 *
 * @since 9
 */
public interface MultiResolutionImage {

    /**
     * Gets a specific image that is the best variant to represent
     * this logical image at the indicated size.
     *
     * @param destImageWidth the width of the destination image, in pixels.
     * @param destImageHeight the height of the destination image, in pixels.
     * @return image resolution variant.
     * @throws IllegalArgumentException if {@code destImageWidth} or
     *         {@code destImageHeight} is less than or equal to zero, infinity,
     *         or NaN.
     *
     * @since 9
     */
    Image getResolutionVariant(double destImageWidth, double destImageHeight);

    /**
     * Gets a readable list of all resolution variants.
     * The list must be nonempty and contain at least one resolution variant.
     * <p>
     * Note that many implementations might return an unmodifiable list.
     *
     * @return list of resolution variants.
     * @since 9
     */
    public List<Image> getResolutionVariants();
}
