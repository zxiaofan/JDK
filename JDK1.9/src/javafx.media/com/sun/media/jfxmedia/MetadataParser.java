/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmedia;

import com.sun.media.jfxmedia.events.MetadataListener;
import java.io.IOException;

public interface MetadataParser {
    // FLV and MP3
    static final String DURATION_TAG_NAME = "duration";
    // FLV
    static final String CREATIONDATE_TAG_NAME = "creationdate";
    static final String WIDTH_TAG_NAME = "width";
    static final String HEIGHT_TAG_NAME = "height";
    static final String FRAMERATE_TAG_NAME = "framerate";
    static final String VIDEOCODEC_TAG_NAME = "video codec";
    static final String AUDIOCODEC_TAG_NAME = "audio codec";
    // MP3
    static final String IMAGE_TAG_NAME = "image";
    static final String ALBUMARTIST_TAG_NAME = "album artist";
    static final String ALBUM_TAG_NAME = "album";
    static final String ARTIST_TAG_NAME = "artist";
    static final String COMMENT_TAG_NAME = "comment";
    static final String COMPOSER_TAG_NAME = "composer";
    static final String GENRE_TAG_NAME = "genre";
    static final String TITLE_TAG_NAME = "title";
    static final String TRACKNUMBER_TAG_NAME = "track number";
    static final String TRACKCOUNT_TAG_NAME = "track count";
    static final String DISCNUMBER_TAG_NAME = "disc number";
    static final String DISCCOUNT_TAG_NAME = "disc count";
    static final String YEAR_TAG_NAME = "year";
    static final String TEXT_TAG_NAME = "text";

    static final String RAW_METADATA_TAG_NAME = "raw metadata";
    static final String RAW_FLV_METADATA_NAME = "FLV";
    static final String RAW_ID3_METADATA_NAME = "ID3";

    void addListener(MetadataListener listener);

    void removeListener(MetadataListener listener);

    void startParser() throws IOException;

    void stopParser();
}
