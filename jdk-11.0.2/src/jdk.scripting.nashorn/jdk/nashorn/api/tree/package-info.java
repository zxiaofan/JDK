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

/**
 * <p>
 * Nashorn parser API provides interfaces to represent ECMAScript source code
 * as abstract syntax trees (AST) and Parser to parse ECMAScript source scripts.
 * </p>
 * <p>
 * Using parser API user can write Java code to access parse tree
 * representation of ECMAScript source. Script source may be a file,
 * a URL or a String. Unless stated otherwise null argument in methods of this
 * package result in NullPointerException being thrown.
 * </p>
 *
 * <pre>
 * <code>
 * import jdk.nashorn.api.tree.*;
 * import java.io.File;
 *
 * // Simple example that prints warning on 'with' statements
 * public class Main {
 *     public static void main(String[] args) throws Exception {
 *         // Create a new parser instance
 *         Parser parser = Parser.create();
 *         File sourceFile = new File(args[0]);
 *
 *         // Parse given source File using parse method.
 *         // Pass a diagnostic listener to print error messages.
 *         CompilationUnitTree cut = parser.parse(sourceFile,
 *             (d) -&gt; { System.out.println(d); });
 *
 *         if (cut != null) {
 *             // call Tree.accept method passing a SimpleTreeVisitor
 *             cut.accept(new SimpleTreeVisitor&lt;Void, Void&gt;() {
 *                 // visit method for 'with' statement
 *                 public Void visitWith(WithTree wt, Void v) {
 *                     // print warning on 'with' statement
 *                     System.out.println("Warning: using 'with' statement!");
 *                     return null;
 *                 }
 *             }, null);
 *         }
 *     }
 * }
 * </code>
 * </pre>
 *
 * @since 9
 */
package jdk.nashorn.api.tree;

