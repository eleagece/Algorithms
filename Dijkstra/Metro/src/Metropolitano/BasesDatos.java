/*
 * BasesDatos.java
 *
 * Created on 18 de abril de 2007, 23:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Metropolitano;
import java.sql.*;
/**
 *
 * @author Antonio
 */
public class BasesDatos {
    Connection con; 
    Statement st; 
    ResultSet rs;
    /** Creates a new instance of BasesDatos */
  public BasesDatos() {
    }
  //Crea una conexión a la base de datos
  public void abrirConexion() { 
      try { String userName="root"; 
            String password="686078126123";
            String bd = "Metro";
            String url="jdbc:mysql://localhost/"+bd; 
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            con = DriverManager.getConnection(url, userName, password); 
            System.out.println("Conexión a la BD"); 
        } catch (Exception e) { 
            System.out.println("Error en conexión "); 
         } 
  }
  //Creación de la tabla usuarios
  public void crear(){
    try{
       st=con.createStatement();
       st.executeUpdate("CREATE TABLE Usuarios"+
               "(DNI INTEGER UNSIGNED DEFAULT NULL,"+
        "Nombre VARCHAR(45) NOT NULL, Apellido1 VARCHAR(45) NOT NULL,"+
        "Apellido2 VARCHAR(45) NOT NULL, Email VARCHAR(45) NOT NULL,"+
        "Usuario VARCHAR(45) NOT NULL, Password VARCHAR(45) NOT NULL,"+
        "Activo BOOLEAN NOT NULL, "+
        "PRIMARY KEY(DNI))"); 
    }catch (SQLException e) { 
          System.out.println("Error al crear la tabla"); 
      }   
  }
  //Cierra una conexión a la base de datos
  public void cerrarConexion() { 
      try { 
          con.close(); 
          System.out.println("Conexión cerrada"); 
      } catch (SQLException e) { 
          System.out.println("Error al cerrar conexión"); 
      } }
  //Inserta una fila de información en la tabla
  public void insertar(int dni,String nombre,String apellido1, String apellido2, String email, String usuario, String password, boolean activo) { 
      try{ 
          st = con.createStatement(); 
          st.executeUpdate( "INSERT INTO usuarios (DNI,Nombre,Apellido1,Apellido2,Email,Usuario,Password, Activo) values ('" 
                  + dni + "', '" + nombre + "', '" + apellido1 + "' ,'" + apellido2 + "','" + email + "','" + usuario + "','" + password + "',"+activo+")"); 
          System.out.println("Elemento insertado"); 
      } catch(SQLException e) { 
          //System.out.println("Error al insertar "); 
      } 
     }
  //Modifica una columna de la tabla
  public void modificar(String columna, String valor, int dni) { 
      try { 
          st=con.createStatement(); 
          st.executeUpdate("Update usuarios set "+columna+"='"+ valor + "' where DNI="+dni); 
          System.out.println("Elemento modificado correctamente"); 
      }catch (SQLException e) { 
          System.out.println("Error al modificar"); 
      } 
  }
  
    //Modifica una columna de la tabla
  public void activar(int dni, boolean activa) { 
      try { 
          st=con.createStatement(); 
          st.executeUpdate("Update usuarios set Activo="+ activa + " where DNI="+dni); 
          System.out.println("Elemento modificado correctamente"); 
      }catch (SQLException e) { 
          System.out.println("Error al modificar"); 
      } 
  }
  
 //Elimina una fila de la tabla
 public void borrar(int dni) { 
     try{ 
         st=con.createStatement(); 
         st.executeUpdate( "DELETE FROM usuarios where DNI="+dni); 
         System.out.println("Elemento Borrado"); 
     }catch(SQLException e) { 
         System.out.println("Error al Borrar"); 
     } 
 } 
 //Recuperar datos de la tabla
 public boolean obtenerDatosTabla(int dni) { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM usuarios where DNI="+dni); 
         System.out.println("Tabla abierta");
         return rs.next();
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     return false;
 }
 
  //Recuperar datos de la tabla
 public void obtenerDatos() { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM usuarios"); 
         System.out.println("Tabla abierta");
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
 }
 
 //Permite visualizar los datos de una consulta
 public void mostrarDatos() { 
     try { 
         while (rs.next()) { 
              String strnombre = rs.getString("Nombre"); 
              String strape1 = rs.getString("Apellido1"); 
              String strape2 = rs.getString("Apellido2"); 
              String stremail = rs.getString("Email"); 
              String strusu = rs.getString("Usuario"); 
              String strpass = rs.getString("Password"); 
              int intdni = rs.getInt("DNI");
              boolean activ=rs.getBoolean("Activo");
              System.out.println(strnombre+ ", " + strape1 + ", " + strape2 + ", " + stremail + ", " + strusu + ", " + strpass + ", " + intdni+","+activ);
         } 
              
     } catch (Exception e) { 
         System.out.println("Error al visualizar datos"); 
     } 
   }

 public boolean seleccionaUsuarios(String usuario, String password){
     try {  
         st =con.createStatement();  
         rs = st.executeQuery("SELECT Usuario FROM usuarios where Usuario='"+usuario+"' AND Activo=true AND Password='"+password+"'");  
         System.out.println("Tabla abierta");          
         return rs.next();
     } catch (SQLException e) {  
         System.out.println("Error al Abrir tabla ");  
     } 
     return false;
 }
}


