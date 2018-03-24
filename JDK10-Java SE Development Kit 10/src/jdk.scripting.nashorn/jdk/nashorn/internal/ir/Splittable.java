/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.ir;

import java.io.Serializable;
import java.util.List;
import jdk.nashorn.internal.codegen.CompileUnit;

/**
 * An interface for splittable expressions.
 */
public interface Splittable {

    /**
     * Get a list of split ranges for this splittable expression, or null
     * if the expression should not be split.
     *
     * @return a list of split ranges
     */
    List<SplitRange> getSplitRanges();

    /**
     * A SplitRange is a range in a splittable expression. It defines the
     * boundaries of the split range and provides a compile unit for code generation.
     */
    final class SplitRange implements CompileUnitHolder, Serializable {
        private static final long serialVersionUID = 1L;

        /** Compile unit associated with the postsets range. */
        private final CompileUnit compileUnit;

        /** postsets range associated with the unit (hi not inclusive). */
        private final int low, high;

        /**
         * Constructor
         * @param compileUnit compile unit
         * @param low lowest array index in unit
         * @param high highest array index in unit + 1
         */
        public SplitRange(final CompileUnit compileUnit, final int low, final int high) {
            this.compileUnit = compileUnit;
            this.low   = low;
            this.high   = high;
        }

        /**
         * Get the high index position of the ArrayUnit (exclusive)
         * @return high index position
         */
        public int getHigh() {
            return high;
        }

        /**
         * Get the low index position of the ArrayUnit (inclusive)
         * @return low index position
         */
        public int getLow() {
            return low;
        }

        /**
         * The array compile unit
         * @return array compile unit
         */
        @Override
        public CompileUnit getCompileUnit() {
            return compileUnit;
        }
    }
}
