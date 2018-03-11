/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.xml.ws;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * The <code>WebServiceRefs</code> annotation allows
 * multiple web service references to be declared at the
 * class level.
 *
 * @see javax.xml.ws.WebServiceRef
 * @since 2.0
 */

@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface WebServiceRefs {
   /**
    * Array used for multiple web service reference declarations.
    */
   WebServiceRef[] value();
}
