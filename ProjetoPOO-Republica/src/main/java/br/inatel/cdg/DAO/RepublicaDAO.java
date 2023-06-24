package br.inatel.cdg.DAO;

import br.inatel.cdg.Morador;
import br.inatel.cdg.Republica;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepublicaDAO extends ConnectionDAO {
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertRep(Republica rep) {

        connectToDB();

        String sql = "INSERT INTO republica (nome) values(?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, rep.getName());

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

    //SELECT
    public ArrayList<Republica> selectRep() {
        ArrayList<Republica> rep = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM republica";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Republica moradaAUX = new Republica(rs.getString("nome"));
                rep.add(moradaAUX);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return rep;
    }
}
