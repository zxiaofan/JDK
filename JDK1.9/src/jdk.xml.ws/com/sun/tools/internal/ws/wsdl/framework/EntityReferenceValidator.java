/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.ws.wsdl.framework;

import javax.xml.namespace.QName;

/**
 * An interface implemented by a class that is capable of validating
 * a QName/Kind pair referring to an external entity.
 *
 * @author WS Development Team
 */
public interface EntityReferenceValidator {
    public boolean isValid(Kind kind, QName name);
}
