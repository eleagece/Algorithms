/*
 * Principal.java
 *
 * Created on 9 de mayo de 2007, 23:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Principal;

import Algoritmos.Sudoku;
import Gestion.BBDD;
import Gestion.XML;
import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public class Principal {
    
    public static void main(String[] args){
        /*Gestion.XML Prueba = new XML();
        ArrayList sudoku = new ArrayList();
        sudoku = Prueba.leer("C:/ejemplo.xml");
        Prueba.escribir(sudoku,"C:/ejemplo2.xml");*/
        
        /*Algoritmos.Sudoku s = new Sudoku();
        int dev[] = s.Genera(60);
        System.out.println(dev[0]);
        System.out.println(dev[1]);
        System.out.println(dev[2]);
        s.imprimir();*/
        BBDD bd = new BBDD();
        bd.abrirConexion();
        
        ////////// USUARIOS ////////////////////////////
        bd.crearTusuarios();
        //bd.insertarTusuarios(25523432,"Alberto","lopez","rubio","al@gmail.com","AL","berto","algo",32);
        //bd.borrarTusuarios(25523432);
        //bd.modificarTusuarios("Nombre","Tata",25523432);
        //bd.sumapuntosTusuarios(25523432,43);
        //String ap = (String) bd.obtenerDatosTusuarios(25523432,"Apellido1");
        //System.out.println(ap);        
        
        ///////// COMPETICION /////////////////////////
        bd.crearTcompeticion();
        //bd.insertarTcompeticion(43,4,2,5,7,34,6);        
        //bd.borrarTcompeticion(43);
        //bd.modificarTcompeticion("Puntos",668,45);
        //bd.sumapuntosTcompeticion(45,4);
        //Object r = (Object)bd.obtenerDatosTcompeticion(45,"Sudoku1");
        //System.out.println(r);     
                
        //////////// CONFIGURACION ///////////////////
        bd.crearTconfiguracion();
        //bd.insertarTconfiguracion("Puntos_No",0);        
        //bd.borrarTconfiguracion("Puntos_No se que");
        //bd.modificarTconfiguracion("valor",5,"Puntos_Dificultad");
        //String val = (String) bd.obtenerDatosTconfiguracion("Puntos_Dificultad","valor");
        //System.out.println(val);
        
        //////////// ESTADO COMPETICION ///////////////
        bd.crearTestadocompeticion();
        //bd.insertarTestadocompeticion(15,23232,2,true,false,false,false);        
        //bd.borrarTestadocompeticion(15,23232);
        //bd.modificarTestadocompeticion("Puntos",6,12,23232);
        //bd.sumapuntosTestadocompeticion(12,23232,10);
        //Boolean b = (Boolean) bd.obtenerDatosTestadocompeticion(12,23232,"Sudoku2");
        //System.out.println(b);
        
        //////////// SUDOKUS /////////////////////////
        bd.crearTsudokus();
        //bd.insertarTsudokus(28,"Juan",3);
        //bd.borrarTsudokus(28);
        //bd.modificarTsudokus("Dificultad",777,23);
        //bd.sumadificultadTsudokus(28,20);
        //Object g = (Object) bd.obtenerDatosTsudokus(28,"Dificultad");
        //System.out.println(g);
        
        bd.cerrarConexion();
        
        
          Sudoku s=new Sudoku();
          int n=17;
          // RESOLVER SUDOKU GENERADO
          System.out.println("-----------------------");
          System.out.println("--- SUDOKU RESUELTO ---");
          System.out.println("-----------------------");
          s.resolverSudokuEntero(n);
    }
    
}
