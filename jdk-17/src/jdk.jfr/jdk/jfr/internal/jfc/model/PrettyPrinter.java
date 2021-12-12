/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.internal.jfc.model;

import java.io.PrintWriter;
import java.util.Map;

final class PrettyPrinter {
    private final PrintWriter out;

    PrettyPrinter(PrintWriter out) {
        this.out = out;
    }

    void print(XmlConfiguration configuration) {
        printHeader();
        prettyPrint("", configuration);
    }

    private void printHeader() {
        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    }

    private void prettyPrint(String indent, XmlElement element) {
        printComment(indent, element);
        String elementName = element.getElementName();
        out.print(indent + '<' + elementName);
        printAttributes(element.getAttributes());
        if (element.getChildren().isEmpty() && !element.hasContent()) {
            out.println("/>");
            return;
        }
        out.print('>');
        out.print(Utilities.escapeAll(element.getContent().trim()));
        if (element.getChildren().isEmpty()) {
            out.println("</" + elementName + '>');
            return;
        }
        out.println();
        boolean first = true;
        for (XmlElement child : element.getChildren()) {
            if (first && child.isEntity()) {
                out.println();
            }
            prettyPrint(indent + "  ", child);
            if (child.isEntity()) {
                out.println();
            }
            first = false;
        }
        out.println(indent + "</" + elementName + '>');
    }

    private void printComment(String indent, XmlElement element) {
        String comment = element.comment();
        if (!comment.isEmpty()) {
            String text = comment.indent(indent.length());
            out.println(indent + "<!--");
            out.println(text.replace("\n", System.lineSeparator()));
            out.println(indent + "-->");
        }
    }

    private void printAttributes(Map<String, String> attributes) {
        for (var entry : attributes.entrySet()) {
            out.print(' ');
            out.print(entry.getKey());
            out.print("=\"");
            out.print(Utilities.escapeAll(entry.getValue()));
            out.print('\"');
        }
    }
}
