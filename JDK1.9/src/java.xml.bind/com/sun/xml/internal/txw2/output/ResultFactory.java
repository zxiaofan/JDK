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

package com.sun.xml.internal.txw2.output;

import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;

/**
 * Factory for producing XmlSerializers for various Result types.
 *
 * @author Ryan.Shoemaker@Sun.COM
 */
public abstract class ResultFactory {

    /**
     * Do not instanciate.
     */
    private ResultFactory() {}

    /**
     * Factory method for producing {@link XmlSerializer} from {@link javax.xml.transform.Result}.
     *
     * This method supports {@link javax.xml.transform.sax.SAXResult},
     * {@link javax.xml.transform.stream.StreamResult}, and {@link javax.xml.transform.dom.DOMResult}.
     *
     * @param result the Result that will receive output from the XmlSerializer
     * @return an implementation of XmlSerializer that will produce output on the supplied Result
     */
    public static XmlSerializer createSerializer(Result result) {
        if (result instanceof SAXResult)
            return new SaxSerializer((SAXResult) result);
        if (result instanceof DOMResult)
            return new DomSerializer((DOMResult) result);
        if (result instanceof StreamResult)
            return new StreamSerializer((StreamResult) result);
        if (result instanceof TXWResult)
            return new TXWSerializer(((TXWResult)result).getWriter());

        throw new UnsupportedOperationException("Unsupported Result type: " + result.getClass().getName());
    }

}
