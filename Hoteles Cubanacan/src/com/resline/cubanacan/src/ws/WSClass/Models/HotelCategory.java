package com.resline.cubanacan.src.ws.WSClass.Models;

/**
 * <p>
 * Contiene las posibles categor�as de hotel
 * </p>
 */
public enum HotelCategory
    implements java.io.Serializable
{
    HOSTAL, //
    STARS1, //
    STARS2, //
    STARS3, //
    STARS4, //
    STARS5; //


    /**
     * The default constructor allowing
     * super classes to access it.
     */
    private HotelCategory()
    {
    }


    /**
     * Retrieves an instance of HotelCategory from <code>its name</code>.
     *
     * @param name the name to create the HotelCategory from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static HotelCategory fromString(String name)
    {
        return HotelCategory.valueOf(name);
    }

    /**
     * This method is necessary to comply with DaoBase implementation.
     * @return The name of this literal.
     */
    public Object getValue()
    {
        return this.name();
    }
}
