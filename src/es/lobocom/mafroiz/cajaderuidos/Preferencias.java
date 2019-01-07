package es.lobocom.mafroiz.cajaderuidos;

import android.R;
import android.os.Bundle;
import android.preference.PreferenceActivity;


public class Preferencias extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}
	
	
}
