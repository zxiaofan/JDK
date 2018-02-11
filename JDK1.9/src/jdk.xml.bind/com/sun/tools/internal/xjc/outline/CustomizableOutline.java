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

package com.sun.tools.internal.xjc.outline;

import com.sun.codemodel.internal.JDefinedClass;
import com.sun.istack.internal.NotNull;
import com.sun.tools.internal.xjc.model.CCustomizable;

/**
 * This interface describes that outline class could be customized.
 * It provides the bound info from {@link CCustomizable} target. And
 * customization output - implementation class.
 *
 * @author yaroska
 * @since 2.2.12
 */
public interface CustomizableOutline {

    /**
     * Provides bound information about customizable target.
     * @return customizable target
     */
    @NotNull CCustomizable getTarget();

    /**
     * Provides customization output.
     * @return Implementation class
     */
    @NotNull JDefinedClass getImplClass();
}
