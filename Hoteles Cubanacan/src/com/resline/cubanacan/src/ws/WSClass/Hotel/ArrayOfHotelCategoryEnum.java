package com.resline.cubanacan.src.ws.WSClass.Hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java class for ArrayOfHotelCategoryEnum complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ArrayOfHotelCategoryEnum&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;HotelCategoryEnum&quot; type=&quot;{http://www.e-resline.com/}HotelCategoryEnum&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class ArrayOfHotelCategoryEnum {

	protected List<HotelCategoryEnum> hotelCategoryEnum;

	/**
	 * Gets the value of the hotelCategoryEnum property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the hotelCategoryEnum property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getHotelCategoryEnum().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link HotelCategoryEnum }
	 * 
	 * 
	 */
	public List<HotelCategoryEnum> getHotelCategoryEnum() {
		if (hotelCategoryEnum == null) {
			hotelCategoryEnum = new ArrayList<HotelCategoryEnum>();
		}
		return this.hotelCategoryEnum;
	}

}
