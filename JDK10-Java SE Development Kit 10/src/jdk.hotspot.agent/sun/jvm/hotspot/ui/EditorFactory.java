/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.ui;

import javax.swing.JComponent;

/** An EditorFactory is the basis of pluggable editor components. One
    can configure the debugger with a new EditorFactory, which
    completely replaces how the debugger displays source code. */

public interface EditorFactory {
  /** Opens the given file in a new window. The debugger has already
      taken care of ensuring that the file can be found. The debugger
      will typically not create two Editor objects for the same source
      file, as it keeps track of open files. The EditorCommands object
      provided to the Editor by the debugger allows the Editor to
      notify the debugger of events such as a breakpoint being set or
      a window being closed. */
  public Editor openFile(String filename, EditorCommands commands);

  /** Retrieves the current topmost file of all of the Editors this
      EditorFactory has opened. This is used for the debugger user
      interface to request that a breakpoint be set. (Editors can also
      request that breakpoints be set via the EditorCommands, but this
      is intended to support external editors with their own
      keystrokes for performing this operation.) Returns null if there
      is no file currently being edited. */
  public Editor getCurrentEditor();
}
