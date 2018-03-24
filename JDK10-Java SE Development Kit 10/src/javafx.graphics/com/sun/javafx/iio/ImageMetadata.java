/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.iio;

/**
 * A class containing a limited number of relatively important metadata fields.
 * A <code>null</code>-valued field indicates that the metadata field has not
 * been set.
 */
public class ImageMetadata {
    /**
     * The image gamma.
     */
    public final Float gamma;

    /**
     * <code>true</code> if smaller values represent darker shades.
     */
    public final Boolean blackIsZero;

    /**
     * A palette index to be used as a background.
     */
    public final Integer backgroundIndex;

    /**
     * An RGB color to be used as a background.
     */
    public final Integer backgroundColor;

    /**
     * The amount of time to wait (in milliseconds) before continuing
     * to process the data stream.
     */
    public final Integer delayTime;

    /**
     * The amount of times to loop the animation, zero or null if the animation
     * should loop endlessly.
     */
    public final Integer loopCount;

    /**
     * A palette index to be used for transparent pixels.
     */
    public final Integer transparentIndex;

    /**
     * The width of of the image.
     */
    public final Integer imageWidth;

    /**
     * The height of the image.
     */
    public final Integer imageHeight;

    /**
     * The X offset of the image relative to the screen origin.
     * Note: This is applicable to GIF image only.
     */
    public final Integer imageLeftPosition;

    /**
     * The Y offset of the image relative to the screen origin.
     * Note: This is applicable to GIF image only.
     */
    public final Integer imageTopPosition;

    /**
     * The disposal method for the image.
     * Note: This is applicable to GIF image only.
     */
    public final Integer disposalMethod;

    /**
     *
     * @param gamma the image gamma
     * @param blackIsZero whether smaller values represent darker shades
     * @param backgroundIndex a palette index to use as background
     * @param backgroundColor the color to be used as background.
     * The color format, in Integer, is packed as ARGB with 8 bits per channel.
     * @param delayTime the amount of time to pause at the current image
     * (milliseconds).
     * @param loopCount the amount of times to loop the animation
     * (zero for infinite loop).
     * @param transparentIndex a palette index to be used as transparency.
     */
    public ImageMetadata(Float gamma, Boolean blackIsZero,
            Integer backgroundIndex, Integer backgroundColor,
            Integer transparentIndex, Integer delayTime, Integer loopCount,
            Integer imageWidth, Integer imageHeight,
            Integer imageLeftPosition, Integer imageTopPosition,
            Integer disposalMethod) {
        this.gamma = gamma;
        this.blackIsZero = blackIsZero;
        this.backgroundIndex = backgroundIndex;
        this.backgroundColor = backgroundColor;
        this.transparentIndex = transparentIndex;
        this.delayTime = delayTime;
        this.loopCount = loopCount;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageLeftPosition = imageLeftPosition;
        this.imageTopPosition = imageTopPosition;
        this.disposalMethod = disposalMethod;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("["+getClass().getName());
        if (gamma != null) {
            sb.append(" gamma: " + gamma);
        }
        if (blackIsZero != null) {
            sb.append(" blackIsZero: " + blackIsZero);
        }
        if (backgroundIndex != null) {
            sb.append(" backgroundIndex: " + backgroundIndex);
        }
        if (backgroundColor != null) {
            sb.append(" backgroundColor: " + backgroundColor);
        }
        if (delayTime != null) {
            sb.append(" delayTime: " + delayTime);
        }
        if (loopCount != null) {
            sb.append(" loopCount: " + loopCount);
        }
        if (transparentIndex != null) {
            sb.append(" transparentIndex: " + transparentIndex);
        }
        if (imageWidth != null) {
            sb.append(" imageWidth: " + imageWidth);
        }
        if (imageHeight != null) {
            sb.append(" imageHeight: " + imageHeight);
        }
        if (imageLeftPosition != null) {
            sb.append(" imageLeftPosition: " + imageLeftPosition);
        }
        if (imageTopPosition != null) {
            sb.append(" imageTopPosition: " + imageTopPosition);
        }
        if (disposalMethod != null) {
            sb.append(" disposalMethod: " + disposalMethod);
        }
        sb.append("]");
        return sb.toString();
    }
}
