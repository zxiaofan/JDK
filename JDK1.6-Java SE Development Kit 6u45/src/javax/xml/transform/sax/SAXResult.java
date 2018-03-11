/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * https://jaxp.dev.java.net/CDDLv1.0.html.
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * https://jaxp.dev.java.net/CDDLv1.0.html
 * If applicable add the following below this CDDL HEADER
 * with the fields enclosed by brackets "[]" replaced with
 * your own identifying information: Portions Copyright
 * [year] [name of copyright owner]
 */

/*
 * $Id: XMLEntityReader.java,v 1.3 2005/11/03 17:02:21 jeffsuttor Exp $
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 */

package javax.xml.transform.sax;

import javax.xml.transform.Result;

import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/**
 * <p>Acts as an holder for a transformation Result.</p>
 * 
 * @author <a href="Jeff.Suttor@Sun.com">Jeff Suttor</a>
 */
public class SAXResult implements Result {

    /**
     * If {@link javax.xml.transform.TransformerFactory#getFeature}
     * returns true when passed this value as an argument,
     * the Transformer supports Result output of this type.
     */
    public static final String FEATURE =
        "http://javax.xml.transform.sax.SAXResult/feature";

    /**
     * Zero-argument default constructor.
     */
    public SAXResult() {
    }

    /**
     * Create a SAXResult that targets a SAX2 {@link org.xml.sax.ContentHandler}.
     *
     * @param handler Must be a non-null ContentHandler reference.
     */
    public SAXResult(ContentHandler handler) {
        setHandler(handler);
    }

    /**
     * Set the target to be a SAX2 {@link org.xml.sax.ContentHandler}.
     *
     * @param handler Must be a non-null ContentHandler reference.
     */
    public void setHandler(ContentHandler handler) {
        this.handler = handler;
    }

    /**
     * Get the {@link org.xml.sax.ContentHandler} that is the Result.
     *
     * @return The ContentHandler that is to be transformation output.
     */
    public ContentHandler getHandler() {
        return handler;
    }

    /**
     * Set the SAX2 {@link org.xml.sax.ext.LexicalHandler} for the output.
     *
     * <p>This is needed to handle XML comments and the like.  If the
     * lexical handler is not set, an attempt should be made by the
     * transformer to cast the {@link org.xml.sax.ContentHandler} to a
     * <code>LexicalHandler</code>.</p>
     *
     * @param handler A non-null <code>LexicalHandler</code> for
     * handling lexical parse events.
     */
    public void setLexicalHandler(LexicalHandler handler) {
        this.lexhandler = handler;
    }

    /**
     * Get a SAX2 {@link org.xml.sax.ext.LexicalHandler} for the output.
     *
     * @return A <code>LexicalHandler</code>, or null.
     */
    public LexicalHandler getLexicalHandler() {
        return lexhandler;
    }

    /**
     * Method setSystemId Set the systemID that may be used in association
     * with the {@link org.xml.sax.ContentHandler}.
     *
     * @param systemId The system identifier as a URI string.
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    /**
     * Get the system identifier that was set with setSystemId.
     *
     * @return The system identifier that was set with setSystemId, or null
     * if setSystemId was not called.
     */
    public String getSystemId() {
        return systemId;
    }

    //////////////////////////////////////////////////////////////////////
    // Internal state.
    //////////////////////////////////////////////////////////////////////

    /**
     * The handler for parse events.
     */
    private ContentHandler handler;

    /**
     * The handler for lexical events.
     */
    private LexicalHandler lexhandler;

    /**
     * The systemID that may be used in association
     * with the node.
     */
    private String systemId;
}
