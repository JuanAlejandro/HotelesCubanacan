package com.resline.cubanacan.src.ws.WSClass.Hotel;

/**
 * <p>
 * Java class for HotelCategoryEnum.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;HotelCategoryEnum&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;TwoStar&quot;/&gt;
 *     &lt;enumeration value=&quot;ThreeStar&quot;/&gt;
 *     &lt;enumeration value=&quot;FourStar&quot;/&gt;
 *     &lt;enumeration value=&quot;FiveStar&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */

public enum HotelCategoryEnum {

	TWO_STAR("TwoStar"),
	THREE_STAR("ThreeStar"),
	FOUR_STAR("FourStar"),
	FIVE_STAR("FiveStar");
	private final String value;

	HotelCategoryEnum(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static HotelCategoryEnum fromValue(String v) {
		for (HotelCategoryEnum c : HotelCategoryEnum.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}