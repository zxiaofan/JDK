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

import java.awt.Color;
import java.awt.Component;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

class XArrayDataViewer {

    private XArrayDataViewer() {}

    public static boolean isViewableValue(Object value) {
        return Utils.canBeRenderedAsArray(value);
    }

    public static Component loadArray(Object value) {
        Component comp = null;
        if (isViewableValue(value)) {
            Object[] arr;
            if (value instanceof Collection) {
                arr = ((Collection<?>) value).toArray();
            } else if (value instanceof Map) {
                arr = ((Map<?,?>) value).entrySet().toArray();
            } else if (value instanceof Object[]) {
                arr = (Object[]) value;
            } else {
                int length = Array.getLength(value);
                arr = new Object[length];
                for (int i = 0; i < length; i++) {
                    arr[i] = Array.get(value, i);
                }
            }
            JEditorPane arrayEditor = new JEditorPane();
            arrayEditor.setContentType("text/html");
            arrayEditor.setEditable(false);
            Color evenRowColor = arrayEditor.getBackground();
            int red = evenRowColor.getRed();
            int green = evenRowColor.getGreen();
            int blue = evenRowColor.getBlue();
            String evenRowColorStr =
                    "rgb(" + red + "," + green + "," + blue + ")";
            Color oddRowColor = new Color(
                    red < 20 ? red + 20 : red - 20,
                    green < 20 ? green + 20 : green - 20,
                    blue < 20 ? blue + 20 : blue - 20);
            String oddRowColorStr =
                    "rgb(" + oddRowColor.getRed() + "," +
                    oddRowColor.getGreen() + "," +
                    oddRowColor.getBlue() + ")";
            Color foreground = arrayEditor.getForeground();
            String textColor = String.format("%06x",
                                             foreground.getRGB() & 0xFFFFFF);
            StringBuilder sb = new StringBuilder();
            sb.append("<html><body text=#").append(textColor).append("><table width=\"100%\">");
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    sb.append("<tr style=\"background-color: ")
                            .append(evenRowColorStr).append("\"><td><pre>")
                            .append(arr[i] == null ?
                                    arr[i] : htmlize(arr[i].toString()))
                      .append("</pre></td></tr>");
                } else {
                    sb.append("<tr style=\"background-color: ")
                            .append(oddRowColorStr).append("\"><td><pre>")
                            .append(arr[i] == null ?
                                    arr[i] : htmlize(arr[i].toString()))
                            .append("</pre></td></tr>");
                }
            }
            if (arr.length == 0) {
                sb.append("<tr style=\"background-color: ")
                        .append(evenRowColorStr).append("\"><td></td></tr>");
            }
            sb.append("</table></body></html>");
            arrayEditor.setText(sb.toString());
            JScrollPane scrollp = new JScrollPane(arrayEditor);
            comp = scrollp;
        }
        return comp;
    }

    private static String htmlize(String value) {
        return value.replace("&", "&amp;").replace("<", "&lt;");
    }
}
