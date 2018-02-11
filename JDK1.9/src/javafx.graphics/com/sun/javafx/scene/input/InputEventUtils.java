/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.input;

import com.sun.javafx.scene.CameraHelper;
import com.sun.javafx.scene.NodeHelper;
import com.sun.javafx.scene.SceneHelper;
import com.sun.javafx.scene.SceneUtils;
import com.sun.javafx.scene.SubSceneHelper;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.SubScene;
import javafx.scene.input.PickResult;
import javafx.scene.input.TransferMode;

/**
 * Utility class for helper methods needed by input events.
 */
public class InputEventUtils {

    /**
     * Recomputes event coordinates for a different node.
     * @param coordinates Coordinates to recompute
     * @param oldSource Node in whose coordinate system the coordinates are
     * @param newSource Node to whose coordinate system to recompute
     * @return the recomputed coordinates
     */
    public static Point3D recomputeCoordinates(PickResult result,
            Object newSource) {

        Point3D coordinates = result.getIntersectedPoint();
        if (coordinates == null) {
            return new Point3D(Double.NaN, Double.NaN, Double.NaN);
        }

        final Node oldSourceNode = result.getIntersectedNode();

        final Node newSourceNode =
                (newSource instanceof Node) ? (Node) newSource : null;

        final SubScene oldSubScene =
                (oldSourceNode == null ? null : NodeHelper.getSubScene(oldSourceNode));
        final SubScene newSubScene =
                (newSourceNode == null ? null : NodeHelper.getSubScene(newSourceNode));
        final boolean subScenesDiffer = (oldSubScene != newSubScene);

        if (oldSourceNode != null) {
            // transform to scene/nearest-subScene coordinates
            coordinates = oldSourceNode.localToScene(coordinates);
            if (subScenesDiffer && oldSubScene != null) {
                // transform to scene coordiantes
                coordinates = SceneUtils.subSceneToScene(oldSubScene, coordinates);
            }
        }

        if (newSourceNode != null) {
            if (subScenesDiffer && newSubScene != null) {
                // flatten the coords to flat mouse coordinates - project
                // by scene's camera
                Point2D planeCoords = CameraHelper.project(
                        SceneHelper.getEffectiveCamera(newSourceNode.getScene()),
                        coordinates);
                // convert the point to subScene coordinates
                planeCoords = SceneUtils.sceneToSubScenePlane(newSubScene, planeCoords);
                // compute inner intersection with the subScene's camera
                // projection plane
                if (planeCoords == null) {
                    coordinates = null;
                } else {
                    coordinates = CameraHelper.pickProjectPlane(
                            SubSceneHelper.getEffectiveCamera(newSubScene),
                            planeCoords.getX(), planeCoords.getY());
                }
            }
            // transform the point to source's local coordinates
            if (coordinates != null) {
                coordinates = newSourceNode.sceneToLocal(coordinates);
            }
            if (coordinates == null) {
                coordinates = new Point3D(Double.NaN, Double.NaN, Double.NaN);
            }
        }

        return coordinates;
    }

    private static final List<TransferMode> TM_ANY =
            Collections.unmodifiableList(Arrays.asList(
                TransferMode.COPY,
                TransferMode.MOVE,
                TransferMode.LINK
            ));

    private static final List<TransferMode> TM_COPY_OR_MOVE =
            Collections.unmodifiableList(Arrays.asList(
                TransferMode.COPY,
                TransferMode.MOVE
            ));

    /**
     * Makes sure changes to the static arrays specified in TransferMode
     * don't have any effect on the transfer modes used.
     * @param modes Modes passed in by user
     * @return list containing the passed modes. If one of the static arrays
     *         is passed, the expected modes are returned regardless of the
     *         values in those arrays.
     */
    public static List<TransferMode> safeTransferModes(TransferMode[] modes) {
        if (modes == TransferMode.ANY) {
            return TM_ANY;
        } else if (modes == TransferMode.COPY_OR_MOVE) {
            return TM_COPY_OR_MOVE;
        } else {
            return Arrays.asList(modes);
        }
    }
}
