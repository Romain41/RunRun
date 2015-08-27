package com.example.runrun;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.example.runrun.R;
import com.example.runrun.data.DatabaseManager;
import com.example.runrun.data.entities.Race;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	// ******************************
	// Fields
	// ******************************
	private TextView tvAllRaces;
	private Button btSave;
	private EditText etRace;
	
	// ******************************
	// Private methods
	// ******************************
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initControls();
		refreshRaceList();
	}
	
	private void initControls() {
		tvAllRaces = (TextView) findViewById(R.id.tvAllRaces);
		btSave = (Button) findViewById(R.id.btSave);
		etRace = (EditText) findViewById(R.id.etRace);
		
		btSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				saveNewRace();
				refreshRaceList();
			}
		});
	}
	
	private void saveNewRace() {
		String distance = etRace.getText().toString();
		
		if (distance == null || distance.isEmpty()) {
			Toast.makeText(getApplicationContext(), "You must enter a distance...", Toast.LENGTH_SHORT).show();
		} else {
			float convertedDistance = Float.valueOf(distance);
			Race newRace = new Race(new Date(), convertedDistance);
			DatabaseManager.saveOrUpdateRace(getApplicationContext(), newRace);
		}
	}
	
	private void displayRaces(List<Race> allRaces) {
		StringBuffer result = new StringBuffer();
		
		if (allRaces == null || allRaces.isEmpty()) {
			result.append(getString(R.string.no_race_yet).toString());
		} else {
			for (Race currentRace : allRaces) {
				result.append(currentRace.getDate() + " - " + currentRace.getDistance() + "Kms\n");
			}
		}
		
		tvAllRaces.setText(result.toString());
	}
	
	private void refreshRaceList() {
		List<Race> allRaces = null;
		
		try {
			allRaces = DatabaseManager.getAllRace(getApplicationContext());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		displayRaces(allRaces);
	}
}