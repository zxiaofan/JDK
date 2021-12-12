/*
 * Copyright (c) 2015, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * Provides the interfaces for the Document Object Model (DOM). Supports the
 * <a href="http://www.w3.org/TR/DOM-Level-2-Core/">
 *     Document Object Model (DOM) Level 2 Core Specification</a>,
 * <a href="http://www.w3.org/TR/DOM-Level-3-Core">
 *     Document Object Model (DOM) Level 3 Core Specification</a>,
 * and <a href="http://www.w3.org/TR/DOM-Level-3-LS">
 *     Document Object Model (DOM) Level 3 Load and Save Specification</a>.
 *
 * @apiNote
 * The documentation comments for the get and set methods within this API are
 * written as property definitions and are shared between both methods. These
 * methods do not follow the standard Java SE specification format.
 *
 * <p>
 * Take the {@link org.w3c.dom.Node Node} TextContent property as an example, both
 * {@link org.w3c.dom.Node#getTextContent() getTextContent} and
 * {@link org.w3c.dom.Node#setTextContent(String) setTextContent} shared the same
 * content that defined the TextContent property itself.
 *
 *
 * @since 1.4
 */

package org.w3c.dom;
