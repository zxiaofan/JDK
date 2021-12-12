/*
 * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.www.protocol.mailto;

import java.net.URL;
import java.net.InetAddress;
import java.net.SocketPermission;
import java.io.*;
import java.security.Permission;

import jdk.internal.util.StaticProperty;
import sun.net.www.*;
import sun.net.smtp.SmtpClient;
import sun.net.www.ParseUtil;


/**
 * Handle mailto URLs. To send mail using a mailto URLConnection,
 * call <code>getOutputStream</code>, write the message to the output
 * stream, and close it.
 *
 */
public class MailToURLConnection extends URLConnection {
    InputStream is = null;
    OutputStream os = null;

    SmtpClient client;
    Permission permission;
    private int connectTimeout = -1;
    private int readTimeout = -1;

    MailToURLConnection(URL u) {
        super(u);

        MessageHeader props = new MessageHeader();
        props.add("content-type", "text/html");
        setProperties(props);
    }

    /**
     * Get the user's full email address - stolen from
     * HotJavaApplet.getMailAddress().
     */
    String getFromAddress() {
        String str = System.getProperty("user.fromaddr");
        if (str == null) {
            // Perform the property security check for user.name
            @SuppressWarnings("removal")
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkPropertyAccess("user.name");
            }
            str = StaticProperty.userName();
            if (str != null) {
                String host = System.getProperty("mail.host");
                if (host == null) {
                    try {
                        host = InetAddress.getLocalHost().getHostName();
                    } catch (java.net.UnknownHostException e) {
                    }
                }
                str += "@" + host;
            } else {
                str = "";
            }
        }
        return str;
    }

    public void connect() throws IOException {
        client = new SmtpClient(connectTimeout);
        client.setReadTimeout(readTimeout);
    }

    @Override
    public synchronized OutputStream getOutputStream() throws IOException {
        if (os != null) {
            return os;
        } else if (is != null) {
            throw new IOException("Cannot write output after reading input.");
        }
        connect();

        String to = ParseUtil.decode(url.getPath());
        client.from(getFromAddress());
        client.to(to);

        os = client.startMessage();
        return os;
    }

    @Override
    public Permission getPermission() throws IOException {
        if (permission == null) {
            connect();
            String host = client.getMailHost() + ":" + 25;
            permission = new SocketPermission(host, "connect");
        }
        return permission;
    }

    @Override
    public void setConnectTimeout(int timeout) {
        if (timeout < 0)
            throw new IllegalArgumentException("timeouts can't be negative");
        connectTimeout = timeout;
    }

    @Override
    public int getConnectTimeout() {
        return (connectTimeout < 0 ? 0 : connectTimeout);
    }

    @Override
    public void setReadTimeout(int timeout) {
        if (timeout < 0)
            throw new IllegalArgumentException("timeouts can't be negative");
        readTimeout = timeout;
    }

    @Override
    public int getReadTimeout() {
        return readTimeout < 0 ? 0 : readTimeout;
    }
}
