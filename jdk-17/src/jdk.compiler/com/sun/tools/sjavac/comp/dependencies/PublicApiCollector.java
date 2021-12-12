/*
 * Copyright (c) 2014, 2021, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.comp.dependencies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.tools.JavaFileObject;

import com.sun.source.tree.Tree;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskListener;
import com.sun.tools.javac.code.Symbol.ClassSymbol;
import com.sun.tools.javac.tree.JCTree.JCClassDecl;
import com.sun.tools.javac.tree.JCTree.JCCompilationUnit;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.DefinedBy;
import com.sun.tools.javac.util.DefinedBy.Api;
import com.sun.tools.sjavac.Log;
import com.sun.tools.sjavac.comp.PubAPIs;
import com.sun.tools.sjavac.pubapi.PubApi;


public class PublicApiCollector implements TaskListener {

    private Context context;
    private final Set<ClassSymbol> classSymbols = new HashSet<>();
    private final Collection<JavaFileObject> explicitJFOs;

    // Result collected upon compilation task finished
    private Map<String, PubApi> explicitPubApis;
    private Map<String, PubApi> nonExplicitPubApis;

    public PublicApiCollector(Context context,
                              Collection<JavaFileObject> explicitJFOs) {
        this.context = context;
        this.explicitJFOs = explicitJFOs;
    }

    @Override
    @DefinedBy(Api.COMPILER_TREE)
    public void finished(TaskEvent e) {
        switch (e.getKind()) {
        case ANALYZE:
            collectClassSymbols((JCCompilationUnit) e.getCompilationUnit());
            break;
        case COMPILATION:
            Log.debug("Compilation finished");
            Log.debug("Extracting pub APIs for the following symbols:");
            for (ClassSymbol cs : classSymbols)
                Log.debug("    " + cs.fullname);
            extractPubApis();

            // Save result for later retrieval. (Important that we do this
            // before we return from this method, because we may not access
            // symbols after compilation is finished.)
            PubAPIs pa = PubAPIs.instance(context);
            explicitPubApis = pa.getPubapis(explicitJFOs, true);
            nonExplicitPubApis = pa.getPubapis(explicitJFOs, false);

            Log.debug("done");
            break;
        }
    }

    private void collectClassSymbols(JCCompilationUnit cu) {
        for (Tree t : cu.getTypeDecls()) {
            if (t instanceof JCClassDecl classDecl)  // Can also be a JCSkip
                classSymbols.add(classDecl.sym);
        }
    }

    private void extractPubApis() {
        // To handle incremental builds (subsequent sjavac invocations) we need
        // to keep track of the public API of what we depend upon.
        //
        // During the recompilation loop (within a single sjavac invocation) we
        // need to keep track of public API of what we're compiling to decide if
        // any dependants needs to be tainted.
        PubAPIs pubApis = PubAPIs.instance(context);
        classSymbols.forEach(pubApis::visitPubapi);
    }

    public Map<String, PubApi> getPubApis(boolean explicit) {
        return explicit ? explicitPubApis : nonExplicitPubApis;
    }
}
