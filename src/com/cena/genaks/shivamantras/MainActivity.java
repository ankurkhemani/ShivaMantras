package com.cena.genaks.shivamantras;





import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button b1,b2,b3,b4,b5,b6;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    
	    
		
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.MANTRASLIST");
				startActivity(i);
			}
		});
		
		b2=(Button)findViewById(R.id.button2);
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.SUTRAS");
				startActivity(i);
			}
		});
		
		b3=(Button)findViewById(R.id.button3);
		b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.SHIVAGALLERY");
				startActivity(i);
			}
		});
		
		b4=(Button)findViewById(R.id.button4);
		b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.ABOUT");
				startActivity(i);
			}
		});
		
		
		
		b5=(Button)findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			
    					    
    			Uri uri = Uri.parse("market://details?id=com.cena.genaks.shivamantras");
    		    Intent i = new Intent(Intent.ACTION_VIEW, uri);
    		    try 
    		    {
    		        startActivity(i);
    		    } 
    		    catch (ActivityNotFoundException e) 
    		    {
    		    	Toast.makeText(getApplicationContext(), "Sorry, Not able to open!", Toast.LENGTH_SHORT).show();
    		    }
    			
    				}
    			} );
        
        b6=(Button)findViewById(R.id.button6);
        b6.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    	
    	try
    	{ Intent i = new Intent(Intent.ACTION_SEND);  
    	  i.setType("text/plain");
    	  i.putExtra(Intent.EXTRA_SUBJECT, "SHIVA MANTRAS - OM NAMAH SHIVAYA");
    	  String sAux = "\nHi, i tried 'SHIVA MANTRAS - OM NAMAH SHIVAYA' Android App on Google Play Store. " +
    	  		"It's very devotional app with deep knowledge and mind-soothing mantras of Lord Shiva. I recommend to try it once. Follow the link:\n\n";
    	  sAux = sAux + "https://play.google.com/store/apps/details?id=com.cena.genaks.shivamantras \n\n";
    	  i.putExtra(Intent.EXTRA_TEXT, sAux);  
    	  startActivity(Intent.createChooser(i, "choose one"));
    	}
    	 
        catch (Exception e) 
        {
        	Toast.makeText(getApplicationContext(), "Sorry, Not able to open!", Toast.LENGTH_SHORT).show();
        }
    	
    		}
    	} );
	}

	
	
}


