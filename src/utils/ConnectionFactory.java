package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
//    private static final String URL ="jdbc:mariadb://localhost:3306/exercicio10";
//    private static final String USER = "root";
//    private static final String PW = "root";
//    private static final String DRIVER = "org.mariadb.jdbc.Driver";

    private static final String URL ="jdbc:mysql://localhost:3306/exercicio10";
    private static final String USER = "root";
    private static final String PW = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection factory() {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL, USER, PW);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}