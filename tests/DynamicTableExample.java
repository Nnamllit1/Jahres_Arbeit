import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DynamicTableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DefaultTableModel model = new DefaultTableModel();

        // Initialisierung des JTable mit einem leeren Model
        JTable table = new JTable(model);
        frame.add(new JScrollPane(table));

        // Hinzufügen eines Buttons, um die Anzahl der Spalten und Zeilen zu ändern
        JButton addRowButton = new JButton("Add Row");
        JButton addColumnButton = new JButton("Add Column");
        addRowButton.addActionListener(e -> addRow(model));
        addColumnButton.addActionListener(e -> addColumn(model));

        // Anordnung der UI-Komponenten
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addRowButton);
        buttonPanel.add(addColumnButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Konfiguration des Frames
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // Methode zum Hinzufügen einer Zeile zum Model
    private static void addRow(DefaultTableModel model) {
        model.addRow(new Object[model.getColumnCount()]);
    }

    // Methode zum Hinzufügen einer Spalte zum Model
    private static void addColumn(DefaultTableModel model) {
        model.addColumn("New Column");
    }
}

