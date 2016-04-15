package com.resline.cubanacan.src.ws.WSClass.Models;

/**
 * <p>
 * Representa un tipo de habitacion disponible para una busqueda de
 * hotel
 * </p>
 */
public class AvailableRoomTypeVO
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 7949192951803630367L;

    public AvailableRoomTypeVO()
    {
    }

    public AvailableRoomTypeVO(java.util.List<MealPlanDetailsVO> mealPlans, java.util.List<OptionalAmenityDetailsVO> optionalAmenities, String code, Double price, Integer availability, Long currencyId, String currencyName)
    {
        this.mealPlans = mealPlans;
        this.optionalAmenities = optionalAmenities;
        this.code = code;
        this.price = price;
        this.availability = availability;
        this.currencyId = currencyId;
        this.currencyName = currencyName;
    }

    public AvailableRoomTypeVO(java.util.List<MealPlanDetailsVO> mealPlans, java.util.List<OptionalAmenityDetailsVO> optionalAmenities, Long id, String code, Double price, String name, Integer availability, Long currencyId, String currencyName, java.util.Map optionalAmenitiesPrices, java.util.Map mealPlansPrices)
    {
        this.mealPlans = mealPlans;
        this.optionalAmenities = optionalAmenities;
        this.id = id;
        this.code = code;
        this.price = price;
        this.name = name;
        this.availability = availability;
        this.currencyId = currencyId;
        this.currencyName = currencyName;
        this.optionalAmenitiesPrices = optionalAmenitiesPrices;
        this.mealPlansPrices = mealPlansPrices;
    }

    /**
     * Copies constructor from other AvailableRoomTypeVO
     *
     * @param otherBean, cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public AvailableRoomTypeVO(AvailableRoomTypeVO otherBean)
    {
        this(otherBean.getMealPlans(), otherBean.getOptionalAmenities(), otherBean.getId(), otherBean.getCode(), otherBean.getPrice(), otherBean.getName(), otherBean.getAvailability(), otherBean.getCurrencyId(), otherBean.getCurrencyName(), otherBean.getOptionalAmenitiesPrices(), otherBean.getMealPlansPrices());
    }

    /**
     * Copies all properties from the argument value object into this value object.
     */
    public void copy(AvailableRoomTypeVO otherBean)
    {
        if (otherBean != null)
        {
            this.setMealPlans(otherBean.getMealPlans());
            this.setOptionalAmenities(otherBean.getOptionalAmenities());
            this.setId(otherBean.getId());
            this.setCode(otherBean.getCode());
            this.setPrice(otherBean.getPrice());
            this.setName(otherBean.getName());
            this.setAvailability(otherBean.getAvailability());
            this.setCurrencyId(otherBean.getCurrencyId());
            this.setCurrencyName(otherBean.getCurrencyName());
            this.setOptionalAmenitiesPrices(otherBean.getOptionalAmenitiesPrices());
            this.setMealPlansPrices(otherBean.getMealPlansPrices());
        }
    }

    private java.util.List<MealPlanDetailsVO> mealPlans;

    /**
     * <p>
     * Listado de reg�menes de alojamiento disponibles para el tipo de
     * habitaci�n
     * </p>
     */
    public java.util.List<MealPlanDetailsVO> getMealPlans()
    {
        return this.mealPlans;
    }

    public void setMealPlans(java.util.List<MealPlanDetailsVO> mealPlans)
    {
        this.mealPlans = mealPlans;
    }

    private java.util.List<OptionalAmenityDetailsVO> optionalAmenities;

    /**
     * <p>
     * Listado de servicios opcionales disponibles para el tipo de
     * habitaci�n
     * </p>
     */
    public java.util.List<OptionalAmenityDetailsVO> getOptionalAmenities()
    {
        return this.optionalAmenities;
    }

    public void setOptionalAmenities(java.util.List<OptionalAmenityDetailsVO> optionalAmenities)
    {
        this.optionalAmenities = optionalAmenities;
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
     * C�digo del tipo de habitaci�n
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

    private Double price;

    /**
     * <p>
     * Precio de la habitaci�n
     * </p>
     */
    public Double getPrice()
    {
        return this.price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    private String name;

    /**
     * 
     */
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private Integer availability;

    /**
     * 
     */
    public Integer getAvailability()
    {
        return this.availability;
    }

    public void setAvailability(Integer availability)
    {
        this.availability = availability;
    }

    private Long currencyId;

    /**
     * 
     */
    public Long getCurrencyId()
    {
        return this.currencyId;
    }

    public void setCurrencyId(Long currencyId)
    {
        this.currencyId = currencyId;
    }

    private String currencyName;

    /**
     * 
     */
    public String getCurrencyName()
    {
        return this.currencyName;
    }

    public void setCurrencyName(String currencyName)
    {
        this.currencyName = currencyName;
    }

    private java.util.Map optionalAmenitiesPrices;

    /**
     * <p>
     * contiene para cada id de OptionalAmenity la variacion que debe
     * hacerse al precio de la reserva. el signo del valor indica el
     * sentido de la variacion.
     * </p>
     */
    public java.util.Map getOptionalAmenitiesPrices()
    {
        return this.optionalAmenitiesPrices;
    }

    public void setOptionalAmenitiesPrices(java.util.Map optionalAmenitiesPrices)
    {
        this.optionalAmenitiesPrices = optionalAmenitiesPrices;
    }

    private java.util.Map mealPlansPrices;

    /**
     * <p>
     * el aumento o decremento que implica cada uno de los mealPlans
     * disponibles para esta habitacion
     * </p>
     */
    public java.util.Map getMealPlansPrices()
    {
        return this.mealPlansPrices;
    }

    public void setMealPlansPrices(java.util.Map mealPlansPrices)
    {
        this.mealPlansPrices = mealPlansPrices;
    }

    // com.sagit.travels.booking.vo.AvailableRoomTypeVO value-object java merge-point
}