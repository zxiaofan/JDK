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

import javax.imageio.ImageTypeSpecifier;
import javax.imageio.metadata.IIOMetadataFormat;

public class TIFFStreamMetadataFormat extends TIFFMetadataFormat {

    private static TIFFStreamMetadataFormat theInstance = null;

    public boolean canNodeAppear(String elementName,
                                 ImageTypeSpecifier imageType) {
        return false;
    }

    private TIFFStreamMetadataFormat() {
        this.resourceBaseName =
    "javax.imageio.plugins.tiff.TIFFStreamMetadataFormatResources";
        this.rootName = TIFFStreamMetadata.NATIVE_METADATA_FORMAT_NAME;

        TIFFElementInfo einfo;
        TIFFAttrInfo ainfo;
        String[] empty = new String[0];
        String[] childNames;
        String[] attrNames;

        childNames = new String[] { "ByteOrder" };
        einfo = new TIFFElementInfo(childNames, empty, CHILD_POLICY_ALL);

        elementInfoMap.put(TIFFStreamMetadata.NATIVE_METADATA_FORMAT_NAME,
                           einfo);

        childNames = empty;
        attrNames = new String[] { "value" };
        einfo = new TIFFElementInfo(childNames, attrNames, CHILD_POLICY_EMPTY);
        elementInfoMap.put("ByteOrder", einfo);

        ainfo = new TIFFAttrInfo();
        ainfo.dataType = DATATYPE_STRING;
        ainfo.isRequired = true;
        attrInfoMap.put("ByteOrder/value", ainfo);
    }

    public static synchronized IIOMetadataFormat getInstance() {
        if (theInstance == null) {
            theInstance = new TIFFStreamMetadataFormat();
        }
        return theInstance;
    }
}
