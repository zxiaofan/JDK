/*
 * Copyright (c) 2004, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.soap;

/**
 * A {@code SOAPBodyElement} object represents the contents in
 * a {@code SOAPBody} object.  The {@code SOAPFault} interface
 * is a {@code SOAPBodyElement} object that has been defined.
 * <P>
 * A new {@code SOAPBodyElement} object can be created and added
 * to a {@code SOAPBody} object with the {@code SOAPBody}
 * method {@code addBodyElement}. In the following line of code,
 * {@code sb} is a {@code SOAPBody} object, and
 * {@code myName} is a {@code Name} object.
 * <pre>{@code
 *    SOAPBodyElement sbe = sb.addBodyElement(myName);
 * }</pre>
 *
 * @since 1.6
 */
public interface SOAPBodyElement extends SOAPElement {
}
