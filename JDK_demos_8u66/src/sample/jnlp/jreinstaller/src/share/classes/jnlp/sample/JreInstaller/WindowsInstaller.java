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
import javax.swing.JOptionPane;

/**
 *
 * @version 1.14 05/15/03
 */
public class WindowsInstaller  {

    private static final String JAVAWS_REBOOT_FLAG_FILE = "jawsboot.ini";

    /**
     * Executes the passed in string, returning true if the process
     * succesfully completes, otherwise false.
     */
    public static boolean execute(String execString) {
        Config.trace("execute !" + execString + "!");
        try {
            Process p = Runtime.getRuntime().exec(execString);
            p.waitFor();
        }
        catch (IOException ioe) {
            Config.trace("Got exception: " + ioe);
            return false;
        }
        catch (InterruptedException ie) {
            Config.trace("Got exception: " + ie);
            return false;
        }
        return true;
    }

    /** Creates a temp. ISS file used to launch Windows installer */
    static File createTempISSScript(String jrepath, String version) throws IOException {
        if (jrepath.endsWith("\\")) {
            jrepath = jrepath.substring(0, jrepath.length() - 1);
        }
        String script = null;

        if (version.equals("1.4.1_02")) {
            script =
                "[InstallShield Silent]\n" +
                "Version=v6.00.000\n" +
                "File=Response File\n" +
                "[File Transfer]\n" +
                "OverwrittenReadOnly=NoToAll\n" +
                "[{EFCE5837-FC21-11D6-9D24-00010240CE95}-DlgOrder]\n" +
                "Dlg0={EFCE5837-FC21-11D6-9D24-00010240CE95}-SdLicense-0\n" +
                "Count=3\n" +
                "Dlg1={EFCE5837-FC21-11D6-9D24-00010240CE95}-SetupType-0\n" +
                "Dlg2={EFCE5837-FC21-11D6-9D24-00010240CE95}-SdAskDestPath-0\n" +
                "[{EFCE5837-FC21-11D6-9D24-00010240CE95}-SdLicense-0]\n" +
                "Result=1\n" +
                "[{EFCE5837-FC21-11D6-9D24-00010240CE95}-SetupType-0]\n" +
                "Result=303\n" +
                "[{EFCE5837-FC21-11D6-9D24-00010240CE95}-SdAskDestPath-0]\n" +
                "szDir=" + jrepath + "\n" +
                "Result=1\n" +
                "[Application]\n" +
                "Name=Java 2 Runtime Environment, SE v" + version + "\n" +
                "Version=" + version + "\n" +
                "Company=JavaSoft\n" +
                "Lang=0009\n";
        } else if (Config.isHopper()) {
            script =
                "[InstallShield Silent]\n" +
                "Version=v6.00.000\n" +
                "File=Response File\n" +
                "[File Transfer]\n" +
                "OverwrittenReadOnly=NoToAll\n" +
                "[{CD0159C9-17FB-11D6-A76A-00B0D079AF64}-DlgOrder]\n" +
                "Dlg0={CD0159C9-17FB-11D6-A76A-00B0D079AF64}-SdLicense-0\n" +
                "Count=3\n" +
                "Dlg1={CD0159C9-17FB-11D6-A76A-00B0D079AF64}-SetupType-0\n" +
                "Dlg2={CD0159C9-17FB-11D6-A76A-00B0D079AF64}-SdAskDestPath-0\n" +
                "[{CD0159C9-17FB-11D6-A76A-00B0D079AF64}-SdLicense-0]\n" +
                "Result=1\n" +
                "[{CD0159C9-17FB-11D6-A76A-00B0D079AF64}-SetupType-0]\n" +
                "Result=303\n" +
                "[{CD0159C9-17FB-11D6-A76A-00B0D079AF64}-SdAskDestPath-0]\n" +
                "szDir=" + jrepath + "\n" +
                "Result=1\n" +
                "[Application]\n" +
                "Name=Java 2 Runtime Environment, SE v" + version + "\n" +
                "Version=" + version + "\n" +
                "Company=JavaSoft\n" +
                "Lang=0009\n";
        } else if (Config.isMerlin()) {
            script =
                "[InstallShield Silent]\n" +
                "Version=v6.00.000\n" +
                "File=Response File\n" +
                "[File Transfer]\n" +
                "OverwrittenReadOnly=NoToAll\n" +
                "[{F4588301-0A06-11D6-A761-00B0D079AF64}-DlgOrder]\n" +
                "Dlg0={EE21CE74-CD7F-11D5-A886-00B0D079AF64}-SdWelcome-0\n" +
                "Count=4\n" +
                "Dlg1={F4588301-0A06-11D6-A761-00B0D079AF64}-SdLicense-0\n" +
                "Dlg2={F4588301-0A06-11D6-A761-00B0D079AF64}-SdAskDestPath-0\n" +
                "Dlg3={F4588301-0A06-11D6-A761-00B0D079AF64}-SdAskOptions-0\n" +
                "[{F4588301-0A06-11D6-A761-00B0D079AF64}-SdWelcome-0]\n" +
                "Result=1\n" +
                "[{F4588301-0A06-11D6-A761-00B0D079AF64}-SdLicense-0]\n" +
                "Result=1\n" +
                "[{F4588301-0A06-11D6-A761-00B0D079AF64}-SdAskDestPath-0]\n" +
                "szDir=" + jrepath + "\n" +
                "Result=1\n" +
                "[{F4588301-0A06-11D6-A761-00B0D079AF64}-SdAskOptions-0]\n" +
                "Component-type=string\n" +
                "Component-count=0\n" +
                "Result=1\n" +
                "[Application]\n" +
                "Name=Java 2 Runtime Environment, SE v" + version + "\n" +
                "Version=" + version + "\n" +
                "Company=JavaSoft\n" +
                "Lang=0009\n";
        } else if (version.equals("1.3.1_08")) {
            script =
                "[InstallShield Silent]\n" +
                "Version=v6.00.000\n" +
                "File=Response File\n" +
                "[File Transfer]\n" +
                "OverwrittenReadOnly=NoToAll\n" +
                "[{B11CAD0E-0E0F-11D7-88BE-0050DA21757E}-DlgOrder]\n" +
                "Dlg0={B11CAD0E-0E0F-11D7-88BE-0050DA21757E}-SdLicense-0\n" +
                "Count=3\n" +
                "Dlg1={B11CAD0E-0E0F-11D7-88BE-0050DA21757E}-SdAskDestPath-0\n" +
                "Dlg2={B11CAD0E-0E0F-11D7-88BE-0050DA21757E}-SdAskOptions-0\n" +
                "[{B11CAD0E-0E0F-11D7-88BE-0050DA21757E}-SdLicense-0]\n" +
                "Result=1\n" +
                "[{B11CAD0E-0E0F-11D7-88BE-0050DA21757E}-SdAskDestPath-0]\n" +
                "szDir=" + jrepath + "\n" +
                "Result=1\n" +
                "[{B11CAD0E-0E0F-11D7-88BE-0050DA21757E}-SdAskOptions-0]\n" +
                "Component-type=string\n" +
                "Component-count=0\n" +
                "Result=1\n" +
                "[Application]\n" +
                "Name=Java 2 Runtime Environment, SE v" + version + "\n" +
                "Version=" + version + "\n" +
                "Company=JavaSoft\n" +
                "Lang=0009\n";
        } else {
            script =
                "[InstallShield Silent]\n" +
                "Version=v5.00.000\n" +
                "File=Response File\n" +
                "[DlgOrder]\n" +
                "Dlg0=SdLicense-0\n" +
                "Dlg2=SdFinishReboot-0\n" +
                "Count=3\n" +
                "Dlg1=SdAskDestPath-0\n" +
                "[SdLicense-0]\n" +
                "Result=1\n" +
                "[SdAskDestPath-0]\n" +
                "szDir=" + jrepath + "\n" +
                "Result=1\n" +
                "[Application]\n" +
                "Name=Java Runtime Environment\n" +
                "Version=" + version + "\n" +
                "Company=JavaSoft\n" +
                "Lang=0009\n" +
                "[SdFinishReboot-0]\n" +
                "Result=1\n" +
                "BootOption=0\n";
        }

        File result = File.createTempFile("jre", "iss");
        result.deleteOnExit();
        PrintStream out  = new PrintStream(new FileOutputStream(result));
        out.println(script);
        out.close();
        return result;
    }

