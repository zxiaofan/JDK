/*
 * Copyright (c) 2008, 2011, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.fs;

import java.nio.file.attribute.*;
import java.util.*;
import java.io.IOException;

/**
 * An implementation of FileOwnerAttributeView that delegates to a given
 * PosixFileAttributeView or AclFileAttributeView object.
 */

final class FileOwnerAttributeViewImpl
    implements FileOwnerAttributeView, DynamicFileAttributeView
{
    private static final String OWNER_NAME = "owner";

    private final FileAttributeView view;
    private final boolean isPosixView;

    FileOwnerAttributeViewImpl(PosixFileAttributeView view) {
        this.view = view;
        this.isPosixView = true;
    }

    FileOwnerAttributeViewImpl(AclFileAttributeView view) {
        this.view = view;
        this.isPosixView = false;
    }

    @Override
    public String name() {
        return "owner";
    }

    @Override
    public void setAttribute(String attribute, Object value)
        throws IOException
    {
        if (attribute.equals(OWNER_NAME)) {
            setOwner((UserPrincipal)value);
        } else {
            throw new IllegalArgumentException("'" + name() + ":" +
                attribute + "' not recognized");
        }
    }

    @Override
    public Map<String,Object> readAttributes(String[] attributes) throws IOException {
        Map<String,Object> result = new HashMap<>();
        for (String attribute: attributes) {
            if (attribute.equals("*") || attribute.equals(OWNER_NAME)) {
                result.put(OWNER_NAME, getOwner());
            } else {
                throw new IllegalArgumentException("'" + name() + ":" +
                    attribute + "' not recognized");
            }
        }
        return result;
    }

    @Override
    public UserPrincipal getOwner() throws IOException {
        if (isPosixView) {
            return ((PosixFileAttributeView)view).readAttributes().owner();
        } else {
            return ((AclFileAttributeView)view).getOwner();
        }
    }

    @Override
    public void setOwner(UserPrincipal owner)
        throws IOException
    {
        if (isPosixView) {
            ((PosixFileAttributeView)view).setOwner(owner);
        } else {
            ((AclFileAttributeView)view).setOwner(owner);
        }
    }
 }
