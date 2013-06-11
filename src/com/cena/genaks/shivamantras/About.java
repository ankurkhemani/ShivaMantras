package com.cena.genaks.shivamantras;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.content.Intent;

	public class About extends Activity {
		
		Button more;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.about);
			
			more=(Button)findViewById(R.id.more);
			more.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.DESCRIPTION");
					startActivity(i);
				}
			});
		}
	}