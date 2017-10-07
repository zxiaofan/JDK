/*
 * Copyright (c) 2009, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.ftp;

/**
 * This interface describes a parser for the FtpClient class. Such a parser is
 * used when listing a remote directory to transform text lines like:
 *      drwxr-xr-x      1 user01      ftp   512 Jan 29 23:32 prog
 * into FtpDirEntry instances.
 *
 * @see java.net.FtpClient#setFileParser(FtpDirParser)
 * @since 1.7
 */
public interface FtpDirParser {

    /**
     * Takes one line from a directory listing and returns an FtpDirEntry instance
     * based on the information contained.
     *
     * @param line a <code>String</code>, a line sent by the FTP server as a
     *        result of the LST command.
     * @return an <code>FtpDirEntry</code> instance.
     * @see java.net.FtpDirEntry
     */
    public FtpDirEntry parseLine(String line);
}
