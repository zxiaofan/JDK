/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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

package javax.tools;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;

/**
 * Forwards calls to a given file object.  Subclasses of this class
 * might override some of these methods and might also provide
 * additional fields and methods.
 *
 * @param <F> the kind of file object forwarded to by this object
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public class ForwardingJavaFileObject<F extends JavaFileObject>
    extends ForwardingFileObject<F>
    implements JavaFileObject
{

    /**
     * Creates a new instance of {@code ForwardingJavaFileObject}.
     * @param fileObject delegate to this file object
     */
    protected ForwardingJavaFileObject(F fileObject) {
        super(fileObject);
    }

    @Override
    public Kind getKind() {
        return fileObject.getKind();
    }

    @Override
    public boolean isNameCompatible(String simpleName, Kind kind) {
        return fileObject.isNameCompatible(simpleName, kind);
    }

    @Override
    public NestingKind getNestingKind() { return fileObject.getNestingKind(); }

    @Override
    public Modifier getAccessLevel()  { return fileObject.getAccessLevel(); }

}
