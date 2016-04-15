package com.resline.cubanacan.src.ws.WSClass.Tpv;

public class TPVPostData {
    /*
     * Obligatorio. Para Euros las dos últimas posiciones
     * se consideran decimales.
     */
    protected String Ds_Merchant_Amount;

    protected String Ds_Merchant_Currency;

    /*
     * Obligatorio. Los 4 primeros dígitos deben ser
     * numéricos, para los dígitos restantes solo utilizar
     * los siguientes caracteres ASCII
     * Del 30 = 0 al 39 = 9
     * Del 65 = A al 90 = Z
     * Del 97 = a al 122 = z
     */
    protected String Ds_Merchant_Order;

    /*
     * Opcional. 125 se considera su longitud máxima.
     * Este campo se mostrará al titular en la pantalla
     * de confirmación de la compra.
     */
    protected String Ds_Merchant_ProductDescription;

    /*
     * Obligatorio si el comercio tiene notificación “online”. URL del comercio que recibirá un post con
     * los datos de la transacción.
     */
    protected String Ds_Merchant_UrlConfirm;

    /*
     * Opcional: si se envía será utilizado como URLOK
     * ignorando el configurado en el módulo de
     * administración en caso de tenerlo.
     */
    protected String Ds_Merchant_UrlOK;

    /*
     * Opcional: si se envía será utilizado como URLKO
     * ignorando el configurado en el módulo de
     * administración en caso de tenerlo
     */
    protected String Ds_Merchant_UrlKO;

    public String getDs_Merchant_Titular() {
        return Ds_Merchant_Titular;
    }

    public void setDs_Merchant_Titular(String ds_Merchant_Titular) {
        Ds_Merchant_Titular = ds_Merchant_Titular;
    }

    public String getDs_Merchant_Amount() {
        return Ds_Merchant_Amount;
    }

    public void setDs_Merchant_Amount(String ds_Merchant_Amount) {
        Ds_Merchant_Amount = ds_Merchant_Amount;
    }

    public String getDs_Merchant_Currency() {
        return Ds_Merchant_Currency;
    }

    public void setDs_Merchant_Currency(String ds_Merchant_Currency) {
        Ds_Merchant_Currency = ds_Merchant_Currency;
    }

    public String getDs_Merchant_Order() {
        return Ds_Merchant_Order;
    }

    public void setDs_Merchant_Order(String ds_Merchant_Order) {
        Ds_Merchant_Order = ds_Merchant_Order;
    }

    public String getDs_Merchant_ProductDescription() {
        return Ds_Merchant_ProductDescription;
    }

    public void setDs_Merchant_ProductDescription(String ds_Merchant_ProductDescription) {
        Ds_Merchant_ProductDescription = ds_Merchant_ProductDescription;
    }

    public String getDs_Merchant_UrlConfirm() {
        return Ds_Merchant_UrlConfirm;
    }

    public void setDs_Merchant_UrlConfirm(String ds_Merchant_UrlConfirm) {
        Ds_Merchant_UrlConfirm = ds_Merchant_UrlConfirm;
    }

    public String getDs_Merchant_UrlOK() {
        return Ds_Merchant_UrlOK;
    }

    public void setDs_Merchant_UrlOK(String ds_Merchant_UrlOK) {
        Ds_Merchant_UrlOK = ds_Merchant_UrlOK;
    }

    public String getDs_Merchant_UrlKO() {
        return Ds_Merchant_UrlKO;
    }

    public void setDs_Merchant_UrlKO(String ds_Merchant_UrlKO) {
        Ds_Merchant_UrlKO = ds_Merchant_UrlKO;
    }

    public String getDs_Merchant_MerchantName() {
        return Ds_Merchant_MerchantName;
    }

    public void setDs_Merchant_MerchantName(String ds_Merchant_MerchantName) {
        Ds_Merchant_MerchantName = ds_Merchant_MerchantName;
    }

    public String getDs_ClientSignature() {
        return Ds_ClientSignature;
    }

    public void setDs_ClientSignature(String ds_ClientSignature) {
        Ds_ClientSignature = ds_ClientSignature;
    }

    public String getDs_Merchant_MerchantSignature() {
        return Ds_Merchant_MerchantSignature;
    }

    public void setDs_Merchant_MerchantSignature(String ds_Merchant_MerchantSignature) {
        Ds_Merchant_MerchantSignature = ds_Merchant_MerchantSignature;
    }

    /*
         * Será el nombre del comercio que aparecerá en el

         * ticket del cliente (opcional).
         */
    protected String Ds_Merchant_MerchantName;

    protected String Ds_ClientSignature;

    protected String Ds_Merchant_MerchantSignature;

    /*
     * Su longitud máxima es de 60 caracteres.
     * Este campo se mostrará al titular en la pantalla de confirmación de la compra.
     */
    protected String Ds_Merchant_Titular;
}