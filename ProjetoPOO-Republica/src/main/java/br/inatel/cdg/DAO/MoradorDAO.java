package br.inatel.cdg.DAO;

import br.inatel.cdg.Morador;

import java.sql.SQLException;
import java.util.ArrayList;

public class MoradorDAO extends ConnectionDAO {
    //DAO - Data Access Object
    static boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public static boolean insertMorador(Morador pessoa) {

        connectToDB();

        String sql = "INSERT INTO Morador (nome, idade, Republica_idRepublica) values(?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pessoa.getName());
            pst.setInt(2, pessoa.getAge());
            pst.setInt(3, pessoa.getRepID());

            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro = " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro = " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //UPDATE
    public boolean updateUser(int id, Morador user) {
        connectToDB();
        String sql = "UPDATE Morador SET nome=?, idade=?, Republica_idRepublica=? WHERE idMorador=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setInt(2, user.getAge());
            pst.setInt(3, user.getRepID());
            pst.setInt(4, id);

            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro = " + exc.getMessage());
            }
        }
        return sucesso;
    }


    //DELETE
    public boolean deleteMorador(int id) {
        connectToDB();
        String sql = "DELETE FROM Morador where idMorador=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro = " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //SELECT
    public ArrayList<Morador> selectMorador() {
        ArrayList<Morador> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Morador";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Morador userAux = new Morador(rs.getString("nome"), rs.getInt("idade"), rs.getInt("Republica_idRepublica"));
                users.add(userAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro = " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro = " + e.getMessage());
            }
        }
        return users;
    }
}
