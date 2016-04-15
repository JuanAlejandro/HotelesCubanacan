package com.resline.cubanacan.src.ws.WSClass.Models;

/**
 * <p>
 * Criterios de busqueda para una disponibilidad determinada
 * </p>
 */
public class RoomAvailabilitySearchCriteria
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 4751732490458339246L;

    public RoomAvailabilitySearchCriteria()
    {
    }

    public RoomAvailabilitySearchCriteria(Integer adultOccupancy, Integer[] childrenAges, Integer childOccupancy)
    {
        this.adultOccupancy = adultOccupancy;
        this.childrenAges = childrenAges;
        this.childOccupancy = childOccupancy;
    }

    public RoomAvailabilitySearchCriteria(Integer adultOccupancy, Integer[] childrenAges, Integer childOccupancy, int quantity)
    {
        this.adultOccupancy = adultOccupancy;
        this.childrenAges = childrenAges;
        this.childOccupancy = childOccupancy;
        this.quantity = quantity;
    }

    /**
     * Copies constructor from other RoomAvailabilitySearchCriteria
     *
     * @param otherBean, cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public RoomAvailabilitySearchCriteria(RoomAvailabilitySearchCriteria otherBean)
    {
        this(otherBean.getAdultOccupancy(), otherBean.getChildrenAges(), otherBean.getChildOccupancy(), otherBean.getQuantity());
    }

    /**
     * Copies all properties from the argument value object into this value object.
     */
    public void copy(RoomAvailabilitySearchCriteria otherBean)
    {
        if (otherBean != null)
        {
            this.setAdultOccupancy(otherBean.getAdultOccupancy());
            this.setChildrenAges(otherBean.getChildrenAges());
            this.setChildOccupancy(otherBean.getChildOccupancy());
            this.setQuantity(otherBean.getQuantity());
        }
    }

    private Integer adultOccupancy;

    /**
     * <p>
     * N�mero de adultos en la habitaci�n
     * </p>
     */
    public Integer getAdultOccupancy()
    {
        return this.adultOccupancy;
    }

    public void setAdultOccupancy(Integer adultOccupancy)
    {
        this.adultOccupancy = adultOccupancy;
    }

    private Integer[] childrenAges;

    /**
     * <p>
     * Arreglo de edades para los ni�os
     * </p>
     */
    public Integer[] getChildrenAges()
    {
        return this.childrenAges;
    }

    public void setChildrenAges(Integer[] childrenAges)
    {
        this.childrenAges = childrenAges;
    }

    private Integer childOccupancy;

    /**
     * <p>
     * N�mero de ni�os en la habitaci�n
     * </p>
     */
    public Integer getChildOccupancy()
    {
        return this.childOccupancy;
    }

    public void setChildOccupancy(Integer childOccupancy)
    {
        this.childOccupancy = childOccupancy;
    }

    private int quantity;

    /**
     * <p>
     * se utiliza en la busqueda de hoteles para indicar cantidad de
     * habitaciones deseadas segun el criterio de busqueda y compararlo
     * con la disponibilidad existente
     * </p>
     */
    public int getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    // com.sagit.travels.booking.vo.RoomAvailabilitySearchCriteria value-object java merge-point
}