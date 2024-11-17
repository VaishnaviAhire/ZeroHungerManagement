
package management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class FoodFeeForm extends JFrame {
    
    JTable table;
    JScrollPane jsp;

  FoodFeeForm() {
        setSize(1000, 700);
        setLocation(250, 50);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);
        
        javax.swing.JLabel heading = new javax.swing.JLabel("Food Details", SwingConstants.CENTER);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading, BorderLayout.NORTH);
        
        table = new JTable();
        jsp = new JScrollPane(table);
        add(jsp, BorderLayout.CENTER);
        
        loadTableData();
        
        setVisible(true);
    }
    
    private void loadTableData() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from items");
            
            // Get ResultSet metadata
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            
            // Create table model with column names
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            
            // Populate table model with data
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }
            
            table.setModel(model);
            
            // Close ResultSet and Statement
            rs.close();
            c.s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new FoodFeeForm();
    }
}
