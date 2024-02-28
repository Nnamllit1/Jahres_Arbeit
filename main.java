import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.JFrame;
import java.io.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.02.2024
 * @author 
 */

public class main extends JFrame {
  // Anfang Attribute
  // start attributes
  int max_uboot = 1;
  int max_x = 10;
  int max_y = 10;
  
  int [] [] game_field;
  
  //int [] [] game_field = new int [max_x] [max_y];
  
  //public int x;
  //public int y;
  public int treffer;
  public boolean cheats = false;
  
  public JTable jTable_gamefielt = new JTable(0, 1);
    public DefaultTableModel jTable_gamefieltModel = (DefaultTableModel) jTable_gamefielt.getModel();
    public JScrollPane jTable_gamefieltScrollPane = new JScrollPane(jTable_gamefielt);
  public JTextArea jTextArea_gamelog = new JTextArea("");
    public JScrollPane jTextArea_gamelogScrollPane = new JScrollPane(jTextArea_gamelog);
  public JNumberField jNumberField_inputx = new JNumberField();
  public JNumberField jNumberField_inputy = new JNumberField();
  private JButton b_eingabe = new JButton();
  private JButton bStartNewGame1 = new JButton();
  private JPanel jPanel1 = new JPanel(null, true);
    private JLabel lNewGameSettings1 = new JLabel();
    private JLabel lUboote1 = new JLabel();
    private JTextArea jTextArea_logofshame = new JTextArea();
      private JScrollPane jTextArea_logofshameScrollPane = new JScrollPane(jTextArea_logofshame);
    private JLabel lPlayingfieldsizeX2 = new JLabel();
    private JLabel lPlayingfieldsizeY1 = new JLabel();
    private JLabel lanysizeover25isntrecommended1 = new JLabel();
    private JButton bStart1 = new JButton();
    private JNumberField jNumberField_uboote = new JNumberField();
    private JNumberField jNumberField_x = new JNumberField();
    private JNumberField jNumberField_y = new JNumberField();
    private JLabel lCheats = new JLabel();
    private JCheckBox jCheckBox_cheats = new JCheckBox();
  // end attributes
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
    // start components
    // Anfang Komponenten
    
