/*
 * Copyright (c) 2004, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jconsole.inspector;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;


/**
 * This list implements the drag and drop functionality.
 */
@SuppressWarnings("serial")
public class XTextField extends JPanel
    implements DocumentListener,
               ActionListener {

    private XObject selectedObject;
    protected JTextField textField;

    private static boolean allowNullSelection = false;

    protected static final int COMPATIBLE_VALUE = 1;
    protected static final int CURRENT_VALUE = 2;
    protected static final int NULL_VALUE = 3;

    private JButton button;
    private XOperations operation;

    //used in XTestFieldEditor
    public XTextField() {
        super(new BorderLayout());
        add(textField = new JTextField(),BorderLayout.CENTER);
        textField.addActionListener(this);
        //
    }

    public XTextField(Object value) {
        this(value,value.toString().length());
    }

    public XTextField(Object value, int colWidth) {
        this(value,value.getClass(),colWidth, true, null, null);
    }

    public XTextField(Object value,
                      Class<?> expectedClass,
                      int colWidth,
                      boolean isCallable,
                      JButton button,
                      XOperations operation) {
        super(new BorderLayout());
        this.button = button;
        this.operation = operation;
        add(textField = new JTextField(value.toString(),colWidth),
            BorderLayout.CENTER);
        if(isCallable)
            textField.addActionListener(this);

        boolean fieldEditable = Utils.isEditableType(expectedClass.getName());
        if (fieldEditable && isCallable) {
            textField.setEditable(true);
        }
        else {
            textField.setEditable(false);
        }
    }

    public static void setNullSelectionAllowed(boolean allowNullSelection) {
        XTextField.allowNullSelection = allowNullSelection;
    }

    public static boolean getNullSelectionAllowed() {
        return allowNullSelection;
    }

    protected void init(Object value, Class<?> expectedClass) {
         boolean fieldEditable =  Utils.isEditableType(expectedClass.getName());
        clearObject();
        if (value != null) {
            textField.setText(value.toString());
        }
        else {
            //null String value for the moment
            textField.setText("");
        }
        textField.setToolTipText(null);
        if (fieldEditable) {
            if (!textField.isEditable()) {
                textField.setEditable(true);
            }

        }
        else {
            if (textField.isEditable()) {
                textField.setEditable(false);
            }
        }
    }

    private synchronized void clearObject() {
        textField.getDocument().removeDocumentListener(this);
        selectedObject = null;
        setDefaultColors();
    }

    private synchronized void setDefaultColors() {
        //  if (fore != null) textField.setForeground(fore);
        // if (back != null)  textField.setBackground(back);
    }

    public void setHorizontalAlignment(int h) {
        textField.setHorizontalAlignment(h);
    }

    //can be overwritten
    protected JMenuItem buildJMenuItem(XObject xobject, int valueType) {
        if (valueType == COMPATIBLE_VALUE) {
            return new JMenuItem(xobject.getText());
        }
        else if (valueType == CURRENT_VALUE) {
            return new JMenuItem("> "+xobject.getText());
        }
        else if (valueType == NULL_VALUE) {
            return new JMenuItem("null");
        }
        else {
            return null;
        }
    }

    // ACTIONLISTENER IMPLEMENTATION
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JTextField) {
            if(operation != null)
                operation.performInvokeRequest(button);
        }
    }

    /**
     * This method returns either the user inputted String, or an XObject
     * if one was dropped on the input field.
     */
    public Object getValue() {
        if (selectedObject!=null) {
            if (selectedObject == XObject.NULL_OBJECT) {
                //null case
                return null;
            }
            else {
                return selectedObject;
            }
        }
        else {
            return  textField.getText();
        }
    }

    public void changedUpdate(DocumentEvent e) {
        // the user typed something, so remove references
        // to the object that was dropped.
        clearObject();
    }

    public void removeUpdate(DocumentEvent e) {
        // the user typed something, so remove references
        // to the object that was dropped.
        clearObject();
    }

    public void insertUpdate(DocumentEvent e) {
        // the user typed something, so remove references
        // to the object that was dropped.
        clearObject();
    }

}
