/*
 * Copyright (c) 2011 Socialize Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.socialize.ui.comment;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import com.socialize.ui.util.Colors;
import com.socialize.ui.view.BaseViewFactory;

/**
 * @author Jason Polites
 *
 */
public class CommentHeaderFactory extends BaseViewFactory<CommentHeader> {
	
	@Override
	public CommentHeader make(Context context, Object... params) {
		
		final int four = getDIP(4);
		
		CommentHeader header = new CommentHeader(context);
		LayoutParams titlePanelLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		titlePanelLayoutParams.gravity = Gravity.CENTER_VERTICAL;
		header.setLayoutParams(titlePanelLayoutParams);
		header.setOrientation(LinearLayout.HORIZONTAL);
		header.setPadding(four, four, four, four);
		header.setBackgroundDrawable(drawables.getDrawable("header.png", true, false, true));
		
		TextView titleText = new TextView(context);
		titleText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
		titleText.setTextColor(colors.getColor(Colors.HEADER));
		titleText.setText("Comments");
		titleText.setPadding(0, 0, 0, deviceUtils.getDIP(2));

		LayoutParams titleTextLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		titleTextLayoutParams.gravity = Gravity.CENTER_VERTICAL;
		titleText.setLayoutParams(titleTextLayoutParams);

		ImageView titleImage = new ImageView(context);
		titleImage.setImageDrawable(drawables.getDrawable("socialize_icon_white.png", true));
		titleImage.setPadding(0, 0, 0, 0);

		LayoutParams titleImageLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		titleImageLayoutParams.gravity = Gravity.CENTER_VERTICAL;
		titleImageLayoutParams.setMargins(four, 0, four, 0);
		titleImage.setLayoutParams(titleImageLayoutParams);

		header.setTitleText(titleText);
		
		header.addView(titleImage);
		header.addView(titleText);
		
		return header;
	}
}
