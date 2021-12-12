/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Interface {@code Accessible} is the main interface for the accessibility
 * package. All components that support the accessibility package must implement
 * this interface. It contains a single method, {@link #getAccessibleContext},
 * which returns an instance of the class {@link AccessibleContext}.
 *
 * @author Peter Korn
 * @author Hans Muller
 * @author Willie Walker
 */
public interface Accessible {

    /**
     * Returns the {@code AccessibleContext} associated with this object. In
     * most cases, the return value should not be {@code null} if the object
     * implements interface {@code Accessible}. If a component developer creates
     * a subclass of an object that implements {@code Accessible}, and that
     * subclass is not {@code Accessible}, the developer should override the
     * {@code getAccessibleContext} method to return {@code null}.
     *
     * @return the {@code AccessibleContext} associated with this object
     */
    public AccessibleContext getAccessibleContext();
}
