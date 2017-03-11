/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author LAB-USR-AQ265-A0108
 */
public class TipoComunicacion {
    private String Cod_Tipo_Com;
    private String Des_Nombre;

    public TipoComunicacion(String Cod_Tipo_Com, String Des_Nombre) {
        this.Cod_Tipo_Com = Cod_Tipo_Com;
        this.Des_Nombre = Des_Nombre;
    }

    /**
     * @return the Cod_Tipo_Com
     */
    public String getCod_Tipo_Com() {
        return Cod_Tipo_Com;
    }

    /**
     * @param Cod_Tipo_Com the Cod_Tipo_Com to set
     */
    public void setCod_Tipo_Com(String Cod_Tipo_Com) {
        this.Cod_Tipo_Com = Cod_Tipo_Com;
    }

    /**
     * @return the Des_Nombre
     */
    public String getDes_Nombre() {
        return Des_Nombre;
    }

    /**
     * @param Des_Nombre the Des_Nombre to set
     */
    public void setDes_Nombre(String Des_Nombre) {
        this.Des_Nombre = Des_Nombre;
    }
    
}
