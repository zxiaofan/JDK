/*
 * Copyright (c) 2007, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.print;

import java.awt.Dialog;
import javax.print.attribute.Attribute;
import javax.print.attribute.PrintRequestAttribute;
import java.awt.Frame;
import java.awt.Window;

/**
 * Class DialogOwner is a printing attribute class that identifies
 * the window that owns the print dialog.
 *
 * <P>
 * <B>IPP Compatibility:</B> This is not an IPP attribute.
 * <P>
 *
 */
@SuppressWarnings("serial") // JDK-implementation class
public final class DialogOwner
    implements PrintRequestAttribute {

    private Window dlgOwner;

    /**
     * Construct a new dialog owner attribute with the given frame.
     *
     * @param  frame the frame that owns the print dialog
     */
    public DialogOwner(Frame frame) {
        dlgOwner = frame;
    }

    /**
     * Construct a new dialog owner attribute with the given dialog.
     *
     * @param  dialog the dialog that owns the print dialog
     */
    public DialogOwner(Dialog dialog) {
        dlgOwner = dialog;
    }

    /**
     * Returns the string table for class DialogOwner.
     */
    public Window getOwner() {
        return dlgOwner;
    }


    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <P>
     * For class DialogOwner the category is class
     * DialogOwner itself.
     *
     * @return  Printing attribute class (category), an instance of class
     *          {@link java.lang.Class java.lang.Class}.
     */
    public Class<? extends Attribute> getCategory() {
        return DialogOwner.class;
    }


    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <P>
     * For class DialogOwner the category name is
     * {@code "dialog-owner"}.
     *
     * @return  Attribute category name.
     */
    public String getName() {
        return "dialog-owner";
    }

}
