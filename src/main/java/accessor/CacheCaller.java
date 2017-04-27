package accessor;

import org.apache.log4j.Logger;

import dao.Cacheable;

public class CacheCaller {

	private static final Logger log = Logger.getLogger(CacheCaller.class);
	
	public static void main(String[] args) {
		try {
			//initialize cache
			CacheAccessor.init();
		} catch (Exception e) {
			log.error("Error Occurred", e);
			e.printStackTrace();
		}
		
		Cacheable record = CacheAccessor.getInstance().getRecord(args[0], Long.valueOf(args[1]));
		System.out.println("Record: " + record.displayRecords());
		
	}
}
