/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jshell;

import java.io.IOException;
import java.io.StringWriter;
import com.sun.source.tree.ClassTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.Tree;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCBlock;
import com.sun.tools.javac.tree.JCTree.JCClassDecl;
import com.sun.tools.javac.tree.JCTree.JCExpression;
import com.sun.tools.javac.tree.JCTree.JCMethodDecl;
import com.sun.tools.javac.tree.JCTree.JCNewClass;
import com.sun.tools.javac.tree.JCTree.JCStatement;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.tree.Pretty;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Names;
import static com.sun.tools.javac.code.Flags.STATIC;
import static com.sun.tools.javac.code.Flags.INTERFACE;
import static com.sun.tools.javac.code.Flags.ENUM;
import static com.sun.tools.javac.code.Flags.PUBLIC;
import com.sun.tools.javac.util.Name;
import jdk.jshell.spi.SPIResolutionException;

/**
 * Produce a corralled version of the Wrap for a snippet.
 * Incoming tree is mutated.
 *
 * @author Robert Field
 */
class Corraller extends Pretty {

    private final StringWriter out;
    private final int keyIndex;
    private final TreeMaker make;
    private final Names names;
    private JCBlock resolutionExceptionBlock;

    public Corraller(int keyIndex, Context context) {
        this(new StringWriter(), keyIndex, context);
    }

    private Corraller(StringWriter out, int keyIndex, Context context) {
        super(out, false);
        this.out = out;
        this.keyIndex = keyIndex;
        this.make = TreeMaker.instance(context);
        this.names = Names.instance(context);
    }

    public Wrap corralType(ClassTree ct) {
        ((JCClassDecl) ct).mods.flags |= Flags.STATIC | Flags.PUBLIC;
        return corral(ct);
    }

    public Wrap corralMethod(MethodTree mt) {
        ((JCMethodDecl) mt).mods.flags |= Flags.STATIC | Flags.PUBLIC;
        return corral(mt);
    }

    private Wrap corral(Tree tree) {
        try {
            printStat((JCTree) tree);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
        return Wrap.simpleWrap(out.toString());
    }

    @Override
    public void visitBlock(JCBlock tree) {
        // Top-level executable blocks (usually method bodies) are corralled
        super.visitBlock((tree.flags & STATIC) != 0
                ? tree
                : resolutionExceptionBlock());
    }

    @Override
    public void visitVarDef(JCVariableDecl tree) {
        // No field inits in corralled classes
        tree.init = null;
        super.visitVarDef(tree);
    }

    @Override
    public void visitClassDef(JCClassDecl tree) {
        if ((tree.mods.flags & (INTERFACE | ENUM)) == 0 &&
                !tree.getMembers().stream()
                .anyMatch(t -> t.getKind() == Tree.Kind.METHOD &&
                ((MethodTree) t).getName() == tree.name.table.names.init)) {
            // Generate a default constructor, since
            // this is a regular class and there are no constructors
            ListBuffer<JCTree> ndefs = new ListBuffer<>();
            ndefs.addAll(tree.defs);
            ndefs.add(make.MethodDef(make.Modifiers(PUBLIC),
                    tree.name.table.names.init,
                    null, List.nil(), List.nil(), List.nil(),
                    resolutionExceptionBlock(), null));
            tree.defs = ndefs.toList();
        }
        super.visitClassDef(tree);
    }

    // Build a compiler tree for an exception throwing block, e.g.:
    // {
    //     throw new jdk.jshell.spi.SPIResolutionException(9);
    // }
    private JCBlock resolutionExceptionBlock() {
        if (resolutionExceptionBlock == null) {
            JCExpression expClass = null;
            // Split the exception class name at dots
            for (String id : SPIResolutionException.class.getName().split("\\.")) {
                Name nm = names.fromString(id);
                if (expClass == null) {
                    expClass = make.Ident(nm);
                } else {
                    expClass = make.Select(expClass, nm);
                }
            }
            JCNewClass exp = make.NewClass(null,
                    null, expClass, List.of(make.Literal(keyIndex)), null);
            resolutionExceptionBlock = make.Block(0L, List.of(make.Throw(exp)));
        }
        return resolutionExceptionBlock;
    }
}
