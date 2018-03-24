/*
 * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.print.attribute;

/**
 * Interface {@code PrintRequestAttribute} is a tagging interface which a
 * printing attribute class implements to indicate the attribute denotes a
 * requested setting for a print job.
 * <p>
 * Attributes which are tagged with {@code PrintRequestAttribute} and are also
 * tagged as {@code PrintJobAttribute}, represent the subset of job attributes
 * which can be part of the specification of a job request.
 * <p>
 * If an attribute implements {@link DocAttribute DocAttribute} as well as
 * {@code PrintRequestAttribute}, the client may include the attribute in a
 * {@code Doc}'s attribute set to specify a job setting which pertains just to
 * that doc.
 *
 * @author Alan Kaminsky
 * @see DocAttributeSet
 * @see PrintRequestAttributeSet
 */
public interface PrintRequestAttribute extends Attribute {
}
