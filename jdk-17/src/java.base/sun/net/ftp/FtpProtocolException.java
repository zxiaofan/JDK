/*
 * Copyright (c) 1994, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown to indicate that the FTP server reported an error.
 * For instance that the requested file doesn't exist or
 * that a command isn't supported.
 * <p>The specific error code can be retreived with {@link #getReplyCode() }.</p>
 * @author      Jonathan Payne
 */
public class FtpProtocolException extends Exception {
    @java.io.Serial
    private static final long serialVersionUID = 5978077070276545054L;
    private final FtpReplyCode code;

    /**
     * Constructs a new {@code FtpProtocolException} from the
     * specified detail message. The reply code is set to unknow error.
     *
     * @param   detail   the detail message.
     */
    public FtpProtocolException(String detail) {
            super(detail);
            code = FtpReplyCode.UNKNOWN_ERROR;
    }

    /**
     * Constructs a new {@code FtpProtocolException} from the
     * specified response code and exception detail message
     *
     * @param   detail   the detail message.
     * @param   code The {@code FtpRelyCode} received from server.
     */
      public FtpProtocolException(String detail, FtpReplyCode code) {
        super(detail);
        this.code = code;
    }

    /**
     * Gets the reply code sent by the server that led to this exception
     * being thrown.
     *
     * @return The {@link FtpReplyCode} associated with that exception.
     */
    public FtpReplyCode getReplyCode() {
        return code;
    }
}
