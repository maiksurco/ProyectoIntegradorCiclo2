package data;

import entidades.DetalleDeVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import utils.ErrorLogger;

public class DetalleVentaData {
    static Connection cn = Conexion.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(DetalleVentaData.class.getName());

    
    public static int create(DetalleDeVenta dv) {
        int rsId = 0;
        String[] returns = {"id"};
        String sql = "INSERT INTO detalleVenta(descripcion, cantidad, precio, descuento, subtotal, ventaId,  productoId) " //activo
                + "VALUES(?,?,?,?,?,?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, dv.getDescripcion());
            ps.setDouble(++i, dv.getCantidad());
            ps.setDouble(++i, dv.getPrecio());
            ps.setDouble(++i, dv.getDescuento());
            ps.setDouble(++i, dv.getSubtotal());
            
            ps.setInt(++i, dv.getVentaId());
            ps.setInt(++i, dv.getProductoId());
            
            rsId = ps.executeUpdate();// 0 no o 1 si commit
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1); // select tk, max(id)  from venta_lineas
                    //System.out.println("rs.getInt(rsId): " + rsId);
                    // soy sullon local
                    //
                    System.out.println(" rs.getInt(rsId): " + rsId);
                    
                }
                rs.close();
            }
        } catch (SQLException ex) {
            //System.err.println("create:" + ex.toString());
            log.log(Level.SEVERE, "create", ex);
        }
        return rsId;
    }

    public static int update(DetalleDeVenta dv) {
        System.out.println("actualizar d.getId(): " + dv.getId());
        int comit = 0;
        String sql = "UPDATE DetalleDeVenta SET "
                + "descripcion=?, "
                + "cantidad=?, "
                + "precio=?, "
                + "descuento=?, "
                + "subtotal=?, "
                + "productoId=? "
                
                + "WHERE id=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, dv.getDescripcion());
            ps.setDouble(++i, dv.getCantidad());
            ps.setDouble(++i, dv.getPrecio());
            ps.setDouble(++i, dv.getDescuento());
            ps.setDouble(++i, Math.round(dv.getCantidad()* dv.getPrecio() * 100.0) / 100.0 ); //ps.setDouble(++i, d.getSubtotal());
            
            //ps.setInt(++i, d.getVenta_id());
            ps.setInt(++i, dv.getProductoId());
            
            ps.setInt(++i, dv.getId());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }
    

    public static int delete(int id) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM DetalleDeVenta WHERE id = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Detalle:" + ex.getMessage());
        }
        return comit;
    }

    public static List<DetalleDeVenta> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<DetalleDeVenta> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM DetalleDeVenta ORDER BY id";
        } else {
            sql = "SELECT * FROM DetalleDeVenta WHERE (id LIKE'" + filter + "%' OR "
                    + "descripcion LIKE'" + filter + "%' OR cant LIKE'" + filter + "%' OR "
                    + "id LIKE'" + filter + "%') "
                    + "ORDER BY descripcion";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DetalleDeVenta dv = new DetalleDeVenta();
                dv.setId(rs.getInt("id"));
                dv.setDescripcion(rs.getString("descripcion"));
                dv.setCantidad(rs.getDouble("cantidad"));
                dv.setPrecio(rs.getDouble("precio"));
                dv.setDescuento(rs.getDouble("descuento"));
                dv.setSubtotal(rs.getDouble("subtotal"));
                dv.setProductoId(rs.getInt("productoId"));
                dv.setVentaId(rs.getInt("ventaId"));
                dv.setActivo(rs.getInt("activo"));
                ls.add(dv);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }

    public static DetalleDeVenta getByPId(int id) {
        DetalleDeVenta dv = new DetalleDeVenta();

        String sql = "SELECT * FROM DetalleDeVenta WHERE id = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dv.setId(rs.getInt("id"));
                dv.setDescripcion(rs.getString("descripcion"));
                 dv.setCantidad(rs.getDouble("cantidad"));
                dv.setPrecio(rs.getDouble("precio"));
                dv.setDescuento(rs.getDouble("descuento"));
                dv.setSubtotal(rs.getDouble("subtotal"));
                dv.setProductoId(rs.getInt("productoId"));
                dv.setVentaId(rs.getInt("ventaId"));
                dv.setActivo(rs.getInt("activo"));
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return dv;
    }
    
    
    public static List<DetalleDeVenta> listByVenta(int ventaId) { // devolver todas las lineas de una venta

        System.out.println("listByVenta.comp_id:" + ventaId);

        List<DetalleDeVenta> ls = new ArrayList();

        String sql = "";
         sql = " SELECT * FROM detalleVenta "
                + " WHERE ventaId = " + ventaId + " "
                + " ORDER BY id ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DetalleDeVenta dv = new DetalleDeVenta();
                dv.setId(rs.getInt("id"));
                dv.setDescripcion(rs.getString("descripcion"));                
                dv.setCantidad(rs.getDouble("cantidad"));
                dv.setPrecio(rs.getDouble("precio"));
                dv.setDescuento(rs.getDouble("descuento"));
                dv.setSubtotal(rs.getDouble("subtotal"));
                dv.setProductoId(rs.getInt("productoId"));
                dv.setVentaId(rs.getInt("ventaId"));
                dv.setActivo(rs.getInt("activo"));
                
                ls.add(dv);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }
    
}
