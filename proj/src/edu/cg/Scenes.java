package edu.cg;

import edu.cg.algebra.Point;
import edu.cg.algebra.Vec;
import edu.cg.scene.Scene;
import edu.cg.scene.camera.PinholeCamera;
import edu.cg.scene.lightSources.CutoffSpotlight;
import edu.cg.scene.lightSources.DirectionalLight;
import edu.cg.scene.lightSources.Light;
import edu.cg.scene.objects.*;


public class Scenes {

	public static Scene scene1() {
		Shape plainShape = new Plain(0, 0.0, 1, 2.5);

		Surface plainSurface = new Surface(plainShape, Materials.getWhiteRubberMaterial());

		Shape aab1 = new AxisAlignedBox(new Point(-1.5, -1.5, -2.5),
				new Point(-0.2, -0.2, -1.5));
		Surface sphereSurface1 = new Surface(aab1, Materials.getGoldMaterial());

		Shape aab2 = new AxisAlignedBox(new Point(0.1, -1., -2.5),
				new Point(1.1, 0.0, -0.4));
		Surface sphereSurface2 = new Surface(aab2, Materials.getRedPlasticMaterial());

		Light spotLight = new CutoffSpotlight()
				.initPosition(new Point(0, 0, 1.5))
				.initDirection(new Vec(-0.25, 0, -0.5))
				.initIntensity(new Vec(0.5, 0.0, 0.0))
				.initCutoffAngle(15);

		Light dirLight = new DirectionalLight()
				.initDirection(new Vec(0, 0.1, -1))
				.initIntensity(new Vec(1.0, 1.0, 1.0));

		return new Scene()
				.initAmbient(new Vec(0.1, 0.2, 0.3))
				.initCamera(new Point(0, 0, 4), new Vec(0,0,-1),new Vec(0.0, 1.0, 0.0), 4.0)
				.addLightSource(dirLight)
				.addLightSource(spotLight)
				.addSurface(plainSurface)
				.addSurface(sphereSurface1)
				.addSurface(sphereSurface2)
				.initName("scene1")
				.initAntiAliasingFactor(1);
	}

