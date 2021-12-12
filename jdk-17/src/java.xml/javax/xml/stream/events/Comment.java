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

/**
 * An interface for comment events
 *
 * @version 1.0
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @since 1.6
 */
public interface Comment extends XMLEvent {

  /**
   * Return the string data of the comment, returns empty string if it
   * does not exist.
   * @return the string data of the comment
   */
  public String getText();
}
