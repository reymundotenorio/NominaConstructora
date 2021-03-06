package Ventanas;


import Clases.Conexion;
import Clases.Trabajador;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FI23
 */
public class Ver_Trabajador extends javax.swing.JFrame {

    /**
     * Creates new form Ver
     */
    public Ver_Trabajador() {
        initComponents();
         Tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbbuscar = new javax.swing.JComboBox();
        txtbuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver Trabajor");
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabla.getTableHeader().setReorderingAllowed(false);
        Tabla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TablaFocusLost(evt);
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Buscar Por:");

        cmbbuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No.", "No. INSS", "Nombres", "Apellidos", "No. Cédula", "Departamento", "Cargo", "Años Antiguedad", "Estado" }));

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jButton1.setText("Mostar Todo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btndelete.setText("Desactivar");
        btndelete.setEnabled(false);
        btndelete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btndeleteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btndeleteFocusLost(evt);
            }
        });
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndelete)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btndelete))
                .addGap(2, 2, 2))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(679, 386));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     DefaultTableModel model = new DefaultTableModel() {

    @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
}; 
     
        public class FormatoTablaTrabajador extends DefaultTableCellRenderer
{
 @Override
 public Component getTableCellRendererComponent
 (JTable table, Object value, boolean selected, boolean focused, int row, int column)
 {
         
  if(String.valueOf(table.getValueAt(row,11)).equalsIgnoreCase("Inactivo"))  {
      setForeground(Color.RED);
  }
   else { setForeground(Color.BLACK);
   }
  
          
    
 super.getTableCellRendererComponent(table, value, selected, focused, row, column);
 return this;
 }
 }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

       Tabla.setDefaultRenderer(Object.class, new FormatoTablaTrabajador());
        
        String [] Titulo = {"No","No. INSS", "Nombres", "Apellidos", "No. Cédula",
       "Sexo", "Teléfono", "Departamento", "Cargo", "Salario", "Años de Antiguedad", "Estado"};
        
        model.setColumnIdentifiers(Titulo);
        
        Tabla.setModel(model);
        
        MostrarTodo();
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
MostrarTodo();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
Buscar();        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
String Estado;

        int Fila = Tabla.getSelectedRow();

        if (Fila > -1){

            btndelete.setEnabled(true);
           

            Estado = ((String)this.Tabla.getModel().getValueAt(Fila, 11));
           

            if("Activo".equalsIgnoreCase(Estado)){
                btndelete.setText("Desactivar");
                }
            if("Inactivo".equalsIgnoreCase(Estado)){
                btndelete.setText("Activar");
                 }

            
        }
        else{
            btndelete.setEnabled(false);
         
        }  
        
        if(evt.getClickCount()==2 && evt.getButton()==MouseEvent.BUTTON1){
        
            
        int index = Tabla.getSelectedRow();
        
        String ID, INSS, Nombres, Apellidos, Cedula, Sexo, Telefono, Departamento, Cargo,
                Salario, Antiguedad;
        
        ID = (String) Tabla.getValueAt(index, 0);
        INSS = (String) Tabla.getValueAt(index, 1);
        Nombres = (String) Tabla.getValueAt(index, 2);
        Apellidos = (String) Tabla.getValueAt(index, 3);
        Cedula = (String) Tabla.getValueAt(index, 4);
        Sexo = (String) Tabla.getValueAt(index, 5);
        Telefono = (String) Tabla.getValueAt(index, 6);
        Departamento = (String) Tabla.getValueAt(index, 7);
        Cargo = (String) Tabla.getValueAt(index, 8);
        Salario = (String) Tabla.getValueAt(index, 9);
        Antiguedad = (String) Tabla.getValueAt(index, 10);
        
        
        
            Modificar_Trabajador MT = new Modificar_Trabajador();
        MT.setVisible(true);
        MT.Parametros(ID, INSS, Nombres, Apellidos, Cedula, Telefono, Sexo, Cargo, Departamento, Salario, Antiguedad);
        MT.setV(this);
        
        }
// TODO add your handling code here:
    }//GEN-LAST:event_TablaMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
