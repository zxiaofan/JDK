/*
 * Copyright (c) 1997, 1998, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing;

import java.awt.*;
import java.awt.event.*;

/**
 * The editor component used for JComboBox components.
 *
 * @author Arnaud Weber
 * @since 1.2
 */
public interface ComboBoxEditor {

  /**
   * Returns the component that should be added to the tree hierarchy for
   * this editor
   *
   * @return the component
   */
  public Component getEditorComponent();

  /**
   * Set the item that should be edited. Cancel any editing if necessary
   *
   * @param anObject an item
   */
  public void setItem(Object anObject);

  /**
   * Returns the edited item
   *
   * @return the edited item
   */
  public Object getItem();

  /**
   * Ask the editor to start editing and to select everything
   */
  public void selectAll();

  /**
   * Add an ActionListener. An action event is generated when the edited item changes
   *
   * @param l an {@code ActionListener}
   */
  public void addActionListener(ActionListener l);

  /**
   * Remove an ActionListener
   *
   * @param l an {@code ActionListener}
   */
  public void removeActionListener(ActionListener l);
}
