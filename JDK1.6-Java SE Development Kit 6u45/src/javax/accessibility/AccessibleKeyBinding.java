/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.accessibility;

/**
 * The AccessibleKeyBinding interface should be supported by any object
 * that has a keyboard bindings such as a keyboard mnemonic and/or keyboard
 * shortcut which can be used to select the object.  This interface provides
 * the standard mechanism for an assistive technology to determine the
 * key bindings which exist for this object.
 * Any object that has such key bindings should support this
 * interface.  Applications can determine if an object supports the
 * AccessibleKeyBinding interface by first obtaining its AccessibleContext
 * (see @link Accessible} and then calling the
 * {@link AccessibleContext#getAccessibleKeyBinding} method.  If the return
 * value is not null, the object supports this interface.
 *
 * @see Accessible
 * @see Accessible#getAccessibleContext
 * @see AccessibleContext
 * @see AccessibleContext#getAccessibleKeyBinding
 *
 * @version     %I% %G%
 * @author	Lynn Monsanto
 * @since 1.4
 */
public interface AccessibleKeyBinding {

    /**
     * Returns the number of key bindings for this object
     *
     * @return the zero-based number of key bindings for this object
     */
    public int getAccessibleKeyBindingCount();

    /**
     * Returns a key binding for this object.  The value returned is an
     * java.lang.Object which must be cast to appropriate type depending
     * on the underlying implementation of the key.  For example, if the
     * Object returned is a javax.swing.KeyStroke, the user of this
     * method should do the following:
     * <nf><code>
     * Component c = <get the component that has the key bindings>
     * AccessibleContext ac = c.getAccessibleContext();
     * AccessibleKeyBinding akb = ac.getAccessibleKeyBinding();
     * for (int i = 0; i < akb.getAccessibleKeyBindingCount(); i++) {
     *     Object o = akb.getAccessibleKeyBinding(i);
     *     if (o instanceof javax.swing.KeyStroke) {
     *         javax.swing.KeyStroke keyStroke = (javax.swing.KeyStroke)o;
     *         <do something with the key binding>
     *     }
     * }
     * </code></nf>
     *
     * @param i zero-based index of the key bindings
     * @return a javax.lang.Object which specifies the key binding
     * @see #getAccessibleKeyBindingCount
     */
    public java.lang.Object getAccessibleKeyBinding(int i);
}