    jTable_gamefieltScrollPane.setBounds(0, 0, 500, 500);
    jTable_gamefielt.setRowSelectionAllowed(false);
    jTable_gamefielt.setEnabled(false);
    jTable_gamefielt.setFillsViewportHeight(false);
    jTable_gamefielt.setAutoCreateRowSorter(false);
    jTable_gamefielt.getColumnModel().getColumn(0).setHeaderValue("");
    cp.add(jTable_gamefieltScrollPane);
    jTextArea_gamelogScrollPane.setBounds(500, 352, 300, 150);
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
    lCheats.setBounds(192, 24, 112, 24);
    lCheats.setText("Cheats?");
    lCheats.setToolTipText("Or for debuging");
    jPanel1.add(lCheats);
    jCheckBox_cheats.setBounds(304, 24, 24, 24);
    jCheckBox_cheats.setOpaque(false);
    jCheckBox_cheats.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jCheckBox_cheats_ActionPerformed(evt);
      }
    });
    jPanel1.add(jCheckBox_cheats);
    // Ende Komponenten
    
    bStartNewGame1.setBounds(500, 0, 115, 24);
    bStartNewGame1.setText("Start New Game");
    bStartNewGame1.setMargin(new Insets(2, 2, 2, 2));
    bStartNewGame1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bStartNewGame1_ActionPerformed(evt);
      }
    });
    cp.add(bStartNewGame1);
    jPanel1.setBounds(500, 24, 500, 240);
    jPanel1.setOpaque(false);
    jPanel1.setVisible(false);
    cp.add(jPanel1);
    lNewGameSettings1.setBounds(0, 0, 115, 24);
    lNewGameSettings1.setText("New Game Settings");
    jPanel1.add(lNewGameSettings1);
    lUboote1.setBounds(0, 24, 112, 24);
    lUboote1.setText("Uboote");
    jPanel1.add(lUboote1);
    jTextArea_logofshameScrollPane.setBounds(0, 160, 500, 80);
    jTextArea_logofshame.setToolTipText("The log of shame");
    jPanel1.add(jTextArea_logofshameScrollPane);
    lPlayingfieldsizeX2.setBounds(0, 48, 112, 24);
    lPlayingfieldsizeX2.setText("Playing field size X");
    jPanel1.add(lPlayingfieldsizeX2);
    lPlayingfieldsizeY1.setBounds(0, 72, 112, 24);
    lPlayingfieldsizeY1.setText("Playing field size Y");
    jPanel1.add(lPlayingfieldsizeY1);
    lanysizeover25isntrecommended1.setBounds(0, 96, 218, 24);
    lanysizeover25isntrecommended1.setText("* any size over 25 isn't recommended");
    jPanel1.add(lanysizeover25isntrecommended1);
    bStart1.setBounds(0, 128, 80, 24);
    bStart1.setText("Start");
    bStart1.setMargin(new Insets(2, 2, 2, 2));
    bStart1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bStart1_ActionPerformed(evt);
      }
    });
    jPanel1.add(bStart1);
    jNumberField_uboote.setBounds(112, 24, 80, 24);
    jPanel1.add(jNumberField_uboote);
    jNumberField_x.setBounds(112, 48, 80, 24);
    jPanel1.add(jNumberField_x);
    jNumberField_y.setBounds(112, 72, 80, 24);
    jPanel1.add(jNumberField_y);



    // end components
    setVisible(true);
    
  
    //game_start();
  
  } // end of public main
  
  // Anfang Methoden
  
  // start methods
  public void game_start(int uboote, int x, int y) {
    max_x = x;
    max_y = y;
    max_uboot = uboote;
    
    game_field = new int[max_x][max_y];
    
    game_field_fill();
    random_uboot_gen();
    game_fielt_abgleichen();
  }
  
  public void game_fielt_abgleichen() {
    
    jTable_gamefieltModel.setColumnCount(1);
    jTable_gamefieltModel.setRowCount(0);
  
    for (int y = 0; y < max_y; y++) {
      jTable_gamefieltModel.addColumn(String.valueOf(y));
    }
    jTable_gamefieltModel.setRowCount(max_x);
    for (int x = 0; x < max_x; x++) {
      jTable_gamefieltModel.setValueAt(String.valueOf(x), x, 0);
      for (int y = 0; y < max_y; y++) {
        if (cheats == true) {
          jTable_gamefieltModel.setValueAt(String.valueOf(game_field [x] [y]), x ,y+1);
        } else {
          if (game_field [x] [y] == 1) {
            jTable_gamefieltModel.setValueAt(String.valueOf(0), x ,y+1);
          } else {
            jTable_gamefieltModel.setValueAt(String.valueOf(game_field [x] [y]), x ,y+1);  
          } // end of if-else
        } // end of if-else
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
  
  public void user_input(int x, int y) {
    if (game_field [x] [y] == 1) {
      log_println("Treffer versengt");
      game_field [x] [y] = 3;
      treffer++;
    } else {
      log_println("Verfehlt");
      game_field [x] [y] = 2;
    } // end of if-else
    
    if (treffer >= max_uboot) {
      log_println("Gewonnen!!!");
    } // end of if
    
  }
  
  public void log_println(String input) {
    jTextArea_gamelog.append("\n" + input);
  }
  
  public static void main(String[] args) {
    new main();
  } // end of main
  
  public void b_eingabe_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfuegen
    int x = jNumberField_inputx.getInt();
    int y = jNumberField_inputy.getInt();
    jNumberField_inputx.clear();
    jNumberField_inputy.clear();
    user_input(x,y);
    game_fielt_print();
  } // end of b_eingabe_ActionPerformed
  
  public void game_fielt_print() {
    for (int x = 0; x < max_x; x++) {
      for (int y = 0; y < max_y; y++) {
        if (cheats == true) {
          jTable_gamefieltModel.setValueAt(String.valueOf(game_field [x] [y]), x ,y+1);
        } else {
          if (game_field [x] [y] == 1) {
            jTable_gamefieltModel.setValueAt(String.valueOf(0), x ,y+1);
          } else {
            jTable_gamefieltModel.setValueAt(String.valueOf(game_field [x] [y]), x ,y+1);  
          } // end of if-else
        } // end of if-else
      }
    }
  }

  public void jCheckBox_cheats_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    cheats =! cheats;
    //log_println(String.valueOf(cheats));
  } // end of jCheckBox_cheats_ActionPerformed

  public void bStartNewGame1_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    bStartNewGame1.setVisible(false);
    jPanel1.setVisible(true);
  } // end of bStartNewGame1_ActionPerformed

  public void bStart1_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    int Uboote = jNumberField_uboote.getInt();
    int nmax_x = jNumberField_x.getInt();
    int nmax_y = jNumberField_y.getInt();
    
    
    
    bStartNewGame1.setVisible(true);
    jPanel1.setVisible(false);
    jNumberField_uboote.clear();
    jNumberField_x.clear();
    jNumberField_y.clear();
    game_start(Uboote, nmax_x, nmax_y);
    
  } // end of bStart1_ActionPerformed







  // end methods
} // end of class main

