package com.example.primitiva;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	
	EditText num;
	Button calc;
	String rand;
	SharedPreferences sharedpreferences;
	static int i=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(i<1){
			i++;
		Intent e= new Intent(this,CargaActivity.class);
		startActivity(e);
		}
		
	    setContentView(R.layout.activity_main);
	    num = (EditText) findViewById(R.id.editCalculo);
	    calc = (Button) findViewById(R.id.calculo);
		sharedpreferences = getSharedPreferences("numeros", Context.MODE_PRIVATE); 
		
		
		
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void crearRandom(View v) {
		Random rdm = new Random();
		rand = "";
		for (int i = 0; i < 7; i++) {
			rand = rand.concat(":"+(rdm.nextInt(48) + 1 )+ ":");
		}
		num.setText(rand);	
	}

	 public void run(View b){	  
		 SharedPreferences.Editor editor = sharedpreferences.edit();
	     editor.putString("numeros",""+num.getText());
	     editor.commit();
	}
	   
	 public void getRun(View r){ 
			if (sharedpreferences.contains("numeros"))
		      {
		         num.setText(sharedpreferences.getString("numeros",""+num));
		      }
	 }
	 
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
