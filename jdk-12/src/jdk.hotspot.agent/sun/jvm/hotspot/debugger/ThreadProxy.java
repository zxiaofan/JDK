/*
 * Copyright (c) 2000, 2002, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger;

/** <P> This interface abstracts raw access to operating system-level
    threads. In a debugging environment these methods map to, for
    example, thread_db calls on Solaris (see /usr/include/thread_db.h)
    or the Win32 debugging API calls. In a runtime environment these
    might map directly to pthread calls. </P>

    <P> Implementors of this interface must provide equals() and
    hashCode() methods which work properly regardless of how the
    ThreadProxy is obtained, in particular either through {@link
    sun.jvm.hotspot.debugger.ThreadAccess} or the thread list provided
    by {@link sun.jvm.hotspot.debugger.cdbg.CDebugger}. This allows
    matching up of the OS's notion of the thread list of the target
    process with any user-level lists that may be present (i.e., the
    JavaThread list in the HotSpot VM). </P>

    <P> Implementors of this interface should also provide a
    toString() which converts the ThreadProxy to a value easily
    recognizable in the platform's debugger. (For example, on Solaris,
    "t@&lt;id&gt;".) </P>

    <P> FIXME: had to be renamed from "Thread" to avoid numerous
    clashes with java.lang.Thread -- would be nice to pick a more
    consistent name with the rest of the system. </P> */

public interface ThreadProxy {
  /** Retrieves the context for the given thread. It is only valid to
      call this method if the thread is suspended (i.e., the process
      has not been resumed via ProcessControl); throws an
      IllegalThreadStateException if it is not. */
  public ThreadContext getContext() throws IllegalThreadStateException;

  /** Indicates whether calls to setContext() are valid. */
  public boolean canSetContext() throws DebuggerException;

  /** Sets the context for the given thread. The passed ThreadContext
      must be a modified version of one returned from a previous call
      to getContext(). It is only valid to call this method if the
      thread is suspended (i.e., the process has not been resumed via
      ProcessControl); throws an IllegalThreadStateException if it is
      not. Throws a DebuggerException if the target process can not be
      modified, for example because it is a core file. */
  public void setContext(ThreadContext context)
    throws IllegalThreadStateException, DebuggerException;
}
