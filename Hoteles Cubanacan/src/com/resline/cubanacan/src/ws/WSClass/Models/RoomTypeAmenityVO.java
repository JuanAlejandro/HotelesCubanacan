package com.resline.cubanacan.src.ws.WSClass.Models;

/**
 * 
 */
public class RoomTypeAmenityVO
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 5715146594914835965L;

    public RoomTypeAmenityVO()
    {
    }

    public RoomTypeAmenityVO(String code)
    {
        this.code = code;
    }

    public RoomTypeAmenityVO(Long id, String code)
    {
        this.id = id;
        this.code = code;
    }

    /**
     * Copies constructor from other RoomTypeAmenityVO
     *
     * @param otherBean, cannot be <code>null</code>
     * @throws NullPointerException if the argument is <code>null</code>
     */
    public RoomTypeAmenityVO(RoomTypeAmenityVO otherBean)
    {
        this(otherBean.getId(), otherBean.getCode());
    }

    /**
     * Copies all properties from the argument value object into this value object.
     */
    public void copy(RoomTypeAmenityVO otherBean)
    {
        if (otherBean != null)
        {
            this.setId(otherBean.getId());
            this.setCode(otherBean.getCode());
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
     * 
     */
    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
}