/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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
 */



package jdk.tools.jaotc;

final class Timer implements AutoCloseable {

    private final Main main;
    private final long start;

    Timer(Main main, String message) {
        this.main = main;
        start = System.currentTimeMillis();
        main.printer.printInfo(message);
    }

    @Override
    public void close() {
        final long end = System.currentTimeMillis();
        main.printer.printlnInfo(" (" + (end - start) + " ms)");
    }

}
