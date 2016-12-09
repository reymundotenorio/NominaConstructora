/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Reymundo Tenorio
 */
public class HorasExtras {
    


public static void Agregar_Horas (int ID_Trabajador, int HorasExtras, int Dia, int Mes, int Anio){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_HrsExtras] (?,?,?,?,?)}");

                        consulta.setInt(1, ID_Trabajador);
                        consulta.setInt(2, HorasExtras);
                        consulta.setInt(3, Dia);
                        consulta.setInt(4, Mes);
                        consulta.setInt(5, Anio);
                       

                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de Las Horas Extras Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

public static void Modificar_Horas(int ID, int ID_Trabajador, int HorasExtras, int Dia, int Mes, int Anio){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Modificar_HrsExtras] (?,?,?,?,?,?)}");

                        consulta.setInt(1, ID);
                        consulta.setInt(2, ID_Trabajador);
                        consulta.setInt(3, HorasExtras);
                        consulta.setInt(4, Dia);
                        consulta.setInt(5, Mes);
                        consulta.setInt(6, Anio);
                        

                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos de Las Horas Extras Modificados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

public static void Pagar_Horas(int ID){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Pagar_HrsExtras] (?)}");

                        consulta.setInt(1, ID);
                       
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Horas Extras Pagadas Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

    
}
