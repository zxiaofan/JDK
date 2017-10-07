/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.util;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.server.SDDocument;
import com.sun.xml.internal.ws.wsdl.SDDocumentResolver;

import java.util.*;

/**
 * WSDL, schema document metadata utility class.
 *
 * @author Jitendra Kotamraju
 */
public class MetadataUtil {

    /**
     * Gets closure of all the referenced documents from the primary document(typically
     * the service WSDL). It traverses the WSDL and schema imports and builds a closure
     * set of documents.
     *
     * @param systemId primary wsdl or the any root document
     * @param resolver used to get SDDocumentImpl for a document
     * @param onlyTopLevelSchemas if true, the imported schemas from a schema would be ignored
     * @return all the documents
     */
    public static Map<String, SDDocument> getMetadataClosure(@NotNull String systemId,
            @NotNull SDDocumentResolver resolver, boolean onlyTopLevelSchemas) {
        Map <String, SDDocument> closureDocs = new HashMap<String, SDDocument>();
        Set<String> remaining = new HashSet<String>();
        remaining.add(systemId);

        while(!remaining.isEmpty()) {
            Iterator<String> it = remaining.iterator();
            String current = it.next();
            remaining.remove(current);

            SDDocument currentDoc = resolver.resolve(current);
            SDDocument old = closureDocs.put(currentDoc.getURL().toExternalForm(), currentDoc);
            assert old == null;

            Set<String> imports =  currentDoc.getImports();
            if (!currentDoc.isSchema() || !onlyTopLevelSchemas) {
                for(String importedDoc : imports) {
                    if (closureDocs.get(importedDoc) == null) {
                        remaining.add(importedDoc);
                    }
                }
            }
        }

        return closureDocs;
    }

}