String Estado1;

        int Fila = Tabla.getSelectedRow();

        if (Fila > -1){

            btndelete.setEnabled(true);
           

            Estado1 = ((String)this.Tabla.getModel().getValueAt(Fila, 11));
           

            if("Activo".equalsIgnoreCase(Estado1)){
                btndelete.setText("Desactivar");
                }
            if("Inactivo".equalsIgnoreCase(Estado1)){
                btndelete.setText("Activar");
                 }

            
        }
        else{
            btndelete.setEnabled(false);
         
        }  
        
        
          int fila = Tabla.getSelectedRow();

        int ID;
        String Nombres, Apellidos;
        String Estado;
      
        int v=JOptionPane.NO_OPTION;
        
        

        if (fila > -1){
            
            

            ID= Integer.parseInt(this.Tabla.getModel().getValueAt(fila, 0).toString());
            Nombres=((String)this.Tabla.getModel().getValueAt(fila, 2));
            Apellidos = ((String)this.Tabla.getModel().getValueAt(fila, 3));
            Estado = ((String)this.Tabla.getModel().getValueAt(fila, 11));

           
            
            if("Activo".equalsIgnoreCase(Estado)){
                
                v= JOptionPane.showConfirmDialog(this, "Está Seguro Que Desea Desactivar al Trabajador "+Nombres.trim()+" "+Apellidos.trim()+"?", "Confirmación", JOptionPane.YES_NO_OPTION);
            }
            if("Inactivo".equalsIgnoreCase(Estado)){
             
                v= JOptionPane.showConfirmDialog(this, "Está Seguro Que Desea Activar al Trabajador "+Nombres.trim()+" "+Apellidos.trim()+"?", "Confirmación", JOptionPane.YES_NO_OPTION);
            }

            if(v==JOptionPane.YES_OPTION){

                
                Trabajador.Activar_Desactivar_Trabajador(ID);
                MostrarTodo();
            }
        }

        else{

            JOptionPane.showMessageDialog(this, "Seleccione Un Trabajador a Activar/Desactivar", "Error", JOptionPane.ERROR_MESSAGE);

        }

        
// TODO add your handling code here:
    }//GEN-LAST:event_btndeleteActionPerformed

    private void TablaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaFocusGained
 String Estado;

        int Fila = Tabla.getSelectedRow();

        if (Fila > -1){

            btndelete.setEnabled(true);
           

            Estado = ((String)this.Tabla.getModel().getValueAt(Fila, 11));
           

            if("Activo".equalsIgnoreCase(Estado)){
                btndelete.setText("Desactivar");
                }
            if("Inactivo".equalsIgnoreCase(Estado)){
                btndelete.setText("Activar");
                 }

            
        }
        else{
            btndelete.setEnabled(false);
         
        }        // TODO add your handling code here:
    }//GEN-LAST:event_TablaFocusGained

    private void TablaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaFocusLost
String Estado;

        int Fila = Tabla.getSelectedRow();

        if (Fila > -1){

            btndelete.setEnabled(true);
           

            Estado = ((String)this.Tabla.getModel().getValueAt(Fila, 11));
           

            if("Activo".equalsIgnoreCase(Estado)){
                btndelete.setText("Desactivar");
                }
            if("Inactivo".equalsIgnoreCase(Estado)){
                btndelete.setText("Activar");
                 }

            
        }
        else{
            btndelete.setEnabled(false);
         
        }         // TODO add your handling code here:
    }//GEN-LAST:event_TablaFocusLost

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
String Estado;

        int Fila = Tabla.getSelectedRow();

        if (Fila > -1){

            btndelete.setEnabled(true);
           

            Estado = ((String)this.Tabla.getModel().getValueAt(Fila, 11));
           

            if("Activo".equalsIgnoreCase(Estado)){
                btndelete.setText("Desactivar");
                }
            if("Inactivo".equalsIgnoreCase(Estado)){
                btndelete.setText("Activar");
                 }

            
        }
        else{
            btndelete.setEnabled(false);
         
        }          // TODO add your handling code here:
    }//GEN-LAST:event_btndeleteMouseClicked

    private void btndeleteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btndeleteFocusGained
String Estado;

        int Fila = Tabla.getSelectedRow();

        if (Fila > -1){

            btndelete.setEnabled(true);
           

            Estado = ((String)this.Tabla.getModel().getValueAt(Fila, 11));
           

            if("Activo".equalsIgnoreCase(Estado)){
                btndelete.setText("Desactivar");
                }
            if("Inactivo".equalsIgnoreCase(Estado)){
                btndelete.setText("Activar");
                 }

            
        }
        else{
            btndelete.setEnabled(false);
         
        }          // TODO add your handling code here:
    }//GEN-LAST:event_btndeleteFocusGained

    private void btndeleteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btndeleteFocusLost
