/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.httpserver;

import java.util.*;
import com.sun.net.httpserver.*;

class UnmodifiableHeaders extends Headers {

        Headers map;

        UnmodifiableHeaders(Headers map) {
            this.map = map;
        }

        public int size() {return map.size();}

        public boolean isEmpty() {return map.isEmpty();}

        public boolean containsKey(Object key) {
            return map.containsKey (key);
        }

        public boolean containsValue(Object value) {
            return map.containsValue(value);
        }

        public List<String> get(Object key) {
            return map.get(key);
        }

        public String getFirst (String key) {
            return map.getFirst(key);
        }


        public List<String> put(String key, List<String> value) {
            return map.put (key, value);
        }

        public void add (String key, String value) {
            throw new UnsupportedOperationException ("unsupported operation");
        }

        public void set (String key, String value) {
            throw new UnsupportedOperationException ("unsupported operation");
        }

        public List<String> remove(Object key) {
            throw new UnsupportedOperationException ("unsupported operation");
        }

        public void putAll(Map<? extends String,? extends List<String>> t)  {
            throw new UnsupportedOperationException ("unsupported operation");
        }

        public void clear() {
            throw new UnsupportedOperationException ("unsupported operation");
        }

        public Set<String> keySet() {
            return Collections.unmodifiableSet (map.keySet());
        }

        public Collection<List<String>> values() {
            return Collections.unmodifiableCollection(map.values());
        }

        /* TODO check that contents of set are not modifable : security */

        public Set<Map.Entry<String, List<String>>> entrySet() {
            return Collections.unmodifiableSet (map.entrySet());
        }

        public boolean equals(Object o) {return map.equals(o);}

        public int hashCode() {return map.hashCode();}
    }
