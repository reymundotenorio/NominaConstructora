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
public class Departamento {
    


public static void Agregar_Departamento(String Nombre){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Departamento] (?)}");

                
                        consulta.setString(1, Nombre);

                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Departamento Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

public static void Modificar_Departamento(int ID, String Nombre){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Modificar_Departamento] (?,?)}");

                        consulta.setInt(1, ID);
                        consulta.setString(2, Nombre);

                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Departamento Modificados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

    
}
