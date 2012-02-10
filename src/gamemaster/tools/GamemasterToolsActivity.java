package gamemaster.tools;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;



public class GamemasterToolsActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	private Button _editButton;
	private DrawView _drawView;
	private FrameLayout _frameLayout;
	private CharStatEditor _charEdit;
	private Boolean _editingChars;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     
        _editingChars= false;
        
        setContentView(R.layout.main);
        _editButton= (Button)findViewById(R.id.charEditBtn);
        _editButton.setOnClickListener(this);
        _frameLayout= (FrameLayout) findViewById(R.id.frameLayout);
        _drawView= new DrawView(this);        
        _drawView.setBackgroundColor(Color.WHITE);    
        _frameLayout.addView(_drawView, 0);
        
        _charEdit= new CharStatEditor(this);
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		_frameLayout.removeViewAt(0);
		if(!_editingChars){			
			_frameLayout.addView(_charEdit, 0);
			_editButton.setText("Done");
			_editingChars= true;
		}else{
			_frameLayout.addView(_drawView, 0);
			_editButton.setText("Character Editor");
			_editingChars= false;
		}
	}
}