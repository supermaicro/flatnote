package com.androsz.flatnote.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.androsz.flatnote.R;
import com.androsz.flatnote.app.widget.ColorPickerView;
import com.androsz.flatnote.app.widget.ColorPickerView.OnColorChangedListener;

public class ColorPickerDialog extends Dialog {

	private final OnColorChangedListener mListener;
	private final int mInitialColor;

	public ColorPickerDialog(Context context, OnColorChangedListener listener,
			int initialColor) {
		super(context);

		mListener = listener;
		mInitialColor = initialColor;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final OnColorChangedListener l = new OnColorChangedListener() {
			@Override
			public void onColorChanged(int color) {
				mListener.onColorChanged(color);
				dismiss();
			}
		};

		setContentView(new ColorPickerView(getContext(), l, mInitialColor));
		setTitle(R.string.pick_a_color);
	}
}