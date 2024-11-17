
package management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class NeedDetails extends JFrame implements ActionListener {

    Choice   cId;
    JTable table;
    JButton search, print, update, add, cancel;
    
 NeedDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        javax.swing.JLabel heading = new javax.swing.JLabel("Search by need Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        cId = new Choice();
          cId.setBounds(180, 20, 150, 20);
        add(  cId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from people");
            while(rs.next()) {
                 cId.add(rs.getString("needid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from people");
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    

public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == search) {
        String selectedId = cId.getSelectedItem();
        if (selectedId != null && !selectedId.isEmpty()) {
            String query = "select * from people where needid = '" + selectedId + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                // Create a table model to hold the data
                DefaultTableModel model = new DefaultTableModel();
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                // Add column names to the table model
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    model.addColumn(metaData.getColumnName(columnIndex));
                }
                // Add rows to the table model
                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        row[columnIndex - 1] = rs.getObject(columnIndex);
                    }
                    model.addRow(row);
                }
                // Set the table model to the JTable
                table.setModel(model);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a need ID.");
        }
    } else if (ae.getSource() == print) {
        try {
            table.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == add) {
        setVisible(false);
        new AddNeeds();
    } else if (ae.getSource() == update) {
        setVisible(false);
        new UpdateNeedDetails ();
    } else {
        setVisible(false);
    }
}


    public static void main(String[] args) {
        new  NeedDetails();
    }
}
