/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.org.jline.terminal.impl.jna.win;

import jdk.internal.org.jline.terminal.impl.jna.win.Kernel32.CHAR_INFO;
import jdk.internal.org.jline.terminal.impl.jna.win.Kernel32.CONSOLE_SCREEN_BUFFER_INFO;
import jdk.internal.org.jline.terminal.impl.jna.win.Kernel32.COORD;
import jdk.internal.org.jline.terminal.impl.jna.win.Kernel32.INPUT_RECORD;
import jdk.internal.org.jline.terminal.impl.jna.win.Kernel32.SMALL_RECT;

public class Kernel32Impl implements Kernel32 {

    static {
        System.loadLibrary("le");
        initIDs();
    }

    private static native void initIDs();

    @Override
    public native int WaitForSingleObject(Pointer in_hHandle, int in_dwMilliseconds);

    @Override
    public native Pointer GetStdHandle(int nStdHandle);

    @Override
    public native int GetConsoleOutputCP();

    @Override
    public native void FillConsoleOutputCharacter(Pointer in_hConsoleOutput, char in_cCharacter, int in_nLength, COORD in_dwWriteCoord, IntByReference out_lpNumberOfCharsWritten) throws LastErrorException;

    @Override
    public native void FillConsoleOutputAttribute(Pointer in_hConsoleOutput, short in_wAttribute, int in_nLength, COORD in_dwWriteCoord, IntByReference out_lpNumberOfAttrsWritten) throws LastErrorException;

    @Override
    public native void GetConsoleMode(Pointer in_hConsoleOutput, IntByReference out_lpMode) throws LastErrorException;

    @Override
    public native void GetConsoleScreenBufferInfo(Pointer in_hConsoleOutput, CONSOLE_SCREEN_BUFFER_INFO out_lpConsoleScreenBufferInfo) throws LastErrorException;

    @Override
    public native void ReadConsoleInput(Pointer in_hConsoleOutput, INPUT_RECORD[] out_lpBuffer, int in_nLength, IntByReference out_lpNumberOfEventsRead) throws LastErrorException;

    @Override
    public native void SetConsoleCursorPosition(Pointer in_hConsoleOutput, COORD in_dwCursorPosition) throws LastErrorException;

    @Override
    public native void SetConsoleMode(Pointer in_hConsoleOutput, int in_dwMode) throws LastErrorException;

    @Override
    public native void SetConsoleTextAttribute(Pointer in_hConsoleOutput, short in_wAttributes) throws LastErrorException;

    @Override
    public native void SetConsoleTitle(String in_lpConsoleTitle) throws LastErrorException;

    @Override
    public native void WriteConsoleW(Pointer in_hConsoleOutput, char[] in_lpBuffer, int in_nNumberOfCharsToWrite, IntByReference out_lpNumberOfCharsWritten, Pointer reserved_lpReserved) throws LastErrorException;

    @Override
    public native void ScrollConsoleScreenBuffer(Pointer in_hConsoleOutput, SMALL_RECT in_lpScrollRectangle, SMALL_RECT in_lpClipRectangle, COORD in_dwDestinationOrigin, CHAR_INFO in_lpFill) throws LastErrorException;

}
