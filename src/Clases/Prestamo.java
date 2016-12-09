/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Reymundo Tenorio
 */
public class Prestamo {
    


public static void Agregar_Prestamo (int ID_Trabajador, double Prestamo, int Dia, int Mes, int Anio){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Prestamo] (?,?,?,?,?)}");

                        consulta.setInt(1, ID_Trabajador);
                        consulta.setDouble(2, Prestamo);
                        consulta.setInt(3, Dia);
                        consulta.setInt(4, Mes);
                        consulta.setInt(5, Anio);
                       

                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Préstamo Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

public static void Modificar_Prestamo(int ID, int ID_Trabajador, double Prestamo, int Dia, int Mes, int Anio){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Modificar_Prestamo] (?,?,?,?,?,?)}");

                        consulta.setInt(1, ID);
                        consulta.setInt(2, ID_Trabajador);
                        consulta.setDouble(3, Prestamo);
                        consulta.setInt(4, Dia);
                        consulta.setInt(5, Mes);
                        consulta.setInt(6, Anio);
                        

                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Préstamo Modificados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

public static void Pagar_Prestamo(int ID){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Pagar_Prestamo] (?)}");

                        consulta.setInt(1, ID);
                       
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Préstamo Pagado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

    
}
