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
public class RoomReservationCellRequest {

	protected RoomReservationRequest roomReservationRequest;
	protected double price;
	protected int currencyId;
	protected String hotelName;
	protected String language;

	public RoomReservationRequest getRoomReservationRequest() {
		return roomReservationRequest;
	}

	public void setRoomReservationRequest(RoomReservationRequest roomReservationRequest) {
		this.roomReservationRequest = roomReservationRequest;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
