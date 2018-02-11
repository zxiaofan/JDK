/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.encoding;

import com.sun.istack.internal.Nullable;
import com.sun.istack.internal.NotNull;

/**
 * @author Vivek Pandey
 */
public final class ContentTypeImpl implements com.sun.xml.internal.ws.api.pipe.ContentType {
    private final @NotNull String contentType;
    private final @NotNull String soapAction;
    private String accept;
    private final @Nullable String charset;
    private String boundary;
    private String boundaryParameter;
    private String rootId;
    private ContentType internalContentType;

    public ContentTypeImpl(String contentType) {
        this(contentType, null, null);
    }

    public ContentTypeImpl(String contentType, @Nullable String soapAction) {
        this(contentType, soapAction, null);
    }

    public ContentTypeImpl(String contentType, @Nullable String soapAction, @Nullable String accept) {
        this(contentType, soapAction, accept, null);
    }

    public ContentTypeImpl(String contentType, @Nullable String soapAction, @Nullable String accept, String charsetParam) {
        this.contentType = contentType;
        this.accept = accept;
        this.soapAction = getQuotedSOAPAction(soapAction);
        if (charsetParam == null) {
            String tmpCharset = null;
            try {
                internalContentType = new ContentType(contentType);
                tmpCharset = internalContentType.getParameter("charset");
                rootId = internalContentType.getParameter("start");
            } catch(Exception e) {
                //Ignore the parsing exception.
            }
            charset = tmpCharset;
        } else {
            charset = charsetParam;
        }
    }

    /**
     * Returns the character set encoding.
     *
     * @return returns the character set encoding.
     */
    public @Nullable String getCharSet() {
        return charset;
    }

    /** BP 1.1 R1109 requires SOAPAction too be a quoted value **/
    private String getQuotedSOAPAction(String soapAction){
        if(soapAction == null || soapAction.length() == 0){
            return "\"\"";
        }else if(soapAction.charAt(0) != '"' && soapAction.charAt(soapAction.length() -1) != '"'){
            //surround soapAction by double quotes for BP R1109
            return "\"" + soapAction + "\"";
        }else{
            return soapAction;
        }
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public String getSOAPActionHeader() {
        return soapAction;
    }

    @Override
    public String getAcceptHeader() {
        return accept;
    }

    public void setAcceptHeader(String accept) {
        this.accept = accept;
    }

    public String getBoundary() {
        if (boundary == null) {
            if (internalContentType == null) internalContentType = new ContentType(contentType);
            boundary = internalContentType.getParameter("boundary");
        }
        return boundary;
    }

    public void setBoundary(String boundary) {
        this.boundary = boundary;
    }

    public String getBoundaryParameter() {
        return boundaryParameter;
    }

    public void setBoundaryParameter(String boundaryParameter) {
        this.boundaryParameter = boundaryParameter;
    }

    public String getRootId() {
        if (rootId == null) {
            if (internalContentType == null) internalContentType = new ContentType(contentType);
            rootId = internalContentType.getParameter("start");
        }
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public static class Builder {
        public String contentType;
        public String soapAction;
        public String accept;
        public String charset;
        public ContentTypeImpl build() {
            return new ContentTypeImpl(contentType, soapAction, accept, charset);
        }
    }
}
