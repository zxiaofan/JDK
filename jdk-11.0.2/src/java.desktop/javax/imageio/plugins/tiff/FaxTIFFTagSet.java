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
 * A class representing the extra tags found in a
 * <a href="http://tools.ietf.org/html/rfc2306.html">TIFF-F</a> (RFC 2036) file.
 *
 * @since 9
 */
public final class FaxTIFFTagSet extends TIFFTagSet {

    private static FaxTIFFTagSet theInstance = null;

    /** Tag indicating the number of bad fax lines (type SHORT or LONG). */
    public static final int TAG_BAD_FAX_LINES = 326;

    /**
     * Tag indicating the number of lines of clean fax data (type
     * SHORT).
     *
     * @see #CLEAN_FAX_DATA_NO_ERRORS
     * @see #CLEAN_FAX_DATA_ERRORS_CORRECTED
     * @see #CLEAN_FAX_DATA_ERRORS_UNCORRECTED
     */
    public static final int TAG_CLEAN_FAX_DATA = 327;

    /**
     * A value to be used with the "CleanFaxData" tag.
     *
     * @see #TAG_CLEAN_FAX_DATA
     */
    public static final int CLEAN_FAX_DATA_NO_ERRORS = 0;

    /**
     * A value to be used with the "CleanFaxData" tag.
     *
     * @see #TAG_CLEAN_FAX_DATA
     */
    public static final int CLEAN_FAX_DATA_ERRORS_CORRECTED = 1;

    /**
     * A value to be used with the "CleanFaxData" tag.
     *
     * @see #TAG_CLEAN_FAX_DATA
     */
    public static final int CLEAN_FAX_DATA_ERRORS_UNCORRECTED = 2;

    /**
     * Tag indicating the number of consecutive bad lines (type
     * SHORT or LONG).
     */
    public static final int TAG_CONSECUTIVE_BAD_LINES = 328;

    static class BadFaxLines extends TIFFTag {

        public BadFaxLines() {
            super("BadFaxLines",
                  TAG_BAD_FAX_LINES,
                  1 << TIFF_SHORT |
                  1 << TIFF_LONG,
                  1);
        }
    }

    static class CleanFaxData extends TIFFTag {

        public CleanFaxData() {
            super("CleanFaxData",
                  TAG_CLEAN_FAX_DATA,
                  1 << TIFF_SHORT,
                  1);

            addValueName(CLEAN_FAX_DATA_NO_ERRORS,
                         "No errors");
            addValueName(CLEAN_FAX_DATA_ERRORS_CORRECTED,
                         "Errors corrected");
            addValueName(CLEAN_FAX_DATA_ERRORS_UNCORRECTED,
                         "Errors uncorrected");
        }
    }

    static class ConsecutiveBadFaxLines extends TIFFTag {

        public ConsecutiveBadFaxLines() {
            super("ConsecutiveBadFaxLines",
                  TAG_CONSECUTIVE_BAD_LINES,
                  1 << TIFF_SHORT |
                  1 << TIFF_LONG,
                  1);
        }
    }

    private static List<TIFFTag> tags;

    private static void initTags() {
        tags = new ArrayList<TIFFTag>(42);

        tags.add(new FaxTIFFTagSet.BadFaxLines());
        tags.add(new FaxTIFFTagSet.CleanFaxData());
        tags.add(new FaxTIFFTagSet.ConsecutiveBadFaxLines());
    }

    private FaxTIFFTagSet() {
        super(tags);
    }

    /**
     * Returns a shared instance of a {@code FaxTIFFTagSet}.
     *
     * @return a {@code FaxTIFFTagSet} instance.
     */
    public synchronized static FaxTIFFTagSet getInstance() {
        if (theInstance == null) {
            initTags();
            theInstance = new FaxTIFFTagSet();
            tags = null;
        }
        return theInstance;
    }
}
