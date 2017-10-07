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
package com.sun.media.jfxmedia.locator;

import com.sun.media.jfxmedia.logging.Logger;
import com.sun.media.jfxmediaimpl.MediaDisposer;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Local in-memory cache for frequently loaded media, e.g., AudioClips
 */
public class LocatorCache {
    private static class CacheInitializer {
        private static final LocatorCache globalInstance = new LocatorCache();
    }

    public static LocatorCache locatorCache() {
        return CacheInitializer.globalInstance;
    }

    private final Map<URI,WeakReference<CacheReference>> uriCache;
    private final CacheDisposer cacheDisposer;

    private LocatorCache() {
        uriCache = new HashMap<URI,WeakReference<CacheReference>>();
        cacheDisposer = new CacheDisposer();
    }

    /*
     * MIME type is cached so that Locator doesn't need to talk to the server,
     * it can just get the type and buffer and be done
     */
    public CacheReference registerURICache(URI sourceURI, ByteBuffer data, String mimeType) {
        if (Logger.canLog(Logger.DEBUG)) {
            Logger.logMsg(Logger.DEBUG, "New cache entry: URI " + sourceURI
                    +", buffer "+data
                    +", MIME type "+mimeType);
        }

        // ensure the given ByteBuffer is a direct buffer, required for native access
        if (!data.isDirect()) {
            data.rewind();
            ByteBuffer newData = ByteBuffer.allocateDirect(data.capacity());
            newData.put(data);
            data = newData;
        }

        CacheReference ref = new CacheReference(data, mimeType);
        synchronized (uriCache) {
            uriCache.put(sourceURI, new WeakReference(ref));
        }

        // Now register sourceURI with the disposer so we can remove it
        // from uriCache when our cache entry gets collected
        MediaDisposer.addResourceDisposer(ref, sourceURI, cacheDisposer);
        return ref;
    }

    public CacheReference fetchURICache(URI sourceURI) {
        synchronized (uriCache) {
            WeakReference<CacheReference> ref = uriCache.get(sourceURI);
            if (null == ref) {
                return null;
            }

            CacheReference cacheData = ref.get();
            if (null != cacheData) {
                if (Logger.canLog(Logger.DEBUG)) {
                    Logger.logMsg(Logger.DEBUG, "Fetched cache entry: URI "+sourceURI
                            +", buffer "+cacheData.getBuffer()
                            +", MIME type "+cacheData.getMIMEType()
                            );
                }

                return cacheData;
            }
        }
        return null;
    }

    public boolean isCached(URI sourceURI) {
        synchronized (uriCache) {
            return uriCache.containsKey(sourceURI);
        }
    }

    public static class CacheReference {
        private final ByteBuffer buffer;
        private String mimeType;

        public CacheReference(ByteBuffer buf, String mimeType) {
            buffer = buf;
            this.mimeType = mimeType;
        }

        public ByteBuffer getBuffer() {
            return buffer;
        }

        public String getMIMEType() {
            return mimeType;
        }
    }

    private class CacheDisposer implements MediaDisposer.ResourceDisposer {
        public void disposeResource(Object resource) {
            // resource will be the URI that the CacheReference was stored against
            // use it to remove the entry from uriCache, this way we don't need
            // to periodically purge the Map
            if (resource instanceof URI) {
                synchronized (uriCache) {
                    uriCache.remove((URI)resource);
                }
            }
        }
    }
}
