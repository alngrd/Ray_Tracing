package edu.cg;

import edu.cg.algebra.Vec;
import edu.cg.scene.objects.Material;

import java.lang.reflect.Method;
import java.util.Random;

/***
 * This class implements static methods that return pred-fined materials such as Gold, Bronze etc.
 */
public class Materials {

    private static Material[] GENERAL_MATERIALS = new Material[]{
            getTinMaterial(),
            getRedPlasticMaterial(),
            getWhiteRubberMaterial(),
            getWhitePlasticMaterial(),
            getCyanRubberMaterial(),
            getGoldMaterial(),
            getGreenPlasticMaterial(),
            getPolishedGoldMaterial(),
            getBlackRubberMaterial(),
            getBronzeMaterial(),
    };

    private static Material[] GLASS_MATERIALS = new Material[]{
            getGlassMaterial(),
            getRedGlassMaterial(),
            getBlueGlassMaterial(),
            getGreenGlassMaterial(),
            getPeachGlassMaterial(),
    };

    private static Material[] MIRROR_MATERIALS = new Material[]{
            getMirrorMaterial(),
            getRedMirrorMaterial(),
            getBlueMirrorMaterial(),
            getMagentaMirrorMaterial(),
    };

    public static Material getGoldMaterial(){
        Material goldMaterial = new Material();
        goldMaterial.initKa(new Vec(0.24725, 0.1995, 0.0745))
                .initKd(new Vec(0.75164, 0.60648, 0.22648))
                .initKs(new Vec(0.628281, 0.555802, 0.366065))
                .initShininess(51)
                .initIsTransparent(false)
                .initIsReflecting(false);
        return goldMaterial;
    }

    public static Material getPolishedGoldMaterial(){
        Material goldMaterial = new Material();
        goldMaterial.initKa(new Vec(0.24725, 0.1995, 0.0745))
                .initKd(new Vec(0.75164, 0.60648, 0.22648))
                .initKs(new Vec(0.628281, 0.555802, 0.366065))
                .initKr(new Vec(0.4))
                .initIsReflecting(true)
                .initShininess(51)
                .initIsTransparent(false)
                .initIsReflecting(false);
        return goldMaterial;
    }

    public static Material getRedPlasticMaterial(){
        Material redPlasticMaterial = new Material();
        redPlasticMaterial.initKa(new Vec(0.4, 0.0, 0.0))
                .initKd(new Vec(0.5, 0.0, 0.0))
                .initKs(new Vec(0.7, 0.6, 0.6))
                .initShininess(32)
                .initIsTransparent(false)
                .initIsReflecting(false);
        return redPlasticMaterial;
    }

    public static Material getGreenPlasticMaterial(){
        Material greenPlasticMaterial = new Material();
        greenPlasticMaterial.initKa(new Vec(0.0, 0.4, 0.0))
                .initKd(new Vec(0.1	,0.35,	0.1))
                .initKs(new Vec(0.45,0.55,0.45))
                .initShininess(32)
                .initIsTransparent(false)
                .initIsReflecting(false);
        return greenPlasticMaterial;
    }

    public static Material getWhitePlasticMaterial(){
        Material whitePlasticMaterial = new Material();
        whitePlasticMaterial.initKa(new Vec(0.2))
                .initKd(new Vec(0.7, 0.7, 0.7))
                .initKs(new Vec(0.70, 0.70, 0.70))
                .initShininess(32)
                .initIsTransparent(false)
                .initIsReflecting(false);
        return whitePlasticMaterial;
    }

