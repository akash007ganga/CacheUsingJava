package dao;

import enums.CacheTableName;

/**
 * A factory for creating Cache objects.
 */
public class CacheFactory {
	
	public Cacheable getCacheTableHandler(CacheTableName tableName) {
		Cacheable handler = null;
		switch(tableName) {
		case REF_COUNTRY : handler =  new CountryGen();
		                   break;
		case REF_CURRENCY: handler =  new CurrencyGen();
		                   break;
		                   
		case REF_HOLIDAY  :handler =  new HolidayGen(); 
		                   break;
		default          : throw new IllegalArgumentException("Table name not supported");
		}
		return handler;
	}

}
