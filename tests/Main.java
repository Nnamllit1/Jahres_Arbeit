import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    
    jInternalFrame1.setBounds(488, 80, 500, 250);
    jInternalFrame1.setVisible(true);
    cp.add(jInternalFrame1);
    jInternalFrame1.setBorder(BorderFactory.createEtchedBorder()); // Hinzugefügt: Rahmen
    jInternalFrame1.setBackground(Color.WHITE); // Hinzugefügt: Hintergrundfarbe
    
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.WHITE); // Hinzugefügt: Hintergrundfarbe
    
    lNewGameSettings1.setBounds(10, 5, 150, 25); // Geändert: Position und Größe
    lNewGameSettings1.setText("<html><b>New Game Settings</b></html>"); // Geändert: Fett formatiert
    panel.add(lNewGameSettings1);
    
    lUboote1.setBounds(10, 35, 150, 24); // Geändert: Position und Größe
    panel.add(lUboote1);
    
    jNumberField_Uboote.setBounds(165, 35, 100, 24); // Geändert: Position und Größe
    panel.add(jNumberField_Uboote);
    
    lSpielfeltGroesseX1.setBounds(10, 65, 150, 25); // Geändert: Position und Größe
    panel.add(lSpielfeltGroesseX1);
    
    jNumberField_X.setBounds(165, 65, 100, 25); // Geändert: Position und Größe
    panel.add(jNumberField_X);
    
    lSpielfeltGroesseY2.setBounds(10, 95, 150, 25); // Geändert: Position und Größe
    panel.add(lSpielfeltGroesseY2);
    
    jNumberField_Y.setBounds(165, 95, 100, 25); // Geändert: Position und Größe
    panel.add(jNumberField_Y);
    
    jInternalFrame1.add(panel); // Geändert: Panel hinzufügen
   // end components
    setVisible(true);
}
