/*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * $Id: AttributeList.java,v 1.2.4.1 2005/09/06 10:50:13 pvedula Exp $
 */

package com.sun.org.apache.xalan.internal.xsltc.runtime;

import java.util.Vector;

/**
 * @author Morten Jorgensen
 */
public class AttributeList implements org.xml.sax.Attributes {

    private final static String EMPTYSTRING = "";
    private final static String CDATASTRING = "CDATA";

    private Hashtable _attributes;
    private Vector    _names;
    private Vector    _qnames;
    private Vector    _values;
    private Vector    _uris;
    private int       _length;

    /**
     * AttributeList constructor
     */
    public AttributeList() {
	/*
	_attributes = new Hashtable();
	_names  = new Vector();
	_values = new Vector();
	_qnames = new Vector();
	_uris   = new Vector();
	*/
	_length = 0;
    }

    /**
     * Attributes clone constructor
     */
    public AttributeList(org.xml.sax.Attributes attributes) {
	this();
	if (attributes != null) {
	    final int count = attributes.getLength();
	    for (int i = 0; i < count; i++) {
		add(attributes.getQName(i),attributes.getValue(i));
	    }
	}
    }
    
    /**
     * Allocate memory for the AttributeList
     * %OPT% Use on-demand allocation for the internal vectors. The memory
     * is only allocated when there is an attribute. This reduces the cost 
     * of creating many small RTFs.
     */
    private void alloc() {
	_attributes = new Hashtable();
	_names  = new Vector();
	_values = new Vector();
	_qnames = new Vector();
	_uris   = new Vector();        
    }

    /**
     * SAX2: Return the number of attributes in the list. 
     */
    public int getLength() {
	return(_length);
    }

    /**
     * SAX2: Look up an attribute's Namespace URI by index.
     */
    public String getURI(int index) {
	if (index < _length)
	    return((String)_uris.elementAt(index));
	else
	    return(null);
    }

    /**
     * SAX2: Look up an attribute's local name by index.
     */
    public String getLocalName(int index) {
	if (index < _length)
	    return((String)_names.elementAt(index));
	else
	    return(null);
    }

    /**
     * Return the name of an attribute in this list (by position).
     */
    public String getQName(int pos) {
	if (pos < _length)
	    return((String)_qnames.elementAt(pos));
	else
	    return(null);
    }

    /**
     * SAX2: Look up an attribute's type by index.
     */
    public String getType(int index) {
	return(CDATASTRING);
    }

    /**
     * SAX2: Look up the index of an attribute by Namespace name.
     */
    public int getIndex(String namespaceURI, String localPart) {
	return(-1);
    }

    /**
     * SAX2: Look up the index of an attribute by XML 1.0 qualified name.
     */
    public int getIndex(String qname) {
	return(-1);
    }

    /**
     * SAX2: Look up an attribute's type by Namespace name.
     */
    public String getType(String uri, String localName) {
	return(CDATASTRING);
    }

    /**
     * SAX2: Look up an attribute's type by qname.
     */
    public String getType(String qname) {
	return(CDATASTRING);
    }

    /**
     * SAX2: Look up an attribute's value by index.
     */
    public String getValue(int pos) {
	if (pos < _length)
	    return((String)_values.elementAt(pos));
	else
	    return(null);
    }

    /**
     * SAX2: Look up an attribute's value by qname.
     */
    public String getValue(String qname) {
	if (_attributes != null) {
	    final Integer obj = (Integer)_attributes.get(qname);
	    if (obj == null) return null;
	    return(getValue(obj.intValue()));
	}
	else
	    return null;
    }

    /**
     * SAX2: Look up an attribute's value by Namespace name - SLOW!
     */
    public String getValue(String uri, String localName) {
	return(getValue(uri+':'+localName));
    }

    /**
     * Adds an attribute to the list
     */
    public void add(String qname, String value) {
	// Initialize the internal vectors at the first usage.
	if (_attributes == null)
	    alloc();
	
	// Stuff the QName into the names vector & hashtable
	Integer obj = (Integer)_attributes.get(qname);
	if (obj == null) {
	    _attributes.put(qname, obj = new Integer(_length++));
	    _qnames.addElement(qname);
	    _values.addElement(value);
	    int col = qname.lastIndexOf(':');
	    if (col > -1) {
		_uris.addElement(qname.substring(0,col));
		_names.addElement(qname.substring(col+1));
	    }
	    else {
		_uris.addElement(EMPTYSTRING);
		_names.addElement(qname);
	    }
	}
	else {
	    final int index = obj.intValue();
	    _values.set(index, value);
	}
    }

    /**
     * Clears the attribute list
     */
    public void clear() {
	_length = 0;
	if (_attributes != null) {
	    _attributes.clear();
	    _names.removeAllElements();
	    _values.removeAllElements();
	    _qnames.removeAllElements();
	    _uris.removeAllElements();
	}
    }
    
}
