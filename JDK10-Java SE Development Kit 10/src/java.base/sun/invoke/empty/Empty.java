/*
 * Copyright (c) 2009, 2011, Oracle and/or its affiliates. All rights reserved.
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

package sun.invoke.empty;

/**
 * An empty class in an empty package.
 * Used as a proxy for unprivileged code, since making access checks
 * against it will only succeed against public methods in public types.
 * <p>
 * This class also stands (internally to sun.invoke) for the type of a
 * value that cannot be produced, because the expression of this type
 * always returns abnormally.  (Cf. Nothing in the closures proposal.)
 * @author jrose
 */
public class Empty {
    private Empty() { throw new InternalError(); }
}
