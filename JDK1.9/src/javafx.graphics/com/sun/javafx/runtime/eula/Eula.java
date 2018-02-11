/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.runtime.eula;

/**
 * A simple interface to show the End User License Agreement(EULA) dialog
 */
public interface Eula {

        /**
         * display the eula dialog, if not already shown
         * @return false if eula was rejected, true otherwise
         */
        public boolean show();

        /**
         * accept the EULA, so no EULA dialog will be displayed
         */
        public void accept();

}

