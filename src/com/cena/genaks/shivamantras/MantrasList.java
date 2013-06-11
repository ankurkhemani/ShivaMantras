package com.cena.genaks.shivamantras;


import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MantrasList extends ListActivity {
    /** Called when the activity is first created. */
	    
	String m="10";
	String s="0";
	ListView lv;
	
	String values[]={"Om Namah Shivaya (bhajan)","Om Namah Shivaya (Lata Mangeshkar)",
			"Om Namah Shivaya (Peaceful)","Dhimika dhimika dhim",
			"Om Namah Shivaya (dhun)"	};
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mantraslist);
        
       
		this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values));
		
    }
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		switch( position )
   	 {
   	    case 0: 
   	    	Intent i=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.MANTRA1");
			startActivity(i);
   	    	
   	    	break;
    		
   	      
   	    case 1:	
   	    	Intent i1=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.MANTRA2");
			startActivity(i1);
	    	break;
   	    case 2: 
   	    	Intent i2=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.MANTRA3");
			startActivity(i2);
   	    	
	    	break;
   	    case 3: 
   	    	Intent i3=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.MANTRA4");
			startActivity(i3);
   	    	
	    	break;
   	    case 4: 
   	    	Intent i4=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.MANTRA5");
			startActivity(i4);
   	    	
	    	break;
   		
   	    case 5:
   	    	Intent i5=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.MANTRA6");
			startActivity(i5);
   	    	break;
   	}
   	
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intent = new Intent(MantrasList.this, MainActivity.class);
	    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);    
	    startActivity(intent);
	}
}
   	
		