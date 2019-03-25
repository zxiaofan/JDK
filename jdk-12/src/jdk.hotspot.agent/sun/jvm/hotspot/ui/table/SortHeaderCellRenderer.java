/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.ui.table;

import java.awt.Component;

import javax.swing.*;
import javax.swing.table.*;

/**
 * A cell renderer for the JTableHeader which understands the sorted
 * column state and renders arrow buttons to indicated the sorted column
 * and order
 */
public class SortHeaderCellRenderer extends DefaultTableCellRenderer {

    private Icon descendingIcon;
    private Icon ascendingIcon;

    private SortableTableModel model;

    public SortHeaderCellRenderer(JTableHeader header, SortableTableModel model) {
        this.model = model;

        descendingIcon = getIcon("navigation/Down16.gif");
        ascendingIcon = getIcon("navigation/Up16.gif");

        setForeground(header.getForeground());
        setBackground(header.getBackground());
        setFont(header.getFont());

        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setHorizontalAlignment(JLabel.CENTER);

    }

    /**
     *  Retrieves an Image Icon from the JLF graphics repository.
     */
    public ImageIcon getIcon(String name) {
        String imagePath = "/toolbarButtonGraphics/" + name;
        java.net.URL url = this.getClass().getResource(imagePath);
        if (url != null) {
            return new ImageIcon(url);
        }
        return null;
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column)  {
        setText((value == null) ? "" : value.toString());

        Icon icon = null;
        if (column == model.getColumn()) {
            if (model.isAscending()) {
                icon = ascendingIcon;
            } else {
                icon = descendingIcon;
            }
        }
        setIcon(icon);

        return this;
    }
}
