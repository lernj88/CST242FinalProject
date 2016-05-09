package model;
/**
 * Address class is comprised of items of information essential to address such as country, zip code, building number, etc. 
 * @author me
 *
 */
public class Address {
	/**
	 * number of the building for given address (presumably >0, but unchecked in this class)
	 */
	private int buildingNumber;
	private String streetName;
	private String city;
	/**
	 * 5-digit number denoting zip code.
	 */
	private String zip;
	private String state;
	private String country = "USA";

	public Address(int buildingNumber, String streetName, String city, String state, String zip) {
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.city = city;
		this.zip = zip;
		this.state = state;
	}
	
	public Address(Address location) {
		this.buildingNumber = location.buildingNumber;
		this.streetName = location.streetName;
		this.city = location.city;
		this.zip = location.zip;
		this.state = location.state;
	}

	public Address() {
	}

	/**
	 * @return the buildingNumber
	 */
	public int getBuildingNumber() {
		return buildingNumber;
	}

	/**
	 * @param buildingNumber the buildingNumber to set
	 */
	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * This method changes the country of the Address (default = USA)
	 * @param country country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + buildingNumber;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (buildingNumber != other.buildingNumber)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return buildingNumber + " " + streetName + ", " + city + ", " + state + ", " + zip + 
				 ", " + country;
	}
}
