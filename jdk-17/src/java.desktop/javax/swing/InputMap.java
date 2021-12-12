/*
 * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

/**
 * {@code InputMap} provides a binding between an input event (currently only
 * {@code KeyStroke}s are used) and an {@code Object}. {@code InputMap}s are
 * usually used with an {@code ActionMap}, to determine an {@code Action} to
 * perform when a key is pressed. An {@code InputMap} can have a parent that
 * is searched for bindings not defined in the {@code InputMap}.
 * <p>As with {@code ActionMap} if you create a cycle, eg:
 * <pre>
 *   InputMap am = new InputMap();
 *   InputMap bm = new InputMap():
 *   am.setParent(bm);
 *   bm.setParent(am);
 * </pre>
 * some of the methods will cause a StackOverflowError to be thrown.
 *
 * @author Scott Violet
 * @since 1.3
 */
@SuppressWarnings("serial")
public class InputMap implements Serializable {
    /** Handles the mapping between KeyStroke and Action name. */
    private transient ArrayTable     arrayTable;
    /** Parent that handles any bindings we don't contain. */
    private InputMap                                parent;


    /**
     * Creates an {@code InputMap} with no parent and no mappings.
     */
    public InputMap() {
    }

    /**
     * Sets this {@code InputMap}'s parent.
     *
     * @param map the {@code InputMap} that is the parent of this one
     */
    public void setParent(InputMap map) {
        this.parent = map;
    }

    /**
     * Gets this {@code InputMap}'s parent.
     *
     * @return map the {@code InputMap} that is the parent of this one,
     *             or null if this {@code InputMap} has no parent
     */
    public InputMap getParent() {
        return parent;
    }

    /**
     * Adds a binding for {@code keyStroke} to {@code actionMapKey}.
     * If {@code actionMapKey} is null, this removes the current binding
     * for {@code keyStroke}.
     *
     * @param keyStroke a {@code KeyStroke}
     * @param actionMapKey an action map key
     */
    public void put(KeyStroke keyStroke, Object actionMapKey) {
        if (keyStroke == null) {
            return;
        }
        if (actionMapKey == null) {
            remove(keyStroke);
        }
        else {
            if (arrayTable == null) {
                arrayTable = new ArrayTable();
            }
            arrayTable.put(keyStroke, actionMapKey);
        }
    }

    /**
     * Returns the binding for {@code keyStroke}, messaging the
     * parent {@code InputMap} if the binding is not locally defined.
     *
     * @param keyStroke the {@code KeyStroke} for which to get the binding
     * @return the binding for {@code keyStroke}
     */
    public Object get(KeyStroke keyStroke) {
        if (arrayTable == null) {
            InputMap    parent = getParent();

            if (parent != null) {
                return parent.get(keyStroke);
            }
            return null;
        }
        Object value = arrayTable.get(keyStroke);

        if (value == null) {
            InputMap    parent = getParent();

            if (parent != null) {
                return parent.get(keyStroke);
            }
        }
        return value;
    }

    /**
     * Removes the binding for {@code key} from this {@code InputMap}.
     *
     * @param key the {@code KeyStroke} for which to remove the binding
     */
    public void remove(KeyStroke key) {
        if (arrayTable != null) {
            arrayTable.remove(key);
        }
    }

    /**
     * Removes all the mappings from this {@code InputMap}.
     */
    public void clear() {
        if (arrayTable != null) {
            arrayTable.clear();
        }
    }

    /**
     * Returns the {@code KeyStroke}s that are bound in this {@code InputMap}.
     *
     * @return an array of the {@code KeyStroke}s that are bound in this
     *         {@code InputMap}
     */
    public KeyStroke[] keys() {
        if (arrayTable == null) {
            return null;
        }
        KeyStroke[] keys = new KeyStroke[arrayTable.size()];
        arrayTable.getKeys(keys);
        return keys;
    }

    /**
     * Returns the number of {@code KeyStroke} bindings.
     *
     * @return the number of {@code KeyStroke} bindings
     */
    public int size() {
        if (arrayTable == null) {
            return 0;
        }
        return arrayTable.size();
    }

    /**
     * Returns an array of the {@code KeyStroke}s defined in this
     * {@code InputMap} and its parent. This differs from {@code keys()}
     * in that this method includes the keys defined in the parent.
     *
     * @return an array of the {@code KeyStroke}s defined in this
     *         {@code InputMap} and its parent
     */
    public KeyStroke[] allKeys() {
        int             count = size();
        InputMap        parent = getParent();

        if (count == 0) {
            if (parent != null) {
                return parent.allKeys();
            }
            return keys();
        }
        if (parent == null) {
            return keys();
        }
        KeyStroke[]    keys = keys();
        KeyStroke[]    pKeys =  parent.allKeys();

        if (pKeys == null) {
            return keys;
        }
        if (keys == null) {
            // Should only happen if size() != keys.length, which should only
            // happen if mutated from multiple threads (or a bogus subclass).
            return pKeys;
        }

        HashMap<KeyStroke, KeyStroke> keyMap = new HashMap<KeyStroke, KeyStroke>();
        int            counter;

        for (counter = keys.length - 1; counter >= 0; counter--) {
            keyMap.put(keys[counter], keys[counter]);
        }
        for (counter = pKeys.length - 1; counter >= 0; counter--) {
            keyMap.put(pKeys[counter], pKeys[counter]);
        }

        KeyStroke[]    allKeys = new KeyStroke[keyMap.size()];

        return keyMap.keySet().toArray(allKeys);
    }

    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();

        ArrayTable.writeArrayTable(s, arrayTable);
    }

    @Serial
    private void readObject(ObjectInputStream s) throws ClassNotFoundException,
                                                 IOException {
        s.defaultReadObject();
        for (int counter = s.readInt() - 1; counter >= 0; counter--) {
            put((KeyStroke)s.readObject(), s.readObject());
        }
    }
}
