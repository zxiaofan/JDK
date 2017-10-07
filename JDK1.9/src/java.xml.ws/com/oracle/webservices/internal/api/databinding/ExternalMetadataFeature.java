/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.oracle.webservices.internal.api.databinding;

import com.sun.xml.internal.ws.api.databinding.MetadataReader;
import com.sun.xml.internal.ws.model.ExternalMetadataReader;

import javax.xml.ws.WebServiceFeature;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * WebServiceFeature allowing to define either on server or client side external xml descriptors replacing/supplementing
 * WS metadata provided by class annotations. This can be useful if those annotations are missing (existing non-WS
 * components) or if it is necessary to override those.
 *
 * @author Miroslav Kos (miroslav.kos at oracle.com)
 */
public class ExternalMetadataFeature extends WebServiceFeature {

    private static final String ID = "com.oracle.webservices.internal.api.databinding.ExternalMetadataFeature";

    /**
     * Enable this feature.  Defaults to true.
     */
    private boolean enabled = true;

    private List<String> resourceNames;
    private List<File> files;
    private MetadataReader reader;

    private ExternalMetadataFeature() {
    }

    public void addResources(String... resourceNames) {
        if (this.resourceNames == null) {
            this.resourceNames = new ArrayList<String>();
        }
        Collections.addAll(this.resourceNames, resourceNames);
    }

    public List<String> getResourceNames() { return resourceNames; }

    public void addFiles(File... files) {
        if (this.files == null) {
            this.files = new ArrayList<File>();
        }
        Collections.addAll(this.files, files);
    }

    public List<File> getFiles() { return files; }

    public boolean isEnabled() {
        return enabled;
    }

    private void setEnabled(final boolean x) {
        enabled = x;
    }

    @Override
    public String getID() {
        return ID;
    }

    public MetadataReader getMetadataReader(ClassLoader classLoader, boolean disableXmlSecurity) {
        if (reader != null && enabled) return reader;
        return enabled ? new ExternalMetadataReader(files, resourceNames, classLoader, true, disableXmlSecurity) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExternalMetadataFeature that = (ExternalMetadataFeature) o;

        if (enabled != that.enabled) return false;
        if (files != null ? !files.equals(that.files) : that.files != null) return false;
        if (resourceNames != null ? !resourceNames.equals(that.resourceNames) : that.resourceNames != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (enabled ? 1 : 0);
        result = 31 * result + (resourceNames != null ? resourceNames.hashCode() : 0);
        result = 31 * result + (files != null ? files.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "[" + getID() +
                ", enabled=" + enabled +
                ", resourceNames=" + resourceNames +
                ", files=" + files +
                ']';
    }

    public static Builder builder() {
        return new Builder(new ExternalMetadataFeature());
    }

    public final static class Builder {
        final private ExternalMetadataFeature o;

        Builder(final ExternalMetadataFeature x) {
            o = x;
        }

        public ExternalMetadataFeature build() {
            return o;
        }

        public Builder addResources(String... res) {
            o.addResources(res);
            return this;
        }

        public Builder addFiles(File... files) {
            o.addFiles(files);
            return this;
        }

        public Builder setEnabled(boolean enabled) {
            o.setEnabled(enabled);
            return this;
        }

        public Builder setReader( MetadataReader r ) {
            o.reader = r;
            return this;
        }
    }
}
