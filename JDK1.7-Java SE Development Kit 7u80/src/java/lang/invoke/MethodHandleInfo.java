/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.invoke;
import java.lang.invoke.MethodHandleNatives.Constants;

//Not yet public: public
class MethodHandleInfo {
   public static final int
       REF_NONE                    = Constants.REF_NONE,
       REF_getField                = Constants.REF_getField,
       REF_getStatic               = Constants.REF_getStatic,
       REF_putField                = Constants.REF_putField,
       REF_putStatic               = Constants.REF_putStatic,
       REF_invokeVirtual           = Constants.REF_invokeVirtual,
       REF_invokeStatic            = Constants.REF_invokeStatic,
       REF_invokeSpecial           = Constants.REF_invokeSpecial,
       REF_newInvokeSpecial        = Constants.REF_newInvokeSpecial,
       REF_invokeInterface         = Constants.REF_invokeInterface;

   private final Class<?> declaringClass;
   private final String name;
   private final MethodType methodType;
   private final int referenceKind;

   public MethodHandleInfo(MethodHandle mh) throws ReflectiveOperationException {
       MemberName mn = mh.internalMemberName();
       this.declaringClass = mn.getDeclaringClass();
       this.name = mn.getName();
       this.methodType = mn.getMethodType();
       this.referenceKind = mn.getReferenceKind();
   }

   public Class<?> getDeclaringClass() {
       return declaringClass;
   }

   public String getName() {
       return name;
   }

   public MethodType getMethodType() {
       return methodType;
   }

   public int getReferenceKind() {
       return referenceKind;
   }
}
