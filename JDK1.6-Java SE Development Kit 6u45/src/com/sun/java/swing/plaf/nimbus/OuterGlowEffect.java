/*
 * %W% %E%
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.java.swing.plaf.nimbus;

import java.awt.Color;

/**
 * InnerGlowEffect
 *
 * @author Created by Jasper Potts (Jun 21, 2007)
 * @version 1.0
 */
class OuterGlowEffect extends DropShadowEffect {
    OuterGlowEffect() {
        distance = 0;
        color = new Color(255, 255, 211);
    }
}
