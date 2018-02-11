/*
 * Copyright (c) 1998, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.text.html.parser;

import javax.swing.text.html.HTML;
/**
 * A generic HTML TagElement class. The methods define how white
 * space is interpreted around the tag.
 *
 * @author      Sunita Mani
 */

public class TagElement {

    Element elem;
    HTML.Tag htmlTag;
    boolean insertedByErrorRecovery;

    /**
     * Creates a generic HTML TagElement class with {@code fictional} equals to {@code false}.
     *
     * @param elem an element
     */
    public TagElement(Element elem) {
        this(elem, false);
    }

    /**
     * Creates a generic HTML TagElement class.
     *
     * @param elem an element
     * @param fictional if {@code true} the tag is inserted by error recovery.
     */
    public TagElement (Element elem, boolean fictional) {
        this.elem = elem;
        htmlTag = HTML.getTag(elem.getName());
        if (htmlTag == null) {
            htmlTag = new HTML.UnknownTag(elem.getName());
        }
        insertedByErrorRecovery = fictional;
    }

    /**
     * Returns {@code true} if this tag causes a
     * line break to the flow of data, otherwise returns
     * {@code false}.
     *
     * @return {@code true} if this tag causes a
     *   line break to the flow of data, otherwise returns
     *   {@code false}
     */
    public boolean breaksFlow() {
        return htmlTag.breaksFlow();
    }

    /**
     * Returns {@code true} if this tag is pre-formatted.
     *
     * @return {@code true} if this tag is pre-formatted,
     *   otherwise returns {@code false}
     */
    public boolean isPreformatted() {
        return htmlTag.isPreformatted();
    }

    /**
     * Returns the element.
     *
     * @return the element
     */
    public Element getElement() {
        return elem;
    }

    /**
     * Returns the tag constant corresponding to the name of the {@code element}
     *
     * @return the tag constant corresponding to the name of the {@code element}
     */
    public HTML.Tag getHTMLTag() {
        return htmlTag;
    }

    /**
     * Returns {@code true} if the tag is fictional.
     *
     * @return {@code true} if the tag is fictional.
     */
    public boolean fictional() {
        return insertedByErrorRecovery;
    }
}
