import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ModernLoginPage extends JFrame {

    private final Color backgroundColorStart = new Color(15, 15, 15);
    private final Color backgroundColorEnd = new Color(40, 40, 40);
    private final Color cardColor = new Color(30, 30, 30);
    private final Color orangeColor = new Color(255, 140, 0);
    private final Color textColor = new Color(220, 220, 220);
    private final Color fieldColor = new Color(45, 45, 45);

    public ModernLoginPage() {
        setTitle("Modern Login - InternShield");
        setSize(1000, 700); // Larger, more "weblike" window
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Custom Gradient Panel for background
        JPanel mainPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth(), h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, backgroundColorStart, w, h, backgroundColorEnd);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };

        JPanel cardPanel = new JPanel();
        cardPanel.setBackground(cardColor);
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        cardPanel.setPreferredSize(new Dimension(400, 450)); // Larger card
        cardPanel.setMaximumSize(new Dimension(400, 450));
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(60, 60, 60), 1, true),
                new EmptyBorder(40, 50, 40, 50)
        ));

        JLabel titleLabel = new JLabel("InternShield Login");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel userLabel = createLabel("Username");
        JTextField userField = createTextField();

        JLabel passLabel = createLabel("Password");
        JPasswordField passField = createPasswordField();

        JCheckBox showPass = new JCheckBox("Show Password");
        showPass.setBackground(cardColor);
        showPass.setForeground(textColor);
        showPass.setFocusPainted(false);
        showPass.setAlignmentX(Component.CENTER_ALIGNMENT);
        showPass.addActionListener(e -> {
            passField.setEchoChar(showPass.isSelected() ? (char) 0 : '•');
        });

        JButton loginButton = createButton("Login");
        loginButton.addActionListener(e -> {
            String username = userField.getText().trim();
            String password = new String(passField.getPassword()).trim();

            if (username.equalsIgnoreCase("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                new DashboardPage(username).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cardPanel.add(titleLabel);
        cardPanel.add(Box.createVerticalStrut(30));
        cardPanel.add(userLabel);
        cardPanel.add(Box.createVerticalStrut(5));
        cardPanel.add(userField);
        cardPanel.add(Box.createVerticalStrut(20));
        cardPanel.add(passLabel);
        cardPanel.add(Box.createVerticalStrut(5));
        cardPanel.add(passField);
        cardPanel.add(Box.createVerticalStrut(10));
        cardPanel.add(showPass);
        cardPanel.add(Box.createVerticalStrut(30));
        cardPanel.add(loginButton);

        mainPanel.add(cardPanel);
        add(mainPanel);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(textColor);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private JTextField createTextField() {
        JTextField field = new JTextField();
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        field.setBackground(fieldColor);
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(80, 80, 80), 1),
                new EmptyBorder(0, 10, 0, 10)
        ));
        return field;
    }

    private JPasswordField createPasswordField() {
        JPasswordField field = new JPasswordField();
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        field.setBackground(fieldColor);
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(80, 80, 80), 1),
                new EmptyBorder(0, 10, 0, 10)
        ));
        return field;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(200, 45)); // fixed width
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // center it

        button.setBackground(orangeColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Simple hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(255, 165, 0));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(orangeColor);
            }
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ModernLoginPage().setVisible(true);
        });
    }
}