/*
 * Copyright (c) 1995, 2003, Oracle and/or its affiliates. All rights reserved.
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


package sun.tools.java;

import java.io.*;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public class BinaryCode implements Constants {
    int maxStack;               // maximum stack used by code
    int maxLocals;              // maximum locals used by code
    BinaryExceptionHandler exceptionHandlers[];
    BinaryAttribute atts;       // code attributes
    BinaryConstantPool cpool;   // constant pool of the class
    byte code[];                // the byte code

    /**
     * Construct the binary code from the code attribute
     */

    public
    BinaryCode(byte data[], BinaryConstantPool cpool, Environment env) {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(data));
        try {
            this.cpool = cpool;
            // JVM 4.7.4 CodeAttribute.max_stack
            this.maxStack = in.readUnsignedShort();
            // JVM 4.7.4 CodeAttribute.max_locals
            this.maxLocals = in.readUnsignedShort();
            // JVM 4.7.4 CodeAttribute.code_length
            int code_length = in.readInt();
            this.code = new byte[code_length];
            // JVM 4.7.4 CodeAttribute.code[]
            in.read(this.code);
            // JVM 4.7.4 CodeAttribute.exception_table_length
            int exception_count = in.readUnsignedShort();
            this.exceptionHandlers = new BinaryExceptionHandler[exception_count];
            for (int i = 0; i < exception_count; i++) {
                // JVM 4.7.4 CodeAttribute.exception_table.start_pc
                int start = in.readUnsignedShort();
                // JVM 4.7.4 CodeAttribute.exception_table.end_pc
                int end = in.readUnsignedShort();
                // JVM 4.7.4 CodeAttribute.exception_table.handler_pc
                int handler = in.readUnsignedShort();
                // JVM 4.7.4 CodeAttribute.exception_table.catch_type
                ClassDeclaration xclass = cpool.getDeclaration(env, in.readUnsignedShort());
                this.exceptionHandlers[i]  =
                    new BinaryExceptionHandler(start, end, handler, xclass);
            }
            this.atts = BinaryAttribute.load(in, cpool, ~0);
            if (in.available() != 0) {
                System.err.println("Should have exhausted input stream!");
            }
        } catch (IOException e) {
            throw new CompilerError(e);
        }
    }


    /**
     * Accessors
     */

    public BinaryExceptionHandler getExceptionHandlers()[] {
        return exceptionHandlers;
    }

    public byte getCode()[] { return code; }

    public int getMaxStack() { return maxStack; }

    public int getMaxLocals() { return maxLocals; }

    public BinaryAttribute getAttributes() { return atts; }

    /**
     * Load a binary class
     */
    public static
    BinaryCode load(BinaryMember bf, BinaryConstantPool cpool, Environment env) {
        byte code[] = bf.getAttribute(idCode);
        return (code != null) ? new BinaryCode(code, cpool, env) : null;
    }
}
