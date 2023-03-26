import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                Connection con = null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                try {
// se connecter à la base de données
                    con = connexion.seConnecter();
// requête SQL pour récupérer l'utilisateur authentifié
                    String sql = "SELECT * FROM etudiant WHERE mail=? AND PASSWORD=?";
                    preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, password);
// exécuter la requête
                    resultSet = preparedStatement.executeQuery();
// vérifier si l'utilisateur existe
                    if (resultSet.next()) {
// l'utilisateur est authentifié
                        dispose();
                    } else {
// afficher un message d'erreur
                        JOptionPane.showMessageDialog(login.this, "Email ou mot de passe incorrect");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } finally {
// fermer les ressources utilisées
                    try {
                        if (resultSet != null) resultSet.close();
                        if (preparedStatement != null) preparedStatement.close();
                        if (con != null) con.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }


        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String email = tfemail.getText();
        String password = String.valueOf(tfpassword.getPassword());

        try {
            // Connexion à la base de données
            Connection conn = connexion.seConnecter();

            // Requête préparée pour récupérer l'utilisateur authentifié
            String sql = "SELECT * FROM utilisateur WHERE mail = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);

            // Exécution de la requête
            ResultSet result = statement.executeQuery();

            // Vérification des résultats
            if (result.next()) {
                // Utilisateur authentifié
                dispose();  // Ferme la fenêtre de login
                // Faire quelque chose d'autre...
            } else {
                // Mauvais email ou mot de passe
                JOptionPane.showMessageDialog(login.this, "Email ou mot de passe incorrect");
            }

            // Fermeture de la connexion
            conn.close();
        } catch (SQLException ex) {
            // Gestion des erreurs SQL
            throw new RuntimeException(ex);
        }
    }








    /*@Override
    public void actionPerformed(ActionEvent e) {

        final String DB_URL = "jdbc:mysql://localhost:3306/bddgraph";
        final String USERNAME = "votrenom";
        final String PASSWORD = "votrepass";
        try {

            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stat = con.createStatement();
            String sql = "SELECT* FROM etudiantWHERE mail=? AND PASSWORD=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(tfemail));
            preparedStatement.setString(2, String.valueOf(tfpassword));


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }*/
}
