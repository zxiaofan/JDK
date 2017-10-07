/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.formats.html;

/**
 * Enum representing various section names of generated API documentation.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Bhavesh Patel
 */
@Deprecated
public enum SectionName {

    ANNOTATION_TYPE_ELEMENT_DETAIL("annotation.type.element.detail"),
    ANNOTATION_TYPE_FIELD_DETAIL("annotation.type.field.detail"),
    ANNOTATION_TYPE_FIELD_SUMMARY("annotation.type.field.summary"),
    ANNOTATION_TYPE_OPTIONAL_ELEMENT_SUMMARY("annotation.type.optional.element.summary"),
    ANNOTATION_TYPE_REQUIRED_ELEMENT_SUMMARY("annotation.type.required.element.summary"),
    CONSTRUCTOR_DETAIL("constructor.detail"),
    CONSTRUCTOR_SUMMARY("constructor.summary"),
    ENUM_CONSTANT_DETAIL("enum.constant.detail"),
    ENUM_CONSTANTS_INHERITANCE("enum.constants.inherited.from.class."),
    ENUM_CONSTANT_SUMMARY("enum.constant.summary"),
    FIELD_DETAIL("field.detail"),
    FIELDS_INHERITANCE("fields.inherited.from.class."),
    FIELD_SUMMARY("field.summary"),
    METHOD_DETAIL("method.detail"),
    METHODS_INHERITANCE("methods.inherited.from.class."),
    METHOD_SUMMARY("method.summary"),
    NAVBAR_BOTTOM("navbar.bottom"),
    NAVBAR_BOTTOM_FIRSTROW("navbar.bottom.firstrow"),
    NAVBAR_TOP("navbar.top"),
    NAVBAR_TOP_FIRSTROW("navbar.top.firstrow"),
    NESTED_CLASSES_INHERITANCE("nested.classes.inherited.from.class."),
    NESTED_CLASS_SUMMARY("nested.class.summary"),
    OVERVIEW_DESCRIPTION("overview.description"),
    PACKAGE_DESCRIPTION("package.description"),
    PROPERTY_DETAIL("property.detail"),
    PROPERTIES_INHERITANCE("properties.inherited.from.class."),
    PROPERTY_SUMMARY("property.summary"),
    SKIP_NAVBAR_BOTTOM("skip.navbar.bottom"),
    SKIP_NAVBAR_TOP("skip.navbar.top"),
    UNNAMED_PACKAGE_ANCHOR("unnamed.package");

    private final String value;

    SectionName(String sName) {
        this.value = sName;
    }

    public String getName() {
        return this.value;
    }
}
