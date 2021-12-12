/*
 * Copyright (c) 2013, 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;

import sun.java2d.cmm.Profile;

final class LCMSProfile extends Profile {

    private final Object disposerReferent;
    private final Map<Integer, byte[]> tags = new ConcurrentHashMap<>();
    private final StampedLock lock = new StampedLock();

    LCMSProfile(long ptr, Object ref) {
        super(ptr);
        disposerReferent = ref;
    }

    long getLcmsPtr() {
        return getNativePtr();
    }

    byte[] getProfileData() {
        long stamp = lock.readLock();
        try {
            return LCMS.getProfileDataNative(getNativePtr());
        } finally {
            lock.unlockRead(stamp);
        }
    }

    byte[] getTag(int sig) {
        byte[] t = tags.get(sig);
        if (t != null) {
            return t;
        }
        long stamp = lock.readLock();
        try {
            return tags.computeIfAbsent(sig, (key) -> {
                return LCMS.getTagNative(getNativePtr(), key);
            });
        } finally {
            lock.unlockRead(stamp);
        }
    }

    void setTag(int tagSignature, byte[] data) {
        long stamp = lock.writeLock();
        try {
            tags.clear();
            // Now we are going to update the profile with new tag data
            // In some cases, we may change the pointer to the native profile.
            //
            // If we fail to write tag data for any reason, the old pointer
            // should be used.
            LCMS.setTagDataNative(getNativePtr(), tagSignature, data);
        } finally {
            lock.unlockWrite(stamp);
        }
    }
}
