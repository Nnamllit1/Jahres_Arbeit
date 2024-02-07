import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.02.2024
 * @author 
 */

public class main extends JFrame {
  // Anfang Attribute
  static int max_uboot = 10;
  static int max_x = 10;
  static int max_y = 10;
  static int [] [] game_field = new int [max_x] [max_y];
  
  private JTable jTable1 = new JTable(1, 1);
    private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
    private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  // Ende Attribute
  
  public main() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1000; 
    int frameHeight = 500;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("main");
    setResizable(true);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jTable1ScrollPane.setBounds(0, 0, 500, 500);
    jTable1.setRowSelectionAllowed(false);
    jTable1.setEnabled(false);
    jTable1.setFillsViewportHeight(false);
    jTable1.getColumnModel().getColumn(0).setHeaderValue("");
    cp.add(jTable1ScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public main
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new main();
  } // end of main
  
  // Ende Methoden
} // end of class main

