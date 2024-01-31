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

public class main_test extends JFrame {
  // Anfang Attribute
  private JTable jTable1 = new JTable(max_x, max_y);
    private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
    private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  static int max_uboot = 10;
  static int max_x = 10;
  static int max_y = 10;
  // Ende Attribute
  
  public main_test() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 500; 
    int frameHeight = 500;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("main_test_Frame");
    setResizable(true);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jTable1ScrollPane.setBounds(0, 0, 0, 0);
    jTable1.setAutoCreateRowSorter(false);
    jTable1.setRowSelectionAllowed(false);
    jTable1.setEnabled(false);
    jTable1.setCellSelectionEnabled(false);
    jTable1.setDragEnabled(false);
    jTable1ScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    jTable1ScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jTable1.setRowHeight(10);
    jTable1.setFillsViewportHeight(false);
    jTable1.getColumnModel().getColumn(0).setHeaderValue("Title 1");
    jTable1.getColumnModel().getColumn(1).setHeaderValue("Title 2");
    jTable1.getColumnModel().getColumn(2).setHeaderValue("Title 3");
    jTable1.getColumnModel().getColumn(3).setHeaderValue("Title 4");
    jTable1.getColumnModel().getColumn(4).setHeaderValue("Title 5");
    cp.add(jTable1ScrollPane);
   // Ende Komponenten
    setup_JTabel();
    setVisible(true);
  } // end of public main_test
  
  // Anfang Methoden
  
  public void setup_JTabel() {
    jTable1.setBounds(0, 0, (max_x*20), (max_y*20));
  }
  
  public static void main(String[] args) {
    new main_test();
  } // end of main
  
  // Ende Methoden
} // end of class main_test

