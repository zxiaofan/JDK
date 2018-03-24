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

/** The debugger supplies an implementation of this interface to
    Editors it requests be opened by the EditorFactory. Using this
    object the Editor can communicate with the debugger. */

public interface EditorCommands {
  /** Notifies the debugger that the editing window has been closed. */
  public void windowClosed(Editor editor);

  /** Toggles a breakpoint at the given (one-based) line */
  public void toggleBreakpointAtLine(Editor editor, int lineNumber);
}
