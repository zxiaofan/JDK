/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.formats.html;

import java.io.*;

import com.sun.javadoc.*;
import com.sun.tools.doclets.formats.html.markup.*;
import com.sun.tools.doclets.internal.toolkit.*;
import com.sun.tools.doclets.internal.toolkit.util.*;

/**
 * Writes nested class documentation in HTML format.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Robert Field
 * @author Atul M Dambalkar
 * @author Jamie Ho (rewrite)
 * @author Bhavesh Patel (Modified)
 */
@Deprecated
public class NestedClassWriterImpl extends AbstractMemberWriter
    implements MemberSummaryWriter {

    public NestedClassWriterImpl(SubWriterHolderWriter writer,
            ClassDoc classdoc) {
        super(writer, classdoc);
    }

    public NestedClassWriterImpl(SubWriterHolderWriter writer) {
        super(writer);
    }

    /**
     * {@inheritDoc}
     */
    public Content getMemberSummaryHeader(ClassDoc classDoc,
            Content memberSummaryTree) {
        memberSummaryTree.addContent(HtmlConstants.START_OF_NESTED_CLASS_SUMMARY);
        Content memberTree = writer.getMemberTreeHeader();
        writer.addSummaryHeader(this, classDoc, memberTree);
        return memberTree;
    }

    /**
     * {@inheritDoc}
     */
    public void addMemberTree(Content memberSummaryTree, Content memberTree) {
        writer.addMemberTree(memberSummaryTree, memberTree);
    }

    /**
     * Close the writer.
     */
    public void close() throws IOException {
        writer.close();
    }

    public int getMemberKind() {
        return VisibleMemberMap.INNERCLASSES;
    }

    /**
     * {@inheritDoc}
     */
    public void addSummaryLabel(Content memberTree) {
        Content label = HtmlTree.HEADING(HtmlConstants.SUMMARY_HEADING,
                writer.getResource("doclet.Nested_Class_Summary"));
        memberTree.addContent(label);
    }

    /**
     * {@inheritDoc}
     */
    public String getTableSummary() {
        return configuration.getText("doclet.Member_Table_Summary",
                configuration.getText("doclet.Nested_Class_Summary"),
                configuration.getText("doclet.nested_classes"));
    }

    /**
     * {@inheritDoc}
     */
    public Content getCaption() {
        return configuration.getResource("doclet.Nested_Classes");
    }

    /**
     * {@inheritDoc}
     */
    public String[] getSummaryTableHeader(ProgramElementDoc member) {
        String[] header;
        if (member.isInterface()) {
            header = new String[] {
                writer.getModifierTypeHeader(),
                configuration.getText("doclet.0_and_1",
                        configuration.getText("doclet.Interface"),
                        configuration.getText("doclet.Description"))
            };
        }
        else {
            header = new String[] {
                writer.getModifierTypeHeader(),
                configuration.getText("doclet.0_and_1",
                        configuration.getText("doclet.Class"),
                        configuration.getText("doclet.Description"))
            };
        }
        return header;
    }

    /**
     * {@inheritDoc}
     */
    public void addSummaryAnchor(ClassDoc cd, Content memberTree) {
        memberTree.addContent(writer.getMarkerAnchor(
                SectionName.NESTED_CLASS_SUMMARY));
    }

    /**
     * {@inheritDoc}
     */
    public void addInheritedSummaryAnchor(ClassDoc cd, Content inheritedTree) {
        inheritedTree.addContent(writer.getMarkerAnchor(
                SectionName.NESTED_CLASSES_INHERITANCE,
                cd.qualifiedName()));
    }

    /**
     * {@inheritDoc}
     */
    public void addInheritedSummaryLabel(ClassDoc cd, Content inheritedTree) {
        Content classLink = writer.getPreQualifiedClassLink(
                LinkInfoImpl.Kind.MEMBER, cd, false);
        Content label = new StringContent(cd.isInterface() ?
            configuration.getText("doclet.Nested_Classes_Interface_Inherited_From_Interface") :
            configuration.getText("doclet.Nested_Classes_Interfaces_Inherited_From_Class"));
        Content labelHeading = HtmlTree.HEADING(HtmlConstants.INHERITED_SUMMARY_HEADING,
                label);
        labelHeading.addContent(writer.getSpace());
        labelHeading.addContent(classLink);
        inheritedTree.addContent(labelHeading);
    }

    /**
     * {@inheritDoc}
     */
    protected void addSummaryLink(LinkInfoImpl.Kind context, ClassDoc cd, ProgramElementDoc member,
            Content tdSummary) {
        Content memberLink = HtmlTree.SPAN(HtmlStyle.memberNameLink,
                writer.getLink(new LinkInfoImpl(configuration, context, (ClassDoc)member)));
        Content code = HtmlTree.CODE(memberLink);
        tdSummary.addContent(code);
    }

    /**
     * {@inheritDoc}
     */
    protected void addInheritedSummaryLink(ClassDoc cd,
            ProgramElementDoc member, Content linksTree) {
        linksTree.addContent(
                writer.getLink(new LinkInfoImpl(configuration, LinkInfoImpl.Kind.MEMBER,
                (ClassDoc)member)));
    }

    /**
     * {@inheritDoc}
     */
    protected void addSummaryType(ProgramElementDoc member,
            Content tdSummaryType) {
        ClassDoc cd = (ClassDoc)member;
        addModifierAndType(cd, null, tdSummaryType);
    }

    /**
     * {@inheritDoc}
     */
    protected Content getDeprecatedLink(ProgramElementDoc member) {
        return writer.getQualifiedClassLink(LinkInfoImpl.Kind.MEMBER,
                (ClassDoc)member);
    }

    /**
     * {@inheritDoc}
     */
    protected Content getNavSummaryLink(ClassDoc cd, boolean link) {
        if (link) {
            if (cd == null) {
                return writer.getHyperLink(
                        SectionName.NESTED_CLASS_SUMMARY,
                        writer.getResource("doclet.navNested"));
            } else {
                return writer.getHyperLink(
                        SectionName.NESTED_CLASSES_INHERITANCE,
                        cd.qualifiedName(), writer.getResource("doclet.navNested"));
            }
        } else {
            return writer.getResource("doclet.navNested");
        }
    }

    /**
     * {@inheritDoc}
     */
    protected void addNavDetailLink(boolean link, Content liNav) {
    }
}
