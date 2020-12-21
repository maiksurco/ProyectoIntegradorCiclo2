package nuevo.igu.modelo.venta;

import data.DetalleVentaData;
import entidades.Producto;
import entidades.Venta;
import entidades.DetalleDeVenta;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import nuevo.igu.modelo.detalleventamodelos.DetalleVentaTablaModelo;
import paneles.VentasPanel;
public class AddandDeleteProductoPanel extends javax.swing.JPanel {

    private JPanel ifr;
    private JTable tabla;
    private DetalleVentaTablaModelo dvtm;
    private int indexFila = -1;
    private CeldaAccionEditor cae;

    public AddandDeleteProductoPanel(JPanel ifr) {
        initComponents();
        this.ifr = ifr;

    }

    public void setCeldaEditor(CeldaAccionEditor cae) {
        this.cae = cae;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
        dvtm = (DetalleVentaTablaModelo) this.tabla.getModel();
    }

    public void setIndexFila(int fila) {
        this.indexFila = fila;
    }

    public AddandDeleteProductoPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AGREGAR = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(1, 0));

        AGREGAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar detalle producto venta.png"))); // NOI18N
        AGREGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGARActionPerformed(evt);
            }
        });
        add(AGREGAR);

        ELIMINAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar detalle producto venta.png"))); // NOI18N
        add(ELIMINAR);
    }// </editor-fold>//GEN-END:initComponents

    private void AGREGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGARActionPerformed
        System.out.println("add");
        if (this.tabla.getSelectedRow() != -1) {
            this.indexFila = this.tabla.getSelectedRow();
            System.err.println("add " + this.indexFila);
        }
        //if (((VentasPanel) this.ifr).isEsActualizacion()) {
        //    System.out.println("isEsActualizacion  true ");
        //}

        VentasPanel vp = ((VentasPanel) this.ifr);
        Venta ventaSelected = vp.getVentaSelected();
        if (ventaSelected != null) {
            BuscarProductoVentaPanel mov = new BuscarProductoVentaPanel(ventaSelected);
            // mov.setCompraSelected(compraSelected);
            //mov.getCompraSelected().getEsdolares()
            JOptionPane.showOptionDialog(null, mov,
                    "Elija un producto ",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{}, null);

            Producto pSelected = mov.getProducto();
            if (pSelected != null) {
                System.err.println("Producto seleccionado " + pSelected.getNameProduct());
                DetalleDeVenta dv = ((DetalleDeVenta) dvtm.getRow(this.indexFila));
                dv.setVentaId(ventaSelected.getId());
                dv.setProductoId(pSelected.getIdProducto());
                dv.setDescripcion(pSelected.getNameProduct());
                dv.setPrecio(pSelected.getCostUnitProduct());
                dv.setCantidad(1);
                dv.setSubtotal(pSelected.getCostUnitProduct()* dv.getCantidad());
                if (dv.getId() > 0) {
                    DetalleVentaData.update(dv);
                } else {
                    int idx = DetalleVentaData.create(dv);
                    dv.setId(idx);
                    dv.setActivo(1);
                }
                
                this.tabla.changeSelection(this.indexFila, 1, true, false);
                // mtdc.contarItems();
                cae.lanzarDetencionEdicion();
                
                if (this.indexFila == this.tabla.getRowCount() - 1 ) {
       
                dvtm.addRow(new DetalleDeVenta());
   
            }
                

            } else {
                System.err.println("Producto NO seleccionado ");
            }

        }
    }//GEN-LAST:event_AGREGARActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AGREGAR;
    private javax.swing.JButton ELIMINAR;
    // End of variables declaration//GEN-END:variables
}
