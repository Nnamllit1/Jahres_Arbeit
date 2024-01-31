import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 31.01.2024
 * @author 
 */

public class main_Window_and_main extends JFrame {
  // Anfang Attribute
  private JTable jTable1 = new JTable(5, 5);
    private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
    private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  // Ende Attribute
  
  public main_Window_and_main() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 600;
    int frameHeight = 600;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("main_Window_and_main");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jTable1ScrollPane.setBounds(90, 62, 300, 150);
    jTable1.getColumnModel().getColumn(0).setHeaderValue("Title 1");
    jTable1.getColumnModel().getColumn(1).setHeaderValue("Title 2");
    jTable1.getColumnModel().getColumn(2).setHeaderValue("Title 3");
    jTable1.getColumnModel().getColumn(3).setHeaderValue("Title 4");
    jTable1.getColumnModel().getColumn(4).setHeaderValue("Title 5");
    jTable1.setAutoCreateRowSorter(true);
    jTable1.setDragEnabled(false);
    cp.add(jTable1ScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public main_Window_and_main
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new main_Window_and_main();
  } // end of main
  
  // Ende Methoden
} // end of class main_Window_and_main

