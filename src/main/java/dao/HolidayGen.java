package dao;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class HolidayGen corresponding to REF_HOLIDAY.
 */
public class HolidayGen implements Cacheable {


	@Override
	public long getUniqueIdentifier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String displayRecords() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public List<Cacheable> fetchRecordsFromDB() {
		// TODO Auto-generated method stub
		return new ArrayList<Cacheable>();
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}

}