String Estado;

        int Fila = Tabla.getSelectedRow();

        if (Fila > -1){

            btndelete.setEnabled(true);
           

            Estado = ((String)this.Tabla.getModel().getValueAt(Fila, 11));
           

            if("Activo".equalsIgnoreCase(Estado)){
                btndelete.setText("Desactivar");
                }
            if("Inactivo".equalsIgnoreCase(Estado)){
                btndelete.setText("Activar");
                 }

            
        }
        else{
            btndelete.setEnabled(false);
         
        }          // TODO add your handling code here:
    }//GEN-LAST:event_btndeleteFocusLost

    ResultSet resultado;
    
    public void MostrarTodo(){
        
        
        model.setRowCount(0);
        
       
            try {
                resultado = Conexion.consulta("Select * from [dbo].[TrabajadorV]");
            
        
        while(resultado.next()){
           
            String [] Titulo = new String[12];
            
            Titulo [0] = String.valueOf(resultado.getInt(1));
            Titulo [1] = resultado.getString(2);
            Titulo [2] = resultado.getString(3);
            Titulo [3] = resultado.getString(4);
            Titulo [4] = resultado.getString(5);
            Titulo [5] = resultado.getString(6);
            Titulo [6] = resultado.getString(7);
            Titulo [7] = resultado.getString(8);
            Titulo [8] = resultado.getString(9);
            Titulo [9] = String.valueOf(resultado.getDouble(10));
            Titulo [10] = String.valueOf(resultado.getInt(11));
            Titulo [11] = resultado.getString(12);
            
            model.addRow(Titulo);
            
            
        }
        } catch (SQLException ex) {
                     
            JOptionPane.showMessageDialog(null, "Error Al Realizar Consulta"); 
            return; 
}
        Tabla.setModel(model);
           
        
    }
    
    
    public void Buscar(){
        
        
        int index = cmbbuscar.getSelectedIndex()+1;
        
        String Buscar = txtbuscar.getText();
        
     switch (index){
         
         case 1:
        
          model.setRowCount(0);
        
       
            try {
                resultado = Conexion.consulta("Select * from [dbo].[TrabajadorV] where "
                        + "[ID_Trabajador] like '%"+Buscar+"%'");
            
        
        while(resultado.next()){
           
            String [] Titulo = new String[11];
            
            Titulo [0] = String.valueOf(resultado.getInt(1));
            Titulo [1] = resultado.getString(2);
            Titulo [2] = resultado.getString(3);
            Titulo [3] = resultado.getString(4);
            Titulo [4] = resultado.getString(5);
            Titulo [5] = resultado.getString(6);
            Titulo [6] = resultado.getString(7);
            Titulo [7] = resultado.getString(8);
            Titulo [8] = resultado.getString(9);
            Titulo [9] = String.valueOf(resultado.getDouble(10));
            Titulo [10] = String.valueOf(resultado.getInt(11));
           
            
            model.addRow(Titulo);
            
            
        }
        } catch (SQLException ex) {
                     
            JOptionPane.showMessageDialog(null, "Error Al Realizar Búsqueda"); 
            return; 
}
             break;
      
             
             
               case 2:
        
          model.setRowCount(0);
        
       
            try {
                resultado = Conexion.consulta("Select * from [dbo].[TrabajadorV] where "
                        + "[No_Inss] like '%"+Buscar+"%'");
            
        
        while(resultado.next()){
           
            String [] Titulo = new String[11];
            
            Titulo [0] = String.valueOf(resultado.getInt(1));
            Titulo [1] = resultado.getString(2);
            Titulo [2] = resultado.getString(3);
            Titulo [3] = resultado.getString(4);
            Titulo [4] = resultado.getString(5);
            Titulo [5] = resultado.getString(6);
            Titulo [6] = resultado.getString(7);
            Titulo [7] = resultado.getString(8);
            Titulo [8] = resultado.getString(9);
            Titulo [9] = String.valueOf(resultado.getDouble(10));
            Titulo [10] = String.valueOf(resultado.getInt(11));
           
            
            model.addRow(Titulo);
            
            
        }
        } catch (SQLException ex) {
                     
            JOptionPane.showMessageDialog(null, "Error Al Realizar Búsqueda"); 
            return; 
}

             break;
                   
                case 3:
        
          model.setRowCount(0);
        
       
            try {
                resultado = Conexion.consulta("Select * from [dbo].[TrabajadorV] where "
                        + "[Nombres_Trabajador] like '%"+Buscar+"%'");
            
        
        while(resultado.next()){
           
            String [] Titulo = new String[11];
            
            Titulo [0] = String.valueOf(resultado.getInt(1));
            Titulo [1] = resultado.getString(2);
            Titulo [2] = resultado.getString(3);
            Titulo [3] = resultado.getString(4);
            Titulo [4] = resultado.getString(5);
            Titulo [5] = resultado.getString(6);
            Titulo [6] = resultado.getString(7);
            Titulo [7] = resultado.getString(8);
            Titulo [8] = resultado.getString(9);
            Titulo [9] = String.valueOf(resultado.getDouble(10));
            Titulo [10] = String.valueOf(resultado.getInt(11));
           
            
            model.addRow(Titulo);
            
            
        }
        } catch (SQLException ex) {
                     
            JOptionPane.showMessageDialog(null, "Error Al Realizar Búsqueda"); 
            return; 
}
         
             break;
                       
               
                case 4:
        
          model.setRowCount(0);
        
       
            try {
                resultado = Conexion.consulta("Select * from [dbo].[TrabajadorV] where "
                        + "[Apellidos_Trabajador] like '%"+Buscar+"%'");
            
        
        while(resultado.next()){
           
            String [] Titulo = new String[11];
            
            Titulo [0] = String.valueOf(resultado.getInt(1));
            Titulo [1] = resultado.getString(2);
            Titulo [2] = resultado.getString(3);
            Titulo [3] = resultado.getString(4);
            Titulo [4] = resultado.getString(5);
            Titulo [5] = resultado.getString(6);
            Titulo [6] = resultado.getString(7);
            Titulo [7] = resultado.getString(8);
            Titulo [8] = resultado.getString(9);
            Titulo [9] = String.valueOf(resultado.getDouble(10));
            Titulo [10] = String.valueOf(resultado.getInt(11));
           
            
            model.addRow(Titulo);
            
            
        }
        } catch (SQLException ex) {
                     
            JOptionPane.showMessageDialog(null, "Error Al Realizar Búsqueda"); 
            return; 
}
         
             break;
                           
                case 5:
        
          model.setRowCount(0);
        
       
            try {
                resultado = Conexion.consulta("Select * from [dbo].[TrabajadorV] where "
                        + "[No_Cedula] like '%"+Buscar+"%'");
            
        
        while(resultado.next()){
           
            String [] Titulo = new String[11];
            
            Titulo [0] = String.valueOf(resultado.getInt(1));
            Titulo [1] = resultado.getString(2);
            Titulo [2] = resultado.getString(3);
            Titulo [3] = resultado.getString(4);
            Titulo [4] = resultado.getString(5);
            Titulo [5] = resultado.getString(6);
            Titulo [6] = resultado.getString(7);
            Titulo [7] = resultado.getString(8);
            Titulo [8] = resultado.getString(9);
            Titulo [9] = String.valueOf(resultado.getDouble(10));
            Titulo [10] = String.valueOf(resultado.getInt(11));
           
            
            model.addRow(Titulo);
            
            
        }
        } catch (SQLException ex) {
                     
            JOptionPane.showMessageDialog(null, "Error Al Realizar Búsqueda"); 
            return; 
}
         
             break;
                 
                case 6:
        
          model.setRowCount(0);
        
       
            try {
                resultado = Conexion.consulta("Select * from [dbo].[TrabajadorV] where "
                        + "[NombreDepartamento] like '%"+Buscar+"%'");
            
        
        while(resultado.next()){
           
            String [] Titulo = new String[11];
            
            Titulo [0] = String.valueOf(resultado.getInt(1));
            Titulo [1] = resultado.getString(2);
            Titulo [2] = resultado.getString(3);
            Titulo [3] = resultado.getString(4);
            Titulo [4] = resultado.getString(5);
            Titulo [5] = resultado.getString(6);
            Titulo [6] = resultado.getString(7);
            Titulo [7] = resultado.getString(8);
            Titulo [8] = resultado.getString(9);
            Titulo [9] = String.valueOf(resultado.getDouble(10));
            Titulo [10] = String.valueOf(resultado.getInt(11));
           
            
            model.addRow(Titulo);
            
            
        }
        } catch (SQLException ex) {
                     
            JOptionPane.showMessageDialog(null, "Error Al Realizar Búsqueda"); 
            return; 
}
         
             break;
                
                case 7:
        
          model.setRowCount(0);
        
       
            try {
                resultado = Conexion.consulta("Select * from [dbo].[TrabajadorV] where "
                        + "[NombreCargo] like '%"+Buscar+"%'");
            
        
        while(resultado.next()){
           
            String [] Titulo = new String[11];
            
            Titulo [0] = String.valueOf(resultado.getInt(1));
            Titulo [1] = resultado.getString(2);
            Titulo [2] = resultado.getString(3);
            Titulo [3] = resultado.getString(4);
            Titulo [4] = resultado.getString(5);
            Titulo [5] = resultado.getString(6);
            Titulo [6] = resultado.getString(7);
            Titulo [7] = resultado.getString(8);
            Titulo [8] = resultado.getString(9);
            Titulo [9] = String.valueOf(resultado.getDouble(10));
            Titulo [10] = String.valueOf(resultado.getInt(11));
           
            
            model.addRow(Titulo);
            
            
        }
        } catch (SQLException ex) {
                     
            JOptionPane.showMessageDialog(null, "Error Al Realizar Búsqueda"); 
            return; 
}
         
             break;
                    
                    case 8:
        
          model.setRowCount(0);
        
       
            try {
                resultado = Conexion.consulta("Select * from [dbo].[TrabajadorV] where "
                        + "[Anios_Antiguedad] like '%"+Buscar+"%'");
            
        
        while(resultado.next()){
           
            String [] Titulo = new String[11];
            
            Titulo [0] = String.valueOf(resultado.getInt(1));
            Titulo [1] = resultado.getString(2);
            Titulo [2] = resultado.getString(3);
            Titulo [3] = resultado.getString(4);
            Titulo [4] = resultado.getString(5);
            Titulo [5] = resultado.getString(6);
            Titulo [6] = resultado.getString(7);
            Titulo [7] = resultado.getString(8);
            Titulo [8] = resultado.getString(9);
            Titulo [9] = String.valueOf(resultado.getDouble(10));
            Titulo [10] = String.valueOf(resultado.getInt(11));
           
            
            model.addRow(Titulo);
            
            
        }
        } catch (SQLException ex) {
                     
            JOptionPane.showMessageDialog(null, "Error Al Realizar Búsqueda"); 
            return; 
}
         
             break;
                       
                        
                          case 9:
        
          model.setRowCount(0);
        
       
            try {
                resultado = Conexion.consulta("Select * from [dbo].[TrabajadorV] where "
                        + "[Estado_Trabajador] like '%"+Buscar+"%'");
            
        
        while(resultado.next()){
           
            String [] Titulo = new String[11];
            
            Titulo [0] = String.valueOf(resultado.getInt(1));
            Titulo [1] = resultado.getString(2);
            Titulo [2] = resultado.getString(3);
            Titulo [3] = resultado.getString(4);
            Titulo [4] = resultado.getString(5);
            Titulo [5] = resultado.getString(6);
            Titulo [6] = resultado.getString(7);
            Titulo [7] = resultado.getString(8);
            Titulo [8] = resultado.getString(9);
            Titulo [9] = String.valueOf(resultado.getDouble(10));
            Titulo [10] = String.valueOf(resultado.getInt(11));
           
            
            model.addRow(Titulo);
            
            
        }
        } catch (SQLException ex) {
                     
            JOptionPane.showMessageDialog(null, "Error Al Realizar Búsqueda"); 
            return; 
}
         
             break;
                   
                  
               
               default:break;      
        }
     
  
     
        Tabla.setModel(model);
           
        
    }
        
    
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
            java.util.logging.Logger.getLogger(Ver_Trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ver_Trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ver_Trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ver_Trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ver_Trabajador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btndelete;
    private javax.swing.JComboBox cmbbuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
