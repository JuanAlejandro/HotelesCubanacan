package com.resline.cubanacan.src.ws.WSClass.Reservation;

/**
 * <p>
 * Java class for PaymentMethodEnum.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;PaymentMethodEnum&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;BANK_TRANSFER&quot;/&gt;
 *     &lt;enumeration value=&quot;DEPOSIT&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
public enum PaymentMethodEnum {

	BANK_TRANSFER, CREDIT_CAR, PAID_IN_ADVANCE;

	public String value() {
		return name();
	}

	public static PaymentMethodEnum fromValue(String v) {
		return valueOf(v);
	}

}
