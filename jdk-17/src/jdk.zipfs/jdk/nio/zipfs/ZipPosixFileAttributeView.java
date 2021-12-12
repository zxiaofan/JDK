/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nio.zipfs;

import java.io.IOException;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.UserPrincipal;

/**
 * The zip file system attribute view with POSIX support.
 */
class ZipPosixFileAttributeView extends ZipFileAttributeView implements PosixFileAttributeView {
    private final boolean isOwnerView;

    ZipPosixFileAttributeView(ZipPath path, boolean owner) {
        super(path, true);
        this.isOwnerView = owner;
    }

    @Override
    public String name() {
        return isOwnerView ? "owner" : "posix";
    }

    @Override
    public PosixFileAttributes readAttributes() throws IOException {
        return (PosixFileAttributes)path.readAttributes();
    }

    @Override
    public UserPrincipal getOwner() throws IOException {
        return readAttributes().owner();
    }

    @Override
    public void setOwner(UserPrincipal owner) throws IOException {
        path.setOwner(owner);
    }

    @Override
    public void setGroup(GroupPrincipal group) throws IOException {
        path.setGroup(group);
    }

    @Override
    Object attribute(AttrID id, ZipFileAttributes zfas) {
        PosixFileAttributes pzfas = (PosixFileAttributes)zfas;
        switch (id) {
        case owner:
            return pzfas.owner();
        case group:
            return pzfas.group();
        case permissions:
            if (!isOwnerView) {
                return pzfas.permissions();
            } else {
                return super.attribute(id, zfas);
            }
        default:
            return super.attribute(id, zfas);
        }
    }
}