    /** Windows reboot manager */

    /**
     * Checks the version of the MSVCRT.DLL. If the version is too old,
     * the user is asked if they would like to reboot, otherwise JavaWS is
     * restarted.
     */
    static public boolean IsRebootNecessary() {
        long versionMS = getLongHexResource(Config.getMsvcrtVersionMS());
        long versionLS = getLongHexResource(Config.getMsvcrtVersionLS());

        Config.trace("versions: " + versionMS + " " + versionLS);

        File tmp = null;
        File flagFile = null;
        try {
            tmp = File.createTempFile("javaws", "tmp");
            if (tmp != null) {
                flagFile = new File(tmp.getParent() + File.separator +
                                    JAVAWS_REBOOT_FLAG_FILE);
                tmp.delete();
            }
        } catch (IOException ioe) {
        }
        if (new WindowsInstaller().needsReboot(versionMS, versionLS) ||
            (flagFile != null && Config.isHopper() && flagFile.exists())) {
            Config.trace("needs reboot");
            return true;
        }
        return false;
    }

    /**
     * Prompts the user if they would like to reboot now, or later. If they
     * want to reboot now, <code>reboot</code>is invoked.
     */
    public static boolean askUserForReboot() {
        String message = Config.getRebootMessage();
        String title = Config.getRebootTitle();
        Object[] options = new Object[] {
            Config.getRebootNowString(),
                Config.getRebootLaterString()
        };
        if (JOptionPane.showOptionDialog(null, message, title, -1,
                                         JOptionPane.QUESTION_MESSAGE,
                                         null, options, options[0]) == 0) {
            WinRegistry.doReboot();
            return true;
        }
        return false;
    }

    /**
     * Returns the resource named <code>key</code> this is a hex value
     * as a long.
     */
    static private long getLongHexResource(String value)
        throws MissingResourceException {
        long retValue = 0;
        int length = value.length();
        for (int counter = 0; counter < length; counter++) {
            char aChar = value.charAt(counter);
            retValue *= 16;
            if (Character.isDigit(aChar)) {
                retValue += (aChar - '0');
            }
            else if (aChar >= 'a' && aChar <= 'f') {
                retValue += (10 + aChar - 'a');
            }
            else if (aChar >= 'A' && aChar <= 'F') {
                retValue += (10 + aChar - 'A');
            }
        }
        return retValue;
    }

    /**
     * Native method that returns true if the current version of the JRE
     * is less than the passed in version.
     */
    private native boolean needsReboot(long versionMS, long versionLS);

    /**
     * Native method to do a reboot.
     */
    private native void reboot();
}
