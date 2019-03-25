/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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
package sun.swing.plaf.synth;

import javax.swing.plaf.synth.*;
import java.util.*;
import java.util.regex.*;

/**
 * <b>WARNING:</b> This class is an implementation detail and is only
 * public so that it can be used by two packages. You should NOT consider
 * this public API.
 * <p>
 * StyleAssociation is used to lookup a style for a particular
 * component (or region).
 *
 * @author Scott Violet
 */
public class StyleAssociation {
    /**
     * The style
     */
    private SynthStyle _style;

    /**
     * Pattern used for matching.
     */
    private Pattern _pattern;
    /**
     * Matcher used for testing if path matches that of pattern.
     */
    private Matcher _matcher;

    /**
     * Identifier for this association.
     */
    private int _id;


    /**
     * Returns a StyleAssociation that can be used to determine if
     * a particular string matches the returned association.
     */
    public static StyleAssociation createStyleAssociation(
        String text, SynthStyle style)
        throws PatternSyntaxException {
        return createStyleAssociation(text, style, 0);
    }

    /**
     * Returns a StyleAssociation that can be used to determine if
     * a particular string matches the returned association.
     */
    public static StyleAssociation createStyleAssociation(
        String text, SynthStyle style, int id)
        throws PatternSyntaxException {
        return new StyleAssociation(text, style, id);
    }


    private StyleAssociation(String text, SynthStyle style, int id)
                 throws PatternSyntaxException {
        _style = style;
        _pattern = Pattern.compile(text);
        _id = id;
    }

    /**
     * Returns the developer specified identifier for this association, will
     * be <code>0</code> if an identifier was not specified when this
     * <code>StyleAssociation</code> was created.
     */
    public int getID() {
        return _id;
    }

    /**
     * Returns true if this <code>StyleAssociation</code> matches the
     * passed in CharSequence.
     *
     * @return true if this <code>StyleAssociation</code> matches the
     * passed in CharSequence.if this StyleAssociation.
     */
    public synchronized boolean matches(CharSequence path) {
        if (_matcher == null) {
            _matcher = _pattern.matcher(path);
        }
        else {
            _matcher.reset(path);
        }
        return _matcher.matches();
    }

    /**
     * Returns the text used in matching the string.
     *
     * @return the text used in matching the string.
     */
    public String getText() {
        return _pattern.pattern();
    }

    /**
     * Returns the style this association is mapped to.
     *
     * @return the style this association is mapped to.
     */
    public SynthStyle getStyle() {
        return _style;
    }
}
