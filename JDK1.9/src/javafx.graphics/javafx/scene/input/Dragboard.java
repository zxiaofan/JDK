/*
 * Copyright (c) 2000, 2016, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.input;

import java.security.Permission;
import java.util.Set;

import com.sun.javafx.scene.input.DragboardHelper;
import com.sun.javafx.tk.PermissionHelper;
import com.sun.javafx.tk.TKClipboard;
import com.sun.javafx.tk.TKScene;
import javafx.scene.image.Image;

/**
 * A drag and drop specific {@link Clipboard}.
 * @since JavaFX 2.0
 */
public final class Dragboard extends Clipboard {

    /**
     * Whether access to the data requires a permission.
     */
    private boolean dataAccessRestricted = true;

    Dragboard(TKClipboard peer) {
        super(peer);
    }

    @Override
    Object getContentImpl(DataFormat dataFormat) {
        if (dataAccessRestricted) {
            PermissionHelper.checkClipboardPermission();
        }
        return super.getContentImpl(dataFormat);
    }

    /**
     * Gets set of transport modes supported by source of this drag opeation.
     * @return set of supported transfer modes
     */
    public final Set<TransferMode> getTransferModes() {
        return peer.getTransferModes();
    }

    TKClipboard getPeer() {
        return peer;
    }

    static Dragboard createDragboard(TKClipboard peer) {
        return new Dragboard(peer);
    }

    // PENDING_DOC_REVIEW
    /**
     * Sets the visual representation of data being transfered
     * in a drag and drop gesture.
     * Uses the given image for the drag view with the offsetX and offsetY
     * specifying cursor position over the image.
     * This method should be called only when starting drag and drop operation
     * in the DRAG_DETECTED handler, calling it at other times
     * doesn't have any effect.
     * @param image image to use for the drag view
     * @param offsetX x position of the cursor over the image
     * @param offsetY y position of the cursor over the image
     * @since JavaFX 8.0
     */
    public void setDragView(Image image, double offsetX, double offsetY) {
        peer.setDragView(image);
        peer.setDragViewOffsetX(offsetX);
        peer.setDragViewOffsetY(offsetY);
    }

    /**
     * Sets the visual representation of data being transfered
     * in a drag and drop gesture.
     * This method should be called only when starting drag and drop operation
     * in the DRAG_DETECTED handler, calling it at other times
     * doesn't have any effect.
     * @param image image to use for the drag view
     * @since JavaFX 8.0
     */
    public void setDragView(Image image) {
        peer.setDragView(image);
    }

    /**
     * Sets the x position of the cursor of the drag view image.
     * This method should be called only when starting drag and drop operation
     * in the DRAG_DETECTED handler, calling it at other times
     * doesn't have any effect.
     * @param offsetX x position of the cursor over the image
     * @since JavaFX 8.0
     */
    public void setDragViewOffsetX(double offsetX) {
        peer.setDragViewOffsetX(offsetX);
    }

    /**
     * Sets the y position of the cursor of the drag view image.
     * This method should be called only when starting drag and drop operation
     * in the DRAG_DETECTED handler, calling it at other times
     * doesn't have any effect.
     * @param offsetY y position of the cursor over the image
     * @since JavaFX 8.0
     */
    public void setDragViewOffsetY(double offsetY) {
        peer.setDragViewOffsetY(offsetY);
    }

    /**
     * Gets the image used as a drag view.
     * This method returns meaningful value only when starting drag and drop
     * operation in the DRAG_DETECTED handler, it returns null at other times.
     * @return the image used as a drag view
     * @since JavaFX 8.0
     */
    public Image getDragView() {
        return peer.getDragView();
    }

    /**
     * Gets the x position of the cursor of the drag view image.
     * This method returns meaningful value only when starting drag and drop
     * operation in the DRAG_DETECTED handler, it returns 0 at other times.
     * @return x position of the cursor over the image
     * @since JavaFX 8.0
     */
    public double getDragViewOffsetX() {
        return peer.getDragViewOffsetX();
    }

    /**
     * Gets the y position of the cursor of the drag view image.
     * This method returns meaningful value only when starting drag and drop
     * operation in the DRAG_DETECTED handler, it returns 0 at other times.
     * @return y position of the cursor over the image
     * @since JavaFX 8.0
     */
    public double getDragViewOffsetY() {
        return peer.getDragViewOffsetY();
    }

    static {
        // This is used by classes in different packages to get access to
        // private and package private methods.
        DragboardHelper.setDragboardAccessor(new DragboardHelper.DragboardAccessor() {

            @Override
            public void setDataAccessRestriction(Dragboard dragboard, boolean restricted) {
                dragboard.dataAccessRestricted = restricted;
            }

            @Override
            public TKClipboard getPeer(Dragboard dragboard) {
                return dragboard.getPeer();
            }

            @Override
            public Dragboard createDragboard(TKClipboard peer) {
                return Dragboard.createDragboard(peer);
            }
        });
    }
}
