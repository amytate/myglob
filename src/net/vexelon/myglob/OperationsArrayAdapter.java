/*
 * The MIT License
 * 
 * Copyright (c) 2010 Petar Petrov
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
package net.vexelon.myglob;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class OperationsArrayAdapter extends ArrayAdapter<Operations> {
	
//	private List<Operations> _items;
//	public OperationsArrayAdapter(Context context, int textViewResId, List<Operations> items) {
//		super(context, android.R.layout.simple_spinner_item, items);
//		this._items = items;
//	}
	
	private Operations[] _items;
	public OperationsArrayAdapter(Context context, int textViewResId, Operations[] items) {
		super(context, textViewResId, items);
		this._items = items;
	}	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if ( convertView == null ) {
			convertView = new TextView(getContext());
		}
		TextView tv = (TextView)convertView;
		tv.setText(_items[position].getText(getContext()));
		tv.setTextColor(Color.BLACK);
		tv.setPadding(1, 5, 1, 5);
		tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
		return tv;
	}
	
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		if ( convertView == null ) {
			convertView = new TextView(getContext());
		}
		TextView tv = (TextView)convertView;
		tv.setText(_items[position].getText(getContext()));
		tv.setTextColor(Color.BLACK);
		tv.setPadding(1, 5, 1, 5);
		tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
		return tv;		
	}
	
	public int getItemPosition(Operations operation) {
		for (int i = 0; i < _items.length; i++) {
			if (_items[i].equals(operation)) {
				return i;
			}
		}
		return -1;
	}
	
}
