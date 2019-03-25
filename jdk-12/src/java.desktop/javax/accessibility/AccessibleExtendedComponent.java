/*
 * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.accessibility;

/**
 * The {@code AccessibleExtendedComponent} interface should be supported by any
 * object that is rendered on the screen. This interface provides the standard
 * mechanism for an assistive technology to determine the extended graphical
 * representation of an object. Applications can determine if an object supports
 * the {@code AccessibleExtendedComponent} interface by first obtaining its
 * {@code AccessibleContext} and then calling the
 * {@link AccessibleContext#getAccessibleComponent} method. If the return value
 * is not {@code null} and the type of the return value is
 * {@code AccessibleExtendedComponent}, the object supports this interface.
 *
 * @author Lynn Monsanto
 * @see Accessible
 * @see Accessible#getAccessibleContext
 * @see AccessibleContext
 * @see AccessibleContext#getAccessibleComponent
 * @since 1.4
 */
public interface AccessibleExtendedComponent extends AccessibleComponent {

    /**
     * Returns the tool tip text.
     *
     * @return the tool tip text, if supported, of the object; otherwise,
     *         {@code null}
     */
    public String getToolTipText();

    /**
     * Returns the titled border text.
     *
     * @return the titled border text, if supported, of the object; otherwise,
     *         {@code null}
     */
    public String getTitledBorderText();

    /**
     * Returns key bindings associated with this object.
     *
     * @return the key bindings, if supported, of the object; otherwise,
     *         {@code null}
     * @see AccessibleKeyBinding
     */
    public AccessibleKeyBinding getAccessibleKeyBinding();
}
