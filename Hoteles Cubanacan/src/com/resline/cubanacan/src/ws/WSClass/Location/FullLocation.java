package com.resline.cubanacan.src.ws.WSClass.Location;

import com.resline.cubanacan.src.ws.WSClass.Hotel.ArrayOfHotelDetails;
import com.resline.cubanacan.src.ws.WSClass.Image.ArrayOfImage;

/**
 * <p>
 * Java class for FullLocation complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;FullLocation&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;Id&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

public class FullLocation {

	protected Long id;
	protected String name;
	protected ArrayOfLocationLozalization localizations;
	protected ArrayOfHotelDetails hotels;
	protected ArrayOfImage images;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setId(Long value) {
		this.id = value;
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
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public ArrayOfLocationLozalization getLocalizations() {
		return localizations;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setLocalizations(ArrayOfLocationLozalization value) {
		this.localizations = value;
	}
	
	/**
	 * Gets the value of the hotels property.
	 * 
	 * @return possible object is {@link ArrayOfHotelDetails }
	 * 
	 */
	public ArrayOfHotelDetails getHotels() {
		return hotels;
	}

	/**
	 * Sets the value of the hotels property.
	 * 
	 * @param value allowed object is {@link ArrayOfHotelDetails }
	 * 
	 */
	public void setHotels(ArrayOfHotelDetails value) {
		this.hotels = value;
	}
	
	/**
	 * Gets the value of the images property.
	 */
	public ArrayOfImage getImages() {
		return images;
	}

	/**
	 * Sets the value of the images property.
	 */
	public void setImages(ArrayOfImage value) {
		this.images = value;
	}

	public String __toString(){
		return name;
	}

}
