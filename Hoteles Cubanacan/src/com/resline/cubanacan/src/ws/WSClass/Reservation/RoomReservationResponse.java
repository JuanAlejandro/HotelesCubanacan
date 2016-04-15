package com.resline.cubanacan.src.ws.WSClass.Reservation;

import java.math.BigDecimal;

/**
 * <p>
 * Java class for RoomReservationResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;RoomReservationResponse&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ReferenceCode&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;Id&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;Price&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;1&quot;/&gt;
 *         &lt;element name=&quot;OperationMessage&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class RoomReservationResponse {

	protected String referenceCode;
	protected Long id;
	protected BigDecimal price;
	protected String operationMessage;

	/**
	 * Gets the value of the referenceCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReferenceCode() {
		return referenceCode;
	}

	/**
	 * Sets the value of the referenceCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReferenceCode(String value) {
		this.referenceCode = value;
	}
	
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
	 * Gets the value of the operationMessage property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOperationMessage() {
		return operationMessage;
	}

	/**
	 * Sets the value of the operationMessage property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOperationMessage(String value) {
		this.operationMessage = value;
	}

	
	/**
	 * Gets the value of the price property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Sets the value of the price property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
