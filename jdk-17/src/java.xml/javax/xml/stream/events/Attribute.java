/*
 * Copyright (c) 2009, 2020, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.stream.events;

import javax.xml.namespace.QName;

/**
 * An interface that contains information about an attribute.  Attributes are reported
 * as a set of events accessible from a StartElement.  Other applications may report
 * Attributes as first-order events, for example as the results of an XPath expression.
 *
 * @version 1.0
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @see StartElement
 * @since 1.6
 */
public interface Attribute extends XMLEvent {

  /**
   * Returns the QName for this attribute.
   * @return the QName of the attribute
   */
  QName getName();

  /**
   * Gets the normalized value of this attribute.
   * @return the normalized value of the attribute
   */
  public String getValue();

  /**
   * Gets the type of this attribute, default is
   * the String "CDATA".
   * @return the type as a String, default is "CDATA"
   */
  public String getDTDType();

  /**
   * A flag indicating whether this attribute was actually
   * specified in the start-tag of its element, or was defaulted from the schema.
   * @return returns true if this was specified in the start element
   */
  public boolean isSpecified();

}
