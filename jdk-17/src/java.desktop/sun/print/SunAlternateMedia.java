/*
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.print;

import java.io.Serial;

import javax.print.attribute.Attribute;
import javax.print.attribute.PrintRequestAttribute;
import javax.print.attribute.standard.Media;

/*
 * An implementation class used by services which can distinguish media
 * by size and media by source. Values are expected to be MediaTray
 * instances, but this is not enforced by API.
 */
public class SunAlternateMedia implements PrintRequestAttribute {

    /**
     * Use serialVersionUID from JDK 1.5 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -8878868345472850201L;

    private Media media;

    public SunAlternateMedia(Media altMedia) {
        media = altMedia;
    }

    public Media getMedia() {
        return media;
    }

    public final Class<? extends Attribute> getCategory() {
        return SunAlternateMedia.class;
    }

    public final String getName() {
        return "sun-alternate-media";
    }

    public String toString() {
       return "alternate-media: " + media.toString();
    }

    /**
     * Returns a hash code value for this enumeration value. The hash code is
     * just this enumeration value's integer value.
     */
    public int hashCode() {
        return media.hashCode();
    }
}
