
package view;

// <editor-fold defaultstate="collapsed" desc="imports">

import controller.componentes.TablaProduccion;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.MainClass;

// </editor-fold>

/**
 * author  : miguel, braden, never
 */
public class MenuPrincipal extends javax.swing.JFrame {

    //private DefaultTableModel dtm_tabla_actividades;
    private int fila_tabla, col_tabla;

    public void setCol_tabla(int col_tabla) {
        this.col_tabla = col_tabla;
    }

    public int getCol_tabla() {
        return col_tabla;
    }
    
    //VENTANAS INTERNAS
    public GestionArticulos controlArticulos;
    public GestionComponentes controlComponentes;
    public GestionRepuestos gestionRepuestos;
    public OrdenProduccion ordenProduccion;
    public RegistroEmpleados registroEmpleados;
    public GestionProduccion produccion_general;
    //----
    
    /** Creates new form MenuPrincipal */
    public MenuPrincipal() {
        initComponents();
        this.setTitle("MT BIKE");
        try {
            Image iconoPrograma;
            //iconoPrograma = ImageIO.read(new File("mis_imagenes/icon_program.png"));
            iconoPrograma = new ImageIcon(MenuPrincipal.class.getResource("/sources/mis_imagenes/icon_program.png")).getImage();
            this.setIconImage(iconoPrograma);
        } catch (/*IO*/Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el Icono de la aplicación." + e.toString());
        }
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        if (tabla_actividades instanceof TablaProduccion) {
            //ArrayList<Object[]> data = ConsultaSQL.revisarProduccionActual();
            int anchoContenedor = scroll_tabla_acts.getWidth();
            int[] anchos = new int[]{
                ((anchoContenedor * 8) / 100), ((anchoContenedor * 13) / 100),
                ((anchoContenedor * 15) / 100), ((anchoContenedor * 15) / 100),
                ((anchoContenedor * 18) / 100), ((anchoContenedor * 7) / 100),
                ((anchoContenedor * 7) / 100), ((anchoContenedor * 15) / 100)
            //70, 100, 100, 100, 150, 70, 70, 150
            };
            int alturaCol = 30;
            ((TablaProduccion) tabla_actividades).formatearTabla(anchos, alturaCol);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_empleados_ = new javax.swing.JButton();
        btn_produccion_ = new javax.swing.JButton();
        panel_reloj_ = new controller.PanelReloj();
        panel_fecha_ = new javax.swing.JPanel();
        txtview_fecha_actual = new javax.swing.JTextField();
        btn_reportes_ = new javax.swing.JButton();
        barra_menu_1 = new javax.swing.JMenuBar();
        menu_tareas_ = new javax.swing.JMenu();
        menu_item_nueva_orden_ = new javax.swing.JMenuItem();
        menu_item_observar_produccion_ = new javax.swing.JMenuItem();
        menu_almacen_ = new javax.swing.JMenu();
        menu_item_gestion_produccion_ = new javax.swing.JMenuItem();
        menu_item_componentes_ = new javax.swing.JMenuItem();
        menuItem_controlRepuestos_ = new javax.swing.JMenuItem();
        menu_ensambladores_ = new javax.swing.JMenu();
        menuItem_registroEnsamblador_ = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(204, 204, 204));
        escritorio.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        escritorio.setAutoscrolls(true);
        escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        scroll_tabla_acts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRODUCCION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 0, 14), new java.awt.Color(204, 0, 0))); // NOI18N
        scroll_tabla_acts.setViewportBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(220, 218, 218), new java.awt.Color(0, 153, 204), null, null));
        scroll_tabla_acts.setAutoscrolls(true);
        scroll_tabla_acts.setMaximumSize(new java.awt.Dimension(1000, 1000));
        scroll_tabla_acts.setMinimumSize(new java.awt.Dimension(452, 402));
        scroll_tabla_acts.setName(""); // NOI18N

        tabla_actividades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla_actividades.getTableHeader().setReorderingAllowed(false);
        tabla_actividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_actividadesMouseClicked(evt);
            }
        });
        scroll_tabla_acts.setViewportView(tabla_actividades);

        btn_empleados_.setBackground(new java.awt.Color(0, 0, 204));
        btn_empleados_.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        btn_empleados_.setForeground(new java.awt.Color(255, 255, 255));
        btn_empleados_.setIcon(new javax.swing.ImageIcon(MenuPrincipal.class.getResource("/sources/mis_imagenes/btnempleados.png")));
        btn_empleados_.setBorderPainted(false);
        btn_empleados_.setContentAreaFilled(false);
        btn_empleados_.setMaximumSize(new java.awt.Dimension(150, 80));
        btn_empleados_.setMinimumSize(new java.awt.Dimension(150, 80));
        btn_empleados_.setPreferredSize(new java.awt.Dimension(150, 80));
        btn_empleados_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_empleados_ActionPerformed(evt);
            }
        });

        btn_produccion_.setBackground(new java.awt.Color(0, 51, 153));
        btn_produccion_.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        btn_produccion_.setForeground(new java.awt.Color(255, 255, 255));
        btn_produccion_.setIcon(new javax.swing.ImageIcon(MenuPrincipal.class.getResource("/sources/mis_imagenes/btnproduccion.png")));
        btn_produccion_.setBorderPainted(false);
        btn_produccion_.setContentAreaFilled(false);
        btn_produccion_.setMaximumSize(new java.awt.Dimension(150, 80));
        btn_produccion_.setMinimumSize(new java.awt.Dimension(150, 80));
        btn_produccion_.setPreferredSize(new java.awt.Dimension(150, 80));
        btn_produccion_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produccion_ActionPerformed(evt);
            }
        });

        panel_reloj_.setBackground(new java.awt.Color(204, 204, 204));
        panel_reloj_.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel_reloj_.setEnabled(false);
        panel_reloj_.setPreferredSize(new java.awt.Dimension(210, 210));

        javax.swing.GroupLayout panel_reloj_Layout = new javax.swing.GroupLayout(panel_reloj_);
        panel_reloj_.setLayout(panel_reloj_Layout);
        panel_reloj_Layout.setHorizontalGroup(
            panel_reloj_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );
        panel_reloj_Layout.setVerticalGroup(
            panel_reloj_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        txtview_fecha_actual.setEditable(false);
        txtview_fecha_actual.setFont(new java.awt.Font("DS-Digital", 0, 52)); // NOI18N
        txtview_fecha_actual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtview_fecha_actual.setText(controller.Tiempo.getStringFechaActual());
        txtview_fecha_actual.setToolTipText("Hoy: ");

        javax.swing.GroupLayout panel_fecha_Layout = new javax.swing.GroupLayout(panel_fecha_);
        panel_fecha_.setLayout(panel_fecha_Layout);
        panel_fecha_Layout.setHorizontalGroup(
            panel_fecha_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fecha_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtview_fecha_actual, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_fecha_Layout.setVerticalGroup(
            panel_fecha_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fecha_Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtview_fecha_actual)
                .addContainerGap())
        );

        btn_reportes_.setBackground(new java.awt.Color(0, 0, 204));
        btn_reportes_.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        btn_reportes_.setForeground(new java.awt.Color(255, 255, 255));
        btn_reportes_.setIcon(new javax.swing.ImageIcon(MenuPrincipal.class.getResource("/sources/mis_imagenes/btninventario.png")));
        btn_reportes_.setBorderPainted(false);
        btn_reportes_.setContentAreaFilled(false);
        btn_reportes_.setMaximumSize(new java.awt.Dimension(150, 80));
        btn_reportes_.setMinimumSize(new java.awt.Dimension(150, 80));
        btn_reportes_.setPreferredSize(new java.awt.Dimension(150, 80));
        btn_reportes_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportes_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_fecha_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_reloj_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btn_empleados_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(btn_produccion_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(btn_reportes_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(scroll_tabla_acts, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_reloj_, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_fecha_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll_tabla_acts, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_reportes_, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(btn_produccion_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_empleados_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        escritorio.setLayer(scroll_tabla_acts, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btn_empleados_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btn_produccion_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(panel_reloj_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(panel_fecha_, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btn_reportes_, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menu_tareas_.setText("Produccion");

        menu_item_nueva_orden_.setText("Nueva Orden");
        menu_item_nueva_orden_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_nueva_orden_ActionPerformed(evt);
            }
        });
        menu_tareas_.add(menu_item_nueva_orden_);

        menu_item_observar_produccion_.setText("Inventario");
        menu_item_observar_produccion_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_observar_produccion_ActionPerformed(evt);
            }
        });
        menu_tareas_.add(menu_item_observar_produccion_);

        barra_menu_1.add(menu_tareas_);

        menu_almacen_.setText("Almacen");

        menu_item_gestion_produccion_.setText("Articulos Ensamblados");
        menu_item_gestion_produccion_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_gestion_produccion_ActionPerformed(evt);
            }
        });
        menu_almacen_.add(menu_item_gestion_produccion_);

        menu_item_componentes_.setText("Gestion de Componentes");
        menu_item_componentes_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_componentes_ActionPerformed(evt);
            }
        });
        menu_almacen_.add(menu_item_componentes_);

        menuItem_controlRepuestos_.setText("Gestion de Repuestos");
        menuItem_controlRepuestos_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_controlRepuestos_ActionPerformed(evt);
            }
        });
        menu_almacen_.add(menuItem_controlRepuestos_);

        barra_menu_1.add(menu_almacen_);

        menu_ensambladores_.setText("Ensambladores");

        menuItem_registroEnsamblador_.setText("Registro");
        menuItem_registroEnsamblador_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_registroEnsamblador_ActionPerformed(evt);
            }
        });
        menu_ensambladores_.add(menuItem_registroEnsamblador_);

        barra_menu_1.add(menu_ensambladores_);

        setJMenuBar(barra_menu_1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*private Font getFuenteFecha(){
        Font letter;
        String source = "sources/fuentes/DS-DIGI.ttf";//USADO EN PRODUCCION
        //String source = "DS-DIGI.TTF";//USADO EN EL CODIGO FINAL PARA EL .jar (o ejecutable)
        try{
            InputStream upload = MenuPrincipal.class.getClassLoader().getResourceAsStream(source);
            letter = Font.createFont(Font.TRUETYPE_FONT, upload);
            letter = letter.deriveFont(0, 52);
        }
        catch(FontFormatException | IOException ex){
            JOptionPane.showMessageDialog(MenuPrincipal.this, "No se pudo cargar la letra del calendario", 
                    "Instanciación de la letra.\n"+ex.toString(), 0);
            //System.out.println(ex.toString());
            letter = new Font("cursive", Font.PLAIN, 52);
        }
        return letter;
    }*/
    
    public void iniciarTabla(){
        if (tabla_actividades instanceof TablaProduccion) {
            try {
                ((TablaProduccion) tabla_actividades).actualizarTabla();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MenuPrincipal.this, e.getLocalizedMessage(), "Obtener Informacion de Produccion", 0);
            }
        }
    }
    
    private void menu_item_nueva_orden_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_nueva_orden_ActionPerformed
        try {
            if (ordenProduccion != null && ordenProduccion.isVisible()) {
                if (ordenProduccion.isIcon()) {
                   ordenProduccion.setIcon(false);
                }
            } else {
                ordenProduccion = new OrdenProduccion();
                escritorio.add(ordenProduccion);
                ordenProduccion.setVisible(true);
            }
            ordenProduccion.toFront();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            //System.out.print("Excepcion localizada en: MenuPrincipal.menu_item_nueva_orden_ActionPerformed => \n"+ex.toString());
        }
    }//GEN-LAST:event_menu_item_nueva_orden_ActionPerformed

    private void tabla_actividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_actividadesMouseClicked
        
        fila_tabla = tabla_actividades.rowAtPoint(evt.getPoint());
        col_tabla = tabla_actividades.columnAtPoint(evt.getPoint());
        
    }//GEN-LAST:event_tabla_actividadesMouseClicked

    private void menu_item_componentes_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_componentes_ActionPerformed
        try {
            if (controlComponentes != null && controlComponentes.isVisible()) {
                if (controlComponentes.isIcon()) {
                    controlComponentes.setIcon(false);
                }
            } else {
                controlComponentes = new GestionComponentes();
                escritorio.add(controlComponentes);
                controlComponentes.setVisible(true);
            }
            controlComponentes.toFront();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(MenuPrincipal.this, "No Fue posible Abrir la Ventana.\nError: "+ex.toString());
        }
    }//GEN-LAST:event_menu_item_componentes_ActionPerformed

    private void menuItem_controlRepuestos_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_controlRepuestos_ActionPerformed
        try {
            if (gestionRepuestos != null && gestionRepuestos.isVisible()) {
                if (gestionRepuestos.isIcon()) {
                    gestionRepuestos.setIcon(false);
                }
            } else {
                gestionRepuestos = new GestionRepuestos();
                escritorio.add(gestionRepuestos);
                gestionRepuestos.setVisible(true);
            }
            gestionRepuestos.toFront();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(MenuPrincipal.this, "No Fue posible Abrir la Ventana.\nError: "+ex.toString());
        }
    }//GEN-LAST:event_menuItem_controlRepuestos_ActionPerformed

    private void menuItem_registroEnsamblador_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_registroEnsamblador_ActionPerformed
        try {
            if (registroEmpleados != null && registroEmpleados.isVisible()) {
                if (registroEmpleados.isIcon()) {
                    registroEmpleados.setIcon(false);
                }
            } else {
                registroEmpleados = new RegistroEmpleados();
                escritorio.add(registroEmpleados);
                registroEmpleados.setVisible(true);
            }
            registroEmpleados.toFront();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(MenuPrincipal.this, "No Fue posible Abrir la Ventana.\nError: "+ex.toString());
        }
    }//GEN-LAST:event_menuItem_registroEnsamblador_ActionPerformed

    private void menu_item_gestion_produccion_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_gestion_produccion_ActionPerformed
        try {
            if (controlArticulos != null && controlArticulos.isVisible()) {
                if (controlArticulos.isIcon()) {
                    controlArticulos.setIcon(false);
                }
            } else {
                controlArticulos = new GestionArticulos();
                escritorio.add(controlArticulos);
                controlArticulos.setVisible(true);
            }
            controlArticulos.toFront();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(MenuPrincipal.this, "No Fue posible Abrir la Ventana.\nError: "+ex.toString());
        }    
    }//GEN-LAST:event_menu_item_gestion_produccion_ActionPerformed

    private void btn_empleados_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_empleados_ActionPerformed
        try {
            if (registroEmpleados != null && registroEmpleados.isVisible()) {
                if (registroEmpleados.isIcon()) {
                    registroEmpleados.setIcon(false);
                }
            } else {
                registroEmpleados = new RegistroEmpleados();
                escritorio.add(registroEmpleados);
                registroEmpleados.setVisible(true);
            }
            registroEmpleados.toFront();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(MenuPrincipal.this, "No Fue posible Abrir la Ventana.\nError: "+ex.toString());
        }
    }//GEN-LAST:event_btn_empleados_ActionPerformed

    private void btn_produccion_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produccion_ActionPerformed
        try {
            if (ordenProduccion != null && ordenProduccion.isVisible()) {
                if (ordenProduccion.isIcon()) {
                   ordenProduccion.setIcon(false);
                }
            } else {
                ordenProduccion = new OrdenProduccion();
                escritorio.add(ordenProduccion);
                ordenProduccion.setVisible(true);
            }
            ordenProduccion.toFront();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            //System.out.print("Excepcion localizada en: MenuPrincipal.menu_item_nueva_orden_ActionPerformed => \n"+ex.toString());
        }
    }//GEN-LAST:event_btn_produccion_ActionPerformed

    private void menu_item_observar_produccion_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_observar_produccion_ActionPerformed
        try {
            if (produccion_general != null && produccion_general.isVisible()) {
                if (produccion_general.isIcon()) {
                   produccion_general.setIcon(false);
                }
            } else {
                produccion_general = new GestionProduccion();
                escritorio.add(produccion_general);
                produccion_general.setVisible(true);
            }
            produccion_general.toFront();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            //System.out.print("Excepcion localizada en: MenuPrincipal.menu_item_nueva_orden_ActionPerformed => \n"+ex.toString());
        }
    }//GEN-LAST:event_menu_item_observar_produccion_ActionPerformed

    private void btn_reportes_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportes_ActionPerformed
        try {
            if (produccion_general != null && produccion_general.isVisible()) {
                if (produccion_general.isIcon()) {
                   produccion_general.setIcon(false);
                }
            } else {
                produccion_general = new GestionProduccion();
                escritorio.add(produccion_general);
                produccion_general.setVisible(true);
            }
            produccion_general.toFront();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_btn_reportes_ActionPerformed
   
    // <editor-fold defaultstate="collapsed" desc="VOID MAIN O METODO PRINCIPAL">
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
        // Create and display the form
        java.awt.EventQueue.invokeLater(() -> {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
        });
    }
    // </editor-fold>
   
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barra_menu_1;
    private javax.swing.JButton btn_empleados_;
    private javax.swing.JButton btn_produccion_;
    private javax.swing.JButton btn_reportes_;
    public static final javax.swing.JDesktopPane escritorio = new controller.componentes.Paneles.Escritorio();
    private javax.swing.JMenuItem menuItem_controlRepuestos_;
    private javax.swing.JMenuItem menuItem_registroEnsamblador_;
    private javax.swing.JMenu menu_almacen_;
    private javax.swing.JMenu menu_ensambladores_;
    private javax.swing.JMenuItem menu_item_componentes_;
    private javax.swing.JMenuItem menu_item_gestion_produccion_;
    private javax.swing.JMenuItem menu_item_nueva_orden_;
    private javax.swing.JMenuItem menu_item_observar_produccion_;
    private javax.swing.JMenu menu_tareas_;
    private javax.swing.JPanel panel_fecha_;
    private javax.swing.JPanel panel_reloj_;
    private static final javax.swing.JScrollPane scroll_tabla_acts = new javax.swing.JScrollPane();
    private static final javax.swing.JTable tabla_actividades = new TablaProduccion(TablaProduccion.TABLA_CONTROL);
    private javax.swing.JTextField txtview_fecha_actual;
    // End of variables declaration//GEN-END:variables

    public static JTable getTabla_actividades() {
        return tabla_actividades;
    }

}
