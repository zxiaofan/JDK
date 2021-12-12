/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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
import javax.swing.event.*;

public class JInternalFrameWrapper implements FrameWrapper {
  private JInternalFrame frame;
  private boolean        hasWindowListener;
  private ActionListener closingActionListener;
  private ActionListener activatedActionListener;

  public JInternalFrameWrapper(JInternalFrame frame) {
    this.frame = frame;
  }

  public Component  getComponent()              { return frame;                  }
  public Container  getContentPane()            { return frame.getContentPane(); }
  public void       setVisible(boolean visible) { frame.setVisible(visible);     }
  public void       setSize(int x, int y)       { frame.setSize(x, y);           }
  public void       pack()                      { frame.pack();                  }
  public void       show()                      { frame.show();                  }
  public void       dispose()                   { frame.dispose();               }
  public void       setBackground(Color color)  { frame.setBackground(color);    }
  public void       setResizable(boolean resizable) { frame.setResizable(resizable); }
  public void       setClosable(boolean closable) { frame.setClosable(closable); }

  public void setClosingActionListener(ActionListener l) {
    closingActionListener = l;
    maybeInstallWindowListener();
  }

  public void setActivatedActionListener(ActionListener l) {
    activatedActionListener = l;
    maybeInstallWindowListener();
  }

  public void toFront() {
    frame.toFront();
    try {
      frame.setSelected(true);
    } catch (java.beans.PropertyVetoException e) {
    }
  }

  //----------------------------------------------------------------------
  // Internals only below this point
  //

  private void maybeInstallWindowListener() {
    if (!hasWindowListener) {
      frame.addInternalFrameListener(new InternalFrameAdapter() {
          public void internalFrameClosing(InternalFrameEvent e) {
            if (closingActionListener != null) {
              closingActionListener.actionPerformed(null);
            }
          }

          public void internalFrameActivated(InternalFrameEvent e) {
            if (activatedActionListener != null) {
              activatedActionListener.actionPerformed(null);
            }
          }
        });
      hasWindowListener = true;
    }
  }
}
