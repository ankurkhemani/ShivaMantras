package com.cena.genaks.shivamantras;



import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class ShivaGallery extends Activity implements ViewSwitcher.ViewFactory,OnItemSelectedListener {
    /** Called when the activity is first created. */
	private Gallery gallery;  
    private ImageSwitcher imageSwitcher;  
    int i=0;
      
    private ImageAdapter ia;   
    int[] IMAGE_IDS = {  
            R.drawable.shivji1, R.drawable.shivji2, R.drawable.shivji3, R.drawable.shivji4, R.drawable.shivji5,
            R.drawable.shivji6, R.drawable.shivji7, R.drawable.shivji8,R.drawable.shivji9,
            R.drawable.shivji10,R.drawable.shivji11, R.drawable.shivji12, R.drawable.shivji13, R.drawable.shivji14, 
            R.drawable.shivji15 
      };  
 
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
         super.onCreate(savedInstanceState);  
         setContentView(R.layout.shivagallery);  
 
         gallery = (Gallery) findViewById(R.id.gallery);  
         imageSwitcher = (ImageSwitcher) findViewById(R.id.image_switcher);  
           
         imageSwitcher.setFactory(this);  
         imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,  
                   android.R.anim.slide_in_left));  
         imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,  
                   android.R.anim.slide_out_right));  
           
 
         ia = new ImageAdapter(this);  
         gallery.setAdapter(ia);  
           
         //Event listener
         gallery.setOnItemSelectedListener(this);  
    }  
      
    private class ImageAdapter extends BaseAdapter {  
         private Context context;  
           
         private ImageAdapter(Context context) {  
              this.context = context;  
         }  
           
         
 
         public int getCount() {  
              return IMAGE_IDS.length;  
         }  
 
         public Object getItem(int position) {  
              return IMAGE_IDS[position];  
         }  
 
         public long getItemId(int position) {  
              return position;  
         }  
 
         public View getView(int position, View convertView, ViewGroup parent) {  
              ImageView iv = new ImageView(context);  
              iv.setImageResource(IMAGE_IDS[position]);  
              iv.setScaleType(ScaleType.FIT_XY);
             // iv.setLayoutParams(new Gallery.LayoutParams(1000, 800));
              
              return iv;  
         }  
    }  
 
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
         int imageResourceId = (Integer) ia.getItem(position);  
         imageSwitcher.setImageResource(imageResourceId);  
         i=position;
    }  
 
    public void onNothingSelected(AdapterView<?> parent) {  
    }  
 
    public View makeView() {  
         ImageView i = new ImageView(this);  
         i.setScaleType(ImageView.ScaleType.FIT_CENTER);  
         return i;  
    }  
    
    
}