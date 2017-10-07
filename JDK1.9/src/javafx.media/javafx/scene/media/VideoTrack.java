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
 * A {@link Track} that describes a video track. This will usually be the unique
 * visual track in an audiovisual media resource.
 * @since JavaFX 2.0
 */
public final class VideoTrack extends Track {
    /**
     * The width in pixels of the video contained in this video track.
     */
    private int width;

    /**
     * Retrieves the width of the track.
     * @return the track width.
     */
    public final int getWidth() {
        return width;
    }

    /**
     * The height in pixels of the video contained in this video track.
     */
    private int height;

    /**
     * Retrieves the height of the track.
     * @return the track height.
     */
    public final int getHeight() {
        return height;
    }

    VideoTrack(long trackID, Map<String,Object> metadata) {
        super(trackID, metadata);

        Object value = metadata.get("video width");
        if (null != value && value instanceof Number) {
            this.width = ((Number)value).intValue();
        }

        value = metadata.get("video height");
        if (null != value && value instanceof Number) {
            this.height = ((Number)value).intValue();
        }
    }
}
