/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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
package sun.swing.plaf.windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.UIManager;
import javax.swing.plaf.UIResource;

/**
 * Classic sort icons.
 *
 */
@SuppressWarnings("serial") // JDK-implementation class
public class ClassicSortArrowIcon implements Icon, UIResource, Serializable{
    private static final int X_OFFSET = 9;
    private boolean ascending;

    public ClassicSortArrowIcon(boolean ascending) {
        this.ascending = ascending;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        x += X_OFFSET;
        if (ascending) {
            g.setColor(UIManager.getColor("Table.sortIconHighlight"));
            drawSide(g, x + 3, y, -1);

            g.setColor(UIManager.getColor("Table.sortIconLight"));
            drawSide(g, x + 4, y, 1);

            g.fillRect(x + 1, y + 6, 6, 1);
        }
        else {
            g.setColor(UIManager.getColor("Table.sortIconHighlight"));
            drawSide(g, x + 3, y + 6, -1);
            g.fillRect(x + 1, y, 6, 1);

            g.setColor(UIManager.getColor("Table.sortIconLight"));
            drawSide(g, x + 4, y + 6, 1);
        }
    }

    private void drawSide(Graphics g, int x, int y, int xIncrement) {
        int yIncrement = 2;
        if (ascending) {
            g.fillRect(x, y, 1, 2);
            y++;
        }
        else {
            g.fillRect(x, --y, 1, 2);
            yIncrement = -2;
            y -= 2;
        }
        x += xIncrement;
        for (int i = 0; i < 2; i++) {
            g.fillRect(x, y, 1, 3);
            x += xIncrement;
            y += yIncrement;
        }
        if (!ascending) {
            y++;
        }
        g.fillRect(x, y, 1, 2);
    }

    public int getIconWidth() {
        return X_OFFSET + 8;
    }
    public int getIconHeight() {
        return 9;
    }
}
