package mockinbird.imccorregido;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AcercaDe extends Activity {
	
	TextView textView1;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acerca_de);
		
		textView1=(TextView) findViewById(R.id.textView1);
		info();
		
		
	}
	
	public void info(){
		
		String info="\nLa OMS (Organización mundial de la salud) recomienda un hábito de vida saludable" +
				" mediante la ingesta de alimentos bajos en grasas y la realización habitual de deporte" +
				" al aire libre, llevando una vida sana podemos evitar muchas de las enfermedades" +
				" cardiovasculares más comunes.";
		
		textView1.setText(info);
		
		
	}
	
	public void onClickButtonOk(View v) {
		
		this.finish();
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