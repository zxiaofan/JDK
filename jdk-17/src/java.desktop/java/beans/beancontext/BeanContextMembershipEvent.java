/*
 * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.beans.beancontext;

import java.io.Serial;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * A {@code BeanContextMembershipEvent} encapsulates
 * the list of children added to, or removed from,
 * the membership of a particular {@code BeanContext}.
 * An instance of this event is fired whenever a successful
 * add(), remove(), retainAll(), removeAll(), or clear() is
 * invoked on a given {@code BeanContext} instance.
 * Objects interested in receiving events of this type must
 * implement the {@code BeanContextMembershipListener}
 * interface, and must register their intent via the
 * {@code BeanContext}'s
 * {@code addBeanContextMembershipListener(BeanContextMembershipListener bcml)}
 * method.
 *
 * @author      Laurence P. G. Cable
 * @since       1.2
 * @see         java.beans.beancontext.BeanContext
 * @see         java.beans.beancontext.BeanContextEvent
 * @see         java.beans.beancontext.BeanContextMembershipListener
 */
public class BeanContextMembershipEvent extends BeanContextEvent {

    /**
     * Use serialVersionUID from JDK 1.7 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 3499346510334590959L;

    /**
     * Contruct a BeanContextMembershipEvent
     *
     * @param bc        The BeanContext source
     * @param changes   The Children affected
     * @throws NullPointerException if {@code changes} is {@code null}
     */

    @SuppressWarnings("rawtypes")
    public BeanContextMembershipEvent(BeanContext bc, Collection changes) {
        super(bc);

        if (changes == null) throw new NullPointerException(
            "BeanContextMembershipEvent constructor:  changes is null.");

        children = changes;
    }

    /**
     * Contruct a BeanContextMembershipEvent
     *
     * @param bc        The BeanContext source
     * @param changes   The Children effected
     * @exception       NullPointerException if changes associated with this
     *                  event are null.
     */

    public BeanContextMembershipEvent(BeanContext bc, Object[] changes) {
        super(bc);

        if (changes == null) throw new NullPointerException(
            "BeanContextMembershipEvent:  changes is null.");

        children = Arrays.asList(changes);
    }

    /**
     * Gets the number of children affected by the notification.
     * @return the number of children affected by the notification
     */
    public int size() { return children.size(); }

    /**
     * Is the child specified affected by the event?
     * @return {@code true} if affected, {@code false}
     * if not
     * @param child the object to check for being affected
     */
    public boolean contains(Object child) {
        return children.contains(child);
    }

    /**
     * Gets the array of children affected by this event.
     * @return the array of children affected
     */
    public Object[] toArray() { return children.toArray(); }

    /**
     * Gets the array of children affected by this event.
     * @return the array of children effected
     */
    @SuppressWarnings("rawtypes")
    public Iterator iterator() { return children.iterator(); }

    /*
     * fields
     */

   /**
    * The list of children affected by this
    * event notification.
    */
    @SuppressWarnings({"rawtypes",
                       "serial"}) // Not statically typed as Serializable
    protected Collection children;
}
