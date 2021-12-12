/*
 * Copyright (c) 2010, 2019, Oracle and/or its affiliates. All rights reserved.
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
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import jdk.javadoc.internal.doclets.toolkit.util.DocFileIOException;
import jdk.javadoc.internal.doclets.toolkit.util.DocletConstants;

/**
 * Class for generating an HTML document for javadoc output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class HtmlDocument {
    private final DocType docType = DocType.HTML5;
    private final Content docContent;

    /**
     * Constructor to construct an HTML document.
     *
     * @param htmlTree HTML tree of the document
     */
    public HtmlDocument(Content htmlTree) {
        docContent = htmlTree;
    }

    /**
     * Writes the content of this document to the specified file.
     *
     * @param docFile the file
     * @throws DocFileIOException if an {@code IOException} occurs while writing the file
     */
    public void write(DocFile docFile) throws DocFileIOException {
        try (Writer writer = docFile.openWriter()) {
            write(writer);
        } catch (IOException e) {
            throw new DocFileIOException(docFile, DocFileIOException.Mode.WRITE, e);
        }
    }

    @Override
    public String toString() {
        try (Writer writer = new StringWriter()) {
            write(writer);
            return writer.toString();
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    private void write(Writer writer) throws IOException {
        writer.write(docType.text);
        writer.write(DocletConstants.NL);
        docContent.write(writer, true);
    }
}
