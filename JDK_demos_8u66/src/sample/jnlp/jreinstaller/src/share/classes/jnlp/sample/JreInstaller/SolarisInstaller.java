package sample.jnlp.jreinstaller.src.share.classes.jnlp.sample.JreInstaller;
/*
 * Copyright (c) 2006, 2010, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * Neither the name of Oracle nor the names of contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MICROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */


import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;
import java.util.zip.*;


class EatInput implements Runnable {
    InputStream _is;
    String _name;

    EatInput(String name, InputStream is) {
        _name = name;
        _is = is;
    }

    public void run() {
        Config.trace("EatInput " + _name + " started");
        byte[] buffer = new byte[1024];
        try {
            while(true) {
                int n = _is.read(buffer);
            }
        } catch(IOException ioe) {
            Config.trace("EatInput " + _name + ": " + ioe);
        }
    }
}

/**
 * Some installs require user intervention with the installer for it to
 * complete. This class allows you to define the strings that are to be
 * expected from the output of the process. When a matching string has been
 * found, a string can then be passed back to the process.
 * <p>The strings to wait for and respond with are defined in the properties
 * file.
 * <code>install.waitStringx</code> gives the wait string for the x'th
 * pass, with <code>install.responseStringx</code> giveing the wait string
 * for the x'th iteration (starting at 0).
 *
 * @version 1.13 03/04/03
 */
public class SolarisInstaller  {

    /**
     * Overriden to interact with the process. After starting the
     * process the string <code>Config.getWaitString</code> is waited for, and
     * if <code>Config.getResponseString</code> is non null, it is passed to
     * the process. This is repeated until <code>Config.getWaitString</code> returns
     * null, at which point the process is waited for to complete. If
     * successful true is returned, otherwise false is returned.
     */
    public static  boolean execute(String execString) {
        Config.trace("Executing: " + execString);

        Process p;
        try {
            p = Runtime.getRuntime().exec(execString);
        }
        catch (IOException ioe) {
            return false;
        }

        final InputStream processIS = p.getInputStream();
        final InputStream processES = p.getErrorStream();
        final OutputStream processOS = p.getOutputStream();

        int counter = 0;
        String waitString;
        boolean failed = false;
        try {
            while ((waitString = Config.getWaitString(counter)) != null) {
                String responseString = Config.getResponseString(counter);
                responseString += '\n';
                Config.trace("Waiting for: " + waitString +
                                 " response: " + responseString);
                if (waitFor(waitString, processIS)) {
                    if (responseString != null) {
                        processOS.write(responseString.getBytes());
                        processOS.flush();
                    }
                }
                counter++;
            }

            EatInput isEatInput = new EatInput("is", processIS);
            EatInput esEatInput = new EatInput("es", processIS);
            new Thread(isEatInput).start();
            new Thread(esEatInput).start();


            // Wait for the process to finish
            Config.trace("Wating for process to finish");
            try {
                p.waitFor();
            } catch (InterruptedException ie) {
                Config.trace("Got interrupt exception: " + ie);
                return false;
            }

            // cleanup
            try {
                processOS.close();
            }
            catch (IOException ioe) {}

            Config.trace("Process ended");

            try {
                processIS.close();
            }
            catch (IOException ioe) {}


            return true;
        } catch (IOException ioe) {
            Config.trace("Got IO exception: " + ioe);
            return false;
        }
    }

    /**
     * Reads from the InputStream <code>is</code>, waiting for the String
     * matching <code>string</code> to be read. This assumes that
     * <code>string</code> will be encountered once, and that after
     * <code>string</code> has been read no more bytes will be able to
     * be read.
     */
    static private boolean waitFor(String string, InputStream is)
        throws IOException {
        int length = string.length();
        byte[] buff = new byte[length];
        int read;
        String content = "";

        // PENDING: we may want to not use read, but instead first use
        // available and then read to avoid blocking if the correct response
        // is never seen.
        while ((read = is.read(buff)) > 0) {
            String readStr = new String(buff, 0, 0, read);
            int cl = content.length();
            if (cl < length * 4) {
                content += readStr;
            } else {
                content = content.substring(read) + readStr;
            }
            if (content.indexOf(string) != -1) {
                Config.trace("match");
                return true;
            }
        }

        Config.trace("failed to find match");
        // failed
        return false;
    }


    /** Creates a temp. shell script used to launch UNIX installer */
    static File createTempShellScript() throws IOException {
        String script =
            "#!/bin/sh\n" +
            "# This script is executed by the java Installer with the directory\n" +
            "# to install to as well as the real install script to execute.\n" +
            "# This script is used instead of /bin/sh cd $0; /bin/sh $1 as I couldn't\n" +
            "# get it to work inside java.\n" +
            "cd $1\n" +
            "/bin/sh $2\n";

        File result = File.createTempFile("jre", "sh");
        result.deleteOnExit();
        PrintStream out  = new PrintStream(new FileOutputStream(result));
        out.println(script);
        out.close();
        return result;
    }
}
