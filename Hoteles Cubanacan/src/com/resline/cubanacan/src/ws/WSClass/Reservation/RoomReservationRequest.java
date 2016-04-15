package com.resline.cubanacan.src.ws.WSClass.Reservation;

import java.util.GregorianCalendar;

/**
 * <p>
 * Java class for RoomReservationRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;RoomReservationRequest&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;CheckIn&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;CheckOut&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;PaymentMethod&quot; type=&quot;{http://www.e-resline.com/}PaymentMethodEnum&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Rooms&quot; type=&quot;{http://www.e-resline.com/}ArrayOfBookedRoom&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class RoomReservationRequest {

	protected String checkIn;
	protected String checkOut;
	protected PaymentMethodEnum paymentMethod;
	protected ArrayOfBookedRoom rooms;
	protected String email;
	protected String password;
	protected String titularName;
	protected String titularLastName;
	protected String titularEmail;

	/**
	 * Gets the value of the checkIn property.
	 * 
	 * @return possible object is {@link GregorianCalendar }
	 * 
	 */
	public String getCheckIn() {
		return checkIn;
	}

	/**
	 * Sets the value of the checkIn property.
	 * 
	 * @param value
	 *            allowed object is {@link GregorianCalendar }
	 * 
	 */
	public void setCheckIn(String value) {
		this.checkIn = value;
	}

	/**
	 * Gets the value of the checkOut property.
	 * 
	 * @return possible object is {@link GregorianCalendar }
	 * 
	 */
	public String getCheckOut() {
		return checkOut;
	}

	/**
	 * Sets the value of the checkOut property.
	 * 
	 * @param value
	 *            allowed object is {@link GregorianCalendar }
	 * 
	 */
	public void setCheckOut(String value) {
		this.checkOut = value;
	}

	/**
	 * Gets the value of the paymentMethod property.
	 * 
	 * @return possible object is {@link PaymentMethodEnum }
	 * 
	 */
	public PaymentMethodEnum getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Sets the value of the paymentMethod property.
	 * 
	 * @param value
	 *            allowed object is {@link PaymentMethodEnum }
	 * 
	 */
	public void setPaymentMethod(PaymentMethodEnum value) {
		this.paymentMethod = value;
	}

	/**
	 * Gets the value of the rooms property.
	 * 
	 * @return possible object is {@link ArrayOfBookedRoom }
	 * 
	 */
	public ArrayOfBookedRoom getRooms() {
		return rooms;
	}

	/**
	 * Sets the value of the rooms property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfBookedRoom }
	 * 
	 */
	public void setRooms(ArrayOfBookedRoom value) {
		this.rooms = value;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the titularName
	 */
	public String getTitularName() {
		return titularName;
	}

	/**
	 * @param password the titularName to set
	 */
	public void setTitularName(String titularName) {
		this.titularName = titularName;
	}
	
	/**
	 * @return the titularLastName
	 */
	public String getTitularLastName() {
		return titularLastName;
	}

	/**
	 * @param password the password to set
	 */
	public void setTitularLastName(String titularLastName) {
		this.titularLastName = titularLastName;
	}
	
	/**
	 * @return the titularEmail
	 */
	public String getTitularEmail() {
		return titularEmail;
	}

	/**
	 * @param password the titularEmail to set
	 */
	public void setTitularEmail(String titularEmail) {
		this.titularEmail = titularEmail;
	}

}
