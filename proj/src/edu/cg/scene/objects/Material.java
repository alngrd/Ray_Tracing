package edu.cg.scene.objects;

import edu.cg.algebra.Vec;

public class Material {
	public Vec Ka = new Vec(0.1, 0.1, 0.1); //ambient coefficient
	public Vec Kd = new Vec(1, 1, 1); //diffuse coefficient
	public Vec Ks = new Vec(0.7, 0.7, 0.7); //specular coefficient
	public int shininess = 10; //shine factor - for specular calculation
	public boolean isReflecting = false;
	public Vec Kr = new Vec(1, 1, 1); // reflection coefficient
	// Bonus related fields
	public boolean isTransparent = false;
	public Vec Kt = new Vec(1, 1, 1); //transparency coefficient - for refraction bonus
	public double refractionIndex = 1.5; //refraction index - bonus


	@Override
	public String toString() {
		String endl = System.lineSeparator();
		return "Ka: " + Ka + endl +
				"Ks: " + Ks + endl +
				"Kt: " + Kt + endl +
				"Kr: " + Kr + endl +
				"Shininess: " + shininess + endl +
				"isReflecting: " + isReflecting + endl +
				"isTransparent: " + isTransparent + endl +
				"Refraction Index: " + refractionIndex + endl;
	}

	public Material initKa(Vec Ka) {
		this.Ka = Ka;
		return this;
	}

	public Material initKd(Vec Kd) {
		this.Kd = Kd;
		return this;
	}

	public Material initKr(Vec Kr){
		this.Kr = Kr;
		return this;
	}

	public Material initKs(Vec Ks) {
		this.Ks = Ks;
		return this;
	}

	public Material initShininess(int shininess) {
		this.shininess = shininess;
		return this;
	}

	public Material initKt(Vec Kt) {
		this.Kt = Kt;
		return this;
	}

	public Material initRefractionIndex(double refractionIndex) {
		this.refractionIndex = refractionIndex;
		return this;
	}

	public Material initIsTransparent(boolean isTransparent) {
		this.isTransparent = isTransparent;
		return this;
	}

	public Material initIsReflecting(boolean isReflecting){
		this.isReflecting = isReflecting;
		return this;
	}
}
