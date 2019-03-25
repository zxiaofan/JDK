package com.sun.tools.javac.resources;

public final class version extends java.util.ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            { "full", "12+33" },
            { "jdk", "12" },
            { "release", "12" },
        };
    }
}
