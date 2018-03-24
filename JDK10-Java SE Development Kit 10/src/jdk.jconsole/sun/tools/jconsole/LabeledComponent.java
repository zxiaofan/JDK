/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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

import javax.swing.*;

@SuppressWarnings("serial")
public class LabeledComponent extends JPanel {
    JPanel rightPanel;
    String labelStr, valueLabelStr, compoundStr;
    JLabel label;
    JComponent comp;

    public LabeledComponent(String text, JComponent comp) {
        this(text, 0, comp);
    }

    public LabeledComponent(String text, int mnemonic, JComponent comp) {
        super(new BorderLayout(6, 6));

        this.labelStr = text;
        this.label = new JLabel(text, JLabel.RIGHT);
        this.comp = comp;

        label.setLabelFor(comp);
        if (mnemonic > 0) {
            label.setDisplayedMnemonic(mnemonic);
        }

        add(label, BorderLayout.WEST);
        add(comp,  BorderLayout.CENTER);
    }

    public void setLabel(String str) {
        this.labelStr = str;
        updateLabel();
    }

    public void setValueLabel(String str) {
        this.valueLabelStr = str;
        updateLabel();
    }

    private void updateLabel() {
        String str = labelStr;
        label.setText(str);
        this.compoundStr = str;
        JComponent container = (JComponent)getParent();
        LabeledComponent.layout(container);
    }

    public static void layout(Container container) {
        int wMax = 0;

        for (Component c : container.getComponents()) {
            if (c instanceof LabeledComponent) {
                LabeledComponent lc = (LabeledComponent)c;
lc.label.setPreferredSize(null);
//              int w = lc.label.getMinimumSize().width;
int w = lc.label.getPreferredSize().width;
                if (w > wMax) {
                    wMax = w;
                }
            }
        }

        for (Component c : container.getComponents()) {
            if (c instanceof LabeledComponent) {
                LabeledComponent lc = (LabeledComponent)c;
                JLabel label = lc.label;
                int h = label.getPreferredSize().height;

                label.setPreferredSize(new Dimension(wMax, h));
                label.setHorizontalAlignment(JLabel.RIGHT);
            }
        }
    }
}
