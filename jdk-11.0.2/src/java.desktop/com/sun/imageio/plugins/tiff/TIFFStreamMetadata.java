/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.imageio.plugins.tiff;

import java.nio.ByteOrder;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.metadata.IIOInvalidTreeException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class TIFFStreamMetadata extends IIOMetadata {

    // package scope
    static final String NATIVE_METADATA_FORMAT_NAME =
        "javax_imageio_tiff_stream_1.0";

    static final String NATIVE_METADATA_FORMAT_CLASS_NAME =
        "javax.imageio.plugins.tiff.TIFFStreamMetadataFormat";

    private static final String bigEndianString =
        ByteOrder.BIG_ENDIAN.toString();
    private static final String littleEndianString =
        ByteOrder.LITTLE_ENDIAN.toString();

    public ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;

    public TIFFStreamMetadata() {
        super(false,
              NATIVE_METADATA_FORMAT_NAME,
              NATIVE_METADATA_FORMAT_CLASS_NAME,
              null, null);
    }

    public boolean isReadOnly() {
        return false;
    }

    // Shorthand for throwing an IIOInvalidTreeException
    private static void fatal(Node node, String reason)
        throws IIOInvalidTreeException {
        throw new IIOInvalidTreeException(reason, node);
    }

    public Node getAsTree(String formatName) {
        IIOMetadataNode root = new IIOMetadataNode(nativeMetadataFormatName);

        IIOMetadataNode byteOrderNode = new IIOMetadataNode("ByteOrder");
        byteOrderNode.setAttribute("value", byteOrder.toString());

        root.appendChild(byteOrderNode);
        return root;
    }

//     public void setFromTree(String formatName, Node root) {
//     }

    private void mergeNativeTree(Node root) throws IIOInvalidTreeException {
        Node node = root;
        if (!node.getNodeName().equals(nativeMetadataFormatName)) {
            fatal(node, "Root must be " + nativeMetadataFormatName);
        }

        node = node.getFirstChild();
        if (node == null || !node.getNodeName().equals("ByteOrder")) {
            fatal(node, "Root must have \"ByteOrder\" child");
        }

        NamedNodeMap attrs = node.getAttributes();
        String order = attrs.getNamedItem("value").getNodeValue();

        if (order == null) {
            fatal(node, "ByteOrder node must have a \"value\" attribute");
        }
        if (order.equals(bigEndianString)) {
            this.byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (order.equals(littleEndianString)) {
            this.byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            fatal(node, "Incorrect value for ByteOrder \"value\" attribute");
        }
    }

    public void mergeTree(String formatName, Node root)
        throws IIOInvalidTreeException {
        if (formatName.equals(nativeMetadataFormatName)) {
            if (root == null) {
                throw new NullPointerException("root == null!");
            }
            mergeNativeTree(root);
        } else {
            throw new IllegalArgumentException("Not a recognized format!");
        }
    }

    public void reset() {
        this.byteOrder = ByteOrder.BIG_ENDIAN;
    }
}
