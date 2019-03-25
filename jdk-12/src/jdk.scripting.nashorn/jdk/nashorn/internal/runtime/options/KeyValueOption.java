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

package jdk.nashorn.internal.runtime.options;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Key Value option such as logger. It comes on the format
 * such as:
 *
 * {@code --log=module1:level1,module2:level2... }
 */
public class KeyValueOption extends Option<String> {
    /**
     * Map of keys given
     */
    protected Map<String, String> map;

    KeyValueOption(final String value) {
        super(value);
        initialize();
    }

    Map<String, String> getValues() {
        return Collections.unmodifiableMap(map);
    }

    /**
     * Check if the key value option has a value or if it has not
     * been initialized
     * @param key the key
     * @return value, or null if not initialized
     */
    public boolean hasValue(final String key) {
        return map != null && map.get(key) != null;
    }

    String getValue(final String key) {
        if (map == null) {
            return null;
        }
        final String val = map.get(key);
        return "".equals(val) ? null : val;
    }

    private void initialize() {
        if (getValue() == null) {
            return;
        }

        map = new LinkedHashMap<>();

        final StringTokenizer st = new StringTokenizer(getValue(), ",");
        while (st.hasMoreElements()) {
            final String   token    = st.nextToken();
            final String[] keyValue = token.split(":");

            if (keyValue.length == 1) {
                map.put(keyValue[0], "");
            } else if (keyValue.length == 2) {
                map.put(keyValue[0], keyValue[1]);
            } else {
                throw new IllegalArgumentException(token);
            }
        }
    }
}
