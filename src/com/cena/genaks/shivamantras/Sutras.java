package com.cena.genaks.shivamantras;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.content.Intent;

	public class Sutras extends Activity {
		
		Button b1,b2,b3;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.sutras);
			b1=(Button)findViewById(R.id.s1);
			b1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.SECTION1");
					startActivity(i);
				}
			});
			
			b2=(Button)findViewById(R.id.s2);
			b2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.SECTION2");
					startActivity(i);
				}
			});
			
			b3=(Button)findViewById(R.id.s3);
			b3.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.SECTION3");
					startActivity(i);
				}
			});
		}
		
	}
