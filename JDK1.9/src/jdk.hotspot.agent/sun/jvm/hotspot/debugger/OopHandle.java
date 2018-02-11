/*
 * Copyright (c) 2000, 2007, Oracle and/or its affiliates. All rights reserved.
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

/** <P> This is a tag interface (similar to Cloneable) which indicates
    that the contained address is "special" and is updated under the
    hood by the VM. The purpose is to support implementation of
    reflection on the current VM with these interfaces; if the Java
    code implementing parts of the VM requires proxies for objects in
    the heap, it must be the case that those proxies are updated if GC
    occurs. This is the level at which this updating is handled. The
    VM (and specifically the GC code) must have intimate knowledge of
    the VM-specific implementation of this interface. </P>

    <P> Note that in the case of debugging a remote VM, it is not
    workable to handle the automatic updating of these handles.
    If the debugger allows the VM to resume running, it will have to
    look up once again any object references via the path they were
    found (i.e., the activation on the stack as the root, etc.) </P>
*/

public interface OopHandle extends Address {
}
