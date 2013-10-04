package com.aetna.carepass.android;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * A test activity for viewing the {@link InitFragment}. You will most likely
 * want to insert {@link InitFragment} or a subclass of it into your project
 * instead.
 */
public class InitActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.init);
	}
}
