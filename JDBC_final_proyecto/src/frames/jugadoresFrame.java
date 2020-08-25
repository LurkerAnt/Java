package frames;

import DAO.MYSQL.MySQLDaoManager;
import DAOS.DAOManager;

import javax.swing.*;
import java.sql.SQLException;

public class jugadoresFrame {
    private JPanel Jugadores;
    private JButton insertButton;
    private JTable tabla;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) throws SQLException {
        final String configUTF = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String USER = "userJDBC";
        final String PASSWORD = "12345";

        DAOManager daoManager = new MySQLDaoManager("localhost",USER, PASSWORD, "equipos"+configUTF);
    }
}
