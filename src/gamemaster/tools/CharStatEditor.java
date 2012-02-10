package gamemaster.tools;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.view.View.OnClickListener;

public class CharStatEditor extends View implements OnClickListener{
	// since GridLayout is availible in Android >4.0 have to use
	// two LinearLayouts for the Job. Horizonzal Layout provides
	// two Cells which will be filled with a Vertical Layout each.
	// Within those the TextViews and Edits take place
	
	// on top of that are some buttons in a horizontal Layout
	// to compose all together another layout is needed (vertical)
	
	
	
	private LinearLayout _outerLayout;
	private LinearLayout _buttonLayout;
	
	private LinearLayout _workspaceLayout; 
	private LinearLayout _leftSide;
	private LinearLayout _rightSide;
	private Button _newCharBtn;
	private Button _delCharBtn;
	
	private TableLayout _tableLayout;
	private TableRow _buttonRow;
	
	
	public CharStatEditor(Context context) {
		super(context);

		_newCharBtn= new Button(context);
		_newCharBtn.setText("New Char");
		_newCharBtn.setOnClickListener(this);
		_delCharBtn= new Button(context);
		_delCharBtn.setText("Delete Char");	
		_delCharBtn.setOnClickListener(this);
		
/*		_buttonLayout= new LinearLayout(context);
		_buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
		
		_workspaceLayout= new LinearLayout(context);
		_leftSide= new LinearLayout(context);
		_rightSide= new LinearLayout(context);
		_workspaceLayout.setOrientation(LinearLayout.HORIZONTAL);
		_leftSide.setOrientation(LinearLayout.VERTICAL);
		_rightSide.setOrientation(LinearLayout.VERTICAL);
		_workspaceLayout.addView(_leftSide, 0);
		_workspaceLayout.addView(_rightSide,1);
		
		_outerLayout= new LinearLayout(context);
		_outerLayout.setOrientation(LinearLayout.VERTICAL);
		_outerLayout.addView(_buttonLayout, 0);
		_outerLayout.addView(_workspaceLayout, 1);
		
		_buttonLayout.addView(_newCharBtn, 0);
		_buttonLayout.addView(_delCharBtn, 1);*/
		
		_tableLayout= new TableLayout(context);
		_tableLayout.setBackgroundColor(Color.CYAN);
		
		_buttonRow= new TableRow(context);
		
		_buttonRow.addView(_newCharBtn, 0);
		_buttonRow.addView(_delCharBtn, 1);
		
		_tableLayout.addView(_buttonRow);
		
		
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}