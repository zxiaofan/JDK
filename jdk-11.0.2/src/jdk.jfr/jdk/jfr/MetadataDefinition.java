/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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
 * <pre>
 * <code>
 *{@literal @}MetadataDefinition
 *{@literal @}Label("Severity")
 *{@literal @}Description("Value between 0 and 100 that indicates severity. 100 is most severe.")
 *{@literal @}Retention(RetentionPolicy.RUNTIME)
 *{@literal @}Target({ ElementType.TYPE })
 * public {@literal @}interface {@literal @}Severity {
 *   int value() default 50;
 * }
 *
 *{@literal @}MetadataDefinition
 *{@literal @}Label("Transaction Id")
 *{@literal @}Relational
 *{@literal @}Retention(RetentionPolicy.RUNTIME)
 *{@literal @}Target({ ElementType.FIELD })
 * public {@literal @}interface {@literal @}Severity {
 * }
 *
 *{@literal @}Severity(80)
 *{@literal @}Label("Transaction Blocked");
 * class TransactionBlocked extends Event {
 *  {@literal @}TransactionId
 *  {@literal @}Label("Transaction");
 *   long transactionId;
 *
 *  {@literal @}TransactionId
 *  {@literal @}Label("Transaction Blocker");
 *   long transactionId;
 * }
 *
 * </code>
 * </pre>
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