    public static Material getMirrorMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec(0.1, 0.1, 0.1))
                .initKd(new Vec(0.1, 0.1, 0.1))
                .initKs(new Vec(0.8, 0.8, 0.8))
                .initKr(new Vec(0.9))
                .initShininess(77)
                .initIsTransparent(false)
                .initIsReflecting(true);
        return mat;
    }

    public static Material getRedMirrorMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec(0.1, 0.1, 0.1))
                .initKd(new Vec(0.5, 0.1, 0.1))
                .initKs(new Vec(0.5, 0.1, 0.1))
                .initKr(new Vec(0.9, 0.7 ,0.7))
                .initShininess(77)
                .initIsTransparent(false)
                .initIsReflecting(true);
        return mat;
    }

    public static Material getBlueMirrorMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec(0.1, 0.1, 0.1))
                .initKd(new Vec(0.1, 0.1, 0.5))
                .initKs(new Vec(0.1, 0.1, 0.5))
                .initKr(new Vec(0.7, 0.7, 0.9))
                .initShininess(77)
                .initIsTransparent(false)
                .initIsReflecting(true);
        return mat;
    }

    public static Material getMagentaMirrorMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec(0.1, 0.1, 0.1))
                .initKd(new Vec(0.4, 0.4, 0.0))
                .initKs(new Vec(0.4, 0.4, 0.0))
                .initKr(new Vec(0.9, 0.9, 0.7))
                .initShininess(77)
                .initIsTransparent(false)
                .initIsReflecting(true);
        return mat;
    }

    public static Material getBlackRubberMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec(0.02))
                .initKd(new Vec(0.01))
                .initKs(new Vec(0.4))
                .initShininess(10)
                .initIsTransparent(false)
                .initIsReflecting(false);
        return mat;
    }

    public static Material getWhiteRubberMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec(0.4))
                .initKd(new Vec(0.8))
                .initKs(new Vec(0.4))
                .initShininess(10)
                .initIsTransparent(false)
                .initIsReflecting(false);
        return mat;
    }

    public static Material getCyanRubberMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec(0.0, 0.2, 0.2))
                .initKd(new Vec(0.4, 0.5, 0.5))
                .initKs(new Vec(0.04, 0.7, 0.7))
                .initShininess(10)
                .initIsTransparent(false)
                .initIsReflecting(false);
        return mat;
    }

    public static Material getTinMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec( 0.205882f, 0.12f, 0.213725f))
                .initKd(new Vec(0.427451f, 0.470588f, 0.541176f))
                .initKs(new Vec(0.333333f, 0.333333f, 0.521569f))
                .initShininess(10)
                .initIsTransparent(false)
                .initIsReflecting(false);
        return mat;
    }

    public static Material getBronzeMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec( 0.2125f, 0.1275f, 0.054f))
                .initKd(new Vec(0.714f, 0.4284f, 0.18144f))
                .initKs(new Vec(0.393548f, 0.271906f, 0.166721f))
                .initShininess(25)
                .initIsTransparent(false)
                .initIsReflecting(false);
        return mat;
    }

    public static Material getGlassMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec( 0.01, 0.01, 0.01))
                .initKd(new Vec(0.01f, 0.01f, 0.01f))
                .initKs(new Vec(0.5f, 0.5, 0.5))
                .initKt(new Vec(0.9))
                .initShininess(75)
                .initIsTransparent(true)
                .initRefractionIndex(1.33)
                .initIsReflecting(false);
        return mat;
    }

    public static Material getRedGlassMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec( 0.01, 0.01, 0.01))
                .initKd(new Vec(0.01f, 0.01f, 0.01f))
                .initKs(new Vec(0.5f, 0.5, 0.5))
                .initKt(new Vec(1.0,0.7,0.7))
                .initShininess(75)
                .initRefractionIndex(1.33)
                .initIsTransparent(true)
                .initIsReflecting(false);
        return mat;
    }

    public static Material getBlueGlassMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec( 0.01, 0.01, 0.01))
                .initKd(new Vec(0.01f, 0.01f, 0.01f))
                .initKs(new Vec(0.5f, 0.5, 0.5))
                .initKt(new Vec(0.7,0.7,0.9))
                .initShininess(75)
                .initIsTransparent(true)
                .initRefractionIndex(1.333)
                .initIsReflecting(false);
        return mat;
    }

    public static Material getGreenGlassMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec( 0.01, 0.01, 0.01))
                .initKd(new Vec(0.01f, 0.01f, 0.01f))
                .initKs(new Vec(0.5f, 0.5, 0.5))
                .initKt(new Vec(0.7,0.9,0.7))
                .initShininess(75)
                .initIsTransparent(true)
                .initRefractionIndex(1.333)
                .initIsReflecting(false);
        return mat;
    }

    public static Material getPeachGlassMaterial(){
        Material mat = new Material();
        mat.initKa(new Vec( 0.01, 0.01, 0.01))
                .initKd(new Vec(0.01f, 0.01f, 0.01f))
                .initKs(new Vec(0.5f, 0.5, 0.5))
                .initKt(new Vec(1.0,218./255.0,185./255.0))
                .initShininess(75)
                .initIsTransparent(true)
                .initRefractionIndex(1.333)
                .initIsReflecting(false);
        return mat;
    }


    public static Material getRandomMaterial(){
        Random randomGen = new Random();
        int material_type = randomGen.nextInt(3);
        if (material_type == 0){
            int rnd = randomGen.nextInt(GENERAL_MATERIALS.length);
            return GENERAL_MATERIALS[rnd];
        }else if (material_type == 1){
            int rnd = randomGen.nextInt(MIRROR_MATERIALS.length);
            return MIRROR_MATERIALS[rnd];
        }else{
            int rnd = randomGen.nextInt(GLASS_MATERIALS.length);
            return GLASS_MATERIALS[rnd];
        }
    }

}
