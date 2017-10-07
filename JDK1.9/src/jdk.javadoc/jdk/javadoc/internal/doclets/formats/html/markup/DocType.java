/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.formats.html.markup;

import java.io.IOException;
import java.io.Writer;

import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocletConstants;

/**
 * Class for generating document type for HTML pages of javadoc output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Bhavesh Patel
 */
public class DocType extends Content {

    private String docType;

    public static final DocType TRANSITIONAL =
            new DocType("Transitional", "http://www.w3.org/TR/html4/loose.dtd");

    public static final DocType HTML5 = new DocType();

    /**
     * Constructor to construct a DocType object.
     *
     * @param type the doctype to be added
     * @param dtd the dtd of the doctype
     */
    private DocType(String type, String dtd) {
        docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 " + type +
                "//EN\" \"" + dtd + "\">" + DocletConstants.NL;
    }

    /**
     * Constructor to construct a DocType object.
     */
    private DocType() {
        docType = "<!DOCTYPE HTML>" + DocletConstants.NL;
    }

    /**
     * This method is not supported by the class.
     *
     * @param content content that needs to be added
     * @throws UnsupportedOperationException always
     */
    public void addContent(Content content) {
        throw new UnsupportedOperationException();
    }

    /**
     * This method is not supported by the class.
     *
     * @param stringContent string content that needs to be added
     * @throws UnsupportedOperationException always
     */
    @Override
    public void addContent(CharSequence stringContent) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return (docType.length() == 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean write(Writer out, boolean atNewline) throws IOException {
        out.write(docType);
        return true; // guaranteed by constructor
    }
}
