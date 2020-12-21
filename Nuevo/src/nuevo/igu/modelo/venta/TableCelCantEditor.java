package nuevo.igu.modelo.venta;

import data.DetalleVentaData;
import entidades.DetalleDeVenta;
import nuevo.igu.modelo.detalleventamodelos.DetalleVentaTablaModelo;
import paneles.VentasPanel;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellEditor;
import utils.MsgPanel;

public class TableCelCantEditor extends AbstractCellEditor implements TableCellEditor {

    JTextField valor;
    private String valorInicial = "";
    private String valorActual = "";
    private int fila;
    private int col;

    VentasPanel compra;
    private JTable tabla;

    public VentasPanel getCompra() {
        return compra;
    }

    public TableCelCantEditor(VentasPanel compra) {
        this.compra = compra;
        valor = new JTextField();
        valor.setHorizontalAlignment(JTextField.RIGHT);
        valor.setFont(new Font("Times New Roman", 1, 19));
        valor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        valor.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String filterStr = "0123456789.";
                char c = (char) e.getKeyChar();
                if (filterStr.indexOf(c) < 0) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                JTextField tmp = (JTextField) e.getSource();
                valorActual = tmp.getText();
                System.out.println("keyReleased valorActual: " + valorActual);
                System.out.println("keyReleased valorInicial: " + valorInicial);

                DetalleVentaTablaModelo mt = ((DetalleVentaTablaModelo) tabla.getModel());

                if (!valorActual.trim().isEmpty()) {

                    mt.setValueAt(valorActual, fila, col);
                    tmp.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
                    MsgPanel.error("");

                    DetalleDeVenta dv = ((DetalleDeVenta) mt.getRow(fila));
                    System.out.println("getCant : " + dv.getCantidad());

                    //d.setSubtotal(d.getCant()*d.getPrecio());
                    if (dv.getProductoId() > 0) { //producto es selected
                        ////d.setVenta_id(d.getVenta_id());
                        //d.setProd_id(d.getProd_id());
                        //d.setDescripcion(d.getDescripcion());
                        //d.setPrecio(d.getPrecio());
                        dv.setCantidad(Double.parseDouble(valorActual + ""));
                        //d.setSubtotal(d.getPrecio() * d.getCant());

                        int opcion = DetalleVentaData.update(dv);
                        if (opcion != 0) {
                            MsgPanel.success("Se ha modificado el detalle de la venta");
                            //pintar campos calculados: totales
                            DetalleDeVenta dvd = DetalleVentaData.getByPId(dv.getId());
                            //d.setPrecio_do(dt.getPrecio_do());
                            //d.setPrecio_so(dt.getPrecio_so());
                            dv.setSubtotal(dvd.getSubtotal());
                            // d.setTotal_do(dt.getTotal_do());
                        }
                    }  else {
                        MsgPanel.success("Debe seleccionar un producto");
                        fireEditingStopped();
                    }
                } else {
                    tmp.setBorder(new LineBorder(new java.awt.Color(255, 0, 0), 3));
                    MsgPanel.error("cantidad es requerido", true);
                }
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        if (valorActual.trim().isEmpty()) {
            return valorInicial;
        } else {
            return valorActual;
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        System.out.println("getTableCellEditorComponent  cant fila: " + row);
        tabla = table;
        fila = row;
        col = column;
        valorInicial = ((DetalleVentaTablaModelo) table.getModel()).getValueAt(row, column) + "";
        valorActual = value == null ? "" : "" + value;
        valor.setText(valorActual);
        //System.out.println("Component valorActual : " + valorActual);
        //System.out.println("Component valorInicial : " + valorInicial);
        return valor;
    }

}
