/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.relaxng;

import com.sun.tools.internal.xjc.reader.Const;
import com.sun.tools.internal.xjc.reader.internalizer.AbstractReferenceFinderImpl;
import com.sun.tools.internal.xjc.reader.internalizer.DOMForest;
import com.sun.tools.internal.xjc.reader.internalizer.InternalizationLogic;

import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * RELAX NG specific internalization logic.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public class RELAXNGInternalizationLogic implements InternalizationLogic {

    /**
     * This filter looks for {@code <xs:import>} and {@code <xs:include>}
     * and parses those documents referenced by them.
     */
    private static final class ReferenceFinder extends AbstractReferenceFinderImpl {
        ReferenceFinder( DOMForest parent ) {
            super(parent);
        }

        protected String findExternalResource( String nsURI, String localName, Attributes atts) {
            if( Const.RELAXNG_URI.equals(nsURI)
            && ("include".equals(localName) || "externalRef".equals(localName) ) )
                return atts.getValue("href");
            else
                return null;
        }
    };

    public XMLFilterImpl createExternalReferenceFinder(DOMForest parent) {
        return new ReferenceFinder(parent);
    }

    public boolean checkIfValidTargetNode(DOMForest parent, Element bindings, Element target) {
        return Const.RELAXNG_URI.equals(target.getNamespaceURI());
    }

    public Element refineTarget(Element target) {
        // no refinement necessary
        return target;
    }

}
