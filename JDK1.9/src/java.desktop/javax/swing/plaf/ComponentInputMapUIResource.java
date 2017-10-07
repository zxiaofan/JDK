/*
 * Copyright (c) 1999, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf;

import javax.swing.ComponentInputMap;
import javax.swing.JComponent;


/**
 * A subclass of javax.swing.ComponentInputMap that implements UIResource.
 * UI classes which provide a ComponentInputMap should use this class.
 *
 * @author Scott Violet
 * @since 1.3
 */
@SuppressWarnings("serial") // Superclass is not serializable across versions
public class ComponentInputMapUIResource extends ComponentInputMap implements UIResource {
    /**
     * Constructs a {@code ComponentInputMapUIResource}.
     * @param component a non-null JComponent
     */
    public ComponentInputMapUIResource(JComponent component) {
        super(component);
    }
}
