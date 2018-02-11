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

package com.sun.xml.internal.bind.v2.runtime;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.v2.util.QNameMap;

/**
 * Creates {@link Name}s and assign index numbers to them.
 *
 * <p>
 * During this process, this class also finds out which namespace URIs
 * are statically known to be un-bindable as the default namespace.
 * Those are the namespace URIs that are used by attribute names.
 *
 * @author Kohsuke Kawaguchi
 */
@SuppressWarnings({"StringEquality"})
public final class NameBuilder {
    private Map<String,Integer> uriIndexMap = new HashMap<String, Integer>();
    private Set<String> nonDefaultableNsUris = new HashSet<String>();
    private Map<String,Integer> localNameIndexMap = new HashMap<String, Integer>();
    private QNameMap<Integer> elementQNameIndexMap = new QNameMap<Integer>();
    private QNameMap<Integer> attributeQNameIndexMap = new QNameMap<Integer>();

    public Name createElementName(QName name) {
        return createElementName(name.getNamespaceURI(),name.getLocalPart());
    }

    public Name createElementName(String nsUri, String localName) {
        return createName(nsUri, localName, false, elementQNameIndexMap);
    }

    public Name createAttributeName(QName name) {
        return createAttributeName(name.getNamespaceURI(),name.getLocalPart());
    }

    public Name createAttributeName(String nsUri, String localName) {
        assert nsUri.intern()==nsUri;
        assert localName.intern()==localName;

        if(nsUri.length()==0)
            return new Name(
                    allocIndex(attributeQNameIndexMap,"",localName),
                    -1,
                    nsUri,
                    allocIndex(localNameIndexMap,localName),
                    localName,
                    true);
        else {
            nonDefaultableNsUris.add(nsUri);
            return createName(nsUri,localName, true, attributeQNameIndexMap);
        }
    }

    private Name createName(String nsUri, String localName, boolean isAttribute, QNameMap<Integer> map) {
        assert nsUri.intern()==nsUri;
        assert localName.intern()==localName;

        return new Name(
                allocIndex(map,nsUri,localName),
                allocIndex(uriIndexMap,nsUri),
                nsUri,
                allocIndex(localNameIndexMap,localName),
                localName,
                isAttribute );
    }

    private int allocIndex(Map<String,Integer> map, String str) {
        Integer i = map.get(str);
        if(i==null) {
            i = map.size();
            map.put(str,i);
        }
        return i;
    }

    private int allocIndex(QNameMap<Integer> map, String nsUri, String localName) {
        Integer i = map.get(nsUri,localName);
        if(i==null) {
            i = map.size();
            map.put(nsUri,localName,i);
        }
        return i;
    }

    /**
     * Wraps up everything and creates {@link NameList}.
     */
    public NameList conclude() {
        boolean[] nsUriCannotBeDefaulted = new boolean[uriIndexMap.size()];
        for (Map.Entry<String,Integer> e : uriIndexMap.entrySet()) {
            nsUriCannotBeDefaulted[e.getValue()] = nonDefaultableNsUris.contains(e.getKey());
        }

        NameList r = new NameList(
                list(uriIndexMap),
                nsUriCannotBeDefaulted,
                list(localNameIndexMap),
                elementQNameIndexMap.size(),
                attributeQNameIndexMap.size() );
        // delete them so that the create method can never be called again
        uriIndexMap = null;
        localNameIndexMap = null;
        return r;
    }

    private String[] list(Map<String, Integer> map) {
        String[] r = new String[map.size()];
        for (Map.Entry<String, Integer> e : map.entrySet())
            r[e.getValue()] = e.getKey();
        return r;
    }
}
