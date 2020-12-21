package data;

import entidades.Cliente;
import java.beans.Statement;
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

public class ClienteData {
    static Connection con = Conexion.connectSQLite();
    static PreparedStatement prest;
    static ErrorLogger log = new ErrorLogger(ClienteData.class.getName());
    
    static SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
    static SimpleDateFormat sdf = new SimpleDateFormat(SQLiteConfig.DEFAULT_DATE_STRING_FORMAT);
    
    static Date dt = new Date();
    static String currentTime = sdf.format(dt);
    
    public static int create(Cliente cli) {
        int rsId_cliente = 0;
        String[] returns = {"idCliente"};
        String sql = "INSERT INTO clientes(nombre, apellido, direccion, correo, sexo) "
                + "VALUES(?,?,?,?,?)";
        int i = 0;
        System.out.println(sql);
        try {
            prest = con.prepareStatement(sql, returns);
            prest.setString(++i, cli.getNombres());
            prest.setString(++i, cli.getApellidos());
            prest.setString(++i, cli.getDireccion());
            prest.setString(++i, cli.getCorreo());
            prest.setString(++i, cli.getSexo());
            rsId_cliente = prest.executeUpdate();// 0 no o 1 si commit
            try (ResultSet rs = prest.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId_cliente = rs.getInt(1); // select tk, max(id)  from clientes
                    //System.out.println("rs.getInt(rsId): " + rsId);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.err.println("create:" + ex.toString());
            //ErrorLogger.log(Level.SEVERE, "create", ex);
        }
        return rsId_cliente;
    }

    
    public static int update(Cliente cli) {
        Connection cn = Conexion.connectSQLite();
        PreparedStatement prs;
        int comit = 0;
        String sql = "UPDATE clientes SET "
                
                + "Nombres=?, "
                + "Apellidos=?, "
                + "Direccion=?, "
                + "Correo=?, "
                + "Sexo=?, "
                + "WHERE Id_Cliente=?";
        int i = 0;
        try {
            prest = cn.prepareStatement(sql);
            
            prest.setString(++i, cli.getNombres());
            prest.setString(++i, cli.getApellidos());
            prest.setString(++i, cli.getDireccion());
            prest.setString(++i, cli.getCorreo());
            prest.setString(++i, cli.getSexo());
           
            comit = prest.executeUpdate();
        } catch (SQLException ex) {
            //ErrorLogger.log(Level.SEVERE, "update", ex);
           // log.log(java.util.logging.Level.SEVERE, "update", ex);
        }
        return comit;
    }
    
    
    public static int delete(int Id_Cliente) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM clientes WHERE Id_Cliente = ?";
        try {
            prest = con.prepareStatement(sql);
            prest.setInt(1, Id_Cliente);
            comit = prest.executeUpdate();
        } catch (SQLException ex) {
            //ErrorLogger.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Persona_id:" + ex.getMessage());
        }
        return comit;
    }
    
    
    public static List<Cliente> listCombo(String filter){
        List<Cliente> li = new ArrayList();
        li.add(new Cliente("Seleccione..."));
        li.addAll(list(filter));
        return li;
    }

    public static List<Cliente> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<Cliente> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM clientes ORDER BY idCliente";
        } else {
            sql = "SELECT * FROM clientes WHERE (idCliente LIKE'" + filter +
                   
                    "%' OR " + "nombre LIKE'" + filter + 
                    "%' OR " + "apellido LIKE'" + filter + 
                    "%' OR " + "direccion LIKE'" + filter + 
                    "%' OR " + "correo LIKE'" + filter + 
                    "%' OR " + "sexo LIKE'" + filter + 
                    "%') "
                    + "ORDER BY idCliente";
        }
        try {
            java.sql.Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("idCliente"));
                
                cli.setNombres(rs.getString("nombre"));
                cli.setApellidos(rs.getString("apellido"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setCorreo(rs.getString("correo"));
                cli.setSexo(rs.getString("sexo"));
                ls.add(cli);
            }
        } catch (SQLException ex) {
            //log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }
    
    
    public static Cliente getByPId(int Id_Cliente) {
        Cliente cli = new Cliente();

        String sql = "SELECT * FROM clientes WHERE idCliente = ? ";
        int i = 0;
        try {
            prest = con.prepareStatement(sql);
            prest.setInt(++i, Id_Cliente);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                cli.setId(rs.getInt("idCliente"));
               
                cli.setNombres(rs.getString("nombre"));
                cli.setApellidos(rs.getString("apellido"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setCorreo(rs.getString("correo"));
                cli.setSexo(rs.getString("sexo"));
            }
        } catch (SQLException ex) {
            //log.log(Level.SEVERE, "getByPId", ex);
        }
        return cli;
    }

    
    
    
}