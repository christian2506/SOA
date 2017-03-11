/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author segovia
 */
public class Rubro {
    private String Cod_Rubro;
    private String Des_Nombre;

    public Rubro(String Cod_Rubro, String Des_Nombre) {
        this.Cod_Rubro = Cod_Rubro;
        this.Des_Nombre = Des_Nombre;
    }

    /**
     * @return the Cod_Rubro
     */
    public String getCod_Rubro() {
        return Cod_Rubro;
    }

    /**
     * @param Cod_Rubro the Cod_Rubro to set
     */
    public void setCod_Rubro(String Cod_Rubro) {
        this.Cod_Rubro = Cod_Rubro;
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
