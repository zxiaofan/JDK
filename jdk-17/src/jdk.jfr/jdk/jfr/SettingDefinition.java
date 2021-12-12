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
 * Annotation that specifies that a method in an event class should be used to
 * filter out events.
 * <p>
 * For the method to be valid it must return a {@code SettingControl} and only have one
 * parameter, which should be a non-abstract subclass of {@link SettingControl}
 * <p>
 * The return value of the method specifies whether the event is to be
 * written to the Flight Recorder system or not.
 * <p>
 * The following example shows how to annotate a method in an event class.
 *
 * <pre>{@literal
 * class HelloWorld extends Event {
 *
 *   @Label("Message")
 *   String message;
 *
 *   @SettingDefinition
 *   @Label("Message Filter")
 *   public boolean filter(RegExpControl regExp) {
 *     return regExp.matches(message);
 *   }
 * }
 * }</pre>
 *
 * For an example of how the setting controls are defined, see
 * {@link SettingControl}.
 *
 * @see SettingControl
 *
 * @since 9
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface SettingDefinition {
}
