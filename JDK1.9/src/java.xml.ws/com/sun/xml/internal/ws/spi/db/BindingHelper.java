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

package com.sun.xml.internal.ws.spi.db;

import java.lang.reflect.Type;

//TODO SOAPVersion WebServiceFeatureList
import com.sun.xml.internal.bind.util.Which;

//TODO Packet AbstractMessageImpl
import com.sun.xml.internal.bind.marshaller.SAX2DOMEx;

//TODO DOMHeader DOMMessage SAAJMessage StatefulInstanceResolver
import com.sun.xml.internal.bind.unmarshaller.DOMScanner;

//TODO ExceptionBean
import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

//TODO AbstractWrapperBeanGenerator
import com.sun.xml.internal.bind.v2.model.annotation.AnnotationReader;
import com.sun.xml.internal.bind.v2.model.annotation.RuntimeInlineAnnotationReader;
import com.sun.xml.internal.bind.v2.model.nav.Navigator;

//TODO WSDLGenerator
import static com.sun.xml.internal.bind.v2.schemagen.Util.*;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import com.sun.xml.internal.bind.v2.model.nav.Navigator;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
/**
 * BindingHelper
 *
 * @author shih-chang.chen@oracle.com
 */
public class BindingHelper {
    /**
     * Computes a Java identifier from a local name.
     *
     * <p>
     * This method faithfully implements the name mangling rule as specified in the JAXB spec.
     *
     * <p>
     * In JAXB, a collision with a Java reserved word (such as "return") never happens.
     * Accordingly, this method may return an identifier that collides with reserved words.
     *
     * <p>
     * Use {@code JJavaName.isJavaIdentifier(String)} to check for such collision.
     *
     * @return
     *      Typically, this method returns "nameLikeThis".
     */
    public static @NotNull String mangleNameToVariableName(@NotNull String localName) {
        return NameConverter.standard.toVariableName(localName);
    }

    /**
     * Computes a Java class name from a local name.
     *
     * <p>
     * This method faithfully implements the name mangling rule as specified in the JAXB spec.
     *
     * @return
     *      Typically, this method returns "NameLikeThis".
     */
    public static @NotNull String mangleNameToClassName(@NotNull String localName) {
        return NameConverter.standard.toClassName(localName);
    }

    /**
     * Computes a Java class name from a local name.
     *
     * <p>
     * This method faithfully implements the name mangling rule as specified in the JAXB spec.
     * This method works like {@link #mangleNameToClassName(String)} except that it looks
     * for "getClass" and returns something else.
     *
     * @return
     *      Typically, this method returns "NameLikeThis".
     */
    public static @NotNull String mangleNameToPropertyName(@NotNull String localName) {
        return NameConverter.standard.toPropertyName(localName);
    }

    /**
     * Gets the parameterization of the given base type.
     *
     * <p>
     * For example, given the following
     * <pre>{@code
     * interface Foo<T> extends List<List<T>> {}
     * interface Bar extends Foo<String> {}
     * }</pre>
     * This method works like this:
     * <pre>{@code
     * getBaseClass( Bar, List ) = List<List<String>
     * getBaseClass( Bar, Foo  ) = Foo<String>
     * getBaseClass( Foo<? extends Number>, Collection ) = Collection<List<? extends Number>>
     * getBaseClass( ArrayList<? extends BigInteger>, List ) = List<? extends BigInteger>
     * }</pre>
     *
     * @param type
     *      The type that derives from {@code baseType}
     * @param baseType
     *      The class whose parameterization we are interested in.
     * @return
     *      The use of {@code baseType} in {@code type}.
     *      or null if the type is not assignable to the base type.
     * @since 2.0 FCS
     */
    public static @Nullable Type getBaseType(@NotNull Type type, @NotNull Class baseType) {
        return Utils.REFLECTION_NAVIGATOR.getBaseClass(type,baseType);
    }

    public static <T> Class<T> erasure(Type t) {
        return (Class<T>) Utils.REFLECTION_NAVIGATOR.erasure(t);
    }
}
