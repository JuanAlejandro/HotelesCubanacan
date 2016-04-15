package com.resline.cubanacan.src.ws.WSClass.Hotel;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;HotelsDetailsResult&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}ArrayOfHotelDetails&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;OperationMessage&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

public class HotelsFullDetailsResponse {

	protected ArrayOfHotelFullDetails hotelsFullDetailsResult;
	protected String operationMessage;

	/**
	 * Gets the value of the hotelsDetailsResult property.
	 * 
	 * @return possible object is {@link ArrayOfHotelsDetails }
	 * 
	 */
	public ArrayOfHotelFullDetails getHotelsFullDetailsResult() {
		return hotelsFullDetailsResult;
	}

	/**
	 * Sets the value of the hotelsDetailsResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfHotelsDetails }
	 * 
	 */
	public void setHotelsFullDetailsResult(ArrayOfHotelFullDetails value) {
		this.hotelsFullDetailsResult = value;
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

}
