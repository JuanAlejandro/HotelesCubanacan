package com.resline.cubanacan.src.ws.WSClass.Models;

/**
 * <p>
 * Contiene los detalles de un r�gimen de alojamiento, incluidos
 * los campos internacionalizados
 * </p>
 */
public class MealPlanDetailsVO
    extends MealPlanVO
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 3025508094684817142L;

    public MealPlanDetailsVO()
    {
        super();
    }

    public MealPlanDetailsVO(String description, String code, Integer rank)
    {
        super(code, rank);
        this.description = description;
    }

    public MealPlanDetailsVO(String name, String description, String code, Long id, Integer rank, String localizedName)
    {
        super(code, id, rank, localizedName);
        this.name = name;
        this.description = description;
    }

    /**
     * Copies constructor from other MealPlanDetailsVO
     *
     * @param otherBean, cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public MealPlanDetailsVO(MealPlanDetailsVO otherBean)
    {
        this(otherBean.getName(), otherBean.getDescription(), otherBean.getCode(), otherBean.getId(), otherBean.getRank(), otherBean.getLocalizedName());
    }

    /**
     * Copies all properties from the argument value object into this value object.
     */
    public void copy(MealPlanDetailsVO otherBean)
    {
        if (otherBean != null)
        {
            this.setName(otherBean.getName());
            this.setDescription(otherBean.getDescription());
            this.setCode(otherBean.getCode());
            this.setId(otherBean.getId());
            this.setRank(otherBean.getRank());
            this.setLocalizedName(otherBean.getLocalizedName());
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

    // com.sagit.travels.hotels.vo.MealPlanDetailsVO value-object java merge-point
}