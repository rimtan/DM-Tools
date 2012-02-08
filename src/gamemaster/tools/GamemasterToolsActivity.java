package gamemaster.tools;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;


public class GamemasterToolsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        DrawView drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);       
      
    }
}