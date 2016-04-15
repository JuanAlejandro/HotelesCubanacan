package com.resline.cubanacan.src.ws.WSClass.Hotel;

import android.location.Location;

import com.resline.cubanacan.src.ws.WSClass.Image.ArrayOfImage;

/**
 * <p>
 * Java class for HotelDetails complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;HotelDetails&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;Active&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}boolean&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Code&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Brand&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Phone&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Fax&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Adress&quot; type=&quot;{http://www.e-resline.com/}Address&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;RoomCount&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CheckIntime&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CheckOutTime&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;AllInclusive&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}boolean&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Priority&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Location&quot; type=&quot;{http://www.e-resline.com/}Location&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CategoryEnum&quot; type=&quot;{http://www.e-resline.com/}HotelCategoryEnum&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Facilities&quot; type=&quot;{http://www.e-resline.com/}ArrayOfAccommodationFacility&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Images&quot; type=&quot;{http://www.e-resline.com/}ArrayOfImage&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;HotelId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;FromPrice&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}double&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class HotelFullDetails {

	protected Boolean active;
	protected String code;
	protected String name;
	protected String brand;
	protected String phone;
	protected String fax;
	protected Address adress;
	protected Integer roomCount;
	protected String checkIntime;
	protected String checkOutTime;
	protected Boolean allInclusive;
	protected Integer priority;
	protected Location location;
	protected HotelCategoryEnum categoryEnum;
	protected ArrayOfAccommodationFacility facilities;
	protected ArrayOfRoomType roomTypes;
	protected ArrayOfImage images;
	protected Long hotelId;
	protected Double fromPrice;
	protected String description;
	protected String services;
	protected ArrayOfThemesLocationsResult themes;
	
	
	/**
	 * Gets the value of the active property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isActive() {
		return active;
	}

	/**
	 * Sets the value of the active property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setActive(Boolean value) {
		this.active = value;
	}

	/**
	 * Gets the value of the code property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the value of the code property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the brand property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the value of the brand property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBrand(String value) {
		this.brand = value;
	}

	/**
	 * Gets the value of the phone property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the value of the phone property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPhone(String value) {
		this.phone = value;
	}

	/**
	 * Gets the value of the fax property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Sets the value of the fax property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFax(String value) {
		this.fax = value;
	}

	/**
	 * Gets the value of the adress property.
	 * 
	 * @return possible object is {@link Address }
	 * 
	 */
	public Address getAdress() {
		return adress;
	}

	/**
	 * Sets the value of the adress property.
	 * 
	 * @param value
	 *            allowed object is {@link Address }
	 * 
	 */
	public void setAdress(Address value) {
		this.adress = value;
	}

	/**
	 * Gets the value of the roomCount property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getRoomCount() {
		return roomCount;
	}

	/**
	 * Sets the value of the roomCount property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setRoomCount(Integer value) {
		this.roomCount = value;
	}

	/**
	 * Gets the value of the checkIntime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCheckIntime() {
		return checkIntime;
	}

	/**
	 * Sets the value of the checkIntime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCheckIntime(String value) {
		this.checkIntime = value;
	}

	/**
	 * Gets the value of the checkOutTime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCheckOutTime() {
		return checkOutTime;
	}

	/**
	 * Sets the value of the checkOutTime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCheckOutTime(String value) {
		this.checkOutTime = value;
	}

	/**
	 * Gets the value of the allInclusive property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isAllInclusive() {
		return allInclusive;
	}

	/**
	 * Sets the value of the allInclusive property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setAllInclusive(Boolean value) {
		this.allInclusive = value;
	}

	/**
	 * Gets the value of the priority property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * Sets the value of the priority property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setPriority(Integer value) {
		this.priority = value;
	}

	/**
	 * Gets the value of the location property.
	 * 
	 * @return possible object is {@link Location }
	 * 
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the value of the location property.
	 * 
	 * @param value
	 *            allowed object is {@link Location }
	 * 
	 */
	public void setLocation(Location value) {
		this.location = value;
	}

	/**
	 * Gets the value of the categoryEnum property.
	 * 
	 * @return possible object is {@link HotelCategoryEnum }
	 * 
	 */
	public HotelCategoryEnum getCategoryEnum() {
		return categoryEnum;
	}

	/**
	 * Sets the value of the categoryEnum property.
	 * 
	 * @param value
	 *            allowed object is {@link HotelCategoryEnum }
	 * 
	 */
	public void setCategoryEnum(HotelCategoryEnum value) {
		this.categoryEnum = value;
	}
	
	/**
	 * Gets the value of the facilities property.
	 * 
	 * @return possible object is {@link ArrayOfAccommodationFacility }
	 * 
	 */
	public ArrayOfAccommodationFacility getFacilities() {
		return facilities;
	}
	
	/**
	 * Sets the value of the facilities property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfAccommodationFacility }
	 * 
	 */
	public void setFacilities(ArrayOfAccommodationFacility value) {
		this.facilities = value;
	}
	
	/**
	 * Gets the value of the roomTypes property.
	 * 
	 * @return possible object is {@link ArrayOfRoomType }
	 * 
	 */
	public ArrayOfRoomType getRoomTypes() {
		return roomTypes;
	}
	
	/**
	 * Sets the value of the roomTypes property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfRoomType }
	 * 
	 */
	public void setRoomTypes(ArrayOfRoomType value) {
		this.roomTypes = value;
	}

	/**
	 * Gets the value of the images property.
	 * 
	 * @return possible object is {@link ArrayOfImage }
	 * 
	 */
	public ArrayOfImage getImages() {
		return images;
	}

	/**
	 * Sets the value of the images property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfImage }
	 * 
	 */
	public void setImages(ArrayOfImage value) {
		this.images = value;
	}

	/**
	 * Gets the value of the hotelId property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getHotelId() {
		return hotelId;
	}

	/**
	 * Sets the value of the hotelId property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setHotelId(Long value) {
		this.hotelId = value;
	}
	
	/**
	 * Gets the value of the fromPrice property.
	 * 
	 * @return possible object is {@link Double }
	 * 
	 */
	public Double getFromPrice() {
		return fromPrice;
	}

	/**
	 * Sets the value of the fromPrice property.
	 * 
	 * @param value
	 *            allowed object is {@link Double }
	 * 
	 */
	public void setFromPrice(Double value) {
		this.fromPrice = value;
	}
	
	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}
	
	/**
	 * Gets the value of the services property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getServices() {
		return services;
	}

	/**
	 * Sets the value of the services property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setServices(String value) {
		this.services = value;
	}
	
	/**
	 * Gets the value of the themes property.
	 * 
	 * @return possible object is {@link ArrayOfAccommodationFacility }
	 * 
	 */
	public ArrayOfThemesLocationsResult getThemes() {
		return themes;
	}
	
	/**
	 * Sets the value of the facilities property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfAccommodationFacility }
	 * 
	 */
	public void setThemes(ArrayOfThemesLocationsResult value) {
		this.themes = value;
	}
}
