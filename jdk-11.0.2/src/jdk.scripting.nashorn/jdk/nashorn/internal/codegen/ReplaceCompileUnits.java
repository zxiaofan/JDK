/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.codegen;

import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.ir.CompileUnitHolder;
import jdk.nashorn.internal.ir.FunctionNode;
import jdk.nashorn.internal.ir.LiteralNode;
import jdk.nashorn.internal.ir.LiteralNode.ArrayLiteralNode;
import jdk.nashorn.internal.ir.Node;
import jdk.nashorn.internal.ir.ObjectNode;
import jdk.nashorn.internal.ir.Splittable;
import jdk.nashorn.internal.ir.visitor.SimpleNodeVisitor;

/**
 * Base class for a node visitor that replaces {@link CompileUnit}s in {@link CompileUnitHolder}s.
 */
abstract class ReplaceCompileUnits extends SimpleNodeVisitor {

    /**
     * Override to provide a replacement for an old compile unit.
     * @param oldUnit the old compile unit to replace
     * @return the compile unit's replacement.
     */
    abstract CompileUnit getReplacement(final CompileUnit oldUnit);

    CompileUnit getExistingReplacement(final CompileUnitHolder node) {
        final CompileUnit oldUnit = node.getCompileUnit();
        assert oldUnit != null;

        final CompileUnit newUnit = getReplacement(oldUnit);
        assert newUnit != null;

        return newUnit;
    }

    @Override
    public Node leaveFunctionNode(final FunctionNode node) {
        return node.setCompileUnit(lc, getExistingReplacement(node));
    }

    @Override
    public Node leaveLiteralNode(final LiteralNode<?> node) {
        if (node instanceof ArrayLiteralNode) {
            final ArrayLiteralNode aln = (ArrayLiteralNode)node;
            if (aln.getSplitRanges() == null) {
                return node;
            }
            final List<Splittable.SplitRange> newArrayUnits = new ArrayList<>();
            for (final Splittable.SplitRange au : aln.getSplitRanges()) {
                newArrayUnits.add(new Splittable.SplitRange(getExistingReplacement(au), au.getLow(), au.getHigh()));
            }
            return aln.setSplitRanges(lc, newArrayUnits);
        }
        return node;
    }

    @Override
    public Node leaveObjectNode(final ObjectNode objectNode) {
        final List<Splittable.SplitRange> ranges = objectNode.getSplitRanges();
        if (ranges != null) {
            final List<Splittable.SplitRange> newRanges = new ArrayList<>();
            for (final Splittable.SplitRange range : ranges) {
                newRanges.add(new Splittable.SplitRange(getExistingReplacement(range), range.getLow(), range.getHigh()));
            }
            return objectNode.setSplitRanges(lc, newRanges);
        }
        return super.leaveObjectNode(objectNode);
    }
}
