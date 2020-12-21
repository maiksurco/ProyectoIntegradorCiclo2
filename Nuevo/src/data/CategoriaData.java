package data;

import entidades.Categoria;
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

public class CategoriaData {
    static Connection con = Conexion.connectSQLite();
    static PreparedStatement prest;
    static ErrorLogger log = new ErrorLogger(CategoriaData.class.getName());
    
    static SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
    static SimpleDateFormat sdf = new SimpleDateFormat(SQLiteConfig.DEFAULT_DATE_STRING_FORMAT);
    
    static Date dt = new Date();
    static String currentTime = sdf.format(dt);
    
    public static int create(Categoria cat) {
        int rsId_categoria = 0;
        String[] returns = {"idCliente"};
        String sql = "INSERT INTO clientes(id, nombreCategoria) "
                + "VALUES(?,?)";
        int i = 0;
        System.out.println(sql);
        try {
            prest = con.prepareStatement(sql, returns);
            prest.setString(++i, cat.getNombreCategoria());

            rsId_categoria = prest.executeUpdate();// 0 no o 1 si commit
            try (ResultSet rs = prest.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId_categoria = rs.getInt(1); // select tk, max(id)  from clientes
                    //System.out.println("rs.getInt(rsId): " + rsId);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.err.println("create:" + ex.toString());
            //ErrorLogger.log(Level.SEVERE, "create", ex);
        }
        return rsId_categoria;
    }

    
    public static int update(Categoria cat) {
        Connection cn = Conexion.connectSQLite();
        PreparedStatement prs;
        int comit = 0;
        String sql = "UPDATE categorias SET "
                
                + "nombreCategoria=?, "
                + "WHERE Id_Cliente=?";
        int i = 0;
        try {
            prest = cn.prepareStatement(sql);
            
            prest.setString(++i, cat.getNombreCategoria());
           
            comit = prest.executeUpdate();
        } catch (SQLException ex) {
            //ErrorLogger.log(Level.SEVERE, "update", ex);
           // log.log(java.util.logging.Level.SEVERE, "update", ex);
        }
        return comit;
    }
    
    
    public static int delete(int Id_Categoria) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM categorias WHERE id = ?";
        try {
            prest = con.prepareStatement(sql);
            prest.setInt(1, Id_Categoria);
            comit = prest.executeUpdate();
        } catch (SQLException ex) {
            //ErrorLogger.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Persona_id:" + ex.getMessage());
        }
        return comit;
    }
    
    
    public static List<Categoria> listCombo(String filter){
        List<Categoria> li = new ArrayList();
        li.add(new Categoria("Seleccione..."));
        li.addAll(list(filter));
        return li;
    }

    public static List<Categoria> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<Categoria> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM categorias ORDER BY id";
        } else {
            sql = "SELECT * FROM categorias WHERE (id LIKE'" + filter +
                   
                    "%' OR " + "nombreCategoria LIKE'" + filter + 
                    "%') "
                    + "ORDER BY idCliente";
        }
        try {
            java.sql.Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                
                cat.setNombreCategoria(rs.getString("nombreCategoria"));

                ls.add(cat);
            }
        } catch (SQLException ex) {
            //log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }
    
    
    public static Categoria getByPId(int Id_Categoria) {
        Categoria cat = new Categoria();

        String sql = "SELECT * FROM categorias WHERE id = ? ";
        int i = 0;
        try {
            prest = con.prepareStatement(sql);
            prest.setInt(++i, Id_Categoria);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                cat.setId(rs.getInt("id"));
               
                cat.setNombreCategoria(rs.getString("nombreCategoria"));
            }
        } catch (SQLException ex) {
            //log.log(Level.SEVERE, "getByPId", ex);
        }
        return cat;
    }

    
    
    
}