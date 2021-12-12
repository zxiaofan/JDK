/*
 * Copyright (c) 2004, 2005, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.*;

import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.oops.Oop;
import sun.jvm.hotspot.utilities.LivenessPathList;

import sun.jvm.hotspot.ui.action.*;

import com.sun.java.swing.ui.*;
import com.sun.java.swing.action.*;
import sun.jvm.hotspot.ui.tree.SimpleTreeNode;


public interface SAListener {
    public void showThreadOopInspector(JavaThread thread);
    public void showInspector(SimpleTreeNode node);
    public void showThreadStackMemory(JavaThread thread);
    public void showThreadInfo(JavaThread thread);
    public void showJavaStackTrace(JavaThread thread);
    public void showCodeViewer(Address address);
    public void showLiveness(Oop oop, LivenessPathList liveness);
}
