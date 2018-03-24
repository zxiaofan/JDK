/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.media;

import java.util.Locale;
import java.util.Map;

/**
 * A {@link Track} that describes an audio track. An audio track may for example
 * be the unique track in a piece of digital music or one of several tracks in
 * an audiovisual media resource.
 * @since JavaFX 2.0
 */
public final class AudioTrack extends Track {
    /**
     * Retrieves the language of the audio track. The IANA language code might
     * be for example "en" for English or "ru" for Russian. The list of all
     * registered IANA language codes is available in the
     * <a href="http://www.iana.org/assignments/language-subtag-registry">
     * IANA Language Subtag Registry</a>.
     * @return the IANA language code or <code>null</code>.
     * @deprecated Use {@link Track#getLocale()} instead.
     */
    @Deprecated
    public final String getLanguage() {
        Locale l = getLocale();
        return (null == l) ? null : l.getLanguage();
    }

    AudioTrack(long trackID, Map<String,Object> metadata) {
        super(trackID, metadata);
    }
}
