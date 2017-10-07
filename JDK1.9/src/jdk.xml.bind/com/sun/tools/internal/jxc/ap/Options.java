/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.jxc.ap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.sun.tools.internal.xjc.BadCommandLineException;

/**
 * This stores the invocation configuration for
 * SchemaGenerator
 *
 * @author Bhakti Mehta
 */
public class Options  {

    public static final String DISABLE_XML_SECURITY = "-disableXmlSecurity";

    // honor CLASSPATH environment variable, but it will be overrided by -cp
    public String classpath = System.getenv("CLASSPATH");

    public File targetDir = null;

    public File episodeFile = null;

    private boolean disableXmlSecurity = false;

    // encoding is not required for JDK5, 6, but JDK 7 javac is much more strict - see issue 6859289
    public String encoding = null;

    public final List<String> arguments = new ArrayList<String>();

    public void parseArguments(String[] args) throws BadCommandLineException {
        for (int i = 0 ; i <args.length; i++) {
            if (args[i].charAt(0)== '-') {
                i += parseArgument(args, i);
            } else {
                arguments.add(args[i]);
            }
        }
    }

    private int parseArgument( String[] args, int i ) throws BadCommandLineException {
        if (args[i].equals("-d")) {
            if (i == args.length - 1)
                throw new BadCommandLineException(
                        (Messages.OPERAND_MISSING.format(args[i])));
            targetDir = new File(args[++i]);
            if( !targetDir.exists() )
                throw new BadCommandLineException(
                        Messages.NON_EXISTENT_FILE.format(targetDir));
            return 1;
        }

        if (args[i].equals("-episode")) {
            if (i == args.length - 1)
                throw new BadCommandLineException(
                        (Messages.OPERAND_MISSING.format(args[i])));
            episodeFile = new File(args[++i]);
            return 1;
        }

        if (args[i].equals(DISABLE_XML_SECURITY)) {
            disableXmlSecurity = true;
            return 0;
        }

        if (args[i].equals("-encoding")) {
            if (i == args.length - 1)
                throw new BadCommandLineException(
                        (Messages.OPERAND_MISSING.format(args[i])));
            encoding = args[++i];
            return 1;
        }

        if (args[i].equals("-cp") || args[i].equals("-classpath")) {
            if (i == args.length - 1)
                throw new BadCommandLineException(
                        (Messages.OPERAND_MISSING.format(args[i])));
            classpath = args[++i];

            return 1;
        }

        throw new BadCommandLineException(
                Messages.UNRECOGNIZED_PARAMETER.format(args[i]));
    }

    /**
     * @return the disableXmlSecurity
     */
    public boolean isDisableXmlSecurity() {
        return disableXmlSecurity;
    }



}
