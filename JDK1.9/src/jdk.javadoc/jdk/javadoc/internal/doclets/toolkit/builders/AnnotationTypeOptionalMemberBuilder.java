/*
 * Copyright (c) 2003, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.builders;

import javax.lang.model.element.TypeElement;

import jdk.javadoc.internal.doclets.toolkit.AnnotationTypeOptionalMemberWriter;
import jdk.javadoc.internal.doclets.toolkit.AnnotationTypeRequiredMemberWriter;
import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.DocletException;
import jdk.javadoc.internal.doclets.toolkit.util.VisibleMemberMap;


/**
 * Builds documentation for optional annotation type members.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 * @author Bhavesh Patel (Modified)
 */
public class AnnotationTypeOptionalMemberBuilder extends AnnotationTypeRequiredMemberBuilder {

    /**
     * Construct a new AnnotationTypeMemberBuilder.
     *
     * @param context  the build context.
     * @param typeElement the class whose members are being documented.
     * @param writer the doclet specific writer.
     */
    private AnnotationTypeOptionalMemberBuilder(Context context,
            TypeElement typeElement,
            AnnotationTypeOptionalMemberWriter writer) {
        super(context, typeElement, writer,
                VisibleMemberMap.Kind.ANNOTATION_TYPE_MEMBER_OPTIONAL);
    }


    /**
     * Construct a new AnnotationTypeMemberBuilder.
     *
     * @param context  the build context.
     * @param typeElement the class whose members are being documented.
     * @param writer the doclet specific writer.
     * @return the new AnnotationTypeMemberBuilder
     */
    public static AnnotationTypeOptionalMemberBuilder getInstance(
            Context context, TypeElement typeElement,
            AnnotationTypeOptionalMemberWriter writer) {
        return new AnnotationTypeOptionalMemberBuilder(context,
                typeElement, writer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "AnnotationTypeOptionalMemberDetails";
    }

    /**
     * Build the annotation type optional member documentation.
     *
     * @param node the XML element that specifies which components to document
     * @param memberDetailsTree the content tree to which the documentation will be added
     * @throws DocletException if there is a problem while building the documentation
     */
    public void buildAnnotationTypeOptionalMember(XMLNode node, Content memberDetailsTree)
                throws DocletException {
        buildAnnotationTypeMember(node, memberDetailsTree);
    }

    /**
     * Build the default value for this optional member.
     *
     * @param node the XML element that specifies which components to document
     * @param annotationDocTree the content tree to which the documentation will be added
     */
    public void buildDefaultValueInfo(XMLNode node, Content annotationDocTree) {
        ((AnnotationTypeOptionalMemberWriter) writer).addDefaultValueInfo(currentMember,
                annotationDocTree);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnotationTypeRequiredMemberWriter getWriter() {
        return writer;
    }
}
