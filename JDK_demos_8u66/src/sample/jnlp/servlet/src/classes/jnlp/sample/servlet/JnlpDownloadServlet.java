package sample.jnlp.servlet.src.classes.jnlp.sample.servlet;
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


import java.io.*;
import java.util.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This Servlet class is an implementation of JNLP Specification's
 * Download Protocols.
 *
 * All requests to this servlet is in the form of HTTP GET commands.
 * The parameters that are needed are:
 * <ul>
 * <li><code>arch</code>,
 * <li><code>os</code>,
 * <li><code>locale</code>,
 * <li><code>version-id</code> or <code>platform-version-id</code>,
 * <li><code>current-version-id</code>,
 * <li>code>known-platforms</code>
 * </ul>
 * <p>
 *
 * @version 1.8 01/23/03
 */
public class JnlpDownloadServlet extends HttpServlet {

    // Localization
    private static ResourceBundle  _resourceBundle = null;

    // Servlet configuration
    private static final String PARAM_JNLP_EXTENSION    = "jnlp-extension";
    private static final String PARAM_JAR_EXTENSION     = "jar-extension";

    // Servlet configuration
    private Logger _log = null;

    private JnlpFileHandler _jnlpFileHandler = null;
    private JarDiffHandler  _jarDiffHandler = null;
    private ResourceCatalog _resourceCatalog = null;

