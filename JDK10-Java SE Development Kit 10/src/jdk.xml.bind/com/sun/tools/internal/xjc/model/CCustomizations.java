/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.model;

import java.util.ArrayList;
import java.util.Collection;

import com.sun.tools.internal.xjc.Plugin;

/**
 * Represents the list of {@link CPluginCustomization}s attached to a JAXB model component.
 *
 * <p>
 * When {@link Plugin}s register the customization namespace URIs through {@link Plugin#getCustomizationURIs()},
 * XJC will treat those URIs just like XJC's own extension "http://java.sun.com/xml/ns/xjc" and make them
 * available as DOM nodes through {@link CPluginCustomization}. A {@link Plugin} can then access
 * this information to change its behavior.
 *
 * @author Kohsuke Kawaguchi
 */
public final class CCustomizations extends ArrayList<CPluginCustomization> {

    /**
     * All {@link CCustomizations} used by a {@link Model} form a single linked list
     * so that we can look for unacknowledged customizations later.
     *
     * @see CPluginCustomization#markAsAcknowledged()
     * @see #setParent(Model,CCustomizable)
     */
    /*package*/ CCustomizations next;

    /**
     * The owner model component that carries these customizations.
     */
    private CCustomizable owner;

    public CCustomizations() {
    }

    public CCustomizations(Collection<? extends CPluginCustomization> cPluginCustomizations) {
        super(cPluginCustomizations);
    }

    /*package*/ void setParent(Model model,CCustomizable owner) {
        if(this.owner!=null)     return;

//        // loop check
//        for( CCustomizations c = model.customizations; c!=null; c=c.next )
//            assert c!=this;

        this.next = model.customizations;
        model.customizations = this;
        assert owner!=null;
        this.owner = owner;
    }

    /**
     * Gets the model component that carries this customization.
     *
     * @return never null.
     */
    public CCustomizable getOwner() {
        assert owner!=null;
        return owner;
    }

    /**
     * Finds the first {@link CPluginCustomization} that belongs to the given namespace URI.
     * @return null if not found
     */
    public CPluginCustomization find( String nsUri ) {
        for (CPluginCustomization p : this) {
            if(fixNull(p.element.getNamespaceURI()).equals(nsUri))
                return p;
        }
        return null;
    }

    /**
     * Finds the first {@link CPluginCustomization} that belongs to the given namespace URI and the local name.
     * @return null if not found
     */
    public CPluginCustomization find( String nsUri, String localName ) {
        for (CPluginCustomization p : this) {
            if(fixNull(p.element.getNamespaceURI()).equals(nsUri)
            && fixNull(p.element.getLocalName()).equals(localName))
                return p;
        }
        return null;
    }

    private String fixNull(String s) {
        if(s==null) return "";
        else        return s;
    }

    /**
     * Convenient singleton instance that represents an empty {@link CCustomizations}.
     */
    public static final CCustomizations EMPTY = new CCustomizations();

    /**
     * Merges two {@link CCustomizations} objects into one.
     */
    public static CCustomizations merge(CCustomizations lhs, CCustomizations rhs) {
        if(lhs==null || lhs.isEmpty())   return rhs;
        if(rhs==null || rhs.isEmpty())   return lhs;

        CCustomizations r = new CCustomizations(lhs);
        r.addAll(rhs);
        return r;
    }

    public boolean equals(Object o) {
        return this==o;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }
}
