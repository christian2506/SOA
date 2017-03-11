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
public class Cliente {
    private String Cod_Cliente;
    private String Des_Nombre;
    private String Cod_Rubro;
    private String Telefono;
    private String Correo;

    public Cliente(String Cod_Cliente, String Des_Nombre, String Cod_Rubro, String Telefono, String Correo) {
        this.Cod_Cliente = Cod_Cliente;
        this.Des_Nombre = Des_Nombre;
        this.Cod_Rubro = Cod_Rubro;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }

    /**
     * @return the Cod_Cliente
     */
    public String getCod_Cliente() {
        return Cod_Cliente;
    }

    /**
     * @param Cod_Cliente the Cod_Cliente to set
     */
    public void setCod_Cliente(String Cod_Cliente) {
        this.Cod_Cliente = Cod_Cliente;
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
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
}
