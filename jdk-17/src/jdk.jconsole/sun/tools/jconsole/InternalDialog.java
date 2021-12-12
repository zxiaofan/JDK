/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jconsole;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


import static javax.swing.JLayeredPane.*;

/**
 * Used instead of JDialog in a JDesktopPane/JInternalFrame environment.
 */
@SuppressWarnings("serial")
public class InternalDialog extends JInternalFrame {
    protected JLabel statusBar;

    public InternalDialog(JConsole jConsole, String title, boolean modal) {
        super(title, true, true, false, false);

        setLayer(PALETTE_LAYER);
        putClientProperty("JInternalFrame.frameType", "optionDialog");

        jConsole.getDesktopPane().add(this);


        getActionMap().put("cancel", new AbstractAction() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                if (statusBar != null) {
                    statusBar.setText("");
                }
            }
        });
        InputMap inputMap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancel");
    }

    public void setLocationRelativeTo(Component c) {
        setLocation((c.getWidth()  - getWidth())  / 2,
                    (c.getHeight() - getHeight()) / 2);
    }

    protected class MastheadIcon implements Icon {
        // Important: Assume image background is white!
        private ImageIcon leftIcon =
            new ImageIcon(InternalDialog.class.getResource("resources/masthead-left.png"));
        private ImageIcon rightIcon =
            new ImageIcon(InternalDialog.class.getResource("resources/masthead-right.png"));

        private Font font = Font.decode(Messages.MASTHEAD_FONT);
        private int gap = 10;
        private String title;

        public MastheadIcon(String title) {
            this.title = title;
        }

        public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
            // Clone the Graphics object
            g = g.create();

            // Ignore x to make sure we fill entire component width
            x = 0;
            int width = c.getWidth();
            int lWidth = leftIcon.getIconWidth();
            int rWidth = rightIcon.getIconWidth();
            int height = getIconHeight();
            int textHeight = g.getFontMetrics(font).getAscent();

            g.setColor(Color.white);
            g.fillRect(x, y, width, height);

            leftIcon.paintIcon(c, g, x, y);
            rightIcon.paintIcon(c, g, width - rWidth, y);

            g.setFont(font);
            ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                                             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g.setColor(new Color(0x35556b));
            g.drawString(title, lWidth + gap, height/2 + textHeight/2);
        }

        public int getIconWidth() {
            int textWidth = 0;
            Graphics g = getGraphics();
            if (g != null) {
                FontMetrics fm = g.getFontMetrics(font);
                if (fm != null) {
                    textWidth = fm.stringWidth(title);
                }
            }
            return (leftIcon.getIconWidth() + gap + textWidth +
                    gap + rightIcon.getIconWidth());
        }


        public int getIconHeight() {
            return leftIcon.getIconHeight();
        }
    }
}
