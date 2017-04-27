package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Class CountryGen corresponding to REF_COUNTRY.
 */
public class CountryGen implements Cacheable {
	
	private long countryId = -1;
	private String countryCd = null;
	private String countryName = null;
	private long statusInd = -1;
	private Date lastModifyDate = null;
	private long modifyPersonNum = -1;
	
	@Override
	public List<Cacheable> fetchRecordsFromDB() {
		//here we will fetch records from db. For our case we created sample test data
				ArrayList<Cacheable> records = new ArrayList<Cacheable>();
				
				//first obejct
				CountryGen c1 = new CountryGen();
				c1.setCountryId(1);
				c1.setCountryCd("Country CD 1");
				c1.setCountryName("Country Name 1");
				c1.setStatusInd(11);
				c1.setLastModifyDate(new Date());
				c1.setModifyPersonNum(12);
				records.add(c1);
				
				//Second obejct
				CountryGen c2 = new CountryGen();
				c2.setCountryId(2);
				c2.setCountryCd("Country CD 2");
				c2.setCountryName("Country Name 2");
				c2.setStatusInd(21);
				c2.setLastModifyDate(new Date());
				c2.setModifyPersonNum(22);
				records.add(c2);

				//first obejct
				CountryGen c3 = new CountryGen();
				c3.setCountryId(3);
				c3.setCountryCd("Country CD 3");
				c3.setCountryName("Country Name 3");
				c3.setStatusInd(31);
				c3.setLastModifyDate(new Date());
				c3.setModifyPersonNum(32);
				records.add(c3);

				//first obejct
				CountryGen c4 = new CountryGen();
				c4.setCountryId(4);
				c4.setCountryCd("Country CD 4");
				c4.setCountryName("Country Name 4");
				c4.setStatusInd(41);
				c4.setLastModifyDate(new Date());
				c4.setModifyPersonNum(42);
				records.add(c4);
				
				return records;
	}

	@Override
	public String displayRecords() {
		return toString();
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CountryGen [countryId=" + countryId + ", countryCd=" + countryCd + ", countryName=" + countryName
				+ ", statusInd=" + statusInd + ", lastModifyDate=" + lastModifyDate + ", modifyPersonNum="
				+ modifyPersonNum + "]";
	}

	public long getUniqueIdentifier() {

		return getCountryId();
	}
	
	
	/**
	 * @return the countryId
	 */
	public long getCountryId() {
		return countryId;
	}



	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}



	/**
	 * @return the countryCd
	 */
	public String getCountryCd() {
		return countryCd;
	}



	/**
	 * @param countryCd the countryCd to set
	 */
	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}



	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}



	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}



	/**
	 * @return the statusInd
	 */
	public long getStatusInd() {
		return statusInd;
	}



	/**
	 * @param statusInd the statusInd to set
	 */
	public void setStatusInd(long statusInd) {
		this.statusInd = statusInd;
	}



	/**
	 * @return the lastModifyDate
	 */
	public Date getLastModifyDate() {
		return lastModifyDate;
	}



	/**
	 * @param lastModifyDate the lastModifyDate to set
	 */
	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}



	/**
	 * @return the modifyPersonNum
	 */
	public long getModifyPersonNum() {
		return modifyPersonNum;
	}



	/**
	 * @param modifyPersonNum the modifyPersonNum to set
	 */
	public void setModifyPersonNum(long modifyPersonNum) {
		this.modifyPersonNum = modifyPersonNum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCd == null) ? 0 : countryCd.hashCode());
		result = prime * result + (int) (countryId ^ (countryId >>> 32));
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + (int) (modifyPersonNum ^ (modifyPersonNum >>> 32));
		result = prime * result + (int) (statusInd ^ (statusInd >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CountryGen)) {
			return false;
		}
		CountryGen other = (CountryGen) obj;
		if (countryCd == null) {
			if (other.countryCd != null) {
				return false;
			}
		} else if (!countryCd.equals(other.countryCd)) {
			return false;
		}
		if (countryId != other.countryId) {
			return false;
		}
		if (countryName == null) {
			if (other.countryName != null) {
				return false;
			}
		} else if (!countryName.equals(other.countryName)) {
			return false;
		}
		if (modifyPersonNum != other.modifyPersonNum) {
			return false;
		}
		if (statusInd != other.statusInd) {
			return false;
		}
		return true;
	}

	

	

	



	

}
