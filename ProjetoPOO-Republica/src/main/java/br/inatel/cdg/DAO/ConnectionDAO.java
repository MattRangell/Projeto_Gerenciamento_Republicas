package br.inatel.cdg.DAO;
import br.inatel.cdg.Morador;
import br.inatel.cdg.Republica;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionDAO{

    public static Connection con; //conexao
    public static PreparedStatement pst; // declaracao(query) preparada - codigo em sql
    Statement st;
    ResultSet rs;
    boolean sucesso;

    static String database = "mydb"; //nome do db
    static String user = "root";
    static String password = "Arkstrom@789";
    static String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

    public static void connectToDB(){
        try{

            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        }

    }
}