/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.fxml.builder;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.Set;
import java.util.StringTokenizer;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Builder;

/**
 * JavaFX font builder.
 */
public final class JavaFXFontBuilder extends AbstractMap<String, Object> implements Builder<Font> {
    private String      name = null;
    private double      size = 12D;
    private FontWeight  weight = null;
    private FontPosture posture = null;
    private URL         url     = null;

    @Override
    public Font build() {
        Font f;
        if ( url != null) {
            //TODO Implement some font name caching so that the font
            // is not constructed from the stream every time
            InputStream in = null;
            try {
                in = url.openStream();
                f = Font.loadFont(in, size);
            } catch( Exception e) {
                //TODO
                throw new RuntimeException( "Load of font file failed from " + url, e);
            } finally {
                try {
                    if ( in != null) {
                        in.close();
                    }
                } catch( Exception e) {
                    //TODO
                    e.printStackTrace();
                }
            }
        } else {
            if (weight == null && posture == null) {
                f = new Font(name, size);
            } else {
                if (weight == null) weight = FontWeight.NORMAL;
                if (posture == null) posture = FontPosture.REGULAR;
                f = Font.font(name, weight, posture, size);
            }
        }
        return f;
    }

    @Override
    public Object put(String key, Object value) {
        if ( "name".equals( key)) {
            if ( value instanceof URL) {
                url = (URL) value;
            } else {
                name = (String) value;
            }
        } else if ( "size".equals(key)) {
            size =  Double.parseDouble((String) value);
        } else if ( "style".equals(key)) {
            String style = (String) value;
            if ( style != null && style.length() > 0) {
                boolean isWeightSet = false;
                for( StringTokenizer st = new StringTokenizer( style, " "); st.hasMoreTokens(); ) {
                    String stylePart = st.nextToken();
                    FontWeight fw;
                    if ( !isWeightSet && (fw=FontWeight.findByName(stylePart)) != null) {
                        weight = fw;
                        isWeightSet = true;
                        continue;
                    }
                    FontPosture fp;
                    if ( (fp=FontPosture.findByName(stylePart)) != null) {
                        posture = fp;
                        continue;
                    }
                }
            }
        } else if ( "url".equals(key)) {
            if ( value instanceof URL) {
                url = (URL) value;
            } else {
                try {
                    url = new URL( value.toString());
                } catch( MalformedURLException e) {
                    //TODO Better exception
                    throw new IllegalArgumentException("Invalid url " + value.toString(), e);
                }
            }
        } else {
            throw new IllegalArgumentException("Unknown Font property: " + key);
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return false; // False in this context means that the property is NOT read only
    }

    @Override
    public Object get(Object key) {
        return null; // In certain cases, get is also required to return null for read-write "properties"
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        throw new UnsupportedOperationException();
    }
}
