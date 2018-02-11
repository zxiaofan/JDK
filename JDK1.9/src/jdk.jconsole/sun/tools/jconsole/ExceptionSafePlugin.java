/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import com.sun.tools.jconsole.JConsolePlugin;

/**
 * Proxy that shields GUI from plug-in exceptions.
 *
 */
final class ExceptionSafePlugin extends JConsolePlugin {

    private static boolean ignoreExceptions;
    private final JConsolePlugin plugin;

    public ExceptionSafePlugin(JConsolePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public Map<String, JPanel> getTabs() {
        try {
            return plugin.getTabs();
        } catch (RuntimeException e) {
            handleException(e);
        }
        return new HashMap<>();
    }

    @Override
    public SwingWorker<?, ?> newSwingWorker() {
        try {
            return plugin.newSwingWorker();
        } catch (RuntimeException e) {
            handleException(e);
        }
        return null;
    }

    @Override
    public void dispose() {
        try {
            plugin.dispose();
        } catch (RuntimeException e) {
            handleException(e);
        }
    }

    public void executeSwingWorker(SwingWorker<?, ?> sw) {
        try {
            sw.execute();
        } catch (RuntimeException e) {
            handleException(e);
        }
    }

    private void handleException(Exception e) {
        if (JConsole.isDebug()) {
            System.err.println("Plug-in exception:");
            e.printStackTrace();
        } else {
            if (!ignoreExceptions) {
                showExceptionDialog(e);
            }
        }
    }

    private void showExceptionDialog(Exception e) {
        Object[] buttonTexts = {
            Messages.PLUGIN_EXCEPTION_DIALOG_BUTTON_OK,
            Messages.PLUGIN_EXCEPTION_DIALOG_BUTTON_EXIT,
            Messages.PLUGIN_EXCEPTION_DIALOG_BUTTON_IGNORE
        };

        String message = String.format(
            Messages.PLUGIN_EXCEPTION_DIALOG_MESSAGE,
            plugin.getClass().getSimpleName(),
            String.valueOf(e.getMessage())
        );

        int buttonIndex = JOptionPane.showOptionDialog(
            null,
            message,
            Messages.PLUGIN_EXCEPTION_DIALOG_TITLE,
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.ERROR_MESSAGE,
            null,
            buttonTexts,
            buttonTexts[0]
        );

        if (buttonIndex == 1) {
            System.exit(0);
        }
        ignoreExceptions = buttonIndex == 2;
    }
}
