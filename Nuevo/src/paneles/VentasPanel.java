package paneles;

import data.ClienteData;
import data.VentaData;
import entidades.Cliente;
import entidades.Venta;
import nuevo.igu.modelo.venta.AccionTableCellRenderer;
import nuevo.igu.modelo.venta.CeldaAccionEditor;
import nuevo.igu.modelo.venta.TableCelCantEditor;
import nuevo.igu.Validate;
//import nuevo.igu.modelo.tablas.TableCellNumber;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import nuevo.igu.modelo.detalleventamodelos.DetalleVentaTablaModelo;
import utils.Config;
import utils.MsgPanel;

public class VentasPanel extends javax.swing.JPanel {

    private DefaultComboBoxModel clientesComboxModel;
    private List<Cliente> clientes;

    DetalleVentaTablaModelo dvtm;

    private boolean esActualizacion;
    private Cliente clienteSelected;
    private Venta ventaSelected;

    public Venta getVentaSelected() {
        return ventaSelected;
    }

    public boolean isEsActualizacion() {
        return esActualizacion;
    }

    public Cliente getClienteSelected() {
        return clienteSelected;
    }
    
    public VentasPanel() {
        initComponents();
        USER.setText(Validate.userId+"");
        
        clientes = ClienteData.listCombo("");
        clientesComboxModel = new DefaultComboBoxModel(clientes.toArray());
        jComboBox1.setModel(clientesComboxModel);

        dvtm = new DetalleVentaTablaModelo();
        TablaVentas.setModel(dvtm);
        TablaVentas.setEnabled(false);
        ESTADO.setText("");
        paintTable(dvtm);

    }

