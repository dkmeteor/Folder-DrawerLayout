package com.dk.view;

public class CoreCalc {


	private float[] originVerts = new float[6*51*2];
	private float[] meshVerts = new float[6*51*2];
	
	private int width;
	private int height;
	
	public CoreCalc(int width,int height)
	{
		this.width =width;
		this.height = height;
		originVerts = createOriginVerts();
	}
	
	
	public float[] createOffsetVerts(float offset) {
		System.out.println("offset:"+offset);
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 51; j++) {
				meshVerts[i*102+2*j]=originVerts[i*102+2*j];
				meshVerts[i*102+2*j+1]=originVerts[i*102+2*j+1] + (float)(64f*(1-offset)*Math.sin(originVerts[i*102+2*j]/25))   ;
			}
		
		return meshVerts;
	}
	
	/**
	 * 50*5
	 * 
	 * @return
	 */
	private float[] createOriginVerts()
	{
		float[] result = new float[6*51*2];
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 51; j++) {
				result[i*102+2*j]=j*width/50f;
				result[i*102+2*j+1]=i*height/5f;
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
