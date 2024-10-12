package swingUi;

import javax.swing.*;

public class LoginUI extends JFrame {
    private JLabel Header;
    private JButton login;
    private JTextField Name;
    private JPanel container;
    private JTextField Password;
    public JFrame frame;

    public LoginUI() {
        this.add(container);
        this.setTitle("Login");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        }


}
