/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author segovia
 */
public class Activities {
    ResultSet rs;
    Statement st; 
    PreparedStatement pr;
    CallableStatement cst;
    Conexion cn = new Conexion();
    Connection conn = cn.getConexion();
    
    public Vector<DetailClient> listDetailClient(String codEmpl){
        Vector<DetailClient> vecDet = new Vector<DetailClient>();
        String sql = "SELECT cl.Cod_Cliente		,\n" +
                     "	     cl.Des_Nombre 		AS Nom_Cliente,\n" +
                     "	     se.Des_Nombre 		AS Negocicacion,\n" +
                     "	     de.Nivel_Interes		AS Interes,\n" +
                     "	     ti.Des_Nombre		AS Contacto,\n" +
                     "	     ru.Des_Nombre		AS Nom_Rubro,\n" +
                     "	     date_format(ac.Fecha_Registro, '%d/%m/%Y') AS Fecha_Reg\n" +
                     "  FROM Cliente cl\n" +
                     " INNER JOIN Actividad ac		ON cl.Cod_Cliente   = ac.Cod_Cliente\n" +
                     " INNER JOIN Empleado em		ON ac.Cod_Empleado  = em.Cod_Empleado\n" +
                     " INNER JOIN Detalle_Actividad de	ON de.Cod_Actividad = ac.Cod_Actividad\n" +
                     " INNER JOIN Servicio se		ON de.Cod_Servicio  = se.Cod_Servicio\n" +
                     " INNER JOIN Tipo_Comunicacion ti	ON de.Cod_Tipo_Com  = ti.Cod_Tipo_Com\n" +
                     " INNER JOIN Rubro ru		ON cl.Cod_rubro     = ru.Cod_Rubro\n" +
                     " WHERE ac.Fecha_Registro = de.Fecha_Actividad\n" +
                     "   AND em.Cod_Empleado = ?";
        try {
            pr = conn.prepareStatement(sql);
            pr.setString(1, codEmpl);
            rs = pr.executeQuery();
            
            while(rs.next()){
                DetailClient detCl = new DetailClient(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                detCl.setCod_Cliente(rs.getString(1));
                detCl.setNom_Cliente(rs.getString(2));
                detCl.setNegociacion(rs.getString(3));
                detCl.setInteres(rs.getString(4));
                detCl.setContacto(rs.getString(5));
                detCl.setRubro(rs.getString(6));
                detCl.setFecha_Reg(rs.getString(7));
                vecDet.add(detCl);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try{
                rs.close();
                pr.close();
                conn.close();
            }catch(Exception ex){
            }
        }
        return vecDet;
    }
    
    public String validarDatos(String user, String pass){
        String codEmpl = "";
        String sql = "SELECT em.Cod_Empleado\n" +
                     "  FROM Usuario us\n" +
                     " INNER JOIN Empleado em ON em.Cod_Usuario = us.Cod_Usuario\n" +
                     " WHERE us.Nom_Usuario  = ?\n" +
                     "   AND us.Pass_Usuario = ?";  
        try {
            pr = conn.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, pass);
            rs = pr.executeQuery();
            while(rs.next()){
                codEmpl = rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();  
        }
        return codEmpl;
    }
    
    public Vector<DetailClient> listDetailActivity(String codCl){
        Vector<DetailClient> vecDet = new Vector<DetailClient>();
        String sql = "SELECT se.Des_Nombre 		AS Negociacion,\n" +
                     "	     de.Nivel_Interes		AS Interes,\n" +
                     "	     ti.Des_Nombre		AS Contacto,\n" +
                     "       date_format(de.Fecha_Actividad, '%d/%m/%Y') AS Fecha_Act\n" +
                     "  FROM Servicio se\n" +
                     " INNER JOIN Detalle_Actividad de 	ON de.Cod_Servicio  = se.Cod_Servicio\n" +
                     " INNER JOIN Tipo_Comunicacion ti 	ON de.Cod_Tipo_Com  = ti.Cod_Tipo_Com\n" +
                     " INNER JOIN Actividad ac		ON de.Cod_Actividad = ac.Cod_Actividad\n" +
                     " INNER JOIN Cliente cl		ON ac.Cod_Cliente   = cl.Cod_Cliente\n" +
                     " WHERE ac.Fecha_Registro <> de.Fecha_Actividad\n" +
                     "   AND cl.Cod_Cliente = ?";
        try {
            pr = conn.prepareStatement(sql);
            pr.setString(1, codCl);
            rs = pr.executeQuery();
            
            while(rs.next()){
                DetailClient detCl = new DetailClient("","", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), "");
                detCl.setNegociacion(rs.getString(1));
                detCl.setInteres(rs.getString(2));
                detCl.setContacto(rs.getString(3));
                detCl.setFecha_Reg(rs.getString(4));
                vecDet.add(detCl);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try{
                rs.close();
                pr.close();
                conn.close();
            }catch(Exception ex){

            }
        }
        return vecDet;
    }
    
    public Vector<Servicio> listServices(){
        Vector<Servicio> vecDet = new Vector<Servicio>();
        String sql = "SELECT * FROM Servicio";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Servicio ser = new Servicio(rs.getString("Cod_Servicio"), rs.getString("Des_Nombre"));
                ser.setCod_Servicio(rs.getString("Cod_Servicio"));
                ser.setDes_Nombre(rs.getString("Des_Nombre"));
                vecDet.add(ser);
            }
        } catch (Exception ex) {
             ex.printStackTrace();
        }finally{
            try{
                rs.close();
                pr.close();
                conn.close();
            }catch(Exception ex){

            }
        }
        return vecDet;
    }
    
