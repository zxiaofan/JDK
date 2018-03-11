/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang;

/**
 * The Boolean class wraps a value of the primitive type 
 * <code>boolean</code> in an object. An object of type 
 * <code>Boolean</code> contains a single field whose type is 
 * <code>boolean</code>. 
 * <p>
 * In addition, this class provides many methods for 
 * converting a <code>boolean</code> to a <code>String</code> and a 
 * <code>String</code> to a <code>boolean</code>, as well as other 
 * constants and methods useful when dealing with a 
 * <code>boolean</code>. 
 *
 * @author  Arthur van Hoff
 * @version %I%, %G%
 * @since   JDK1.0
 */
public final class Boolean implements java.io.Serializable,
                                      Comparable<Boolean>
{
    /** 
     * The <code>Boolean</code> object corresponding to the primitive 
     * value <code>true</code>. 
     */
    public static final Boolean TRUE = new Boolean(true);

    /** 
     * The <code>Boolean</code> object corresponding to the primitive 
     * value <code>false</code>. 
     */
    public static final Boolean FALSE = new Boolean(false);

    /**
     * The Class object representing the primitive type boolean.
     *
     * @since   JDK1.1
     */
    public static final Class<Boolean> TYPE = Class.getPrimitiveClass("boolean");

    /**
     * The value of the Boolean.
     *
     * @serial
     */
    private final boolean value;

    /** use serialVersionUID from JDK 1.0.2 for interoperability */
    private static final long serialVersionUID = -3665804199014368530L;

    /**
     * Allocates a <code>Boolean</code> object representing the 
     * <code>value</code> argument. 
     *
     * <p><b>Note: It is rarely appropriate to use this constructor.
     * Unless a <i>new</i> instance is required, the static factory
     * {@link #valueOf(boolean)} is generally a better choice. It is
     * likely to yield significantly better space and time performance.</b>
     * 
     * @param   value   the value of the <code>Boolean</code>.
     */
    public Boolean(boolean value) {
	this.value = value;
    }

    /**
     * Allocates a <code>Boolean</code> object representing the value 
     * <code>true</code> if the string argument is not <code>null</code> 
     * and is equal, ignoring case, to the string {@code "true"}. 
     * Otherwise, allocate a <code>Boolean</code> object representing the 
     * value <code>false</code>. Examples:<p>
     * {@code new Boolean("True")} produces a <tt>Boolean</tt> object 
     * that represents <tt>true</tt>.<br>
     * {@code new Boolean("yes")} produces a <tt>Boolean</tt> object 
     * that represents <tt>false</tt>.
     *
     * @param   s   the string to be converted to a <code>Boolean</code>.
     */
    public Boolean(String s) {
	this(toBoolean(s));
    }

    /**
     * Parses the string argument as a boolean.  The <code>boolean</code> 
     * returned represents the value <code>true</code> if the string argument 
     * is not <code>null</code> and is equal, ignoring case, to the string 
     * {@code "true"}. <p>
     * Example: {@code Boolean.parseBoolean("True")} returns <tt>true</tt>.<br>
     * Example: {@code Boolean.parseBoolean("yes")} returns <tt>false</tt>.
     *
     * @param      s   the <code>String</code> containing the boolean
     *                 representation to be parsed
     * @return     the boolean represented by the string argument
     * @since 1.5
     */
    public static boolean parseBoolean(String s) {
        return toBoolean(s);
    }

    /**
     * Returns the value of this <tt>Boolean</tt> object as a boolean 
     * primitive.
     *
     * @return  the primitive <code>boolean</code> value of this object.
     */
    public boolean booleanValue() {
	return value;
    }

    /**
     * Returns a <tt>Boolean</tt> instance representing the specified
     * <tt>boolean</tt> value.  If the specified <tt>boolean</tt> value
     * is <tt>true</tt>, this method returns <tt>Boolean.TRUE</tt>;
     * if it is <tt>false</tt>, this method returns <tt>Boolean.FALSE</tt>.
     * If a new <tt>Boolean</tt> instance is not required, this method
     * should generally be used in preference to the constructor
     * {@link #Boolean(boolean)}, as this method is likely to yield
     * significantly better space and time performance.
     *
     * @param  b a boolean value.
     * @return a <tt>Boolean</tt> instance representing <tt>b</tt>.
     * @since  1.4
     */
    public static Boolean valueOf(boolean b) {
        return (b ? TRUE : FALSE);
    }

    /**
     * Returns a <code>Boolean</code> with a value represented by the
     * specified string.  The <code>Boolean</code> returned represents a
     * true value if the string argument is not <code>null</code>
     * and is equal, ignoring case, to the string {@code "true"}.
     *
     * @param   s   a string.
     * @return  the <code>Boolean</code> value represented by the string.
     */
    public static Boolean valueOf(String s) {
	return toBoolean(s) ? TRUE : FALSE;
    }

    /**
     * Returns a <tt>String</tt> object representing the specified
     * boolean.  If the specified boolean is <code>true</code>, then
     * the string {@code "true"} will be returned, otherwise the
     * string {@code "false"} will be returned.
     *
     * @param b	the boolean to be converted
     * @return the string representation of the specified <code>boolean</code>
     * @since 1.4
     */
    public static String toString(boolean b) {
        return b ? "true" : "false";
    }

    /**
     * Returns a <tt>String</tt> object representing this Boolean's
     * value.  If this object represents the value <code>true</code>,
     * a string equal to {@code "true"} is returned. Otherwise, a
     * string equal to {@code "false"} is returned.
     *
     * @return  a string representation of this object. 
     */
    public String toString() {
	return value ? "true" : "false";
    }

    /**
     * Returns a hash code for this <tt>Boolean</tt> object.
     *
     * @return  the integer <tt>1231</tt> if this object represents 
     * <tt>true</tt>; returns the integer <tt>1237</tt> if this 
     * object represents <tt>false</tt>. 
     */
    public int hashCode() {
	return value ? 1231 : 1237;
    }

    /**
     * Returns <code>true</code> if and only if the argument is not 
     * <code>null</code> and is a <code>Boolean</code> object that 
     * represents the same <code>boolean</code> value as this object. 
     *
     * @param   obj   the object to compare with.
     * @return  <code>true</code> if the Boolean objects represent the 
     *          same value; <code>false</code> otherwise.
     */
    public boolean equals(Object obj) {
	if (obj instanceof Boolean) {
	    return value == ((Boolean)obj).booleanValue();
	} 
	return false;
    }

    /**
     * Returns <code>true</code> if and only if the system property 
     * named by the argument exists and is equal to the string 
     * {@code "true"}. (Beginning with version 1.0.2 of the 
     * Java<small><sup>TM</sup></small> platform, the test of 
     * this string is case insensitive.) A system property is accessible 
     * through <code>getProperty</code>, a method defined by the 
     * <code>System</code> class.
     * <p>
     * If there is no property with the specified name, or if the specified
     * name is empty or null, then <code>false</code> is returned.
     *
     * @param   name   the system property name.
     * @return  the <code>boolean</code> value of the system property.
     * @see     java.lang.System#getProperty(java.lang.String)
     * @see     java.lang.System#getProperty(java.lang.String, java.lang.String)
     */
    public static boolean getBoolean(String name) {
        boolean result = false;
        try {
            result = toBoolean(System.getProperty(name));
        } catch (IllegalArgumentException e) {
        } catch (NullPointerException e) {
        }
        return result;
    }

    /**
     * Compares this <tt>Boolean</tt> instance with another.
     *
     * @param   b the <tt>Boolean</tt> instance to be compared
     * @return  zero if this object represents the same boolean value as the
     *          argument; a positive value if this object represents true
     *          and the argument represents false; and a negative value if
     *          this object represents false and the argument represents true
     * @throws  NullPointerException if the argument is <tt>null</tt>
     * @see     Comparable
     * @since  1.5
     */
    public int compareTo(Boolean b) {
        return (b.value == value ? 0 : (value ? 1 : -1));
    }

    private static boolean toBoolean(String name) { 
	return ((name != null) && name.equalsIgnoreCase("true"));
    }
}
