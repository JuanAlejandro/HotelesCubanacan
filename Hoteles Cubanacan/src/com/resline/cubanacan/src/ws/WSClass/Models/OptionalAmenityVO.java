package com.resline.cubanacan.src.ws.WSClass.Models;

/**
 * <p>
 * Objeto de valores b�sico para una entidad Servicio opcional.
 * </p>
 */
public class OptionalAmenityVO
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 4203794635888342450L;

    public OptionalAmenityVO()
    {
    }

    public OptionalAmenityVO(String code, java.util.Date startDate, java.util.Date endDate)
    {
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public OptionalAmenityVO(Long id, String code, java.util.Date startDate, java.util.Date endDate)
    {
        this.id = id;
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Copies constructor from other OptionalAmenityVO
     *
     * @param otherBean, cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public OptionalAmenityVO(OptionalAmenityVO otherBean)
    {
        this(otherBean.getId(), otherBean.getCode(), otherBean.getStartDate(), otherBean.getEndDate());
    }

    /**
     * Copies all properties from the argument value object into this value object.
     */
    public void copy(OptionalAmenityVO otherBean)
    {
        if (otherBean != null)
        {
            this.setId(otherBean.getId());
            this.setCode(otherBean.getCode());
            this.setStartDate(otherBean.getStartDate());
            this.setEndDate(otherBean.getEndDate());
        }
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
     * C�digo del servicio opcional
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

    private java.util.Date startDate;

    /**
     * <p>
     * Fecha en la que se inicia el servicio opcional
     * </p>
     */
    public java.util.Date getStartDate()
    {
        return this.startDate;
    }

    public void setStartDate(java.util.Date startDate)
    {
        this.startDate = startDate;
    }

    private java.util.Date endDate;

    /**
     * <p>
     * Fecha en la termina el Servicio opcional
     * </p>
     */
    public java.util.Date getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(java.util.Date endDate)
    {
        this.endDate = endDate;
    }

    // com.sagit.travels.hotels.vo.OptionalAmenityVO value-object java merge-point
}