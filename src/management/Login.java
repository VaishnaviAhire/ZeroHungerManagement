
package management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame //represents GUI WINDOW
{

    Login() {
        
        //setting titles and default close operation
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set a custom font
        Font customFont = new Font("Arial", Font.BOLD, 18);
        UIManager.put("Button.font", customFont); //UIManager.put() method is used to set properties for UI components 
        UIManager.put("Label.font", customFont);

        // Create content pane with GridBagLayout
        JPanel contentPane = new JPanel(new GridBagLayout()) {
            // Override paintComponent to draw background gradient
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw gradient background
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(255, 255, 255);
                Color color2 = new Color(220, 220, 220);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Add buttons with some styling
        gbc.gridy++;
        JButton hotelButton = new JButton("Hotel Interface");
        styleButton(hotelButton);
        JButton ngoButton = new JButton("NGO Interface");
        styleButton(ngoButton);
        JButton userButton = new JButton("User Interface");
        styleButton(userButton);

        contentPane.add(hotelButton, gbc);
        gbc.gridy++;
        contentPane.add(ngoButton, gbc);
        gbc.gridy++;
        contentPane.add(userButton, gbc);

        // Button action listeners
        hotelButton.addActionListener(e -> openInterface("Hotel"));
        ngoButton.addActionListener(e -> openInterface("NGO"));
        userButton.addActionListener(e -> openInterface("User"));

        setContentPane(contentPane);
        pack(); // Adjust frame size
        setSize(600, 400); // Set a custom size (you can adjust this as needed)
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void openInterface(String interfaceType) {
    if (interfaceType.equals("Hotel")) {
        // Open EnterFood directly for the hotel interface
        setVisible(false); // Hide the login window
        new EnterFood().setVisible(true); // Open EnterFood
    } else {
        // For other interfaces, show a message (you can modify this as needed)
        JOptionPane.showMessageDialog(this, interfaceType + " Interface clicked");
        // Add code to open LoginBoard Interface
        Loginboard loginBoard = new Loginboard();
        loginBoard.setVisible(true);
    }
}
    // Method to style buttons
    private void styleButton(JButton button) {
        button.setBackground(new Color(240, 240, 240));
        button.setForeground(Color.DARK_GRAY);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new); // Run GUI code in Event Dispatch Thread
    }
}
