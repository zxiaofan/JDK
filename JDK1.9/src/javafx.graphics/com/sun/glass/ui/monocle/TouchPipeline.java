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

import java.util.ArrayList;

class TouchPipeline {

    private TouchInput touch = TouchInput.getInstance();
    private ArrayList<TouchFilter> filters = new ArrayList<TouchFilter>();
    private TouchState flushState = new TouchState();

    /**
     * Adds the filters in the given pipeline to this pipeline
     */
    void add(TouchPipeline pipeline) {
        for (int i = 0; i < pipeline.filters.size(); i++) {
            addFilter(pipeline.filters.get(i));
        }
    }

    /**
     * Attempts to add the filters named in the comma-separated list provided.
     */
    void addNamedFilters(String filterNameList) {
        String[] touchFilterNames = filterNameList.split(",");
        if (touchFilterNames != null) {
            for (String touchFilterName : touchFilterNames) {
                String s = touchFilterName.trim();
                if (s.length() > 0) {
                    addNamedFilter(s);
                }
            }
        }
    }

    void addNamedFilter(String filterName) {
        try {
            // install known filters without reflection
            if (filterName.equals("SmallMove")) {
                addFilter(new SmallMoveTouchFilter());
            } else if (filterName.equals("NearbyPoints")) {
                addFilter(new NearbyPointsTouchFilter());
            } else if (filterName.equals("AssignPointID")) {
                addFilter(new AssignPointIDTouchFilter());
            } else {
                Class cls;
                if (!filterName.contains(".")) {
                    filterName = "com.sun.glass.ui.monocle."
                            + filterName + "TouchFilter";
                }
                ClassLoader loader = Thread.currentThread().getContextClassLoader();
                addFilter((TouchFilter) loader.loadClass(filterName).newInstance());
            }
        } catch (Exception e) {
            System.err.println(
                    "Cannot install touch filter '" + filterName + "'");
            e.printStackTrace();
        }
    }

    void addFilter(TouchFilter filter) {
        int priority = filter.getPriority();
        int i;
        for (i = 0; i < filters.size(); i++) {
            if (filters.get(i).equals(filter)) {
                return;
            }
            if (filters.get(i).getPriority() < priority) {
                break;
            }
        }
        filters.add(i, filter);
    }

    boolean filter(TouchState state) {
        for (int i = 0; i < filters.size(); i++) {
            TouchFilter filter = filters.get(i);
            if (MonocleSettings.settings.traceEventsVerbose) {
                MonocleTrace.traceEvent("Applying %s to %s", filter, state);
            }
            if (filter.filter(state)) {
                return true;
            }
        }
        return false;
    }

    void pushState(TouchState state) {
        if (MonocleSettings.settings.traceEventsVerbose) {
            MonocleTrace.traceEvent("Pushing %s to %s", state, this);
        }
        if (!filter(state)) {
            touch.setState(state);
        }
    }

    /** Flushes any remaining data in the pipeline, possibly pushing more
     * state objects to TouchInput.
     */
    void flush() {
        for (int i = 0; i < filters.size(); i++) {
            TouchFilter filter = filters.get(i);
            while (filter.flush(flushState)) {
                if (MonocleSettings.settings.traceEventsVerbose) {
                    MonocleTrace.traceEvent("Flushing %s from %s", flushState, filter);
                }
                boolean consumed = false;
                for (int j = i + 1; j < filters.size() && !consumed; j++) {
                    consumed = filters.get(j).filter(flushState);
                }
                if (!consumed) {
                    touch.setState(flushState);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("TouchPipeline[");
        for (int i = 0; i < filters.size(); i++) {
            sb.append(filters.get(i));
            if (i < filters.size() - 1) {
                sb.append(" -> ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
