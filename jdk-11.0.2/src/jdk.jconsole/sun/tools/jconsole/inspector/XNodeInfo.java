/*
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
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

/**
 * <p>This class represents the user object of the nodes in the MBean tree.</p>
 *
 * <p>It encapsulates the node's info, i.e. the type of the node, the label to
 * be used when displaying the node in the MBean tree, the node's tool tip text
 * and arbitrary data which varies depending on the type of the node: an XMBean
 * reference for MBEAN, ATTRIBUTES, OPERATIONS and NOTIFICATIONS nodes; the
 * corresponding MBeanInfo for ATTRIBUTE, OPERATION and NOTIFICATION nodes;
 * it is not used for NONMBEAN nodes.</p>
 */
public class XNodeInfo {

    public static enum Type {
        MBEAN, NONMBEAN,
        ATTRIBUTES, OPERATIONS, NOTIFICATIONS,
        ATTRIBUTE, OPERATION, NOTIFICATION
    };

    public XNodeInfo(Type type, Object data, String label, String tooltip) {
        this.type = type;
        this.data = data;
        this.label = label;
        this.tooltip = tooltip;
    }

    public Type getType() {
        return type;
    }

    public Object getData() {
        return data;
    }

    public String getLabel() {
        return label;
    }

    public String getToolTipText() {
        return tooltip;
    }

    public String toString() {
        return label;
    }

    private Type type;
    private Object data;
    private String label;
    private String tooltip;
}
