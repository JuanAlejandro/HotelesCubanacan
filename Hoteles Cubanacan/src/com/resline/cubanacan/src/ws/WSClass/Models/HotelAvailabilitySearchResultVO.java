package com.resline.cubanacan.src.ws.WSClass.Models;

/**
 * <p>
 * Representa un resultado de busqueda de disponibilidad de hotel
 * </p>
 */
public class HotelAvailabilitySearchResultVO
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 2095813976311154322L;

    public HotelAvailabilitySearchResultVO()
    {
    }

    public HotelAvailabilitySearchResultVO(java.util.List<RoomAvailabilitySearchResultVO> roomAvailabilitySearchResults, String name, String code, HotelCategory category, Long locationId, boolean hasAvailability, boolean allInclusive, boolean hasSpecialOffers, String checkInTime, String checkOutTime)
    {
        this.roomAvailabilitySearchResults = roomAvailabilitySearchResults;
        this.name = name;
        this.code = code;
        this.category = category;
        this.locationId = locationId;
        this.hasAvailability = hasAvailability;
        this.allInclusive = allInclusive;
        this.hasSpecialOffers = hasSpecialOffers;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public HotelAvailabilitySearchResultVO(java.util.List<RoomAvailabilitySearchResultVO> roomAvailabilitySearchResults, String name, Long id, String code, String address, HotelCategory category, String locationName, Long locationId, boolean hasAvailability, boolean allInclusive, boolean hasSpecialOffers, Double minimumPrice, String checkInTime, String checkOutTime, String phone)
    {
        this.roomAvailabilitySearchResults = roomAvailabilitySearchResults;
        this.name = name;
        this.id = id;
        this.code = code;
        this.address = address;
        this.category = category;
        this.locationName = locationName;
        this.locationId = locationId;
        this.hasAvailability = hasAvailability;
        this.allInclusive = allInclusive;
        this.hasSpecialOffers = hasSpecialOffers;
        this.minimumPrice = minimumPrice;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.phone = phone;
    }

    /**
     * Copies constructor from other HotelAvailabilitySearchResultVO
     *
     * @param otherBean, cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public HotelAvailabilitySearchResultVO(HotelAvailabilitySearchResultVO otherBean)
    {
        this(otherBean.getRoomAvailabilitySearchResults(), otherBean.getName(), otherBean.getId(), otherBean.getCode(), otherBean.getAddress(), otherBean.getCategory(), otherBean.getLocationName(), otherBean.getLocationId(), otherBean.isHasAvailability(), otherBean.isAllInclusive(), otherBean.isHasSpecialOffers(), otherBean.getMinimumPrice(), otherBean.getCheckInTime(), otherBean.getCheckOutTime(), otherBean.getPhone());
    }

    /**
     * Copies all properties from the argument value object into this value object.
     */
    public void copy(HotelAvailabilitySearchResultVO otherBean)
    {
        if (otherBean != null)
        {
            this.setRoomAvailabilitySearchResults(otherBean.getRoomAvailabilitySearchResults());
            this.setName(otherBean.getName());
            this.setId(otherBean.getId());
            this.setCode(otherBean.getCode());
            this.setAddress(otherBean.getAddress());
            this.setCategory(otherBean.getCategory());
            this.setLocationName(otherBean.getLocationName());
            this.setLocationId(otherBean.getLocationId());
            this.setHasAvailability(otherBean.isHasAvailability());
            this.setAllInclusive(otherBean.isAllInclusive());
            this.setHasSpecialOffers(otherBean.isHasSpecialOffers());
            this.setMinimumPrice(otherBean.getMinimumPrice());
            this.setCheckInTime(otherBean.getCheckInTime());
            this.setCheckOutTime(otherBean.getCheckOutTime());
            this.setPhone(otherBean.getPhone());
        }
    }

    private java.util.List<RoomAvailabilitySearchResultVO> roomAvailabilitySearchResults;

    /**
     * 
     */
    public java.util.List<RoomAvailabilitySearchResultVO> getRoomAvailabilitySearchResults()
    {
        return this.roomAvailabilitySearchResults;
    }

    public void setRoomAvailabilitySearchResults(java.util.List<RoomAvailabilitySearchResultVO> roomAvailabilitySearchResults)
    {
        this.roomAvailabilitySearchResults = roomAvailabilitySearchResults;
    }

    private String name;

    /**
     * <p>
     * Nombre del hotel
     * </p>
     */
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private Long id;

    /**
     * 
     */
    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    private String code;

    /**
     * <p>
     * C�digo del hotel
     * </p>
     */
    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    private String address;

    /**
     * <p>
     * Direccion del hotel
     * </p>
     */
    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    private HotelCategory category;

    /**
     * <p>
     * Categor�a del hotel
     * </p>
     */
    public HotelCategory getCategory()
    {
        return this.category;
    }

    public void setCategory(HotelCategory category)
    {
        this.category = category;
    }

    private String locationName;

    /**
     * <p>
     * Nombre del destino del hotel
     * </p>
     */
    public String getLocationName()
    {
        return this.locationName;
    }

    public void setLocationName(String locationName)
    {
        this.locationName = locationName;
    }

    private Long locationId;

    /**
     * <p>
     * Identificador del destino
     * </p>
     */
    public Long getLocationId()
    {
        return this.locationId;
    }

    public void setLocationId(Long locationId)
    {
        this.locationId = locationId;
    }

    private boolean hasAvailability;

    /**
     * 
     */
    public boolean isHasAvailability()
    {
        return this.hasAvailability;
    }

    public void setHasAvailability(boolean hasAvailability)
    {
        this.hasAvailability = hasAvailability;
    }

    private boolean allInclusive;

    /**
     * <p>
     * atributo que indica si el hotel es Todo Incluido
     * </p>
     */
    public boolean isAllInclusive()
    {
        return this.allInclusive;
    }

    public void setAllInclusive(boolean allInclusive)
    {
        this.allInclusive = allInclusive;
    }

    private boolean hasSpecialOffers;

    /**
     * 
     */
    public boolean isHasSpecialOffers()
    {
        return this.hasSpecialOffers;
    }

    public void setHasSpecialOffers(boolean hasSpecialOffers)
    {
        this.hasSpecialOffers = hasSpecialOffers;
    }

    private Double minimumPrice;

    /**
     * 
     */
    public Double getMinimumPrice()
    {
        return this.minimumPrice;
    }

    public void setMinimumPrice(Double minimumPrice)
    {
        this.minimumPrice = minimumPrice;
    }

    private String checkInTime;

    /**
     * 
     */
    public String getCheckInTime()
    {
        return this.checkInTime;
    }

    public void setCheckInTime(String checkInTime)
    {
        this.checkInTime = checkInTime;
    }

    private String checkOutTime;

    /**
     * 
     */
    public String getCheckOutTime()
    {
        return this.checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime)
    {
        this.checkOutTime = checkOutTime;
    }

    private String phone;

    /**
     * 
     */
    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}