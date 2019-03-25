/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.api.tree;


/**
 * Indicates that an unknown kind of Tree was encountered.  This
 * can occur if the language evolves and new kinds of Trees are
 * added to the {@code Tree} hierarchy.  May be thrown by a
 * {@linkplain TreeVisitor tree visitor} to indicate that the
 * visitor was created for a prior version of the language.
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public class UnknownTreeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private transient final Tree tree;
    private transient final Object parameter;

    /**
     * Creates a new {@code UnknownTreeException}.  The {@code p}
     * parameter may be used to pass in an additional argument with
     * information about the context in which the unknown element was
     * encountered; for example, the visit methods of {@link
     * TreeVisitor} may pass in their additional parameter.
     *
     * @param t the unknown tree, may be {@code null}
     * @param p an additional parameter, may be {@code null}
     */
    public UnknownTreeException(final Tree t, final Object p) {
        super("Unknown tree: " + t);
        this.tree = t;
        this.parameter = p;
    }

    /**
     * Returns the unknown tree.
     * The value may be unavailable if this exception has been
     * serialized and then read back in.
     *
     * @return the unknown element, or {@code null} if unavailable
     */
    public Tree getUnknownTree() {
        return tree;
    }

    /**
     * Returns the additional argument.
     * The value may be unavailable if this exception has been
     * serialized and then read back in.
     *
     * @return the additional argument
     */
    public Object getArgument() {
        return parameter;
    }
}
