package com.cena.genaks.shivamantras;





import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.cena.genaks.shivamantras.R.drawable;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.SeekBar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.MediaController.MediaPlayerControl;
import android.os.CountDownTimer;
import android.provider.MediaStore;


public class Mantra5 extends Activity {
	
	private static final String TAG = null;
	Runnable notification;
	Button next,previous,stop,next1,previous1;
	MediaPlayer mp=new MediaPlayer();
	ToggleButton tb,tb1;
    private SeekBar seekBar;
    MediaController mc;
    TextView tv;
    private final Handler handler = new Handler();
	MyCounter timer,timer1;
	
	ImageView iv;
	
	
	
	int[] IMAGE_IDS =new int[] {  
            R.drawable.shiv5, R.drawable.shiv8, R.drawable.shiv9, R.drawable.shiv10,
            R.drawable.shiv7,
            R.drawable.shiv11, R.drawable.shiv12
       };
	
	
	int mins=3000,sec=0,i=1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mantraplay);
		tv=(TextView)findViewById(R.id.tv);
		tv.setText("Om Namah Shivaya (dhun)");
		
		mp=MediaPlayer.create(Mantra5.this, R.raw.mantra5);
		iv=(ImageView)findViewById(R.id.iv);
		timer = new MyCounter((mins*60*1000)+(sec*1000),1000);
		timer.start();
		timer1=timer;
		
		seekBar = (SeekBar) findViewById(R.id.SeekBar01);
        seekBar.setMax(mp.getDuration());
        
        
        seekBar.setOnTouchListener(new OnTouchListener() {public boolean onTouch(View v, MotionEvent event) {
            seekChange(v);
            return false; }
        }); 
		
		mp.start();
		mp.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				
				mp.seekTo(0);
				mp.pause();
				Intent stopplay=new Intent(Mantra5.this,Mantra1.class);
	            startActivity(stopplay);
			}
		});
		
		startPlayProgressUpdater();
		
		
		tb=(ToggleButton)findViewById(R.id.tb);
		tb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	            seekBar.setProgress(mp.getCurrentPosition());
				if(tb.isChecked())
				{
					mp.pause();
					startPlayProgressUpdater();
					tb.setBackgroundResource(R.drawable.play);
				}
				else
				{
					mp.start();
					startPlayProgressUpdater();
					tb.setBackgroundResource(R.drawable.pause);
				}

			}
		});
		
		next=(Button)findViewById(R.id.next);
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.pause();
				mp.seekTo(0);
				Intent stopplay=new Intent(Mantra5.this,Mantra1.class);
	            startActivity(stopplay);

			}
		});
		previous=(Button)findViewById(R.id.previous);
		previous.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.pause();
				mp.seekTo(0);
				Intent stopplay=new Intent(Mantra5.this,Mantra4.class);
	            startActivity(stopplay);
				

			}
		});
		stop=(Button)findViewById(R.id.stop);
		stop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.pause();	
				mp.seekTo(0);
				seekBar.setProgress(0);
									
				tb.setBackgroundResource(R.drawable.play);
				tb.setChecked(true);
				

			}
		});
		
		tb1=(ToggleButton)findViewById(R.id.tb1);
		tb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	            
				if(tb1.isChecked())
				{
					timer.cancel();
					
					tb1.setBackgroundResource(R.drawable.play);
				}
				else
				{
					
					timer.start();
									
					
					tb1.setBackgroundResource(R.drawable.pause);
				}

			}
		});
		
		next1=(Button)findViewById(R.id.next1);
		next1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				timer.cancel();
				tb1.setBackgroundResource(R.drawable.play);
				tb1.setChecked(true);
				

				if(i==0)
					i=1;
				else if(i==1)
					i=2;
				else if(i==2)
					i=3;
				else if(i==3)
					i=4;
				else if(i==4)
					i=5;
				else if(i==5)
					i=6;
				else if(i==6)
					i=0;
				
				iv.setImageResource(IMAGE_IDS[i]);
				
				

			}
		});
		previous1=(Button)findViewById(R.id.previous1);
		previous1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				timer.cancel();
				tb1.setBackgroundResource(R.drawable.play);
				tb1.setChecked(true);


				if(i==0)
					i=6;
				else if(i==1)
					i=0;
				else if(i==2)
					i=1;
				else if(i==3)
					i=2;
				else if(i==4)
					i=3;
				else if(i==5)
					i=4;
				else if(i==6)
					i=5;
				
				iv.setImageResource(IMAGE_IDS[i]);
				

			}
		});
		
	}       
   	
	

	protected void startPlayProgressUpdater() {
		// TODO Auto-generated method stub
		seekBar.setProgress(mp.getCurrentPosition());
		
		
		if (mp.isPlaying()) {
            notification = new Runnable() {
                public void run() {
                    startPlayProgressUpdater();
                }
            };
            handler.postDelayed(notification,1000);
        }
       
        else{
            mp.pause();
			tb.setBackgroundResource(R.drawable.play);
        }
	}
	
	protected void seekChange(View v) {
		// TODO Auto-generated method stub
		
            SeekBar sb = (SeekBar)v;
            mp.seekTo(sb.getProgress());
        
	}
	
	public class MyCounter extends CountDownTimer{
		 
        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
 
        @Override
        public void onFinish() {
        	timer.cancel();
        	timer1.cancel();
        }
 
        @Override
        public void onTick(long millisUntilFinished) {
                 if((millisUntilFinished/1000)%3==0)
                 //iv.setImageResource(R.drawable.shiv8); 
                 {   iv.setImageResource(IMAGE_IDS[i]);
                 
                 i++;
                 if(i>6)
                	 i=0;}
                 
                // tv.setText(""+(millisUntilFinished/1000)%3);
                  
            }  
        	
        	
        	
        }
	

	
	
	@Override 
	public void onBackPressed(){
		
		mp.pause();
		Intent i=new Intent("COM.CENA.GENAKS.SHIVAMANTRAS.MANTRASLIST");
		startActivity(i);

	  //there is no reason to call super.finish(); here
	  //call super.onBackPressed(); and it will finish that activity for you
	  super.onBackPressed(); 
	}
    
	
/*	@Override
	protected void onPause() {
	    if (mp != null)
	      mp.stop();
	    super.onPause();
	}
	@Override
	protected void onStop() {
		if (mp != null){
		      if(mp.isPlaying())
		    	  mp.stop();
		      }

	    super.onStop();
	}
	*/
	
	/*public boolean onKeyDown(int keyCode, KeyEvent event) 
    {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) 
        {
        	
                
           
            	mc.hide();
            	
                handler.removeCallbacks(notification);

            	mp.stop();
            	mp.release();
                mp=null;
                return true;
            
        }
        return super.onKeyDown(keyCode, event);
    }*/

	

/*Override

	 public boolean onKeyDown(int keyCode, KeyEvent event) 
	 {
	        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) 
	        {
	        	if(mp != null) {
	                if (mp.isPlaying())
	                {
	                    mp.stop();
	                }
	                mp.release();
	                mp = null;
	            }
	             
	             Intent intent = new Intent(Mantra5.this, MantrasList.class);
	     	    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);    
	     	    startActivity(intent);
	             return true;
	        }
	        return super.onKeyDown(keyCode, event);
	  }*/
       

		
	   
		
	}

	

