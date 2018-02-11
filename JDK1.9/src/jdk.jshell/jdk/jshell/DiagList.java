/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jshell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * List of diagnostics, with convenient operations.
 *
 * @author Robert Field
 */
@SuppressWarnings("serial")             // serialVersionUID intentionally omitted
final class DiagList extends ArrayList<Diag> {

    private int cntNotStmt = 0;
    private int cntUnreach = 0;
    private int cntResolve = 0;
    private int cntOther = 0;

    DiagList() {
        super();
    }

    DiagList(Diag d) {
        super();
        add(d);
    }

    DiagList(Collection<? extends Diag> c) {
        super();
        addAll(c);
    }

    private void tally(Diag d) {
        if (d.isError()) {
            if (d.isUnreachableError()) {
                ++cntUnreach;
            } else if (d.isNotAStatementError()) {
                ++cntNotStmt;
            } else if (d.isResolutionError()) {
                ++cntResolve;
            } else {
                ++cntOther;
            }
        }
    }

    @Override
    public boolean addAll(Collection<? extends Diag> c) {
        return c.stream().filter(this::add).count() > 0;
    }

    @Override
    public Diag set(int index, Diag element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, Diag element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Diag d) {
        boolean added = super.add(d);
        if (added) {
            tally(d);
        }
        return added;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Diag> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    DiagList ofUnit(Unit u) {
        return this.stream()
                .filter(d -> {
                    Snippet snn = d.snippetOrNull();
                    return snn == u.snippet();
                })
                .collect(Collectors.toCollection(DiagList::new));
    }

    boolean hasErrors() {
        return (cntNotStmt + cntResolve + cntUnreach + cntOther) > 0;
    }

    boolean hasResolutionErrorsAndNoOthers() {
        return cntResolve > 0 && (cntNotStmt + cntUnreach + cntOther) == 0;
    }

    boolean hasUnreachableError() {
        return cntUnreach > 0;
    }

    boolean hasNotStatement() {
        return cntNotStmt > 0;
    }

    boolean hasOtherThanNotStatementErrors() {
        return (cntResolve + cntUnreach + cntOther) > 0;
    }

}
