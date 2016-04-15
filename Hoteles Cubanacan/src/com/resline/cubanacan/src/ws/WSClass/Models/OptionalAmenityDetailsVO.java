package com.resline.cubanacan.src.ws.WSClass.Models;

/**
 * <p>
 * Contiene los detalles de un servicio opcional, incluyendo campos
 * localizados
 * </p>
 */
public class OptionalAmenityDetailsVO
    extends OptionalAmenityVO
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 7581736356513394003L;

    public OptionalAmenityDetailsVO()
    {
        super();
    }

    public OptionalAmenityDetailsVO(String description, String code, java.util.Date startDate, java.util.Date endDate)
    {
        super(code, startDate, endDate);
        this.description = description;
    }

    public OptionalAmenityDetailsVO(String name, String description, Long id, String code, java.util.Date startDate, java.util.Date endDate)
    {
        super(id, code, startDate, endDate);
        this.name = name;
        this.description = description;
    }

    /**
     * Copies constructor from other OptionalAmenityDetailsVO
     *
     * @param otherBean, cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public OptionalAmenityDetailsVO(OptionalAmenityDetailsVO otherBean)
    {
        this(otherBean.getName(), otherBean.getDescription(), otherBean.getId(), otherBean.getCode(), otherBean.getStartDate(), otherBean.getEndDate());
    }

    /**
     * Copies all properties from the argument value object into this value object.
     */
    public void copy(OptionalAmenityDetailsVO otherBean)
    {
        if (otherBean != null)
        {
            this.setName(otherBean.getName());
            this.setDescription(otherBean.getDescription());
            this.setId(otherBean.getId());
            this.setCode(otherBean.getCode());
            this.setStartDate(otherBean.getStartDate());
            this.setEndDate(otherBean.getEndDate());
        }
    }

    private String name;

    /**
     * <p>
     * Nombre localizado
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

    private String description;

    /**
     * <p>
     * Descripci�n localizada
     * </p>
     */
    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    // com.sagit.travels.hotels.vo.OptionalAmenityDetailsVO value-object java merge-point
}