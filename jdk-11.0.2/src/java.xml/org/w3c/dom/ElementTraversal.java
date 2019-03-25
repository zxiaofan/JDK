/*
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
/*
 * Copyright (c) 2015 World Wide Web Consortium,
 *
 * (Massachusetts Institute of Technology, European Research Consortium for
 * Informatics and Mathematics, Keio University, Beihang). All Rights Reserved.
 * This work is distributed under the W3C(r) Software License [1] in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * [1] http://www.w3.org/Consortium/Legal/copyright-software
 */

package org.w3c.dom;

/**
 * The {@code ElementTraversal} interface is a set of read-only attributes
 * which allow an author to easily navigate between elements in a document.
 * <p>
 * In conforming implementations of Element Traversal, all objects that
 * implement {@link Element} must also implement the {@code ElementTraversal}
 * interface. Four of the methods,
 * {@link #getFirstElementChild}, {@link #getLastElementChild},
 * {@link #getPreviousElementSibling}, and {@link #getNextElementSibling},
 * each provides a live reference to another element with the defined
 * relationship to the current element, if the related element exists. The
 * fifth method, {@link #getChildElementCount}, exposes the number of child
 * elements of an element, for preprocessing before navigation.
 *
 * @see
 * <a href='http://www.w3.org/TR/ElementTraversal/'><cite>Element Traversal Specification</cite></a>
 *
 * @since 9
 */
public interface ElementTraversal {

    /**
     * Returns a reference to the first child node of the element which is of
     * the {@link Element} type.
     *
     * @return a reference to an element child, {@code null} if the element has
     * no child of the {@link Element} type.
     */
    Element getFirstElementChild();

    /**
     * Returns a reference to the last child node of the element which is of
     * the {@link Element} type.
     *
     * @return a reference to an element child, {@code null} if the element has
     * no child of the {@link Element} type.
     */
    Element getLastElementChild();

    /**
     * Returns a reference to the sibling node of the element which most immediately
     * precedes the element in document order, and which is of the {@link Element} type.
     *
     * @return a reference to an element child, {@code null} if the element has
     * no sibling node of the {@link Element} type that comes before this one.
     */
    Element getPreviousElementSibling();

    /**
     * Returns a reference to the sibling node of the element which most immediately
     * follows the element in document order, and which is of the {@link Element} type.
     *
     * @return a reference to an element child, {@code null} if the element has
     * no sibling node of the {@link Element} type that comes after this one.
     */
    Element getNextElementSibling();

    /**
     * Returns the current number of child nodes of the element which are of
     * the {@link Element} type.
     *
     * @return the number of element children, or {@code 0} if the element has
     * no element children.
     */
    int getChildElementCount();
}
