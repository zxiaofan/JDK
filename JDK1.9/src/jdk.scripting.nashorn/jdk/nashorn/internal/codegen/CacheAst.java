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

package jdk.nashorn.internal.codegen;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import jdk.nashorn.internal.ir.FunctionNode;
import jdk.nashorn.internal.ir.Node;
import jdk.nashorn.internal.ir.Statement;
import jdk.nashorn.internal.ir.visitor.SimpleNodeVisitor;
import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;

class CacheAst extends SimpleNodeVisitor {
    private final Deque<RecompilableScriptFunctionData> dataStack = new ArrayDeque<>();

    private final Compiler compiler;

    CacheAst(final Compiler compiler) {
        this.compiler = compiler;
        assert !compiler.isOnDemandCompilation();
    }

    @Override
    public boolean enterFunctionNode(final FunctionNode functionNode) {
        final int id = functionNode.getId();
        // It isn't necessary to keep a stack of RecompilableScriptFunctionData, but then we'd need to do a
        // potentially transitive lookup with compiler.getScriptFunctionData(id) for deeper functions; this way
        // we keep it constant time.
        dataStack.push(dataStack.isEmpty() ? compiler.getScriptFunctionData(id) : dataStack.peek().getScriptFunctionData(id));
        return true;
    }

    @Override
    public Node leaveFunctionNode(final FunctionNode functionNode) {
        final RecompilableScriptFunctionData data = dataStack.pop();
        if (functionNode.isSplit()) {
            // NOTE: cache only split function ASTs from eager pass. Caching non-split functions would require
            // some additional work, namely creating the concept of "uncacheable" function and reworking
            // ApplySpecialization to ensure that functions undergoing apply-to-call transformations are not
            // cacheable as well as recomputing Symbol.useCount when caching the eagerly parsed AST.
            // Recomputing Symbol.useCount would be needed so it will only reflect uses from within the
            // function being cached (and not reflect uses from its own nested functions or functions it is
            // nested in). This is consistent with the count an on-demand recompilation of the function would
            // produce. This is important as the decision to emit shared scope calls is based on this count,
            // and if it is not matched between a previous version of the code and its deoptimizing rest-of
            // compilation, it can result in rest-of not emitting a shared scope call where a previous version
            // of the code (compiled from a cached eager pre-pass seeing higher (global) useCount) would emit
            // it, causing a mismatch in stack shapes between previous code and its rest-of.
            data.setCachedAst(functionNode);
        }

        if (!dataStack.isEmpty() && ((dataStack.peek().getFunctionFlags() & FunctionNode.IS_SPLIT) != 0)) {
            // Return a function node with no body so that caching outer functions doesn't hold on to nested
            // functions' bodies. Note we're doing this only for functions directly nested inside split
            // functions, since we're only caching the split ones. It is not necessary to limit body removal
            // to just these functions, but it's a cheap way to prevent unnecessary AST mutations.
            return functionNode.setBody(lc, functionNode.getBody().setStatements(null, Collections.<Statement>emptyList()));
        }
        return functionNode;
    }
}
