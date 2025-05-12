import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class FanDataBaseApp {
    private static final String URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String USER = "student1";
    private static final String PASSWORD = "pass";
    
    private JTextField idField, firstNameField, lastNameField, favoriteTeamField;
    private JButton displayButton, updateButton;
    
    public FanDataBaseApp() {
        JFrame frame = new JFrame("Fan Database Application");
        frame.setLayout(new GridLayout(5, 2, 10, 10));
        
        // ID field
        frame.add(new JLabel("ID:"));
        idField = new JTextField();
        frame.add(idField);
        
        // First name field
        frame.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        frame.add(firstNameField);
        
        // Last name field
        frame.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        frame.add(lastNameField);
        
        // Favorite team field
        frame.add(new JLabel("Favorite Team:"));
        favoriteTeamField = new JTextField();
        frame.add(favoriteTeamField);
        
        // Display Button
        displayButton = new JButton("Display");
        displayButton.addActionListener(e -> displayFanRecord());
        frame.add(displayButton);
        
        // Update Button
        updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updateFanRecord());
        frame.add(updateButton);
        
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private void displayFanRecord() {
        String id = idField.getText();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM fans WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(id));
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                favoriteTeamField.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(null, "Record not found!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving data: " + e.getMessage());
        }
    }
    
    private void updateFanRecord() {
        String id = idField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String favoriteTeam = favoriteTeamField.getText();
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, favoriteTeam);
            stmt.setInt(4, Integer.parseInt(id));
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Record updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Error updating record.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating data: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Set the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Run the application
        SwingUtilities.invokeLater(FanDataBaseApp::new);
    }
}