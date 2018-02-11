/*
 * Copyright (c) 2001, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.internal.toolkit.taglets;

import com.sun.javadoc.Tag;
import com.sun.tools.doclets.internal.toolkit.Content;

/**
 * An abstract class that implements the {@link Taglet} interface and
 * serves as a base for JavaFX property getter and setter taglets.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 */
@Deprecated
public abstract class BasePropertyTaglet extends BaseTaglet {

    public BasePropertyTaglet() {
    }

    /**
     * This method returns the text to be put in the resulting javadoc before
     * the property name.
     *
     * @param tagletWriter the taglet writer for output
     * @return the string to be put in the resulting javadoc.
     */
    abstract String getText(TagletWriter tagletWriter);

    /**
     * Given the <code>Tag</code> representation of this custom
     * tag, return its string representation, which is output
     * to the generated page.
     * @param tag the <code>Tag</code> representation of this custom tag.
     * @param tagletWriter the taglet writer for output.
     * @return the TagletOutput representation of this <code>Tag</code>.
     */
    public Content getTagletOutput(Tag tag, TagletWriter tagletWriter) {
        return tagletWriter.propertyTagOutput(tag, getText(tagletWriter));
    }

    /**
     * Will return false because this tag may
     * only appear in Methods.
     * @return false since this is not a method.
     */
    public boolean inConstructor() {
        return false;
    }

    /**
     * Will return false because this tag may
     * only appear in Methods.
     * @return false since this is not a method.
     */
    public boolean inOverview() {
        return false;
    }

    /**
     * Will return false because this tag may
     * only appear in Methods.
     * @return false since this is not a method.
     */
    public boolean inPackage() {
        return false;
    }

    /**
     * Will return false because this tag may
     * only appear in Methods.
     * @return false since this is not a method.
     */
    public boolean inType() {
        return false;
    }

    /**
     * Will return false because this tag is not inline.
     * @return false since this is not an inline tag.
     */
    public boolean isInlineTag() {
        return false;
    }

}
