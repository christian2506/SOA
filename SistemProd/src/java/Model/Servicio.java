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
public class Servicio {
    private String Cod_Servicio;
    private String Des_Nombre;

    public Servicio(String Cod_Servicio, String Des_Nombre) {
        this.Cod_Servicio = Cod_Servicio;
        this.Des_Nombre = Des_Nombre;
    }

    /**
     * @return the Cod_Servicio
     */
    public String getCod_Servicio() {
        return Cod_Servicio;
    }

    /**
     * @param Cod_Servicio the Cod_Servicio to set
     */
    public void setCod_Servicio(String Cod_Servicio) {
        this.Cod_Servicio = Cod_Servicio;
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
