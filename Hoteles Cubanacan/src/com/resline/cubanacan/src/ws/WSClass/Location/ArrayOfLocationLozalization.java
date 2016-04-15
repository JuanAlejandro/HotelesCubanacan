package com.resline.cubanacan.src.ws.WSClass.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java class for ArrayOfLocationLocalizationResult complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ArrayOfLocationLocalizationResult&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ThemeLocationResult&quot; type=&quot;{http://www.e-resline.com/}ThemeLocationResult&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

public class ArrayOfLocationLozalization {

	protected List<LocationLocalization> locationLocalizationResult;

	/**
	 * Gets the value of the hotelResult property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the hotelResult property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getHotelResult().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link HotelResult }
	 * 
	 * 
	 */
	public List<LocationLocalization> getLocationLocalizationResult() {
		if (locationLocalizationResult == null) {
			locationLocalizationResult = new ArrayList<LocationLocalization>();
		}
		return this.locationLocalizationResult;
	}

}
