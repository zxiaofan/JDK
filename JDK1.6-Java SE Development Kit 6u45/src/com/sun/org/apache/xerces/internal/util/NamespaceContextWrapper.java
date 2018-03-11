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
 * $Id: NamespaceContextWrapper.java,v 1.4 2005/11/03 17:54:06 jeffsuttor Exp $
 * %W% %E%
 *
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
 */

package com.sun.org.apache.xerces.internal.util;

import java.util.Enumeration;
import java.util.Vector;
import javax.xml.namespace.NamespaceContext;

/**
 * Writing a wrapper to re-use most of the namespace functionality 
 * already provided by NamespaceSupport, which implements NamespaceContext
 * from XNI. It would be good if we can change the XNI NamespaceContext 
 * interface to implement the JAXP NamespaceContext interface.
 *
 * Note that NamespaceSupport assumes the use of symbols. Since this class
 * can be exposed to the application, we must intern all Strings before
 * calling NamespaceSupport methods.
 *
 * @author  Neeraj Bajaj, Sun Microsystems, inc.
 * @author Santiago.PericasGeertsen@sun.com
 *
 */
public class NamespaceContextWrapper implements NamespaceContext {
    
    private com.sun.org.apache.xerces.internal.xni.NamespaceContext fNamespaceContext;
    
    public NamespaceContextWrapper(NamespaceSupport namespaceContext) {
        fNamespaceContext = namespaceContext ;
    }
    
    public String getNamespaceURI(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix can't be null");
        }
        return fNamespaceContext.getURI(prefix.intern());
    }
    
    public String getPrefix(String namespaceURI) {
        if (namespaceURI == null || namespaceURI.trim().length() == 0) {
            throw new IllegalArgumentException("URI can't be null or empty String");
        }
        return fNamespaceContext.getPrefix(namespaceURI.intern());
    }
    
    /**
     * TODO: Namespace doesn't give information giving multiple prefixes for
     * the same namespaceURI.
     */
    public java.util.Iterator getPrefixes(String namespaceURI) {
        if (namespaceURI == null || namespaceURI.trim().length() == 0) {
            throw new IllegalArgumentException("URI can't be null or empty String");
        } 
        else {
            Vector vector = 
                ((NamespaceSupport) fNamespaceContext).getPrefixes(namespaceURI.intern());
            return vector.iterator();
        }
    }
    
    /**
     * This method supports all functions in the NamespaceContext utility class
     */
    public com.sun.org.apache.xerces.internal.xni.NamespaceContext getNamespaceContext() {
        return fNamespaceContext;
    }

}
