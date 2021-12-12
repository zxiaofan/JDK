/*
 * Copyright (c) 1998, 2003, Oracle and/or its affiliates. All rights reserved.
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
/*
 *
 * (C) Copyright IBM Corp. 1998-2003 - All Rights Reserved
 */

package sun.font;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

/**
 * A text source represents text for rendering, plus context information.
 * All text in the source uses the same font, metrics, and render context,
 * and is at the same bidi level.
 */

public abstract class TextSource {
  /** Source character data. */
  public abstract char[] getChars();

  /** Start of source data in char array returned from getChars. */
  public abstract int getStart();

  /** Length of source data. */
  public abstract int getLength();

  /** Start of context data in char array returned from getChars. */
  public abstract int getContextStart();

  /** Length of context data. */
  public abstract int getContextLength();

  /** Return the layout flags */
  public abstract int getLayoutFlags();

  /** Bidi level of all the characters in context. */
  public abstract int getBidiLevel();

  /** Font for source data. */
  public abstract Font getFont();

  /** Font render context to use when measuring or rendering source data. */
  public abstract FontRenderContext getFRC();

  /** Line metrics for source data. */
  public abstract CoreMetrics getCoreMetrics();

  /** Get subrange of this TextSource. dir is one of the TextLineComponent constants */
  public abstract TextSource getSubSource(int start, int length, int dir);

  /** Constant for toString(boolean).  Indicates that toString should not return info
      outside of the context of this instance. */
  public static final boolean WITHOUT_CONTEXT = false;

  /** Constant for toString(boolean).  Indicates that toString should return info
      outside of the context of this instance. */
  public static final boolean WITH_CONTEXT = true;

  /** Get debugging info about this TextSource instance. Default implementation just
      returns toString.  Subclasses should implement this to match the semantics of
      the toString constants. */
  public abstract String toString(boolean withContext);
}
