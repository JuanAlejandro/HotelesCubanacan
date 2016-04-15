package com.resline.cubanacan.src.ws.WSClass.Models;

/**
 * <p>
 * Objeto de valores basico para una entidad regimen de
 * alojamiento.
 * </p>
 */
public class MealPlanVO
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -1735177775536386823L;

    public MealPlanVO()
    {
    }

    public MealPlanVO(String code, Integer rank)
    {
        this.code = code;
        this.rank = rank;
    }

    public MealPlanVO(String code, Long id, Integer rank, String localizedName)
    {
        this.code = code;
        this.id = id;
        this.rank = rank;
        this.localizedName = localizedName;
    }

    /**
     * Copies constructor from other MealPlanVO
     *
     * @param otherBean, cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public MealPlanVO(MealPlanVO otherBean)
    {
        this(otherBean.getCode(), otherBean.getId(), otherBean.getRank(), otherBean.getLocalizedName());
    }

    /**
     * Copies all properties from the argument value object into this value object.
     */
    public void copy(MealPlanVO otherBean)
    {
        if (otherBean != null)
        {
            this.setCode(otherBean.getCode());
            this.setId(otherBean.getId());
            this.setRank(otherBean.getRank());
            this.setLocalizedName(otherBean.getLocalizedName());
        }
    }

    private String code;

    /**
     * <p>
     * C�digo del r�gimen de alojamiento
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

    private Integer rank;

    /**
     * <p>
     * Orden del r�gimen de alojamiento
     * </p>
     */
    public Integer getRank()
    {
        return this.rank;
    }

    public void setRank(Integer rank)
    {
        this.rank = rank;
    }

    private String localizedName;

    /**
     * 
     */
    public String getLocalizedName()
    {
        return this.localizedName;
    }

    public void setLocalizedName(String localizedName)
    {
        this.localizedName = localizedName;
    }

    // com.sagit.travels.hotels.vo.MealPlanVO value-object java merge-point
}