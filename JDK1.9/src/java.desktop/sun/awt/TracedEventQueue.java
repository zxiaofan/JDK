/*
 * Copyright (c) 1997, Oracle and/or its affiliates. All rights reserved.
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
 * An EventQueue subclass which adds selective tracing of events as they
 * are posted to an EventQueue.  Tracing is globally enabled and disabled
 * by the AWT.TraceEventPosting property in awt.properties.  <P>
 *
 * The optional AWT.NoTraceIDs property defines a list of AWTEvent IDs
 * which should not be traced, such as MouseEvent.MOUSE_MOVED or PaintEvents.
 * This list is declared by specifying the decimal value of each event's ID,
 * separated by commas.
 *
 * @author  Thomas Ball
 */

package sun.awt;

import java.awt.EventQueue;
import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.util.StringTokenizer;

public class TracedEventQueue extends EventQueue {

    // Determines whether any event tracing is enabled.
    static boolean trace = false;

    // The list of event IDs to ignore when tracing.
    static int suppressedIDs[] = null;

    static {
        String s = Toolkit.getProperty("AWT.IgnoreEventIDs", "");
        if (s.length() > 0) {
            StringTokenizer st = new StringTokenizer(s, ",");
            int nIDs = st.countTokens();
            suppressedIDs = new int[nIDs];
            for (int i = 0; i < nIDs; i++) {
                String idString = st.nextToken();
                try {
                    suppressedIDs[i] = Integer.parseInt(idString);
                } catch (NumberFormatException e) {
                    System.err.println("Bad ID listed in AWT.IgnoreEventIDs " +
                                       "in awt.properties: \"" +
                                       idString + "\" -- skipped");
                    suppressedIDs[i] = 0;
                }
            }
        } else {
            suppressedIDs = new int[0];
        }
    }

    public void postEvent(AWTEvent theEvent) {
        boolean printEvent = true;
        int id = theEvent.getID();
        for (int i = 0; i < suppressedIDs.length; i++) {
            if (id == suppressedIDs[i]) {
                printEvent = false;
                break;
            }
        }
        if (printEvent) {
            System.out.println(Thread.currentThread().getName() +
                               ": " + theEvent);
        }
        super.postEvent(theEvent);
    }
}
