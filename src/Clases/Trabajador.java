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
public class Trabajador {
    


public static void Agregar_Trabajador(String NoInss, String NumCedula, String Nombres, String Apellidos,
        String Sexo, String Telefono, int ID_Cargo, double Salario, int Antiguedad, int ID_Departamento ){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Trabajador] (?,?,?,?,?,?,?,?,?,?)}");

                
                         consulta.setString(1, NoInss);
                         consulta.setString(2, NumCedula);
                         consulta.setString(3, Nombres);
                         consulta.setString(4, Apellidos);
                         consulta.setString(5, Sexo);
                         consulta.setString(6, Telefono);
                         consulta.setInt(7,ID_Cargo );
                         consulta.setDouble(8, Salario);
                         consulta.setInt(9, Antiguedad);
                         consulta.setInt(10, ID_Departamento);
                        
                        

                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Trabajador Guardado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }



        

    }

public static void Modificar_Trabajador(int ID,String NoInss, String NumCedula, String Nombres, 
        String Apellidos, String Sexo, String Telefono, int ID_Cargo, double Salario, int Antiguedad, 
        int ID_Departamento){

    
 
        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Modificar_Trabajador] (?,?,?,?,?,?,?,?,?,?,?)}");

                         consulta.setInt(1, ID);
                         consulta.setString(2, NoInss);
                         consulta.setString(3, NumCedula);
                         consulta.setString(4, Nombres);
                         consulta.setString(5, Apellidos);
                         consulta.setString(6, Sexo);
                         consulta.setString(7, Telefono);
                         consulta.setInt(8,ID_Cargo );
                         consulta.setDouble(9, Salario);
                         consulta.setInt(10, Antiguedad);
                         consulta.setInt(11, ID_Departamento);
                        

                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Trabajador Modificados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

     }   catch (SQLException ex) {     
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
  }


    }

 

public static void Activar_Desactivar_Trabajador(int ID){
  
      ResultSet resultado;
      
      String estado = null;
      
    try{
        
          
            resultado = Conexion.consulta("Select [Estado_Trabajador] from [dbo].[Trabajador] where [ID_Trabajador] = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Trabajador] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Trabajador Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Trabajador] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Trabajador Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}

    
}
