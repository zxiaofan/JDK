/*
 * Copyright (c) 1995, 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.image;

/**
 * This interface allows the ImageFetcher class to drive the production
 * of image data in an ImageProducer class by calling the doFetch()
 * method from one of a pool of threads which are created to facilitate
 * asynchronous delivery of image data outside of the standard system
 * threads which manage the applications User Interface.
 *
 * @see ImageFetcher
 * @see java.awt.image.ImageProducer
 *
 * @author      Jim Graham
 */
public interface ImageFetchable {
    /**
     * This method is called by one of the ImageFetcher threads to start
     * the flow of information from the ImageProducer to the ImageConsumer.
     * @see ImageFetcher
     * @see java.awt.image.ImageProducer
     */
    public void doFetch();
}
