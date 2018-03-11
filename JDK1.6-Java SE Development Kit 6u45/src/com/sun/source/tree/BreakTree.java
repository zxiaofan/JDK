/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * Use and Distribution is subject to the Java Research License available
 * at <http://wwws.sun.com/software/communitysource/jrl.html>.
 */

package com.sun.source.tree;

import javax.lang.model.element.Name;

/**
 * A tree node for a 'break' statement.
 *
 * For example:
 * <pre>
 *   break;
 *
 *   break <em>label</em> ;
 * </pre>
 *
 * @see "The Java Language Specification, 3rd ed, section 14.15"
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface BreakTree extends StatementTree {
    Name getLabel();
}
