/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.ir;

import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import jdk.nashorn.internal.codegen.types.Type;
import jdk.nashorn.internal.ir.annotations.Ignore;
import jdk.nashorn.internal.ir.annotations.Immutable;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;

/**
 * IR representation of an object literal.
 */
@Immutable
public final class ObjectNode extends Expression implements LexicalContextNode, Splittable {
    private static final long serialVersionUID = 1L;

    /** Literal elements. */
    private final List<PropertyNode> elements;

    /** Ranges for splitting large literals over multiple compile units in codegen. */
    @Ignore
    private final List<Splittable.SplitRange> splitRanges;

    /**
     * Constructor
     *
     * @param token    token
     * @param finish   finish
     * @param elements the elements used to initialize this ObjectNode
     */
    public ObjectNode(final long token, final int finish, final List<PropertyNode> elements) {
        super(token, finish);
        this.elements = elements;
        this.splitRanges = null;
        assert elements instanceof RandomAccess : "Splitting requires random access lists";
    }

    private ObjectNode(final ObjectNode objectNode, final List<PropertyNode> elements,
                       final List<Splittable.SplitRange> splitRanges ) {
        super(objectNode);
        this.elements = elements;
        this.splitRanges = splitRanges;
    }

    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        return Acceptor.accept(this, visitor);
    }

    @Override
    public Node accept(final LexicalContext lc, final NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterObjectNode(this)) {
            return visitor.leaveObjectNode(setElements(lc, Node.accept(visitor, elements)));
        }
        return this;
    }

    @Override
    public Type getType() {
        return Type.OBJECT;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        sb.append('{');

        if (!elements.isEmpty()) {
            sb.append(' ');

            boolean first = true;
            for (final Node element : elements) {
                if (!first) {
                    sb.append(", ");
                }
                first = false;

                element.toString(sb, printType);
            }
            sb.append(' ');
        }

        sb.append('}');
    }

    /**
     * Get the elements of this literal node
     * @return a list of elements
     */
    public List<PropertyNode> getElements() {
        return Collections.unmodifiableList(elements);
    }

    private ObjectNode setElements(final LexicalContext lc, final List<PropertyNode> elements) {
        if (this.elements == elements) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new ObjectNode(this, elements, this.splitRanges));
    }

    /**
     * Set the split ranges for this ObjectNode
     * @see Splittable.SplitRange
     * @param lc the lexical context
     * @param splitRanges list of split ranges
     * @return new or changed object node
     */
    public ObjectNode setSplitRanges(final LexicalContext lc, final List<Splittable.SplitRange> splitRanges) {
        if (this.splitRanges == splitRanges) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new ObjectNode(this, elements, splitRanges));
    }

    /**
     * Get the split ranges for this ObjectNode, or null if the object is not split.
     * @see Splittable.SplitRange
     * @return list of split ranges
     */
    @Override
    public List<Splittable.SplitRange> getSplitRanges() {
        return splitRanges == null ? null : Collections.unmodifiableList(splitRanges);
    }

}
