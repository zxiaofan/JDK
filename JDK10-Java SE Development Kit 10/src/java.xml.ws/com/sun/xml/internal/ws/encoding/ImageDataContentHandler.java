/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.encoding;

import javax.activation.DataContentHandler;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataSource;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.datatransfer.DataFlavor;
import java.util.logging.Logger;
import java.util.Iterator;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * @author Jitendra Kotamraju
 */

public class ImageDataContentHandler extends Component
    implements DataContentHandler {

    private static final Logger log = Logger.getLogger(ImageDataContentHandler.class.getName());
    private final DataFlavor[] flavor;

    public ImageDataContentHandler() {
        String[] mimeTypes = ImageIO.getReaderMIMETypes();
        flavor = new DataFlavor[mimeTypes.length];
        for(int i=0; i < mimeTypes.length; i++) {
            flavor[i] = new ActivationDataFlavor(Image.class, mimeTypes[i], "Image");
        }
    }

    /**
     * Returns an array of DataFlavor objects indicating the flavors the
     * data can be provided in. The array should be ordered according to
     * preference for providing the data (from most richly descriptive to
     * least descriptive).
     *
     * @return The DataFlavors.
     */
    public DataFlavor[] getTransferDataFlavors() {
        return Arrays.copyOf(flavor, flavor.length);
    }

    /**
     * Returns an object which represents the data to be transferred.
     * The class of the object returned is defined by the representation class
     * of the flavor.
     *
     * @param df The DataFlavor representing the requested type.
     * @param ds The DataSource representing the data to be converted.
     * @return The constructed Object.
     */
    public Object getTransferData(DataFlavor df, DataSource ds)
        throws IOException {
        for (DataFlavor aFlavor : flavor) {
            if (aFlavor.equals(df)) {
                return getContent(ds);
            }
        }
        return null;
    }

    /**
     * Return an object representing the data in its most preferred form.
     * Generally this will be the form described by the first DataFlavor
     * returned by the <code>getTransferDataFlavors</code> method.
     *
     * @param ds The DataSource representing the data to be converted.
     * @return The constructed Object.
     */
    public Object getContent(DataSource ds) throws IOException {
        return ImageIO.read(new BufferedInputStream(ds.getInputStream()));
    }

    /**
     * Convert the object to a byte stream of the specified MIME type
     * and write it to the output stream.
     *
     * @param obj   The object to be converted.
     * @param type  The requested MIME type of the resulting byte stream.
     * @param os    The output stream into which to write the converted
     *          byte stream.
     */

    public void writeTo(Object obj, String type, OutputStream os)
        throws IOException {

        try {
            BufferedImage bufImage;
            if (obj instanceof BufferedImage) {
                bufImage = (BufferedImage)obj;
            } else if (obj instanceof Image) {
                bufImage = render((Image)obj);
            } else {
                throw new IOException(
                    "ImageDataContentHandler requires Image object, "
                    + "was given object of type "
                    + obj.getClass().toString());
            }
            ImageWriter writer = null;
            Iterator<ImageWriter> i = ImageIO.getImageWritersByMIMEType(type);
            if (i.hasNext()) {
                writer = i.next();
            }
            if (writer != null) {
                ImageOutputStream stream = ImageIO.createImageOutputStream(os);
                writer.setOutput(stream);
                writer.write(bufImage);
                writer.dispose();
                stream.close();
            } else {
                throw new IOException("Unsupported mime type:"+ type);
            }
        } catch (Exception e) {
            throw new IOException("Unable to encode the image to a stream "
                + e.getMessage());
        }
    }


    private BufferedImage render(Image img) throws InterruptedException {

        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(img, 0);
        tracker.waitForAll();
        BufferedImage bufImage = new BufferedImage(img.getWidth(null),
            img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics g = bufImage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return bufImage;
    }

}
