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
 *
 */

package sun.jvm.hotspot.opto;

//These definitions should be kept in sync with the definitions in the HotSpot code.

public enum CompilerPhaseType {
  PHASE_BEFORE_STRINGOPTS ("Before StringOpts"),
  PHASE_AFTER_STRINGOPTS ("After StringOpts"),
  PHASE_BEFORE_REMOVEUSELESS ("Before RemoveUseless"),
  PHASE_AFTER_PARSING ("After Parsing"),
  PHASE_ITER_GVN1 ("Iter GVN 1"),
  PHASE_PHASEIDEAL_BEFORE_EA ("PhaseIdealLoop before EA"),
  PHASE_ITER_GVN_AFTER_EA ("Iter GVN after EA"),
  PHASE_ITER_GVN_AFTER_ELIMINATION ("Iter GVN after eliminating allocations and locks"),
  PHASE_PHASEIDEALLOOP1 ("PhaseIdealLoop 1"),
  PHASE_PHASEIDEALLOOP2 ("PhaseIdealLoop 2"),
  PHASE_PHASEIDEALLOOP3 ("PhaseIdealLoop 3"),
  PHASE_CPP1 ("PhaseCPP 1"),
  PHASE_ITER_GVN2 ("Iter GVN 2"),
  PHASE_PHASEIDEALLOOP_ITERATIONS ("PhaseIdealLoop iterations"),
  PHASE_OPTIMIZE_FINISHED ("Optimize finished"),
  PHASE_GLOBAL_CODE_MOTION ("Global code motion"),
  PHASE_FINAL_CODE ("Final Code"),
  PHASE_AFTER_EA ("After Escape Analysis"),
  PHASE_BEFORE_CLOOPS ("Before CountedLoop"),
  PHASE_AFTER_CLOOPS ("After CountedLoop"),
  PHASE_BEFORE_BEAUTIFY_LOOPS ("Before beautify loops"),
  PHASE_AFTER_BEAUTIFY_LOOPS ("After beautify loops"),
  PHASE_BEFORE_MATCHING ("Before Matching"),
  PHASE_INCREMENTAL_INLINE ("Incremental Inline"),
  PHASE_INCREMENTAL_BOXING_INLINE ("Incremental Boxing Inline"),
  PHASE_END ("End"),
  PHASE_FAILURE ("Failure"),
  PHASE_NUM_TYPES ("Number of Phase Types");

  private final String value;

  CompilerPhaseType(String val) {
    this.value = val;
  }
  public String value() {
    return value;
  }
}
