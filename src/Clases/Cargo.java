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
public class Cargo {
    


public static void Agregar_Cargo (String Nombre, double Salario){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Cargo] (?,?)}");

                
                        consulta.setString(1, Nombre);
                        consulta.setDouble(2, Salario);

                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Cargo Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

public static void Modificar_Cargo(int ID, String Nombre, double Salario){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Modificar_Cargo] (?,?,?)}");

                        consulta.setInt(1, ID);
                        consulta.setString(2, Nombre);
                        consulta.setDouble(3, Salario);

                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Cargo Modificados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

    
}
