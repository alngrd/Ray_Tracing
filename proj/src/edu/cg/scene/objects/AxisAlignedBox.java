package edu.cg.scene.objects;

import edu.cg.algebra.*;


// TODO Implement this class which represents an axis aligned box
public class AxisAlignedBox extends Shape {
    private final static int NDIM = 3; // Number of dimensions
    private Point a = null;
    private Point b = null;
    private double[] aAsArray;
    private double[] bAsArray;

    public AxisAlignedBox(Point a, Point b) {
        this.a = a;
        this.b = b;
        // We store the points as Arrays - this could be helpful for more elegant implementation.
        aAsArray = a.asArray();
        bAsArray = b.asArray();
        assert (a.x <= b.x && a.y <= b.y && a.z <= b.z);
    }

    @Override
    public String toString() {
        String endl = System.lineSeparator();
        return "AxisAlignedBox:" + endl +
                "a: " + a + endl +
                "b: " + b + endl;
    }

    public AxisAlignedBox initA(Point a) {
        this.a = a;
        aAsArray = a.asArray();
        return this;
    }

    public AxisAlignedBox initB(Point b) {
        this.b = b;
        bAsArray = b.asArray();
        return this;
    }

    @Override
    public Hit intersect(Ray ray) {
        // TODO Implement:
        Plain[] boxPlains = new Plain[6];
        Hit[] boxHits = new Hit[6];
        Point[] hittingPoints = new Point[6];
        Vec[] normalsXYZ = {new Vec(1, 0, 0), new Vec(0, 1, 0), new Vec(0, 0, 1)};

        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                boxPlains[i] = new Plain(normalsXYZ[i], a);
            } else {
                boxPlains[i] = new Plain(normalsXYZ[i % 3], b);
            }

            boxHits[i] = boxPlains[i].intersect(ray);
            hittingPoints[i] = (boxHits[i] != null) ? ray.getHittingPoint(boxHits[i]) : null;
        }

        double bestT = Double.MAX_VALUE;
        int bestTInd = -1;

        for (int i = 0; i < 6; i++) {
            Point hit = hittingPoints[i];
            if ((hit != null) && isInRange(hit, a, b,i % 3)) {
                if (Math.abs(boxHits[i].t()) < bestT) {
                    bestTInd = i;
                    bestT = Math.abs(boxHits[i].t());
                }
            }
        }

        return (bestTInd >= 0) ? boxHits[bestTInd] : null;
    }

    private boolean isInRange(Point hittingPoint, Point a, Point b, int dim) {
        switch (dim){
            case 0:
                return (isBetween(a.y, b.y, hittingPoint.y)) && (isBetween(a.z, b.z, hittingPoint.z));
            case 1:
                return (isBetween(a.x, b.x, hittingPoint.x)) && (isBetween(a.z, b.z, hittingPoint.z));
            case 2:
                return isBetween(a.x, b.x, hittingPoint.x) && (isBetween(a.y, b.y, hittingPoint.y));
            default:
                return false;
        }
    }

    private boolean isBetween(double a, double b, double p) {
        return ((p >= a && p <= b) || (p >= b && p <= a));
    }
}

