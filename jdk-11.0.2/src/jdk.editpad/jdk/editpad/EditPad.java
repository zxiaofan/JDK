/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.editpad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * A minimal Swing editor as a fallback when the user does not specify an
 * external editor.
 */
class EditPad implements Runnable {

    private static final String L10N_RB_NAME  = "jdk.editpad.resources.l10n";
    private ResourceBundle rb  = null;
    private final String windowLabel;
    private final Consumer<String> errorHandler;
    private final String initialText;
    private final Runnable closeMark;
    private final Consumer<String> saveHandler;

    /**
     * Create an Edit Pad minimal editor.
     *
     * @param windowLabel the label string for the Edit Pad window
     * @param errorHandler a handler for unexpected errors
     * @param initialText the source to load in the Edit Pad
     * @param closeMark a Runnable that is run when Edit Pad closes
     * @param saveHandler a handler for changed source (sent the full source)
     */
    EditPad(String windowLabel, Consumer<String> errorHandler, String initialText,
            Runnable closeMark, Consumer<String> saveHandler) {
        this.windowLabel = windowLabel;
        this.errorHandler = errorHandler;
        this.initialText = initialText;
        this.closeMark = closeMark;
        this.saveHandler = saveHandler;
    }

    @Override
    public void run() {
        JFrame jframe = new JFrame(windowLabel == null
                ? getResourceString("editpad.name")
                : windowLabel);
        Runnable closer = () -> {
            jframe.setVisible(false);
            jframe.dispose();
            closeMark.run();
        };
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closer.run();
            }
        });
        jframe.setLocationRelativeTo(null);
        jframe.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea(initialText);
        textArea.setFont(new Font("monospaced", Font.PLAIN, 13));
        jframe.add(new JScrollPane(textArea), BorderLayout.CENTER);
        jframe.add(buttons(closer, textArea), BorderLayout.SOUTH);

        jframe.setSize(800, 600);
        jframe.setVisible(true);
    }

    private JPanel buttons(Runnable closer, JTextArea textArea) {
        FlowLayout flow = new FlowLayout();
        flow.setHgap(35);
        JPanel buttons = new JPanel(flow);
        addButton(buttons, "editpad.cancel", KeyEvent.VK_C, e -> {
            closer.run();
        });
        addButton(buttons, "editpad.accept", KeyEvent.VK_A, e -> {
            saveHandler.accept(textArea.getText());
        });
        addButton(buttons, "editpad.exit",   KeyEvent.VK_X, e -> {
            saveHandler.accept(textArea.getText());
            closer.run();
        });
        return buttons;
    }

    private void addButton(JPanel buttons, String rkey, int mnemonic, ActionListener action) {
        JButton but = new JButton(getResourceString(rkey));
        but.setMnemonic(mnemonic);
        buttons.add(but);
        but.addActionListener(action);
    }

    private String getResourceString(String key) {
        if (rb == null) {
            try {
                rb = ResourceBundle.getBundle(L10N_RB_NAME);
            } catch (MissingResourceException mre) {
                error("Cannot find ResourceBundle: %s", L10N_RB_NAME);
                return "";
            }
        }
        String s;
        try {
            s = rb.getString(key);
        } catch (MissingResourceException mre) {
            error("Missing resource: %s in %s", key, L10N_RB_NAME);
            return "";
        }
        return s;
    }

    private void error(String fmt, Object... args) {
        errorHandler.accept(String.format(fmt, args));
    }
}
