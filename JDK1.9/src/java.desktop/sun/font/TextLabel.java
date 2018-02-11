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
 * (C) Copyright IBM Corp. 1998-2003 All Rights Reserved
 */

package sun.font;

import java.awt.Graphics2D;
import java.awt.Shape;

import java.awt.geom.Rectangle2D;

/**
 * A label.
 * Visual bounds is a rect that encompasses the entire rendered area.
 * Logical bounds is a rect that defines how to position this next
 * to other objects.
 * Align bounds is a rect that defines how to align this to margins.
 * it generally allows some overhang that logical bounds would prevent.
 */
public abstract class TextLabel {

  /**
   * Return a rectangle that surrounds the text outline when this label is rendered at x, y.
   */
  public abstract Rectangle2D getVisualBounds(float x, float y);

  /**
   * Return a rectangle that corresponds to the logical bounds of the text
   * when this label is rendered at x, y.
   * This rectangle is used when positioning text next to other text.
   */
  public abstract Rectangle2D getLogicalBounds(float x, float y);

  /**
   * Return a rectangle that corresponds to the alignment bounds of the text
   * when this label is rendered at x, y. This rectangle is used when positioning text next
   * to a margin.  It differs from the logical bounds in that it does not include leading or
   * trailing whitespace.
   */
  public abstract Rectangle2D getAlignBounds(float x, float y);

  /**
   * Return a rectangle that corresponds to the logical bounds of the text, adjusted
   * to angle the leading and trailing edges by the italic angle.
   */
  public abstract Rectangle2D getItalicBounds(float x, float y);

  /**
   * Return an outline of the characters in the label when rendered at x, y.
   */
  public abstract Shape getOutline(float x, float y);

  /**
   * Render the label at x, y in the graphics.
   */
  public abstract void draw(Graphics2D g, float x, float y);

  /**
   * A convenience method that returns the visual bounds when rendered at 0, 0.
   */
  public Rectangle2D getVisualBounds() {
    return getVisualBounds(0f, 0f);
  }

  /**
   * A convenience method that returns the logical bounds when rendered at 0, 0.
   */
  public Rectangle2D getLogicalBounds() {
    return getLogicalBounds(0f, 0f);
  }

  /**
   * A convenience method that returns the align bounds when rendered at 0, 0.
   */
  public Rectangle2D getAlignBounds() {
    return getAlignBounds(0f, 0f);
  }

  /**
   * A convenience method that returns the italic bounds when rendered at 0, 0.
   */
  public Rectangle2D getItalicBounds() {
    return getItalicBounds(0f, 0f);
  }

  /**
   * A convenience method that returns the outline when rendered at 0, 0.
   */
  public Shape getOutline() {
    return getOutline(0f, 0f);
  }

  /**
   * A convenience method that renders the label at 0, 0.
   */
  public void draw(Graphics2D g) {
    draw(g, 0f, 0f);
  }
}
