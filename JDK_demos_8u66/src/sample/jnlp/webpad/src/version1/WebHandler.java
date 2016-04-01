package sample.jnlp.webpad.src.version1;
/*
 * Copyright (c) 2006, 2010, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * Neither the name of Oracle nor the names of contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MICROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */

import javax.jnlp.BasicService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import java.io.*;
import java.net.*;

public class WebHandler {


    static private BasicService _bs = null;

    static public boolean isEnabled() {
        return true;
    }

    static public void publish(String txt) {
        // Construct POST request (Heavily inspired from
        // JavaWorld TIP 34)
        URL url = getPublishURL();

        try {
            URLConnection urlConn = url.openConnection();
            // Let the run-time system (RTS) know that we want input.
            urlConn.setDoInput (true);
            // Let the RTS know that we want to do output.
            urlConn.setDoOutput (true);
            // No caching, we want the real thing.
            urlConn.setUseCaches (false);
            // Specify the content type.
            urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Send POST output.
            DataOutputStream printout = new DataOutputStream (urlConn.getOutputStream());
            String content = "contents=" + URLEncoder.encode(txt);
            printout.writeBytes(content);
            printout.flush ();
            printout.close ();

            // Get response data.
            DataInputStream input = new DataInputStream (urlConn.getInputStream ());
            String str;
            while (null != ((str = input.readLine()))) {
                System.out.println (str);
            }
            input.close ();
        } catch(IOException ioe) {
            ioe.printStackTrace(System.out);
        }
    };

    static public void show() {
        initialize();
        _bs.showDocument(getPublishURL());
    };

    static private URL getPublishURL() {
        String location = System.getProperty("jnlp.publish-url");
        System.out.println(location);
        try {
            return new URL(location);
        } catch(MalformedURLException mue) {
            mue.printStackTrace(System.out);
            return null;
        }
    }

    static private synchronized void initialize() {
        if (_bs != null) return;
        try {
            _bs  = (BasicService)ServiceManager.lookup("javax.jnlp.BasicService");
        } catch(UnavailableServiceException e) {
            _bs = null;
        }
    }
}
