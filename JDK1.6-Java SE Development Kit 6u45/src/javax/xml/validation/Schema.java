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
 * Immutable in-memory representation of grammar.
 * 
 * <p>
 * This object represents a set of constraints that can be checked/
 * enforced against an XML document. 
 * 
 * <p>
 * A {@link Schema} object is thread safe and applications are
 * encouraged to share it across many parsers in many threads.
 * 
 * <p>
 * A {@link Schema} object is immutable in the sense that it shouldn't
 * change the set of constraints once it is created. In other words,
 * if an application validates the same document twice against the same
 * {@link Schema}, it must always produce the same result. 
 * 
 * <p>
 * A {@link Schema} object is usually created from {@link SchemaFactory}.
 * 
 * <p>
 * Two kinds of validators can be created from a {@link Schema} object.
 * One is {@link Validator}, which provides highly-level validation
 * operations that cover typical use cases. The other is
 * {@link ValidatorHandler}, which works on top of SAX for better
 * modularity.
 * 
 * <p>
 * This specification does not refine
 * the {@link java.lang.Object#equals(java.lang.Object)} method.
 * In other words, if you parse the same schema twice, you may
 * still get <code>!schemaA.equals(schemaB)</code>.
 * 
 * @author <a href="mailto:Kohsuke.Kawaguchi@Sun.com">Kohsuke Kawaguchi</a>
 * @version $Revision: 1.3 $, $Date: 2005/10/12 17:14:21 $
 * @see <a href="http://www.w3.org/TR/xmlschema-1/">XML Schema Part 1: Structures</a>
 * @see <a href="http://www.w3.org/TR/xml11/">Extensible Markup Language (XML) 1.1</a>
 * @see <a href="http://www.w3.org/TR/REC-xml">Extensible Markup Language (XML) 1.0 (Second Edition)</a>
 * @since 1.5
 */
public abstract class Schema {
    
    /**
     * Constructor for the derived class.
     * 
     * <p>
     * The constructor does nothing.
     */
    protected Schema() {
    }
    
    /**
     * Creates a new {@link Validator} for this {@link Schema}.
     * 
     * <p>A validator enforces/checks the set of constraints this object
     * represents.</p>
     *
     * <p>Implementors should assure that the properties set on the
     * {@link SchemaFactory} that created this {@link Schema} are also
     * set on the {@link Validator} constructed.</p>
     * 
     * @return
     *      Always return a non-null valid object.
     */
    public abstract Validator newValidator();
    
    /**
     * Creates a new {@link ValidatorHandler} for this {@link Schema}.
     * 
     * <p>Implementors should assure that the properties set on the
     * {@link SchemaFactory} that created this {@link Schema} are also
     * set on the {@link ValidatorHandler} constructed.</p>
     * 
     * @return
     *      Always return a non-null valid object.
     */
    public abstract ValidatorHandler newValidatorHandler();
}
