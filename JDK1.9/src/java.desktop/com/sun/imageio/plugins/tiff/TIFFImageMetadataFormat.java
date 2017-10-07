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

public class TIFFImageMetadataFormat extends TIFFMetadataFormat {

    private static TIFFImageMetadataFormat theInstance = null;

    static {
    }

    public boolean canNodeAppear(String elementName,
                                 ImageTypeSpecifier imageType) {
        return false;
    }

    private TIFFImageMetadataFormat() {
        this.resourceBaseName =
     "javax.imageio.plugins.tiff.TIFFImageMetadataFormatResources";
        this.rootName = TIFFImageMetadata.NATIVE_METADATA_FORMAT_NAME;

        TIFFElementInfo einfo;
        TIFFAttrInfo ainfo;
        String[] empty = new String[0];
        String[] childNames;
        String[] attrNames;

        childNames = new String[] { "TIFFIFD" };
        einfo = new TIFFElementInfo(childNames, empty, CHILD_POLICY_SEQUENCE);

        elementInfoMap.put(TIFFImageMetadata.NATIVE_METADATA_FORMAT_NAME,
                           einfo);

        childNames = new String[] { "TIFFField", "TIFFIFD" };
        attrNames =
            new String[] { "tagSets", "parentTagNumber", "parentTagName" };
        einfo = new TIFFElementInfo(childNames, attrNames, CHILD_POLICY_SEQUENCE);
        elementInfoMap.put("TIFFIFD", einfo);

        ainfo = new TIFFAttrInfo();
        ainfo.dataType = DATATYPE_STRING;
        ainfo.isRequired = true;
        attrInfoMap.put("TIFFIFD/tagSets", ainfo);

        ainfo = new TIFFAttrInfo();
        ainfo.dataType = DATATYPE_INTEGER;
        ainfo.isRequired = false;
        attrInfoMap.put("TIFFIFD/parentTagNumber", ainfo);

        ainfo = new TIFFAttrInfo();
        ainfo.dataType = DATATYPE_STRING;
        ainfo.isRequired = false;
        attrInfoMap.put("TIFFIFD/parentTagName", ainfo);

        String[] types = {
            "TIFFByte",
            "TIFFAscii",
            "TIFFShort",
            "TIFFSShort",
            "TIFFLong",
            "TIFFSLong",
            "TIFFRational",
            "TIFFSRational",
            "TIFFFloat",
            "TIFFDouble",
            "TIFFUndefined"
        };

        attrNames = new String[] { "value", "description" };
        String[] attrNamesValueOnly = new String[] { "value" };
        TIFFAttrInfo ainfoValue = new TIFFAttrInfo();
        TIFFAttrInfo ainfoDescription = new TIFFAttrInfo();

        for (int i = 0; i < types.length; i++) {
            if (!types[i].equals("TIFFUndefined")) {
                childNames = new String[1];
                childNames[0] = types[i];
                einfo =
                    new TIFFElementInfo(childNames, empty, CHILD_POLICY_SEQUENCE);
                elementInfoMap.put(types[i] + "s", einfo);
            }

            boolean hasDescription =
                !types[i].equals("TIFFUndefined") &&
                !types[i].equals("TIFFAscii") &&
                !types[i].equals("TIFFRational") &&
                !types[i].equals("TIFFSRational") &&
                !types[i].equals("TIFFFloat") &&
                !types[i].equals("TIFFDouble");

            String[] anames = hasDescription ? attrNames : attrNamesValueOnly;
            einfo = new TIFFElementInfo(empty, anames, CHILD_POLICY_EMPTY);
            elementInfoMap.put(types[i], einfo);

            attrInfoMap.put(types[i] + "/value", ainfoValue);
            if (hasDescription) {
                attrInfoMap.put(types[i] + "/description", ainfoDescription);
            }
        }

        childNames = new String[2*types.length - 1];
        for (int i = 0; i < types.length; i++) {
            childNames[2*i] = types[i];
            if (!types[i].equals("TIFFUndefined")) {
                childNames[2*i + 1] = types[i] + "s";
            }
        }
        attrNames = new String[] { "number", "name" };
        einfo = new TIFFElementInfo(childNames, attrNames, CHILD_POLICY_CHOICE);
        elementInfoMap.put("TIFFField", einfo);

        ainfo = new TIFFAttrInfo();
        ainfo.isRequired = true;
        attrInfoMap.put("TIFFField/number", ainfo);

        ainfo = new TIFFAttrInfo();
        attrInfoMap.put("TIFFField/name", ainfo);
    }

    public static synchronized IIOMetadataFormat getInstance() {
        if (theInstance == null) {
            theInstance = new TIFFImageMetadataFormat();
        }
        return theInstance;
    }
}
