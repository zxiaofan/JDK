/*
 * Copyright (c) 1998, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf.metal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.border.*;
import java.io.Serializable;
import javax.swing.plaf.basic.BasicComboBoxUI;


/**
 * This utility class draws the horizontal bars which indicate a MetalComboBox
 *
 * @see MetalComboBoxUI
 * @author Tom Santos
 */
@SuppressWarnings("serial") // Same-version serialization only
public class MetalComboBoxIcon implements Icon, Serializable {

    /**
     * Constructs a {@code MetalComboBoxIcon}.
     */
    public MetalComboBoxIcon() {}

    /**
     * Paints the horizontal bars for the
     */
    public void paintIcon(Component c, Graphics g, int x, int y){
        JComponent component = (JComponent)c;
        int iconWidth = getIconWidth();

        g.translate( x, y );

        g.setColor(component.isEnabled()
                   ? MetalLookAndFeel.getControlInfo()
                   : MetalLookAndFeel.getControlShadow());
        g.fillPolygon(new int[]{0, 5, iconWidth - 5, iconWidth},
                      new int[]{0, 5, 5, 0}, 4);
        g.translate( -x, -y );
    }

    /**
     * Created a stub to satisfy the interface.
     */
    public int getIconWidth() { return 10; }

    /**
     * Created a stub to satisfy the interface.
     */
    public int getIconHeight()  { return 5; }

}
