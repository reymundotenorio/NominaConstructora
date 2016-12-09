/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Reymundo Tenorio
 */
public class Nomina {
    


public static void Agregar_Nomina(int NoNomina, int Dia, int Mes, int Anio, int ID_Trabajador,
        double SalarioBasico, int CantidadHrsExtras, double PagoHrsExtras, int AniosAntiguedad,
        double IngAntiguedad, double TotalIngresos, double INSS_L, double IR, double TotalDeducciones,
        double SalarioNeto, double OtrasDeducciones, double SalarioPagar, double INNS_P, double INATEC,
        double Vacaciones, double TreceavoMes){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Nomina] (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

                
                         consulta.setInt(1, NoNomina);
                         consulta.setInt(2, Dia);
                         consulta.setInt(3, Mes);
                         consulta.setInt(4, Anio);
                         consulta.setInt(5, ID_Trabajador);
                         consulta.setDouble(6, SalarioBasico);
                         consulta.setInt(7, CantidadHrsExtras);
                         consulta.setDouble(8, PagoHrsExtras);
                         consulta.setInt(9, AniosAntiguedad);
                         consulta.setDouble(10, IngAntiguedad);
                         consulta.setDouble(11, TotalIngresos);
                         consulta.setDouble(12, INSS_L);
                         consulta.setDouble(13, IR);
                         consulta.setDouble(14, TotalDeducciones);
                         consulta.setDouble(15, SalarioNeto);
                         consulta.setDouble(16, OtrasDeducciones);
                         consulta.setDouble(17, SalarioPagar);
                         consulta.setDouble(18, INNS_P);
                         consulta.setDouble(19, INATEC);
                         consulta.setDouble(20, Vacaciones);
                         consulta.setDouble(21, TreceavoMes);
        
                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de La Nómina Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

public static void Pagar_Nomina(int NoNomina){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Pagar_Nomina] (?)}");

                         consulta.setInt(1, NoNomina);
                        
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Nómina Pagada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }


    }

 

    
}
