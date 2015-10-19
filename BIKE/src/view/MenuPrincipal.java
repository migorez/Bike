
package view;

import controller.componentes.Paneles;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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

    private final String[] columnas_tabla =  new String[]{"Empleado", "Activo", "Última Tarea", "Inicio", "Entrega", "Accion"};
    private final Class[] tiposCampos = new Class[]{String.class, Boolean.class, TextArea.class, /*Date.class*/ String.class, String.class, PanelBotonesCelda.class};
    //private DefaultTableModel dtm_tabla_actividades;
    private int fila_tabla, col_tabla;
    
    //VENTANAS INTERNAS
    public OrdenProduccion ordenProduccion;
    public ComponenteArticulo controlRepuestos;
    //----
    
    /** Creates new form MenuPrincipal */
    public MenuPrincipal() {
        initComponents();
        
        this.setTitle("MT BIKE");
        
        //configuracion de la tabla
        
        
        
        tabla_actividades.setDefaultRenderer(PanelBotonesCelda.class, new ComponentCellRenderer());
        tabla_actividades.setDefaultEditor(PanelBotonesCelda.class, new ComponentCellEditor());
        
        // <editor-fold defaultstate="collapsed" desc="Configuracion de la Ventana">
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
    // </editor-fold>
       
        //uso del metodo
        refrescarTablaActividades();
        formatearTabla();
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
        boolean[] colsEditables = new boolean[]{false, true, false, false, false, true};
        tabla_actividades.setModel(new DefaultTableModel(datos, columnas_tabla){
            @Override
            public Class getColumnClass(int columnIndex) {
                return tiposCampos[columnIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return colsEditables[column];
            }
        });

    }
    
    private void formatearTabla(){
        int anchoContenedor = scroll_tabla_acts.getWidth();
        int[] anchos = new int[]{((anchoContenedor*16)/100), ((anchoContenedor*9)/100), ((anchoContenedor*30)/100), ((anchoContenedor*15)/100), ((anchoContenedor*15)/100), ((anchoContenedor*15)/100)};
        for(int i = 0; i < tabla_actividades.getColumnCount(); i++){
            tabla_actividades.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            tabla_actividades.getColumnModel().getColumn(i).setMinWidth(anchos[i]);
            tabla_actividades.getColumnModel().getColumn(i).setMaxWidth(anchos[i]);
        }
        tabla_actividades.setRowHeight(40);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_tabla_acts = new javax.swing.JScrollPane();
        tabla_actividades = new javax.swing.JTable();
        btn_empleados_ = new javax.swing.JButton();
        btn_produccion_ = new javax.swing.JButton();
        btn_inventario_ = new javax.swing.JButton();
        btn_revision_ = new javax.swing.JButton();
        panel_reloj_ = new controller.PanelReloj();
        panel_fecha_ = new javax.swing.JPanel();
        txtview_fecha_actual = new javax.swing.JTextField();
        barra_menu_1 = new javax.swing.JMenuBar();
        menu_archivo_ = new javax.swing.JMenu();
        menu_item_parametrizacion_ = new javax.swing.JMenuItem();
        menu_item_cerrar_ = new javax.swing.JMenuItem();
        menu_tareas_ = new javax.swing.JMenu();
        menu_item_nueva_orden_ = new javax.swing.JMenuItem();
        menu_item_despachos_ = new javax.swing.JMenuItem();
        menu_almacen_ = new javax.swing.JMenu();
        menu_item_componentes_ = new javax.swing.JMenuItem();
        menu_item_articulos_ = new javax.swing.JMenuItem();
        menu_item_repuestos_ = new javax.swing.JMenuItem();
        menu_ensambladores_ = new javax.swing.JMenu();
        menu_item_reg_ensam_ = new javax.swing.JMenuItem();
        menu_item_supervis_ensam_ = new javax.swing.JMenuItem();
        menu_herramientas_ = new javax.swing.JMenu();
        menu_item_servidores_ = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(204, 204, 204));
        escritorio.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        escritorio.setAutoscrolls(true);
        escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        scroll_tabla_acts.setAutoscrolls(true);
        scroll_tabla_acts.setMaximumSize(new java.awt.Dimension(452, 402));
        scroll_tabla_acts.setMinimumSize(new java.awt.Dimension(452, 402));

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

        panel_reloj_.setBackground(new java.awt.Color(204, 204, 204));
        panel_reloj_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel_reloj_.setEnabled(false);
        panel_reloj_.setPreferredSize(new java.awt.Dimension(210, 210));

        javax.swing.GroupLayout panel_reloj_Layout = new javax.swing.GroupLayout(panel_reloj_);
        panel_reloj_.setLayout(panel_reloj_Layout);
        panel_reloj_Layout.setHorizontalGroup(
            panel_reloj_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );
        panel_reloj_Layout.setVerticalGroup(
            panel_reloj_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        txtview_fecha_actual.setEditable(false);
        txtview_fecha_actual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtview_fecha_actual.setFont(getFuenteFecha());
        txtview_fecha_actual.setText(controller.Tiempo.getStringFechaActual());
        txtview_fecha_actual.setToolTipText("Hoy: ");

        javax.swing.GroupLayout panel_fecha_Layout = new javax.swing.GroupLayout(panel_fecha_);
        panel_fecha_.setLayout(panel_fecha_Layout);
        panel_fecha_Layout.setHorizontalGroup(
            panel_fecha_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fecha_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtview_fecha_actual, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_fecha_Layout.setVerticalGroup(
            panel_fecha_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fecha_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtview_fecha_actual, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_tabla_acts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_fecha_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_reloj_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_empleados_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btn_produccion_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btn_inventario_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btn_revision_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_reloj_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(panel_fecha_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(scroll_tabla_acts, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_empleados_, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_produccion_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_inventario_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_revision_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );
        escritorio.setLayer(scroll_tabla_acts, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btn_empleados_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btn_produccion_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btn_inventario_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btn_revision_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(panel_reloj_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(panel_fecha_, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menu_archivo_.setText("Archivo");

        menu_item_parametrizacion_.setText("Parametrizacion");
        menu_item_parametrizacion_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_parametrizacion_ActionPerformed(evt);
            }
        });
        menu_archivo_.add(menu_item_parametrizacion_);

        menu_item_cerrar_.setText("Cerrar");
        menu_archivo_.add(menu_item_cerrar_);

        barra_menu_1.add(menu_archivo_);

        menu_tareas_.setText("Tareas");

        menu_item_nueva_orden_.setText("Nueva Orden");
        menu_item_nueva_orden_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_nueva_orden_ActionPerformed(evt);
            }
        });
        menu_tareas_.add(menu_item_nueva_orden_);

        menu_item_despachos_.setText("Revisar Despachos");
        menu_item_despachos_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_despachos_ActionPerformed(evt);
            }
        });
        menu_tareas_.add(menu_item_despachos_);

        barra_menu_1.add(menu_tareas_);

        menu_almacen_.setText("Almacen");

        menu_item_componentes_.setText("Componentes");
        menu_item_componentes_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_componentes_ActionPerformed(evt);
            }
        });
        menu_almacen_.add(menu_item_componentes_);

        menu_item_articulos_.setText("Articulos");
        menu_almacen_.add(menu_item_articulos_);

        menu_item_repuestos_.setText("Repuestos");
        menu_item_repuestos_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_repuestos_ActionPerformed(evt);
            }
        });
        menu_almacen_.add(menu_item_repuestos_);

        barra_menu_1.add(menu_almacen_);

        menu_ensambladores_.setText("Ensambladores");

        menu_item_reg_ensam_.setText("Registro");
        menu_ensambladores_.add(menu_item_reg_ensam_);

        menu_item_supervis_ensam_.setText("Supervision");
        menu_ensambladores_.add(menu_item_supervis_ensam_);

        barra_menu_1.add(menu_ensambladores_);

        menu_herramientas_.setText("Herramientas");

        menu_item_servidores_.setText("Servidor");
        menu_item_servidores_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_servidores_ActionPerformed(evt);
            }
        });
        menu_herramientas_.add(menu_item_servidores_);

        barra_menu_1.add(menu_herramientas_);

        setJMenuBar(barra_menu_1);

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

    //METODOS DEL PROGRAMADOR =>
    
    private Font getFuenteFecha(){
        Font letter;
        String source = "../sources/fuentes/DS-DIGI.ttf";
                //LiquidCrystal-Bold.otf";
        try{
            InputStream upload = getClass().getResourceAsStream(source);
            letter = Font.createFont(Font.TRUETYPE_FONT, upload);
            letter = letter.deriveFont(0, 58);
        }
        catch(FontFormatException | IOException ex){
            System.out.println(ex.toString());
            letter = new Font("cursive", Font.PLAIN, 18);
        }
        return letter;
    }

    
    private void menu_item_parametrizacion_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_parametrizacion_ActionPerformed


    }//GEN-LAST:event_menu_item_parametrizacion_ActionPerformed

    private void menu_item_servidores_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_servidores_ActionPerformed

    }//GEN-LAST:event_menu_item_servidores_ActionPerformed

    private void menu_item_despachos_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_despachos_ActionPerformed

    }//GEN-LAST:event_menu_item_despachos_ActionPerformed

    private void menu_item_nueva_orden_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_nueva_orden_ActionPerformed

        //try {
            if (ordenProduccion != null && ordenProduccion.isVisible()) {
                if (ordenProduccion.isIcon()) {
                   // ordenProduccion.setIcon(false);
                }
            } else {
                ordenProduccion = new OrdenProduccion();
                escritorio.add(ordenProduccion);
                ordenProduccion.setVisible(true);
            }
            ordenProduccion.toFront();
        /*} catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            //System.out.print("Excepcion localizada en: MenuPrincipal.menu_item_nueva_orden_ActionPerformed => \n"+ex.toString());
        }*/
        
    }//GEN-LAST:event_menu_item_nueva_orden_ActionPerformed

    private void tabla_actividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_actividadesMouseClicked
        
        fila_tabla = tabla_actividades.rowAtPoint(evt.getPoint());
        col_tabla = tabla_actividades.columnAtPoint(evt.getPoint());
        
    }//GEN-LAST:event_tabla_actividadesMouseClicked

    private void menu_item_componentes_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_componentes_ActionPerformed

        try {
            if (controlRepuestos != null && controlRepuestos.isVisible()) {
                if (controlRepuestos.isIcon()) {
                    controlRepuestos.setIcon(false);
                }
            } else {
                controlRepuestos = new ComponenteArticulo();
                escritorio.add(controlRepuestos);
                controlRepuestos.setVisible(true);
            }
            controlRepuestos.toFront();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }//GEN-LAST:event_menu_item_componentes_ActionPerformed

    private void menu_item_repuestos_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_repuestos_ActionPerformed
        
        
        
    }//GEN-LAST:event_menu_item_repuestos_ActionPerformed
   
