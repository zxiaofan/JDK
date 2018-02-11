/*
 * Copyright (c) 1998, 2015, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.text;

import java.io.IOException;

/**
 * ChangedCharSetException as the name indicates is an exception
 * thrown when the charset is changed.
 *
 * @author Sunita Mani
 */
@SuppressWarnings("serial") // Same-version serialization only
public class ChangedCharSetException extends IOException {

    String charSetSpec;
    boolean charSetKey;

    /**
     * Constructs a {@code ChangedCharSetException}.
     * @param charSetSpec name of the char set specification
     * @param charSetKey char set key
     */
    public ChangedCharSetException(String charSetSpec, boolean charSetKey) {
        this.charSetSpec = charSetSpec;
        this.charSetKey = charSetKey;
    }

    /**
     * Returns the char set specification.
     * @return the char set specification
     */
    public String getCharSetSpec() {
        return charSetSpec;
    }

    /**
     * Returns the char set key.
     * @return the char set key
     */
    public boolean keyEqualsCharSet() {
        return charSetKey;
    }

}
