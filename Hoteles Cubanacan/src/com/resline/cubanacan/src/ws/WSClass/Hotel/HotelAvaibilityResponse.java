package com.resline.cubanacan.src.ws.WSClass.Hotel;

import com.resline.cubanacan.src.ws.WSClass.Image.ArrayOfImage;
import com.resline.cubanacan.src.ws.WSClass.Models.HotelAvailabilitySearchResultVO;
import com.resline.cubanacan.src.ws.WSClass.Models.IdValueVO;
import com.resline.cubanacan.src.ws.WSClass.Models.RoomTypeAmenityVO;

import java.util.List;
import java.util.Map;

public class HotelAvaibilityResponse {
	
	private String operationMessage;

	/**
	 * Nombre de la moneda correspondiente al contrato activo en el periodo
	 * de fechas en el que se hace la busqueda
	 */
	private String currencyName;
	
	private List<HotelAvailabilitySearchResultVO> hotelsAvaibility;
	
	private Map<Long, List<IdValueVO>> hotelAmenitiesPerHotel;
	
	private Map<Long, List<RoomTypeAmenityVO>> roomTypesAmenities;
	
	private Map<Long,ArrayOfImage> hotelImage;
	
	
	public Map<Long, ArrayOfImage> getHotelImage() {
		return hotelImage;
	}

	public void setHotelImage(Map<Long, ArrayOfImage> hotelImage) {
		this.hotelImage = hotelImage;
	}

	public Map<Long, List<RoomTypeAmenityVO>> getRoomTypesAmenities() {
		return roomTypesAmenities;
	}
	
	public void setRoomTypesAmenities(Map<Long, List<RoomTypeAmenityVO>> roomTypesAmenities) {
		this.roomTypesAmenities = roomTypesAmenities;
	}
	
	public Map<Long, List<IdValueVO>> getHotelAmenitiesPerHotel() {
		return hotelAmenitiesPerHotel;
	}
	public void setHotelAmenitiesPerHotel(Map<Long, List<IdValueVO>> hotelAmenitiesPerHotel) {
		this.hotelAmenitiesPerHotel = hotelAmenitiesPerHotel;
	}

	public String getOperationMessage() {
		return operationMessage;
	}
	public void setOperationMessage(String operationMessage) {
		this.operationMessage = operationMessage;
	}
	public List<HotelAvailabilitySearchResultVO> getHotelsAvaibility() {
		return hotelsAvaibility;
	}
	public void setHotelsAvaibility(List<HotelAvailabilitySearchResultVO> hotelsAvaibility) {
		this.hotelsAvaibility = hotelsAvaibility;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	
}
