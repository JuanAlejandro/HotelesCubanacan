package com.resline.cubanacan.src.ws.WSClass.Hotel;

/**
 * <p>
 * Java class for RoomType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;RoomType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;RoomTypeId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;RoomTypeName&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;RoomServices&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}ArrayOfRoomService&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class RoomType {

	protected long roomTypeId;
	protected String roomTypeName;
	protected ArrayOfRoomService roomServices;

	/**
	 * Gets the value of the roomTypeId property.
	 * 
	 */
	public long getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * Sets the value of the roomTypeId property.
	 * 
	 */
	public void setRoomTypeId(long value) {
		this.roomTypeId = value;
	}

	/**
	 * Gets the value of the roomTypeName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRoomTypeName() {
		return roomTypeName;
	}

	/**
	 * Sets the value of the roomTypeName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRoomTypeName(String value) {
		this.roomTypeName = value;
	}

	public ArrayOfRoomService getRoomServices() {
		return roomServices;
	}

	public void setRoomServices(ArrayOfRoomService roomServices) {
		this.roomServices = roomServices;
	}

}
