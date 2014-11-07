package mockinbird.imccorregido;

import java.util.Timer;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String LOGTAG="MainActivity";
	
	private IndiceMasaCorporal imc;
	EditText editPeso;
	EditText editAltura;
	TextView textViewResultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Establecer identificadores
		editPeso = (EditText) findViewById(R.id.editPeso);
		editAltura = (EditText) findViewById(R.id.editAltura);
		textViewResultado = (TextView) findViewById(R.id.textViewResultado);

	}

	/**
	 * onButtonClickCalcularIMC
	 * @throws InterruptedException 
	 */
	public void onButtonClickCalcularIMC(View v) throws InterruptedException {

		String peso;
		String altura;
		String resultado, resultadoC;
		try {
			
			
			editAltura.setBackgroundColor(Color.WHITE);
			editPeso.setBackgroundColor(Color.WHITE);
			peso = editPeso.getText().toString();
			altura = editAltura.getText().toString();
			imc = new IndiceMasaCorporal(peso, altura);
			resultado = "Valor IMC = " + imc.valorIndiceMasaCorporal() + " - ";
			resultado = resultado.concat(imc.clasificacionOMS());
			resultadoC=""+imc.clasificacionOMS();
			setColor(resultadoC);
			textViewResultado.setText(resultado);
			Log.e(LOGTAG, imc.toString());
			
			
			
		} catch (IndiceMasaCorporalException e) {
			if (e.isErrorPeso()) {
				textViewResultado.setText("");
				editPeso.setBackgroundColor(Color.rgb(250, 120, 120));
				Toast to=new Toast(this);
				to= to.makeText(this, "Introduzca un peso válido (10-300Kg)", 8);
				to.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				to.show();
				
				}
			
		
			
			if (e.isErrorAltura()){
				textViewResultado.setText("");
				editAltura.setBackgroundColor(Color.rgb(250, 120, 120));
				Toast toa=new Toast(this);
				toa= toa.makeText(this, "Introduzca una altura válida (100-300cm)", 8);
				 toa.setGravity(Gravity.CENTER_VERTICAL, 0, 50);
				toa.show();	
				
				}
		} catch (Exception e) {
			Log.e(LOGTAG, e.getMessage());
		}
	}
	
	public void setColor(String res){
		
		
		if(res.compareToIgnoreCase("Delgadez Extrema")==0){
			textViewResultado.setTextColor(Color.RED);
		}
		else if(res.compareToIgnoreCase("Delgadez moderada")==0){
			textViewResultado.setTextColor(Color.MAGENTA);
		}
		else if(res.compareToIgnoreCase("Delgadez aceptable")==0){
			textViewResultado.setTextColor(Color.YELLOW);
		}
		else if(res.compareToIgnoreCase("Peso Normal")==0){
			textViewResultado.setTextColor(Color.GREEN);
		}
		else if(res.compareToIgnoreCase("Sobrepeso")==0){
			textViewResultado.setTextColor(Color.YELLOW);
		}
		else if(res.compareToIgnoreCase("Obesidad Ligera")==0){
			textViewResultado.setTextColor(Color.MAGENTA);}
		else if(res.compareToIgnoreCase("Obeso Moderada")==0){
			textViewResultado.setTextColor(Color.RED);
		}
		else if(res.compareToIgnoreCase("Obeso Mórbido")==0){
			textViewResultado.setTextColor(Color.RED);	
		}
	}
	
	public String toString(){
		
		return ""+textViewResultado.getText();
	}
	
	public void reset(View w){
		
		editAltura.setBackgroundColor(color.transparent);
		editPeso.setBackgroundColor(color.transparent);
	}

	public void onButonAcercaDe(View v){
		Intent i= new Intent(this,AcercaDe.class);  //This: dsd donde lo lanza, AcercaDe.class crea un objeto de la clase
		startActivity(i);
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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