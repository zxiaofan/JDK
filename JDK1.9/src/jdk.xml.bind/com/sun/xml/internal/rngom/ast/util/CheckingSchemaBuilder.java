/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
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
/*
 * Copyright (C) 2004-2011
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sun.xml.internal.rngom.ast.util;

import com.sun.xml.internal.rngom.ast.builder.BuildException;
import com.sun.xml.internal.rngom.ast.builder.SchemaBuilder;
import com.sun.xml.internal.rngom.ast.om.ParsedPattern;
import com.sun.xml.internal.rngom.binary.SchemaBuilderImpl;
import com.sun.xml.internal.rngom.binary.SchemaPatternBuilder;
import com.sun.xml.internal.rngom.parse.IllegalSchemaException;
import com.sun.xml.internal.rngom.parse.host.ParsedPatternHost;
import com.sun.xml.internal.rngom.parse.host.SchemaBuilderHost;
import com.sun.xml.internal.org.relaxng.datatype.DatatypeLibraryFactory;
import org.xml.sax.ErrorHandler;

/**
 * Wraps a {@link SchemaBuilder} and does all the semantic checks
 * required by the RELAX NG spec.
 *
 * <h2>Usage</h2>
 * <p>
 * Whereas you normally write it as follows:
 * <pre>
 * YourParsedPattern r = (YourParsedPattern)parseable.parse(sb);
 * </pre>
 * write this as follows:
 * <pre>
 * YourParsedPattern r = (YourParsedPattern)parseable.parse(new CheckingSchemaBuilder(sb,eh));
 * </pre>
 *
 * <p>
 * The checking is done by using the {@code rngom.binary} package, so if you are using
 * that package for parsing schemas, then there's no need to use this.
 *
 * @author
 *      Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public class CheckingSchemaBuilder extends SchemaBuilderHost {
    /**
     *
     * @param sb
     *      Your {@link SchemaBuilder} that parses RELAX NG schemas.
     * @param eh
     *      All the errors found will be sent to this handler.
     */
    public CheckingSchemaBuilder( SchemaBuilder sb, ErrorHandler eh ) {
        super(new SchemaBuilderImpl(eh),sb);
    }
    public CheckingSchemaBuilder( SchemaBuilder sb, ErrorHandler eh, DatatypeLibraryFactory dlf ) {
        super(new SchemaBuilderImpl(eh,dlf,new SchemaPatternBuilder()),sb);
    }

    public ParsedPattern expandPattern(ParsedPattern p)
        throws BuildException, IllegalSchemaException {

        // just return the result from the user-given SchemaBuilder
        ParsedPatternHost r = (ParsedPatternHost)super.expandPattern(p);
        return r.rhs;
    }
}
