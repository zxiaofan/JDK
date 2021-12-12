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
 * Interface {@code DocAttribute} is a tagging interface which a printing
 * attribute class implements to indicate the attribute denotes a setting for a
 * doc. ("Doc" is a short, easy-to-pronounce term that means "a piece of print
 * data.") The client may include a {@code DocAttribute} in a {@code Doc}'s
 * attribute set to specify a characteristic of that doc. If an attribute
 * implements {@link PrintRequestAttribute PrintRequestAttribute} as well as
 * {@code DocAttribute}, the client may include the attribute in a attribute set
 * which specifies a print job to specify a characteristic for all the docs in
 * that job.
 *
 * @author Alan Kaminsky
 * @see DocAttributeSet
 * @see PrintRequestAttributeSet
 */
public interface DocAttribute extends Attribute {
}
