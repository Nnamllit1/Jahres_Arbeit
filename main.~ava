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
  
  public JTable jTable_gamefielt = new JTable(1, 0);
    public DefaultTableModel jTable_gamefieltModel = (DefaultTableModel) jTable_gamefielt.getModel();
    public JScrollPane jTable_gamefieltScrollPane = new JScrollPane(jTable_gamefielt);
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
    
    jTable_gamefieltScrollPane.setBounds(0, 0, 500, 500);
    jTable_gamefielt.setRowSelectionAllowed(false);
    jTable_gamefielt.setEnabled(false);
    jTable_gamefielt.setFillsViewportHeight(false);
    jTable_gamefielt.setAutoCreateRowSorter(true);
    jTable_gamefielt.getColumnModel().getColumn(0).setHeaderValue("");
    cp.add(jTable_gamefieltScrollPane);
    // Ende Komponenten
    
    setVisible(true);
    game_fielt_abgleichen();
  } // end of public main
  
  // Anfang Methoden
  
  public void game_fielt_abgleichen() {
    for (int x = 0; x < max_x; x++) {
      jTable_gamefieltModel.addColumn(String.valueOf(x));
    }  
  }
  
  public static void main(String[] args) {
    new main();
  } // end of main
  
  // Ende Methoden
} // end of class main

