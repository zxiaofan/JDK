/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.xsom.impl.parser;

import com.sun.xml.internal.xsom.impl.SchemaImpl;
import com.sun.xml.internal.xsom.parser.SchemaDocument;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link SchemaDocument} implementation.
 *
 * @author Kohsuke Kawaguchi
 */
public final class SchemaDocumentImpl implements SchemaDocument
{
    private final SchemaImpl schema;

    /**
     * URI of the schema document to be parsed. Can be null.
     */
    private final String schemaDocumentURI;

    /**
     * {@link SchemaDocumentImpl}s that are referenced from this document.
     */
    final Set<SchemaDocumentImpl> references = new HashSet<SchemaDocumentImpl>();

    /**
     * {@link SchemaDocumentImpl}s that are referencing this document.
     */
    final Set<SchemaDocumentImpl> referers = new HashSet<SchemaDocumentImpl>();

    protected SchemaDocumentImpl(SchemaImpl schema, String _schemaDocumentURI) {
        this.schema = schema;
        this.schemaDocumentURI = _schemaDocumentURI;
    }

    public String getSystemId() {
        return schemaDocumentURI;
    }

    public String getTargetNamespace() {
        return schema.getTargetNamespace();
    }

    public SchemaImpl getSchema() {
        return schema;
    }

    public Set<SchemaDocument> getReferencedDocuments() {
        return Collections.<SchemaDocument>unmodifiableSet(references);
    }

    public Set<SchemaDocument> getIncludedDocuments() {
        return getImportedDocuments(this.getTargetNamespace());
    }

    public Set<SchemaDocument> getImportedDocuments(String targetNamespace) {
        if(targetNamespace==null)
            throw new IllegalArgumentException();
        Set<SchemaDocument> r = new HashSet<SchemaDocument>();
        for (SchemaDocumentImpl doc : references) {
            if(doc.getTargetNamespace().equals(targetNamespace))
                r.add(doc);
        }
        return Collections.unmodifiableSet(r);
    }

    public boolean includes(SchemaDocument doc) {
        if(!references.contains(doc))
            return false;
        return doc.getSchema()==schema;
    }

    public boolean imports(SchemaDocument doc) {
        if(!references.contains(doc))
            return false;
        return doc.getSchema()!=schema;
    }

    public Set<SchemaDocument> getReferers() {
        return Collections.<SchemaDocument>unmodifiableSet(referers);
    }

    @Override
    public boolean equals(Object o) {
        SchemaDocumentImpl rhs = (SchemaDocumentImpl) o;

        if( this.schemaDocumentURI==null || rhs.schemaDocumentURI==null)
            return this==rhs;
        if(!schemaDocumentURI.equals(rhs.schemaDocumentURI) )
            return false;
        return this.schema==rhs.schema;
    }

    @Override
    public int hashCode() {
        if (schemaDocumentURI==null)
            return super.hashCode();
        if (schema == null) {
            return schemaDocumentURI.hashCode();
        }
        return schemaDocumentURI.hashCode()^this.schema.hashCode();
    }
}
