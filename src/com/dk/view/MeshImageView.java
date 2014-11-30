package com.dk.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

public class MeshImageView extends View {
	private Bitmap mBitmap;
	private float[] mVerts;
	private Paint mPaint;

	public MeshImageView(Context context) {
		super(context);
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		if (mPaint == null)
			mPaint = new Paint();

		if (mVerts != null)
			canvas.drawBitmapMesh(mBitmap, 4, 4, mVerts, 0, null, 0, mPaint);
//		canvas.drawBitmap(mBitmap, new Matrix(), mPaint);
	}

	public void setImageBitmap(Bitmap bitmap) {
		mBitmap = bitmap;
		postInvalidate();
	}

	public void setMeshVerts(float[] verts) {
		mVerts = verts;
	}
}
