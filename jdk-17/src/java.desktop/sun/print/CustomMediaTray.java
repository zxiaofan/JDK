/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.print;

import java.io.Serial;
import java.util.ArrayList;

import javax.print.attribute.EnumSyntax;
import javax.print.attribute.standard.Media;
import javax.print.attribute.standard.MediaTray;

public class CustomMediaTray extends MediaTray {
    private static ArrayList<String> customStringTable = new ArrayList<>();
    private static ArrayList<MediaTray> customEnumTable = new ArrayList<>();
    private String choiceName;

    private CustomMediaTray(int x) {
        super(x);

    }

    private static synchronized int nextValue(String name) {
      customStringTable.add(name);
      return (customStringTable.size()-1);
    }


    public CustomMediaTray(String name, String choice) {
        super(nextValue(name));
        choiceName = choice;
        customEnumTable.add(this);
    }

    /**
     * Use serialVersionUID from JDK 1.5 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 1019451298193987013L;


    /**
     * Returns the command string for this media tray.
     */
    public String getChoiceName() {
        return choiceName;
    }


    /**
     * Returns the string table for super class MediaTray.
     */
    public Media[] getSuperEnumTable() {
      return (Media[])super.getEnumValueTable();
    }


    /**
     * Returns the string table for class CustomMediaTray.
     */
    protected String[] getStringTable() {
      String[] nameTable = new String[customStringTable.size()];
      return customStringTable.toArray(nameTable);
    }

    /**
     * Returns the enumeration value table for class CustomMediaTray.
     */
    protected EnumSyntax[] getEnumValueTable() {
      MediaTray[] enumTable = new MediaTray[customEnumTable.size()];
      return customEnumTable.toArray(enumTable);
    }

}
