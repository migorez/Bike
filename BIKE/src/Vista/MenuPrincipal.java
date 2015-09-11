
package Vista;

import Controlador.Graficos;
import RecursosTemporales.GUsers;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 * author  : miguel, braden, never
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private final String[] columnas_tabla;
    private final Class[] tiposCampos;
    private DefaultTableModel dtm_tabla_actividades;
    private int fila_tabla, col_tabla;
    
    private class PanelBotonesCelda extends JPanel {
        // <editor-fold defaultstate="collapsed" desc="JPANEL PARA CELDA DE TABLA">
        
        // Variables declaration                    
        private final CellTableButton btncell_cancel_orden_;
        private final CellTableButton btncell_edit_orden_;
        private final CellTableButton btncell_ok_orden_;
        public int miFila, miCol;
        // End of variables declaration 
        
        /**
         * Creates new form PanelBotonesCelda
         */
        public PanelBotonesCelda() {
            btncell_cancel_orden_ = new CellTableButton();
            btncell_edit_orden_ = new CellTableButton();
            btncell_ok_orden_ = new CellTableButton();
            inicializacion();
        }

        /**
         * este metodo es llamado al inicializar el panel
         * este configura las cosas basicas
         */
        @SuppressWarnings("unchecked")
        private void inicializacion() {
            // <editor-fold defaultstate="collapsed" desc="Codigo Generado Automaticamente por el Disenador Netbeans">                          
            try {
                setLayout(new java.awt.GridLayout());
                
                //btncell_cancel_orden_.setIcon(new javax.swing.ImageIcon(getClass().getResource("../Recursos/imgs/imgbtn_cancel.png"))); // NOI18N
                btncell_cancel_orden_.setPreferredSize(new java.awt.Dimension(35, 35));
                add(btncell_cancel_orden_);

                //btncell_edit_orden_.setIcon(new javax.swing.ImageIcon(getClass().getResource("../Recursos/imgs/imgbtn_edit.png"))); // NOI18N
                btncell_edit_orden_.setPreferredSize(new java.awt.Dimension(35, 35));
                add(btncell_edit_orden_);

                //btncell_ok_orden_.setIcon(new javax.swing.ImageIcon(getClass().getResource("../Recursos/imgs/imgbtn_ok.png"))); // NOI18N
                btncell_ok_orden_.setPreferredSize(new java.awt.Dimension(35, 35));
                add(btncell_ok_orden_);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }// </editor-fold>
        }                       

        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="CLASES INTERNAS DEL PANEL">
        private class CellTableButton extends JButton implements /*TableCellEditor,*/ ActionListener {
            // <editor-fold defaultstate="collapsed" desc="CLASE EXTENDIDA DE JBUTTON CONFIGURADA PARA INSERTAR BOTONES EN CELDAS DE UNA TABLA">
            //fuentes
            //http://www.edu4java.com/es/swing/swing4.html
            //http://stackoverflow.com/questions/1475543/how-to-add-button-in-a-row-of-jtable-in-swing-java

            //private int fil, col;
            //<editor-fold defaultstate="collapsed" desc="METODOS DE CONSTRUCCION Y CONFIGURACION DE ESTA CLASE DE BOTON">
            public CellTableButton() {
                super();
                metodoConstructorGeneral();
            }
            
            public CellTableButton(String text) {
                super(text);
                metodoConstructorGeneral();
            }
            
            private void metodoConstructorGeneral() {
                addActionListener(this);
            }
            
            @Override
            public void paint(Graphics grf) {
                super.paint(grf);
            }
            
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(15, 10);
            }
//</editor-fold>

            //Action Listener => metodo que se desata al accionar el boton u oprimirlo
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Haz oprimido el boton de la celda (" + miFila + ", " + miCol + ")");
            }

            // <editor-fold defaultstate="collapsed" desc="METODOS IMPLEMENTADOS DE LA INTERFAZ TableCellEditor del Boton">
        /*@Override
             public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
             MenuPrincipal.fila_tabla = row;
             MenuPrincipal.col_tabla = column;
             return this;
             }

             @Override
             public Object getCellEditorValue() {
             return "Configurado";
             }

             @Override
             public boolean isCellEditable(EventObject anEvent) {
             return true;
             }

             @Override
             public boolean shouldSelectCell(EventObject anEvent) {
             return true;
             }

             @Override
             public boolean stopCellEditing() {
             return true;
             }

             @Override
             public void cancelCellEditing() {
             }

             @Override
             public void addCellEditorListener(CellEditorListener l) {
             }

             @Override
             public void removeCellEditorListener(CellEditorListener l) {
             }
             */
            // </editor-fold>
            // </editor-fold>
        }

