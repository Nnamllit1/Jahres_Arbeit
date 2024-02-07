                               import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NoRowDragTableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("No Row Drag Example");
        
        // Erstellen der Tabelle mit Standardmodell
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Column 1", "Column 2", "Column 3"}, 0);
        JTable table = new JTable(model);
        
        // Füge einige Beispieldaten hinzu
        model.addRow(new Object[]{"Data 1", "Data 2", "Data 3"});
        model.addRow(new Object[]{"Data 4", "Data 5", "Data 6"});
        model.addRow(new Object[]{"Data 7", "Data 8", "Data 9"});
        
        // Deaktiviere das Ziehen von Zeilen
        table.setRowDragEnabled(false);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

