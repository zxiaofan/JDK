/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.buffer;

import java.util.Map;

/**
 * A mark into a buffer.
 *
 * <p>
 * A mark can be processed in the same manner as a XMLStreamBuffer.
 *
 * <p>
 * A mark will share a sub set of information of the buffer that is
 * marked. If the buffer is directly or indirectly associated with a
 * (mutable) {@link XMLStreamBuffer} which is reset and/or re-created
 * then this will invalidate the mark and processing behvaiour of the mark
 * is undefined. It is the responsibility of the application to manage the
 * relationship between the marked XMLStreamBuffer and one or more marks.
 */
public class XMLStreamBufferMark extends XMLStreamBuffer {

    /**
     * Create a mark from the buffer that is being created.
     *
     * <p>
     * A mark will be created from the current position of creation of the
     * {@link XMLStreamBuffer} that is being created by a {@link AbstractCreator}.
     *
     * @param inscopeNamespaces
     * The in-scope namespaces on the fragment of XML infoset that is
     * to be marked.
     *
     * @param src
     * The {@link AbstractCreator} or {@link AbstractProcessor} from which the current
     * position of creation of the XMLStreamBuffer will be taken as the mark.
     */
    public XMLStreamBufferMark(Map<String,String> inscopeNamespaces, AbstractCreatorProcessor src) {
        if(inscopeNamespaces != null) {
            _inscopeNamespaces = inscopeNamespaces;
        }

        _structure = src._currentStructureFragment;
        _structurePtr = src._structurePtr;

        _structureStrings = src._currentStructureStringFragment;
        _structureStringsPtr = src._structureStringsPtr;

        _contentCharactersBuffer = src._currentContentCharactersBufferFragment;
        _contentCharactersBufferPtr = src._contentCharactersBufferPtr;

        _contentObjects = src._currentContentObjectFragment;
        _contentObjectsPtr = src._contentObjectsPtr;
        treeCount = 1; // TODO: define a way to create a mark over a forest
    }
}
