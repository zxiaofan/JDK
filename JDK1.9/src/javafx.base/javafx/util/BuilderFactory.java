/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.util;

/**
 * Interface representing a builder factory. Builder factories are used to
 * produce builders.
 *
 * @since JavaFX 2.0
 */
@FunctionalInterface
public interface BuilderFactory {
    /**
     * Returns a builder suitable for constructing instances of the given type.
     *
     * @param type the given type or null
     *
     * @return
     * A builder for the given type, or {@code null} if this factory does not
     * produce builders for the type.
     */
    public Builder<?> getBuilder(Class<?> type);
}
