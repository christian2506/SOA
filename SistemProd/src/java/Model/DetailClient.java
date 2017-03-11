package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DetailClient {
    private String Cod_Cliente;
    private String Nom_Cliente;
    private String Negociacion;
    private String Interes;
    private String Contacto;
    private String Rubro;
    private String Fecha_Reg;

    public DetailClient(String Cod_Cliente, String Nom_Cliente, String Negociacion, String Interes, String Contacto, String Rubro, String Fecha_Reg) {
        this.Cod_Cliente = Cod_Cliente;
        this.Nom_Cliente = Nom_Cliente;
        this.Negociacion = Negociacion;
        this.Interes = Interes;
        this.Contacto = Contacto;
        this.Rubro = Rubro;
        this.Fecha_Reg = Fecha_Reg;
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
     * @return the Nom_Cliente
     */
    public String getNom_Cliente() {
        return Nom_Cliente;
    }

    /**
     * @param Nom_Cliente the Nom_Cliente to set
     */
    public void setNom_Cliente(String Nom_Cliente) {
        this.Nom_Cliente = Nom_Cliente;
    }

    /**
     * @return the Negociacion
     */
    public String getNegociacion() {
        return Negociacion;
    }

    /**
     * @param Negociacion the Negociacion to set
     */
    public void setNegociacion(String Negociacion) {
        this.Negociacion = Negociacion;
    }

    /**
     * @return the Interes
     */
    public String getInteres() {
        return Interes;
    }

    /**
     * @param Interes the Interes to set
     */
    public void setInteres(String Interes) {
        this.Interes = Interes;
    }

    /**
     * @return the Contacto
     */
    public String getContacto() {
        return Contacto;
    }

    /**
     * @param Contacto the Contacto to set
     */
    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    /**
     * @return the Rubro
     */
    public String getRubro() {
        return Rubro;
    }

    /**
     * @param Rubro the Rubro to set
     */
    public void setRubro(String Rubro) {
        this.Rubro = Rubro;
    }

    /**
     * @return the Fecha_Reg
     */
    public String getFecha_Reg() {
        return Fecha_Reg;
    }

    /**
     * @param Fecha_Reg the Fecha_Reg to set
     */
    public void setFecha_Reg(String Fecha_Reg) {
        this.Fecha_Reg = Fecha_Reg;
    }

   
    
    
    
}