    /** Initialize servlet */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);


        // Setup logging
        _log = new Logger(config, getResourceBundle());
        _log.addDebug("Initializing");

        // Get extension from Servlet configuration, or use default
        JnlpResource.setDefaultExtensions(
            config.getInitParameter(PARAM_JNLP_EXTENSION),
            config.getInitParameter(PARAM_JAR_EXTENSION));

        _jnlpFileHandler = new JnlpFileHandler(config.getServletContext(), _log);
        _jarDiffHandler = new JarDiffHandler(config.getServletContext(), _log);
        _resourceCatalog = new ResourceCatalog(config.getServletContext(), _log);
    }

    public static synchronized ResourceBundle getResourceBundle() {
        if (_resourceBundle == null) {
            _resourceBundle = ResourceBundle.getBundle("jnlp/sample/servlet/resources/strings");
        }
        return _resourceBundle;
    }


    public void doHead(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        handleRequest(request, response, true);
    }

    /** We handle get requests too - eventhough the spec. only requeres POST requests */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response, false);
    }

    private void handleRequest(HttpServletRequest request,
            HttpServletResponse response, boolean isHead) throws IOException {
        String requestStr = request.getRequestURI();
        if (request.getQueryString() != null) requestStr += "?" + request.getQueryString().trim();

        // Parse HTTP request
        DownloadRequest dreq = new DownloadRequest(getServletContext(), request);
        if (_log.isInformationalLevel()) {
            _log.addInformational("servlet.log.info.request",   requestStr);
            _log.addInformational("servlet.log.info.useragent", request.getHeader("User-Agent"));
        }
        if (_log.isDebugLevel()) {
            _log.addDebug(dreq.toString());
        }

        long ifModifiedSince = request.getDateHeader("If-Modified-Since");

        // Check if it is a valid request
        try {
            // Check if the request is valid
            validateRequest(dreq);

            // Decide what resource to return
            JnlpResource jnlpres = locateResource(dreq);
            _log.addDebug("JnlpResource: " + jnlpres);


            if (_log.isInformationalLevel()) {
                _log.addInformational("servlet.log.info.goodrequest", jnlpres.getPath());
            }

            DownloadResponse dres = null;

            if (isHead) {

                int cl =
                      jnlpres.getResource().openConnection().getContentLength();

                // head request response
                dres = DownloadResponse.getHeadRequestResponse(
                        jnlpres.getMimeType(), jnlpres.getVersionId(),
                        jnlpres.getLastModified(), cl);

            } else if (ifModifiedSince != -1 &&
                    (ifModifiedSince / 1000) >=
                    (jnlpres.getLastModified() / 1000)) {
                // We divide the value returned by getLastModified here by 1000
                // because if protocol is HTTP, last 3 digits will always be
                // zero.  However, if protocol is JNDI, that's not the case.
                // so we divide the value by 1000 to remove the last 3 digits
                // before comparison

                // return 304 not modified if possible
                _log.addDebug("return 304 Not modified");
                dres = DownloadResponse.getNotModifiedResponse();

            } else {

                // Return selected resource
                dres = constructResponse(jnlpres, dreq);
            }

            dres.sendRespond(response);

        } catch(ErrorResponseException ere) {
            if (_log.isInformationalLevel()) {
                _log.addInformational("servlet.log.info.badrequest", requestStr);
            }
            if (_log.isDebugLevel()) {
                _log.addDebug("Response: "+ ere.toString());
            }
            // Return response from exception
            ere.getDownloadResponse().sendRespond(response);
        } catch(Throwable e) {
            _log.addFatal("servlet.log.fatal.internalerror", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    /** Make sure that it is a valid request. This is also the place to implement the
     *  reverse IP lookup
     */
    private void validateRequest(DownloadRequest dreq) throws ErrorResponseException {
        String path = dreq.getPath();
        if (path.endsWith(ResourceCatalog.VERSION_XML_FILENAME) ||
            path.indexOf("__") != -1 ) {
            throw new ErrorResponseException(DownloadResponse.getNoContentResponse());
        }
    }

    /** Interprets the download request and convert it into a resource that is
     *  part of the Web Archive.
     */
    private JnlpResource locateResource(DownloadRequest dreq) throws IOException, ErrorResponseException {
        if (dreq.getVersion() == null) {
            return handleBasicDownload(dreq);
        } else {
            return handleVersionRequest(dreq);
        }
    }

    private JnlpResource handleBasicDownload(DownloadRequest dreq) throws ErrorResponseException, IOException {
        _log.addDebug("Basic Protocol lookup");
        // Do not return directory names for basic protocol
        if (dreq.getPath() == null || dreq.getPath().endsWith("/")) {
            throw new ErrorResponseException(DownloadResponse.getNoContentResponse());
        }
        // Lookup resource
        JnlpResource jnlpres = new JnlpResource(getServletContext(), dreq.getPath());
        if (!jnlpres.exists()) {
            throw new ErrorResponseException(DownloadResponse.getNoContentResponse());
        }
        return jnlpres;
    }

    private JnlpResource handleVersionRequest(DownloadRequest dreq) throws IOException, ErrorResponseException {
        _log.addDebug("Version-based/Extension based lookup");
        return _resourceCatalog.lookupResource(dreq);
    }

    /** Given a DownloadPath and a DownloadRequest, it constructs the data stream to return
     *  to the requester
     */
    private DownloadResponse constructResponse(JnlpResource jnlpres, DownloadRequest dreq) throws IOException {
        String path = jnlpres.getPath();
        if (jnlpres.isJnlpFile()) {
            // It is a JNLP file. It need to be macro-expanded, so it is handled differently
            boolean supportQuery = JarDiffHandler.isJavawsVersion(dreq, "1.5+");
            _log.addDebug("SupportQuery in Href: " + supportQuery);

            // only support query string in href for 1.5 and above
            if (supportQuery) {
                return _jnlpFileHandler.getJnlpFileEx(jnlpres, dreq);
            } else {
                return _jnlpFileHandler.getJnlpFile(jnlpres, dreq);
            }
        }

        // Check if a JARDiff can be returned
        if (dreq.getCurrentVersionId() != null && jnlpres.isJarFile()) {
            DownloadResponse response = _jarDiffHandler.getJarDiffEntry(_resourceCatalog, dreq, jnlpres);
            if (response != null) {
                _log.addInformational("servlet.log.info.jardiff.response");
                return response;
            }
        }

        // check and see if we can use pack resource
        JnlpResource jr =  new JnlpResource(getServletContext(),
                                    jnlpres.getName(),
                                    jnlpres.getVersionId(),
                                    jnlpres.getOSList(),
                                    jnlpres.getArchList(),
                                    jnlpres.getLocaleList(),
                                    jnlpres.getPath(),
                                    jnlpres.getReturnVersionId(),
                                    dreq.getEncoding());

        _log.addDebug("Real resource returned: " + jr);

        // Return WAR file resource
        return DownloadResponse.getFileDownloadResponse(jr.getResource(),
                                                        jr.getMimeType(),
                                                        jr.getLastModified(),
                                                        jr.getReturnVersionId());
    }
}
