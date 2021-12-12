/*
 * Copyright (c) 2006, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.util;

import com.sun.source.doctree.DocCommentTree;
import com.sun.source.doctree.DocTree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A path of tree nodes, typically used to represent the sequence of ancestor
 * nodes of a tree node up to the top-level {@code DocCommentTree} node.
 *
 * @since 1.8
 */
public class DocTreePath implements Iterable<DocTree> {
    /**
     * Returns a documentation tree path for a tree node within a compilation unit,
     * or {@code null} if the node is not found.
     * @param treePath the path for the node with which the doc comment is associated
     * @param doc the doc comment associated with the node
     * @param target a node within the doc comment
     * @return a path identifying the target within the tree
     */
    public static DocTreePath getPath(TreePath treePath, DocCommentTree doc, DocTree target) {
        return getPath(new DocTreePath(treePath, doc), target);
    }

    /**
     * Returns a documentation tree path for a tree node within a subtree
     * identified by a {@code DocTreePath} object, or {@code null} if the node is not found.
     * @param path a path identifying a node within a doc comment tree
     * @param target a node to be located within the given node
     * @return a path identifying the target node
     */
    public static DocTreePath getPath(DocTreePath path, DocTree target) {
        Objects.requireNonNull(path); //null check
        Objects.requireNonNull(target); //null check

        class Result extends Error {
            static final long serialVersionUID = -5942088234594905625L;
            DocTreePath path;
            Result(DocTreePath path) {
                this.path = path;
            }
        }

        class PathFinder extends DocTreePathScanner<DocTreePath,DocTree> {
            @Override
            public DocTreePath scan(DocTree tree, DocTree target) {
                if (tree == target) {
                    throw new Result(new DocTreePath(getCurrentPath(), target));
                }
                return super.scan(tree, target);
            }
        }

        if (path.getLeaf() == target) {
            return path;
        }

        try {
            new PathFinder().scan(path, target);
        } catch (Result result) {
            return result.path;
        }
        return null;
    }

    /**
     * Creates a {@code DocTreePath} for a root node.
     *
     * @param treePath the {@code TreePath} from which the root node was created
     * @param t the {@code DocCommentTree} to create the path for
     */
    public DocTreePath(TreePath treePath, DocCommentTree t) {
        this.treePath = treePath;
        this.docComment = Objects.requireNonNull(t);
        this.parent = null;
        this.leaf = t;
    }

    /**
     * Creates a {@code DocTreePath} for a child node.
     * @param p the parent node
     * @param t the child node
     */
    public DocTreePath(DocTreePath p, DocTree t) {
        if (t.getKind() == DocTree.Kind.DOC_COMMENT) {
            throw new IllegalArgumentException("Use DocTreePath(TreePath, DocCommentTree) to construct DocTreePath for a DocCommentTree.");
        } else {
            treePath = p.treePath;
            docComment = p.docComment;
            parent = p;
        }
        leaf = t;
    }

    /**
     * Returns the {@code TreePath} associated with this path.
     * @return the {@code TreePath} for this {@code DocTreePath}
     */
    public TreePath getTreePath() {
        return treePath;
    }

    /**
     * Returns the {@code DocCommentTree} associated with this path.
     * @return the {@code DocCommentTree} for this {@code DocTreePath}
     */
    public DocCommentTree getDocComment() {
        return docComment;
    }

    /**
     * Returns the leaf node for this path.
     * @return the {@code DocTree} for this {@code DocTreePath}
     */
    public DocTree getLeaf() {
        return leaf;
    }

    /**
     * Returns the path for the enclosing node, or {@code null} if there is no enclosing node.
     * @return {@code DocTreePath} of parent
     */
    public DocTreePath getParentPath() {
        return parent;
    }

    @Override
    public Iterator<DocTree> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public DocTree next() {
                if (next == null) {
                    throw new NoSuchElementException();
                }
                DocTree t = next.leaf;
                next = next.parent;
                return t;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            private DocTreePath next = DocTreePath.this;
        };
    }

    private final TreePath treePath;
    private final DocCommentTree docComment;
    private final DocTree leaf;
    private final DocTreePath parent;
}
