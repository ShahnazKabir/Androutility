package com.example.androutility;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class VolumeActivity extends Activity {

	double factor;
	Spinner spinner;
	Button btnConvert;
	EditText etFrom, etTo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_volume);

		spinner = (Spinner) findViewById(R.id.spinnerLength);
		btnConvert = (Button) findViewById(R.id.btnConvert);
		etFrom = (EditText) findViewById(R.id.editTextFrom);
		etTo = (EditText) findViewById(R.id.editTextTo);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter
				.createFromResource(this, R.array.volumeArray,
						android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				switch (arg2) {
				case 0:
					factor = 4.54609;
					break;
				case 1:
					factor = 0.21997;
					break;
				case 2:
					factor = 3.785412;
					break;
				case 3:
					factor = 0.264172;
					break;
				case 4:
					factor = 16.387064;
					break;
				case 5:
					factor = 0.999999;
					break;
				case 6:
					factor = 0.028317;
					break;
				case 7:
					factor = 35.314667;
					break;
				case 8:
					factor = 0.764555;
					break;
				case 9:
					factor = 1.307951;
					break;
					 
				default:
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
				
			}
		});
		
		
		btnConvert.setOnClickListener(new OnClickListener() { 
			
			@Override
			public void onClick(View arg0) {
				double from, to;
				
				from = Double.parseDouble(etFrom.getText().toString());
				
				to  = factor * from;
				
				etTo.setText(String.valueOf(to));
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.volume, menu);
		return true;
	}

}
