package nuevo.igu;

import entidades.Cliente;
import java.awt.Color;
import paneles.CategoriaPanel;
import paneles.ClientePanel;
import paneles.ProductoPanel;
import paneles.ProveedorPanel;
import utils.ChangePanel;
import paneles.VentasPanel;
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        PRODUCTOS = new nuevo.igu.modelo.button.TheButton();
        CLIENTES = new nuevo.igu.modelo.button.TheButton();
        PROVEEDORES = new nuevo.igu.modelo.button.TheButton();
        VENTAS = new nuevo.igu.modelo.button.TheButton();
        COMPRA_PRO = new nuevo.igu.modelo.button.TheButton();
        CATEGORIA = new nuevo.igu.modelo.button.TheButton();
        Escritorio = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        PRODUCTOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Productos.png"))); // NOI18N
        PRODUCTOS.setText("Productos");
        PRODUCTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRODUCTOSActionPerformed(evt);
            }
        });

        CLIENTES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Clientes.png"))); // NOI18N
        CLIENTES.setText("Clientes");
        CLIENTES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CLIENTESMousePressed(evt);
            }
        });
        CLIENTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLIENTESActionPerformed(evt);
            }
        });

        PROVEEDORES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Proveedor.png"))); // NOI18N
        PROVEEDORES.setText("Proveedores");
        PROVEEDORES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PROVEEDORESActionPerformed(evt);
            }
        });

        VENTAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ventas.png"))); // NOI18N
        VENTAS.setText("Ventas");
        VENTAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VENTASActionPerformed(evt);
            }
        });

        COMPRA_PRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Compra.png"))); // NOI18N
        COMPRA_PRO.setText("Compra Pro.");
        COMPRA_PRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COMPRA_PROActionPerformed(evt);
            }
        });

        CATEGORIA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Categoria.png"))); // NOI18N
        CATEGORIA.setText("Categoría");
        CATEGORIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CATEGORIAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PRODUCTOS, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLIENTES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PROVEEDORES, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VENTAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(COMPRA_PRO, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PRODUCTOS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addComponent(CLIENTES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PROVEEDORES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(VENTAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(COMPRA_PRO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CATEGORIA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Escritorio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Escritorio.setLayout(new javax.swing.BoxLayout(Escritorio, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void COMPRA_PROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COMPRA_PROActionPerformed
        
    }//GEN-LAST:event_COMPRA_PROActionPerformed

    private void CLIENTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLIENTESActionPerformed
    
        new ChangePanel(Escritorio, new ClientePanel());
    
        
        if (this.CLIENTES.isSelected()) {
            this.CLIENTES.setColorNormal(new Color(204, 204, 204));

            this.PRODUCTOS.setColorNormal(new Color(239, 238, 244));
            this.PROVEEDORES.setColorNormal(new Color(239, 238, 244));
            this.COMPRA_PRO.setColorNormal(new Color(239, 238, 244));
            this.CATEGORIA.setColorNormal(new Color(239, 238, 244));
            this.VENTAS.setColorNormal(new Color(239, 238, 244));

        } else {
            this.CLIENTES.setColorNormal(new Color(239, 238, 244));
        }
    }//GEN-LAST:event_CLIENTESActionPerformed

    private void CLIENTESMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLIENTESMousePressed
        // TODO add your handling code here:
        this.CLIENTES.setSelected(true);
        this.PRODUCTOS.setSelected(false);
        this.PROVEEDORES.setSelected(false);
        this.COMPRA_PRO.setSelected(false);
        this.CATEGORIA.setSelected(false);
        this.VENTAS.setSelected(false);
    }//GEN-LAST:event_CLIENTESMousePressed

    private void PRODUCTOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRODUCTOSActionPerformed
        // TODO add your handling code here:
        new ChangePanel(Escritorio, new ProductoPanel());
    }//GEN-LAST:event_PRODUCTOSActionPerformed

    private void VENTASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VENTASActionPerformed
        // TODO add your handling code here:
        new ChangePanel(Escritorio, new VentasPanel());
    }//GEN-LAST:event_VENTASActionPerformed

    private void PROVEEDORESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PROVEEDORESActionPerformed
        // TODO add your handling code here:
        new ChangePanel(Escritorio, new ProveedorPanel());
    }//GEN-LAST:event_PROVEEDORESActionPerformed

    private void CATEGORIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CATEGORIAActionPerformed
        // TODO add your handling code here:
        new ChangePanel(Escritorio, new CategoriaPanel());
    }//GEN-LAST:event_CATEGORIAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private nuevo.igu.modelo.button.TheButton CATEGORIA;
    private nuevo.igu.modelo.button.TheButton CLIENTES;
    private nuevo.igu.modelo.button.TheButton COMPRA_PRO;
    public static javax.swing.JPanel Escritorio;
    private nuevo.igu.modelo.button.TheButton PRODUCTOS;
    private nuevo.igu.modelo.button.TheButton PROVEEDORES;
    private javax.swing.JPanel PanelPrincipal;
    private nuevo.igu.modelo.button.TheButton VENTAS;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
