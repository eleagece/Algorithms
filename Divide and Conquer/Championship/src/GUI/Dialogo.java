package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dialogo extends JDialog  // Hereda del contenedor JDialog (para ventanas secundarias) 
 {
 public Dialogo(JFrame a,String mensaje) 
  {
  // ---------------------------------------------------------------------------------//
  // CONSTRUCTOR del diálogo. Muestra mensaje (mensaje) de la ventana principal (a)   //
  // ---------------------------------------------------------------------------------//
  // *param* a:   //
  // *param* mensaje:                           //
  // ---------------------------------------------------------------------------------//
  super(a," ",true);
  Container contenido=getContentPane();
  contenido.add(new JLabel("<HTML><CENTER>"+mensaje+"</CENTER></HTML>"));
  JButton ok=new JButton("OK");  
  ok.addActionListener(new ActionListener()
   {
   public void actionPerformed(ActionEvent evt)
    {
    setVisible(false);
    }
   });
  JPanel panel=new JPanel();
  panel.add(ok);
  contenido.add(panel,BorderLayout.SOUTH);
  setSize(250,150);
  }
 }
