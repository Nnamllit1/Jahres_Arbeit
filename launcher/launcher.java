import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Paths;

/**
 *
 * Description
 *
 * @version 1.0 from 19.04.2024
 * @author 
 */

public class launcher extends JFrame {
  // start attributes
  private JLabel jLabel_Ver = new JLabel();
  private JButton b_PlayUpdate = new JButton();
  // end attributes
  
  public launcher() { 
    // Frame init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 600; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Launcher");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    jLabel_Ver.setBounds(0, 0, 80, 24);
    jLabel_Ver.setText("Text");
    cp.add(jLabel_Ver);
    b_PlayUpdate.setBounds(0, 24, 80, 24);
    b_PlayUpdate.setText("Play/Update");
    b_PlayUpdate.setMargin(new Insets(2, 2, 2, 2));
    b_PlayUpdate.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b_PlayUpdate_ActionPerformed(evt);
      }
    });
    cp.add(b_PlayUpdate);
    // end components
    init();
    setVisible(true);
  } // end of public launcher
  
  public void init() {
    try {
      jLabel_Ver.setText(getDownloadUrl("luncher", "0.0.0"));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
  
  // start methods
  public static String getDownloadUrl(String programName, String programVersion) throws Exception {
      String url = "https://raw.githubusercontent.com/Nnamllit1/Jahres_Arbeit/main/update/Vers.txt";
      HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
      conn.setRequestMethod("GET");
      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String inputLine;
      StringBuffer content = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
      }
      in.close();
      conn.disconnect();

      JSONObject jsonObj = new JSONObject(content.toString());
      JSONArray jsonArray = jsonObj.getJSONArray(programName);
      for (int i = 0; i < jsonArray.length(); i++) {
          JSONObject obj = jsonArray.getJSONObject(i);
          if (!obj.getString("version").equals(programVersion)) { 
             return obj.getString("download");
          }
      }
    return null;
  }
  

  public static void main(String[] args) {
    String currentDir = System.getProperty("user.dir");
    System.out.println(currentDir);
    try {
      String programName = "luncher";
      String programVersion = "0.0.0";
      System.out.println(getDownloadUrl(programName, programVersion));
      
      } catch (Exception e) {
      e.printStackTrace();
    }
    new launcher();
  } // end of main
  
  public void b_PlayUpdate_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
            try {
            // Pfad zum aktuellen Verzeichnis
            String currentDir = System.getProperty("user.dir");

            // Pfad zum übergeordneten Verzeichnis
            String parentDir = Paths.get(currentDir).getParent().toString();

            // Pfad zur JAR-Datei
            String jarPath = parentDir + "/main.jar";
      
            System.out.println("java" + "-jar: " + jarPath + "\n");

            // Erstellen Sie einen neuen Prozess
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath);

            // Starten Sie den Prozess
            Process process = processBuilder.start();

            // Lesen Sie die Ausgabe
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Warten Sie, bis der Prozess beendet ist
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
  } // end of b_PlayUpdate_ActionPerformed

  // end methods
} // end of class launcher
