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

package javax.xml.validation;

/**
 * <p>Factory that creates {@link SchemaFactory}.</p>
 * 
 * <p><b>DO NOT USE THIS CLASS</b></p>
 * 
 * <p>
 * This class was introduced as a part of an early proposal during the
 * JSR-206 standardization process. The proposal was eventually abandoned
 * but this class accidentally remained in the source tree, and made its
 * way into the final version.
 * </p><p>
 * This class does not participate in any JAXP 1.3 or JAXP 1.4 processing.
 * It must not be used by users or JAXP implementations.
 * </p>
 * 
 * @author <a href="Kohsuke.Kawaguchi@Sun.com">Kohsuke Kawaguchi</a>
 * @version $Revision: 1.1 $, $Date: 2005/10/12 16:48:28 $
 * @since 1.5
 */
public abstract class SchemaFactoryLoader {
    
    /**
     * A do-nothing constructor.
     */
    protected SchemaFactoryLoader() {
    }
    
    /**
     * Creates a new {@link SchemaFactory} object for the specified
     * schema language.
     * 
     * @param schemaLanguage
     *      See <a href="SchemaFactory.html#schemaLanguage">
     *      the list of available schema languages</a>.
     * 
     * @throws NullPointerException
     *      If the <tt>schemaLanguage</tt> parameter is null.
     * 
     * @return <code>null</code> if the callee fails to create one.
     */
    public abstract SchemaFactory newFactory(String schemaLanguage);
}
