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

package sun.jvm.hotspot.runtime;

//These definitions should be kept in sync with the definitions in the HotSpot code.

public enum VMOps {
  Dummy,
  ThreadStop,
  ThreadDump,
  PrintThreads,
  FindDeadlocks,
  ForceSafepoint,
  ForceAsyncSafepoint,
  Deoptimize,
  DeoptimizeFrame,
  DeoptimizeAll,
  ZombieAll,
  UnlinkSymbols,
  Verify,
  PrintJNI,
  HeapDumper,
  DeoptimizeTheWorld,
  CollectForMetadataAllocation,
  GC_HeapInspection,
  GenCollectFull,
  GenCollectFullConcurrent,
  GenCollectForAllocation,
  ParallelGCFailedAllocation,
  ParallelGCSystemGC,
  CGC_Operation,
  CMS_Initial_Mark,
  CMS_Final_Remark,
  G1CollectFull,
  G1CollectForAllocation,
  G1IncCollectionPause,
  EnableBiasedLocking,
  RevokeBias,
  BulkRevokeBias,
  PopulateDumpSharedSpace,
  JNIFunctionTableCopier,
  RedefineClasses,
  GetOwnedMonitorInfo,
  GetObjectMonitorUsage,
  GetCurrentContendedMonitor,
  GetStackTrace,
  GetMultipleStackTraces,
  GetAllStackTraces,
  GetThreadListStackTraces,
  GetFrameCount,
  GetFrameLocation,
  ChangeBreakpoints,
  GetOrSetLocal,
  GetCurrentLocation,
  EnterInterpOnlyMode,
  ChangeSingleStep,
  HeapWalkOperation,
  HeapIterateOperation,
  ReportJavaOutOfMemory,
  JFRCheckpoint,
  Exit,
  LinuxDllLoad,
  Terminating
}
