/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.pkcs11;

import java.util.*;
import java.lang.ref.*;

import java.security.Key;

import sun.security.util.Cache;

/**
 * Key to P11Key translation cache. The PKCS#11 token can only perform
 * operations on keys stored on the token (permanently or temporarily). That
 * means that in order to allow the PKCS#11 provider to use keys from other
 * providers, we need to transparently convert them to P11Keys. The engines
 * do that using (Secret)KeyFactories, which in turn use this class as a
 * cache.
 *
 * There are two KeyCache instances per provider, one for secret keys and
 * one for public and private keys.
 *
 * @author  Andreas Sterbenz
 * @since   1.5
 */
final class KeyCache {

    private final Cache<IdentityWrapper, P11Key> strongCache;

    private WeakReference<Map<Key,P11Key>> cacheReference;

    KeyCache() {
        strongCache = Cache.newHardMemoryCache(16);
    }

    private static final class IdentityWrapper {
        final Object obj;
        IdentityWrapper(Object obj) {
            this.obj = obj;
        }
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof IdentityWrapper == false) {
                return false;
            }
            IdentityWrapper other = (IdentityWrapper)o;
            return this.obj == other.obj;
        }
        public int hashCode() {
            return System.identityHashCode(obj);
        }
    }

    synchronized P11Key get(Key key) {
        P11Key p11Key = strongCache.get(new IdentityWrapper(key));
        if (p11Key != null) {
            return p11Key;
        }
        Map<Key,P11Key> map =
                (cacheReference == null) ? null : cacheReference.get();
        if (map == null) {
            return null;
        }
        return map.get(key);
    }

    synchronized void put(Key key, P11Key p11Key) {
        strongCache.put(new IdentityWrapper(key), p11Key);
        Map<Key,P11Key> map =
                (cacheReference == null) ? null : cacheReference.get();
        if (map == null) {
            map = new IdentityHashMap<>();
            cacheReference = new WeakReference<>(map);
        }
        map.put(key, p11Key);
    }

    synchronized void clear() {
        strongCache.clear();
        cacheReference = null;
    }
}
