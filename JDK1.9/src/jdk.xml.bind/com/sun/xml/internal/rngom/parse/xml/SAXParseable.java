/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.xml.internal.rngom.parse.xml;

import java.io.IOException;

import com.sun.xml.internal.rngom.ast.builder.BuildException;
import com.sun.xml.internal.rngom.ast.builder.IncludedGrammar;
import com.sun.xml.internal.rngom.ast.builder.SchemaBuilder;
import com.sun.xml.internal.rngom.ast.builder.Scope;
import com.sun.xml.internal.rngom.ast.om.ParsedPattern;
import com.sun.xml.internal.rngom.parse.IllegalSchemaException;
import com.sun.xml.internal.rngom.parse.Parseable;
import com.sun.xml.internal.rngom.xml.sax.JAXPXMLReaderCreator;
import com.sun.xml.internal.rngom.xml.sax.XMLReaderCreator;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * RELAX NG schema in the XML syntax.
 *
 */
public class SAXParseable implements Parseable {
  private final InputSource in;

  final XMLReaderCreator xrc;
  final ErrorHandler eh;

  public SAXParseable(InputSource in, ErrorHandler eh, XMLReaderCreator xrc) {
      this.xrc = xrc;
      this.eh = eh;
    this.in = in;
  }

  public SAXParseable(InputSource in, ErrorHandler eh) {
      this(in,eh,new JAXPXMLReaderCreator());
  }

  public ParsedPattern parse(SchemaBuilder schemaBuilder) throws BuildException, IllegalSchemaException {
    try {
      XMLReader xr = xrc.createXMLReader();
      SchemaParser sp = new SchemaParser(this, xr, eh, schemaBuilder, null, null,"");
      xr.parse(in);
      ParsedPattern p = sp.getParsedPattern();
      return schemaBuilder.expandPattern(p);
    }
    catch (SAXException e) {
      throw toBuildException(e);
    }
    catch (IOException e) {
      throw new BuildException(e);
    }
  }

      public ParsedPattern parseInclude(String uri, SchemaBuilder schemaBuilder, IncludedGrammar g, String inheritedNs)
              throws BuildException, IllegalSchemaException {
        try {
          XMLReader xr = xrc.createXMLReader();
          SchemaParser sp = new SchemaParser(this, xr, eh, schemaBuilder, g, g, inheritedNs);
          xr.parse(makeInputSource(xr, uri));
          return sp.getParsedPattern();
        }
        catch (SAXException e) {
         throw SAXParseable.toBuildException(e);
        }
        catch (IOException e) {
         throw new BuildException(e);
        }
      }

      public ParsedPattern parseExternal(String uri, SchemaBuilder schemaBuilder, Scope s, String inheritedNs)
              throws BuildException, IllegalSchemaException {
        try {
          XMLReader xr = xrc.createXMLReader();
          SchemaParser sp = new SchemaParser(this, xr, eh, schemaBuilder, null, s, inheritedNs);
          xr.parse(makeInputSource(xr, uri));
          return sp.getParsedPattern();
        }
        catch (SAXException e) {
          throw SAXParseable.toBuildException(e);
        }
        catch (IOException e) {
          throw new BuildException(e);
        }
      }

      private static InputSource makeInputSource(XMLReader xr, String systemId) throws IOException, SAXException {
        EntityResolver er = xr.getEntityResolver();
        if (er != null) {
          InputSource inputSource = er.resolveEntity(null, systemId);
          if (inputSource != null)
        return inputSource;
        }
        return new InputSource(systemId);
      }

      static BuildException toBuildException(SAXException e) {
        Exception inner = e.getException();
        if (inner instanceof BuildException)
          throw (BuildException)inner;
        throw new BuildException(e);
      }
    }
