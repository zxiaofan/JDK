/*
 * Copyright (c) 2005, 2006, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.shell;

import javax.swing.*;
import java.util.Comparator;

public class ShellFolderColumnInfo {
    private String title;
    private Integer width;
    private boolean visible;
    /**
     * Allowed values are {@link SwingConstants#LEFT}, {@link SwingConstants#RIGHT}, {@link SwingConstants#LEADING},
     * {@link SwingConstants#TRAILING}, {@link SwingConstants#CENTER}
     */
    private Integer alignment;
    private SortOrder sortOrder;
    private Comparator<?> comparator;
    /**
     * {@code false} (default) if the {@link #comparator} expects folders as arguments,
     * and {@code true} if folder's column values. The first option is used default for comparison
     * on Windows and also for separating files from directories when sorting using
     * ShellFolderManager's inner comparator.
     */
    private boolean compareByColumn;

    public ShellFolderColumnInfo(String title, Integer width,
                                 Integer alignment, boolean visible,
                                 SortOrder sortOrder, Comparator<?> comparator,
                                 boolean compareByColumn) {
        this.title = title;
        this.width = width;
        this.alignment = alignment;
        this.visible = visible;
        this.sortOrder = sortOrder;
        this.comparator = comparator;
        this.compareByColumn = compareByColumn;
    }

    public ShellFolderColumnInfo(String title, Integer width,
                                 Integer alignment, boolean visible,
                                 SortOrder sortOrder, Comparator<?> comparator) {
        this(title, width, alignment, visible, sortOrder, comparator, false);
    }

    /**
     * This constructor is used by native code when getting column set for
     * a folder under Windows
     */
    public ShellFolderColumnInfo(String title, int width, int alignment,
                                 boolean visible) {
        this(title, width, alignment, visible, null, null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getAlignment() {
        return alignment;
    }

    public void setAlignment(Integer alignment) {
        this.alignment = alignment;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Comparator<?> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<?> comparator) {
        this.comparator = comparator;
    }

    public boolean isCompareByColumn() {
        return compareByColumn;
    }

    public void setCompareByColumn(boolean compareByColumn) {
        this.compareByColumn = compareByColumn;
    }
}
