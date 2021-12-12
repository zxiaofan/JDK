/*
 * Copyright (c) 2019, 2020, Oracle and/or its affiliates. All rights reserved.
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

package javax.lang.model.element;

/**
 * Represents a record component.
 *
 * @since 16
 */
public interface RecordComponentElement extends Element {
    /**
     * {@return the enclosing element of this record component}
     *
     * The enclosing element of a record component is the record class
     * declaring the record component.
     */
    @Override
    Element getEnclosingElement();

    /**
     * {@return the simple name of this record component}
     *
     * <p>The name of each record component must be distinct from the
     * names of all other record components of the same record.
     *
     * @jls 6.2 Names and Identifiers
     */
    @Override
    Name getSimpleName();

    /**
     * Returns the executable element for the accessor associated with the
     * given record component.
     *
     * @return the record component accessor.
     */
    ExecutableElement getAccessor();
}
