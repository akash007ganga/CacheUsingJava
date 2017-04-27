package com.test;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import accessor.CacheAccessor;
import dao.Cacheable;
import dao.CountryGen;

public class TestCache {
	
	/**
     * The <code>Log</code> instance for this class.
     */
	private static final Logger log = Logger.getLogger(TestCache.class);

	@BeforeClass 
	public static void init() {
		try {
			CacheAccessor.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test 1 for accessing object present in cache.
	 */
	@Test
	public void test1()  {
		String tableName = "REF_COUNTRY";
		long pk = 1;
		
		CountryGen c1 = new CountryGen();
		c1.setCountryId(1);
		c1.setCountryCd("Country CD 1");
		c1.setCountryName("Country Name 1");
		c1.setStatusInd(11);
		c1.setLastModifyDate(new Date());
		c1.setModifyPersonNum(12);
				
		Cacheable record = CacheAccessor.getInstance().getRecord(tableName, pk);
		log.debug("Record: " + record.displayRecords());
		Assert.assertEquals("Obects are not equal", record, c1);		
	}
	
	/**
	 * Test 2 for accessing object not present in cache.
	 */
	
	@Test
	public void test2()  {
		String tableName = "REF_COUNTRY";
		long pk = 2;
		
		CountryGen c1 = new CountryGen();
		c1.setCountryId(1);
		c1.setCountryCd("Country CD 1");
		c1.setCountryName("Country Name 1");
		c1.setStatusInd(11);
		c1.setLastModifyDate(new Date());
		c1.setModifyPersonNum(12);
				
		Cacheable record = CacheAccessor.getInstance().getRecord(tableName, pk);
		log.debug("Record: " + record.displayRecords());
		Assert.assertNotSame(c1, record);
		
	}
	
	/**
	 * Test 3: To test whether cache has been build only once or not.
	 */
	
	@Test
	public void test3()  {
		
    for(int i=0; i<100; i++) {	
    	log.debug("Started Thread: " + i);
	 Thread T1 = new Thread(new Runnable() {
		 
		 @Override
		 public void run() {
			 try {
				CacheAccessor.init();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		 }
	 });
	 T1.setName("Thread " + i);
	 T1.start();
	
    }
		
		
	}
}
