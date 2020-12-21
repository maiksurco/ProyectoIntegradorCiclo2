package data;

import entidades.Producto;
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

public class ProductoData {
    static Connection con = Conexion.connectSQLite();
    static PreparedStatement prest;
    static ErrorLogger log = new ErrorLogger(ProductoData.class.getName());
    
    static SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
    static SimpleDateFormat sdf = new SimpleDateFormat(SQLiteConfig.DEFAULT_DATE_STRING_FORMAT);
    
    static Date dt = new Date();
    static String currentTime = sdf.format(dt);
    
    public static int create(Producto pro) {
        int rsIdProducto = 0;
        String[] returns = {"idProdutcto"};
        String sql = "INSERT INTO productos(nombre_Producto, costo_Unitario_Producto, stock_Producto, producto_Defectuosos, marca_Producto) "
                + "VALUES(?,?,?,?,?)";
        int i = 0;
        System.out.println(sql);
        try {
            prest = con.prepareStatement(sql, returns);
            prest.setString(++i, pro.getNameProduct());
            prest.setDouble(++i, pro.getCostUnitProduct());
            prest.setDouble(++i, pro.getStockProduct());
            prest.setDouble(++i, pro.getDefecProduct());
            prest.setString(++i,pro.getMarcaProduct());
            rsIdProducto = prest.executeUpdate();// 0 no o 1 si commit
            try (ResultSet rs = prest.getGeneratedKeys()) {
                if (rs.next()) {
                    rsIdProducto = rs.getInt(1); // select tk, max(id)  from clientes
                    //System.out.println("rs.getInt(rsId): " + rsId);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.err.println("create:" + ex.toString());
            //ErrorLogger.log(Level.SEVERE, "create", ex);
        }
        return rsIdProducto;
    }

    
    public static int update(Producto pro) {
        Connection cn = Conexion.connectSQLite();
        PreparedStatement prs;
        int comit = 0;
        String sql = "UPDATE clientes SET "
                
                + "NombreProducto=?, "
                + "Costo=?, "
                + "Stock=?, "
                + "ProductosDfectuosos=?, "
                + "Categoria=?, "
                + "WHERE Id_Cliente=?";
        int i = 0;
        try {
            prest = cn.prepareStatement(sql);
            
            prest.setString(++i, pro.getNameProduct());
            prest.setDouble(++i, pro.getCostUnitProduct());
            prest.setDouble(++i, pro.getStockProduct());
            prest.setDouble(++i, pro.getDefecProduct());
            prest.setString(++i,pro.getMarcaProduct());
            comit = prest.executeUpdate();
        } catch (SQLException ex) {
            //ErrorLogger.log(Level.SEVERE, "update", ex);
           // log.log(java.util.logging.Level.SEVERE, "update", ex);
        }
        return comit;
    }
    
    
    public static int delete(int Id_Producto) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM clientes WHERE Id_Producto = ?";
        try {
            prest = con.prepareStatement(sql);
            prest.setInt(1, Id_Producto);
            comit = prest.executeUpdate();
        } catch (SQLException ex) {
            log.log(java.util.logging.Level.SEVERE, "delete", ex);
            throw new Exception("Detalle:" + ex.getMessage());
        }
        return comit;
    }
    
    
    public static List<Producto> listCombo(String filter){
        List<Producto> listProducto = new ArrayList();
        listProducto.add(new Producto("Seleccione..."));
        listProducto.addAll(list(filter));
        return listProducto;
    }

    public static List<Producto> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<Producto> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM productos ORDER BY idProducto";
        } else {
            sql = "SELECT * FROM productos WHERE (idProducto LIKE'" + filter +
                   
                    "%' OR " + "nombre_Producto LIKE'" + filter + 
                    "%' OR " + "costo_Unitario_Producto LIKE'" + filter + 
                    "%' OR " + "stock_Producto LIKE'" + filter + 
                    "%' OR " + "producto_Defectuosos LIKE'" + filter + 
                    "%' OR " + "marca_Producto LIKE'" + filter + 
                    "%') "
                    + "ORDER BY idProducto";
        }
        try {
            java.sql.Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setIdProducto(rs.getInt("idProducto"));
                
                pro.setNameProduct(rs.getString("nombre_Producto"));
                pro.setCostUnitProduct(rs.getDouble("costo_Unitario_Producto"));
                pro.setStockProduct(rs.getDouble("stock_Producto"));
                pro.setDefecProduct(rs.getDouble("producto_Defectuosos"));
                pro.setMarcaProduct(rs.getString("marca_Producto"));
                ls.add(pro);
            }
        } catch (SQLException ex) {
            //log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }
    
    
    public static Producto getByPId(int Id_Producto) {
        Producto pro = new Producto();

        String sql = "SELECT * FROM clientes WHERE idProducto = ? ";
        int i = 0;
        try {
            prest = con.prepareStatement(sql);
            prest.setInt(++i, Id_Producto);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                pro.setIdProducto(rs.getInt("idProducto"));
                pro.setNameProduct(rs.getString("nombre_Producto"));
                pro.setCostUnitProduct(rs.getDouble("costo_Unitario_Producto"));
                pro.setStockProduct(rs.getDouble("stock_Producto"));
                pro.setDefecProduct(rs.getDouble("producto_Defectuosos"));
                pro.setMarcaProduct(rs.getString("marca_Producto"));
            }
        } catch (SQLException ex) {
            //log.log(Level.SEVERE, "getByPId", ex);
        }
        return pro;
    }

    
    
    
}