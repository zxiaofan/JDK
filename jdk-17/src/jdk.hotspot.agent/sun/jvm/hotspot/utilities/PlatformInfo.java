/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.utilities;

/** Provides canonicalized OS and CPU information for the rest of the
    system. */

public class PlatformInfo {
  /* Returns "win32" if Windows; "linux" if Linux. */
  public static String getOS() throws UnsupportedPlatformException {
    String os = System.getProperty("os.name");
    if (os.equals("Linux")) {
      return "linux";
    } else if (os.equals("FreeBSD")) {
      return "bsd";
    } else if (os.equals("NetBSD")) {
      return "bsd";
    } else if (os.equals("OpenBSD")) {
      return "bsd";
    } else if (os.contains("Darwin") || os.contains("OS X")) {
      return "darwin";
    } else if (os.startsWith("Windows")) {
      return "win32";
    } else {
      throw new UnsupportedPlatformException("Operating system " + os + " not yet supported");
    }
  }

  public static boolean knownCPU(String cpu) {
    final String[] KNOWN =
        new String[] {"i386", "x86", "x86_64", "amd64", "ppc64", "ppc64le", "aarch64"};

    for(String s : KNOWN) {
      if(s.equals(cpu))
        return true;
    }

    return false;
  }

  /* Returns "x86" for x86 based platforms and x86_64 for 64bit x86
     based platform. Otherwise returns the value of os.arch. If the
     value is not recognized as supported, an exception is thrown
     instead. */

  public static String getCPU() throws UnsupportedPlatformException {
    String cpu = System.getProperty("os.arch");

    // Check that CPU is supported
    if (!knownCPU(cpu)) {
       throw new UnsupportedPlatformException("CPU type " + cpu + " not yet supported");
    }

    // Tweeks
    if (cpu.equals("i386"))
      return "x86";

    if (cpu.equals("x86_64"))
      return "amd64";

    if (cpu.equals("ppc64le"))
      return "ppc64";

    return cpu;

  }

  // this main is invoked from Makefile to make platform specific agent Makefile(s).
  public static void main(String[] args) {
    System.out.println(getOS());
  }
}
