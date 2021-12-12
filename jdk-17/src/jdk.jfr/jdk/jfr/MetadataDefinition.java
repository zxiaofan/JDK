/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Meta annotation for defining new types of event metadata.
 * <p>
 * In the following example, a transaction event is defined with two
 * user-defined annotations, {@code @Severity} and {@code @TransactionId}.
 *
 * <pre>{@literal
 * @MetadataDefinition
 * @Label("Severity")
 * @Description("Value between 0 and 100 that indicates severity. 100 is most severe.")
 * @Retention(RetentionPolicy.RUNTIME)
 * @Target({ElementType.TYPE})
 * public @interface Severity {
 *     int value() default 50;
 * }
 *
 * @MetadataDefinition
 * @Label("Transaction Id")
 * @Relational
 * @Retention(RetentionPolicy.RUNTIME)
 * @Target({ElementType.FIELD})
 * public @interface TransactionId {
 * }
 *
 * @Severity(80)
 * @Label("Transaction Blocked")
 * class TransactionBlocked extends Event {
 *     @TransactionId
 *     @Label("Transaction")
 *     long transactionId1;
 *
 *     @TransactionId
 *     @Label("Transaction Blocker")
 *     long transactionId2;
 * }
 * }</pre>
 *
 * Adding {@code @MetadataDefinition} to the declaration of {@code @Severity} and {@code @TransactionId}
 * ensures the information is saved by Flight Recorder.
 *
 * @since 9
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface MetadataDefinition {
}
