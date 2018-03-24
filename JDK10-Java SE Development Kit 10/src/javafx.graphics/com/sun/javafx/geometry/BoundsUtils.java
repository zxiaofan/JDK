/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.geometry;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;

public final class BoundsUtils {
    private BoundsUtils() {}

    private static double min4(double v1, double v2, double v3, double v4) {
        return Math.min(Math.min(v1, v2), Math.min(v3, v4));
    }

    private static double min8(double v1, double v2, double v3, double v4,
                               double v5, double v6, double v7, double v8) {
        return Math.min(min4(v1, v2, v3, v4), min4(v5, v6, v7, v8));
    }

    private static double max4(double v1, double v2, double v3, double v4) {
        return Math.max(Math.max(v1, v2), Math.max(v3, v4));
    }

    private static double max8(double v1, double v2, double v3, double v4,
                               double v5, double v6, double v7, double v8) {
        return Math.max(max4(v1, v2, v3, v4), max4(v5, v6, v7, v8));
    }


    public static Bounds createBoundingBox(Point2D p1, Point2D p2, Point2D p3, Point2D p4,
                                           Point2D p5, Point2D p6, Point2D p7, Point2D p8) {

        if (p1 == null || p2 == null || p3 == null || p4 == null
                || p5 == null || p6 == null || p7 == null || p8 == null) {
            return null;
        }

        double minX = min8(p1.getX(), p2.getX(), p3.getX(), p4.getX(),
                p5.getX(), p6.getX(), p7.getX(), p8.getX());
        double maxX = max8(p1.getX(), p2.getX(), p3.getX(), p4.getX(),
                p5.getX(), p6.getX(), p7.getX(), p8.getX());

        double minY = min8(p1.getY(), p2.getY(), p3.getY(), p4.getY(),
                p5.getY(), p6.getY(), p7.getY(), p8.getY());
        double maxY = max8(p1.getY(), p2.getY(), p3.getY(), p4.getY(),
                p5.getY(), p6.getY(), p7.getY(), p8.getY());

        return new BoundingBox(minX, minY, maxX - minX, maxY - minY);
    }

    public static Bounds createBoundingBox(Point3D p1, Point3D p2, Point3D p3, Point3D p4,
                                           Point3D p5, Point3D p6, Point3D p7, Point3D p8) {

        if (p1 == null || p2 == null || p3 == null || p4 == null
                || p5 == null || p6 == null || p7 == null || p8 == null) {
            return null;
        }

        double minX = min8(p1.getX(), p2.getX(), p3.getX(), p4.getX(),
                p5.getX(), p6.getX(), p7.getX(), p8.getX());
        double maxX = max8(p1.getX(), p2.getX(), p3.getX(), p4.getX(),
                p5.getX(), p6.getX(), p7.getX(), p8.getX());

        double minY = min8(p1.getY(), p2.getY(), p3.getY(), p4.getY(),
                p5.getY(), p6.getY(), p7.getY(), p8.getY());
        double maxY = max8(p1.getY(), p2.getY(), p3.getY(), p4.getY(),
                p5.getY(), p6.getY(), p7.getY(), p8.getY());

        double minZ = min8(p1.getZ(), p2.getZ(), p3.getZ(), p4.getZ(),
                p5.getZ(), p6.getZ(), p7.getZ(), p8.getZ());
        double maxZ = max8(p1.getZ(), p2.getZ(), p3.getZ(), p4.getZ(),
                p5.getZ(), p6.getZ(), p7.getZ(), p8.getZ());

        return new BoundingBox(minX, minY, minZ, maxX - minX, maxY - minY, maxZ - minZ);
    }

    public static Bounds createBoundingBox(Point2D p1, Point2D p2, Point2D p3, Point2D p4) {

        if (p1 == null || p2 == null || p3 == null || p4 == null) {
            return null;
        }

        double minX = min4(p1.getX(), p2.getX(), p3.getX(), p4.getX());
        double maxX = max4(p1.getX(), p2.getX(), p3.getX(), p4.getX());
        double minY = min4(p1.getY(), p2.getY(), p3.getY(), p4.getY());
        double maxY = max4(p1.getY(), p2.getY(), p3.getY(), p4.getY());

        return new BoundingBox(minX, minY, maxX - minX, maxY - minY);
    }
}
