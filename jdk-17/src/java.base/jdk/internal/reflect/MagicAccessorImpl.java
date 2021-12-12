/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.reflect;

/** <P> MagicAccessorImpl (named for parity with FieldAccessorImpl and
    others, not because it actually implements an interface) is a
    marker class in the hierarchy. All subclasses of this class are
    "magically" granted access by the VM to otherwise inaccessible
    fields and methods of other classes. It is used to hold the code
    for dynamically-generated FieldAccessorImpl and MethodAccessorImpl
    subclasses. (Use of the word "unsafe" was avoided in this class's
    name to avoid confusion with {@link jdk.internal.misc.Unsafe}.) </P>

    <P> The bug fix for 4486457 also necessitated disabling
    verification for this class and all subclasses, as opposed to just
    SerializationConstructorAccessorImpl and subclasses, to avoid
    having to indicate to the VM which of these dynamically-generated
    stub classes were known to be able to pass the verifier. </P>

    <P> Do not change the name of this class without also changing the
    VM's code. </P> */

class MagicAccessorImpl {
}
