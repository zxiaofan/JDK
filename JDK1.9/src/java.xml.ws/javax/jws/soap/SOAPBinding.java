/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package javax.jws.soap;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

/**
 * @since 1.6
 */
@Retention(value=RetentionPolicy.RUNTIME)
@Target({TYPE,METHOD})
public @interface SOAPBinding {

    public enum Style {
       DOCUMENT,
       RPC
    };

    public enum Use {
        LITERAL,
        ENCODED
    };

    public enum ParameterStyle {
        BARE,
        WRAPPED
    };

    Style style() default Style.DOCUMENT;
    Use use() default Use.LITERAL;
    ParameterStyle parameterStyle() default ParameterStyle.WRAPPED;
}
