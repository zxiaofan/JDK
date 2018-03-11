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
 * $Id: TransformerHandler.java,v 1.3 2005/11/03 19:34:26 jeffsuttor Exp $
 * %W% %E%
 *
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
 */

package javax.xml.transform.sax;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;

import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.ext.LexicalHandler;

/**
 * A TransformerHandler
 * listens for SAX ContentHandler parse events and transforms
 * them to a Result.
 */
public interface TransformerHandler
    extends ContentHandler, LexicalHandler, DTDHandler {

    /**
     * <p>Set  the <code>Result</code> associated with this
     * <code>TransformerHandler</code> to be used for the transformation.</p>
     *
     * @param result A <code>Result</code> instance, should not be
     *   <code>null</code>.
     *
     * @throws IllegalArgumentException if result is invalid for some reason.
     */
    public void setResult(Result result) throws IllegalArgumentException;

    /**
     * Set the base ID (URI or system ID) from where relative
     * URLs will be resolved.
     * @param systemID Base URI for the source tree.
     */
    public void setSystemId(String systemID);

    /**
     * Get the base ID (URI or system ID) from where relative
     * URLs will be resolved.
     * @return The systemID that was set with {@link #setSystemId}.
     */
    public String getSystemId();

    /**
     * <p>Get the <code>Transformer</code> associated with this handler, which
     * is needed in order to set parameters and output properties.</p>
     * 
     * @return <code>Transformer</code> associated with this
     *   <code>TransformerHandler</code>.
     */
    public Transformer getTransformer();
}
