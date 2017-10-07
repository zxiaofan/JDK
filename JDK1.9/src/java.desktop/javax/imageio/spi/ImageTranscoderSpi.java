/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package javax.imageio.spi;

import javax.imageio.ImageTranscoder;

/**
 * The service provider interface (SPI) for {@code ImageTranscoder}s.
 * For more information on service provider classes, see the class comment
 * for the {@code IIORegistry} class.
 *
 * @see IIORegistry
 * @see javax.imageio.ImageTranscoder
 *
 */
public abstract class ImageTranscoderSpi extends IIOServiceProvider {

    /**
     * Constructs a blank {@code ImageTranscoderSpi}.  It is up
     * to the subclass to initialize instance variables and/or
     * override method implementations in order to provide working
     * versions of all methods.
     */
    protected ImageTranscoderSpi() {
    }

    /**
     * Constructs an {@code ImageTranscoderSpi} with a given set
     * of values.
     *
     * @param vendorName the vendor name.
     * @param version a version identifier.
     */
    public ImageTranscoderSpi(String vendorName,
                              String version) {
        super(vendorName, version);
    }

    /**
     * Returns the fully qualified class name of an
     * {@code ImageReaderSpi} class that generates
     * {@code IIOMetadata} objects that may be used as input to
     * this transcoder.
     *
     * @return a {@code String} containing the fully-qualified
     * class name of the {@code ImageReaderSpi} implementation class.
     *
     * @see ImageReaderSpi
     */
    public abstract String getReaderServiceProviderName();

    /**
     * Returns the fully qualified class name of an
     * {@code ImageWriterSpi} class that generates
     * {@code IIOMetadata} objects that may be used as input to
     * this transcoder.
     *
     * @return a {@code String} containing the fully-qualified
     * class name of the {@code ImageWriterSpi} implementation class.
     *
     * @see ImageWriterSpi
     */
    public abstract String getWriterServiceProviderName();

    /**
     * Returns an instance of the {@code ImageTranscoder}
     * implementation associated with this service provider.
     *
     * @return an {@code ImageTranscoder} instance.
     */
    public abstract ImageTranscoder createTranscoderInstance();
}
