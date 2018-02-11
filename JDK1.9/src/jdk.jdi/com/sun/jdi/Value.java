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
 * The mirror for a value in the target VM.
 * This interface is the root of a
 * value hierarchy encompassing primitive values and object values.
 * <P>
 * Some examples of where values may be accessed:
 * <BLOCKQUOTE><TABLE><CAPTION style="display:none">layout</CAPTION>
 * <TR>
 *   <TD>{@link ObjectReference#getValue(com.sun.jdi.Field)
 *                 ObjectReference.getValue(Field)}
 *   <TD>- value of a field
 * <TR>
 *   <TD>{@link StackFrame#getValue(com.sun.jdi.LocalVariable)
 *                 StackFrame.getValue(LocalVariable)}
 *   <TD>- value of a variable
 * <TR>
 *   <TD>{@link VirtualMachine#mirrorOf(double)
 *                 VirtualMachine.mirrorOf(double)}
 *   <TD>- created in the target VM by the JDI client
 * <TR>
 *   <TD>{@link com.sun.jdi.event.ModificationWatchpointEvent#valueToBe()
 *                 ModificationWatchpointEvent.valueToBe()}
 *   <TD>- returned with an event
 * </TABLE></BLOCKQUOTE>
 * <P>
 * The following table illustrates which subinterfaces of Value
 * are used to mirror values in the target VM --
 * <TABLE BORDER="1">
 * <CAPTION style="display:none">Maps each kind of value to a mirrored
 *  instance of a subinterface of Value</CAPTION>
 * <TR style="background-color:#EEEEFF">
 *   <TH id="primval" colspan=4>Subinterfaces of {@link PrimitiveValue}</TH>
 * <TR style="background-color:#EEEEFF">
 *   <TH id="kind"     style="text-align:left">Kind of value</TH>
 *   <TH id="example"  style="text-align:left">For example -<br>expression in target</TH>
 *   <TH id="mirrored" style="text-align:left">Is mirrored as an<br>instance of</TH>
 *   <TH id="type"     style="text-align:left">{@link Type} of value<br>{@link #type() Value.type()}</TH>
 * <TR>
 *   <TD headers="primval kind">     a boolean</TD>
 *   <TD headers="primval example">  {@code true}</TD>
 *   <TD headers="primval mirrored"> {@link BooleanValue}</TD>
 *   <TD headers="primval type">     {@link BooleanType}</TD>
 * <TR>
 *   <TD headers="primval kind">     a byte</TD>
 *   <TD headers="primval example">  {@code (byte)4}</TD>
 *   <TD headers="primval mirrored"> {@link ByteValue}</TD>
 *   <TD headers="primval type">     {@link ByteType}</TD>
 * <TR>
 *   <TD headers="primval kind">     a char</TD>
 *   <TD headers="primval example">  {@code 'a'}</TD>
 *   <TD headers="primval mirrored"> {@link CharValue}</TD>
 *   <TD headers="primval type">     {@link CharType}</TD>
 * <TR>
 *   <TD headers="primval kind">     a double</TD>
 *   <TD headers="primval example">  {@code 3.1415926}</TD>
 *   <TD headers="primval mirrored"> {@link DoubleValue}</TD>
 *   <TD headers="primval type">     {@link DoubleType}</TD>
 * <TR>
 *   <TD headers="primval kind">     a float</TD>
 *   <TD headers="primval example">  {@code 2.5f}</TD>
 *   <TD headers="primval mirrored"> {@link FloatValue}</TD>
 *   <TD headers="primval type">     {@link FloatType}</TD>
 * <TR>
 *   <TD headers="primval kind">     an int</TD>
 *   <TD headers="primval example">  {@code 22}</TD>
 *   <TD headers="primval mirrored"> {@link IntegerValue}</TD>
 *   <TD headers="primval type">     {@link IntegerType}</TD>
 * <TR>
 *   <TD headers="primval kind">     a long</TD>
 *   <TD headers="primval example">  {@code 1024L}</TD>
 *   <TD headers="primval mirrored"> {@link LongValue}</TD>
 *   <TD headers="primval type">     {@link LongType}</TD>
 * <TR>
 *   <TD headers="primval kind">     a short</TD>
 *   <TD headers="primval example">  {@code (short)12}</TD>
 *   <TD headers="primval mirrored"> {@link ShortValue}</TD>
 *   <TD headers="primval type">     {@link ShortType}</TD>
 * <TR>
 *   <TD headers="primval kind">     a void</TD>
 *   <TD headers="primval example">  </TD>
 *   <TD headers="primval mirrored"> {@link VoidValue}</TD>
 *   <TD headers="primval type">     {@link VoidType}</TD>
 * <TR style="background-color:#EEEEFF">
 *   <TH id="objref" colspan=4>Subinterfaces of {@link ObjectReference}</TH>
 * <TR style="background-color:#EEEEFF">
 *   <TH id="kind2"     style="text-align:left">Kind of value</TH>
 *   <TH id="example2"  style="text-align:left">For example -<br>expression in target</TH>
 *   <TH id="mirrored2" style="text-align:left">Is mirrored as an<br>instance of</TH>
 *   <TH id="type2"     style="text-align:left">{@link Type} of value<br>{@link #type() Value.type()}</TH>
 * <TR>
 *   <TD headers="objref kind2">     a class instance</TD>
 *   <TD headers="objref example2">  {@code this}</TD>
 *   <TD headers="objref mirrored2"> {@link ObjectReference}</TD>
 *   <TD headers="objref type2">     {@link ClassType}</TD>
 * <TR>
 *   <TD headers="objref kind2">     an array</TD>
 *   <TD headers="objref example2">  {@code new int[5]}</TD>
 *   <TD headers="objref mirrored2"> {@link ArrayReference}</TD>
 *   <TD headers="objref type2">     {@link ArrayType}</TD>
 * <TR>
 *   <TD headers="objref kind2">     a string</TD>
 *   <TD headers="objref example2">  {@code "hello"}</TD>
 *   <TD headers="objref mirrored2"> {@link StringReference}</TD>
 *   <TD headers="objref type2">     {@link ClassType}</TD>
 * <TR>
 *   <TD headers="objref kind2">     a thread</TD>
 *   <TD headers="objref example2">  {@code Thread.currentThread()}</TD>
 *   <TD headers="objref mirrored2"> {@link ThreadReference}</TD>
 *   <TD headers="objref type2">     {@link ClassType}</TD>
 * <TR>
 *   <TD headers="objref kind2">     a thread group</TD>
 *   <TD headers="objref example2">  {@code Thread.currentThread()}<br>&nbsp;&nbsp;{@code .getThreadGroup()}</TD>
 *   <TD headers="objref mirrored2"> {@link ThreadGroupReference}</TD>
 *   <TD headers="objref type2">     {@link ClassType}</TD>
 * <TR>
 *   <TD headers="objref kind2">     a {@code java.lang.Class}<br>instance</TD>
 *   <TD headers="objref example2">  {@code this.getClass()}</TD>
 *   <TD headers="objref mirrored2"> {@link ClassObjectReference}</TD>
 *   <TD headers="objref type2">     {@link ClassType}</TD>
 * <TR>
 *   <TD headers="objref kind2">     a class loader</TD>
 *   <TD headers="objref example2">  {@code this.getClass()}<br>&nbsp;&nbsp;{@code .getClassLoader()}</TD>
 *   <TD headers="objref mirrored2"> {@link ClassLoaderReference}</TD>
 *   <TD headers="objref type2">     {@link ClassType}</TD>
 * <TR style="background-color:#EEEEFF">
 *   <TH id="other" colspan=4>Other</TH>
 * <TR style="background-color:#EEEEFF">
 *   <TD id="kind3"     style="text-align:left">Kind of value</TD>
 *   <TD id="example3"  style="text-align:left">For example -<br>expression in target</TD>
 *   <TD id="mirrored3" style="text-align:left">Is mirrored as</TD>
 *   <TD id="type3"     style="text-align:left">{@link Type} of value</TD>
 * <TR>
 *   <TD headers="other kind3">     null</TD>
 *   <TD headers="other example3">  {@code null}</TD>
 *   <TD headers="other mirrored3"> {@code null}</TD>
 *   <TD headers="other type3">     n/a</TD>
 * </TABLE>
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */

public interface Value extends Mirror {
    /**
     * Returns the run-time type of this value.
     *
     * @see Type
     * @return a {@link Type} which mirrors the value's type in the
     * target VM.
     */
    Type type();
}
