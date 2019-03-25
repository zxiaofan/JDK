/*
 * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.geom;

final class Edge {
    static final int INIT_PARTS = 4;
    static final int GROW_PARTS = 10;

    Curve curve;
    int ctag;
    int etag;
    double activey;
    int equivalence;

    public Edge(Curve c, int ctag) {
        this(c, ctag, AreaOp.ETAG_IGNORE);
    }

    public Edge(Curve c, int ctag, int etag) {
        this.curve = c;
        this.ctag = ctag;
        this.etag = etag;
    }

    public Curve getCurve() {
        return curve;
    }

    public int getCurveTag() {
        return ctag;
    }

    public int getEdgeTag() {
        return etag;
    }

    public void setEdgeTag(int etag) {
        this.etag = etag;
    }

    public int getEquivalence() {
        return equivalence;
    }

    public void setEquivalence(int eq) {
        equivalence = eq;
    }

    private Edge lastEdge;
    private int lastResult;
    private double lastLimit;

    public int compareTo(Edge other, double[] yrange) {
        if (other == lastEdge && yrange[0] < lastLimit) {
            if (yrange[1] > lastLimit) {
                yrange[1] = lastLimit;
            }
            return lastResult;
        }
        if (this == other.lastEdge && yrange[0] < other.lastLimit) {
            if (yrange[1] > other.lastLimit) {
                yrange[1] = other.lastLimit;
            }
            return 0-other.lastResult;
        }
        //long start = System.currentTimeMillis();
        int ret = curve.compareTo(other.curve, yrange);
        //long end = System.currentTimeMillis();
        /*
        System.out.println("compare: "+
                           ((System.identityHashCode(this) <
                             System.identityHashCode(other))
                            ? this+" to "+other
                            : other+" to "+this)+
                           " == "+ret+" at "+yrange[1]+
                           " in "+(end-start)+"ms");
         */
        lastEdge = other;
        lastLimit = yrange[1];
        lastResult = ret;
        return ret;
    }

    public void record(double yend, int etag) {
        this.activey = yend;
        this.etag = etag;
    }

    public boolean isActiveFor(double y, int etag) {
        return (this.etag == etag && this.activey >= y);
    }

    public String toString() {
        return ("Edge["+curve+
                ", "+
                (ctag == AreaOp.CTAG_LEFT ? "L" : "R")+
                ", "+
                (etag == AreaOp.ETAG_ENTER ? "I" :
                 (etag == AreaOp.ETAG_EXIT ? "O" : "N"))+
                "]");
    }
}
