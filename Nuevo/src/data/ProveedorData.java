package data;

import entidades.Proveedor;
import java.beans.Statement;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.sqlite.SQLiteConfig;
import utils.ErrorLogger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorData {
    static Connection con = Conexion.connectSQLite();
    static PreparedStatement prest;
    static ErrorLogger log = new ErrorLogger(ProveedorData.class.getName());
    
    static SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
    static SimpleDateFormat sdf = new SimpleDateFormat(SQLiteConfig.DEFAULT_DATE_STRING_FORMAT);
    
    static Date dt = new Date();
    static String currentTime = sdf.format(dt);
    
    public static int create(Proveedor prov) {
        int rsId_proveedor = 0;
        String[] returns = {"idCliente"};
        String sql = "INSERT INTO clientes(nombreProveedor, apellidoProveedor, telefono, sexo, ruc) "
                + "VALUES(?,?,?,?,?)";
        int i = 0;
        System.out.println(sql);
        try {
            prest = con.prepareStatement(sql, returns);
            prest.setString(++i, prov.getNombreProveedor());
            prest.setString(++i, prov.getApellidoProveedor());
            prest.setDouble(++i, prov.getTelefono());
            prest.setString(++i, prov.getSexo());
            prest.setDouble(++i, prov.getRuc());
            rsId_proveedor = prest.executeUpdate();// 0 no o 1 si commit
            try (ResultSet rs = prest.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId_proveedor = rs.getInt(1); // select tk, max(id)  from clientes
                    //System.out.println("rs.getInt(rsId): " + rsId);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.err.println("create:" + ex.toString());
            //ErrorLogger.log(Level.SEVERE, "create", ex);
        }
        return rsId_proveedor;
    }

    
    public static int update(Proveedor prov) {
        Connection cn = Conexion.connectSQLite();
        PreparedStatement prs;
        int comit = 0;
        String sql = "UPDATE Proveedor SET "
                
                + "nombreProveedor=?, "
                + "apellidoProveedor=?, "
                + "telefono=?, "
                + "sexo=?, "
                + "ruc=?, "
                + "WHERE Id_Cliente=?";
        int i = 0;
        try {
            prest = cn.prepareStatement(sql);
            
            prest.setString(++i, prov.getNombreProveedor());
            prest.setString(++i, prov.getApellidoProveedor());
            prest.setDouble(++i, prov.getTelefono());
            prest.setString(++i, prov.getSexo());
            prest.setDouble(++i, prov.getRuc());
           
            comit = prest.executeUpdate();
        } catch (SQLException ex) {
            //ErrorLogger.log(Level.SEVERE, "update", ex);
           // log.log(java.util.logging.Level.SEVERE, "update", ex);
        }
        return comit;
    }
    
    
    public static int delete(int Id_Proveedor) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM clientes WHERE Id_Cliente = ?";
        try {
            prest = con.prepareStatement(sql);
            prest.setInt(1, Id_Proveedor);
            comit = prest.executeUpdate();
        } catch (SQLException ex) {
            //ErrorLogger.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Persona_id:" + ex.getMessage());
        }
        return comit;
    }
    
    
    public static List<Proveedor> listCombo(String filter){
        List<Proveedor> li = new ArrayList();
        li.add(new Proveedor("Seleccione..."));
        li.addAll(list(filter));
        return li;
    }

    public static List<Proveedor> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<Proveedor> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM proveedores ORDER BY idProducto";
        } else {
            sql = "SELECT * FROM proveedores WHERE (idProducto LIKE'" + filter +
                   
                    "%' OR " + "nombreProveedor LIKE'" + filter + 
                    "%' OR " + "apellidoProveedor LIKE'" + filter + 
                    "%' OR " + "telefono LIKE'" + filter + 
                    "%' OR " + "sexo LIKE'" + filter + 
                    "%' OR " + "ruc LIKE'" + filter + 
                    "%') "
                    + "ORDER BY idCliente";
        }
        try {
            java.sql.Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Proveedor prov = new Proveedor();
                prov.setIdProveedor(rs.getInt("idProducto"));
                
                prov.setNombreProveedor(rs.getString("nombreProveedor"));
                prov.setApellidoProveedor(rs.getString("apellidoProveedor"));
                prov.setTelefono(rs.getDouble("telefono"));
                prov.setSexo(rs.getString("sexo"));
                prov.setRuc(rs.getDouble("ruc"));
                ls.add(prov);
            }
        } catch (SQLException ex) {
            //log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }
    
    
    public static Proveedor getByPId(int Id_Cliente) {
        Proveedor prov = new Proveedor();

        String sql = "SELECT * FROM proveedores WHERE idProveedores = ? ";
        int i = 0;
        try {
            prest = con.prepareStatement(sql);
            prest.setInt(++i, Id_Cliente);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                prov.setIdProveedor(rs.getInt("idCliente"));
               
                prov.setNombreProveedor(rs.getString("nombreProveedor"));
                prov.setApellidoProveedor(rs.getString("apellidoProveedor"));
                prov.setTelefono(rs.getDouble("telefono"));
                prov.setSexo(rs.getString("sexo"));
                prov.setRuc(rs.getDouble("ruc"));
            }
        } catch (SQLException ex) {
            //log.log(Level.SEVERE, "getByPId", ex);
        }
        return prov;
    }

    
    
    
}