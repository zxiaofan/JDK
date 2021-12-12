/*
 * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
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

package javax.lang.model.element;


/**
 * Represents a modifier on a program element such
 * as a class, method, or field.
 *
 * <p>Not all modifiers are applicable to all kinds of elements.
 * When two or more modifiers appear in the source code of an element
 * then it is customary, though not required, that they appear in the same
 * order as the constants listed in the detail section below.
 *
 * <p>Note that it is possible additional modifiers will be added in
 * future versions of the platform.
 *
 * @jls 8.1.1 Class Modifiers
 * @jls 8.3.1 Field Modifiers
 * @jls 8.4.3 Method Modifiers
 * @jls 8.8.3 Constructor Modifiers
 * @jls 9.1.1 Interface Modifiers
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */

public enum Modifier {

    // Note java.lang.reflect.Modifier includes INTERFACE, but that's a VMism.

    /** The modifier {@code public} */          PUBLIC,
    /** The modifier {@code protected} */       PROTECTED,
    /** The modifier {@code private} */         PRIVATE,
    /** The modifier {@code abstract} */        ABSTRACT,
    /**
     * The modifier {@code default}
     * @since 1.8
     */
     DEFAULT,
    /** The modifier {@code static} */          STATIC,

    /**
     * The modifier {@code sealed}
     * @since 17
     */
    SEALED,

    /**
     * The modifier {@code non-sealed}
     * @since 17
     */
    NON_SEALED {
        public String toString() {
            return "non-sealed";
        }
    },
    /** The modifier {@code final} */           FINAL,
    /** The modifier {@code transient} */       TRANSIENT,
    /** The modifier {@code volatile} */        VOLATILE,
    /** The modifier {@code synchronized} */    SYNCHRONIZED,
    /** The modifier {@code native} */          NATIVE,
    /** The modifier {@code strictfp} */        STRICTFP;

    /**
     * Returns this modifier's name as defined in <cite>The
     * Java Language Specification</cite>.
     * The modifier name is the {@linkplain #name() name of the enum
     * constant} in lowercase and with any underscores ("{@code _}")
     * replaced with hyphens ("{@code -}").
     * @return the modifier's name
     */
    @Override
    public String toString() {
        return name().toLowerCase(java.util.Locale.US);
    }
}