    public void paintTable(DetalleVentaTablaModelo ventatableModel) {
        this.dvtm = ventatableModel;
        TablaVentas.setModel(dvtm);
        TablaVentas.getColumnModel().getColumn(0).setMaxWidth(35);

        TablaVentas.getColumnModel().getColumn(3).setCellEditor(new TableCelCantEditor(this));
        //tabla.getColumnModel().getColumn(3).setCellRenderer(new TableCellNumber("#,##0.00")); // "#,##0.00"

        TablaVentas.getColumnModel().getColumn(5).setCellRenderer(new AccionTableCellRenderer(this));
        TablaVentas.getColumnModel().getColumn(5).setCellEditor(new CeldaAccionEditor(this));

        setEventTable();
        if (ventaSelected != null) {
            if (ventaSelected.getActivo() == 1) {
                ESTADO.setText("EN PROCESO");
            }
            if (ventaSelected.getActivo() == 2) {
                ESTADO.setText("COMPLETADO");
            }
        }
        }
    private void setEventTable() {
        TableModelListener tml = new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.printf("tableChanged \n");
                tableHandlerEvent();
            }
        };
        this.TablaVentas.getModel().addTableModelListener(tml);

    }

    private void tableHandlerEvent() {
        if (ventaSelected != null) {
            System.out.printf("ventaSelected \n");
            double sal = sumRow(this.dvtm, 4); //CompraDetData.getSaldosByCompId(compraSelected.getId());
            TOTAL.setText(new DecimalFormat(Config.DEFAULT_DECIMAL_STRING_FORMAT).format(sal));

        } else {
            System.out.printf("venta no Selected \n");
            TOTAL.setText("0");

        }
    }

    public double sumRow(DetalleVentaTablaModelo mdl, int col) {
        double total = 0;
        // iterate over all columns
        for (int i = 0; i < mdl.getRowCount(); i++) {
            // null or not Integer will throw exception
            total += (double) mdl.getValueAt(i, col);
        }
        return total;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ESTADO = new javax.swing.JLabel();
        INICIAR_Y_CONTINUAR = new nuevo.igu.modelo.button.TheButton();
        exportar = new nuevo.igu.modelo.button.TheButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVentas = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        TerminarVentaNuevaVenta = new nuevo.igu.modelo.button.TheButton();
        jLabel5 = new javax.swing.JLabel();
        TOTAL = new javax.swing.JLabel();
        USER = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("VENTAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 204, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Elija Cliente: ");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija..." }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Estado de la Venta: ");

        ESTADO.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ESTADO.setText("Estado");

        INICIAR_Y_CONTINUAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iniciar y continuar.png"))); // NOI18N
        INICIAR_Y_CONTINUAR.setText("Iniciar");
        INICIAR_Y_CONTINUAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INICIAR_Y_CONTINUARActionPerformed(evt);
            }
        });

        exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/excel.png"))); // NOI18N
        exportar.setText("Exportar");
        exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(INICIAR_Y_CONTINUAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ESTADO)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(INICIAR_Y_CONTINUAR, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaVentas.setMaximumSize(new java.awt.Dimension(2147483647, 120));
        TablaVentas.setMinimumSize(new java.awt.Dimension(60, 120));
        TablaVentas.setPreferredSize(new java.awt.Dimension(300, 120));
        TablaVentas.setRowHeight(30);
        jScrollPane1.setViewportView(TablaVentas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        TerminarVentaNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/terminaar_iniciar.png"))); // NOI18N
        TerminarVentaNuevaVenta.setText("Terminar Venta / Nueva Venta");
        TerminarVentaNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerminarVentaNuevaVentaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Total: ");

        TOTAL.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TOTAL.setText("M");

        USER.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        USER.setText("UusuariId");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TerminarVentaNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(USER)
                .addGap(28, 28, 28))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TerminarVentaNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(TOTAL)
                    .addComponent(USER)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TerminarVentaNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerminarVentaNuevaVentaActionPerformed
        // TODO add your handling code here:
        if (ventaSelected != null) {
            int opc = JOptionPane.showConfirmDialog(null, "¿Realmente desea terminar la venta? Una vez cerrada ya no se podrá modificar esta venta", "TERMINAR COMPRA", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.OK_OPTION) {
                ventaSelected.setActivo(2);
                int op = VentaData.update(ventaSelected);

                if (op > 0) {
                    MsgPanel.success("compra id:" + ventaSelected.getId() + " estado :" + ventaSelected.getActivo());
                } else {
                    MsgPanel.error("No se pudo cambiar el estado ", true);
                }
            }
            if (ventaSelected.getActivo() == 1) {
                ESTADO.setText("EN PROCESO");
            }
            if (ventaSelected.getActivo() == 2) {
                ESTADO.setText("COMPLETADO");
            }
    }               
    }//GEN-LAST:event_TerminarVentaNuevaVentaActionPerformed

    private void INICIAR_Y_CONTINUARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INICIAR_Y_CONTINUARActionPerformed
        // TODO add your handling code here:
        if (clienteSelected != null) { //.getId() >0
             System.out.println("pppp-------"+ clienteSelected.getNombres());
            //MsgPanel.success("clienteSelected:" + clienteSelected.getNombres());
            if (ventaSelected != null) {
                System.out.println("vvv-------"+ clienteSelected.getNombres());
                paintTable(new DetalleVentaTablaModelo(ventaSelected));
              //  MsgPanel.success("venta id:" + ventaSelected.getId() + "  existente de " + ventaSelected.getCliente_nombre() + " idcli:" + clienteSelected.getId());

            } else {
                ventaSelected = null;
                 System.out.println("else-------"+clienteSelected.getId()+ " NBombre"+clienteSelected.getNombres());
                Venta d = new Venta();
                d.setCliente_id(clienteSelected.getId());
                d.setCliente_nombre(clienteSelected.getNombres());
                int ventaId = VentaData.create(d);
                if (ventaId > 0) {
                    ventaSelected = VentaData.getByPId(ventaId);
                   // MsgPanel.success("venta id:" + ventaSelected.getId() + " creado para " + ventaSelected.getCliente_nombre()+ " idcli:" + clienteSelected.getId());

                    paintTable(new DetalleVentaTablaModelo(ventaSelected));
                } else {

                    ventaSelected = null;
                    MsgPanel.error("No se pudo crear la venta para idcli:" + clienteSelected.getId(), true);
                }

            }

            //new
            if (ventaSelected != null) {
                System.out.printf("ventaSelected \n");
                double sal = sumRow(this.dvtm, 4); //CompraDetData.getSaldosByCompId(compraSelected.getId());
                TOTAL.setText(new DecimalFormat(Config.DEFAULT_DECIMAL_STRING_FORMAT).format(sal));
            } else {
                System.out.printf("venta no Selected \n");
                TOTAL.setText("0");

            }

        } else {
            MsgPanel.error("Elija un cliente", true);
        }
    }//GEN-LAST:event_INICIAR_Y_CONTINUARActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            clienteSelected = (Cliente) jComboBox1.getSelectedItem();
            int id = clienteSelected.getId();
            if (id > 0) {
                List<Venta> ventasDelCliente = VentaData.listActivesByCliente(clienteSelected.getId());
                if (ventasDelCliente.size() > 0) {
                    int ventaId = ventasDelCliente.get(0).getId();// coge el primero
                    ventaSelected = VentaData.getByPId(ventaId);
                  //  MsgPanel.success(" ventaSelected: " + ventaSelected.getId() + " de " + ventaSelected.getCliente_nombre()+ " continuar con la venta");
                } else {
                    ESTADO.setText("");
                    ventaSelected = null;

                   // MsgPanel.success(" cliente: " + clienteSelected + " sin ventas pendientes, se va crear nueva venta");

                }
                TablaVentas.setEnabled(true);
                esActualizacion = true;
                // cmbProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
                // MsgPanel.error("");
                paintTable(new DetalleVentaTablaModelo());
                System.out.println("verrr" + clienteSelected);
            } else {
                ESTADO.setText("");
                MsgPanel.success("seleccione cliente");
                clienteSelected = null;
                TablaVentas.setEnabled(false);
                paintTable(new DetalleVentaTablaModelo());

            }
        }
        tableHandlerEvent();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarActionPerformed
        
    }//GEN-LAST:event_exportarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ESTADO;
    private nuevo.igu.modelo.button.TheButton INICIAR_Y_CONTINUAR;
    private javax.swing.JLabel TOTAL;
    private javax.swing.JTable TablaVentas;
    private nuevo.igu.modelo.button.TheButton TerminarVentaNuevaVenta;
    private javax.swing.JLabel USER;
    private nuevo.igu.modelo.button.TheButton exportar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
