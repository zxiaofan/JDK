/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.formats.html;

import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

import jdk.javadoc.internal.doclets.formats.html.markup.ContentBuilder;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree;
import jdk.javadoc.internal.doclets.formats.html.markup.Text;
import jdk.javadoc.internal.doclets.toolkit.AnnotationTypeOptionalMemberWriter;
import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.MemberSummaryWriter;


/**
 * Writes annotation type optional member documentation in HTML format.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class AnnotationTypeOptionalMemberWriterImpl extends
        AnnotationTypeRequiredMemberWriterImpl
    implements AnnotationTypeOptionalMemberWriter, MemberSummaryWriter {

    /**
     * Construct a new AnnotationTypeOptionalMemberWriterImpl.
     *
     * @param writer         the writer that will write the output.
     * @param annotationType the AnnotationType that holds this member.
     */
    public AnnotationTypeOptionalMemberWriterImpl(SubWriterHolderWriter writer,
        TypeElement annotationType) {
        super(writer, annotationType);
    }

    @Override
    public Content getMemberSummaryHeader(TypeElement typeElement,
            Content memberSummaryTree) {
        memberSummaryTree.add(selectComment(
                MarkerComments.START_OF_ANNOTATION_TYPE_OPTIONAL_MEMBER_SUMMARY,
                MarkerComments.START_OF_ANNOTATION_INTERFACE_OPTIONAL_MEMBER_SUMMARY));
        Content memberTree = new ContentBuilder();
        writer.addSummaryHeader(this, memberTree);
        return memberTree;
    }

    @Override
    public void addSummary(Content summariesList, Content content) {
        writer.addSummary(HtmlStyle.memberSummary,
                HtmlIds.ANNOTATION_TYPE_OPTIONAL_ELEMENT_SUMMARY, summariesList, content);
    }

    @Override
    public void addDefaultValueInfo(Element member, Content annotationDocTree) {
        if (utils.isAnnotationType(member)) {
            ExecutableElement ee = (ExecutableElement) member;
            AnnotationValue value = ee.getDefaultValue();
            if (value != null) {
                Content dl = HtmlTree.DL(HtmlStyle.notes);
                dl.add(HtmlTree.DT(contents.default_));
                dl.add(HtmlTree.DD(Text.of(value.toString())));
                annotationDocTree.add(dl);
            }
        }
    }

    @Override
    public void addSummaryLabel(Content memberTree) {
        Content label = HtmlTree.HEADING(Headings.TypeDeclaration.SUMMARY_HEADING,
                contents.annotateTypeOptionalMemberSummaryLabel);
        memberTree.add(label);
    }

    @Override
    protected Content getCaption() {
        return contents.getContent("doclet.Annotation_Type_Optional_Members");
    }

    @Override
    public TableHeader getSummaryTableHeader(Element member) {
        return new TableHeader(contents.modifierAndTypeLabel,
                contents.annotationTypeOptionalMemberLabel, contents.descriptionLabel);
    }
}
