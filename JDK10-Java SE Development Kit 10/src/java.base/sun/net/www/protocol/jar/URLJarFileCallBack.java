/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.www.protocol.jar;

import java.io.*;
import java.net.*;
import java.util.jar.*;


/*
 * This interface is used to call back to sun.plugin package.
 */
public interface URLJarFileCallBack
{
        public JarFile retrieve (URL url) throws IOException;
}
