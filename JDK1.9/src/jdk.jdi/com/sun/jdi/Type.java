/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi;

/**
 * The mirror for a type in the target VM.
 * This interface is the root of a type hierarchy encompassing primitive
 * types and reference types.
 * <P>
 * A Type may be used to represent a run-time type:
 * <BLOCKQUOTE>
 *   {@link Value}.type()
 * </BLOCKQUOTE>
 * or a compile-time type:
 * <BLOCKQUOTE>
 *  {@link Field#type()} <BR>
 *  {@link Method#returnType()} <BR>
 *  {@link Method#argumentTypes()} <BR>
 *  {@link LocalVariable#type()} <BR>
 *  {@link ArrayType#componentType()}
 * </BLOCKQUOTE>
 * <P>
 * The following table illustrates which subinterfaces of Type
 * are used to mirror types in the target VM --
 * <TABLE BORDER="1">
 * <CAPTION style="display:none">Maps each type declared in target to a mirrored
 *  instance of a subinterface of PrimitiveType or ReferenceType"</CAPTION>
 * <TR style="background-color:#EEEEFF">
 *   <TH id="primtype" colspan=3>Subinterfaces of {@link PrimitiveType}</TH>
 * <TR style="background-color:#EEEEFF">
 *   <TH id="declared" style="text-align:left" colspan=2>Type declared in target as</TH>
 *   <TH id="mirrored" style="text-align:left">Is mirrored as an instance of</TH>
 * <TR>
 *   <TD headers="primtype declared" colspan=2><CODE>boolean</CODE></TD>
 *   <TD headers="primtype mirrored"> {@link BooleanType}</TD>
 * <TR>
 *   <TD headers="primtype declared" colspan=2><CODE>byte</CODE></TD>
 *   <TD headers="primtype mirrored">{@link ByteType}</TD>
 * <TR>
 *   <TD headers="primtype declared" colspan=2><CODE>char</CODE></TD>
 *   <TD headers="primtype mirrored">{@link CharType}</TD>
 * <TR>
 *   <TD headers="primtype declared" colspan=2><CODE>double</CODE></TD>
 *   <TD headers="primtype mirrored">{@link DoubleType}</TD>
 * <TR>
 *   <TD headers="primtype declared" colspan=2><CODE>float</CODE></TD>
 *   <TD headers="primtype mirrored">{@link FloatType}</TD>
 * <TR>
 *   <TD headers="primtype declared" colspan=2><CODE>int</CODE></TD>
 *   <TD headers="primtype mirrored">{@link IntegerType}</TD>
 * <TR>
 *   <TD headers="primtype declared" colspan=2><CODE>long</CODE></TD>
 *   <TD headers="primtype mirrored">{@link LongType}</TD>
 * <TR>
 *   <TD headers="primtype declared" colspan=2><CODE>short</CODE></TD>
 *   <TD headers="primtype mirrored">{@link ShortType}</TD>
 * <TR>
 *   <TD headers="primtype declared" colspan=2><CODE>void</CODE></TD>
 *   <TD headers="primtype mirrored">{@link VoidType}</TD>
 * <TR style="background-color:#EEEEFF">
 *   <TH id="reftype"  colspan=3>Subinterfaces of {@link ReferenceType}</TH>
 * <TR style="background-color:#EEEEFF">
 *   <TH id="declared2"style="text-align:left">Type declared in target as</TH>
 *   <TH id="example2"  style="text-align:left">For example</TH>
 *   <TH id="mirrored2" style="text-align:left">Is mirrored as an instance of</TH>
 * <TR>
 *   <TD headers="reftype declared2"><I>a class</I></TD>
 *   <TD headers="reftype example2"><CODE>Date</CODE></TD>
 *   <TD headers="reftype mirrored2">{@link ClassType}</TD>
 * <TR>
 *   <TD headers="reftype declared2"><I>an interface</I></TD>
 *   <TD headers="reftype example2"><CODE>Runnable</CODE></TD>
 *   <TD headers="reftype mirrored2">{@link InterfaceType}</TD>
 * <TR>
 *   <TD headers="reftype declared2"><I>an array</I></TD>
 *   <TD headers="reftype example2">&nbsp;</TD>
 *   <TD headers="reftype mirrored2">{@link ArrayType}</TD>
 * <TR>
 *   <TD headers="reftype declared2"><I>an array</I></TD>
 *   <TD headers="reftype example2"><CODE>int[]</CODE></TD>
 *   <TD headers="reftype mirrored2">{@link ArrayType} whose
 *         {@link ArrayType#componentType() componentType()} is
 *         {@link IntegerType}</TD>
 * <TR>
 *   <TD headers="reftype declared2"><I>an array</I></TD>
 *   <TD headers="reftype example2"><CODE>Date[]</CODE></TD>
 *   <TD headers="reftype mirrored2">{@link ArrayType} whose
 *         {@link ArrayType#componentType() componentType()} is
 *         {@link ClassType}</TD>
 * <TR>
 *   <TD headers="reftype declared2"><I>an array</I></TD>
 *   <TD headers="reftype example2"><CODE>Runnable[]</CODE></TD>
 *   <TD headers="reftype mirrored2">{@link ArrayType} whose
 *         {@link ArrayType#componentType() componentType()} is
 *         {@link InterfaceType}</TD>
 * </TABLE>
 *
 * @see PrimitiveType Subinterface PrimitiveType
 * @see ReferenceType Subinterface ReferenceType
 * @see Value Value - for relationship between Type and Value
 * @see Field#type() Field.type() - for usage examples
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */
public interface Type extends Mirror {

    /**
     * Returns the JNI-style signature for this type.
     * <p>
     * For primitive classes
     * the returned signature is the signature of the corresponding primitive
     * type; for example, "I" is returned as the signature of the class
     * represented by {@link java.lang.Integer#TYPE}.
     *
     * @see <a href="doc-files/signature.html">Type Signatures</a>
     * @return the string containing the type signature.
     */
    String signature();

    /**
     * @return a text representation of this type.
     */
    String name();
}
