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

package javafx.scene.media;

import java.util.Map;

/**
 * A {@link Track} that contains subtitle or captioning data to be rendered
 * overlaying a video track.
 * @since JavaFX 8.0
 */
public class SubtitleTrack extends Track {
    SubtitleTrack(long trackID, Map<String,Object> metadata) {
        super(trackID, metadata);
    }
}
