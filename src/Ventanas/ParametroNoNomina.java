/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;

import Clases.Conexion;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Reymundo
 */
public class ParametroNoNomina extends javax.swing.JDialog {

    /**
     * Creates new form ParametroReporte
     */
    public ParametroNoNomina(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
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
        jLabel1 = new javax.swing.JLabel();
        cmbNoNomina = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte Por No. Nómina");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 0, 5));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("No. Nómina");
        jPanel1.add(jLabel1);

        cmbNoNomina.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>" }));
        jPanel1.add(cmbNoNomina);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(330, 108));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     private Ver_Nomina Ver;

    public void setVer(Ver_Nomina Ver) {
        this.Ver = Ver;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    ResultSet resultado;
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        int NoAnterior = 0;
        int NoActual = 0;
        try{ 
    resultado = Conexion.consulta("Select [No_Nomina] from [dbo].[Nomina]");
    
    while(resultado.next()){
        
       
        NoActual = resultado.getInt(1);
        
        if(NoActual!=NoAnterior){
        cmbNoNomina.addItem(NoActual);
        NoAnterior = NoActual;
        }
    }
    
    
}catch(SQLException ex){
    
}
        

// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened
private String Usuario;

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Map<String, Object> parametros = new HashMap<String, Object>();


int NoNomina = (int) cmbNoNomina.getSelectedItem();
parametros.put("NoNomina", NoNomina);
parametros.put("Autor", Usuario); 

File miDir = new File ("");

String Ruta;
     
 Ruta = miDir.getAbsolutePath();
 Ruta = Ruta.concat("\\src\\Reportes\\NominaNo.jasper");
     

        
 JasperReport Reporte = null;
           /*  CUANDO SE CREA EL REPORTE EN LA RAIZ DEL PROYECTO SOLO
            SE MANDA EL NOMBRE DEL REPORTE, EN CASO CONTRARIO SE MANDA LA
            URL ABSOLUTA (DIRECCION COMPLETA)*/
             try{
               
                     Reporte = (JasperReport) JRLoader.loadObject(Ruta);
            
             JasperPrint RP;
       
            RP = JasperFillManager.fillReport(Reporte, parametros, Conexion.con);
            
       
             
             JasperViewer Vista  = new JasperViewer(RP, false);
             Vista.setTitle("Nómina No. "+NoNomina+" Autorizada Por: "+Usuario);
             Vista.setVisible(true);
        
 }  catch(JRException ex){
             JOptionPane.showMessageDialog(null, "Error Con Reporte");
             }
             
              this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ParametroNoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParametroNoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParametroNoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParametroNoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ParametroNoNomina dialog = new ParametroNoNomina(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbNoNomina;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
