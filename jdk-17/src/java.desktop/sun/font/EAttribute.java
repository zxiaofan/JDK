/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

/*
 *
 * (C) Copyright IBM Corp. 2005 - All Rights Reserved
 *
 * The original version of this source code and documentation is
 * copyrighted and owned by IBM. These materials are provided
 * under terms of a License Agreement between IBM and Sun.
 * This technology is protected by multiple US and International
 * patents. This notice and attribution to IBM may not be removed.
 */

package sun.font;

import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator.Attribute;

import static java.awt.font.TextAttribute.*;

public enum EAttribute {
    EFAMILY(FAMILY),
    EWEIGHT(WEIGHT),
    EWIDTH(WIDTH),
    EPOSTURE(POSTURE),
    ESIZE(SIZE),
    ETRANSFORM(TRANSFORM),
    ESUPERSCRIPT(SUPERSCRIPT),
    EFONT(FONT),
    ECHAR_REPLACEMENT(CHAR_REPLACEMENT),
    EFOREGROUND(FOREGROUND),
    EBACKGROUND(BACKGROUND),
    EUNDERLINE(UNDERLINE),
    ESTRIKETHROUGH(STRIKETHROUGH),
    ERUN_DIRECTION(RUN_DIRECTION),
    EBIDI_EMBEDDING(BIDI_EMBEDDING),
    EJUSTIFICATION(JUSTIFICATION),
    EINPUT_METHOD_HIGHLIGHT(INPUT_METHOD_HIGHLIGHT),
    EINPUT_METHOD_UNDERLINE(INPUT_METHOD_UNDERLINE),
    ESWAP_COLORS(SWAP_COLORS),
    ENUMERIC_SHAPING(NUMERIC_SHAPING),
    EKERNING(KERNING),
    ELIGATURES(LIGATURES),
    ETRACKING(TRACKING),
    EBASELINE_TRANSFORM(null);

    /* package */ final int mask;
    /* package */ final TextAttribute att;

    EAttribute(TextAttribute ta) {
        mask = 1 << ordinal();
        att = ta;
    }

    /* package */ static final EAttribute[] atts = EAttribute.class.getEnumConstants();

    public static EAttribute forAttribute(Attribute ta) {
        for (EAttribute ea: atts) {
            if (ea.att == ta) {
                return ea;
            }
        }
        return null;
    }

    public String toString() {
        return name().substring(1).toLowerCase();
    }
}
