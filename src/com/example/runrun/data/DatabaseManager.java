package com.example.runrun.data;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.runrun.data.entities.Race;
import com.j256.ormlite.dao.Dao;

import android.content.Context;

/**
 * DatabaseManager provides convenient access to the embedded database.<br>
 * This is a singleton and it's methods are static.
 * 
 * @author BeepBeep
 */
public class DatabaseManager {
	// ******************************
	// Fields
	// ******************************
	private static DatabaseHelper databaseHelper = null;
	
	// ******************************
	// Private methods
	// ******************************
	private static DatabaseHelper getDatabaseHelper(Context context) {
		if (databaseHelper == null) {
			databaseHelper = new DatabaseHelper(context);
		}
		
		return databaseHelper;
	}
	
	// ******************************
	// Public methods
	// ******************************
	/**
	 * Saves or updates the given {@link #Race} in the database.<br>
	 * Only one {@link #Race} is present in the database.
	 * 
	 * @param context
	 *            The application's {@link #Context}.
	 * @param race
	 *            The {@link #Race} to save or update.
	 */
	public static void saveOrUpdateRace(Context context, Race race) {
		try {
			getDatabaseHelper(context).getRaceDao().createOrUpdate(race);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns all stored {@link #Race}.
	 * 
	 * @param context
	 *            The application's {@link #Context}.
	 * @return All stored {@link #Race}, <code>null</code> if an error happened.
	 * @throws SQLException 
	 */
	public static ArrayList<Race> getAllRace(Context context) throws SQLException {
		Dao<Race, Integer> raceDao = getDatabaseHelper(context).getRaceDao();
		
		try {
			return new ArrayList<Race>(raceDao.queryForAll());
		} catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}
}