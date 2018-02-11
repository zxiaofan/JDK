/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

class LookaheadTouchFilter implements TouchFilter {

    private TouchState previousState = new TouchState();
    private TouchState tmpState = new TouchState();
    private boolean assignIDs;

    private enum FilterState {
        /** No events processed yet */
        CLEAN,
        /**
         * previousState contains an event that must be sent as is. This will
         * happen when an event is the first to be processed on this pulse, or
         * "Substantially different" means that two events differ in the number
         * of touch points or in the IDs assigned to those points.
         */
        PENDING_UNMODIFIABLE,
        /**
         * previousState contains an event that we are allowed to change before
         * sending. An event can be modified if it is substantially different
         * neither from the event that preceded it nor from the event that
         * follows it.
         */
        PENDING_MODIFIABLE
    }

    private FilterState filterState = FilterState.CLEAN;

    /**
     * Creates a new LookaheadTouchFilter
     *
     * @param assignIDs Sets whether or not we are asking the touch pipeline to
     *                  assign touch point IDs
     */
    LookaheadTouchFilter(boolean assignIDs) {
        this.assignIDs = assignIDs;
    }

    @Override
    public boolean filter(TouchState state) {
        state.sortPointsByID();
        switch (filterState) {
            case CLEAN:
                state.copyTo(previousState);
                filterState = FilterState.PENDING_UNMODIFIABLE;
                return true;
            case PENDING_UNMODIFIABLE:
                // send the previous state and hold the new state as pending
                state.copyTo(tmpState);
                previousState.copyTo(state);
                tmpState.copyTo(previousState);
                if (state.canBeFoldedWith(previousState, assignIDs)) {
                    filterState = FilterState.PENDING_MODIFIABLE;
                }
                return false;
            case PENDING_MODIFIABLE:
                if (state.canBeFoldedWith(previousState, assignIDs)) {
                    state.copyTo(previousState);
                    return true;
                } else {
                    // send the previous state and hold the new state as pending
                    state.copyTo(tmpState);
                    previousState.copyTo(state);
                    tmpState.copyTo(previousState);
                    filterState = FilterState.PENDING_UNMODIFIABLE;
                    return false;
                }
            default:
                return false;
        }
    }

    @Override
    public boolean flush(TouchState state) {
        switch (filterState) {
            case PENDING_MODIFIABLE:
            case PENDING_UNMODIFIABLE:
                previousState.copyTo(state);
                filterState = FilterState.CLEAN;
                return true;
            default:
                return false;
        }
    }

    @Override
    public int getPriority() {
        return PRIORITY_PRE_ID + 1;
    }

    @Override
    public String toString() {
        return "Lookahead[previousState="
                + previousState
                + ",filterState=" + filterState
                + "]";
    }

}
