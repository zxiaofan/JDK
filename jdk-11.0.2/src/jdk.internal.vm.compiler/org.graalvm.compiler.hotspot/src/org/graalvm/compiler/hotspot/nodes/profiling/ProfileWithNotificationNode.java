/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.hotspot.nodes.profiling;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;

import jdk.vm.ci.meta.ResolvedJavaMethod;

@NodeInfo
public abstract class ProfileWithNotificationNode extends ProfileNode {
    public static final NodeClass<ProfileWithNotificationNode> TYPE = NodeClass.create(ProfileWithNotificationNode.class);

    protected int freqLog;

    protected ProfileWithNotificationNode(NodeClass<? extends ProfileNode> c, ResolvedJavaMethod method, int freqLog, int probabilityLog) {
        super(c, method, probabilityLog);
        this.freqLog = freqLog;
    }

    public ProfileWithNotificationNode(ResolvedJavaMethod method, int freqLog, int probabilityLog) {
        super(TYPE, method, probabilityLog);
        this.freqLog = freqLog;
    }

    /**
     * Get the logarithm base 2 of the notification frequency.
     */
    public int getNotificationFreqLog() {
        return freqLog;
    }

    /**
     * Set the logarithm base 2 of the notification frequency.
     */
    public void setNotificationFreqLog(int freqLog) {
        assert freqLog < 32;
        this.freqLog = freqLog;
    }

    public void setNotificationOff() {
        setNotificationFreqLog(-1);
    }

}
