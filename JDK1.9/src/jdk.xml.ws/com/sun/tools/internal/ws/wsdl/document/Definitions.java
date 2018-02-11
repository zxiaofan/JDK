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

package com.sun.tools.internal.ws.wsdl.document;

import com.sun.tools.internal.ws.api.wsdl.TWSDLExtensible;
import com.sun.tools.internal.ws.api.wsdl.TWSDLExtension;
import com.sun.tools.internal.ws.wsdl.framework.*;

import org.xml.sax.Locator;

import javax.xml.namespace.QName;
import java.util.*;

/**
 * Entity corresponding to the "definitions" WSDL element.
 *
 * @author WS Development Team
 */
public class Definitions extends Entity implements Defining, TWSDLExtensible {

    public Definitions(AbstractDocument document, Locator locator) {
        super(locator);
        _document = document;
        _bindings = new ArrayList();
        _imports = new ArrayList();
        _messages = new ArrayList();
        _portTypes = new ArrayList();
        _services = new ArrayList();
        _importedNamespaces = new HashSet();
        _helper = new ExtensibilityHelper();
    }

    public String getName() {
        return _name;
    }

    public void setName(String s) {
        _name = s;
    }

    public String getTargetNamespaceURI() {
        return _targetNsURI;
    }

    public void setTargetNamespaceURI(String s) {
        _targetNsURI = s;
    }

    public void setTypes(Types t) {
        _types = t;
    }

    public Types getTypes() {
        return _types;
    }

    public void add(Message m) {
        _document.define(m);
        _messages.add(m);
    }

    public void add(PortType p) {
        _document.define(p);
        _portTypes.add(p);
    }

    public void add(Binding b) {
        _document.define(b);
        _bindings.add(b);
    }

    public void add(Service s) {
        _document.define(s);
        _services.add(s);
    }

    public void addServiceOveride(Service s) {
        _services.add(s);
    }

    public void add(Import i) {
        _imports.add(i);
        _importedNamespaces.add(i.getNamespace());
    }

    public Iterator imports() {
        return _imports.iterator();
    }

    public Iterator messages() {
        return _messages.iterator();
    }

    public Iterator portTypes() {
        return _portTypes.iterator();
    }

    public Iterator bindings() {
        return _bindings.iterator();
    }

    public Iterator<Service> services() {
        return _services.iterator();
    }

    public String getNameValue() {
        return getName();
    }

    public String getNamespaceURI() {
        return getTargetNamespaceURI();
    }

    public QName getWSDLElementName() {
        return WSDLConstants.QNAME_DEFINITIONS;
    }

    public Documentation getDocumentation() {
        return _documentation;
    }

    public void setDocumentation(Documentation d) {
        _documentation = d;
    }

    public void addExtension(TWSDLExtension e) {
        _helper.addExtension(e);
    }

    public Iterable<TWSDLExtension> extensions() {
        return _helper.extensions();
    }

    /**
     * wsdl:definition is the root hence no parent so return null.
     */
    public TWSDLExtensible getParent() {
        return null;
    }

    public void withAllSubEntitiesDo(EntityAction action) {
        if (_types != null) {
            action.perform(_types);
        }
        for (Iterator iter = _messages.iterator(); iter.hasNext();) {
            action.perform((Entity) iter.next());
        }
        for (Iterator iter = _portTypes.iterator(); iter.hasNext();) {
            action.perform((Entity) iter.next());
        }
        for (Iterator iter = _bindings.iterator(); iter.hasNext();) {
            action.perform((Entity) iter.next());
        }
        for (Iterator iter = _services.iterator(); iter.hasNext();) {
            action.perform((Entity) iter.next());
        }
        for (Iterator iter = _imports.iterator(); iter.hasNext();) {
            action.perform((Entity) iter.next());
        }
        _helper.withAllSubEntitiesDo(action);
    }

    public void accept(WSDLDocumentVisitor visitor) throws Exception {
        visitor.preVisit(this);

        for (Iterator iter = _imports.iterator(); iter.hasNext();) {
            ((Import) iter.next()).accept(visitor);
        }

        if (_types != null) {
            _types.accept(visitor);
        }

        for (Iterator iter = _messages.iterator(); iter.hasNext();) {
            ((Message) iter.next()).accept(visitor);
        }
        for (Iterator iter = _portTypes.iterator(); iter.hasNext();) {
            ((PortType) iter.next()).accept(visitor);
        }
        for (Iterator iter = _bindings.iterator(); iter.hasNext();) {
            ((Binding) iter.next()).accept(visitor);
        }
        for (Iterator iter = _services.iterator(); iter.hasNext();) {
            ((Service) iter.next()).accept(visitor);
        }

        _helper.accept(visitor);
        visitor.postVisit(this);
    }

    public void validateThis() {
    }

    public Map resolveBindings() {
        return _document.getMap(Kinds.BINDING);
    }

    private AbstractDocument _document;
    private ExtensibilityHelper _helper;
    private Documentation _documentation;
    private String _name;
    private String _targetNsURI;
    private Types _types;
    private List _messages;
    private List _portTypes;
    private List _bindings;
    private List<Service> _services;
    private List _imports;
    private Set _importedNamespaces;

    public QName getElementName() {
        return getWSDLElementName();
    }
}
