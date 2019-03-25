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
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that specifies that an element is experimental and may change
 * without notice.
 * <p>
 * Clients that visualize Flight Recorder events should <em>not</em> show the
 * events or fields annotated with the {@code Experimental} annotation by
 * default. This annotation allows event producers the freedom to try out new
 * events without committing to them.
 * <p>
 * Clients may provide a check box (for example, in a preference page) where a
 * user can opt-in to display experimental data. If the user decide to do so,
 * the user interface should mark experimental events or fields so users can
 * distinguish them from non-experimental events.
 * <p>
 * This annotation is inherited.
 *
 * @since 9
 */
@MetadataDefinition
@Label("Experimental")
@Description("Element is not to be shown to a user by default")
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
public @interface Experimental {
}
