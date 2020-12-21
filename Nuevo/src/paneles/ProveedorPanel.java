  package paneles;

import data.ProveedorData;
import entidades.Proveedor;
import java.io.IOException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import nuevo.igu.modelo.proveedor.TablaModeloProveedor;
import nuevo.igu.modelo.tablas.ExportarExcel;
import utils.ErrorLogger;
import utils.MsgPanel;

public class ProveedorPanel extends javax.swing.JPanel {

    /**
     * Creates new form Cliente
     */
    private TablaModeloProveedor tablaModeloProveedor;
    public ProveedorPanel() {
        initComponents();
        //table.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        //table.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        TablaProveedor.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resetForm();
        tablaModeloProveedor = new TablaModeloProveedor();
        paintTable(tablaModeloProveedor);
    }
    private void resetForm() {
     
        
        NombresProveedor.requestFocus();
        NombresProveedor.setText("");
        NombresProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));

        ApellidosProveedor.requestFocus();
        ApellidosProveedor.setText("");
        ApellidosProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));

        telefonoProveedor.requestFocus();
        telefonoProveedor.setText("");
        telefonoProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
        
        sexoProveedor.requestFocus();
        sexoProveedor.setText("");
        sexoProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));

        rucProveedor.requestFocus();
        rucProveedor.setText("");
        rucProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));

        ModificarGuardarProveedor.setText("Registrar");
        ModificarGuardarProveedor.setToolTipText("Registrar");

    }
     private void paintTable(TablaModeloProveedor tableModel) {
        this.tablaModeloProveedor = tableModel;
        TablaProveedor.setModel(tableModel);
        TablaProveedor.getColumnModel().getColumn(0).setMaxWidth(35);
    }
     private void paintForm() {
        if (TablaProveedor.getSelectedRow() != -1) {
            Proveedor filax = (Proveedor) tablaModeloProveedor.getRow(TablaProveedor.getSelectedRow());
            Proveedor prov = ProveedorData.getByPId(filax.getIdProveedor());
            

            NombresProveedor.setText(prov.getNombreProveedor());
            NombresProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
            
            ApellidosProveedor.setText(prov.getApellidoProveedor());
            ApellidosProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
            
            /*telefonoProveedor.setText(prov.getTelefono()));
            telefonoProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));*/
            
            sexoProveedor.setText(prov.getSexo());
            sexoProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
            
            /*rucProveedor.setText(prov.getRuc()));
            rucProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));*/
  
            
            System.out.printf("getId:%d getSelectedRow:%d \n", prov.getIdProveedor(), TablaProveedor.getSelectedRow());

            ModificarGuardarProveedor.setText("Modificar");
            ModificarGuardarProveedor.setToolTipText("Modificar");
            MsgPanel.error("");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        NombresProveedor = new javax.swing.JTextField();
        msgPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        NuevoProveedor = new nuevo.igu.modelo.button.TheButton();
        EliminarProveedor = new nuevo.igu.modelo.button.TheButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        telefonoProveedor = new javax.swing.JTextField();
        rucProveedor = new javax.swing.JTextField();
        ApellidosProveedor = new javax.swing.JTextField();
        ModificarGuardarProveedor = new nuevo.igu.modelo.button.TheButton();
        sexoProveedor = new javax.swing.JTextField();
        BuscarProveedorTextField = new javax.swing.JTextField();
        ExportProveedor = new nuevo.igu.modelo.button.TheButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProveedor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(0, 204, 153));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PROVEEDOR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 153));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(0, 204, 153));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRES:");

        NombresProveedor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        NombresProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NombresProveedorKeyReleased(evt);
            }
        });

        msgPanel.setBackground(new java.awt.Color(0, 204, 153));

        javax.swing.GroupLayout msgPanelLayout = new javax.swing.GroupLayout(msgPanel);
        msgPanel.setLayout(msgPanelLayout);
        msgPanelLayout.setHorizontalGroup(
            msgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );
        msgPanelLayout.setVerticalGroup(
            msgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 204, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
        );

        NuevoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.png"))); // NOI18N
        NuevoProveedor.setText("Nuevo");
        NuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoProveedorActionPerformed(evt);
            }
        });

        EliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        EliminarProveedor.setText("Eliminar");
        EliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProveedorActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("APELLIDOS:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TELEFONO:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SEXO:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("RUC: ");

        telefonoProveedor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        telefonoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoProveedorActionPerformed(evt);
            }
        });

        rucProveedor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rucProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rucProveedorActionPerformed(evt);
            }
        });

        ApellidosProveedor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ApellidosProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidosProveedorActionPerformed(evt);
            }
        });

        ModificarGuardarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        ModificarGuardarProveedor.setText("Guardar");
        ModificarGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarGuardarProveedorActionPerformed(evt);
            }
        });

        sexoProveedor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sexoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NombresProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ApellidosProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(telefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModificarGuardarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(EliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ModificarGuardarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(msgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombresProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ApellidosProveedor)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexoProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BuscarProveedorTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BuscarProveedorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarProveedorTextFieldActionPerformed(evt);
            }
        });

        ExportProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/excel.png"))); // NOI18N
        ExportProveedor.setText("Excel");
        ExportProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportProveedorActionPerformed(evt);
            }
        });

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 0), new java.awt.Color(204, 51, 0), new java.awt.Color(102, 102, 255), new java.awt.Color(153, 255, 153)));

        TablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProveedorMouseClicked(evt);
            }
        });
        TablaProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TablaProveedorKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProveedor);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BuscarProveedorTextField)
                            .addComponent(ExportProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BuscarProveedorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ExportProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void ApellidosProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidosProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidosProveedorActionPerformed

    private void rucProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rucProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rucProveedorActionPerformed

    private void telefonoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoProveedorActionPerformed

    private void ExportProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportProveedorActionPerformed

        //PrinterTable.imprime(table, "Hola", "foot", true);
        try {
            ExportarExcel obj = new ExportarExcel();
            obj.exportarExcel(TablaProveedor);
        } catch (IOException ex) {
            ErrorLogger.log(Level.SEVERE, ProveedorPanel.class.getName() + ".ExportarExcel", ex);
        }
    }//GEN-LAST:event_ExportProveedorActionPerformed

    private void EliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProveedorActionPerformed
         if (TablaProveedor.getSelectedRow() != -1) {
            try {
                int opc = JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar?", "Quitar", JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.OK_OPTION) {
                    Proveedor fila = (Proveedor) tablaModeloProveedor.getRow(TablaProveedor.getSelectedRow());
                    System.out.printf("eliminarButtonActionPerformed getId:%d getSelectedRow:%d \n", fila.getIdProveedor(), TablaProveedor.getSelectedRow());

                    int opcion = ProveedorData.delete(fila.getIdProveedor());
                    if (opcion != 0) {
                        //tableModel.removeRow(table.getSelectedRow());
                        paintTable(new TablaModeloProveedor());
                        resetForm();
                        MsgPanel.success("Se ha eliminado a:" + fila.getNombreProveedor());
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registo de la tabla");
        }
    }//GEN-LAST:event_EliminarProveedorActionPerformed

    private void ModificarGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarGuardarProveedorActionPerformed

        if (NombresProveedor.getText().trim().isEmpty()) {
            NombresProveedor.requestFocus();
            NombresProveedor.setBorder(new LineBorder(new java.awt.Color(255, 0, 0), 5));
            ApellidosProveedor.setBorder(new LineBorder(new java.awt.Color(255, 0, 0), 5));
            rucProveedor.setBorder(new LineBorder(new java.awt.Color(255, 0, 0), 5));
            MsgPanel.error("Nombre es requerido", true);
        } else {
            Proveedor prov = new Proveedor();
            
            prov.setNombreProveedor(NombresProveedor.getText());
            prov.setApellidoProveedor(ApellidosProveedor.getText());
            if (telefonoProveedor.getText().equals("")) {
                telefonoProveedor.setText("0");
            }
            prov.setTelefono(Double.parseDouble(telefonoProveedor.getText().replaceAll(",", "")));
            
            prov.setSexo(sexoProveedor.getText());
            
            if (rucProveedor.getText().equals("")) {
                rucProveedor.setText("0");
            }
            prov.setRuc(Double.parseDouble(rucProveedor.getText().replaceAll(",", "")));

            
            if (TablaProveedor.getSelectedRow() != -1) {// ha seleccionado, update
                try {
                    Proveedor fila = (Proveedor) tablaModeloProveedor.getRow(TablaProveedor.getSelectedRow());
                    prov.setIdProveedor(fila.getIdProveedor());
                    System.out.println("id:" + prov.getIdProveedor());
                    if (prov.getIdProveedor()> 0) {
                        int returnId = ProveedorData.update(prov);
                        if (returnId != 0) {
                            paintTable(new TablaModeloProveedor());
                            resetForm();
                            MsgPanel.success(" Se ha modificado a:" + prov.getNombreProveedor());
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se puede editar: " + ex.getMessage());
                }
            } else { // sin seleccionar, insert
                try {
                    int returnId = ProveedorData.create(prov);
                    if (returnId != 0) {
                        paintTable(new TablaModeloProveedor());
                        // s.setId(returnId);//necesitamos subir el id, ya no
                        //tableModel.addRow(s);
                        resetForm();
                        MsgPanel.success("Se ha registrado a:" + prov.getNombreProveedor());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se puede insertar: " + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_ModificarGuardarProveedorActionPerformed

    private void sexoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexoProveedorActionPerformed

    private void NuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoProveedorActionPerformed
        resetForm();
        TablaProveedor.clearSelection();
        ModificarGuardarProveedor.setText("Registrar");
        ModificarGuardarProveedor.setToolTipText("Registrar");
    }//GEN-LAST:event_NuevoProveedorActionPerformed

    private void NombresProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombresProveedorKeyReleased
        if (!NombresProveedor.getText().trim().isEmpty()) { //reset
            NombresProveedor.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));

        } else {
            NombresProveedor.setBorder(new LineBorder(new java.awt.Color(255, 0, 0), 3));
            MsgPanel.error("Nombre es requerido", true);
        }
    }//GEN-LAST:event_NombresProveedorKeyReleased

    private void TablaProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaProveedorKeyReleased
        // TODO add your handling code here:
        paintForm();
    }//GEN-LAST:event_TablaProveedorKeyReleased

    private void TablaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProveedorMouseClicked
        // TODO add your handling code here:
        paintForm();
    }//GEN-LAST:event_TablaProveedorMouseClicked

    private void BuscarProveedorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarProveedorTextFieldActionPerformed
        // TODO add your handling code here:
        TablaModeloProveedor tableModel = new TablaModeloProveedor(BuscarProveedorTextField.getText());
        paintTable(tableModel);
    }//GEN-LAST:event_BuscarProveedorTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApellidosProveedor;
    private javax.swing.JTextField BuscarProveedorTextField;
    private nuevo.igu.modelo.button.TheButton EliminarProveedor;
    private nuevo.igu.modelo.button.TheButton ExportProveedor;
    private nuevo.igu.modelo.button.TheButton ModificarGuardarProveedor;
    private javax.swing.JTextField NombresProveedor;
    private nuevo.igu.modelo.button.TheButton NuevoProveedor;
    private javax.swing.JTable TablaProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel msgPanel;
    private javax.swing.JTextField rucProveedor;
    private javax.swing.JTextField sexoProveedor;
    private javax.swing.JTextField telefonoProveedor;
    // End of variables declaration//GEN-END:variables
}
