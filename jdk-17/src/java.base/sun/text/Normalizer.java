/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.text;

import jdk.internal.icu.lang.UCharacter;
import jdk.internal.icu.text.NormalizerBase;

/**
 * This Normalizer is for Unicode 3.2 support for IDNA only.
 * Developers should not use this class.
 *
 * @since 1.6
 */
public final class Normalizer {

    private Normalizer() {};

    /**
     * Option to select Unicode 3.2 (without corrigendum 4 corrections) for
     * normalization.
     */
    public static final int UNICODE_3_2 = NormalizerBase.UNICODE_3_2_0_ORIGINAL;

    /**
     * Normalize a sequence of char values.
     * The sequence will be normalized according to the specified normalization
     * from.
     * @param src        The sequence of char values to normalize.
     * @param form       The normalization form; one of
     *                   {@link java.text.Normalizer.Form#NFC},
     *                   {@link java.text.Normalizer.Form#NFD},
     *                   {@link java.text.Normalizer.Form#NFKC},
     *                   {@link java.text.Normalizer.Form#NFKD}
     * @param option     The normalization option;
     *                   {@link sun.text.Normalizer#UNICODE_3_2}
     * @return The normalized String
     * @throws NullPointerException If <code>src</code> or <code>form</code>
     * is null.
     */
    public static String normalize(CharSequence src,
                                   java.text.Normalizer.Form form,
                                   int option) {
        return NormalizerBase.normalize(src.toString(), form, option);
    };

    /**
     * Determines if the given sequence of char values is normalized.
     * @param src        The sequence of char values to be checked.
     * @param form       The normalization form; one of
     *                   {@link java.text.Normalizer.Form#NFC},
     *                   {@link java.text.Normalizer.Form#NFD},
     *                   {@link java.text.Normalizer.Form#NFKC},
     *                   {@link java.text.Normalizer.Form#NFKD}
     * @param option     The normalization option;
     *                   {@link sun.text.Normalizer#UNICODE_3_2}
     * @return true if the sequence of char values is normalized;
     * false otherwise.
     * @throws NullPointerException If <code>src</code> or <code>form</code>
     * is null.
     */
    public static boolean isNormalized(CharSequence src,
                                       java.text.Normalizer.Form form,
                                       int option) {
        return NormalizerBase.isNormalized(src.toString(), form, option);
    }

    /**
     * Returns the combining class of the given character
     * @param ch character to retrieve combining class of
     * @return combining class of the given character
     */
    public static final int getCombiningClass(int ch) {
        return UCharacter.getCombiningClass(ch);
    }
}
