/*
 * Copyright (c) 2005, 2016, Oracle and/or its affiliates. All rights reserved.
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
package javax.imageio.plugins.tiff;

import java.util.ArrayList;
import java.util.List;

/**
 * A class containing the TIFF tags used to reference the Exif and GPS IFDs.
 * This tag set should be added to the root tag set by means of the
 * {@link TIFFImageReadParam#addAllowedTagSet(TIFFTagSet)
 * TIFFImageReadParam.addAllowedTagSet} method if Exif
 * support is desired.
 *
 * @since 9
 */
public final class ExifParentTIFFTagSet extends TIFFTagSet {

    private static ExifParentTIFFTagSet theInstance = null;

    // 34665 - Exif IFD Pointer                   (LONG/1)
    /** Tag pointing to the Exif IFD (type LONG). */
    public static final int TAG_EXIF_IFD_POINTER = 34665;

    /** Tag pointing to a GPS info IFD (type LONG). */
    public static final int TAG_GPS_INFO_IFD_POINTER = 34853;

    // To be inserted into parent (root) TIFFTagSet
    static class ExifIFDPointer extends TIFFTag {

        public ExifIFDPointer() {
            super("ExifIFDPointer",
                  TAG_EXIF_IFD_POINTER,
                  ExifTIFFTagSet.getInstance());
        }
    }

    // To be inserted into parent (root) TIFFTagSet
    static class GPSInfoIFDPointer extends TIFFTag {

        public GPSInfoIFDPointer() {
            super("GPSInfoIFDPointer",
                  TAG_GPS_INFO_IFD_POINTER,
                  ExifGPSTagSet.getInstance());
        }
    }

    private static List<TIFFTag> tags;

    private static void initTags() {
        tags = new ArrayList<TIFFTag>(1);
        tags.add(new ExifParentTIFFTagSet.ExifIFDPointer());
        tags.add(new ExifParentTIFFTagSet.GPSInfoIFDPointer());
    }

    private ExifParentTIFFTagSet() {
        super(tags);
    }

    /**
     * Returns a shared instance of an {@code ExifParentTIFFTagSet}.
     *
     * @return an {@code ExifParentTIFFTagSet} instance.
     */
    public synchronized static ExifParentTIFFTagSet getInstance() {
        if (theInstance == null) {
            initTags();
            theInstance = new ExifParentTIFFTagSet();
            tags = null;
        }
        return theInstance;
    }
}
