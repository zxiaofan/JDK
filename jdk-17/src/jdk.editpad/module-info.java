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

/**
 * Provides the implementation of the edit pad service used by {@link jdk.jshell}.
 *
 * @moduleGraph
 * @since 9
 */
module jdk.editpad {
    requires java.desktop;
    requires jdk.internal.ed;

    provides jdk.internal.editor.spi.BuildInEditorProvider with
        jdk.editpad.EditPadProvider;
}
