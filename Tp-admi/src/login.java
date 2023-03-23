import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    private JTextField tfemail;
    private JPasswordField tfpassword;
    private JButton bOK;
    private JButton bCANCEL;
    private JPanel login;
    String email = tfemail.getText();
    String password = String.valueOf(tfpassword.getPassword());

    public login(JFrame parent) {
        //super(parent);
        setTitle("login");
        setContentPane(login);
        setMinimumSize(new Dimension(450, 455));
       // setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);


        bOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                  getAuthentificatedUser(email, password);

                Object ActionListener = new Object();
                if (ActionListener != null) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(login.this, "email ou mdp inccorect");

                }
            }

            private void getAuthentificatedUser(String email, String password) {

            }
        });

    }
      public User user;
        private User.User ActionListener  (String email, String password){
            User user =null ;

            final String DB_URL="jdbc:mysql://localhost:3306/bddgraph";
            final String USERNAME="root";
            final String PASSWORD="";
            try {

                Connection con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                Statement stat = con.createStatement();
                String sql = "SELECT* FROM (nom du table)WHERE mail=? AND PASSWORD=?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, String.valueOf(tfemail));
                preparedStatement.setString(2, String.valueOf(tfpassword));

            }
            catch (Exception e) {
                e.printStackTrace();
            }

            return user ;

        }

    @Override
    public void actionPerformed(ActionEvent e) {

        final String DB_URL = "jdbc:mysql://localhost:3306/bddgraph";
        final String USERNAME = "votrenom";
        final String PASSWORD = "votrepass";
        try {

            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stat = con.createStatement();
            String sql = "SELECT* FROM (nom du table)WHERE mail=? AND PASSWORD=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(tfemail));
            preparedStatement.setString(2, String.valueOf(tfpassword));


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
