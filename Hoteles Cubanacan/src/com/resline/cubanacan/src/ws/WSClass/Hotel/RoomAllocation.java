package com.resline.cubanacan.src.ws.WSClass.Hotel;

import com.resline.cubanacan.src.ws.WSClass.system.ArrayOfInt;

/**
 * <p>
 * Java class for RoomAllocation complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;RoomAllocation&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;Adults&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot;/&gt;
 *         &lt;element name=&quot;ChildrenAges&quot; type=&quot;{http://www.e-resline.com/}ArrayOfInt&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Quantity&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class RoomAllocation {

	protected int adults;
	protected ArrayOfInt childrenAges;
	protected int quantity;

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
	 * Gets the value of the childrenAges property.
	 * 
	 * @return possible object is {@link ArrayOfInt }
	 * 
	 */
	public ArrayOfInt getChildrenAges() {
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
	 * Gets the value of the quantity property.
	 * 
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 */
	public void setQuantity(int value) {
		this.quantity = value;
	}

}
