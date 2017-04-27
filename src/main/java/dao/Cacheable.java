package dao;

import java.util.List;

/*
 * Every table which requires caching functionality should implement this interface
 */
public interface Cacheable {
	
	
	
	/**
	 * Fetch records from DB.
	 *
	 * @return the cacheable
	 */
	public List<Cacheable> fetchRecordsFromDB();
	
	/**
	 * unique identifier of the implementing table
	 */
	public long getUniqueIdentifier();
	
	/**
	 * Display records of the implementing table.
	 * @return 
	 */
	public String displayRecords() ;

}
