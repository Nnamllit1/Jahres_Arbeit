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
  // end attributes
  
  public launcher() { 
    // Frame init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300;
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("launcher");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    jLabel_Ver.setBounds(0, 0, 80, 24);
    jLabel_Ver.setText("Text");
    cp.add(jLabel_Ver);
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
    try {
      String programName = "luncher";
      String programVersion = "0.0.0";
      System.out.println(getDownloadUrl(programName, programVersion));
      
      } catch (Exception e) {
      e.printStackTrace();
    }
    new launcher();
  } // end of main
  
  // end methods
} // end of class launcher
