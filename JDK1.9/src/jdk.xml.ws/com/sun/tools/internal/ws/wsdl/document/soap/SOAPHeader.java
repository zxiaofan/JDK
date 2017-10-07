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

package com.sun.tools.internal.ws.wsdl.document.soap;

import com.sun.tools.internal.ws.wsdl.framework.*;
import org.xml.sax.Locator;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A SOAP header extension.
 *
 * @author WS Development Team
 */
public class SOAPHeader extends ExtensionImpl {

    public SOAPHeader(Locator locator) {
        super(locator);
        _faults = new ArrayList();
    }

    public void add(SOAPHeaderFault fault) {
        _faults.add(fault);
    }

    public Iterator faults() {
        return _faults.iterator();
    }

    public QName getElementName() {
        return SOAPConstants.QNAME_HEADER;
    }

    public String getNamespace() {
        return _namespace;
    }

    public void setNamespace(String s) {
        _namespace = s;
    }

    public SOAPUse getUse() {
        return _use;
    }

    public void setUse(SOAPUse u) {
        _use = u;
    }

    public boolean isEncoded() {
        return _use == SOAPUse.ENCODED;
    }

    public boolean isLiteral() {
        return _use == SOAPUse.LITERAL;
    }

    public String getEncodingStyle() {
        return _encodingStyle;
    }

    public void setEncodingStyle(String s) {
        _encodingStyle = s;
    }

    public String getPart() {
        return _part;
    }

    public void setMessage(QName message) {
        _message = message;
    }

    public QName getMessage() {
        return _message;
    }

    public void setPart(String s) {
        _part = s;
    }

    public void withAllSubEntitiesDo(EntityAction action) {
        super.withAllSubEntitiesDo(action);

        for (Iterator iter = _faults.iterator(); iter.hasNext();) {
            action.perform((Entity) iter.next());
        }
    }

    public void withAllQNamesDo(QNameAction action) {
        super.withAllQNamesDo(action);

        if (_message != null) {
            action.perform(_message);
        }
    }

    public void accept(ExtensionVisitor visitor) throws Exception {
        visitor.preVisit(this);
        for (Iterator iter = _faults.iterator(); iter.hasNext();) {
            ((SOAPHeaderFault) iter.next()).accept(visitor);
        }
        visitor.postVisit(this);
    }

    public void validateThis() {
        if (_message == null) {
            failValidation("validation.missingRequiredAttribute", "message");
        }
        if (_part == null) {
            failValidation("validation.missingRequiredAttribute", "part");
        }
        // Fix for bug 4851427
        //        if (_use == null) {
        //            failValidation("validation.missingRequiredAttribute", "use");
        //        }

        if(_use == SOAPUse.ENCODED) {
            throw new ValidationException("validation.unsupportedUse.encoded", getLocator().getLineNumber(),getLocator().getSystemId());
        }
    }

    private String _encodingStyle;
    private String _namespace;
    private String _part;
    private QName _message;
    private SOAPUse _use=SOAPUse.LITERAL;
    private List _faults;
}
