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

package sun.print;

import java.awt.Window;
import java.awt.print.PrinterJob;
import javax.print.PrintService;
import javax.print.ServiceUIFactory;
import javax.print.attribute.PrintRequestAttributeSet;

public abstract class DocumentPropertiesUI {

    /**
     * For Win32 doc properties sheet.
     */
    public static final int
        DOCUMENTPROPERTIES_ROLE = ServiceUIFactory.RESERVED_UIROLE +100;

    /**
     * Name of (this) abstract class for Document Properties.
     */
    public static final String
        DOCPROPERTIESCLASSNAME = DocumentPropertiesUI.class.getName();

    /**
     * Invokes whatever code is needed to display a native dialog
     * with the specified owner. The owner should be the cross-platform
     * dialog. If the user cancels the dialog the return value is null.
     * A non-null return value is always a new attribute set (or is it?)
     * The cross-platform dialog may need to be updated to reflect the
     * updated properties.
     */
    public abstract PrintRequestAttributeSet
        showDocumentProperties(PrinterJob job,
                               Window owner,
                               PrintService service,
                               PrintRequestAttributeSet aset);

}
