package com.resline.cubanacan.src.ws.WSClass.Hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java class for ArrayOfRoomType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ArrayOfRoomType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;RoomType&quot; type=&quot;{http://www.e-resline.com/}RoomType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class ArrayOfRoomType {

	protected List<RoomType> roomType;

	/**
	 * Gets the value of the roomType property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the roomType property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRoomType().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link RoomType }
	 * 
	 * 
	 */
	public List<RoomType> getRoomType() {
		if (roomType == null) {
			roomType = new ArrayList<RoomType>();
		}
		return this.roomType;
	}

}
