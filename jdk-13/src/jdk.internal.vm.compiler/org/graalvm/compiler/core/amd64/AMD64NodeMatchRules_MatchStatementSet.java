// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: AMD64NodeMatchRules.java
package org.graalvm.compiler.core.amd64;

import java.util.*;
import org.graalvm.compiler.core.match.*;
import org.graalvm.compiler.core.gen.NodeMatchRules;
import org.graalvm.compiler.graph.Position;
import org.graalvm.compiler.nodes.memory.*;
import org.graalvm.compiler.nodes.*;
import org.graalvm.compiler.nodes.calc.*;
import org.graalvm.compiler.nodes.java.*;

public class AMD64NodeMatchRules_MatchStatementSet implements MatchStatementSet {

    private static final String[] resetLowestSetBit_arguments = new String[] {"a", "b"};
    private static final class MatchGenerator_resetLowestSetBit implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_resetLowestSetBit();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).resetLowestSetBit((ValueNode) args[0], (ValueNode) args[1]);
        }
        @Override
        public String getName() {
             return "resetLowestSetBit";
        }
    }

    private static final String[] ifCompareValueCas_arguments = new String[] {"root", "compare", "value", "cas"};
    private static final class MatchGenerator_ifCompareValueCas implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_ifCompareValueCas();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).ifCompareValueCas((IfNode) args[0], (CompareNode) args[1], (ValueNode) args[2], (ValueCompareAndSwapNode) args[3]);
        }
        @Override
        public String getName() {
             return "ifCompareValueCas";
        }
    }

    private static final String[] writeNarrow_arguments = new String[] {"root", "narrow"};
    private static final class MatchGenerator_writeNarrow implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_writeNarrow();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).writeNarrow((WriteNode) args[0], (NarrowNode) args[1]);
        }
        @Override
        public String getName() {
             return "writeNarrow";
        }
    }

    private static final String[] rotateRightVariable_arguments = new String[] {"value", "delta", "shiftAmount"};
    private static final class MatchGenerator_rotateRightVariable implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_rotateRightVariable();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).rotateRightVariable((ValueNode) args[0], (ConstantNode) args[1], (ValueNode) args[2]);
        }
        @Override
        public String getName() {
             return "rotateRightVariable";
        }
    }

    private static final String[] ifCompareMemory_arguments = new String[] {"root", "compare", "value", "access"};
    private static final class MatchGenerator_ifCompareMemory implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_ifCompareMemory();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).ifCompareMemory((IfNode) args[0], (CompareNode) args[1], (ValueNode) args[2], (LIRLowerableAccess) args[3]);
        }
        @Override
        public String getName() {
             return "ifCompareMemory";
        }
    }

    private static final String[] zeroExtend_arguments = new String[] {"root", "access"};
    private static final class MatchGenerator_zeroExtend implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_zeroExtend();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).zeroExtend((ZeroExtendNode) args[0], (LIRLowerableAccess) args[1]);
        }
        @Override
        public String getName() {
             return "zeroExtend";
        }
    }

    private static final String[] getMaskUpToLowestSetBit_arguments = new String[] {"a", "b"};
    private static final class MatchGenerator_getMaskUpToLowestSetBit implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_getMaskUpToLowestSetBit();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).getMaskUpToLowestSetBit((ValueNode) args[0], (ValueNode) args[1]);
        }
        @Override
        public String getName() {
             return "getMaskUpToLowestSetBit";
        }
    }

    private static final String[] rotateLeftConstant_arguments = new String[] {"lshift", "rshift"};
    private static final class MatchGenerator_rotateLeftConstant implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_rotateLeftConstant();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).rotateLeftConstant((LeftShiftNode) args[0], (UnsignedRightShiftNode) args[1]);
        }
        @Override
        public String getName() {
             return "rotateLeftConstant";
        }
    }

    private static final String[] subMemory_arguments = new String[] {"value", "access"};
    private static final class MatchGenerator_subMemory implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_subMemory();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).subMemory((ValueNode) args[0], (LIRLowerableAccess) args[1]);
        }
        @Override
        public String getName() {
             return "subMemory";
        }
    }

    private static final String[] signExtend_arguments = new String[] {"root", "access"};
    private static final class MatchGenerator_signExtend implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_signExtend();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).signExtend((SignExtendNode) args[0], (LIRLowerableAccess) args[1]);
        }
        @Override
        public String getName() {
             return "signExtend";
        }
    }

    private static final String[] orMemory_arguments = new String[] {"value", "access"};
    private static final class MatchGenerator_orMemory implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_orMemory();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).orMemory((ValueNode) args[0], (LIRLowerableAccess) args[1]);
        }
        @Override
        public String getName() {
             return "orMemory";
        }
    }

    private static final String[] lowestSetIsolatedBit_arguments = new String[] {"a"};
    private static final class MatchGenerator_lowestSetIsolatedBit implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_lowestSetIsolatedBit();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).lowestSetIsolatedBit((ValueNode) args[0]);
        }
        @Override
        public String getName() {
             return "lowestSetIsolatedBit";
        }
    }

    private static final String[] xorMemory_arguments = new String[] {"value", "access"};
    private static final class MatchGenerator_xorMemory implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_xorMemory();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).xorMemory((ValueNode) args[0], (LIRLowerableAccess) args[1]);
        }
        @Override
        public String getName() {
             return "xorMemory";
        }
    }

    private static final String[] integerTestBranchMemory_arguments = new String[] {"root", "access", "value"};
    private static final class MatchGenerator_integerTestBranchMemory implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_integerTestBranchMemory();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).integerTestBranchMemory((IfNode) args[0], (LIRLowerableAccess) args[1], (ValueNode) args[2]);
        }
        @Override
        public String getName() {
             return "integerTestBranchMemory";
        }
    }

    private static final String[] ifCompareLogicCas_arguments = new String[] {"root", "compare", "value", "cas"};
    private static final class MatchGenerator_ifCompareLogicCas implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_ifCompareLogicCas();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).ifCompareLogicCas((IfNode) args[0], (CompareNode) args[1], (ValueNode) args[2], (LogicCompareAndSwapNode) args[3]);
        }
        @Override
        public String getName() {
             return "ifCompareLogicCas";
        }
    }

    private static final String[] ifLogicCas_arguments = new String[] {"root", "compare", "value", "access"};
    private static final class MatchGenerator_ifLogicCas implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_ifLogicCas();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).ifLogicCas((IfNode) args[0], (CompareNode) args[1], (ValueNode) args[2], (LIRLowerableAccess) args[3]);
        }
        @Override
        public String getName() {
             return "ifLogicCas";
        }
    }

    private static final String[] logicalAndNot_arguments = new String[] {"a", "b"};
    private static final class MatchGenerator_logicalAndNot implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_logicalAndNot();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).logicalAndNot((ValueNode) args[0], (ValueNode) args[1]);
        }
        @Override
        public String getName() {
             return "logicalAndNot";
        }
    }

    private static final String[] signExtendNarrowRead_arguments = new String[] {"root", "narrow", "access"};
    private static final class MatchGenerator_signExtendNarrowRead implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_signExtendNarrowRead();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).signExtendNarrowRead((SignExtendNode) args[0], (NarrowNode) args[1], (LIRLowerableAccess) args[2]);
        }
        @Override
        public String getName() {
             return "signExtendNarrowRead";
        }
    }

    private static final String[] mulMemory_arguments = new String[] {"value", "access"};
    private static final class MatchGenerator_mulMemory implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_mulMemory();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).mulMemory((ValueNode) args[0], (LIRLowerableAccess) args[1]);
        }
        @Override
        public String getName() {
             return "mulMemory";
        }
    }

    private static final String[] reinterpret_arguments = new String[] {"root", "access"};
    private static final class MatchGenerator_reinterpret implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_reinterpret();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).reinterpret((ReinterpretNode) args[0], (LIRLowerableAccess) args[1]);
        }
        @Override
        public String getName() {
             return "reinterpret";
        }
    }

    private static final String[] floatConvert_arguments = new String[] {"root", "access"};
    private static final class MatchGenerator_floatConvert implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_floatConvert();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).floatConvert((FloatConvertNode) args[0], (LIRLowerableAccess) args[1]);
        }
        @Override
        public String getName() {
             return "floatConvert";
        }
    }

    private static final String[] narrowRead_arguments = new String[] {"root", "access"};
    private static final class MatchGenerator_narrowRead implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_narrowRead();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).narrowRead((NarrowNode) args[0], (LIRLowerableAccess) args[1]);
        }
        @Override
        public String getName() {
             return "narrowRead";
        }
    }

    private static final String[] rotateLeftVariable_arguments = new String[] {"value", "shiftAmount", "delta"};
    private static final class MatchGenerator_rotateLeftVariable implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_rotateLeftVariable();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).rotateLeftVariable((ValueNode) args[0], (ValueNode) args[1], (ConstantNode) args[2]);
        }
        @Override
        public String getName() {
             return "rotateLeftVariable";
        }
    }

    private static final String[] addMemory_arguments = new String[] {"value", "access"};
    private static final class MatchGenerator_addMemory implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_addMemory();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).addMemory((ValueNode) args[0], (LIRLowerableAccess) args[1]);
        }
        @Override
        public String getName() {
             return "addMemory";
        }
    }

    private static final String[] writeReinterpret_arguments = new String[] {"root", "reinterpret"};
    private static final class MatchGenerator_writeReinterpret implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_writeReinterpret();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).writeReinterpret((WriteNode) args[0], (ReinterpretNode) args[1]);
        }
        @Override
        public String getName() {
             return "writeReinterpret";
        }
    }

    private static final String[] andMemory_arguments = new String[] {"value", "access"};
    private static final class MatchGenerator_andMemory implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_andMemory();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AMD64NodeMatchRules) nodeMatchRules).andMemory((ValueNode) args[0], (LIRLowerableAccess) args[1]);
        }
        @Override
        public String getName() {
             return "andMemory";
        }
    }

    @Override
    public Class<? extends NodeMatchRules> forClass() {
        return AMD64NodeMatchRules.class;
    }

    @Override
    public List<MatchStatement> statements() {
        // Checkstyle: stop 
        Position[] NegateNode_positions = MatchRuleRegistry.findPositions(NegateNode.TYPE, new String[]{"value"});
        Position[] MulNode_positions = MatchRuleRegistry.findPositions(MulNode.TYPE, new String[]{"x", "y"});
        Position[] FloatEqualsNode_positions = MatchRuleRegistry.findPositions(FloatEqualsNode.TYPE, new String[]{"x", "y"});
        Position[] FloatLessThanNode_positions = MatchRuleRegistry.findPositions(FloatLessThanNode.TYPE, new String[]{"x", "y"});
        Position[] IntegerEqualsNode_positions = MatchRuleRegistry.findPositions(IntegerEqualsNode.TYPE, new String[]{"x", "y"});
        Position[] SignExtendNode_positions = MatchRuleRegistry.findPositions(SignExtendNode.TYPE, new String[]{"value"});
        Position[] IntegerTestNode_positions = MatchRuleRegistry.findPositions(IntegerTestNode.TYPE, new String[]{"x", "y"});
        Position[] SubNode_positions = MatchRuleRegistry.findPositions(SubNode.TYPE, new String[]{"x", "y"});
        Position[] NotNode_positions = MatchRuleRegistry.findPositions(NotNode.TYPE, new String[]{"value"});
        Position[] OrNode_positions = MatchRuleRegistry.findPositions(OrNode.TYPE, new String[]{"x", "y"});
        Position[] ZeroExtendNode_positions = MatchRuleRegistry.findPositions(ZeroExtendNode.TYPE, new String[]{"value"});
        Position[] PointerEqualsNode_positions = MatchRuleRegistry.findPositions(PointerEqualsNode.TYPE, new String[]{"x", "y"});
        Position[] IfNode_positions = MatchRuleRegistry.findPositions(IfNode.TYPE, new String[]{"condition"});
        Position[] AndNode_positions = MatchRuleRegistry.findPositions(AndNode.TYPE, new String[]{"x", "y"});
        Position[] AddNode_positions = MatchRuleRegistry.findPositions(AddNode.TYPE, new String[]{"x", "y"});
        Position[] ReinterpretNode_positions = MatchRuleRegistry.findPositions(ReinterpretNode.TYPE, new String[]{"value"});
        Position[] LeftShiftNode_positions = MatchRuleRegistry.findPositions(LeftShiftNode.TYPE, new String[]{"x", "y"});
        Position[] WriteNode_positions = MatchRuleRegistry.findPositions(WriteNode.TYPE, new String[]{"address", "value"});
        Position[] IntegerLessThanNode_positions = MatchRuleRegistry.findPositions(IntegerLessThanNode.TYPE, new String[]{"x", "y"});
        Position[] IntegerBelowNode_positions = MatchRuleRegistry.findPositions(IntegerBelowNode.TYPE, new String[]{"x", "y"});
        Position[] FloatConvertNode_positions = MatchRuleRegistry.findPositions(FloatConvertNode.TYPE, new String[]{"value"});
        Position[] ObjectEqualsNode_positions = MatchRuleRegistry.findPositions(ObjectEqualsNode.TYPE, new String[]{"x", "y"});
        Position[] UnsignedRightShiftNode_positions = MatchRuleRegistry.findPositions(UnsignedRightShiftNode.TYPE, new String[]{"x", "y"});
        Position[] NarrowNode_positions = MatchRuleRegistry.findPositions(NarrowNode.TYPE, new String[]{"value"});
        Position[] XorNode_positions = MatchRuleRegistry.findPositions(XorNode.TYPE, new String[]{"x", "y"});

        List<MatchStatement> statements = Collections.unmodifiableList(Arrays.asList(
            new MatchStatement("logicalAndNot", new MatchPattern(AndNode.class, null, new MatchPattern(NotNode.class, null, new MatchPattern("a", false, false), NotNode_positions, true, true), new MatchPattern("b", false, false), AndNode_positions, true, true), MatchGenerator_logicalAndNot.instance, logicalAndNot_arguments),
            new MatchStatement("logicalAndNot", new MatchPattern(AndNode.class, null, new MatchPattern("b", false, false), new MatchPattern(NotNode.class, null, new MatchPattern("a", false, false), NotNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_logicalAndNot.instance, logicalAndNot_arguments),
            new MatchStatement("lowestSetIsolatedBit", new MatchPattern(AndNode.class, null, new MatchPattern("a", false, false), new MatchPattern(NegateNode.class, null, new MatchPattern("a", false, false), NegateNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_lowestSetIsolatedBit.instance, lowestSetIsolatedBit_arguments),
            new MatchStatement("lowestSetIsolatedBit", new MatchPattern(AndNode.class, null, new MatchPattern(NegateNode.class, null, new MatchPattern("a", false, false), NegateNode_positions, true, true), new MatchPattern("a", false, false), AndNode_positions, true, true), MatchGenerator_lowestSetIsolatedBit.instance, lowestSetIsolatedBit_arguments),
            new MatchStatement("getMaskUpToLowestSetBit", new MatchPattern(XorNode.class, null, new MatchPattern("a", false, false), new MatchPattern(AddNode.class, null, new MatchPattern("a", false, false), new MatchPattern("b", false, false), AddNode_positions, true, true), XorNode_positions, true, true), MatchGenerator_getMaskUpToLowestSetBit.instance, getMaskUpToLowestSetBit_arguments),
            new MatchStatement("getMaskUpToLowestSetBit", new MatchPattern(XorNode.class, null, new MatchPattern(AddNode.class, null, new MatchPattern("a", false, false), new MatchPattern("b", false, false), AddNode_positions, true, true), new MatchPattern("a", false, false), XorNode_positions, true, true), MatchGenerator_getMaskUpToLowestSetBit.instance, getMaskUpToLowestSetBit_arguments),
            new MatchStatement("getMaskUpToLowestSetBit", new MatchPattern(XorNode.class, null, new MatchPattern("a", false, false), new MatchPattern(AddNode.class, null, new MatchPattern("b", false, false), new MatchPattern("a", false, false), AddNode_positions, true, true), XorNode_positions, true, true), MatchGenerator_getMaskUpToLowestSetBit.instance, getMaskUpToLowestSetBit_arguments),
            new MatchStatement("getMaskUpToLowestSetBit", new MatchPattern(XorNode.class, null, new MatchPattern(AddNode.class, null, new MatchPattern("b", false, false), new MatchPattern("a", false, false), AddNode_positions, true, true), new MatchPattern("a", false, false), XorNode_positions, true, true), MatchGenerator_getMaskUpToLowestSetBit.instance, getMaskUpToLowestSetBit_arguments),
            new MatchStatement("resetLowestSetBit", new MatchPattern(AndNode.class, null, new MatchPattern("a", false, false), new MatchPattern(AddNode.class, null, new MatchPattern("a", false, false), new MatchPattern("b", false, false), AddNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_resetLowestSetBit.instance, resetLowestSetBit_arguments),
            new MatchStatement("resetLowestSetBit", new MatchPattern(AndNode.class, null, new MatchPattern(AddNode.class, null, new MatchPattern("a", false, false), new MatchPattern("b", false, false), AddNode_positions, true, true), new MatchPattern("a", false, false), AndNode_positions, true, true), MatchGenerator_resetLowestSetBit.instance, resetLowestSetBit_arguments),
            new MatchStatement("resetLowestSetBit", new MatchPattern(AndNode.class, null, new MatchPattern("a", false, false), new MatchPattern(AddNode.class, null, new MatchPattern("b", false, false), new MatchPattern("a", false, false), AddNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_resetLowestSetBit.instance, resetLowestSetBit_arguments),
            new MatchStatement("resetLowestSetBit", new MatchPattern(AndNode.class, null, new MatchPattern(AddNode.class, null, new MatchPattern("b", false, false), new MatchPattern("a", false, false), AddNode_positions, true, true), new MatchPattern("a", false, false), AndNode_positions, true, true), MatchGenerator_resetLowestSetBit.instance, resetLowestSetBit_arguments),
            new MatchStatement("ifLogicCas", new MatchPattern(IfNode.class, null, new MatchPattern(ObjectEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), ObjectEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifLogicCas.instance, ifLogicCas_arguments),
            new MatchStatement("ifLogicCas", new MatchPattern(IfNode.class, null, new MatchPattern(ObjectEqualsNode.class, "compare", new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), ObjectEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifLogicCas.instance, ifLogicCas_arguments),
            new MatchStatement("rotateLeftConstant", new MatchPattern(OrNode.class, null, new MatchPattern(LeftShiftNode.class, "lshift", new MatchPattern("value", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), new MatchPattern(UnsignedRightShiftNode.class, "rshift", new MatchPattern("value", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_rotateLeftConstant.instance, rotateLeftConstant_arguments),
            new MatchStatement("rotateLeftConstant", new MatchPattern(OrNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "rshift", new MatchPattern("value", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), new MatchPattern(LeftShiftNode.class, "lshift", new MatchPattern("value", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_rotateLeftConstant.instance, rotateLeftConstant_arguments),
            new MatchStatement("rotateRightVariable", new MatchPattern(OrNode.class, null, new MatchPattern(LeftShiftNode.class, null, new MatchPattern("value", false, false), new MatchPattern(SubNode.class, null, new MatchPattern(ConstantNode.class, "delta", false, true), new MatchPattern("shiftAmount", false, false), SubNode_positions, true, true), LeftShiftNode_positions, true, true), new MatchPattern(UnsignedRightShiftNode.class, null, new MatchPattern("value", false, false), new MatchPattern("shiftAmount", false, false), UnsignedRightShiftNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_rotateRightVariable.instance, rotateRightVariable_arguments),
            new MatchStatement("rotateRightVariable", new MatchPattern(OrNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, null, new MatchPattern("value", false, false), new MatchPattern("shiftAmount", false, false), UnsignedRightShiftNode_positions, true, true), new MatchPattern(LeftShiftNode.class, null, new MatchPattern("value", false, false), new MatchPattern(SubNode.class, null, new MatchPattern(ConstantNode.class, "delta", false, true), new MatchPattern("shiftAmount", false, false), SubNode_positions, true, true), LeftShiftNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_rotateRightVariable.instance, rotateRightVariable_arguments),
            new MatchStatement("rotateLeftVariable", new MatchPattern(OrNode.class, null, new MatchPattern(LeftShiftNode.class, null, new MatchPattern("value", false, false), new MatchPattern("shiftAmount", false, false), LeftShiftNode_positions, true, true), new MatchPattern(UnsignedRightShiftNode.class, null, new MatchPattern("value", false, false), new MatchPattern(SubNode.class, null, new MatchPattern(ConstantNode.class, "delta", false, true), new MatchPattern("shiftAmount", false, false), SubNode_positions, true, true), UnsignedRightShiftNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_rotateLeftVariable.instance, rotateLeftVariable_arguments),
            new MatchStatement("rotateLeftVariable", new MatchPattern(OrNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, null, new MatchPattern("value", false, false), new MatchPattern(SubNode.class, null, new MatchPattern(ConstantNode.class, "delta", false, true), new MatchPattern("shiftAmount", false, false), SubNode_positions, true, true), UnsignedRightShiftNode_positions, true, true), new MatchPattern(LeftShiftNode.class, null, new MatchPattern("value", false, false), new MatchPattern("shiftAmount", false, false), LeftShiftNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_rotateLeftVariable.instance, rotateLeftVariable_arguments),
            new MatchStatement("writeNarrow", new MatchPattern(WriteNode.class, null, new MatchPattern("object", false, false), new MatchPattern(NarrowNode.class, "narrow", true, true), WriteNode_positions, true, false), MatchGenerator_writeNarrow.instance, writeNarrow_arguments),
            new MatchStatement("writeReinterpret", new MatchPattern(WriteNode.class, null, new MatchPattern("object", false, false), new MatchPattern(ReinterpretNode.class, "reinterpret", true, true), WriteNode_positions, true, false), MatchGenerator_writeReinterpret.instance, writeReinterpret_arguments),
            new MatchStatement("integerTestBranchMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerTestNode.class, null, new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), IntegerTestNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_integerTestBranchMemory.instance, integerTestBranchMemory_arguments),
            new MatchStatement("integerTestBranchMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerTestNode.class, null, new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), IntegerTestNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_integerTestBranchMemory.instance, integerTestBranchMemory_arguments),
            new MatchStatement("integerTestBranchMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerTestNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), IntegerTestNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_integerTestBranchMemory.instance, integerTestBranchMemory_arguments),
            new MatchStatement("integerTestBranchMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerTestNode.class, null, new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), IntegerTestNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_integerTestBranchMemory.instance, integerTestBranchMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), IntegerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerEqualsNode.class, "compare", new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), IntegerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerLessThanNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), IntegerLessThanNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerLessThanNode.class, "compare", new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), IntegerLessThanNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerBelowNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), IntegerBelowNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerBelowNode.class, "compare", new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), IntegerBelowNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), IntegerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerEqualsNode.class, "compare", new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), IntegerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerLessThanNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), IntegerLessThanNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerLessThanNode.class, "compare", new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), IntegerLessThanNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerBelowNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), IntegerBelowNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerBelowNode.class, "compare", new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), IntegerBelowNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(FloatEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), FloatEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(FloatEqualsNode.class, "compare", new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), FloatEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(FloatEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), FloatEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(FloatEqualsNode.class, "compare", new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), FloatEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(FloatLessThanNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), FloatLessThanNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(FloatLessThanNode.class, "compare", new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), FloatLessThanNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(FloatLessThanNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), FloatLessThanNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(FloatLessThanNode.class, "compare", new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), FloatLessThanNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(PointerEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), PointerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(PointerEqualsNode.class, "compare", new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), PointerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(PointerEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), PointerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(PointerEqualsNode.class, "compare", new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), PointerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(ObjectEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), ObjectEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(ObjectEqualsNode.class, "compare", new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), ObjectEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(ObjectEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), ObjectEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareMemory", new MatchPattern(IfNode.class, null, new MatchPattern(ObjectEqualsNode.class, "compare", new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), ObjectEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareMemory.instance, ifCompareMemory_arguments),
            new MatchStatement("ifCompareValueCas", new MatchPattern(IfNode.class, null, new MatchPattern(ObjectEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(ValueCompareAndSwapNode.class, "cas", true, false), ObjectEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareValueCas.instance, ifCompareValueCas_arguments),
            new MatchStatement("ifCompareValueCas", new MatchPattern(IfNode.class, null, new MatchPattern(ObjectEqualsNode.class, "compare", new MatchPattern(ValueCompareAndSwapNode.class, "cas", true, false), new MatchPattern("value", false, false), ObjectEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareValueCas.instance, ifCompareValueCas_arguments),
            new MatchStatement("ifCompareValueCas", new MatchPattern(IfNode.class, null, new MatchPattern(PointerEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(ValueCompareAndSwapNode.class, "cas", true, false), PointerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareValueCas.instance, ifCompareValueCas_arguments),
            new MatchStatement("ifCompareValueCas", new MatchPattern(IfNode.class, null, new MatchPattern(PointerEqualsNode.class, "compare", new MatchPattern(ValueCompareAndSwapNode.class, "cas", true, false), new MatchPattern("value", false, false), PointerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareValueCas.instance, ifCompareValueCas_arguments),
            new MatchStatement("ifCompareValueCas", new MatchPattern(IfNode.class, null, new MatchPattern(FloatEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(ValueCompareAndSwapNode.class, "cas", true, false), FloatEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareValueCas.instance, ifCompareValueCas_arguments),
            new MatchStatement("ifCompareValueCas", new MatchPattern(IfNode.class, null, new MatchPattern(FloatEqualsNode.class, "compare", new MatchPattern(ValueCompareAndSwapNode.class, "cas", true, false), new MatchPattern("value", false, false), FloatEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareValueCas.instance, ifCompareValueCas_arguments),
            new MatchStatement("ifCompareValueCas", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(ValueCompareAndSwapNode.class, "cas", true, false), IntegerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareValueCas.instance, ifCompareValueCas_arguments),
            new MatchStatement("ifCompareValueCas", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerEqualsNode.class, "compare", new MatchPattern(ValueCompareAndSwapNode.class, "cas", true, false), new MatchPattern("value", false, false), IntegerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareValueCas.instance, ifCompareValueCas_arguments),
            new MatchStatement("ifCompareLogicCas", new MatchPattern(IfNode.class, null, new MatchPattern(ObjectEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(LogicCompareAndSwapNode.class, "cas", true, false), ObjectEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareLogicCas.instance, ifCompareLogicCas_arguments),
            new MatchStatement("ifCompareLogicCas", new MatchPattern(IfNode.class, null, new MatchPattern(ObjectEqualsNode.class, "compare", new MatchPattern(LogicCompareAndSwapNode.class, "cas", true, false), new MatchPattern("value", false, false), ObjectEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareLogicCas.instance, ifCompareLogicCas_arguments),
            new MatchStatement("ifCompareLogicCas", new MatchPattern(IfNode.class, null, new MatchPattern(PointerEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(LogicCompareAndSwapNode.class, "cas", true, false), PointerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareLogicCas.instance, ifCompareLogicCas_arguments),
            new MatchStatement("ifCompareLogicCas", new MatchPattern(IfNode.class, null, new MatchPattern(PointerEqualsNode.class, "compare", new MatchPattern(LogicCompareAndSwapNode.class, "cas", true, false), new MatchPattern("value", false, false), PointerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareLogicCas.instance, ifCompareLogicCas_arguments),
            new MatchStatement("ifCompareLogicCas", new MatchPattern(IfNode.class, null, new MatchPattern(FloatEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(LogicCompareAndSwapNode.class, "cas", true, false), FloatEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareLogicCas.instance, ifCompareLogicCas_arguments),
            new MatchStatement("ifCompareLogicCas", new MatchPattern(IfNode.class, null, new MatchPattern(FloatEqualsNode.class, "compare", new MatchPattern(LogicCompareAndSwapNode.class, "cas", true, false), new MatchPattern("value", false, false), FloatEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareLogicCas.instance, ifCompareLogicCas_arguments),
            new MatchStatement("ifCompareLogicCas", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerEqualsNode.class, "compare", new MatchPattern("value", false, false), new MatchPattern(LogicCompareAndSwapNode.class, "cas", true, false), IntegerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareLogicCas.instance, ifCompareLogicCas_arguments),
            new MatchStatement("ifCompareLogicCas", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerEqualsNode.class, "compare", new MatchPattern(LogicCompareAndSwapNode.class, "cas", true, false), new MatchPattern("value", false, false), IntegerEqualsNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_ifCompareLogicCas.instance, ifCompareLogicCas_arguments),
            new MatchStatement("addMemory", new MatchPattern(AddNode.class, null, new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), AddNode_positions, true, true), MatchGenerator_addMemory.instance, addMemory_arguments),
            new MatchStatement("addMemory", new MatchPattern(AddNode.class, null, new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), AddNode_positions, true, true), MatchGenerator_addMemory.instance, addMemory_arguments),
            new MatchStatement("addMemory", new MatchPattern(AddNode.class, null, new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), AddNode_positions, true, true), MatchGenerator_addMemory.instance, addMemory_arguments),
            new MatchStatement("addMemory", new MatchPattern(AddNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), AddNode_positions, true, true), MatchGenerator_addMemory.instance, addMemory_arguments),
            new MatchStatement("subMemory", new MatchPattern(SubNode.class, null, new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), SubNode_positions, true, true), MatchGenerator_subMemory.instance, subMemory_arguments),
            new MatchStatement("subMemory", new MatchPattern(SubNode.class, null, new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), SubNode_positions, true, true), MatchGenerator_subMemory.instance, subMemory_arguments),
            new MatchStatement("mulMemory", new MatchPattern(MulNode.class, null, new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), MulNode_positions, true, true), MatchGenerator_mulMemory.instance, mulMemory_arguments),
            new MatchStatement("mulMemory", new MatchPattern(MulNode.class, null, new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), MulNode_positions, true, true), MatchGenerator_mulMemory.instance, mulMemory_arguments),
            new MatchStatement("mulMemory", new MatchPattern(MulNode.class, null, new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), MulNode_positions, true, true), MatchGenerator_mulMemory.instance, mulMemory_arguments),
            new MatchStatement("mulMemory", new MatchPattern(MulNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), MulNode_positions, true, true), MatchGenerator_mulMemory.instance, mulMemory_arguments),
            new MatchStatement("andMemory", new MatchPattern(AndNode.class, null, new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), AndNode_positions, true, true), MatchGenerator_andMemory.instance, andMemory_arguments),
            new MatchStatement("andMemory", new MatchPattern(AndNode.class, null, new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), AndNode_positions, true, true), MatchGenerator_andMemory.instance, andMemory_arguments),
            new MatchStatement("andMemory", new MatchPattern(AndNode.class, null, new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), AndNode_positions, true, true), MatchGenerator_andMemory.instance, andMemory_arguments),
            new MatchStatement("andMemory", new MatchPattern(AndNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), AndNode_positions, true, true), MatchGenerator_andMemory.instance, andMemory_arguments),
            new MatchStatement("orMemory", new MatchPattern(OrNode.class, null, new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), OrNode_positions, true, true), MatchGenerator_orMemory.instance, orMemory_arguments),
            new MatchStatement("orMemory", new MatchPattern(OrNode.class, null, new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), OrNode_positions, true, true), MatchGenerator_orMemory.instance, orMemory_arguments),
            new MatchStatement("orMemory", new MatchPattern(OrNode.class, null, new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), OrNode_positions, true, true), MatchGenerator_orMemory.instance, orMemory_arguments),
            new MatchStatement("orMemory", new MatchPattern(OrNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), OrNode_positions, true, true), MatchGenerator_orMemory.instance, orMemory_arguments),
            new MatchStatement("xorMemory", new MatchPattern(XorNode.class, null, new MatchPattern("value", false, false), new MatchPattern(ReadNode.class, "access", true, false), XorNode_positions, true, true), MatchGenerator_xorMemory.instance, xorMemory_arguments),
            new MatchStatement("xorMemory", new MatchPattern(XorNode.class, null, new MatchPattern(ReadNode.class, "access", true, false), new MatchPattern("value", false, false), XorNode_positions, true, true), MatchGenerator_xorMemory.instance, xorMemory_arguments),
            new MatchStatement("xorMemory", new MatchPattern(XorNode.class, null, new MatchPattern("value", false, false), new MatchPattern(FloatingReadNode.class, "access", true, false), XorNode_positions, true, true), MatchGenerator_xorMemory.instance, xorMemory_arguments),
            new MatchStatement("xorMemory", new MatchPattern(XorNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true, false), new MatchPattern("value", false, false), XorNode_positions, true, true), MatchGenerator_xorMemory.instance, xorMemory_arguments),
            new MatchStatement("signExtend", new MatchPattern(SignExtendNode.class, null, new MatchPattern(ReadNode.class, "access", true, false), SignExtendNode_positions, true, true), MatchGenerator_signExtend.instance, signExtend_arguments),
            new MatchStatement("signExtend", new MatchPattern(SignExtendNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true, false), SignExtendNode_positions, true, true), MatchGenerator_signExtend.instance, signExtend_arguments),
            new MatchStatement("zeroExtend", new MatchPattern(ZeroExtendNode.class, null, new MatchPattern(ReadNode.class, "access", true, false), ZeroExtendNode_positions, true, true), MatchGenerator_zeroExtend.instance, zeroExtend_arguments),
            new MatchStatement("zeroExtend", new MatchPattern(ZeroExtendNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true, false), ZeroExtendNode_positions, true, true), MatchGenerator_zeroExtend.instance, zeroExtend_arguments),
            new MatchStatement("narrowRead", new MatchPattern(NarrowNode.class, null, new MatchPattern(ReadNode.class, "access", true, false), NarrowNode_positions, true, true), MatchGenerator_narrowRead.instance, narrowRead_arguments),
            new MatchStatement("narrowRead", new MatchPattern(NarrowNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true, false), NarrowNode_positions, true, true), MatchGenerator_narrowRead.instance, narrowRead_arguments),
            new MatchStatement("signExtendNarrowRead", new MatchPattern(SignExtendNode.class, null, new MatchPattern(NarrowNode.class, "narrow", new MatchPattern(ReadNode.class, "access", true, false), NarrowNode_positions, true, true), SignExtendNode_positions, true, true), MatchGenerator_signExtendNarrowRead.instance, signExtendNarrowRead_arguments),
            new MatchStatement("signExtendNarrowRead", new MatchPattern(SignExtendNode.class, null, new MatchPattern(NarrowNode.class, "narrow", new MatchPattern(FloatingReadNode.class, "access", true, false), NarrowNode_positions, true, true), SignExtendNode_positions, true, true), MatchGenerator_signExtendNarrowRead.instance, signExtendNarrowRead_arguments),
            new MatchStatement("floatConvert", new MatchPattern(FloatConvertNode.class, null, new MatchPattern(ReadNode.class, "access", true, false), FloatConvertNode_positions, true, true), MatchGenerator_floatConvert.instance, floatConvert_arguments),
            new MatchStatement("floatConvert", new MatchPattern(FloatConvertNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true, false), FloatConvertNode_positions, true, true), MatchGenerator_floatConvert.instance, floatConvert_arguments),
            new MatchStatement("reinterpret", new MatchPattern(ReinterpretNode.class, null, new MatchPattern(ReadNode.class, "access", true, false), ReinterpretNode_positions, true, true), MatchGenerator_reinterpret.instance, reinterpret_arguments),
            new MatchStatement("reinterpret", new MatchPattern(ReinterpretNode.class, null, new MatchPattern(FloatingReadNode.class, "access", true, false), ReinterpretNode_positions, true, true), MatchGenerator_reinterpret.instance, reinterpret_arguments)
        ));
        // Checkstyle: resume
        return statements;
    }

}