	public static Scene scene2() {
		Shape plainShape1 = new Plain(1, 0, -0.1, -3);
		Material plainMat1 = new Material()
				.initKa(new Vec(1))
				.initKd(new Vec(0.6, 0, 0.8))
				.initKs(new Vec(0.7))
				.initKr(new Vec(0.3))
				.initIsReflecting(true)
				.initShininess(20);
		Surface plainSurface1 = new Surface(plainShape1, plainMat1);

		Shape plainShape2 = new Plain(0, 0, -1, -3.5);
		Material plainMat2 = new Material()
				.initKa(new Vec(1))
				.initKd(new Vec(0.7, 0.7, 0))
				.initKs(new Vec(0.7))
				.initKr(new Vec(0.3))
				.initIsReflecting(true)
				.initShininess(10);
		Surface plainSurface2 = new Surface(plainShape2, plainMat2);

		Shape plainShape3 = new Plain(-1, 0, -0.1, -3);
		Material plainMat3 = new Material()
				.initKa(new Vec(1))
				.initKd(new Vec(0, 0.9, 0.5))
				.initKs(new Vec(0.7))
				.initKr(new Vec(0.3))
				.initIsReflecting(true)
				.initShininess(15);
		Surface plainSurface3 = new Surface(plainShape3, plainMat3);

		Shape plainShape4 = new Plain(0, 1, -0.1, -3);
		Material plainMat4 = new Material()
				.initKa(new Vec(1))
				.initKd(new Vec(0, 0.4, 0.4))
				.initKs(new Vec(0.7))
				.initKr(new Vec(0.3))
				.initIsReflecting(true)
				.initShininess(10);
		Surface plainSurface4 = new Surface(plainShape4, plainMat4);

		Shape plainShape5 = new Plain(0, -1, -0.1, -3);
		Material plainMat5 = new Material()
				.initKa(new Vec(1))
				.initKd(new Vec(0.9, 0, 0.1))
				.initKs(new Vec(0.7))
				.initKr(new Vec(0.3))
				.initIsReflecting(true)
				.initShininess(15);
		Surface plainSurface5 = new Surface(plainShape5, plainMat5);

		Light spotlight1 = new CutoffSpotlight()
				.initCutoffAngle(36)
				.initIntensity(new Vec(0.3, 0.9, 0.2))
				.initPosition(new Point())
				.initDirection(new Vec(0, 0.5, -1));

		Light spotlight2 = new CutoffSpotlight()
				.initCutoffAngle(25)
				.initIntensity(new Vec(0.9, 0.5, 0.5))
				.initPosition(new Point())
				.initDirection(new Vec(0.5, 0, -1));

		Light spotlight3 = new CutoffSpotlight()
				.initCutoffAngle(45)
				.initIntensity(new Vec(0.3, 0.5, 0.9))
				.initPosition(new Point(-0.2, 0, 0))
				.initDirection(new Vec(-0.4, -0.3, -1));

		return new Scene()
				.addLightSource(spotlight1)
				.addLightSource(spotlight2)
				.addLightSource(spotlight3)
				.addSurface(plainSurface1)
				.addSurface(plainSurface2)
				.addSurface(plainSurface3)
				.addSurface(plainSurface4)
				.addSurface(plainSurface5)
				.initAmbient(new Vec(0.2, 0.1, 0))
				.initCamera(new Point(0, 0, 1), new Vec(0,0,-1),new Vec(0.0, 1.0, 0.0), 1.0)
				.initName("scene2")
				.initAntiAliasingFactor(1)
				.initRenderReflections(true)
				.initMaxRecursionLevel(2);
	}

	public static Scene scene3() {
		// Create basic scene:
		Scene scene = new Scene()
				.initName("Scene3")
				.initRenderReflections(false)
				.initMaxRecursionLevel(1)
				.initAmbient(new Vec(1.0))
				.initAntiAliasingFactor(1);
		// Camera settings:
		PinholeCamera camera = new PinholeCamera(new Point(12.0,-12.0,8), new Vec(-.5,1.0,-.5),new Vec(0,0,1),5);
		scene.initCamera(camera);
		// Light sources:
		Light light1 = new DirectionalLight().initDirection(new Vec(0.0, 0.5, -1.0)).initIntensity(new Vec(0.4));
		scene.addLightSource(light1);
		Light light2 = new CutoffSpotlight().initDirection(new Vec(0.0, 0.0, -1.0)).
				initIntensity(new Vec(.8)).
				initCutoffAngle(45).
				initPosition(new Point(-2.0, 10.0, 10.0));
		scene.addLightSource(light2);
		Light light3 = new CutoffSpotlight().initDirection(new Vec(0.0, 0.0, -1.0)).
				initIntensity(new Vec(.8)).
				initCutoffAngle(45).
				initPosition(new Point(2.0, 10.0, 10.0));
		scene.addLightSource(light3);

		Light light4 = new CutoffSpotlight().initDirection(new Vec(0.0, 0.0, -1.0)).
				initIntensity(new Vec(.8)).
				initCutoffAngle(45).
				initPosition(new Point(0.0, 5.0, 10.0));
		scene.addLightSource(light4);

		// Add plane to simulate ground
		Shape planeShape = new Plain(0, 0.0, 1.0, 0.0);
		Surface plainSurface = new Surface(planeShape, Materials.getWhitePlasticMaterial());
		scene.addSurface(plainSurface);

		// Add Triangle shape Axis Algined Boxes
		int NUM_ROWS=5;
		double LENGTH=2.0;
		double SPACING=0.25;
		for (int i =0 ; i < NUM_ROWS; i++){
			int numObjectsPerRow= 2*i+1;
			double dx=numObjectsPerRow*(LENGTH+SPACING)-SPACING;
			for(int j =0; j< numObjectsPerRow; j++){
				Point a = new Point(j*(LENGTH+SPACING)-dx/2,
						i*(LENGTH+SPACING),
						0.0);
				Point b = new Point(j*(LENGTH+SPACING)+LENGTH-dx/2,
						i*(LENGTH+SPACING)+LENGTH,
						LENGTH);
				AxisAlignedBox aab = new AxisAlignedBox(a,b);
				Surface aabsurface = new Surface(aab, Materials.getRandomMaterial());
				scene.addSurface(aabsurface);
			}
		}
		return scene;
	}


