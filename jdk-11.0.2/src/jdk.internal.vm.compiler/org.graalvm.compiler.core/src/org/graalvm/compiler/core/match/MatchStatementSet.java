/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.match;

import java.util.List;

import org.graalvm.compiler.core.gen.NodeLIRBuilder;
import org.graalvm.compiler.core.gen.NodeMatchRules;

public interface MatchStatementSet {
    /**
     * @return the {@link NodeLIRBuilder} subclass which defined this set of {@link MatchStatement}
     *         instances.
     */
    Class<? extends NodeMatchRules> forClass();

    /**
     * @return the {@link MatchStatement}s available for this {@link NodeLIRBuilder} subclass.
     */
    List<MatchStatement> statements();
}
