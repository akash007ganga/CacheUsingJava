package accessor;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import dao.CacheFactory;
import dao.Cacheable;
import enums.CacheTableName;

/**
 * The singletone Class CacheAccessor. It will build the cache only once.
 * We have implemented Serializable for future use if any
 */
public class CacheAccessor implements Serializable{

//~ Constant Attributes ====================================================
	
    /**
     * The <code>Log</code> instance for this class.
     */
	private static final Logger log = Logger.getLogger(CacheAccessor.class);
	
 //~ Class Attributes =======================================================
    
    /**
     * Singleton instance. Must be volatile for happens before guaranty
     */
    private static volatile CacheAccessor m_instance = null;
    
    /**
     * Map of all entries in all tables which requires cache.
     */
    private static Map<String, Map<Long, Cacheable>> m_cache = new HashMap<String, Map<Long, Cacheable>>();    

    
    //~ Constructors ===========================================================
    
    /**
     * Private Constructor. instantitiation through reflection prevented. Use getInstance().
     */
    private CacheAccessor() {
    
    	if(CacheAccessor.m_instance != null) {
    		 throw new RuntimeException("Can't create singleton twice");
    	}
    }
    /**
     * to stop from being cloning
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("This obect cloning is not allowed"); 
    }
    
    /* to support serialization and singletone for future use if any*/
    
    protected Object readResolve() {
        return m_instance;
    }
    
    /* to stop creating using class loader */
    
    public Object newInstance() throws InstantiationException {
        throw new InstantiationError( "This obect creation not allowed" );
    }
    
    
    
    
    
    //~ Class Methods ==========================================================

    /**
     * Package private. The instance is created during
     * initialization.
     *
     * @return the singleton instance.
     */
    public static CacheAccessor getInstance() {
        return m_instance;
    }
    
    /**
     * Get a record of specific table with specific primary key(pk).
     *
     * @param tableName the table name
     * @param pk the pk
     * @return the corresponding record
     */
    public Cacheable getRecord(String tableName, long pk) {
    	Map<Long, Cacheable> map = m_cache.get(tableName);
        return map.get(pk);
    }
    
    /**
     * Initialization method to initialize the cache.
     * This method will typically be called during initialization
     * @throws Exception the exception
     */
    public static void init() throws Exception {
    	
    	if(log.isDebugEnabled()) {
    		log.debug("Thread[" + Thread.currentThread().getName() + "] tries to build the cache");
    	}
    	
    	if(m_instance == null){
            synchronized (CacheAccessor.class) {
                if(m_instance == null){
                	if(log.isDebugEnabled()) {
                		log.debug("Thread[" + Thread.currentThread().getName() + "] started to build the cache.....");
                	}
                	
                	m_instance = new CacheAccessor();
                	try {
                        buildCache();
                    } catch (SQLException e) {
                        log.error("Error occured in building cache", e);
                        throw e;
                    }
                }
            }
    	}          
    }

	/**
	 * Builds the cache.
	 *
	 * @throws SQLException the SQL exception
	 */
	private static void buildCache() throws SQLException{
		CacheTableName[] tableNames = CacheTableName.values();
		
		for(CacheTableName tableName : tableNames) {
			Cacheable handler = new CacheFactory().getCacheTableHandler(tableName);
			List<Cacheable> records = handler.fetchRecordsFromDB();
			Map<Long, Cacheable> map= new HashMap<Long, Cacheable>();
			for(Cacheable record: records) {
				map.put(record.getUniqueIdentifier(), record);
			}
			
			m_cache.put(tableName.name(), map);
		}
	}

    
    
}
