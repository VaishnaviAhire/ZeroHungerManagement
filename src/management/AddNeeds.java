
package management;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class AddNeeds extends JFrame implements ActionListener{
    
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaadhar ,tffood , tfgstin,tflandmarks,tfroad,   tffoodname;
    javax.swing.JLabel labelempId ,  labelneedId;
 
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
  AddNeeds() {
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        javax.swing.JLabel heading = new javax.swing.JLabel("Peoples Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
       
        javax.swing.JLabel lblname = new javax.swing.JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
      
        javax.swing.JLabel lblrollno = new javax.swing.JLabel("need Id");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);
        
        labelneedId = new javax.swing.JLabel("1533"+first4);
         labelneedId.setBounds(200, 200, 200, 30);
         labelneedId.setFont(new Font("serif", Font.BOLD, 20));
        add( labelneedId);
        
       
        
        javax.swing.JLabel lbladdress = new javax.swing.JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        javax.swing.JLabel lblphone = new javax.swing.JLabel("Total adult: ");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        
        
         javax.swing.JLabel lblgstin = new javax.swing.JLabel("Total Family Members : ");
        lblgstin.setBounds(400, 150, 200, 30);
        lblgstin.setFont(new Font("serif", Font.BOLD, 20));
        add(lblgstin);
        
       tfgstin = new JTextField();
        tfgstin.setBounds(600, 150, 150, 30);
        add(   tfgstin);
        
        
        javax.swing.JLabel lblemail = new javax.swing.JLabel("Total kids :");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
      
        
        javax.swing.JLabel lblcourse = new javax.swing.JLabel("Area");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        String course[] = {"Pune", "Pcmc", "alandi", "vishrantwadi", "Lavasa", "Magarpatta", "Nagar", "Bhosari", "chakan", "Karvenagar"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
     
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
          
            String needid = labelneedId.getText();
        ;
            String address = tfaddress.getText();
            String noOfFamilyMembers= tfphone.getText();
            String adult = tfgstin.getText();
            String kids = tfemail.getText();
           
           
            String area = (String) cbcourse.getSelectedItem();
          
            try {
             
String query = "INSERT INTO people (name, needid, address, FamilyMembers, adult,kids, area) VALUES ('"+name+"', '"+needid+"', '"+address+"', '"+noOfFamilyMembers+"', '"+adult+"', '"+kids+"', '"+area+"')";


                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Need  Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddNeeds();
    }
}


