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

    @Override
    public Class<? extends NodeMatchRules> forClass() {
        return AArch64NodeMatchRules.class;
    }

    @Override
    public List<MatchStatement> statements() {
        // Checkstyle: stop 
        Position[] OrNode_positions = MatchRuleRegistry.findPositions(OrNode.TYPE, new String[]{"x", "y"});
        Position[] NegateNode_positions = MatchRuleRegistry.findPositions(NegateNode.TYPE, new String[]{"value"});
        Position[] MulNode_positions = MatchRuleRegistry.findPositions(MulNode.TYPE, new String[]{"x", "y"});
        Position[] AddNode_positions = MatchRuleRegistry.findPositions(AddNode.TYPE, new String[]{"x", "y"});
        Position[] UnsignedRightShiftNode_positions = MatchRuleRegistry.findPositions(UnsignedRightShiftNode.TYPE, new String[]{"x", "y"});
        Position[] AndNode_positions = MatchRuleRegistry.findPositions(AndNode.TYPE, new String[]{"x", "y"});
        Position[] LeftShiftNode_positions = MatchRuleRegistry.findPositions(LeftShiftNode.TYPE, new String[]{"x", "y"});
        Position[] SubNode_positions = MatchRuleRegistry.findPositions(SubNode.TYPE, new String[]{"x", "y"});
        Position[] NotNode_positions = MatchRuleRegistry.findPositions(NotNode.TYPE, new String[]{"value"});
        Position[] RightShiftNode_positions = MatchRuleRegistry.findPositions(RightShiftNode.TYPE, new String[]{"x", "y"});
        Position[] XorNode_positions = MatchRuleRegistry.findPositions(XorNode.TYPE, new String[]{"x", "y"});

        List<MatchStatement> statements = Collections.unmodifiableList(Arrays.asList(
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern("a", false), new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), AddNode_positions, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), new MatchPattern("a", false), AddNode_positions, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern("a", false), new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), AddNode_positions, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), new MatchPattern("a", false), AddNode_positions, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern("a", false), new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), AddNode_positions, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(AddNode.class, "binary", new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), new MatchPattern("a", false), AddNode_positions, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(SubNode.class, "binary", new MatchPattern("a", false), new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), SubNode_positions, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(SubNode.class, "binary", new MatchPattern("a", false), new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), SubNode_positions, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("addSubShift", new MatchPattern(SubNode.class, "binary", new MatchPattern("a", false), new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), SubNode_positions, true), MatchGenerator_addSubShift.instance, addSubShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false), new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), new MatchPattern("a", false), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false), new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), new MatchPattern("a", false), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false), new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), new MatchPattern("a", false), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false), new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), new MatchPattern("a", false), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false), new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), new MatchPattern("a", false), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false), new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), new MatchPattern("a", false), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false), new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), new MatchPattern("a", false), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false), new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), new MatchPattern("a", false), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false), new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), new MatchPattern("a", false), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false), new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), NotNode_positions, true), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), NotNode_positions, true), new MatchPattern("a", false), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false), new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), NotNode_positions, true), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), NotNode_positions, true), new MatchPattern("a", false), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern("a", false), new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), NotNode_positions, true), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(AndNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), NotNode_positions, true), new MatchPattern("a", false), AndNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false), new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), NotNode_positions, true), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), NotNode_positions, true), new MatchPattern("a", false), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false), new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), NotNode_positions, true), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), NotNode_positions, true), new MatchPattern("a", false), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern("a", false), new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), NotNode_positions, true), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(OrNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), NotNode_positions, true), new MatchPattern("a", false), OrNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false), new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), NotNode_positions, true), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(LeftShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), LeftShiftNode_positions, true), NotNode_positions, true), new MatchPattern("a", false), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false), new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), NotNode_positions, true), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(RightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), RightShiftNode_positions, true), NotNode_positions, true), new MatchPattern("a", false), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern("a", false), new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), NotNode_positions, true), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("logicShift", new MatchPattern(XorNode.class, "binary", new MatchPattern(NotNode.class, null, new MatchPattern(UnsignedRightShiftNode.class, "shift", new MatchPattern("b", false), new MatchPattern(ConstantNode.class, null, false), UnsignedRightShiftNode_positions, true), NotNode_positions, true), new MatchPattern("a", false), XorNode_positions, true), MatchGenerator_logicShift.instance, logicShift_arguments),
            new MatchStatement("multiplyNegate", new MatchPattern(MulNode.class, null, new MatchPattern(NegateNode.class, null, new MatchPattern("a", false), NegateNode_positions, true), new MatchPattern("b", false), MulNode_positions, true), MatchGenerator_multiplyNegate.instance, multiplyNegate_arguments),
            new MatchStatement("multiplyNegate", new MatchPattern(MulNode.class, null, new MatchPattern("b", false), new MatchPattern(NegateNode.class, null, new MatchPattern("a", false), NegateNode_positions, true), MulNode_positions, true), MatchGenerator_multiplyNegate.instance, multiplyNegate_arguments),
            new MatchStatement("multiplyNegate", new MatchPattern(NegateNode.class, null, new MatchPattern(MulNode.class, null, new MatchPattern("a", false), new MatchPattern("b", false), MulNode_positions, true), NegateNode_positions, true), MatchGenerator_multiplyNegate.instance, multiplyNegate_arguments),
            new MatchStatement("multiplyNegate", new MatchPattern(NegateNode.class, null, new MatchPattern(MulNode.class, null, new MatchPattern("b", false), new MatchPattern("a", false), MulNode_positions, true), NegateNode_positions, true), MatchGenerator_multiplyNegate.instance, multiplyNegate_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(AddNode.class, "binary", new MatchPattern(MulNode.class, null, new MatchPattern("a", false), new MatchPattern("b", false), MulNode_positions, true), new MatchPattern("c", false), AddNode_positions, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(AddNode.class, "binary", new MatchPattern("c", false), new MatchPattern(MulNode.class, null, new MatchPattern("a", false), new MatchPattern("b", false), MulNode_positions, true), AddNode_positions, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(AddNode.class, "binary", new MatchPattern(MulNode.class, null, new MatchPattern("b", false), new MatchPattern("a", false), MulNode_positions, true), new MatchPattern("c", false), AddNode_positions, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(AddNode.class, "binary", new MatchPattern("c", false), new MatchPattern(MulNode.class, null, new MatchPattern("b", false), new MatchPattern("a", false), MulNode_positions, true), AddNode_positions, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(SubNode.class, "binary", new MatchPattern("c", false), new MatchPattern(MulNode.class, null, new MatchPattern("a", false), new MatchPattern("b", false), MulNode_positions, true), SubNode_positions, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments),
            new MatchStatement("multiplyAddSub", new MatchPattern(SubNode.class, "binary", new MatchPattern("c", false), new MatchPattern(MulNode.class, null, new MatchPattern("b", false), new MatchPattern("a", false), MulNode_positions, true), SubNode_positions, true), MatchGenerator_multiplyAddSub.instance, multiplyAddSub_arguments)
        ));
        // Checkstyle: resume
        return statements;
    }

}
