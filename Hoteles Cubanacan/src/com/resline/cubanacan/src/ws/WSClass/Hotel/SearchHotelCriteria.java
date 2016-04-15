package com.resline.cubanacan.src.ws.WSClass.Hotel;

import java.util.GregorianCalendar;

/**
 * <p>
 * Java class for SearchHotelCriteria complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;SearchHotelCriteria&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;Nights&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot;/&gt;
 *         &lt;element name=&quot;ResortName&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;LocationId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;DepartureDate&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot;/&gt;
 *         &lt;element name=&quot;Categories&quot; type=&quot;{http://www.e-resline.com/}ArrayOfHotelCategoryEnum&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Allocation&quot; type=&quot;{http://www.e-resline.com/}ArrayOfRoomAllocation&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

public class SearchHotelCriteria {

	protected int nights;
	protected String resortName;
	protected Long locationId;
	protected String checkInDate;
	protected ArrayOfHotelCategoryEnum categories;
	protected ArrayOfRoomAllocation allocation;

	/**
	 * Gets the value of the nights property.
	 * 
	 */
	public int getNights() {
		return nights;
	}

	/**
	 * Sets the value of the nights property.
	 * 
	 */
	public void setNights(int value) {
		this.nights = value;
	}

	/**
	 * Gets the value of the resortName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResortName() {
		return resortName;
	}

	/**
	 * Sets the value of the resortName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setResortName(String value) {
		this.resortName = value;
	}

	/**
	 * Gets the value of the locationId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public Long getLocationId() {
		return locationId;
	}

	/**
	 * Sets the value of the locationId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocationId(Long value) {
		this.locationId = value;
	}


	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	/**
	 * Gets the value of the categories property.
	 * 
	 * @return possible object is {@link ArrayOfHotelCategoryEnum }
	 * 
	 */
	public ArrayOfHotelCategoryEnum getCategories() {
		return categories;
	}

	/**
	 * Sets the value of the categories property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfHotelCategoryEnum }
	 * 
	 */
	public void setCategories(ArrayOfHotelCategoryEnum value) {
		this.categories = value;
	}

	/**
	 * Gets the value of the allocation property.
	 * 
	 * @return possible object is {@link ArrayOfRoomAllocation }
	 * 
	 */
	public ArrayOfRoomAllocation getAllocation() {
		if (allocation == null) {
			allocation = new ArrayOfRoomAllocation();
		}
		return allocation;
	}

	/**
	 * Sets the value of the allocation property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfRoomAllocation }
	 * 
	 */
	public void setAllocation(ArrayOfRoomAllocation value) {
		this.allocation = value;
	}
}