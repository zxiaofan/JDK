/*
 * Copyright (c) 2000, 2010, Oracle and/or its affiliates. All rights reserved.
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

public class TestParser {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("usage: java TestParser [file name]");
      System.err.println("File name may be an .exe, .dll or .obj");
      System.exit(1);
    }

    try {
      COFFFile file = COFFFileParser.getParser().parse(args[0]);
      if (file.isImage()) {
        System.out.println("PE Image detected.");
      } else {
        System.out.println("PE Image NOT detected, assuming object file.");
      }
      COFFHeader header = file.getHeader();
      int numSections = header.getNumberOfSections();
      System.out.println(numSections + " sections detected.");
      for (int i = 1; i <= numSections; i++) {
        SectionHeader secHeader = header.getSectionHeader(i);
        System.out.println(secHeader.getName());
      }

      // FIXME: the DLL exports are not contained in the COFF symbol
      // table. Instead, they are in the Export Table, one of the
      // Optional Header Data Directories available from the Optional
      // Header. Must implement that next.

      /*
      int numSymbols = header.getNumberOfSymbols();
      System.out.println(numSymbols + " symbols detected.");
      System.out.println("Symbol dump:");
      for (int i = 0; i < header.getNumberOfSymbols(); i++) {
        COFFSymbol sym = header.getCOFFSymbol(i);
        System.out.println("  " + sym.getName());
      }
      */

      // OK, let's give the exported symbols a shot
      OptionalHeader optHdr = header.getOptionalHeader();
      OptionalHeaderDataDirectories ddirs = optHdr.getDataDirectories();
      ExportDirectoryTable exports = ddirs.getExportDirectoryTable();
      System.out.println("Export flags (should be 0): " + exports.getExportFlags());
      System.out.println("DLL name (from export directory table): " +
                         exports.getDLLName());
      int numSymbols = exports.getNumberOfNamePointers();
      System.out.println(numSymbols + " exported symbols detected:");
      for (int i = 0; i < numSymbols; i++) {
        System.out.println("  " + exports.getExportName(i));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
