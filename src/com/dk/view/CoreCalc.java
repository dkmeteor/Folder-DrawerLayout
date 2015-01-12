package com.dk.view;

import android.graphics.LinearGradient;
import android.graphics.Shader;

public class CoreCalc {
	
	private static final int GRAY=0xc0c0c0;
	private static final int TRANSPARENT=0x00000000;
	private static int mAlpha = 0xff;
	
	private float[] originVerts = new float[6 * 51 * 2];
	private float[] meshVerts = new float[6 * 51 * 2];
	private Shader mShader;

	public Shader getShader() {
		return mShader;
	}

	private int width;
	private int height;

	public CoreCalc(int width, int height) {
		this.width = width;
		this.height = height;
		originVerts = createOriginVerts();
	}

	public float[] createOffsetVerts(float offset) {
		applyCurveEffect(offset);
		applyScaleEffect(offset);
		mShader = applyShadow(offset);
		return meshVerts;
	}

	/**
	 * f(x)=64*(1-offset)*sin(x*x/20000)
	 * 
	 * Notice: when x is in 0~720 , it works well. You can see the Graph through
	 * this link.
	 * https://www.google.com/?gws_rd=ssl#newwindow=1&q=y%3D64+sin(x*x%2F20000)+
	 * 
	 * for other screen resolution , may be need other
	 * 
	 * @param offset
	 * @return
	 */
	private float[] applyCurveEffect(float offset) {
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 51; j++) {
				meshVerts[i * 102 + 2 * j] = originVerts[i * 102 + 2 * j];
				meshVerts[i * 102 + 2 * j + 1] = originVerts[i * 102 + 2 * j
						+ 1]
						+ (float) (64f * (1 - offset) * Math.sin(originVerts[i
								* 102 + 2 * j]
								* originVerts[i * 102 + 2 * j] / 20000));
			}
		return meshVerts;
	}

	private float[] applyScaleEffect(float offset) {
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 51; j++) {
				meshVerts[i * 102 + 2 * j] = meshVerts[i * 102 + 2 * j]
						* (0.7f + 0.3f * offset);
			}
		return meshVerts;
	}

	/**
	 * 
	 * (sinx^2)'=2x cosx^2
	 * 
	 * 2xcosx^2 = 0
	 * 
	 * x^2 = ¦Ð/2+2n¦Ð
	 * 
	 * x^2 = (¦Ð/2+2n¦Ð)*20000
	 * 
	 * x = [177.24 , 396.33, 531.73 , 639.06 ,]
	 * 
	 * @param offset
	 * @return
	 */
	private Shader applyShadow(float offset) {

		float p1 = (float) Math.sqrt(Math.PI / 2 * 20000);
		float p2 = (float) Math.sqrt((Math.PI / 2 + 1 * Math.PI) * 20000);
		float p3 = (float) Math.sqrt((Math.PI / 2 + 2 * Math.PI) * 20000);
		float p4 = (float) Math.sqrt((Math.PI / 2 + 3 * Math.PI) * 20000);
		float p5 = (float) Math.sqrt((Math.PI / 2 + 4 * Math.PI) * 20000);
		float p6 = (float) Math.sqrt((Math.PI / 2 + 5 * Math.PI) * 20000);
		float p7 = (float) Math.sqrt((Math.PI / 2 + 6 * Math.PI) * 20000);
		float p8 = (float) Math.sqrt((Math.PI / 2 + 7 * Math.PI) * 20000);
		float p9 = (float) Math.sqrt((Math.PI / 2 + 8 * Math.PI) * 20000);

		int gray =  ((int)(mAlpha * (1f - offset)) << 72) & GRAY;
		
		Shader shader = new LinearGradient(0, 0, width, 0, new int[] {
				gray, TRANSPARENT, gray, TRANSPARENT, gray,
				TRANSPARENT, gray, TRANSPARENT, gray },
				new float[] { p1 / width, p2 / width, p3 / width, p4 / width,
						p5 / width, p6 / width, p7 / width, p8 / width,
						p9 / width }, Shader.TileMode.REPEAT);
		return shader;
	}

	/**
	 * 50*5
	 * 
	 * @return
	 */
	private float[] createOriginVerts() {
		float[] result = new float[6 * 51 * 2];
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 51; j++) {
				result[i * 102 + 2 * j] = j * width / 50f;
				result[i * 102 + 2 * j + 1] = i * height / 5f;
			}

		return result;
	}

	public float[] getOriginVerts() {
		return originVerts;
	}

	public void setOriginVerts(float[] originVerts) {
		this.originVerts = originVerts;
	}

	public float[] getMeshVerts() {
		return meshVerts;
	}

	public void setMeshVerts(float[] meshVerts) {
		this.meshVerts = meshVerts;
	}
}
