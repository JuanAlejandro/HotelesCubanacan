package com.resline.cubanacan.src.ws.WSClass.General;

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
 *         &lt;element name=&quot;CountryResult&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}ArrayOfCountry&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;OperationMessage&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class CountryResponse {

	protected ArrayOfCountry countryResult;
	protected String operationMessage;

	/**
	 * Gets the value of the countryResult property.
	 * 
	 * @return possible object is {@link ArrayOfCountry }
	 * 
	 */
	public ArrayOfCountry getCountryResult() {
		return countryResult;
	}

	/**
	 * Sets the value of the countryResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfCountry }
	 * 
	 */
	public void setCountryResult(ArrayOfCountry value) {
		this.countryResult = value;
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
