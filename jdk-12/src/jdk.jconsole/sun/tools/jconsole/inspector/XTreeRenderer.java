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

package sun.tools.jconsole.inspector;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

@SuppressWarnings("serial")
public class XTreeRenderer extends DefaultTreeCellRenderer {

    public Component getTreeCellRendererComponent(
            JTree tree, Object value, boolean selected, boolean expanded,
            boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(
                tree, value, selected, expanded, leaf, row, hasFocus);
        Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
        if (userObject instanceof XNodeInfo) {
            XNodeInfo node = (XNodeInfo) userObject;
            setToolTipText(node.getToolTipText());
            switch (node.getType()) {
                case MBEAN:
                    XMBean xmbean = (XMBean) node.getData();
                    setIcon((ImageIcon) xmbean.getIcon());
                    break;
                case NONMBEAN:
                    break;
                case ATTRIBUTES:
                case OPERATIONS:
                case NOTIFICATIONS:
                    setIcon(null);
                    break;
                case ATTRIBUTE:
                case OPERATION:
                case NOTIFICATION:
                    setIcon(null);
                    break;
            }
        } else {
            setToolTipText(null);
        }
        return this;
    }
}
