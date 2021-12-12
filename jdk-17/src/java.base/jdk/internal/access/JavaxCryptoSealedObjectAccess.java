/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.access;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SealedObject;
import java.io.IOException;
import java.io.ObjectInputStream;

public interface JavaxCryptoSealedObjectAccess {
    ObjectInputStream getExtObjectInputStream(
            SealedObject sealed, Cipher cipher)
            throws BadPaddingException, IllegalBlockSizeException, IOException;
}
