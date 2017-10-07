/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.xmlschema.bindinfo;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

import com.sun.tools.internal.xjc.reader.Const;
import com.sun.tools.internal.xjc.reader.xmlschema.SimpleTypeBuilder;

/**
 * Enumeration customization.
 * <p>
 * This customization binds a simple type to a type-safe enum class.
 * The actual binding process takes place in {@link SimpleTypeBuilder}.
 *
 * <p>
 * This customization is acknowledged by {@link SimpleTypeBuilder}.
 *
 * @author
 *  Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
@XmlRootElement(name="typesafeEnumClass")
public final class BIEnum extends AbstractDeclarationImpl {

    /**
     * If false, it means not to bind to a type-safe enum.
     *
     * this takes precedence over all the other properties of this class.
     */
    @XmlAttribute(name="map")
    private boolean map = true;

    /** Gets the specified class name, or null if not specified. */
    @XmlAttribute(name="name")
    public String className = null;

    /**
     * @see BIClass#getExistingClassRef()
     */
    @XmlAttribute(name="ref")
    public String ref;

    /**
     * Gets the javadoc comment specified in the customization.
     * Can be null if none is specified.
     */
    @XmlElement
    public final String javadoc = null;

    public boolean isMapped() {
        return map;
    }

    /**
     * Gets the map that contains {@code XML value -> BIEnumMember} pairs.
     * This table is built from {@code <enumMember>} customizations.
     *
     * Always return non-null.
     */
    @XmlTransient
    public final Map<String,BIEnumMember> members = new HashMap<String,BIEnumMember>();

    public QName getName() { return NAME; }

    public void setParent(BindInfo p) {
        super.setParent(p);
        for( BIEnumMember mem : members.values() )
            mem.setParent(p);

        // if this specifies a reference to external class,
        // then it's OK even if noone actually refers this class.
        if(ref!=null)
            markAsAcknowledged();
    }

    /** Name of this declaration. */
    public static final QName NAME = new QName(
        Const.JAXB_NSURI, "enum" );

    // setter method for JAXB runtime
    @XmlElement(name="typesafeEnumMember")
    private void setMembers(BIEnumMember2[] mems) {
        for (BIEnumMember2 e : mems)
            members.put(e.value,e);
    }



    /**
     * {@link BIEnumMember} used inside {@link BIEnum} has additional 'value' attribute.
     */
    static class BIEnumMember2 extends BIEnumMember {
        /**
         * The lexical representaion of the constant to which we are attaching.
         */
        @XmlAttribute(required=true)
        String value;
    }
}
