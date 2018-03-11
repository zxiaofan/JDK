/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang;

/**
 * Thrown when an application tries to access an enum constant by name
 * and the enum type contains no constant with the specified name.
 *
 * @author  Josh Bloch
 * @since   1.5
 */
public class EnumConstantNotPresentException extends RuntimeException {
    /**
     * The type of the missing enum constant.
     */
    private Class<? extends Enum> enumType;

    /**
     * The name of the missing enum constant.
     */
    private String constantName;

    /**
     * Constructs an <tt>EnumConstantNotPresentException</tt> for the 
     * specified constant.
     *
     * @param enumType the type of the missing enum constant
     * @param constantName the name of the missing enum constant
     */
    public EnumConstantNotPresentException(Class<? extends Enum> enumType,
                                           String constantName) {
        super(enumType.getName() + "." + constantName);
	this.enumType = enumType;
	this.constantName  = constantName;
    }

    /**
     * Returns the type of the missing enum constant.
     *
     * @return the type of the missing enum constant
     */
    public Class<? extends Enum> enumType() { return enumType; }

    /**
     * Returns the name of the missing enum constant.
     *
     * @return the name of the missing enum constant
     */
    public String constantName() { return constantName; }
}
