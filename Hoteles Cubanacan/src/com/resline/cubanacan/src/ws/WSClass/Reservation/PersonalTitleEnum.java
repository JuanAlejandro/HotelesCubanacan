package com.resline.cubanacan.src.ws.WSClass.Reservation;

/**
 * <p>
 * Java class for PersonalTitleEnum.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;PersonalTitleEnum&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;MR&quot;/&gt;
 *     &lt;enumeration value=&quot;MRS&quot;/&gt;
 *     &lt;enumeration value=&quot;MS&quot;/&gt;
 *     &lt;enumeration value=&quot;MSC&quot;/&gt;
 *     &lt;enumeration value=&quot;DR&quot;/&gt;
 *     &lt;enumeration value=&quot;SR&quot;/&gt;
 *     &lt;enumeration value=&quot;PROF&quot;/&gt;
 *     &lt;enumeration value=&quot;DON&quot;/&gt;
 *     &lt;enumeration value=&quot;HONORABLE&quot;/&gt;
 *     &lt;enumeration value=&quot;REV&quot;/&gt;
 *     &lt;enumeration value=&quot;LORD&quot;/&gt;
 *     &lt;enumeration value=&quot;LADY&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
public enum PersonalTitleEnum {

	MR, MRS, MS, MSC, DR, SR, PROF, DON, HONORABLE, REV, LORD, LADY;

	public String value() {
		return name();
	}

	public static PersonalTitleEnum fromValue(String v) {
		return valueOf(v);
	}

}
