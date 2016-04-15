package com.resline.cubanacan.src.ws.WSClass.Location;

/**
 * <p>
 * Java class for LocationLocalization complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;Location&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;Name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;Description&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;Locale&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class LocationLocalization {

	protected String name;
	protected String description;
	protected String locale;
	
	/**
	 * Gets the value of the name property.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 */
	public void setName(String value) {
		this.name = value;
	}
	
	/**
	 * Gets the value of the description property.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the name property.
	 */
	public void setDescription(String value) {
		this.description = value;
	}
	
	/**
	 * Gets the value of the locale property.
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Sets the value of the locale property.
	 */
	public void setLocale(String value) {
		this.locale = value;
	}
}