    public Vector<TipoComunicacion> listComunications(){
        Vector<TipoComunicacion> vecDet = new Vector<TipoComunicacion>();
        String sql = "SELECT * FROM Tipo_Comunicacion";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                TipoComunicacion tipC = new TipoComunicacion(rs.getString("Cod_Tipo_Com"), rs.getString("Des_Nombre"));
                tipC.setCod_Tipo_Com(rs.getString("Cod_Tipo_Com"));
                tipC.setDes_Nombre(rs.getString("Des_Nombre"));
                vecDet.add(tipC);
            }
        } catch (Exception ex) {
             ex.printStackTrace();
        }finally{
            try{
                rs.close();
                pr.close();
                conn.close();
            }catch(Exception ex){

            }
        }
        return vecDet;
    }
    
    public Vector<Rubro> listRubro(){
        Vector<Rubro> vecDet = new Vector<Rubro>();
        String sql = "SELECT * FROM Rubro";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Rubro rub = new Rubro(rs.getString("Cod_Rubro"), rs.getString("Des_Nombre"));
                rub.setCod_Rubro(rs.getString("Cod_Rubro"));
                rub.setDes_Nombre(rs.getString("Des_Nombre"));
                vecDet.add(rub);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try{
                rs.close();
                pr.close();
                conn.close();
            }catch(Exception ex){

            }
        }
        return vecDet;
    }
    
    public Vector<Cliente> listCliente(){
        Vector<Cliente> vecDet = new Vector<Cliente>();
        String sql = "SELECT * FROM Cliente";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Cliente cli = new Cliente(rs.getString("Cod_Cliente"), rs.getString("Des_Nombre"), rs.getString("Cod_Rubro"), rs.getString("Telefono"), rs.getString("Correo"));
                cli.setCod_Cliente(rs.getString("Cod_Cliente"));
                cli.setDes_Nombre(rs.getString("Des_Nombre"));
                cli.setCod_Rubro(rs.getString("Cod_Rubro"));
                cli.setTelefono(rs.getString("Telefono"));
                cli.setCorreo(rs.getString("Correo"));
                vecDet.add(cli);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try{
                rs.close();
                pr.close();
                conn.close();
            }catch(Exception ex){

            }
        }
        return vecDet;
    }
    
    public String nomEmplForCod(String codEmpl){
        String nomEmpl = "";
        String sql = "SELECT Des_Nombre, \n" +
                     "	     Des_Apellido_Pat, \n" +
                     "       Des_Apellido_Mat\n" +
                     "  FROM Empleado\n" +
                     " WHERE Cod_Empleado = ?";
        try {
            pr = conn.prepareStatement(sql);
            pr.setString(1, codEmpl);
            rs = pr.executeQuery();
            while(rs.next()){
                nomEmpl = rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nomEmpl;
    }
    
    public int listGraphicsEmploye(String codEmpl, String anio, int mes){
        int i = 0;
        int count = 0;
        String sql = "SELECT COUNT(cl.Des_Nombre)\n" +
                     "  FROM Empleado em\n" +
                     "  INNER JOIN Actividad ac ON em.Cod_Empleado = ac.Cod_Empleado\n" +
                     "  INNER JOIN Cliente   cl ON ac.Cod_Cliente  = cl.Cod_Cliente\n" +
                     "  WHERE em.Cod_Empleado          = ?\n" +
                     "    AND YEAR(ac.Fecha_Registro)  = ?\n" +
                     "    AND MONTH(ac.Fecha_Registro) = ?";
        try {
            pr = conn.prepareStatement(sql);
            pr.setString(1, codEmpl);
            pr.setString(2, anio);
            pr.setInt(3, mes);
            rs = pr.executeQuery();
            while(rs.next()){
                count = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }
    
    public String[][] listGraphicsAll(String anio){
        String[][] mat = null;
        int i = 0;
        int countF = 0;
        String sql1 = "SELECT COUNT(DISTINCT em.Des_Nombre) \n" +
                      "  FROM Empleado em\n" +
                      " INNER JOIN Actividad ac ON em.Cod_Empleado = ac.Cod_Empleado\n" +
                      " INNER JOIN Cliente   cl ON ac.Cod_Cliente  = cl.Cod_Cliente\n" +
                      " WHERE YEAR(ac.Fecha_Registro) = ?";
        
        String sql2 = "SELECT em.Des_Nombre, \n" +
                      "	      COUNT(cl.Des_Nombre)\n" +
                      "  FROM Empleado em\n" +
                      " INNER JOIN Actividad ac ON em.Cod_Empleado = ac.Cod_Empleado\n" +
                      " INNER JOIN Cliente   cl ON ac.Cod_Cliente  = cl.Cod_Cliente\n" +
                      " WHERE YEAR(ac.Fecha_Registro) = ?\n" +
                      " GROUP BY em.Des_Nombre";
        try {
            pr = conn.prepareStatement(sql1);
            pr.setString(1, anio);
            rs = pr.executeQuery();
            while(rs.next()){
                countF = rs.getInt(1);
            }
            mat = new String[countF][2];
            
            pr = conn.prepareStatement(sql2);
            pr.setString(1, anio);
            rs = pr.executeQuery();
            while(rs.next()){
               mat[i][0] = rs.getString(1);
               mat[i][1] = rs.getString(2);
               i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mat;
    }
    
    public String[] listAnios(String codEmpl){
        String[] vec = null;
        int count = 0, i = 0;
        String sql1 = "SELECT  COUNT(DISTINCT YEAR(Fecha_Registro))\n" +
                      "  FROM Actividad\n" +
                      " WHERE Cod_Empleado = ?";
        String sql2 = "SELECT DISTINCT YEAR(Fecha_Registro)\n" +
                      "  FROM Actividad\n" +
                      " WHERE Cod_Empleado = ?";
        try {
            pr = conn.prepareStatement(sql1);
            pr.setString(1, codEmpl);
            rs = pr.executeQuery();
            while(rs.next()){
                count = rs.getInt(1);
            }
            
            vec = new String[count];
            
            pr = conn.prepareStatement(sql2);
            pr.setString(1, codEmpl);
            rs = pr.executeQuery();
            while(rs.next()){
                vec[i] = rs.getString(1);
                i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vec;
    }
    
    public void insertNewClient(String nombreCli, String codRubro, String telefono, String correo, String codEmp, String codServicio, String codTipoCom, String nivelInt){
        try {
            cst = conn.prepareCall("{call sp_register_client(?,?,?,?,?,?,?,?)}");
            cst.setString(1, nombreCli);
            cst.setString(2, codRubro);
            cst.setString(3, telefono);
            cst.setString(4, correo);
            cst.setString(5, codEmp);
            cst.setString(6, codServicio);
            cst.setString(7, codTipoCom);
            cst.setString(8, nivelInt);
            cst.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
    public void insertNewActivity(String codCli, String codServicio, String codTipoCom, String nivelInt){
        try {
            cst = conn.prepareCall("{call sp_register_activity(?,?,?,?)}");
            cst.setString(1, codCli);
            cst.setString(2, codServicio);
            cst.setString(3, codTipoCom);
            cst.setString(4, nivelInt);
            cst.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Vector<DetailClient> resultBusqueda(String palabra){
        Vector<DetailClient> vecDet = new Vector<DetailClient>();
        String sql = "SELECT cl.Cod_Cliente,\n" +
                     "	     cl.Des_Nombre 		AS Nom_Cliente,\n" +
                     "	     se.Des_Nombre 		AS Negocicacion,\n" +
                     "	     de.Nivel_Interes		AS Interes,\n" +
                     "	     ti.Des_Nombre		AS Contacto,\n" +
                     "	     ru.Des_Nombre		AS Nom_Rubro,\n" +
                     "	     date_format(ac.Fecha_Registro, '%d/%m/%Y') AS Fecha_Reg\n" +
                     "  FROM Cliente cl\n" +
                     " INNER JOIN Actividad ac			ON cl.Cod_Cliente   = ac.Cod_Cliente\n" +
                     " INNER JOIN Empleado em		        ON ac.Cod_Empleado  = em.Cod_Empleado\n" +
                     " INNER JOIN Detalle_Actividad de          ON de.Cod_Actividad = ac.Cod_Actividad\n" +
                     " INNER JOIN Servicio se			ON de.Cod_Servicio  = se.Cod_Servicio\n" +
                     " INNER JOIN Tipo_Comunicacion ti          ON de.Cod_Tipo_Com  = ti.Cod_Tipo_Com\n" +
                     " INNER JOIN Rubro ru			ON cl.Cod_rubro     = ru.Cod_Rubro\n" +
                     " WHERE ac.Fecha_Registro = de.Fecha_Actividad\n" +
                     "   AND (cl.Des_Nombre  		LIKE '%"+palabra+"%'\n" +
                     "    OR cl.Telefono	  	LIKE '%"+palabra+"%'\n" +
                     "    OR cl.Correo			LIKE '%"+palabra+"%'\n" +
                     "    OR em.Des_Nombre		LIKE '%"+palabra+"%'\n" +
                     "    OR em.Des_Apellido_Pat	LIKE '%"+palabra+"%'\n" +
                     "    OR em.Des_Apellido_Mat	LIKE '%"+palabra+"%'\n" +
                     "    OR em.Fecha_Nacimiento        LIKE '%"+palabra+"%'\n" +
                     "    OR em.Sexo			LIKE '%"+palabra+"%'\n" +
                     "    OR se.Des_Nombre		LIKE '%"+palabra+"%'\n" +
                     "    OR ac.Fecha_Registro          LIKE '%"+palabra+"%'\n" +
                     "    OR de.Fecha_Actividad         LIKE '%"+palabra+"%'\n" +
                     "    OR de.Nivel_Interes		LIKE '%"+palabra+"%'\n" +
                     "    OR ti.Des_Nombre		LIKE '%"+palabra+"%'\n" +
                     "    OR ru.Des_Nombre		LIKE '%"+palabra+"%')";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                DetailClient detCl = new DetailClient(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                detCl.setCod_Cliente(rs.getString(1));
                detCl.setNom_Cliente(rs.getString(2));
                detCl.setNegociacion(rs.getString(3));
                detCl.setInteres(rs.getString(4));
                detCl.setContacto(rs.getString(5));
                detCl.setRubro(rs.getString(6));
                detCl.setFecha_Reg(rs.getString(7));
                vecDet.add(detCl);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vecDet;
    }
}
