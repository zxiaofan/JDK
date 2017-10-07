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

package com.sun.tools.internal.ws.processor.model;

import com.sun.tools.internal.ws.wsdl.framework.Entity;
import com.sun.tools.internal.ws.wscompile.ErrorReceiver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author WS Development Team
 */
public class Response extends Message {

    public Response(com.sun.tools.internal.ws.wsdl.document.Message entity, ErrorReceiver receiver) {
        super(entity, receiver);
    }

    public void addFaultBlock(Block b) {
        if (_faultBlocks.containsKey(b.getName())) {
            throw new ModelException("model.uniqueness");
        }
        _faultBlocks.put(b.getName(), b);
    }

    public Iterator getFaultBlocks() {
        return _faultBlocks.values().iterator();
    }

    public int getFaultBlockCount () {
        return _faultBlocks.size();
    }

    /* serialization */
    public Map getFaultBlocksMap() {
        return _faultBlocks;
    }

    public void setFaultBlocksMap(Map m) {
        _faultBlocks = m;
    }

    public void accept(ModelVisitor visitor) throws Exception {
        visitor.visit(this);
    }

    private Map _faultBlocks = new HashMap();
}
