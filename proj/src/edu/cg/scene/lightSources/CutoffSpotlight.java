package edu.cg.scene.lightSources;

import edu.cg.UnimplementedMethodException;
import edu.cg.algebra.Ops;
import edu.cg.algebra.Point;
import edu.cg.algebra.Ray;
import edu.cg.algebra.Vec;
import edu.cg.scene.objects.Surface;

public class CutoffSpotlight extends PointLight {
	private Vec direction; // light source direction
	private double cutoffAngle; // Cutoff angle in degrees

	public CutoffSpotlight(){
		this.direction = new Vec(0.0, -1.0, 0.0);
		this.cutoffAngle = 30;
	}

	public CutoffSpotlight(Vec dirVec, double cutoffAngle) {
		this.direction = dirVec;
		this.cutoffAngle = cutoffAngle;
	}

	public CutoffSpotlight initDirection(Vec direction) {
		this.direction = direction;
		return this;
	}
	
	public CutoffSpotlight initCutoffAngle(double cutoffAngle) {
		this.cutoffAngle = cutoffAngle;
		return this;
	}
	
	@Override
	public String toString() {
		String endl = System.lineSeparator();
		return "Spotlight: " + endl +
				description() + 
				"Direction: " + direction +
				"Cutoof Angle:" + cutoffAngle + endl;
	}

	@Override
	public CutoffSpotlight initPosition(Point position) {
		return (CutoffSpotlight) super.initPosition(position);
	}

	@Override
	public CutoffSpotlight initDecayFactors(double q, double l, double c) {
		return (CutoffSpotlight)super.initDecayFactors(q, l, c);
	}

	@Override
	public CutoffSpotlight initIntensity(Vec intensity) {
		return (CutoffSpotlight)super.initIntensity(intensity);
	}
	
	@Override
	public boolean isOccludedBy(Surface surface, Ray rayToLight) {
		return super.isOccludedBy(surface, rayToLight);
	}
	
	@Override
	public Vec intensity(Point hittingPoint, Ray rayToLight) {
		double dotProduct = (direction.normalize().neg()).dot(rayToLight.direction().normalize());
		double gamma = Math.toDegrees(Math.acos(dotProduct));

		return (dotProduct >= Ops.epsilon && cutoffAngle >= gamma) ?
				super.intensity(hittingPoint, rayToLight).mult(dotProduct) : new Vec();
	}
}
