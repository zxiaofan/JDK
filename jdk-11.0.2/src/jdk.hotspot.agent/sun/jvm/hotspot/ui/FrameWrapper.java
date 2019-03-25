/*
 * Copyright (c) 2001, 2010, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Provides uniform interface for dealing with JInternalFrames and
    JFrames. */

public interface FrameWrapper {
  /** The JInternalFrame or JFrame this wraps */
  public Component  getComponent();

  public Container  getContentPane();
  public void       setVisible(boolean visible);
  public void       setSize(int x, int y);
  public void       pack();
  public void       dispose();
  public void       setBackground(Color color);
  public void       setResizable(boolean resizable);

  /** Largely for use with JInternalFrames but also affects, for
      example, the default close operation for JFrames */
  public void       setClosable(boolean closable);

  /** Set an ActionListener to be invoked when the underlying window
      is closing ("windowClosing" event of a WindowListener). Note:
      the ActionEvent passed to this listener may be null. */
  public void       setClosingActionListener(ActionListener l);

  /** Set an ActionListener to be invoked when the underlying window
      is activated ("windowActivated" event of a
      WindowListener). Note: the ActionEvent passed to this listener
      may be null. */
  public void       setActivatedActionListener(ActionListener l);

  /** Move this frame to the front. Should change focus to the frame
      if possible. */
  public void       toFront();
}
