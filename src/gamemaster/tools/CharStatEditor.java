package gamemaster.tools;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.view.View.OnClickListener;

public class CharStatEditor extends TableLayout implements OnClickListener{
	private LinearLayout _workspaceLayout; 
	
	private Button _newCharBtn;
	private Button _delCharBtn;	
	private TableRow _buttonRow;
	
	
	public CharStatEditor(Context context) {
		super(context);

		_newCharBtn= new Button(getContext());
		_newCharBtn.setText("New Char");
		_newCharBtn.setOnClickListener(this);
		_delCharBtn= new Button(getContext());
		_delCharBtn.setText("Delete Char");	
		_delCharBtn.setOnClickListener(this);		
		
		this.setBackgroundColor(Color.BLACK);
		
		_buttonRow= new TableRow(getContext());
		
		_buttonRow.addView(_newCharBtn, 0);
		_buttonRow.addView(_delCharBtn, 1);
		_buttonRow.setGravity(Gravity.FILL_HORIZONTAL);
		this.addView(_buttonRow);
	
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}