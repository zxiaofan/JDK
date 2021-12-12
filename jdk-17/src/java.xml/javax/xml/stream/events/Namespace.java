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
 * An interface that contains information about a namespace.
 * Namespaces are accessed from a StartElement.
 *
 * @version 1.0
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @see StartElement
 * @since 1.6
 */
public interface Namespace extends Attribute {

  /**
   * Gets the prefix, returns "" if this is a default
   * namespace declaration.
   * @return the prefix
   */
  public String getPrefix();

  /**
   * Gets the uri bound to the prefix of this namespace
   * @return the {@code NamespaceURI}
   */
  public String getNamespaceURI();

  /**
   * returns true if this attribute declares the default namespace
   * @return true if this is default namespace, false otherwise
   */
  public boolean isDefaultNamespaceDeclaration();
}
