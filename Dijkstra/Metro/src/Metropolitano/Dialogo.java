package Metropolitano;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dialogo extends JDialog {
    
    /** Creates a new instance of Dialogo */
    public Dialogo(JFrame a,String mensaje) {
        super(a, " ", true);
        setTitle("Acerca");        
        JDesktopPane jDesktopPane1 = new javax.swing.JDesktopPane();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTextArea jTextArea1 = new javax.swing.JTextArea();
        JButton jButton1 = new javax.swing.JButton();
        jDesktopPane1.setBackground(new java.awt.Color(0, 102, 255));
        jTextArea1.setBackground(new java.awt.Color(0, 102, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jTextArea1.setText(mensaje);
        jScrollPane1.setViewportView(jTextArea1);      
        jScrollPane1.setBounds(50, 30, 330, 210);
        jDesktopPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                setVisible(false);
            }
        });
        jButton1.setBounds(150, 250, 110, 23);
        jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        org.jdesktop.layout.GroupLayout jDialog1Layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );
        pack();
    }
    
}
