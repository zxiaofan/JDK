/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.tools.javac.parser.JavacParser;
import com.sun.tools.javac.parser.ParserFactory;
import com.sun.tools.javac.parser.ScannerFactory;
import com.sun.tools.javac.util.Context;

/**
 *
 * @author Robert Field
 */
class ReplParserFactory extends ParserFactory {

    // force starting in expression mode
    private final boolean forceExpression;

    public static void preRegister(Context context, boolean forceExpression) {
        context.put(parserFactoryKey, (Context.Factory<ParserFactory>)
                (c -> new ReplParserFactory(c, forceExpression)));
    }

    private final ScannerFactory scannerFactory;

    protected ReplParserFactory(Context context, boolean forceExpression) {
        super(context);
        this.forceExpression = forceExpression;
        this.scannerFactory = ScannerFactory.instance(context);
    }

    @Override
    public JavacParser newParser(CharSequence input, boolean keepDocComments, boolean keepEndPos, boolean keepLineMap) {
        com.sun.tools.javac.parser.Lexer lexer = scannerFactory.newScanner(input, keepDocComments);
        return new ReplParser(this, lexer, keepDocComments, keepLineMap, keepEndPos, forceExpression);
    }

    @Override
    public JavacParser newParser(CharSequence input, boolean keepDocComments, boolean keepEndPos, boolean keepLineMap, boolean parseModuleInfo) {
        return newParser(input, keepDocComments, keepEndPos, keepLineMap);
    }
}