// </editor-fold>
    }
    
    private static class ComponentCellRenderer implements TableCellRenderer {
        // <editor-fold defaultstate="collapsed" desc="CLASE QUE DIBUJA EL COMPONENTE DENTRO DE LA CELDA DE LA TABLA">

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            /*if(hasFocus == true){
             table.repaint();
             }*/
            return (Component) value;
        }

        // </editor-fold>
    }
    
    private static class ComponentCellEditor extends AbstractCellEditor implements TableCellEditor/*, ActionListener*/ {
        // <editor-fold defaultstate="collapsed" desc="CLASE QUE LE DA LA CAPACIDAD AL COMPONENTE DE EDITAR EL VALOR DE LA CELDA">

        public ComponentCellEditor(){
            
        }
        
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if(column == 5){
                ((PanelBotonesCelda)value).miFila = row;
                ((PanelBotonesCelda)value).miCol = column;
                return (Component) value;
            }
            return (Component) value;
        }

        @Override
        public Object getCellEditorValue() {
            return "CellEditorValue";//combo.getSelectedItem().toString();
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean stopCellEditing() {
            return true;
        }

        @Override
        public void cancelCellEditing() {
            System.out.println("Edicion Cancelada");
        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {
        
        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {
            System.out.println("removeCellEditorListener");
        }

// </editor-fold>
    }
    
    /** Creates new form MenuPrincipal */
    public MenuPrincipal() {
        initComponents();
        
        //configuracion de la tabla
        tiposCampos = new Class[]{
            String.class,
            Boolean.class,
            TextArea.class,
            //Date.class,
            String.class,
            String.class,
            PanelBotonesCelda.class
        };
        columnas_tabla =  new String[]{
            "Empleado", "Activo", "Última Tarea", "Inicio", "Entrega", "Accion" 
        };
        
        tabla_actividades.setDefaultRenderer(PanelBotonesCelda.class, new ComponentCellRenderer());
        tabla_actividades.setDefaultEditor(PanelBotonesCelda.class, new ComponentCellEditor());

        // <editor-fold defaultstate="collapsed" desc="Configuracion de la Ventana">
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
    // </editor-fold>
       
        //uso del metodo
        refrescarTablaActividades();
        //--
    }
    
    //definicion del metodo
    private void refrescarTablaActividades(){
        //tuto perfecto para aprender a insertar botones en una celda de cualquier tabla -> https://www.youtube.com/watch?v=bVknuhawXsI
        Object[][] datos = new Object[][]{
            {"Miguel Gonzalez", true, "5 '26 TT Tradicional", "27/may/15 10:30", "", new PanelBotonesCelda()},
            {"Jerry Gutierrez", true, "30 Aros '20 Econo", "26/may/15 11:25", "", new PanelBotonesCelda()},
            {"David Murcia Guzman", true, "20 Aros '20 Econo", "26/may/15 11:25", "", new PanelBotonesCelda()},
            {"Carlos Trujillo", true, "20 Aros '20 Econo", "26/may/15 11:25", "", new PanelBotonesCelda()}
        };
        tabla_actividades.setModel(new DefaultTableModel(datos, columnas_tabla){
            @Override
            public Class getColumnClass(int columnIndex) {
                return tiposCampos[columnIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class));
            }
        });

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        scroll_tabla_acts = new javax.swing.JScrollPane();
        tabla_actividades = new javax.swing.JTable();
        btn_empleados_ = new javax.swing.JButton();
        btn_produccion_ = new javax.swing.JButton();
        btn_inventario_ = new javax.swing.JButton();
        btn_revision_ = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtview_fecha_actual = new javax.swing.JTextField();
        barraMenu_1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        mnuArchivo_newOrden = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuMercancia_ = new javax.swing.JMenu();
        mnuTareas_nuevaOrden_ = new javax.swing.JMenuItem();
        GestionMercancia_ = new javax.swing.JMenuItem();
        mnuProveedores_ = new javax.swing.JMenu();
        GestionProveedores_ = new javax.swing.JMenuItem();
        mnuGUsers_ = new javax.swing.JMenu();
        GestionUsuarios_ = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(26, 105, 159));
        escritorio.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        escritorio.setAutoscrolls(true);
        escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        scroll_tabla_acts.setAutoscrolls(true);

        tabla_actividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_actividades.getTableHeader().setReorderingAllowed(false);
        tabla_actividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_actividadesMouseClicked(evt);
            }
        });
        scroll_tabla_acts.setViewportView(tabla_actividades);

        btn_empleados_.setText("Empleados");
        btn_empleados_.setMaximumSize(new java.awt.Dimension(150, 80));
        btn_empleados_.setMinimumSize(new java.awt.Dimension(150, 80));
        btn_empleados_.setPreferredSize(new java.awt.Dimension(150, 80));

        btn_produccion_.setText("Produccion");
        btn_produccion_.setMaximumSize(new java.awt.Dimension(150, 80));
        btn_produccion_.setMinimumSize(new java.awt.Dimension(150, 80));
        btn_produccion_.setPreferredSize(new java.awt.Dimension(150, 80));

        btn_inventario_.setText("Inventario");
        btn_inventario_.setMaximumSize(new java.awt.Dimension(150, 80));
        btn_inventario_.setMinimumSize(new java.awt.Dimension(150, 80));
        btn_inventario_.setPreferredSize(new java.awt.Dimension(150, 80));

        btn_revision_.setText("Revisiones");
        btn_revision_.setMaximumSize(new java.awt.Dimension(150, 80));
        btn_revision_.setMinimumSize(new java.awt.Dimension(150, 80));
        btn_revision_.setPreferredSize(new java.awt.Dimension(150, 80));

        jPanel1.setPreferredSize(new java.awt.Dimension(210, 210));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        txtview_fecha_actual.setEditable(false);
        txtview_fecha_actual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtview_fecha_actual.setText("23/07/2016");
        txtview_fecha_actual.setToolTipText("Fecha de Hoy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtview_fecha_actual, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtview_fecha_actual, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(scroll_tabla_acts, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_empleados_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btn_produccion_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btn_inventario_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btn_revision_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(scroll_tabla_acts, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_empleados_, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_produccion_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_inventario_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_revision_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        escritorio.setLayer(scroll_tabla_acts, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btn_empleados_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btn_produccion_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btn_inventario_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btn_revision_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu3.setText("Archivo");

        mnuArchivo_newOrden.setText("Parametrizacion");
        mnuArchivo_newOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivo_newOrdenActionPerformed(evt);
            }
        });
        jMenu3.add(mnuArchivo_newOrden);

        jMenuItem1.setText("Nuevo Empleado");
        jMenu3.add(jMenuItem1);

        jMenuItem3.setText("Cerrar");
        jMenu3.add(jMenuItem3);

        barraMenu_1.add(jMenu3);

        mnuMercancia_.setText("Tareas");

        mnuTareas_nuevaOrden_.setText("Nueva Orden");
        mnuTareas_nuevaOrden_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTareas_nuevaOrden_ActionPerformed(evt);
            }
        });
        mnuMercancia_.add(mnuTareas_nuevaOrden_);

        GestionMercancia_.setText("Revisar Despachos");
        GestionMercancia_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionMercancia_ActionPerformed(evt);
            }
        });
        mnuMercancia_.add(GestionMercancia_);

        barraMenu_1.add(mnuMercancia_);

        mnuProveedores_.setText("Almacen");

        GestionProveedores_.setText("Stock");
        GestionProveedores_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionProveedores_ActionPerformed(evt);
            }
        });
        mnuProveedores_.add(GestionProveedores_);

        barraMenu_1.add(mnuProveedores_);

        mnuGUsers_.setText("Herramientas");

        GestionUsuarios_.setText("Apariencia");
        GestionUsuarios_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionUsuarios_ActionPerformed(evt);
            }
        });
        mnuGUsers_.add(GestionUsuarios_);

        barraMenu_1.add(mnuGUsers_);

        setJMenuBar(barraMenu_1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuArchivo_newOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivo_newOrdenActionPerformed
        // TODO add your handling code here:
        
        OrdenProduccion clnt = new OrdenProduccion();
        escritorio.add(clnt);
        clnt.setVisible(true);
        clnt.toFront();

    }//GEN-LAST:event_mnuArchivo_newOrdenActionPerformed

    private void GestionUsuarios_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionUsuarios_ActionPerformed
        // TODO add your handling code here:
        
        GUsers usr = new GUsers();
        //agrega al escritorio o mas bien desktoppane la ventana de clientes.
        escritorio.add(usr);
        //Hace visible el formulario de clientes.
        usr.setVisible(true);
        //envia el formulario de clientes al frente.
        usr.toFront();
        
    }//GEN-LAST:event_GestionUsuarios_ActionPerformed

    private void GestionMercancia_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionMercancia_ActionPerformed
        // TODO add your handling code here:
        
        GestionEmpleados merc = new GestionEmpleados();
        escritorio.add(merc);
        merc.setVisible(true);
        merc.toFront();
        
    }//GEN-LAST:event_GestionMercancia_ActionPerformed

    private void GestionProveedores_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionProveedores_ActionPerformed
        // TODO add your handling code here:
        
        Inventarios prov = new Inventarios();
        escritorio.add(prov);
        prov.setVisible(true);
        prov.toFront();
        
    }//GEN-LAST:event_GestionProveedores_ActionPerformed

    private void mnuTareas_nuevaOrden_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTareas_nuevaOrden_ActionPerformed
        
        OrdenProduccion orden = new OrdenProduccion();
        escritorio.add(orden);
        orden.setVisible(true);
        orden.toFront();
        
    }//GEN-LAST:event_mnuTareas_nuevaOrden_ActionPerformed

    private void tabla_actividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_actividadesMouseClicked
        
        fila_tabla = tabla_actividades.rowAtPoint(evt.getPoint());
        col_tabla = tabla_actividades.columnAtPoint(evt.getPoint());
        
    }//GEN-LAST:event_tabla_actividadesMouseClicked

    public static void main(String args[]) {
        // Set the Nimbus look and feel
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        // If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        // For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        // Create and display the form
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem GestionMercancia_;
    private javax.swing.JMenuItem GestionProveedores_;
    private javax.swing.JMenuItem GestionUsuarios_;
    private javax.swing.JMenuBar barraMenu_1;
    private javax.swing.JButton btn_empleados_;
    private javax.swing.JButton btn_inventario_;
    private javax.swing.JButton btn_produccion_;
    private javax.swing.JButton btn_revision_;
    public static final javax.swing.JDesktopPane escritorio = new Graficos.Escritorio();
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem mnuArchivo_newOrden;
    private javax.swing.JMenu mnuGUsers_;
    private javax.swing.JMenu mnuMercancia_;
    private javax.swing.JMenu mnuProveedores_;
    private javax.swing.JMenuItem mnuTareas_nuevaOrden_;
    private javax.swing.JScrollPane scroll_tabla_acts;
    private javax.swing.JTable tabla_actividades;
    private javax.swing.JTextField txtview_fecha_actual;
    // End of variables declaration//GEN-END:variables

}
