/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.activation;

import java.io.IOException;

/**
 * JavaBeans components that are Activation Framework aware implement
 * this interface to find out which command verb they're being asked
 * to perform, and to obtain the DataHandler representing the
 * data they should operate on.  JavaBeans that don't implement
 * this interface may be used as well.  Such commands may obtain
 * the data using the Externalizable interface, or using an
 * application-specific method.
 *
 * @since 1.6
 */
public interface CommandObject {

    /**
     * Initialize the Command with the verb it is requested to handle
     * and the DataHandler that describes the data it will
     * operate on. <b>NOTE:</b> it is acceptable for the caller
     * to pass <i>null</i> as the value for {@code DataHandler}.
     *
     * @param verb The Command Verb this object refers to.
     * @param dh The DataHandler.
     * @exception       IOException     for failures accessing data
     */
    public void setCommandContext(String verb, DataHandler dh)
                                                throws IOException;
}
