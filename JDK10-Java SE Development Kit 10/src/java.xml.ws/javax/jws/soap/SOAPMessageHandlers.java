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
 * @deprecated
 */
@Retention(value=RetentionPolicy.RUNTIME)
@Target({TYPE})
@Deprecated public @interface SOAPMessageHandlers {
    SOAPMessageHandler[] value();
}
