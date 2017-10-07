/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package jdk.nashorn.api.tree;

import java.util.List;
import java.util.stream.Collectors;
import jdk.nashorn.internal.ir.FunctionNode;
import jdk.nashorn.internal.ir.IdentNode;
import jdk.nashorn.internal.ir.Module;
import static jdk.nashorn.api.tree.ModuleTreeImpl.identOrNull;

final class ExportEntryTreeImpl extends TreeImpl implements ExportEntryTree {
    private final long startPos, endPos;
    private final IdentifierTree exportName;
    private final IdentifierTree moduleRequest;
    private final IdentifierTree importName;
    private final IdentifierTree localName;

    private ExportEntryTreeImpl(final long startPos, final long endPos,
            final IdentifierTree exportName,
            final IdentifierTree moduleRequest,
            final IdentifierTree importName,
            final IdentifierTree localName) {
        super(null); // no underlying Node!
        this.startPos = startPos;
        this.endPos = endPos;
        this.exportName = exportName;
        this.moduleRequest = moduleRequest;
        this.importName = importName;
        this.localName = localName;
    }

    private static ExportEntryTreeImpl createExportEntry(final Module.ExportEntry entry) {
        return new ExportEntryTreeImpl(entry.getStartPosition(),
                entry.getEndPosition(),
                identOrNull(entry.getExportName()),
                identOrNull(entry.getModuleRequest()),
                identOrNull(entry.getImportName()),
                identOrNull(entry.getLocalName()));
    }

    static List<ExportEntryTreeImpl> createExportList(final List<Module.ExportEntry> exportList) {
        return exportList.stream().
            map(ExportEntryTreeImpl::createExportEntry).
            collect(Collectors.toList());
    }

    @Override
    public Kind getKind() {
        return Tree.Kind.EXPORT_ENTRY;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitExportEntry(this, data);
    }

    @Override
    public long getStartPosition() {
        return startPos;
    }

    @Override
    public long getEndPosition() {
        return endPos;
    }

    @Override
    public IdentifierTree getExportName() {
        return exportName;
    }

    @Override
    public IdentifierTree getModuleRequest() {
        return moduleRequest;
    }

    @Override
    public IdentifierTree getImportName() {
        return importName;
    }

    @Override
    public IdentifierTree getLocalName() {
        return localName;
    }
}
