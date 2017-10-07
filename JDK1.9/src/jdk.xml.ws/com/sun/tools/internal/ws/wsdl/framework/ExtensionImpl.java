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

import com.sun.tools.internal.ws.api.wsdl.TWSDLExtensible;
import com.sun.tools.internal.ws.api.wsdl.TWSDLExtension;
import org.xml.sax.Locator;

/**
 * An entity extending another entity.
 *
 * @author WS Development Team
 */
public abstract class ExtensionImpl extends Entity implements TWSDLExtension {

    public ExtensionImpl(Locator locator) {
        super(locator);
    }

    public TWSDLExtensible getParent() {
        return _parent;
    }

    public void setParent(TWSDLExtensible parent) {
        _parent = parent;
    }

    public void accept(ExtensionVisitor visitor) throws Exception {
        visitor.preVisit(this);
        visitor.postVisit(this);
    }

    private TWSDLExtensible _parent;
}
