/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.font;

/**
 * Encapsulates the information that 2D needs to create a composite font,
 * the runtime representation of a logical font.
 */
public class CompositeFontDescriptor {

    private String faceName;
    private int coreComponentCount;
    private String[] componentFaceNames;
    private String[] componentFileNames;
    private int[] exclusionRanges;
    private int[] exclusionRangeLimits;

    /**
     * Constructs a composite font descriptor.
     * @param faceName the font face name, i.e., the family name suffixed
     *                 with ".plain", ".bold", ".italic", ".bolditalic".
     * @param coreComponentCount the number of core fonts, i.e., the ones
     *                 derived from a non-fallback sequence.
     * @param componentFaceNames the face names for the component fonts
     * @param componentFileNames the file names for the component fonts
     * @param exclusionRanges an array holding lower and upper boundaries
     *                 for all exclusion ranges for all component fonts
     * @param exclusionRangeLimits an array holding the limits of the
     *                 sections for each component font within the previous
     *                 array
     */
    public CompositeFontDescriptor(String faceName,
            int coreComponentCount,
            String[] componentFaceNames,
            String[] componentFileNames,
            int[] exclusionRanges,
            int[] exclusionRangeLimits) {
        this.faceName = faceName;
        this.coreComponentCount = coreComponentCount;
        this.componentFaceNames = componentFaceNames;
        this.componentFileNames = componentFileNames;
        this.exclusionRanges = exclusionRanges;
        this.exclusionRangeLimits = exclusionRangeLimits;
    }

    public String getFaceName() {
        return faceName;
    }

    public int getCoreComponentCount() {
        return coreComponentCount;
    }

    public String[] getComponentFaceNames() {
        return componentFaceNames;
    }

    public String[] getComponentFileNames() {
        return componentFileNames;
    }

    public int[] getExclusionRanges() {
        return exclusionRanges;
    }

    public int[] getExclusionRangeLimits() {
        return exclusionRangeLimits;
    }
}
