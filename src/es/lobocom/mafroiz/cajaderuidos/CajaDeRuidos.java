package es.lobocom.mafroiz.cajaderuidos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class CajaDeRuidos extends Activity {

	private static final String LOGTAG = "CajaDeRuidos";

	SoundManager snd;
	int soundTristeza, soundDecepcion, soundObedece, soundMelapela, soundNombecabrees, soundNopuedespararme;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Eliminar el título de la activity
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Configurar pantalla completa (oculta incluso la barra de estado
		this.getWindow().setFlags(
		   WindowManager.LayoutParams.FLAG_FULLSCREEN, 
		   WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.caja_de_ruidos);
		 Log.i(LOGTAG,"arranco");
		// Creamos una instancia de SoundManager
		snd = new SoundManager(getApplicationContext());
		
		// Carga de audios
		soundTristeza = snd.load(R.raw.chewbacca);
		soundDecepcion = snd.load(R.raw.wa_wa_wa_wavavavava);
		soundObedece = snd.load(R.raw.latigo);
		soundMelapela = snd.load(R.raw.erupto);
		soundNombecabrees = snd.load(R.raw.lightsaber);
		soundNopuedespararme = snd.load(R.raw.darth_vader);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.caja_de_ruidos, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_acercaDe:
				lazarAcercaDe();
				break;
			case R.id.menu_settings:
				lazarSettings();
				break;	
				
		}
		return false;
	}

	
	public void lazarAcercaDe(){
		Intent i = new Intent(this, AcercaDe.class);
		startActivity(i);
	}	

	
	public void lazarSettings(){
		Intent i = new Intent(this, Preferencias.class);
		startActivity(i);
	}	
	
	
	// Button listener assigned in XML layout
    public void clickHandler(View v)
    {
    	int id = v.getId(); // Use the button id to determine which sample should be played
    	
    	switch (id)
    	{
    	 case R.id.button1:
    	  snd.play(soundNombecabrees);
    	  break;
    	  
    	 case R.id.button2:
    	  snd.play(soundNopuedespararme);
    	  break;
    	   
    	 case R.id.button3:
       	  snd.play(soundMelapela);
       	  break;    	  
       	  
    	 case R.id.button4:
          snd.play(soundObedece);
          break;    	  
          	  
    	 case R.id.button5:
          snd.play(soundTristeza);
          break;    	  
          	  
    	 case R.id.button6:
          snd.play(soundDecepcion);
          break;   
           
                            
    	}
    }	
	
	
}
