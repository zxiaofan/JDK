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

import com.sun.tools.javac.code.Source;
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
        class Mark {}
        if (context.get(Mark.class) == null) { //don't register the factory if Context is reused
            context.put(parserFactoryKey, (Context.Factory<ParserFactory>)
                    (c -> new ReplParserFactory(c, forceExpression)));
            context.put(Mark.class, new Mark());
        }
    }

    private final ScannerFactory scannerFactory;
            final Source source;

    protected ReplParserFactory(Context context, boolean forceExpression) {
        super(context);
        this.forceExpression = forceExpression;
        this.scannerFactory = ScannerFactory.instance(context);
        this.source = Source.instance(context);
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
