package com.example.runrun.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.runrun.data.entities.Race;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * {@link #DatabaseHelper} provides convenient access to the embedded database using data access objects.
 * 
 * @author BeepBeep
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	// ******************************
	// Constants
	// ******************************
	private static final String DATABASE_NAME = "RunRun.sqlite";
	private static final int DATABASE_VERSION = 1;
	
	// ******************************
	// Fields
	// ******************************
	private Dao<Race, Integer> raceDao = null;
	
	// ******************************
	// Constructor(s)
	// ******************************
	/**
	 * Default constructor.
	 * 
	 * @param context
	 *            The application's {@link #Context}.
	 */
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	// ******************************
	// Methods
	// ******************************
	@Override
	public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, Race.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		List<String> allSql = new ArrayList<String>();
		switch (oldVersion) {
			case 1:
				// allSql.add("alter table AdData add column `new_col` VARCHAR");
				// allSql.add("alter table AdData add column `new_col2` VARCHAR");
				break;
			case 2:
				break;
			case 3:
				break;
		}
		
		for (String sql : allSql) {
			db.execSQL(sql);
		}
	}
	
	/**
	 * Returns the {@link #Race}'s data access object.
	 * 
	 * @return The {@link #Race}'s data access object.
	 * @throws SQLException 
	 */
	public Dao<Race, Integer> getRaceDao() throws SQLException {
		if (null == raceDao) {
			raceDao = getDao(Race.class);
		}
		
		return raceDao;
	}
}