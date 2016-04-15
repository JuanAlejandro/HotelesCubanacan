package com.resline.cubanacan.src.ws.WSClass.Models;

/**
 * <p>
 * Objeto de valores para representar entidades por su
 * identificador y un valor de tipo cadena
 * </p>
 */
public class IdValueVO
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 3047577459277236650L;

    public IdValueVO()
    {
    }

    public IdValueVO(String value, Long id)
    {
        this.value = value;
        this.id = id;
    }

    /**
     * Copies constructor from other IdValueVO
     *
     * @param otherBean, cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public IdValueVO(IdValueVO otherBean)
    {
        this(otherBean.getValue(), otherBean.getId());
    }

    /**
     * Copies all properties from the argument value object into this value object.
     */
    public void copy(IdValueVO otherBean)
    {
        if (otherBean != null)
        {
            this.setValue(otherBean.getValue());
            this.setId(otherBean.getId());
        }
    }

    private String value;

    /**
     * <p>
     * Campo valor
     * </p>
     */
    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    private Long id;

    /**
     * <p>
     * Campo identificador
     * </p>
     */
    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    // com.sagit.travels.global.vo.IdValueVO value-object java merge-point
}