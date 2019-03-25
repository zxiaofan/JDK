/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.cmm.lcms;

import java.awt.color.CMMException;
import java.util.Arrays;
import java.util.HashMap;
import sun.java2d.cmm.Profile;

final class LCMSProfile extends Profile {
    private final TagCache tagCache;

    private final Object disposerReferent;

    LCMSProfile(long ptr, Object ref) {
        super(ptr);

        disposerReferent = ref;

        tagCache = new TagCache(this);
    }

    long getLcmsPtr() {
        return this.getNativePtr();
    }

    TagData getTag(int sig) {
        return tagCache.getTag(sig);
    }

    void clearTagCache() {
        tagCache.clear();
    }

    static class TagCache  {
        final LCMSProfile profile;
        private HashMap<Integer, TagData> tags;

        TagCache(LCMSProfile p) {
            profile = p;
            tags = new HashMap<>();
        }

        TagData getTag(int sig) {
            TagData t = tags.get(sig);
            if (t == null) {
                byte[] tagData = LCMS.getTagNative(profile.getNativePtr(), sig);
                if (tagData != null) {
                    t = new TagData(sig, tagData);
                    tags.put(sig, t);
                }
            }
            return t;
        }

        void clear() {
            tags.clear();
        }
    }

    static class TagData {
        private int signature;
        private byte[] data;

        TagData(int sig, byte[] data) {
            this.signature = sig;
            this.data = data;
        }

        int getSize() {
            return data.length;
        }

        byte[] getData() {
            return Arrays.copyOf(data, data.length);
        }

        void copyDataTo(byte[] dst) {
            System.arraycopy(data, 0, dst, 0, data.length);
        }

        int getSignature() {
            return signature;
        }
    }
}
