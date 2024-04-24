/**
 *
 * Description
 *
 * @version 1.0 from 19.04.2024
 * @author 
 */

import java.io.*;
import java.nio.file.Paths;

public class efwdv {
  
    public static void main(String[] args) {
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
    }

} // end of class efwdv
