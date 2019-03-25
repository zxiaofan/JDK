/*
 * Copyright (c) 2000, 2002, Oracle and/or its affiliates. All rights reserved.
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
import javax.swing.*;

/** A panel containing a progress bar and a label */

public class ProgressBarPanel extends JPanel {
  private JLabel text;
  private JProgressBar bar;
  private static final int MAX = 10000;

  public static final int VERTICAL   = 0;
  public static final int HORIZONTAL = 1;

  public ProgressBarPanel() {
    this(VERTICAL);
  }

  /** LayoutType is either VERTICAL or HORIZONTAL */
  public ProgressBarPanel(int layoutType) {
    super();
    if (layoutType == VERTICAL) {
      setLayout(new BorderLayout());
      text = new JLabel();
      add(text, BorderLayout.NORTH);
      bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, MAX);
      JPanel panel = new JPanel();
      panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      panel.add(bar);
      add(panel, BorderLayout.CENTER);
    } else {
      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
      text = new JLabel();
      add(text);
      bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, MAX);
      add(bar);
    }
  }

  public ProgressBarPanel(String text) {
    this();
    setText(text);
  }

  public ProgressBarPanel(int layoutType, String text) {
    this(layoutType);
    setText(text);
  }

  public void setText(String text) {
    this.text.setText(text);
  }

  public void setValue(double val) {
    int realVal = (int) (val * MAX);
    bar.setValue(realVal);
  }

  public void setIndeterminate(boolean value) {
    bar.setIndeterminate(value);
  }
}
