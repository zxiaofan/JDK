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

package com.sun.xml.internal.ws.api.message;

import com.sun.istack.internal.Nullable;

/**
 * A set of {@link Attachment} on a {@link Message}.
 *
 * <p>
 * A particular attention is made to ensure that attachments
 * can be read and parsed lazily as requested.
 *
 * @see Message#getAttachments()
 */
public interface AttachmentSet extends Iterable<Attachment> {
    /**
     * Gets the attachment by the content ID.
     *
     * @param contentId
     *      The content ID like "foo-bar-zot@abc.com", without
     *      surrounding '&lt;' and '>' used as the transfer syntax.
     *
     * @return null
     *      if no such attachment exist.
     */
    @Nullable
    Attachment get(String contentId);

    /**
     * Returns true if there's no attachment.
     */
    boolean isEmpty();

    /**
     * Adds an attachment to this set.
     *
     * <p>
     * Note that it's OK for an {@link Attachment} to belong to
     * more than one {@link AttachmentSet} (which is in fact
     * necessary when you wrap a {@link Message} into another.
     *
     * @param att
     *      must not be null.
     */
    public void add(Attachment att);

}
