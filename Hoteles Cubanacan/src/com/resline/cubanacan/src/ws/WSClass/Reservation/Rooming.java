package com.resline.cubanacan.src.ws.WSClass.Reservation;

/**
 * <p>
 * Java class for Rooming complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;Rooming&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;Requirements&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;Smoking&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}boolean&quot;/&gt;
 *         &lt;element name=&quot;Principal&quot; type=&quot;{http://www.e-resline.com/}Principal&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class Rooming {

	protected String requirements;
	protected boolean smoking;
	protected Principal principal;

	/**
	 * Gets the value of the requirements property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRequirements() {
		return requirements;
	}

	/**
	 * Sets the value of the requirements property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRequirements(String value) {
		this.requirements = value;
	}

	/**
	 * Gets the value of the smoking property.
	 * 
	 */
	public boolean isSmoking() {
		return smoking;
	}

	/**
	 * Sets the value of the smoking property.
	 * 
	 */
	public void setSmoking(boolean value) {
		this.smoking = value;
	}

	/**
	 * Gets the value of the principal property.
	 * 
	 * @return possible object is {@link Principal }
	 * 
	 */
	public Principal getPrincipal() {
		return principal;
	}

	/**
	 * Sets the value of the principal property.
	 * 
	 * @param value
	 *            allowed object is {@link Principal }
	 * 
	 */
	public void setPrincipal(Principal value) {
		this.principal = value;
	}

}
