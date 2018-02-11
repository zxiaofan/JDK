/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.dtdparser;


/**
 * This class contains static methods used to determine whether identifiers
 * may appear in certain roles in XML documents.  Such methods are used
 * both to parse and to create such documents.
 *
 * @author David Brownell
 * @version 1.1, 00/08/05
 */
public class XmlNames {
    private XmlNames() {
    }


    /**
     * Returns true if the value is a legal XML name.
     *
     * @param value the string being tested
     */
    public static boolean isName(String value) {
        if (value == null)
            return false;

        char c = value.charAt(0);
        if (!XmlChars.isLetter(c) && c != '_' && c != ':')
            return false;
        for (int i = 1; i < value.length(); i++)
            if (!XmlChars.isNameChar(value.charAt(i)))
                return false;
        return true;
    }

    /**
     * Returns true if the value is a legal "unqualified" XML name, as
     * defined in the XML Namespaces proposed recommendation.
     * These are normal XML names, except that they may not contain
     * a "colon" character.
     *
     * @param value the string being tested
     */
    public static boolean isUnqualifiedName(String value) {
        if (value == null || value.length() == 0)
            return false;

        char c = value.charAt(0);
        if (!XmlChars.isLetter(c) && c != '_')
            return false;
        for (int i = 1; i < value.length(); i++)
            if (!XmlChars.isNCNameChar(value.charAt(i)))
                return false;
        return true;
    }

    /**
     * Returns true if the value is a legal "qualified" XML name, as defined
     * in the XML Namespaces proposed recommendation.  Qualified names are
     * composed of an optional prefix (an unqualified name), followed by a
     * colon, and a required "local part" (an unqualified name).  Prefixes are
     * declared, and correspond to particular URIs which scope the "local
     * part" of the name.  (This method cannot check whether the prefix of a
     * name has been declared.)
     *
     * @param value the string being tested
     */
    public static boolean isQualifiedName(String value) {
        if (value == null)
            return false;

        // [6] QName ::= (Prefix ':')? LocalPart
        // [7] Prefix ::= NCName
        // [8] LocalPart ::= NCName

        int first = value.indexOf(':');

        // no Prefix, only check LocalPart
        if (first <= 0)
            return isUnqualifiedName(value);

        // Prefix exists, check everything

        int last = value.lastIndexOf(':');
        if (last != first)
            return false;

        return isUnqualifiedName(value.substring(0, first))
                && isUnqualifiedName(value.substring(first + 1));
    }

    /**
     * This method returns true if the identifier is a "name token"
     * as defined in the XML specification.  Like names, these
     * may only contain "name characters"; however, they do not need
     * to have letters as their initial characters.  Attribute values
     * defined to be of type NMTOKEN(S) must satisfy this predicate.
     *
     * @param token the string being tested
     */
    public static boolean isNmtoken(String token) {
        int length = token.length();

        for (int i = 0; i < length; i++)
            if (!XmlChars.isNameChar(token.charAt(i)))
                return false;
        return true;
    }


    /**
     * This method returns true if the identifier is a "name token" as
     * defined by the XML Namespaces proposed recommendation.
     * These are like XML "name tokens" but they may not contain the
     * "colon" character.
     *
     * @param token the string being tested
     * @see #isNmtoken
     */
    public static boolean isNCNmtoken(String token) {
        return isNmtoken(token) && token.indexOf(':') < 0;
    }
}
