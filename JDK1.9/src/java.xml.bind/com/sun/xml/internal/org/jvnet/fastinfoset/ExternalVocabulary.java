/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.org.jvnet.fastinfoset;

/**
 * An external vocabulary.
 * <p>
 * An external vocabulary has a URI that refers to a vocabulary.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public class ExternalVocabulary {

    /**
     * A URI that refers to the external vocabulary.
     */
    public final String URI;

    /**
     * The vocabulary that is refered to by the URI.
     */
    public final Vocabulary vocabulary;

    public ExternalVocabulary(String URI, Vocabulary vocabulary) {
        if (URI == null || vocabulary == null) {
            throw new IllegalArgumentException();
        }

        this.URI = URI;
        this.vocabulary = vocabulary;
    }
}
