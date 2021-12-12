/*
 * Copyright (c) 2004, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jconsole;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial") // JDK implementation class
public abstract class Tab extends JPanel {
    private String name;
    private Worker worker;

    protected VMPanel vmPanel;

    private SwingWorker<?, ?> prevSW;

    public Tab(VMPanel vmPanel, String name) {
        this.vmPanel = vmPanel;
        this.name = name;
    }

    public SwingWorker<?, ?> newSwingWorker() {
        return null;
    }

    public void update() {
        final ProxyClient proxyClient = vmPanel.getProxyClient();
        if (!proxyClient.hasPlatformMXBeans()) {
            throw new UnsupportedOperationException(
                "Platform MXBeans not registered in MBeanServer");
        }

        SwingWorker<?,?> sw = newSwingWorker();
        // schedule SwingWorker to run only if the previous
        // SwingWorker has finished its task and it hasn't started.
        if (prevSW == null || prevSW.isDone()) {
            if (sw == null || sw.getState() == SwingWorker.StateValue.PENDING) {
                prevSW = sw;
                if (sw != null) {
                    sw.execute();
                }
            }
        }
    }

    public synchronized void dispose() {
        if(worker != null)
            worker.stopWorker();

        // Subclasses will override to clean up
    }

    protected VMPanel getVMPanel() {
        return vmPanel;
    }

    OverviewPanel[] getOverviewPanels() {
        return null;
    }

    public synchronized void workerAdd(Runnable job) {
        if (worker == null) {
            worker = new Worker(name+"-"+vmPanel.getConnectionName());
            worker.start();
        }
        worker.add(job);
    }

    public Dimension getPreferredSize() {
        return new Dimension(700, 500);
    }
}
