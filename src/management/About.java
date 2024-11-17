
package management;

import javax.swing.*;
import java.awt.*;
import javax.swing.JLabel;

public class About extends JFrame {

    About() {
        setSize(700, 500);
        setLocation(400, 150);

        // Creating a JPanel to hold the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/About1.jpg"));
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(backgroundPanel);

        // Creating other components to be added on top of the background
        JLabel heading = new JLabel("<html>Zero<br/>Hunger System</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        backgroundPanel.add(heading);

        JLabel name = new JLabel("Developed By: ");
        name.setBounds(70, 220, 550, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        backgroundPanel.add(name);

        javax.swing.JLabel rollno1 = new javax.swing.JLabel("Roll number: UCE2023401");
        rollno1.setBounds(70, 270, 550, 40);
        rollno1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(rollno1);
        javax.swing.JLabel rollno2 = new javax.swing.JLabel("Roll number: UCE2023406");
        rollno2.setBounds(70, 300, 550, 40);
        rollno2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(rollno2);
        javax.swing.JLabel rollno3 = new javax.swing.JLabel("Roll number: UCE2023424");
        rollno3.setBounds(70, 330, 550, 40);
        rollno3.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(rollno3);
        
        javax.swing.JLabel rollno4 = new javax.swing.JLabel("Roll number: UCE2023422");
        rollno4.setBounds(70, 360, 550, 40);
        rollno4.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(rollno4);
        // Add more components as needed

        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}

