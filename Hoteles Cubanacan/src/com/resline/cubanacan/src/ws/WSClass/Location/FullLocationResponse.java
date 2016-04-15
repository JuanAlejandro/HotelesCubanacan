package com.resline.cubanacan.src.ws.WSClass.Location;

/**
 * <p>
 * Java class for FullLocationResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;FullLocationResponse&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;Locations&quot; type=&quot;{http://www.e-resline.com/}ArrayOfLocation&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;OperationMessage&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class FullLocationResponse {

	protected ArrayOfFullLocation fullLocations;
	protected String operationMessage;

	/**
	 * Gets the value of the locations property.
	 * 
	 * @return possible object is {@link ArrayOfLocation }
	 * 
	 */
	public ArrayOfFullLocation getFullLocations() {
		return fullLocations;
	}

	/**
	 * Sets the value of the locations property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfLocation }
	 * 
	 */
	public void setFullLocations(ArrayOfFullLocation value) {
		this.fullLocations = value;
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
