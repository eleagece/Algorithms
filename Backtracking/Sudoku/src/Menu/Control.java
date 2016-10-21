package Menu;
public class Control 
 {
 public static void main(String args[]) 
  {
  VentRaiz vRaiz=new VentRaiz();  // Creamos vRaiz
  vRaiz.setVisible(true);  // Hacemos visible vRaiz
  VentLogin vPpal=new VentLogin(vRaiz);  // Creamos vPpal con referencia a vRaiz
  vPpal.setVisible(true);  // Hacemos visible vPpal
  vPpal.setSize(2000,2000);  // Ponemos un tamaño que supere al de vRaiz
  vRaiz.add(vPpal);  // Añadimos vPpal a vRaiz
  vRaiz.pack();  // Empaquetamos vRaiz
  }    
 }
