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
  
  public JTable jTable_gamefielt = new JTable(0, 1);
    public DefaultTableModel jTable_gamefieltModel = (DefaultTableModel) jTable_gamefielt.getModel();
    public JScrollPane jTable_gamefieltScrollPane = new JScrollPane(jTable_gamefielt);
  public JTextArea jTextArea_gamelog = new JTextArea("");
    public JScrollPane jTextArea_gamelogScrollPane = new JScrollPane(jTextArea_gamelog);
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
    jTable_gamefielt.setAutoCreateRowSorter(false);
    jTable_gamefielt.getColumnModel().getColumn(0).setHeaderValue("");
    cp.add(jTable_gamefieltScrollPane);
    jTextArea_gamelogScrollPane.setBounds(500, 350, 300, 150);
    jTextArea_gamelog.setEditable(false);
    jTextArea_gamelog.setText("GAME LOG!!!");
    jTextArea_gamelog.setToolTipText("This is the game log!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    cp.add(jTextArea_gamelogScrollPane);
    // Ende Komponenten
    
    setVisible(true);
    
    
    game_field_fill();
    random_uboot_gen();
    game_fielt_abgleichen();
    
  } // end of public main
  
  // Anfang Methoden
  
  public void game_fielt_abgleichen() {
    for (int y = 0; y < max_y; y++) {
      jTable_gamefieltModel.addColumn(String.valueOf(y));
    }
    jTable_gamefieltModel.setRowCount(max_x);
    for (int x = 0; x < max_x; x++) {
      jTable_gamefieltModel.setValueAt(String.valueOf(x), x, 0);
      for (int y = 0; y < max_y; y++) {
        jTable_gamefieltModel.setValueAt(String.valueOf(game_field [x] [y]), x ,y+1);
      }
    }  
  }
  
  public void game_field_fill() {
    for (int x = 0; x < max_x; x++) {
      for (int y = 0; y < max_y; y++) {
        game_field [x] [y] = 0;
      }
    }
  }
  
  public void random_uboot_gen() {
    int anzahl = 0;
    do {
      int zu1 = (int) (Math.random() *10);
      int zu2 = (int) (Math.random() *10);
    
      if (game_field [zu1] [zu2] == 0) {
        game_field [zu1] [zu2] = 1;
        anzahl = anzahl + 1;
      } // end of if
    } while (anzahl < max_uboot); // end of do-while
  }
  
  public static void main(String[] args) {
    new main();
  } // end of main
  
  // Ende Methoden
} // end of class main

