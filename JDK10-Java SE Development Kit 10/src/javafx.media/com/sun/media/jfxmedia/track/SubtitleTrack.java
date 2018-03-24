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

package com.sun.media.jfxmedia.track;

import java.util.Locale;

/**
 * A class representing a subtitle or captioning track in media.
 */
public class SubtitleTrack extends Track {
    public SubtitleTrack(boolean enabled, long trackID, String name, Locale locale, Encoding encoding) {
        super(enabled, trackID, name, locale, encoding);
    }
}
