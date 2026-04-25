import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JFrame {

    public DashboardPage(String username) {

        setTitle("Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Better close handling
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add spacing in layout
        setLayout(new BorderLayout(10, 10));

        // ================= WELCOME LABEL =================
        JLabel welcome = new JLabel("Welcome, " + username);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));
        welcome.setHorizontalAlignment(SwingConstants.CENTER);

        // ================= LOGOUT BUTTON =================
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFocusPainted(false);

        // Correct logout handling (UI thread safe)
        logoutBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                new ModernLoginPage().setVisible(true);
            });
            dispose();
        });

        // ================= ADD COMPONENTS =================
        add(welcome, BorderLayout.CENTER);
        add(logoutBtn, BorderLayout.SOUTH);
    }

    // Optional main (only for testing dashboard directly)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DashboardPage("Test User").setVisible(true);
        });
    }
}