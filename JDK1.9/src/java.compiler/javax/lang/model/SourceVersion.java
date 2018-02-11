/*
 * Copyright (c) 2005, 2016, Oracle and/or its affiliates. All rights reserved.
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

package javax.lang.model;

import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

/**
 * Source versions of the Java&trade; programming language.
 *
 * See the appropriate edition of
 * <cite>The Java&trade; Language Specification</cite>
 * for information about a particular source version.
 *
 * <p>Note that additional source version constants will be added to
 * model future releases of the language.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public enum SourceVersion {
    /*
     * Summary of language evolution
     * 1.1: nested classes
     * 1.2: strictfp
     * 1.3: no changes
     * 1.4: assert
     * 1.5: annotations, generics, autoboxing, var-args...
     * 1.6: no changes
     * 1.7: diamond syntax, try-with-resources, etc.
     * 1.8: lambda expressions and default methods
     *   9: modules, small cleanups to 1.7 and 1.8 changes
     */

    /**
     * The original version.
     *
     * The language described in
     * <cite>The Java&trade; Language Specification, First Edition</cite>.
     */
    RELEASE_0,

    /**
     * The version recognized by the Java Platform 1.1.
     *
     * The language is {@code RELEASE_0} augmented with nested classes as described in the 1.1 update to
     * <cite>The Java&trade; Language Specification, First Edition</cite>.
     */
    RELEASE_1,

    /**
     * The version recognized by the Java 2 Platform, Standard Edition,
     * v 1.2.
     *
     * The language described in
     * <cite>The Java&trade; Language Specification,
     * Second Edition</cite>, which includes the {@code
     * strictfp} modifier.
     */
    RELEASE_2,

    /**
     * The version recognized by the Java 2 Platform, Standard Edition,
     * v 1.3.
     *
     * No major changes from {@code RELEASE_2}.
     */
    RELEASE_3,

    /**
     * The version recognized by the Java 2 Platform, Standard Edition,
     * v 1.4.
     *
     * Added a simple assertion facility.
     */
    RELEASE_4,

    /**
     * The version recognized by the Java 2 Platform, Standard
     * Edition 5.0.
     *
     * The language described in
     * <cite>The Java&trade; Language Specification,
     * Third Edition</cite>.  First release to support
     * generics, annotations, autoboxing, var-args, enhanced {@code
     * for} loop, and hexadecimal floating-point literals.
     */
    RELEASE_5,

    /**
     * The version recognized by the Java Platform, Standard Edition
     * 6.
     *
     * No major changes from {@code RELEASE_5}.
     */
    RELEASE_6,

    /**
     * The version recognized by the Java Platform, Standard Edition
     * 7.
     *
     * Additions in this release include, diamond syntax for
     * constructors, {@code try}-with-resources, strings in switch,
     * binary literals, and multi-catch.
     * @since 1.7
     */
    RELEASE_7,

    /**
     * The version recognized by the Java Platform, Standard Edition
     * 8.
     *
     * Additions in this release include lambda expressions and default methods.
     * @since 1.8
     */
    RELEASE_8,

    /**
     * The version recognized by the Java Platform, Standard Edition
     * 9.
     *
     * Additions in this release include modules and removal of a
     * single underscore from the set of legal identifier names.
     *
     * @since 9
     */
     RELEASE_9;

    // Note that when adding constants for newer releases, the
    // behavior of latest() and latestSupported() must be updated too.

    /**
     * Returns the latest source version that can be modeled.
     *
     * @return the latest source version that can be modeled
     */
    public static SourceVersion latest() {
        return RELEASE_9;
    }

    private static final SourceVersion latestSupported = getLatestSupported();

    private static SourceVersion getLatestSupported() {
        try {
            String specVersion = System.getProperty("java.specification.version");

            switch (specVersion) {
                case "9":
                case "1.9":
                    return RELEASE_9;
                case "1.8":
                    return RELEASE_8;
                case "1.7":
                    return RELEASE_7;
                case "1.6":
                    return RELEASE_6;
            }
        } catch (SecurityException se) {}

        return RELEASE_5;
    }

    /**
     * Returns the latest source version fully supported by the
     * current execution environment.  {@code RELEASE_5} or later must
     * be returned.
     *
     * @return the latest source version that is fully supported
     */
    public static SourceVersion latestSupported() {
        return latestSupported;
    }

    /**
     * Returns whether or not {@code name} is a syntactically valid
     * identifier (simple name) or keyword in the latest source
     * version.  The method returns {@code true} if the name consists
     * of an initial character for which {@link
     * Character#isJavaIdentifierStart(int)} returns {@code true},
     * followed only by characters for which {@link
     * Character#isJavaIdentifierPart(int)} returns {@code true}.
     * This pattern matches regular identifiers, keywords, and the
     * literals {@code "true"}, {@code "false"}, and {@code "null"}.
     * The method returns {@code false} for all other strings.
     *
     * @param name the string to check
     * @return {@code true} if this string is a
     * syntactically valid identifier or keyword, {@code false}
     * otherwise.
     */
    public static boolean isIdentifier(CharSequence name) {
        String id = name.toString();

        if (id.length() == 0) {
            return false;
        }
        int cp = id.codePointAt(0);
        if (!Character.isJavaIdentifierStart(cp)) {
            return false;
        }
        for (int i = Character.charCount(cp);
                i < id.length();
                i += Character.charCount(cp)) {
            cp = id.codePointAt(i);
            if (!Character.isJavaIdentifierPart(cp)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns whether or not {@code name} is a syntactically valid
     * qualified name in the latest source version.  Unlike {@link
     * #isIdentifier isIdentifier}, this method returns {@code false}
     * for keywords, boolean literals, and the null literal.
     *
     * @param name the string to check
     * @return {@code true} if this string is a
     * syntactically valid name, {@code false} otherwise.
     * @jls 6.2 Names and Identifiers
     */
    public static boolean isName(CharSequence name) {
        return isName(name, latest());
    }

    /**
     * Returns whether or not {@code name} is a syntactically valid
     * qualified name in the given source version.  Unlike {@link
     * #isIdentifier isIdentifier}, this method returns {@code false}
     * for keywords, boolean literals, and the null literal.
     *
     * @param name the string to check
     * @param version the version to use
     * @return {@code true} if this string is a
     * syntactically valid name, {@code false} otherwise.
     * @jls 6.2 Names and Identifiers
     * @since 9
     */
    public static boolean isName(CharSequence name, SourceVersion version) {
        String id = name.toString();

        for(String s : id.split("\\.", -1)) {
            if (!isIdentifier(s) || isKeyword(s, version))
                return false;
        }
        return true;
    }

    /**
     * Returns whether or not {@code s} is a keyword, boolean literal,
     * or null literal in the latest source version.
     *
     * @param s the string to check
     * @return {@code true} if {@code s} is a keyword, or boolean
     * literal, or null literal, {@code false} otherwise.
     * @jls 3.9 Keywords
     * @jls 3.10.3 Boolean Literals
     * @jls 3.10.7 The Null Literal
     */
    public static boolean isKeyword(CharSequence s) {
        return isKeyword(s, latest());
    }

    /**
     * Returns whether or not {@code s} is a keyword, boolean literal,
     * or null literal in the given source version.
     *
     * @param s the string to check
     * @param version the version to use
     * @return {@code true} if {@code s} is a keyword, or boolean
     * literal, or null literal, {@code false} otherwise.
     * @jls 3.9 Keywords
     * @jls 3.10.3 Boolean Literals
     * @jls 3.10.7 The Null Literal
     * @since 9
     */
    public static boolean isKeyword(CharSequence s, SourceVersion version) {
        String id = s.toString();
        switch(id) {
            // A trip through history
        case "strictfp":
            return version.compareTo(RELEASE_2) >= 0;

        case "assert":
            return version.compareTo(RELEASE_4) >= 0;

        case "enum":
            return version.compareTo(RELEASE_5) >= 0;

        case "_":
            return version.compareTo(RELEASE_9) >= 0;

            // Keywords common across versions

            // Modifiers
        case "public":    case "protected": case "private":
        case "abstract":  case "static":    case "final":
        case "transient": case "volatile":  case "synchronized":
        case "native":

            // Declarations
        case "class":     case "interface": case "extends":
        case "package":   case "throws":    case "implements":

            // Primitive types and void
        case "boolean":   case "byte":      case "char":
        case "short":     case "int":       case "long":
        case "float":     case "double":
        case "void":

            // Control flow
        case "if":      case "else":
        case "try":     case "catch":    case "finally":
        case "do":      case "while":
        case "for":     case "continue":
        case "switch":  case "case":     case "default":
        case "break":   case "throw":    case "return":

            // Other keywords
        case  "this":   case "new":      case "super":
        case "import":  case "instanceof":

            // Forbidden!
        case "goto":        case "const":

            // literals
        case "null":         case "true":       case "false":
            return true;

        default:
            return false;
        }
    }
}
