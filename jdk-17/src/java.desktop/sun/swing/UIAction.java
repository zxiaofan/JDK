/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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
package sun.swing;

import java.beans.PropertyChangeListener;

import javax.swing.Action;

/**
 * UIAction is the basis of all of basic's action classes that are used in
 * an ActionMap. Subclasses need to override <code>actionPerformed</code>.
 * <p>
 * A typical subclass will look like:
 * <pre>
 *    private static class Actions extends UIAction {
 *        Actions(String name) {
 *            super(name);
 *        }
 *
 *        public void actionPerformed(ActionEvent ae) {
 *            if (getName() == "selectAll") {
 *                selectAll();
 *            }
 *            else if (getName() == "cancelEditing") {
 *                cancelEditing();
 *            }
 *        }
 *    }
 * </pre>
 * <p>
 * Subclasses that wish to conditionalize the enabled state should override
 * <code>isEnabled(Component)</code>, and be aware that the passed in
 * <code>Component</code> may be null.
 *
 * @see javax.swing.Action
 * @author Scott Violet
 */
public abstract class UIAction implements Action {
    private String name;

    public UIAction(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public Object getValue(String key) {
        if (key == NAME) {
            return name;
        }
        return null;
    }

    // UIAction is not mutable, this does nothing.
    public void putValue(String key, Object value) {
    }

    // UIAction is not mutable, this does nothing.
    public void setEnabled(boolean b) {
    }

    /**
     * Cover method for <code>isEnabled(null)</code>.
     */
    public final boolean isEnabled() {
        return accept(null);
    }

    /**
     * Subclasses that need to conditionalize the enabled state should
     * override this. Be aware that <code>sender</code> may be null.
     *
     * @param sender Widget enabled state is being asked for, may be null.
     */
    @Override
    public boolean accept(Object sender) {
        return true;
    }

    // UIAction is not mutable, this does nothing.
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }

    // UIAction is not mutable, this does nothing.
    public void removePropertyChangeListener(PropertyChangeListener listener) {
    }
}
