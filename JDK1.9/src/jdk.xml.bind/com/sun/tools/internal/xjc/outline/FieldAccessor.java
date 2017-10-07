/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.codemodel.internal.JBlock;
import com.sun.codemodel.internal.JExpression;
import com.sun.codemodel.internal.JVar;
import com.sun.tools.internal.xjc.model.CPropertyInfo;

/**
 * Encapsulates the access on a field.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface FieldAccessor {

    /**
     * Dumps everything in this field into the given variable.
     *
     * <p>
     * This generates code that accesses the field from outside.
     *
     * @param block
     *      The code will be generated into this block.
     * @param $var
     *      Variable whose type is {@link FieldOutline#getRawType()}
     */
    void toRawValue( JBlock block, JVar $var );

    /**
     * Sets the value of the field from the specified expression.
     *
     * <p>
     * This generates code that accesses the field from outside.
     *
     * @param block
     *      The code will be generated into this block.
     * @param uniqueName
     *      Identifier that the caller guarantees to be unique in
     *      the given block. When the callee needs to produce additional
     *      variables, it can do so by adding suffixes to this unique
     *      name. For example, if the uniqueName is "abc", then the
     *      caller guarantees that any identifier "abc.*" is unused
     *      in this block.
     * @param $var
     *      The expression that evaluates to a value of the type
     *      {@link FieldOutline#getRawType()}.
     */
    void fromRawValue( JBlock block, String uniqueName, JExpression $var );

    /**
     * Generates a code fragment to remove any "set" value
     * and move this field to the "unset" state.
     *
     * @param body
     *      The code will be appended at the end of this block.
     */
    void unsetValues( JBlock body );

    /**
     * Return an expression that evaluates to true only when
     * this field has a set value(s).
     *
     * @return null
     *      if the isSetXXX/unsetXXX method does not make sense
     *      for the given field.
     */
    JExpression hasSetValue();

    /**
     * Gets the {@link FieldOutline} from which
     * this object is created.
     */
    FieldOutline owner();

    /**
     * Short for {@code owner().getPropertyInfo()}
     */
    CPropertyInfo getPropertyInfo();
}
