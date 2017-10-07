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

package com.sun.xml.internal.bind.v2.model.core;

import java.util.Map;

import javax.xml.namespace.QName;

/**
 * Property that maps to the following schema fragment.
 *
 * <pre>{@code
 * <xs:complexType>
 *   <xs:sequence>
 *     <xs:element name="entry" minOccurs="0" maxOccurs="unbounded">
 *       <xs:complexType>
 *         <xs:sequence>
 *           <xs:element name="key"   type="XXXX"/>
 *           <xs:element name="value" type="YYYY"/>
 *         </xs:sequence>
 *       </xs:complexType>
 *     </xs:element>
 *   </xs:sequence>
 * </xs:complexType>
 * }</pre>
 *
 * <p>
 * This property is used to represent a default binding of a {@link Map} property.
 * ({@link Map} properties with adapters will be represented by {@link ElementPropertyInfo}.)
 *
 *
 * <h2>Design Thinking Led to This</h2>
 * <p>
 * I didn't like the idea of adding such a special-purpose {@link PropertyInfo} to a model.
 * The alternative was to implicitly assume an adapter, and have internal representation of
 * the Entry class ready.
 * But the fact that the key type and the value type changes with the parameterization makes
 * it very difficult to have such a class (especially inside Annotation Processing, where we can't even generate
 * classes.)
 *
 * @author Kohsuke Kawaguchi
 */
public interface MapPropertyInfo<T,C> extends PropertyInfo<T,C> {
    /**
     * Gets the wrapper element name.
     *
     * @return
     *      always non-null.
     */
    QName getXmlName();

    /**
     * Returns true if this property is nillable
     * (meaning the absence of the value is treated as nil='true')
     *
     * <p>
     * This method is only used when this property is a collection.
     */
    boolean isCollectionNillable();

    /**
     * Type of the key of the map. K of {@code HashMap<K,V>}
     *
     * @return never null.
     */
    NonElement<T,C> getKeyType();

    /**
     * Type of the value of the map. V of {@code HashMap<K,V>}
     *
     * @return never null.
     */
    NonElement<T,C> getValueType();

    // TODO
    // Adapter<T,C> getKeyAdapter();
    // Adapter<T,C> getValueAdapter();
}
