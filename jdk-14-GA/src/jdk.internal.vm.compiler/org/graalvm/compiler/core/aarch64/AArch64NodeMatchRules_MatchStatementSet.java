// CheckStyle: stop header check
// CheckStyle: stop line length check
// GENERATED CONTENT - DO NOT EDIT
// Source: AArch64NodeMatchRules.java
package org.graalvm.compiler.core.aarch64;

import java.util.*;
import org.graalvm.compiler.core.match.*;
import org.graalvm.compiler.core.gen.NodeMatchRules;
import org.graalvm.compiler.graph.Position;
import org.graalvm.compiler.nodes.*;
import org.graalvm.compiler.nodes.calc.*;

public class AArch64NodeMatchRules_MatchStatementSet implements MatchStatementSet {

    private static final String[] signedMultiplyLong_arguments = new String[] {"mul", "a", "b"};
    private static final class MatchGenerator_signedMultiplyLong implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_signedMultiplyLong();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).signedMultiplyLong((MulNode) args[0], (ValueNode) args[1], (ValueNode) args[2]);
        }
        @Override
        public String getName() {
             return "signedMultiplyLong";
        }
    }

    private static final String[] testBitAndBranch_arguments = new String[] {"root", "value", "a"};
    private static final class MatchGenerator_testBitAndBranch implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_testBitAndBranch();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).testBitAndBranch((IfNode) args[0], (ValueNode) args[1], (ConstantNode) args[2]);
        }
        @Override
        public String getName() {
             return "testBitAndBranch";
        }
    }

    private static final String[] signedMultiplyNegLong_arguments = new String[] {"mul", "a", "b"};
    private static final class MatchGenerator_signedMultiplyNegLong implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_signedMultiplyNegLong();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).signedMultiplyNegLong((MulNode) args[0], (ValueNode) args[1], (ValueNode) args[2]);
        }
        @Override
        public String getName() {
             return "signedMultiplyNegLong";
        }
    }

    private static final String[] logicShift_arguments = new String[] {"binary", "a", "shift"};
    private static final class MatchGenerator_logicShift implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_logicShift();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).logicShift((BinaryNode) args[0], (ValueNode) args[1], (BinaryNode) args[2]);
        }
        @Override
        public String getName() {
             return "logicShift";
        }
    }

    private static final String[] addSubShift_arguments = new String[] {"binary", "a", "shift"};
    private static final class MatchGenerator_addSubShift implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_addSubShift();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).addSubShift((BinaryNode) args[0], (ValueNode) args[1], (BinaryNode) args[2]);
        }
        @Override
        public String getName() {
             return "addSubShift";
        }
    }

    private static final String[] multiplyNegate_arguments = new String[] {"a", "b"};
    private static final class MatchGenerator_multiplyNegate implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_multiplyNegate();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).multiplyNegate((ValueNode) args[0], (ValueNode) args[1]);
        }
        @Override
        public String getName() {
             return "multiplyNegate";
        }
    }

    private static final String[] checkNegativeAndBranch_arguments = new String[] {"root", "lessNode", "x", "y"};
    private static final class MatchGenerator_checkNegativeAndBranch implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_checkNegativeAndBranch();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).checkNegativeAndBranch((IfNode) args[0], (IntegerLessThanNode) args[1], (ValueNode) args[2], (ConstantNode) args[3]);
        }
        @Override
        public String getName() {
             return "checkNegativeAndBranch";
        }
    }

    private static final String[] unsignedBitField_arguments = new String[] {"shift", "a", "b", "c"};
    private static final class MatchGenerator_unsignedBitField implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_unsignedBitField();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).unsignedBitField((BinaryNode) args[0], (ValueNode) args[1], (ConstantNode) args[2], (ConstantNode) args[3]);
        }
        @Override
        public String getName() {
             return "unsignedBitField";
        }
    }

    private static final String[] elideL2IForUnary_arguments = new String[] {"unary", "narrow"};
    private static final class MatchGenerator_elideL2IForUnary implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_elideL2IForUnary();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).elideL2IForUnary((UnaryNode) args[0], (NarrowNode) args[1]);
        }
        @Override
        public String getName() {
             return "elideL2IForUnary";
        }
    }

    private static final String[] multiplyAddSub_arguments = new String[] {"binary", "a", "b", "c"};
    private static final class MatchGenerator_multiplyAddSub implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_multiplyAddSub();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).multiplyAddSub((BinaryNode) args[0], (ValueNode) args[1], (ValueNode) args[2], (ValueNode) args[3]);
        }
        @Override
        public String getName() {
             return "multiplyAddSub";
        }
    }

    private static final String[] elideL2IForBinary_arguments = new String[] {"binary", "narrow"};
    private static final class MatchGenerator_elideL2IForBinary implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_elideL2IForBinary();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).elideL2IForBinary((BinaryNode) args[0], (NarrowNode) args[1]);
        }
        @Override
        public String getName() {
             return "elideL2IForBinary";
        }
    }

    private static final String[] signedMultiplyAddSubLong_arguments = new String[] {"binary", "a", "b", "c"};
    private static final class MatchGenerator_signedMultiplyAddSubLong implements MatchGenerator {
        static MatchGenerator instance = new MatchGenerator_signedMultiplyAddSubLong();
        @Override
        public ComplexMatchResult match(NodeMatchRules nodeMatchRules, Object...args) {
            return ((AArch64NodeMatchRules) nodeMatchRules).signedMultiplyAddSubLong((BinaryNode) args[0], (ValueNode) args[1], (ValueNode) args[2], (ValueNode) args[3]);
        }
        @Override
        public String getName() {
             return "signedMultiplyAddSubLong";
        }
    }

    @Override
    public Class<? extends NodeMatchRules> forClass() {
        return AArch64NodeMatchRules.class;
    }

    @Override
    public List<MatchStatement> statements() {
        // Checkstyle: stop 
        Position[] OrNode_positions = MatchRuleRegistry.findPositions(OrNode.TYPE, new String[]{"x", "y"});
        Position[] NegateNode_positions = MatchRuleRegistry.findPositions(NegateNode.TYPE, new String[]{"value"});
        Position[] IfNode_positions = MatchRuleRegistry.findPositions(IfNode.TYPE, new String[]{"condition"});
        Position[] MulNode_positions = MatchRuleRegistry.findPositions(MulNode.TYPE, new String[]{"x", "y"});
        Position[] AndNode_positions = MatchRuleRegistry.findPositions(AndNode.TYPE, new String[]{"x", "y"});
        Position[] AddNode_positions = MatchRuleRegistry.findPositions(AddNode.TYPE, new String[]{"x", "y"});
        Position[] LeftShiftNode_positions = MatchRuleRegistry.findPositions(LeftShiftNode.TYPE, new String[]{"x", "y"});
        Position[] IntegerLessThanNode_positions = MatchRuleRegistry.findPositions(IntegerLessThanNode.TYPE, new String[]{"x", "y"});
        Position[] UnsignedRightShiftNode_positions = MatchRuleRegistry.findPositions(UnsignedRightShiftNode.TYPE, new String[]{"x", "y"});
        Position[] SignExtendNode_positions = MatchRuleRegistry.findPositions(SignExtendNode.TYPE, new String[]{"value"});
        Position[] IntegerTestNode_positions = MatchRuleRegistry.findPositions(IntegerTestNode.TYPE, new String[]{"x", "y"});
        Position[] NarrowNode_positions = MatchRuleRegistry.findPositions(NarrowNode.TYPE, new String[]{"value"});
        Position[] SubNode_positions = MatchRuleRegistry.findPositions(SubNode.TYPE, new String[]{"x", "y"});
        Position[] NotNode_positions = MatchRuleRegistry.findPositions(NotNode.TYPE, new String[]{"value"});
        Position[] RightShiftNode_positions = MatchRuleRegistry.findPositions(RightShiftNode.TYPE, new String[]{"x", "y"});
        Position[] XorNode_positions = MatchRuleRegistry.findPositions(XorNode.TYPE, new String[]{"x", "y"});

        List<MatchStatement> statements = Collections.unmodifiableList(Arrays.asList(
            new MatchStatement("signedMultiplyLong", new MatchPattern(MulNode.class, "mul", new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), MulNode_positions, true, true), MatchGenerator_signedMultiplyLong.instance, signedMultiplyLong_arguments),
            new MatchStatement("signedMultiplyLong", new MatchPattern(MulNode.class, "mul", new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), MulNode_positions, true, true), MatchGenerator_signedMultiplyLong.instance, signedMultiplyLong_arguments),
            new MatchStatement("testBitAndBranch", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerTestNode.class, null, new MatchPattern("value", false, false), new MatchPattern(ConstantNode.class, "a", false, true), IntegerTestNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_testBitAndBranch.instance, testBitAndBranch_arguments),
            new MatchStatement("testBitAndBranch", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerTestNode.class, null, new MatchPattern(ConstantNode.class, "a", false, true), new MatchPattern("value", false, false), IntegerTestNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_testBitAndBranch.instance, testBitAndBranch_arguments),
            new MatchStatement("checkNegativeAndBranch", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerLessThanNode.class, "lessNode", new MatchPattern("x", false, false), new MatchPattern(ConstantNode.class, "y", false, true), IntegerLessThanNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_checkNegativeAndBranch.instance, checkNegativeAndBranch_arguments),
            new MatchStatement("checkNegativeAndBranch", new MatchPattern(IfNode.class, null, new MatchPattern(IntegerLessThanNode.class, "lessNode", new MatchPattern(ConstantNode.class, "y", false, true), new MatchPattern("x", false, false), IntegerLessThanNode_positions, true, true), IfNode_positions, true, false), MatchGenerator_checkNegativeAndBranch.instance, checkNegativeAndBranch_arguments),
            new MatchStatement("unsignedBitField", new MatchPattern(AndNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("a", false, false), new MatchPattern(ConstantNode.class, "b", false, true), UnsignedRightShiftNode_positions, true, true), new MatchPattern(ConstantNode.class, "c", false, true), AndNode_positions, true, true), MatchGenerator_unsignedBitField.instance, unsignedBitField_arguments),
            new MatchStatement("unsignedBitField", new MatchPattern(AndNode.class, null, new MatchPattern(ConstantNode.class, "c", false, true), new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("a", false, false), new MatchPattern(ConstantNode.class, "b", false, true), UnsignedRightShiftNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_unsignedBitField.instance, unsignedBitField_arguments),
            new MatchStatement("unsignedBitField", new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern(AndNode.class, null, new MatchPattern("a", false, false), new MatchPattern(ConstantNode.class, "c", false, true), AndNode_positions, true, true), new MatchPattern(ConstantNode.class, "b", false, true), LeftShiftNode_positions, true, true), MatchGenerator_unsignedBitField.instance, unsignedBitField_arguments),
            new MatchStatement("unsignedBitField", new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern(AndNode.class, null, new MatchPattern(ConstantNode.class, "c", false, true), new MatchPattern("a", false, false), AndNode_positions, true, true), new MatchPattern(ConstantNode.class, "b", false, true), LeftShiftNode_positions, true, true), MatchGenerator_unsignedBitField.instance, unsignedBitField_arguments),
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), AddNode_positions, true, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), new MatchPattern("a", false, false), AddNode_positions, true, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), AddNode_positions, true, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), new MatchPattern("a", false, false), AddNode_positions, true, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), AddNode_positions, true, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), new MatchPattern("a", false, false), AddNode_positions, true, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(SubNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), SubNode_positions, true, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(SubNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), SubNode_positions, true, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(SubNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), SubNode_positions, true, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), new MatchPattern("a", false, false), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), new MatchPattern("a", false, false), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), new MatchPattern("a", false, false), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), new MatchPattern("a", false, false), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), new MatchPattern("a", false, false), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), new MatchPattern("a", false, false), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), new MatchPattern("a", false, false), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), new MatchPattern("a", false, false), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), new MatchPattern("a", false, false), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), NotNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), NotNode_positions, true, true), new MatchPattern("a", false, false), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), NotNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), NotNode_positions, true, true), new MatchPattern("a", false, false), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), NotNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), NotNode_positions, true, true), new MatchPattern("a", false, false), AndNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), NotNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), NotNode_positions, true, true), new MatchPattern("a", false, false), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), NotNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), NotNode_positions, true, true), new MatchPattern("a", false, false), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), NotNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), NotNode_positions, true, true), new MatchPattern("a", false, false), OrNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), NotNode_positions, true, true), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), LeftShiftNode_positions, true, true), NotNode_positions, true, true), new MatchPattern("a", false, false), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), NotNode_positions, true, true), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), RightShiftNode_positions, true, true), NotNode_positions, true, true), new MatchPattern("a", false, false), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), NotNode_positions, true, true), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false, false), new MatchPattern(ConstantNode.class, null, false, true), UnsignedRightShiftNode_positions, true, true), NotNode_positions, true, true), new MatchPattern("a", false, false), XorNode_positions, true, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("signedMultiplyAddSubLong", new MatchPattern(AddNode.class, "binary", new MatchPattern(MulNode.class, null, new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), MulNode_positions, true, true), new MatchPattern("c", false, false), AddNode_positions, true, true), MatchGenerator_signedMultiplyAddSubLong.instance, signedMultiplyAddSubLong_arguments),
            new MatchStatement("signedMultiplyAddSubLong", new MatchPattern(AddNode.class, "binary", new MatchPattern("c", false, false), new MatchPattern(MulNode.class, null, new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), MulNode_positions, true, true), AddNode_positions, true, true), MatchGenerator_signedMultiplyAddSubLong.instance, signedMultiplyAddSubLong_arguments),
            new MatchStatement("signedMultiplyAddSubLong", new MatchPattern(AddNode.class, "binary", new MatchPattern(MulNode.class, null, new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), MulNode_positions, true, true), new MatchPattern("c", false, false), AddNode_positions, true, true), MatchGenerator_signedMultiplyAddSubLong.instance, signedMultiplyAddSubLong_arguments),
            new MatchStatement("signedMultiplyAddSubLong", new MatchPattern(AddNode.class, "binary", new MatchPattern("c", false, false), new MatchPattern(MulNode.class, null, new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), MulNode_positions, true, true), AddNode_positions, true, true), MatchGenerator_signedMultiplyAddSubLong.instance, signedMultiplyAddSubLong_arguments),
            new MatchStatement("signedMultiplyAddSubLong", new MatchPattern(SubNode.class, "binary", new MatchPattern("c", false, false), new MatchPattern(MulNode.class, null, new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), MulNode_positions, true, true), SubNode_positions, true, true), MatchGenerator_signedMultiplyAddSubLong.instance, signedMultiplyAddSubLong_arguments),
            new MatchStatement("signedMultiplyAddSubLong", new MatchPattern(SubNode.class, "binary", new MatchPattern("c", false, false), new MatchPattern(MulNode.class, null, new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), MulNode_positions, true, true), SubNode_positions, true, true), MatchGenerator_signedMultiplyAddSubLong.instance, signedMultiplyAddSubLong_arguments),
            new MatchStatement("signedMultiplyNegLong", new MatchPattern(NegateNode.class, null, new MatchPattern(MulNode.class, "mul", new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), MulNode_positions, true, true), NegateNode_positions, true, true), MatchGenerator_signedMultiplyNegLong.instance, signedMultiplyNegLong_arguments),
            new MatchStatement("signedMultiplyNegLong", new MatchPattern(NegateNode.class, null, new MatchPattern(MulNode.class, "mul", new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), MulNode_positions, true, true), NegateNode_positions, true, true), MatchGenerator_signedMultiplyNegLong.instance, signedMultiplyNegLong_arguments),
            new MatchStatement("signedMultiplyNegLong", new MatchPattern(MulNode.class, "mul", new MatchPattern(NegateNode.class, null, new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), NegateNode_positions, true, true), new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), MulNode_positions, true, true), MatchGenerator_signedMultiplyNegLong.instance, signedMultiplyNegLong_arguments),
            new MatchStatement("signedMultiplyNegLong", new MatchPattern(MulNode.class, "mul", new MatchPattern(SignExtendNode.class, null, new MatchPattern("b", false, false), SignExtendNode_positions, true, true), new MatchPattern(NegateNode.class, null, new MatchPattern(SignExtendNode.class, null, new MatchPattern("a", false, false), SignExtendNode_positions, true, true), NegateNode_positions, true, true), MulNode_positions, true, true), MatchGenerator_signedMultiplyNegLong.instance, signedMultiplyNegLong_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(AddNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), AddNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(AddNode.class, "binary", new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), AddNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(SubNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), SubNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(MulNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), MulNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(MulNode.class, "binary", new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), MulNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(AndNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(AndNode.class, "binary", new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(OrNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(OrNode.class, "binary", new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(XorNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), XorNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(XorNode.class, "binary", new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), XorNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(LeftShiftNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), LeftShiftNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(RightShiftNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), RightShiftNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(UnsignedRightShiftNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern(NarrowNode.class, null, new MatchPattern("b", false, false), NarrowNode_positions, true, true), UnsignedRightShiftNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(AddNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), AddNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(AddNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), new MatchPattern("a", false, false), AddNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(SubNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), SubNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(MulNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), MulNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(MulNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), new MatchPattern("a", false, false), MulNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), AndNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(AndNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), new MatchPattern("a", false, false), AndNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), OrNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(OrNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), new MatchPattern("a", false, false), OrNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), XorNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(XorNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), new MatchPattern("a", false, false), XorNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(LeftShiftNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), LeftShiftNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(RightShiftNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), RightShiftNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(UnsignedRightShiftNode.class, "binary", new MatchPattern("a", false, false), new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("b", false, false), NarrowNode_positions, true, true), UnsignedRightShiftNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(SubNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern("b", false, false), SubNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(LeftShiftNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern("b", false, false), LeftShiftNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(RightShiftNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern("b", false, false), RightShiftNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForBinary", new MatchPattern(UnsignedRightShiftNode.class, "binary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("a", false, false), NarrowNode_positions, true, true), new MatchPattern("b", false, false), UnsignedRightShiftNode_positions, true, true), MatchGenerator_elideL2IForBinary.instance, elideL2IForBinary_arguments),
            new MatchStatement("elideL2IForUnary", new MatchPattern(NegateNode.class, "unary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("value", false, false), NarrowNode_positions, true, true), NegateNode_positions, true, true), MatchGenerator_elideL2IForUnary.instance, elideL2IForUnary_arguments),
            new MatchStatement("elideL2IForUnary", new MatchPattern(NotNode.class, "unary", new MatchPattern(NarrowNode.class, "narrow", new MatchPattern("value", false, false), NarrowNode_positions, true, true), NotNode_positions, true, true), MatchGenerator_elideL2IForUnary.instance, elideL2IForUnary_arguments),
            new MatchStatement("multiplyNegate", new MatchPattern(MulNode.class, null, new MatchPattern(NegateNode.class, null, new MatchPattern("a", false, false), NegateNode_positions, true, true), new MatchPattern("b", false, false), MulNode_positions, true, true), MatchGenerator_multiplyNegate.instance, multiplyNegate_arguments),
            new MatchStatement("multiplyNegate", new MatchPattern(MulNode.class, null, new MatchPattern("b", false, false), new MatchPattern(NegateNode.class, null, new MatchPattern("a", false, false), NegateNode_positions, true, true), MulNode_positions, true, true), MatchGenerator_multiplyNegate.instance, multiplyNegate_arguments),
            new MatchStatement("multiplyNegate", new MatchPattern(NegateNode.class, null, new MatchPattern(MulNode.class, null, new MatchPattern("a", false, false), new MatchPattern("b", false, false), MulNode_positions, true, true), NegateNode_positions, true, true), MatchGenerator_multiplyNegate.instance, multiplyNegate_arguments),
            new MatchStatement("multiplyNegate", new MatchPattern(NegateNode.class, null, new MatchPattern(MulNode.class, null, new MatchPattern("b", false, false), new MatchPattern("a", false, false), MulNode_positions, true, true), NegateNode_positions, true, true), MatchGenerator_multiplyNegate.instance, multiplyNegate_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(AddNode.class, "binary", new MatchPattern(MulNode.class, null, new MatchPattern("a", false, false), new MatchPattern("b", false, false), MulNode_positions, true, true), new MatchPattern("c", false, false), AddNode_positions, true, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(AddNode.class, "binary", new MatchPattern("c", false, false), new MatchPattern(MulNode.class, null, new MatchPattern("a", false, false), new MatchPattern("b", false, false), MulNode_positions, true, true), AddNode_positions, true, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(AddNode.class, "binary", new MatchPattern(MulNode.class, null, new MatchPattern("b", false, false), new MatchPattern("a", false, false), MulNode_positions, true, true), new MatchPattern("c", false, false), AddNode_positions, true, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(AddNode.class, "binary", new MatchPattern("c", false, false), new MatchPattern(MulNode.class, null, new MatchPattern("b", false, false), new MatchPattern("a", false, false), MulNode_positions, true, true), AddNode_positions, true, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(SubNode.class, "binary", new MatchPattern("c", false, false), new MatchPattern(MulNode.class, null, new MatchPattern("a", false, false), new MatchPattern("b", false, false), MulNode_positions, true, true), SubNode_positions, true, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(SubNode.class, "binary", new MatchPattern("c", false, false), new MatchPattern(MulNode.class, null, new MatchPattern("b", false, false), new MatchPattern("a", false, false), MulNode_positions, true, true), SubNode_positions, true, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments)
        ));
        // Checkstyle: resume
        return statements;
    }

}
