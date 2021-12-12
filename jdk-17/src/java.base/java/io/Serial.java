/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.io;

import java.lang.annotation.*;

/**
 * Indicates that an annotated field or method is part of the {@linkplain
 * Serializable serialization mechanism} defined by the
 * <cite>Java Object Serialization Specification</cite>. This
 * annotation type is intended to allow compile-time checking of
 * serialization-related declarations, analogous to the checking
 * enabled by the {@link java.lang.Override} annotation type to
 * validate method overriding. {@code Serializable} classes are encouraged to
 * use {@code @Serial} annotations to help a compiler catch
 * mis-declared serialization-related fields and methods,
 * mis-declarations that may otherwise be difficult to detect.
 *
 * <p>Specifically, annotations of this type should be
 * applied to serialization-related methods and fields in classes
 * declared to be {@code Serializable}. The five serialization-related
 * methods are:
 *
 * <ul>
 * <li>{@code private void writeObject(java.io.ObjectOutputStream stream) throws IOException}
 * <li>{@code private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException}
 * <li>{@code private void readObjectNoData() throws ObjectStreamException}
 * <li><i>ANY-ACCESS-MODIFIER</i> {@code Object writeReplace() throws ObjectStreamException}
 * <li><i>ANY-ACCESS-MODIFIER</i> {@code Object readResolve() throws ObjectStreamException}
 * </ul>
 *
 * The two serialization-related fields are:
 *
 * <ul>
 * <li>{@code private static final ObjectStreamField[] serialPersistentFields}
 * <li>{@code private static final long serialVersionUID}
 * </ul>
 *
 * Compilers are encouraged to validate that a method or field marked with a
 * {@code @Serial} annotation is one of the defined serialization-related
 * methods or fields declared in a meaningful context and issue a warning
 * if that is not the case.
 *
 * <p>It is a semantic error to apply this annotation to other fields or methods, including:
 * <ul>
 * <li>fields or methods in a class that is not {@code Serializable}
 *
 * <li>fields or methods of the proper structural declaration, but in
 * a type where they are ineffectual. For example, {@code enum} types
 * are defined to have a {@code serialVersionUID} of {@code 0L} so a
 * {@code serialVersionUID} field declared in an {@code enum} type is
 * ignored. The five serialization-related methods identified above
 * are likewise ignored for an {@code enum} type.
 *
 * <li>in a class that is {@code Externalizable}:
 * <ul>
 *   <li> method declarations of {@code writeObject}, {@code
 *   readObject}, and {@code readObjectNoData}
 *
 *  <li>a field declaration for {@code serialPersistentFields}
 * </ul>
 *
 * While the {@code Externalizable} interface extends {@code
 * Serializable}, the three methods and one field above are
 * <em>not</em> used for externalizable classes.
 *
 * </ul>
 *
 * Note that serialization mechanism accesses its designated fields
 * and methods reflectively and those fields and methods may appear
 * otherwise unused in a {@code Serializable} class.
 *
 * @see Serializable
 * @see Externalizable
 * @since 14
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface Serial {}
