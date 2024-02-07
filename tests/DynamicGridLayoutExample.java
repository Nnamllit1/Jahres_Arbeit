import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DynamicGridLayoutExample {
    private JFrame frame;
    private JPanel panel;

    public DynamicGridLayoutExample() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3)); // Anfangs 2 Zeilen und 3 Spalten

        // Füge einige Beispiel-Komponenten hinzu
        for (int i = 0; i < 6; i++) {
            panel.add(new JButton("Button " + (i + 1)));
        }

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    // Methode zum Ändern der Spalten- und Zeilenanzahl
    public void changeGridLayout(int rows, int cols) {
        panel.setLayout(new GridLayout(rows, cols));
        frame.pack(); // Aktualisiere die Größe des Frames
    }

    public static void main(String[] args) {
        DynamicGridLayoutExample example = new DynamicGridLayoutExample();
        // Beispiel: Ändere die Spalten- und Zeilenanzahl nach 3 Sekunden
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        example.changeGridLayout(3, 2);
    }
}

