/*
 * Copyright (c) 1994, 2011, Oracle and/or its affiliates. All rights reserved.
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

package sun.net;

import java.io.*;
import java.util.Vector;

/**
 * This class implements that basic intefaces of transfer protocols.
 * It is used by subclasses implementing specific protocols.
 *
 * @author      Jonathan Payne
 * @see         sun.net.ftp.FtpClient
 * @see         sun.net.nntp.NntpClient
 */

public class TransferProtocolClient extends NetworkClient {
    static final boolean debug = false;

    /** Array of strings (usually 1 entry) for the last reply
        from the server. */
    protected Vector<String> serverResponse = new Vector<>(1);

    /** code for last reply */
    protected int       lastReplyCode;


    /**
     * Pulls the response from the server and returns the code as a
     * number. Returns -1 on failure.
     */
    public int readServerResponse() throws IOException {
        StringBuilder   replyBuf = new StringBuilder(32);
        int             c;
        int             continuingCode = -1;
        int             code;
        String          response;

        serverResponse.setSize(0);
        while (true) {
            while ((c = serverInput.read()) != -1) {
                if (c == '\r') {
                    if ((c = serverInput.read()) != '\n')
                        replyBuf.append('\r');
                }
                replyBuf.append((char)c);
                if (c == '\n')
                    break;
            }
            response = replyBuf.toString();
            replyBuf.setLength(0);
            if (debug) {
                System.out.print(response);
            }

            if (response.isEmpty()) {
                code = -1;
            } else {
                try {
                    code = Integer.parseInt(response, 0, 3, 10);
                } catch (NumberFormatException e) {
                    code = -1;
                } catch (IndexOutOfBoundsException e) {
                    /* this line doesn't contain a response code, so
                       we just completely ignore it */
                    continue;
                }
            }
            serverResponse.addElement(response);
            if (continuingCode != -1) {
                /* we've seen a XXX- sequence */
                if (code != continuingCode ||
                    (response.length() >= 4 && response.charAt(3) == '-')) {
                    continue;
                } else {
                    /* seen the end of code sequence */
                    continuingCode = -1;
                    break;
                }
            } else if (response.length() >= 4 && response.charAt(3) == '-') {
                continuingCode = code;
                continue;
            } else {
                break;
            }
        }

        return lastReplyCode = code;
    }

    /** Sends command <i>cmd</i> to the server. */
    public void sendServer(String cmd) {
        serverOutput.print(cmd);
        if (debug) {
            System.out.print("Sending: " + cmd);
        }
    }

    /** converts the server response into a string. */
    public String getResponseString() {
        return serverResponse.elementAt(0);
    }

    /** Returns all server response strings. */
    public Vector<String> getResponseStrings() {
        return serverResponse;
    }

    /** standard constructor to host <i>host</i>, port <i>port</i>. */
    public TransferProtocolClient(String host, int port) throws IOException {
        super(host, port);
    }

    /** creates an uninitialized instance of this class. */
    public TransferProtocolClient() {}
}
