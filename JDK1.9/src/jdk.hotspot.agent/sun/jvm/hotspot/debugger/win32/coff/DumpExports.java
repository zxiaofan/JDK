/*
 * Copyright (c) 2001, 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.win32.coff;

public class DumpExports {
  private static void usage() {
    System.err.println("usage: java DumpExports [.dll name]");
    System.exit(1);
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      usage();
    }

    String filename = args[0];
    COFFFile file   = COFFFileParser.getParser().parse(filename);

    // get common point for both things we want to dump
    OptionalHeaderDataDirectories dataDirs = file.getHeader().getOptionalHeader().
        getDataDirectories();

    // dump the header data directory for the Export Table:
    DataDirectory dir = dataDirs.getExportTable();
    System.out.println("Export table: RVA = " + dir.getRVA() + "/0x" +
        Integer.toHexString(dir.getRVA()) + ", size = " + dir.getSize() + "/0x" +
        Integer.toHexString(dir.getSize()));

    System.out.println(file.getHeader().getNumberOfSections() + " sections in file");
    for (int i = 1; i <= file.getHeader().getNumberOfSections(); i++) {
      SectionHeader sec = file.getHeader().getSectionHeader(i);
      System.out.println("  Section " + i + ":");
      System.out.println("    Name = '" + sec.getName() + "'");
      System.out.println("    VirtualSize = " + sec.getSize() + "/0x" +
          Integer.toHexString(sec.getSize()));
      System.out.println("    VirtualAddress = " + sec.getVirtualAddress() + "/0x" +
          Integer.toHexString(sec.getVirtualAddress()));
      System.out.println("    SizeOfRawData = " + sec.getSizeOfRawData() + "/0x" +
          Integer.toHexString(sec.getSizeOfRawData()));
      System.out.println("    PointerToRawData = " + sec.getPointerToRawData() + "/0x" +
          Integer.toHexString(sec.getPointerToRawData()));
    }

    ExportDirectoryTable exports = dataDirs.getExportDirectoryTable();
    if (exports == null) {
      System.out.println("No exports found.");
    } else {
      System.out.println("DLL name: " + exports.getDLLName());
      System.out.println("Time/date stamp 0x" + Integer.toHexString(exports.getTimeDateStamp()));
      System.out.println("Major version 0x" + Integer.toHexString(exports.getMajorVersion() & 0xFFFF));
      System.out.println("Minor version 0x" + Integer.toHexString(exports.getMinorVersion() & 0xFFFF));
      System.out.println(exports.getNumberOfNamePointers() + " exports found");
      for (int i = 0; i < exports.getNumberOfNamePointers(); i++) {
        short ordinal = exports.getExportOrdinal(i);
        System.out.print("[" + i + "] '" + exports.getExportName(i) + "': [" +
            ordinal + "] = 0x" + Integer.toHexString(exports.getExportAddress(ordinal)));
        System.out.println(exports.isExportAddressForwarder(ordinal)
            ? "  Forwarded to '" + exports.getExportAddressForwarder(ordinal) + "'"
            : "");
      }
    }
  }
}
