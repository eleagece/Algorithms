/*
 * BBDD.java
 *
 * Created on 17 de mayo de 2007, 18:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Gestion;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Antonio
 */
public class BBDD {
    Connection con;
    Statement st;
    ResultSet rs;
    /** Creates a new instance of BasesDatos */
    public BBDD() {
    }
    //Crea una conexión a la base de datos
    public void abrirConexion() {
        try { String userName="root";
        String password="";
        String bd = "Sudoku";
        String url="jdbc:mysql://localhost/"+bd;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(url, userName, password);
        System.out.println("Conexión a la BD");
        } catch (Exception e) {
            System.out.println("Error en conexión ");
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
    
/*********************************************************************************************************
 *
 *                  USUARIOS
 *
 *********************************************************************************************************/    
    //Creación de la tabla usuarios
    public void crearTusuarios(){
        try{
            st=con.createStatement();
            st.executeUpdate("CREATE TABLE Usuarios"+
                    "(DNI INTEGER UNSIGNED DEFAULT NULL,"+
                    "Nombre VARCHAR(45) NOT NULL, Apellido1 VARCHAR(45) NOT NULL,"+
                    "Apellido2 VARCHAR(45) NOT NULL, Email VARCHAR(45) NOT NULL,"+
                    "Usuario VARCHAR(45) NOT NULL, Password VARCHAR(45) NOT NULL,"+
                    "Perfil VARCHAR(45) NOT NULL, Puntos INTEGER UNSIGNED ZEROFILL NOT NULL,"+
                    "PRIMARY KEY(DNI))");
        }catch (SQLException e) {
            System.out.println("Error al crear la tabla");
        }
    }
    
    //Modifica una columna de la tabla
    public void modificarTusuarios(String columna, Object valor, int dni) {
        try {
            st=con.createStatement();
            st.executeUpdate("Update Usuarios set "+columna+"='"+ valor + "' where DNI="+dni);
            System.out.println("Elemento modificado correctamente");
        }catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }
    
    //Elimina una fila de la tabla
    public void borrarTusuarios(int dni) {
        try{
            st=con.createStatement();
            st.executeUpdate( "DELETE FROM Usuarios where DNI="+dni);
            System.out.println("Elemento Borrado");
        }catch(SQLException e) {
            System.out.println("Error al Borrar");
        }
    }
    
    //Inserta una fila de información en la tabla
    public void insertarTusuarios(int dni,String nombre,String apellido1, String apellido2, String email, String usuario, String password, String perfil, int puntos) {
        try{
            st = con.createStatement();
            st.executeUpdate( "INSERT INTO Usuarios (DNI,Nombre,Apellido1,Apellido2,Email,Usuario,Password, Perfil, Puntos) values ('"+ dni + "', '" + nombre + "', '" + apellido1 + "', '" + apellido2 + "', '" + email + "', '" + usuario + "','" + password + "', '" + perfil + "', '"+puntos+"')");
            System.out.println("Elemento insertado");
        } catch(SQLException e) {
            System.out.println("Error al insertar ");
        }
    }
    
    public void sumapuntosTusuarios(int dni,int puntos){
        try {
            st=con.createStatement();
            rs = st.executeQuery("SELECT Puntos FROM Usuarios where DNI="+dni);
            rs.next();
            puntos = puntos + rs.getInt("Puntos");
            st.executeUpdate("Update Usuarios set Puntos="+ puntos + " where DNI="+dni);
            System.out.println("Elemento modificado correctamente");
        }catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }
    
    //Recuperar datos de la tabla
    public String obtenerDatosTusuarios(int dni, String columna) {
        try {
            st =con.createStatement();
            rs = st.executeQuery("SELECT "+columna+" FROM Usuarios where DNI="+dni);
            System.out.println("Tabla abierta");
            rs.next();
            return rs.getString(columna);
        } catch (SQLException e) {
            System.out.println("Error al Abrir tabla ");
        }
        return "";
    }
    
 //Recuperar datos de la tabla
 public boolean compruebaDNI(int dni) { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM Usuarios where DNI='"+dni+"'"); 
         System.out.println("Tabla abierta");
         return rs.next();
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     return false;
 }
 
  //Recuperar datos de la tabla
 public boolean compruebaUsuario(String usuario) { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM Usuarios where Usuario='"+usuario+"'"); 
         System.out.println("Tabla abierta");
         return rs.next();
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     return false;
 } 
 
  public boolean seleccionaUsuarios(String usuario, String password){
     try {  
         st =con.createStatement();  
         rs = st.executeQuery("SELECT Usuario FROM Usuarios where Usuario='"+usuario+"' AND Password='"+password+"'");  
         System.out.println("Tabla abierta");          
         return rs.next();
     } catch (SQLException e) {  
         System.out.println("Error al Abrir tabla ");  
     } 
     return false;
 }
  
  public int obtenerDNI(String usuario){
     try {  
         st =con.createStatement();  
         rs = st.executeQuery("SELECT DNI FROM Usuarios where Usuario='"+usuario+"'");  
         System.out.println("Tabla abierta");          
         rs.next();
         return rs.getInt("DNI");
     } catch (SQLException e) {  
         System.out.println("Error al Abrir tabla ");  
     } 
     return 0;
 }  
  
 public ArrayList obtenerTusuarios() { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT Usuario FROM Usuarios"); 
         System.out.println("Tabla abierta");
         ArrayList usuarios = new ArrayList();
         while(rs.next()){
             //ArrayList s = new ArrayList();
             usuarios.add(rs.getString("Usuario"));
         }
         return usuarios;
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList usuarios = new ArrayList();
     return usuarios;
 }     
 
  public ArrayList obtenerTusuario(int dni) { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM Usuarios WHERE DNI='"+dni+"'"); 
         System.out.println("Tabla abierta");
         ArrayList usuario = new ArrayList();
         while(rs.next()){
             //ArrayList s = new ArrayList();
             usuario.add(rs.getString("Usuario"));
             usuario.add(rs.getString("Puntos"));
             usuario.add(rs.getString("Nombre"));
             usuario.add(rs.getString("Apellido1"));
             usuario.add(rs.getString("Apellido2"));             
             usuario.add(rs.getString("Email"));
             usuario.add(rs.getString("DNI"));
             usuario.add(rs.getString("Password"));            
         }
         return usuario;
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList usuarios = new ArrayList();
     return usuarios;
 }    
  
 public ArrayList obtenerTusuarioss() { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM Usuarios"); 
         System.out.println("Tabla abierta");
         ArrayList usuarios = new ArrayList();
         while(rs.next()){
             ArrayList usuario = new ArrayList();
             usuario.add(rs.getString("Nombre"));
             usuario.add(rs.getString("Apellido1"));
             usuario.add(rs.getString("Apellido2"));             
             usuario.add(rs.getString("Email"));
             usuario.add(rs.getString("DNI"));
             usuario.add(rs.getString("Usuario"));             
             usuario.add(rs.getString("Password")); 
             usuario.add(rs.getString("Perfil")); 
             usuario.add(rs.getString("Puntos"));             
             usuarios.add(usuario);
         }
         return usuarios;
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList usuarios = new ArrayList();
     return usuarios;
 }     
  
    
/*********************************************************************************************************
 *
 *                  SUDOKUS
 *
 *********************************************************************************************************/ 

    //Creación de la tabla sudokus
    public void crearTsudokus(){
        try{
            st=con.createStatement();
            st.executeUpdate("CREATE TABLE sudokus"+
                    "(ID INTEGER UNSIGNED NOT NULL,"+
                    "Nombre VARCHAR(45) NOT NULL, Dificultad INTEGER UNSIGNED NOT NULL,"+
                    "PRIMARY KEY(ID))");
        }catch (SQLException e) {
            System.out.println("Error al crear la tabla");
        }
    }    
    
    
    //Modifica una columna de la tabla
    public void modificarTsudokus(String columna, Object valor, int id) {
        try {
            st=con.createStatement();
            st.executeUpdate("Update sudokus set "+columna+"='"+ valor + "' where ID="+id);
            System.out.println("Elemento modificado correctamente");
        }catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }
    
    //Elimina una fila de la tabla
    public void borrarTsudokus(int id) {
        try{
            st=con.createStatement();
            st.executeUpdate( "DELETE FROM sudokus where ID="+id);
            System.out.println("Elemento Borrado");
        }catch(SQLException e) {
            System.out.println("Error al Borrar");
        }
    }
    
    //Inserta una fila de información en la tabla
    public void insertarTsudokus(int id,String nombre,int dificultad) {
        try{
            st = con.createStatement();
            st.executeUpdate( "INSERT INTO sudokus (ID,Nombre,Dificultad) values ('"+ id + "', '" + nombre + "',"+dificultad+")");
            System.out.println("Elemento insertado");
        } catch(SQLException e) {
            System.out.println("Error al insertar ");
        }
    }
  
    
        public void sumadificultadTsudokus(int id,int dificultad){
        try {
            st=con.createStatement();
            rs = st.executeQuery("SELECT Dificultad FROM sudokus where ID="+id);
            rs.next();
            dificultad = dificultad + rs.getInt("Dificultad");
            st.executeUpdate("Update sudokus set Dificultad="+ dificultad + " where ID="+id);
            System.out.println("Elemento modificado correctamente");
        }catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }
    
        
    //Recuperar datos de la tabla
    public Object obtenerDatosTsudokus(int id, String columna) {
        try {
            st =con.createStatement();
            rs = st.executeQuery("SELECT "+columna+" FROM sudokus where ID="+id);
            System.out.println("Tabla abierta");
            rs.next();
            return rs.getObject(columna);
        } catch (SQLException e) {
            System.out.println("Error al Abrir tabla ");
        }
        return "";
    }        
    
    //Recuperar datos de la tabla
    public int obtenerIDTsudokus(String Nombre) {
        try {
            st =con.createStatement();
            rs = st.executeQuery("SELECT ID FROM sudokus where Nombre='"+Nombre+"'");
            System.out.println("Tabla abierta");
            rs.next();
            return rs.getInt("ID");
        } catch (SQLException e) {
            System.out.println("Error al Abrir tabla ");
        }
        return 0;
    }         
        
  //Recuperar datos de la tabla
 public ArrayList obtenerTsudokus() { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM sudokus"); 
         System.out.println("Tabla abierta");
         ArrayList sudokus = new ArrayList();
         while(rs.next()){
             //ArrayList s = new ArrayList();
             sudokus.add(rs.getString("Nombre"));
         }
         return sudokus;
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList sudokus = new ArrayList();
     return sudokus;
 }    
    
 
  public ArrayList obtenerTsudokuss() { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM sudokus"); 
         System.out.println("Tabla abierta");
         ArrayList sudokus = new ArrayList();
         while(rs.next()){
             ArrayList sudoku = new ArrayList();
             sudoku.add(rs.getString("ID"));
             sudoku.add(rs.getString("Nombre"));
             sudoku.add(rs.getString("Dificultad"));
             sudokus.add(sudoku);
         }
         return sudokus;
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList sudokus = new ArrayList();
     return sudokus;
 }   
 
  public ArrayList obtenerTsudokusordenados() { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM sudokus ORDER BY Dificultad"); 
         System.out.println("Tabla abierta");
         ArrayList sudokus = new ArrayList();
         while(rs.next()){
             ArrayList sudoku = new ArrayList();
             sudoku.add(rs.getString("ID"));
             sudoku.add(rs.getString("Nombre"));
             sudoku.add(rs.getString("Dificultad"));
             sudokus.add(sudoku);
         }
         return sudokus;
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList sudokus = new ArrayList();
     return sudokus;
 }     
    
    public int maxSudoku() {
        try {
            st =con.createStatement();
            rs = st.executeQuery("SELECT MAX(ID) AS maximo FROM sudokus");
            System.out.println("Tabla abierta");
            rs.next();
            return rs.getInt("maximo");
        } catch (SQLException e) {
            System.out.println("Error al Abrir tabla ");
        }
        return 0;
    }   
  
  
/*********************************************************************************************************
 *
 *                  ESTADO COMPETICION
 *
 *********************************************************************************************************/     

    
//Creación de la tabla estadocompeticion
    public void crearTestadocompeticion(){
        try{
            st=con.createStatement();
            st.executeUpdate(
                    "CREATE TABLE estadocompeticion"+
                    "(ID INTEGER UNSIGNED NOT NULL,"+
                    "DNI INTEGER UNSIGNED NOT NULL,"+
                    "Puntos INTEGER UNSIGNED NOT NULL,"+
                    "Sudoku1 BOOLEAN NOT NULL,"+
                    "Sudoku2 BOOLEAN NOT NULL,"+
                    "Sudoku3 BOOLEAN NOT NULL,"+
                    "Sudoku4 BOOLEAN NOT NULL,"+
                    "PRIMARY KEY(ID,DNI))");
        }catch (SQLException e) {
            System.out.println("Error al crear la tabla");
        }
    }
    
    
//Modifica una columna de la tabla
    public void modificarTestadocompeticion(String columna, Object valor, int id, int dni) {
        try {
            st=con.createStatement();
            String md = "Update estadocompeticion set "+columna+"="+ valor + " where ID="+id+" AND DNI="+dni;
            st.executeUpdate(md);
            System.out.println("Elemento modificado correctamente");
        }catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }
    
    //Elimina una fila de la tabla
    public void borrarTestadocompeticion(int id,int dni) {
        try{
            st=con.createStatement();
            st.executeUpdate( "DELETE FROM estadocompeticion where ID="+id+" AND DNI="+dni);
            System.out.println("Elemento Borrado");
        }catch(SQLException e) {
            System.out.println("Error al Borrar");
        }
    }
    
    //Inserta una fila de información en la tabla
    public void insertarTestadocompeticion(int id,int dni, int puntos,boolean sudoku1,boolean sudoku2,boolean sudoku3,boolean sudoku4) {
        try{
            st = con.createStatement();
            st.executeUpdate( "INSERT INTO estadocompeticion (ID,DNI,Puntos,Sudoku1,Sudoku2,Sudoku3,Sudoku4) values ("
                    + id + ", "+ dni + ","+puntos+","+sudoku1+","+sudoku2+","+sudoku3+","+sudoku4+")");
            System.out.println("Elemento insertado");
        } catch(SQLException e) {
            System.out.println("Error al insertar ");
        }
    }
  
    
        public void sumapuntosTestadocompeticion(int id,int dni, int puntos){
        try {
            st=con.createStatement();
            rs = st.executeQuery("SELECT Puntos FROM estadocompeticion where ID="+id);
            rs.next();
            puntos = puntos + rs.getInt("Puntos");
            st.executeUpdate("Update estadocompeticion set Puntos="+ puntos + " where ID="+id+" AND DNI="+dni);
            System.out.println("Elemento modificado correctamente");
        }catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }
    
        
    //Recuperar datos de la tabla
    public Object obtenerDatosTestadocompeticion(int id, int dni, String columna) {
        try {
            st =con.createStatement();
            rs = st.executeQuery("SELECT "+columna+" FROM estadocompeticion where ID="+id+" AND DNI="+dni);
            System.out.println("Tabla abierta");
            rs.next();
            return rs.getObject(columna);
        } catch (SQLException e) {
            System.out.println("Error al Abrir tabla ");
        }
        return "";
    }      
    
 public ArrayList obtenerCompeticiones(int dni) { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM estadocompeticion WHERE DNI='"+dni+"'"); 
         System.out.println("Tabla abierta");
         ArrayList competiciones = new ArrayList();
         while(rs.next()){
             ArrayList comp = new ArrayList();
             comp.add(rs.getInt("ID"));
             comp.add(rs.getInt("Puntos"));             
             comp.add(rs.getBoolean("Sudoku1"));
             comp.add(rs.getBoolean("Sudoku2"));
             comp.add(rs.getBoolean("Sudoku3"));
             comp.add(rs.getBoolean("Sudoku4"));

             competiciones.add(comp);
         }
         return competiciones;         
         
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList competiciones = new ArrayList();
     return competiciones;     
 }    
   
 
 public ArrayList obtenerEstadoCompeticiones() { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM estadocompeticion"); 
         System.out.println("Tabla abierta");
         ArrayList competiciones = new ArrayList();
         while(rs.next()){
             ArrayList comp = new ArrayList();
             comp.add(rs.getInt("ID"));
             comp.add(rs.getInt("DNI"));
             comp.add(rs.getInt("Puntos"));             
             comp.add(rs.getBoolean("Sudoku1"));
             comp.add(rs.getBoolean("Sudoku2"));
             comp.add(rs.getBoolean("Sudoku3"));
             comp.add(rs.getBoolean("Sudoku4"));

             competiciones.add(comp);
         }
         return competiciones;         
         
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList competiciones = new ArrayList();
     return competiciones;     
 }   
 
 
 public ArrayList obtenerGanador(int id) { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM estadocompeticion WHERE ID='"+id+"'"); 
         System.out.println("Tabla abierta");
         ArrayList competiciones = new ArrayList();
         while(rs.next()){
             ArrayList comp = new ArrayList();
             comp.add(rs.getInt("ID"));
             comp.add(rs.getInt("DNI"));
             comp.add(rs.getInt("Puntos"));             
             comp.add(rs.getBoolean("Sudoku1"));
             comp.add(rs.getBoolean("Sudoku2"));
             comp.add(rs.getBoolean("Sudoku3"));
             comp.add(rs.getBoolean("Sudoku4"));

             competiciones.add(comp);
         }
         return competiciones;         
         
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList competiciones = new ArrayList();
     return competiciones;     
 }   
 
    
/*********************************************************************************************************
 *
 *                  COMPETICION
 *
 *********************************************************************************************************/     
    
    
    
//Creación de la tabla competicion
    public void crearTcompeticion(){
        try{
            st=con.createStatement();
            st.executeUpdate(
                    "CREATE TABLE competicion"+
                    "(ID INTEGER UNSIGNED DEFAULT NULL,"+
                    "Sudoku1 INTEGER UNSIGNED NOT NULL,"+
                    "Sudoku2 INTEGER UNSIGNED NOT NULL,"+
                    "Sudoku3 INTEGER UNSIGNED NOT NULL,"+
                    "Sudoku4 INTEGER UNSIGNED NOT NULL,"+
                    "Tiempo INTEGER UNSIGNED NOT NULL,"+
                    "PRIMARY KEY(ID))");
        }catch (SQLException e) {
            System.out.println("Error al crear la tabla");
        }
    }    
    

    //Modifica una columna de la tabla
    public void modificarTcompeticion(String columna, Object valor, int id) {
        try {
            st=con.createStatement();
            st.executeUpdate("Update competicion set "+columna+"='"+ valor + "' where ID="+id);
            System.out.println("Elemento modificado correctamente");
        }catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }
    
    //Elimina una fila de la tabla
    public void borrarTcompeticion(int id) {
        try{
            st=con.createStatement();
            st.executeUpdate( "DELETE FROM competicion where ID="+id);
            System.out.println("Elemento Borrado");
        }catch(SQLException e) {
            System.out.println("Error al Borrar");
        }
    }
    
    //Inserta una fila de información en la tabla
    public void insertarTcompeticion(int id,int sudoku1,int sudoku2,int sudoku3,int sudoku4, int tiempo) {
        try{
            st = con.createStatement();
            String coddd = "INSERT INTO competicion (ID,Sudoku1,Sudoku2,Sudoku3,Sudoku4,Tiempo) values ('"+id+"','"+ sudoku1 + "','"+sudoku2+"','"+sudoku3+"','"+sudoku4+"','"+tiempo+"')";
            st.executeUpdate(coddd);
            System.out.println("Elemento insertado");
        } catch(SQLException e) {
            System.out.println("Error al insertar ");
        }
    }
    
        
    //Recuperar datos de la tabla
    public Object obtenerDatosTcompeticion(int id, String columna) {
        try {
            st =con.createStatement();
            rs = st.executeQuery("SELECT "+columna+" FROM competicion where ID="+id);
            System.out.println("Tabla abierta");
            rs.next();
            return rs.getObject(columna);
        } catch (SQLException e) {
            System.out.println("Error al Abrir tabla ");
        }
        return "";
    }            
    
    //Recuperar datos de la tabla
    public int maxCompeticiones() {
        try {
            st =con.createStatement();
            rs = st.executeQuery("SELECT MAX(ID) AS maximo FROM competicion");
            System.out.println("Tabla abierta");
            rs.next();
            return rs.getInt("maximo");
        } catch (SQLException e) {
            System.out.println("Error al Abrir tabla ");
        }
        return 0;
    }                
    
  //Recuperar datos de la tabla
 public ArrayList obtenerTcompeticiones() { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM competicion"); 
         System.out.println("Tabla abierta");
         ArrayList competiciones = new ArrayList();
         while(rs.next()){
             //ArrayList s = new ArrayList();
             competiciones.add(rs.getString("Nombre"));
         }
         return competiciones;
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList competiciones = new ArrayList();
     return competiciones;
 }     
    
  //Recuperar datos de la tabla
 public ArrayList obtenerTcompeticioness() { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM competicion"); 
         System.out.println("Tabla abierta");
         ArrayList competiciones = new ArrayList();
         while(rs.next()){
             ArrayList competicion = new ArrayList();
             competicion.add(rs.getString("ID"));
             competicion.add(rs.getString("Sudoku1"));
             competicion.add(rs.getString("Sudoku2"));
             competicion.add(rs.getString("Sudoku3"));
             competicion.add(rs.getString("Sudoku4"));
             competicion.add(rs.getString("Tiempo"));
             competiciones.add(competicion);
         }
         return competiciones;
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList competiciones = new ArrayList();
     return competiciones;
 }   
 
 public ArrayList seleccionaCompeticion(int id) { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM competicion WHERE ID='"+id+"'"); 
         System.out.println("Tabla abierta");
         ArrayList competicion = new ArrayList();
         while(rs.next()){
            // ArrayList competicion = new ArrayList();
             competicion.add(rs.getString("ID"));
             competicion.add(rs.getInt("Sudoku1"));
             competicion.add(rs.getInt("Sudoku2"));
             competicion.add(rs.getInt("Sudoku3"));
             competicion.add(rs.getInt("Sudoku4"));
             competicion.add(rs.getInt("Tiempo"));
             //competiciones.add(competicion);
         }
         return competicion;
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList competiciones = new ArrayList();
     return competiciones;
 }    
    
/*********************************************************************************************************
 *
 *                  CONFIGURACION
 *
 *********************************************************************************************************/     
    
    
//Creación de la tabla configuracion
    public void crearTconfiguracion(){
        try{
            st=con.createStatement();
            st.executeUpdate(
                    "CREATE TABLE configuracion"+
                    "(concepto VARCHAR(45) NOT NULL,"+
                    "valor INTEGER UNSIGNED NOT NULL,"+
                    "PRIMARY KEY(concepto))");
        }catch (SQLException e) {
            System.out.println("Error al crear la tabla");
        }
    }    
    
    
    //Modifica una columna de la tabla
    public void modificarTconfiguracion(String columna, Object valor, String concepto) {
        try {
            st=con.createStatement();
            st.executeUpdate("Update configuracion set "+columna+"='"+ valor + "' where concepto='"+concepto+"'");
            System.out.println("Elemento modificado correctamente");
        }catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }
    
    //Elimina una fila de la tabla
    public void borrarTconfiguracion(String concepto) {
        try{
            st=con.createStatement();
            st.executeUpdate( "DELETE FROM configuracion where concepto='"+concepto+"'");
            System.out.println("Elemento Borrado");
        }catch(SQLException e) {
            System.out.println("Error al Borrar");
        }
    }
    
    //Inserta una fila de información en la tabla
    public void insertarTconfiguracion(String concepto, int valor) {
        try{
            st = con.createStatement();
            st.executeUpdate( "INSERT INTO configuracion (concepto,valor) values ('"+ concepto + "', '"+ valor+"')");
            System.out.println("Elemento insertado");
        } catch(SQLException e) {
            System.out.println("Error al insertar ");
        }
    }
  
       
    //Recuperar datos de la tabla
    public Object obtenerDatosTconfiguracion(String concepto, String columna) {
        try {
            st =con.createStatement();
            rs = st.executeQuery("SELECT "+columna+" FROM configuracion where concepto='"+concepto+"'");
            System.out.println("Tabla abierta");
            rs.next();
            return rs.getObject(columna);
        } catch (SQLException e) {
            System.out.println("Error al Abrir tabla ");
        }
        return "";
    }      

 public ArrayList obtenerTconfiguraciones() { 
     try { 
         st =con.createStatement(); 
         rs = st.executeQuery("SELECT * FROM configuracion"); 
         System.out.println("Tabla abierta");
         ArrayList configuraciones = new ArrayList();
         while(rs.next()){
             ArrayList configuracion = new ArrayList();
             configuracion.add(rs.getString("Concepto"));
             configuracion.add(rs.getString("valor"));
             configuraciones.add(configuracion);
         }
         return configuraciones;
     } catch (SQLException e) { 
         System.out.println("Error al Abrir tabla "); 
     }
     ArrayList configuraciones = new ArrayList();
     return configuraciones;
 }     
    
}
