package gamemaster.tools;

//import java.util.Vector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener {
	
	  int m_pos_x = 200;
	  int m_pos_y = 200;
	  
	  int m_offset_x = 0;
	  int m_offset_y = 0;
	  
	  int m_size_x = 100;
	  int m_size_y = 100;	
	  
	  boolean m_is_touched = false;

	  Bitmap bitmap;
	  Canvas bitmapCanvas;
	  boolean isInitialized;
	  
	  Paint paint = new Paint();
	  
	  private void initMe(){
		  setFocusable(true);
		  setFocusableInTouchMode(true);
		  this.setOnTouchListener(this);
		  paint.setColor(Color.WHITE);
		  paint.setAntiAlias(true);
		  paint.setStyle(Style.FILL_AND_STROKE);
		  isInitialized = false;	  
	  }	  
	  
	  public DrawView(Context context)	  {
	    super(context);
	    initMe();
	  }
	  
	  public DrawView(Context context, AttributeSet attrs) {
		  super( context, attrs );
		  initMe();
	  }
	  
	  public DrawView(Context context, AttributeSet attrs, int defStyle) {		   
		  super( context, attrs, defStyle );
		  initMe();
	  }
	  
	  private void init()
	  {
	    bitmap = Bitmap.createBitmap(m_size_x, m_size_y, Bitmap.Config.RGB_565);	    
	    bitmapCanvas = new Canvas();
	    bitmapCanvas.setBitmap(bitmap);
	    bitmapCanvas.drawColor(Color.GREEN);	    
	    isInitialized = true;
	  }
	  
	  @Override
	  public void onDraw(Canvas canvas){
	    if (!isInitialized)
	      init();	    
	    canvas.drawBitmap(bitmap, m_pos_x, m_pos_y, paint); 
	  }	 
	  
	  public boolean onTouch(View view, MotionEvent event) {
		  if (event.getAction() == MotionEvent.ACTION_DOWN){		  
			  if (event.getX() > m_pos_x
					  && event.getX() < m_pos_x + bitmap.getWidth()
					  && event.getY() > m_pos_y
					  && event.getY() < m_pos_y + bitmap.getHeight()){			
				  m_offset_x = (int) event.getX() - m_pos_x;
				  m_offset_y = (int) event.getY() - m_pos_y;
				  m_is_touched = true;
			  }	   
		  } else if (event.getAction() == MotionEvent.ACTION_MOVE){
			  if (m_is_touched){
				  m_pos_x = (int) event.getX() - m_offset_x;
				  m_pos_y = (int) event.getY() - m_offset_y;
			  }			  		  
		  } else if (event.getAction() == MotionEvent.ACTION_UP){
			  m_is_touched = false;
		  }
	    
	    invalidate();
	    return true;
	  }

}
