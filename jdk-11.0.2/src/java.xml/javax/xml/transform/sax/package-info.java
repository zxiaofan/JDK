/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Provides SAX specific transformation classes.
 *
 * <p>
 * The {@link javax.xml.transform.sax.SAXSource} class allows the
 * setting of an {@link org.xml.sax.XMLReader} to be used for pulling
 * parse events, and an {@link org.xml.sax.InputSource} that may be used to
 * specify the SAX source.
 * <p>
 * The {@link javax.xml.transform.sax.SAXResult} class allows the
 * setting of a {@link org.xml.sax.ContentHandler} to be the receiver of
 * SAX2 events from the transformation.
 * <p>
 * The {@link javax.xml.transform.sax.SAXTransformerFactory} extends
 * {@link javax.xml.transform.TransformerFactory} to provide factory
 * methods for creating {@link javax.xml.transform.sax.TemplatesHandler},
 * {@link javax.xml.transform.sax.TransformerHandler}, and
 * {@link org.xml.sax.XMLReader} instances.
 * <p>
 * To obtain a {@link javax.xml.transform.sax.SAXTransformerFactory},
 * the caller must cast the {@link javax.xml.transform.TransformerFactory}
 * instance returned from
 * {@link javax.xml.transform.TransformerFactory#newInstance}.
 *
 * <p>
 * The {@link javax.xml.transform.sax.TransformerHandler} interface
 * allows a transformation to be created from SAX2 parse events, which is a "push"
 * model rather than the "pull" model that normally occurs for a transformation.
 * Normal parse events are received through the
 * {@link org.xml.sax.ContentHandler} interface, lexical events such as
 * startCDATA and endCDATA are received through the
 * {@link org.xml.sax.ext.LexicalHandler} interface, and events that signal
 * the start or end of disabling output escaping are received via
 * {@link org.xml.sax.ContentHandler#processingInstruction}, with the
 * target parameter being
 * {@link javax.xml.transform.Result#PI_DISABLE_OUTPUT_ESCAPING} and
 * {@link javax.xml.transform.Result#PI_ENABLE_OUTPUT_ESCAPING}. If
 * parameters, output properties, or other features need to be set on the
 * Transformer handler, a {@link javax.xml.transform.Transformer} reference
 * will need to be obtained from
 * {@link javax.xml.transform.sax.TransformerHandler#getTransformer}, and
 * the methods invoked from that reference.
 *
 * <p>
 * The {@link javax.xml.transform.sax.TemplatesHandler} interface
 * allows the creation of {@link javax.xml.transform.Templates} objects
 * from SAX2 parse events. Once the {@link org.xml.sax.ContentHandler}
 * events are complete, the Templates object may be obtained from
 * {@link javax.xml.transform.sax.TemplatesHandler#getTemplates}. Note that
 * {@link javax.xml.transform.sax.TemplatesHandler#setSystemId} should
 * normally be called in order to establish a base system ID from which relative
 * URLs may be resolved.
 * <p>
 * The {@link javax.xml.transform.sax.SAXTransformerFactory#newXMLFilter}
 * method allows the creation of a {@link org.xml.sax.XMLFilter}, which
 * encapsulates the SAX2 notion of a "pull" transformation. The resulting
 * {@code XMLFilters} can be chained together so that a series of transformations
 * can happen with one's output becoming another's input.
 *
 * @since 1.5
 */

package javax.xml.transform.sax;
