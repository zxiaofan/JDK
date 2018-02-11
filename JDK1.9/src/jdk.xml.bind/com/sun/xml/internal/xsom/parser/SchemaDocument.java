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

package com.sun.xml.internal.xsom.parser;

import com.sun.xml.internal.xsom.XSSchema;

import java.util.Set;

/**
 * Represents a parsed XML schema document.
 *
 * <p>
 * Unlike schema components defined in {@code XS****} interfaces,
 * which are inherently de-coupled from where it was loaded from,
 * {@link SchemaDocument} represents a single XML infoset that
 * is a schema document.
 *
 * <p>
 * This concept is often useful in tracking down the reference
 * relationship among schema documents.
 *
 * @see XSOMParser#getDocuments()
 * @author Kohsuke Kawaguchi
 */
public interface SchemaDocument {
    /**
     * Gets the system ID of the schema document.
     *
     * @return
     *      null if {@link XSOMParser} was not given the system Id.
     */
    String getSystemId();

    /**
     * The namespace that this schema defines.
     *
     * <p>
     * More precisely, this method simply returns the {@code targetNamespace} attribute
     * of the schema document. When schemas are referenced in certain ways
     * (AKA chameleon schema), schema components in this schema document
     * may end up defining components in other namespaces.
     *
     * @return
     *      can be "" but never null.
     */
    String getTargetNamespace();

    /**
     * Gets {@link XSSchema} component that contains all the schema
     * components defined in this namespace.
     *
     * <p>
     * The returned {@link XSSchema} contains not just components
     * defined in this {@link SchemaDocument} but all the other components
     * defined in all the schemas that collectively define this namespace.
     *
     * @return
     *      never null.
     */
    XSSchema getSchema();

    /**
     * Set of {@link SchemaDocument}s that are included/imported from this document.
     *
     * @return
     *      can be empty but never null. read-only.
     */
    Set<SchemaDocument> getReferencedDocuments();

    /**
     * Gets the {@link SchemaDocument}s that are included from this document.
     *
     * @return
     *      can be empty but never null. read-only.
     *      this set is always a subset of {@link #getReferencedDocuments()}.
     */
    Set<SchemaDocument> getIncludedDocuments();

    /**
     * Gets the {@link SchemaDocument}s that are imported from this document.
     *
     * @param targetNamespace
     *      The namespace URI of the import that you want to
     *      get {@link SchemaDocument}s for.
     * @return
     *      can be empty but never null. read-only.
     *      this set is always a subset of {@link #getReferencedDocuments()}.
     */
    Set<SchemaDocument> getImportedDocuments(String targetNamespace);

    /**
     * Returns true if this document includes the given document.
     *
     * <p>
     * Note that this method returns false if this document
     * imports the given document.
     */
    boolean includes(SchemaDocument doc);

    /**
     * Returns true if this document imports the given document.
     *
     * <p>
     * Note that this method returns false if this document
     * includes the given document.
     */
    boolean imports(SchemaDocument doc);

    /**
     * Set of {@link SchemaDocument}s that include/import this document.
     *
     * <p>
     * This works as the opposite of {@link #getReferencedDocuments()}.
     *
     * @return
     *      can be empty but never null. read-only.
     */
    Set<SchemaDocument> getReferers();
}