//CLASES INTERNAS DE ESTA CLASE "MenuPrincipal"
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
            btncell_cancel_orden_ = new CellTableButton(1);
            btncell_edit_orden_ = new CellTableButton(2);
            btncell_ok_orden_ = new CellTableButton(3);
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
                
                btncell_cancel_orden_.setIcon(new ImageIcon("mis_imagenes/imgbtn_cancel.png"));
                btncell_cancel_orden_.setPreferredSize(new java.awt.Dimension(35, 35));
                add(btncell_cancel_orden_);

                btncell_edit_orden_.setIcon(new ImageIcon("mis_imagenes/imgbtn_edit.png")); 
                btncell_edit_orden_.setPreferredSize(new java.awt.Dimension(35, 35));
                add(btncell_edit_orden_);

                btncell_ok_orden_.setIcon(new ImageIcon("mis_imagenes/imgbtn_ok.png"));
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
            private int miAccion;//1, 2 o 3 segun sea cancelar orden(1), modificarla(2) o entregar(3) 
            
            //<editor-fold defaultstate="collapsed" desc="METODOS DE CONSTRUCCION Y CONFIGURACION DE ESTA CLASE DE BOTON">
            public CellTableButton(int accion) {
                super();
                metodoConstructorGeneral(accion);
            }
            
            public CellTableButton(int accion, String text) {
                super(text);
                metodoConstructorGeneral(accion);
            }
            
            public CellTableButton(int accion, Icon icon) {
                super(icon);
                metodoConstructorGeneral(accion);
            }
            
            private void metodoConstructorGeneral(int accion) {
                addActionListener(this);
                this.miAccion = accion;
            }
            
            @Override
            public void paint(Graphics grf) {
                super.paint(grf);
                /*switch(miAccion){
                    case 1:
                        
                }*/
            }
    
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(15, 10);
            }
