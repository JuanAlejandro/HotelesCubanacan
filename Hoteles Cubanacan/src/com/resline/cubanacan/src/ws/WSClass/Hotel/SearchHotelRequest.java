package com.resline.cubanacan.src.ws.WSClass.Hotel;

/**
 * <p>
 * Java class for SearchHotelRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;SearchHotelRequest&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;MaxResults&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot;/&gt;
 *         &lt;element name=&quot;Criteria&quot; type=&quot;{http://www.e-resline.com/}SearchHotelCriteria&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
public class SearchHotelRequest {

	protected int maxResults;
	protected SearchHotelCriteria criteria;

	/**
	 * Gets the value of the maxResults property.
	 * 
	 */
	public int getMaxResults() {
		return maxResults;
	}

	/**
	 * Sets the value of the maxResults property.
	 * 
	 */
	public void setMaxResults(int value) {
		this.maxResults = value;
	}

	/**
	 * Gets the value of the criteria property.
	 * 
	 * @return possible object is {@link SearchHotelCriteria }
	 * 
	 */
	public SearchHotelCriteria getCriteria() {
		return criteria;
	}

	/**
	 * Sets the value of the criteria property.
	 * 
	 * @param value
	 *            allowed object is {@link SearchHotelCriteria }
	 * 
	 */
	public void setCriteria(SearchHotelCriteria value) {
		this.criteria = value;
	}

}
