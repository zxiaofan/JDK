/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang;

import java.io.IOException;
import java.lang.Process;

/* This class is for the exclusive use of ProcessBuilder.start() to
 * create new processes.
 *
 * @author Martin Buchholz
 * @version %I%, %E%
 * @since   1.5
 */

final class ProcessImpl
{
    private ProcessImpl() {}	// Not instantiable

    private static byte[] toCString(String s) {
	if (s == null)
	    return null;
	byte[] bytes = s.getBytes();
	byte[] result = new byte[bytes.length + 1];
	System.arraycopy(bytes, 0,
			 result, 0,
			 bytes.length);
	result[result.length-1] = (byte)0;
	return result;
    }

    // Only for use by ProcessBuilder.start()
    static Process start(String[] cmdarray,
			 java.util.Map<String,String> environment,
			 String dir,
			 boolean redirectErrorStream)
	throws IOException
    {
	assert cmdarray != null && cmdarray.length > 0;

	// Convert arguments to a contiguous block; it's easier to do
	// memory management in Java than in C.
	byte[][] args = new byte[cmdarray.length-1][];
	int size = args.length; // For added NUL bytes
	for (int i = 0; i < args.length; i++) {
	    args[i] = cmdarray[i+1].getBytes();
	    size += args[i].length;
	}
	byte[] argBlock = new byte[size];
	int i = 0;
	for (byte[] arg : args) {
	    System.arraycopy(arg, 0, argBlock, i, arg.length);
	    i += arg.length + 1;
	    // No need to write NUL bytes explicitly
	}

	int[] envc = new int[1];
	byte[] envBlock = ProcessEnvironment.toEnvironmentBlock(environment, envc);
	
	return new UNIXProcess
	    (toCString(cmdarray[0]),
	     argBlock, args.length,
	     envBlock, envc[0],
	     toCString(dir),
	     redirectErrorStream);
    }
}
