package com.resline.cubanacan.src.ws.WSClass.Models;

/**
 * <p>
 * Representa un resultado de busqueda de disponibilidad de
 * habitaciones dentro de un hotel
 * </p>
 */
public class RoomAvailabilitySearchResultVO
    extends RoomAvailabilitySearchCriteria
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -8234094680715200378L;

    public RoomAvailabilitySearchResultVO()
    {
        super();
    }

    public RoomAvailabilitySearchResultVO(java.util.List<AvailableRoomTypeVO> availableRoomTypes, Integer adultOccupancy, Integer[] childrenAges, Integer childOccupancy)
    {
        super(adultOccupancy, childrenAges, childOccupancy);
        this.availableRoomTypes = availableRoomTypes;
    }

    public RoomAvailabilitySearchResultVO(java.util.List<AvailableRoomTypeVO> availableRoomTypes, Integer adultOccupancy, Integer[] childrenAges, Integer childOccupancy, int quantity)
    {
        super(adultOccupancy, childrenAges, childOccupancy, quantity);
        this.availableRoomTypes = availableRoomTypes;
    }

    /**
     * Copies constructor from other RoomAvailabilitySearchResultVO
     *
     * @param otherBean, cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public RoomAvailabilitySearchResultVO(RoomAvailabilitySearchResultVO otherBean)
    {
        this(otherBean.getAvailableRoomTypes(), otherBean.getAdultOccupancy(), otherBean.getChildrenAges(), otherBean.getChildOccupancy(), otherBean.getQuantity());
    }

    /**
     * Copies all properties from the argument value object into this value object.
     */
    public void copy(RoomAvailabilitySearchResultVO otherBean)
    {
        if (otherBean != null)
        {
            this.setAvailableRoomTypes(otherBean.getAvailableRoomTypes());
            this.setAdultOccupancy(otherBean.getAdultOccupancy());
            this.setChildrenAges(otherBean.getChildrenAges());
            this.setChildOccupancy(otherBean.getChildOccupancy());
            this.setQuantity(otherBean.getQuantity());
        }
    }

    private java.util.List<AvailableRoomTypeVO> availableRoomTypes;

    /**
     * <p>
     * Lista de tipos de habitaciones disponibles
     * </p>
     */
    public java.util.List<AvailableRoomTypeVO> getAvailableRoomTypes()
    {
        return this.availableRoomTypes;
    }

    public void setAvailableRoomTypes(java.util.List<AvailableRoomTypeVO> availableRoomTypes)
    {
        this.availableRoomTypes = availableRoomTypes;
    }
}