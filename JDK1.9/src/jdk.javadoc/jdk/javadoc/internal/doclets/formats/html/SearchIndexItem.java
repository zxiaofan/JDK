/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.formats.html;

/**
 * Index item for search.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class SearchIndexItem {

    private String label = "";
    private String url = "";
    private String category = "";
    private String containingModule = "";
    private String containingPackage = "";
    private String containingClass = "";
    private String holder = "";
    private String description = "";

    public void setLabel(String l) {
        label = l;
    }

    public String getLabel() {
        return label;
    }

    public void setUrl(String u) {
        url = u;
    }

    public String getUrl() {
        return url;
    }

    public void setContainingModule(String m) {
        containingModule = m;
    }

    public void setContainingPackage(String p) {
        containingPackage = p;
    }

    public void setContainingClass(String c) {
        containingClass = c;
    }

    public void setCategory(String c) {
        category = c;
    }

    public void setHolder(String h) {
        holder = h;
    }

    public String getHolder() {
        return holder;
    }

    public void setDescription(String d) {
        description = d;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        StringBuilder item = new StringBuilder("");
        if (category.equals("Modules")) {
            item.append("{")
                    .append("\"l\":\"").append(label).append("\"")
                    .append("}");
        } else if (category.equals("Packages")) {
            item.append("{");
            if (!containingModule.isEmpty()) {
                item.append("\"m\":\"").append(containingModule).append("\",");
            }
            item.append("\"l\":\"").append(label).append("\"")
                    .append("}");
        } else if (category.equals("Types")) {
            item.append("{")
                    .append("\"p\":\"").append(containingPackage).append("\",")
                    .append("\"l\":\"").append(label).append("\"")
                    .append("}");
        } else if (category.equals("Members")) {
            item.append("{")
                    .append("\"p\":\"").append(containingPackage).append("\",")
                    .append("\"c\":\"").append(containingClass).append("\",")
                    .append("\"l\":\"").append(label).append("\"");
            if (!url.equals("")) {
                item.append(",\"url\":\"").append(url).append("\"");
            }
            item.append("}");
        } else {
            item.append("{")
                    .append("\"l\":\"").append(label).append("\",")
                    .append("\"h\":\"").append(holder).append("\",");
            if (!description.equals("")) {
                item.append("\"d\":\"").append(description).append("\",");
            }
            item.append("\"u\":\"").append(url).append("\"")
                    .append("}");
        }
        return item.toString();
    }
}
