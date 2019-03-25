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
 * Defines the subset of the W3C Document Object Model (DOM) API that is not part
 * of the Java SE API.
 *
 * @moduleGraph
 * @since 9
 */
module jdk.xml.dom {
    requires transitive java.xml;

    exports org.w3c.dom.css;
    exports org.w3c.dom.html;
    exports org.w3c.dom.stylesheets;
    exports org.w3c.dom.xpath;
}
