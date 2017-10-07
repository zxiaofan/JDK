/*
 * Copyright (c) 2012, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.control;

import javafx.beans.NamedArg;


/**
 * An immutable wrapper class for use by the column resize policies offered by
 * controls such as {@link TableView} and {@link TreeTableView}.
 * @since JavaFX 8.0
 */
public class ResizeFeaturesBase<S> {
  private final TableColumnBase<S,?> column;
  private final Double delta;

  /**
   * Creates an instance of this class, with the provided TableColumnBase and
   * delta values being set and stored in this immutable instance.
   *
   * @param column The column upon which the resize is occurring, or null
   *      if this ResizeFeatures instance is being created as a result of a
   *      resize operation.
   * @param delta The amount of horizontal space added or removed in the
   *      resize operation.
   */
  public ResizeFeaturesBase(@NamedArg("column") TableColumnBase<S,?> column, @NamedArg("delta") Double delta) {
      this.column = column;
      this.delta = delta;
  }

  /**
   * Returns the column upon which the resize is occurring, or null
   * if this ResizeFeatures instance was created as a result of a
   * resize operation.
   * @return the column upon which the resize is occurring
   */
  public TableColumnBase<S,?> getColumn() { return column; }

  /**
   * Returns the amount of horizontal space added or removed in the
   * resize operation.
   * @return the amount of horizontal space added or removed in the
   * resize operation
   */
  public Double getDelta() { return delta; }
}
