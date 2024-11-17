
package management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateHotel extends JFrame implements ActionListener{
    
    JTextField tfcourse, tfaddress, tfphone, tfemail, tfbranch;
    javax.swing.JLabel labelEmpId;
    JButton submit, cancel;
    Choice cEmpId;
    
   UpdateHotel () {
        
        setSize(900, 650);
        setLocation(350, 50);
        
        setLayout(null);
        
        javax.swing.JLabel heading = new javax.swing.JLabel("Update Hotel Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);
        
        javax.swing.JLabel lblrollnumber = new javax.swing.JLabel("Select Hotel Id");
        lblrollnumber.setBounds(50, 100, 200, 20);
        lblrollnumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblrollnumber);
        
        cEmpId = new Choice();
        cEmpId.setBounds(250, 100, 200, 20);
        add(cEmpId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()) {
                cEmpId.add(rs.getString("Hotelid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
         javax.swing.JLabel lblname = new javax.swing.JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
       javax.swing.JLabel labelname = new javax.swing.JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);
        
      
     
        
         javax.swing.JLabel lblrollno = new javax.swing.JLabel("Hotel Id");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);
        
       
        labelEmpId = new javax.swing.JLabel();
        labelEmpId.setBounds(200, 200, 200, 30);
        labelEmpId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelEmpId);
     
        
        javax.swing.JLabel lbladdress = new javax.swing.JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        
        javax.swing.JLabel lblphone = new javax.swing.JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        javax.swing.JLabel lblemail = new javax.swing.JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
     
        
           javax.swing.JLabel lblgstin = new javax.swing.JLabel("Gst no. : ");
        lblgstin.setBounds(400, 150, 200, 30);
        lblgstin.setFont(new Font("serif", Font.BOLD, 20));
        add(lblgstin);
        
        JTextField tfgstin = new JTextField();
        tfgstin.setBounds(600, 150, 150, 30);
        add(   tfgstin);
        
        
        try {
            Conn c = new Conn();
            String query = "select * from hotel where Hotelid='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
              
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("emailid"));
                
                labelEmpId.setText(rs.getString("Hotelid"));
                tfgstin.setText(rs.getString("Gstin"));
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from hotel where Hotelid='"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                     
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                       
                        labelEmpId.setText(rs.getString("HotelId"));
                           tfgstin.setText(rs.getString("Gstin"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }


   public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String hotelId = labelEmpId.getText();
        String address = tfaddress.getText();
        String phone = tfphone.getText();
        String emailid = tfemail.getText();
        
        try {
            String query = "update hotel set address='"+address+"', phone='"+phone+"', emailid='"+emailid+"' where Hotelid='"+hotelId+"'";
            Conn con = new Conn();
            con.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Hotel Details Updated Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
    }
}

   
    
    public static void main(String[] args) {
        new UpdateHotel ();
    }
}