	public static Scene scene4() {
		return scene3()
				.initName("scene4")
				.initRenderReflections(true)
				.initMaxRecursionLevel(4)
				.initAntiAliasingFactor(1);
	}

	public static Scene scene5() {
		return scene3()
				.initName("scene5")
				.initRenderReflections(true)
				.initRenderRefractions(true)
				.initMaxRecursionLevel(8)
				.initAntiAliasingFactor(1);
	}

	public static Scene scene6() {
		return scene3()
				.initName("scene6")
				.initRenderReflections(true)
				.initRenderRefractions(true)
				.initMaxRecursionLevel(8)
				.initAntiAliasingFactor(9);
	}

	public static Scene scene7() {
		// Create basic scene:
		Scene scene = new Scene()
				.initName("Scene7")
				.initRenderReflections(true)
				.initRenderRefractions(true)
				.initMaxRecursionLevel(8)
				.initAmbient(new Vec(1.0))
				.initAntiAliasingFactor(9);
		// Camera settings:
		PinholeCamera camera = new PinholeCamera(new Point(11.0,-12.0,8), new Vec(-.5,1.0,-.5),new Vec(0,0,1),5);
		scene.initCamera(camera);
		// Light sources:
		Light light1 = new DirectionalLight().initDirection(new Vec(0.0, 0.5, -1.0)).initIntensity(new Vec(0.4));
		scene.addLightSource(light1);
		Light light2 = new CutoffSpotlight().initDirection(new Vec(0.0, 0.0, -1.0)).
				initIntensity(new Vec(.8)).
				initCutoffAngle(45).
				initPosition(new Point(-2.0, 10.0, 10.0));
		scene.addLightSource(light2);
		Light light3 = new CutoffSpotlight().initDirection(new Vec(0.0, 0.0, -1.0)).
				initIntensity(new Vec(.8)).
				initCutoffAngle(45).
				initPosition(new Point(2.0, 10.0, 10.0));
		scene.addLightSource(light3);

		Light light4 = new CutoffSpotlight().initDirection(new Vec(0.0, 0.0, -1.0)).
				initIntensity(new Vec(.8)).
				initCutoffAngle(45).
				initPosition(new Point(0.0, 5.0, 10.0));
		scene.addLightSource(light4);

		// Add plane to simulate ground
		Shape planeShape = new Plain(0, 0.0, 1.0, 0.0);
		Surface plainSurface = new Surface(planeShape, Materials.getWhitePlasticMaterial());
		scene.addSurface(plainSurface);

		// Add Triangle shape Axis Algined Boxes
		int NUM_ROWS=5;
		double LENGTH=2.0;
		double SPACING=0.25;
		for (int i =0 ; i < NUM_ROWS; i++){
			int numObjectsPerRow= 2*i+1;
			double dx=numObjectsPerRow*(LENGTH+SPACING)-SPACING;
			for(int j =0; j< numObjectsPerRow; j++){

				Sphere sphere = new Sphere(new Point(j*(LENGTH+SPACING)-dx/2,i*(LENGTH+SPACING),1.0),1.0);
				Surface aabsurface = new Surface(sphere, Materials.getRandomMaterial());
				scene.addSurface(aabsurface);
			}
		}
		return scene;
	}

}
