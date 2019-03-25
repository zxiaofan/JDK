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

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.MouseListener;
import java.awt.Component;
import java.awt.Container;

import sun.tools.jconsole.MBeansTab;
import sun.tools.jconsole.Messages;

public class XDataViewer {

    public static final int OPEN = 1;
    public static final int ARRAY = 2;
    public static final int NUMERIC = 3;
    public static final int NOT_SUPPORTED = 4;

    private MBeansTab tab;
    public XDataViewer(MBeansTab tab) {
        this.tab = tab;
    }

    public static void registerForMouseEvent(Component comp,
                                             MouseListener mouseListener) {
        if(comp instanceof JScrollPane) {
            JScrollPane pane = (JScrollPane) comp;
            comp = pane.getViewport().getView();
        }
        if(comp instanceof Container) {
            Container container = (Container) comp;
            Component[] components = container.getComponents();
            for(int i = 0; i < components.length; i++) {
                registerForMouseEvent(components[i], mouseListener);
            }
        }

        //No registration for XOpenTypedata that are themselves clickable.
        //No registration for JButton that are themselves clickable.
        if(comp != null &&
           (!(comp instanceof XOpenTypeViewer.XOpenTypeData) &&
            !(comp instanceof JButton)) )
            comp.addMouseListener(mouseListener);
    }

    public static void dispose(MBeansTab tab) {
        XPlottingViewer.dispose(tab);
    }

    public static boolean isViewableValue(Object value) {
        boolean ret = false;
        if((ret = XArrayDataViewer.isViewableValue(value)))
            return ret;
        if((ret = XOpenTypeViewer.isViewableValue(value)))
            return ret;
        if((ret = XPlottingViewer.isViewableValue(value)))
            return ret;

        return ret;
    }

    public static int getViewerType(Object data) {
        if(XArrayDataViewer.isViewableValue(data))
            return ARRAY;
        if(XOpenTypeViewer.isViewableValue(data))
            return OPEN;
        if(XPlottingViewer.isViewableValue(data))
            return NUMERIC;

        return NOT_SUPPORTED;
    }

    public static String getActionLabel(int type) {
        if(type == ARRAY ||
           type == OPEN)
            return Messages.VISUALIZE;
        if(type == NUMERIC)
            return Messages.PLOT;
        return Messages.EXPAND;
    }

    public Component createOperationViewer(Object value,
                                           XMBean mbean) {
        if(value instanceof Number) return null;
        if(value instanceof Component) return (Component) value;
        return createAttributeViewer(value, mbean, null, null);
    }

    public static Component createNotificationViewer(Object value) {
        Component comp = null;

        if(value instanceof Number) return null;

        if((comp = XArrayDataViewer.loadArray(value)) != null)
            return comp;

        if((comp = XOpenTypeViewer.loadOpenType(value)) != null)
            return comp;

        return comp;
    }

    public Component createAttributeViewer(Object value,
                                           XMBean mbean,
                                           String attributeName,
                                           JTable table) {
        Component comp = null;
        if((comp = XArrayDataViewer.loadArray(value)) != null)
            return comp;
        if((comp = XOpenTypeViewer.loadOpenType(value)) != null)
            return comp;
        if((comp = XPlottingViewer.loadPlotting(mbean,
                                                attributeName,
                                                value,
                                                table,
                                                tab)) != null)
            return comp;

        return comp;
    }
}
