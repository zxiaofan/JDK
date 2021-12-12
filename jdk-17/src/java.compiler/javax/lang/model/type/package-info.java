/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Interfaces used to model Java programming language types.
 *
 * <p> Unless otherwise specified in a particular implementation, the
 * collections returned by methods in this package should be expected
 * to be unmodifiable by the caller and unsafe for concurrent access.
 *
 * <p> Unless otherwise specified, methods in this package will throw
 * a {@code NullPointerException} if given a {@code null} argument.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see javax.lang.model.util.Types
 * @jls 4.1 The Kinds of Types and Values
 * @jls 4.2 Primitive Types and Values
 * @jls 4.3 Reference Types and Values
 * @jls 4.4 Type Variables
 * @jls 4.5 Parameterized Types
 * @jls 4.8 Raw Types
 * @jls 4.9 Intersection Types
 * @jls 10.1 Array Types
 * @since 1.6
 */
package javax.lang.model.type;
