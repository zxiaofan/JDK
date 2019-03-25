/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.X11;

/* This interface is needed for listening for StateChanged events (we are interested in iconify only )
 * fix for 6261352. We should detect if Window containing a Choice become iconified and hide pop-down menu with grab release.
 */
public interface ToplevelStateListener{
    /* two different methods for that case if ICCCM states
     * (WithdrawnState, IconicState, NormalState) has the same integer values as Java states
     * (Frame.ICONIFIED,  Frame.MAXIMIZED_BOTH, Frame.MAXIMIZED_HORIZ, Frame.MAXIMIZED_VERT)
     * They will be invoked from different peers in order not to mix different states having same codes.
     */
    public void stateChangedICCCM(int oldState, int newState);
    public void stateChangedJava(int oldState, int newState);
}