//</editor-fold>

            //Action Listener => metodo que se desata al accionar el boton u oprimirlo
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch (miAccion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Haz Cancelado la orden de la fila " + (miFila+1));
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Realmente Quieres Modificar la fila " + (miFila+1));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Entregar la fila " + (miFila+1));
                        break;
                }
                
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
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            /*dialogo1 dialg1 = new dialogo1(menu, true);
            dialg1.setVisible(true);*/
        });
    }

 
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barra_menu_1;
    private javax.swing.JButton btn_empleados_;
    private javax.swing.JButton btn_inventario_;
    private javax.swing.JButton btn_produccion_;
    private javax.swing.JButton btn_revision_;
    public static final javax.swing.JDesktopPane escritorio = new Paneles.Escritorio();
    private javax.swing.JMenu menu_almacen_;
    private javax.swing.JMenu menu_archivo_;
    private javax.swing.JMenu menu_ensambladores_;
    private javax.swing.JMenu menu_herramientas_;
    private javax.swing.JMenuItem menu_item_articulos_;
    private javax.swing.JMenuItem menu_item_cerrar_;
    private javax.swing.JMenuItem menu_item_componentes_;
    private javax.swing.JMenuItem menu_item_despachos_;
    private javax.swing.JMenuItem menu_item_nueva_orden_;
    private javax.swing.JMenuItem menu_item_parametrizacion_;
    private javax.swing.JMenuItem menu_item_reg_ensam_;
    private javax.swing.JMenuItem menu_item_repuestos_;
    private javax.swing.JMenuItem menu_item_servidores_;
    private javax.swing.JMenuItem menu_item_supervis_ensam_;
    private javax.swing.JMenu menu_tareas_;
    private javax.swing.JPanel panel_fecha_;
    private javax.swing.JPanel panel_reloj_;
    private javax.swing.JScrollPane scroll_tabla_acts;
    private javax.swing.JTable tabla_actividades;
    private javax.swing.JTextField txtview_fecha_actual;
    // End of variables declaration//GEN-END:variables

}
