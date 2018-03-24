/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind;

import javax.xml.bind.ValidationEventLocator;

/**
 * Defines additional accessor methods for the event source location.
 * <p>
 * This interface exposes the location information only available
 * in the JAXB RI specific extension.
 * <p>
 * <em>DO NOT IMPLEMENT THIS INTERFACE BY YOUR CODE</em> because
 * we might add more methods on this interface in the future release
 * of the RI.
 *
 * <h2>Usage</h2>
 * <p>
 * If you obtain a reference to {@link javax.xml.bind.ValidationEventLocator},
 * check if you can cast it to {@link ValidationEventLocatorEx} first, like this:
 * <pre>
 * void foo( ValidationEvent e ) {
 *     ValidationEventLocator loc = e.getLocator();
 *     if( loc instanceof ValidationEventLocatorEx ) {
 *         String fieldName = ((ValidationEventLocatorEx)loc).getFieldName();
 *         if( fieldName!=null ) {
 *             // do something with location.
 *         }
 *     }
 * }
 * </pre>
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface ValidationEventLocatorEx extends ValidationEventLocator {
    /**
     * Returns the field name of the object where the error occured.
     * <p>
     * This method always returns null when you are doing
     * a validation during unmarshalling.
     *
     * When not null, the field name indicates the field of the object
     * designated by the {@link #getObject()} method where the error
     * occured.
     */
    String getFieldName();
}
