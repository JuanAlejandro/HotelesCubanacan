package com.resline.cubanacan.src.ws.WSClass.Reservation;

import com.resline.cubanacan.src.ws.WSClass.system.ArrayOfInt;
import com.resline.cubanacan.src.ws.WSClass.system.ArrayOfLong;

/**
 * <p>
 * Java class for BookedRoom complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;BookedRoom&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;Adults&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot;/&gt;
 *         &lt;element name=&quot;MealPlanId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;RoomTypeId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;ChildrenAges&quot; type=&quot;{http://www.e-resline.com/}ArrayOfInt&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Roomings&quot; type=&quot;{http://www.e-resline.com/}ArrayOfRooming&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;OptionalServices&quot; type=&quot;{http://www.e-resline.com/}ArrayOfLong&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class BookedRoom {

	protected int adults;
	protected long mealPlanId;
	protected long roomTypeId;
	protected ArrayOfInt childrenAges;
	protected ArrayOfRooming roomings;
	protected ArrayOfLong optionalServices;

	/**
	 * Gets the value of the adults property.
	 * 
	 */
	public int getAdults() {
		return adults;
	}

	/**
	 * Sets the value of the adults property.
	 * 
	 */
	public void setAdults(int value) {
		this.adults = value;
	}

	/**
	 * Gets the value of the mealPlanId property.
	 * 
	 */
	public long getMealPlanId() {
		return mealPlanId;
	}

	/**
	 * Sets the value of the mealPlanId property.
	 * 
	 */
	public void setMealPlanId(long value) {
		this.mealPlanId = value;
	}

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
	 * Gets the value of the childrenAges property.
	 * 
	 * @return possible object is {@link ArrayOfInt }
	 * 
	 */
	public ArrayOfInt getChildrenAges() {
		if(childrenAges == null)
			childrenAges = new ArrayOfInt();
		return childrenAges;
	}

	/**
	 * Sets the value of the childrenAges property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfInt }
	 * 
	 */
	public void setChildrenAges(ArrayOfInt value) {
		this.childrenAges = value;
	}

	/**
	 * Gets the value of the roomings property.
	 * 
	 * @return possible object is {@link ArrayOfRooming }
	 * 
	 */
	public ArrayOfRooming getRoomings() {
		if(roomings == null)
			roomings = new ArrayOfRooming();
		return roomings;
	}

	/**
	 * Sets the value of the roomings property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfRooming }
	 * 
	 */
	public void setRoomings(ArrayOfRooming value) {
		this.roomings = value;
	}

	/**
	 * Gets the value of the optionalServices property.
	 * 
	 * @return possible object is {@link ArrayOfLong }
	 * 
	 */
	public ArrayOfLong getOptionalServices() {
		if(optionalServices == null)
			optionalServices = new ArrayOfLong();
		return optionalServices;
	}

	/**
	 * Sets the value of the optionalServices property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfLong }
	 * 
	 */
	public void setOptionalServices(ArrayOfLong value) {
		this.optionalServices = value;
	}

}
