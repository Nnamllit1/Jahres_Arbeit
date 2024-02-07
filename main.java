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
  static int max_x = 25;
  static int max_y = 25;
  static int [] [] game_field = new int [max_x] [max_y];
  public int x;
  public int y;
  
  public JTable jTable_gamefielt = new JTable(0, 1);
    public DefaultTableModel jTable_gamefieltModel = (DefaultTableModel) jTable_gamefielt.getModel();
    public JScrollPane jTable_gamefieltScrollPane = new JScrollPane(jTable_gamefielt);
  public JTextArea jTextArea_gamelog = new JTextArea("");
    public JScrollPane jTextArea_gamelogScrollPane = new JScrollPane(jTextArea_gamelog);
  public JNumberField jNumberField_inputx = new JNumberField();
  public JNumberField jNumberField_inputy = new JNumberField();
  private JButton b_eingabe = new JButton();
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
    jNumberField_inputx.setBounds(500, 306, 75, 20);
    jNumberField_inputx.setText("");
    jNumberField_inputx.setToolTipText("Input for X");
    cp.add(jNumberField_inputx);
    jNumberField_inputy.setBounds(575, 306, 75, 20);
    jNumberField_inputy.setText("");
    jNumberField_inputy.setToolTipText("Input for Y");
    cp.add(jNumberField_inputy);
    b_eingabe.setBounds(537, 326, 75, 25);
    b_eingabe.setText("Eingabe");
    b_eingabe.setMargin(new Insets(2, 2, 2, 2));
    b_eingabe.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b_eingabe_ActionPerformed(evt);
      }
    });
    b_eingabe.setToolTipText("TODO");
    cp.add(b_eingabe);
    // Ende Komponenten
    
    setVisible(true);
    
  
    game_start();
  
  } // end of public main
  
  // Anfang Methoden
  
  public void game_start() {
    game_field_fill();
    random_uboot_gen();
    game_fielt_abgleichen();
  }
  
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
      int zu1 = (int) (Math.random() *max_x);
      int zu2 = (int) (Math.random() *max_y);
    
      if (game_field [zu1] [zu2] == 0) {
        game_field [zu1] [zu2] = 1;
        anzahl = anzahl + 1;
      } // end of if
    } while (anzahl < max_uboot); // end of do-while
  }
  
  public void user_input() {
    int treffer = 0;
    do {
      game_fielt_abgleichen();
      
      if (game_field [x] [y] == 1) {
        log_println("Treffer versengt");
        game_field [x] [y] = 3;
        treffer++;
      } else {
        log_println("Verfehlt");
        game_field [x] [y] = 2;
      } // end of if-else
    } while (treffer < max_uboot); // end of do-while
  }
  
  public void log_println(String input) {
    jTextArea_gamelog.append(input + "\n");
  }
  
  public static void main(String[] args) {
    new main();
  } // end of main
  
  public void b_eingabe_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    x = jNumberField_inputx.getInt();
    y = jNumberField_inputy.getInt();
    jNumberField_inputx.clear();
    jNumberField_inputy.clear();
    user_input();
  } // end of b_eingabe_ActionPerformed

  // Ende Methoden
} // end of class main

