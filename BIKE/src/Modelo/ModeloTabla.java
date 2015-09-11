
//code

package Modelo;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.table.AbstractTableModel;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author 
 */
public class ModeloTabla extends AbstractTableModel{
    
    // <editor-fold defaultstate="collapsed" desc="Codigo que Define un Modelo Abstracto de Tabla implementado por el programador">
    //FUENTES
    //http://swing-facil.blogspot.com.co/2012/01/jbutton-jcheckbox-jcombobox-en-jtable.html

//private Class[] TIPOS_COLUMNAS;
    //private String[] nombres_columnas;
    //private boolean[] columnas_editables;
    public Object[][] data;
    private Class claseComponente;//campo que funciona como auxiliar al momento de determinar el componente de todas y cada una de las celdas

    /**
     * Constructor de la Clase que se esta heredando de AbstractTableModel
     */
    public ModeloTabla(){
        this.claseComponente = Object.class;
        this.data = new Object[][]{};
    }
    
    public void setDatosTabla(Object[][] datos){
        this.data = datos;
        fireTableDataChanged();
    }
    
    public void setEditorColumna(int colTable, Object objeto){
    }

    /*@Override//notifica a todos los listeners que todos los datos de la tabla han cambiado por lo que se redibujara la tabla conservando la estructura con los nuevos datos
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    @Override//determina la clase de componentes que iran en cada celda
    public Class getColumnClass(int columnIndex) {
        if(getValueAt(0, columnIndex) != null){
            claseComponente = getValueAt(0, columnIndex).getClass();
        }
        return claseComponente;
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;//columnas_editables[col];
    }
    
    @Override
    public int getRowCount() {
        return 1;//data.length;
    }
    
    @Override
    public int getColumnCount() {
        return 1;//nombres_columnas.length;
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        return 1;//data[row][col];
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        this.fireTableCellUpdated(row, col);//notifica a todos los listeners que el valor de la celda ha sido editado
    }

// </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="COMPONENTES(personalizados) EDITORES DE CELDAS DE TABLA">
    
    //<editor-fold defaultstate="collapsed" desc="EDITOR SPINNER">
    /**
     * esta clase redefine un spinner haciendo que no se le puedan ingresar
     * letras por ejemplo, o cuaquier configuracion que el programador quiera
     * darSPINNER 
     */
    public static class SpinnCellTable extends JSpinner {
        // <editor-fold defaultstate="collapsed" desc="Codigo de la Clase SpinnCellTable">
        
        private SpinnerModel myspinnerNumModel;
        private JSpinner.DefaultEditor editor;
        
        private static class VigiaTecleoDigitos implements KeyListener {//clase regular que implementa el escucha o vigia de teclas oprimidas. Aqui se usa para evitar el ingreso de letras en un campo numerico
            // <editor-fold defaultstate="collapsed" desc="metodos abstractos del keylistener implementados y sobreescritos">
            
            @Override
            public void keyTyped(KeyEvent e) {
                char typ = e.getKeyChar();
                if ((typ < '0' || typ > '9')) {
                    e.consume();
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                
            }
            
// </editor-fold>
        }
        /**
         * Constructor Spinner
         */
        public SpinnCellTable() {
            super();
            editor = ((JSpinner.DefaultEditor) getEditor());
            editor.getTextField().addKeyListener(new VigiaTecleoDigitos());
        }
        /**
         * Constructor Spinner con Modelo
         * @param spinnerModel
         */
        public SpinnCellTable(SpinnerModel spinnerModel) {
            super();
            if (spinnerModel == null) {
                throw new NullPointerException("model cannot be null");
            }
            this.setModel(spinnerModel);
            this.myspinnerNumModel = spinnerModel;
            editor = ((JSpinner.DefaultEditor) getEditor());
            editor.getTextField().addKeyListener(new VigiaTecleoDigitos());
        }
        // </editor-fold>
    }
    //</editor-fold>

    //##############
// </editor-fold>    
    
    // <editor-fold defaultstate="collapsed" desc="CLASES PARA LA GRAFICACION DE COMPONENTES (combobox, boton..) DENTRO DE TABLA Y SU CAPACIDAD DE DETERMINAR EL VALOR DE LA CELDA (edicion)">
        //FUENTES
        //insertar componentes en celdas de tabla ->
        //http://www.java2s.com/Tutorial/Java/0240__Swing/UsingaJComboBoxinaCellinaJTableComponent.htm
        //http://www.chuidiang.com/java/tablas/tablaeditor/tablaeditor.php
    public static class ComponentCellRenderer implements TableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;
        }
    }
    public static class ComponentCellEditor extends AbstractCellEditor implements TableCellEditor {
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return (Component) value;
        }
        @Override
        public Object getCellEditorValue() {
            return "CellEditorValue";//combo.getSelectedItem().toString();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            System.out.println("Edicion Cancelada");
        }
        @Override
        public void addCellEditorListener(CellEditorListener l) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //System.out.println("addCellEditorListener");
        }
        @Override
        public void removeCellEditorListener(CellEditorListener l) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            System.out.println("removeCellEditorListener");
        }
    }// </editor-fold>
    
}
