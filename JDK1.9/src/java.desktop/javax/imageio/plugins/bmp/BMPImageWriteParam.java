/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.imageio.plugins.bmp;

import java.util.Locale;
import javax.imageio.ImageWriteParam;

import com.sun.imageio.plugins.bmp.BMPConstants;
import com.sun.imageio.plugins.bmp.BMPCompressionTypes;

/**
 * A subclass of {@code ImageWriteParam} for encoding images in
 * the BMP format.
 *
 * <p> This class allows for the specification of various parameters
 * while writing a BMP format image file.  By default, the data layout
 * is bottom-up, such that the pixels are stored in bottom-up order,
 * the first scanline being stored last.
 *
 * <p>The particular compression scheme to be used can be specified by using
 * the {@code setCompressionType()} method with the appropriate type
 * string.  The compression scheme specified will be honored if and only if it
 * is compatible with the type of image being written. If the specified
 * compression scheme is not compatible with the type of image being written
 * then the {@code IOException} will be thrown by the BMP image writer.
 * If the compression type is not set explicitly then {@code getCompressionType()}
 * will return {@code null}. In this case the BMP image writer will select
 * a compression type that supports encoding of the given image without loss
 * of the color resolution.
 * <p>The compression type strings and the image type(s) each supports are
 * listed in the following
 * table:
 *
 * <table border=1>
 * <caption><b>Compression Types</b></caption>
 * <tr><th>Type String</th> <th>Description</th>  <th>Image Types</th></tr>
 * <tr><td>BI_RGB</td>  <td>Uncompressed RLE</td> <td>{@literal <= } 8-bits/sample</td></tr>
 * <tr><td>BI_RLE8</td> <td>8-bit Run Length Encoding</td> <td>{@literal <=} 8-bits/sample</td></tr>
 * <tr><td>BI_RLE4</td> <td>4-bit Run Length Encoding</td> <td>{@literal <=} 4-bits/sample</td></tr>
 * <tr><td>BI_BITFIELDS</td> <td>Packed data</td> <td> 16 or 32 bits/sample</td></tr>
 * </table>
 */
public class BMPImageWriteParam extends ImageWriteParam {

    private boolean topDown = false;

    /**
     * Constructs a {@code BMPImageWriteParam} set to use a given
     * {@code Locale} and with default values for all parameters.
     *
     * @param locale a {@code Locale} to be used to localize
     * compression type names and quality descriptions, or
     * {@code null}.
     */
    public BMPImageWriteParam(Locale locale) {
        super(locale);

        // Set compression types ("BI_RGB" denotes uncompressed).
        compressionTypes = BMPCompressionTypes.getCompressionTypes();

        // Set compression flag.
        canWriteCompressed = true;
        compressionMode = MODE_COPY_FROM_METADATA;
        compressionType = compressionTypes[BMPConstants.BI_RGB];
    }

    /**
     * Constructs an {@code BMPImageWriteParam} object with default
     * values for all parameters and a {@code null Locale}.
     */
    public BMPImageWriteParam() {
        this(null);
    }

    /**
     * If set, the data will be written out in a top-down manner, the first
     * scanline being written first.
     *
     * @param topDown whether the data are written in top-down order.
     */
    public void setTopDown(boolean topDown) {
        this.topDown = topDown;
    }

    /**
     * Returns the value of the {@code topDown} parameter.
     * The default is {@code false}.
     *
     * @return whether the data are written in top-down order.
     */
    public boolean isTopDown() {
        return topDown;
    }
}
