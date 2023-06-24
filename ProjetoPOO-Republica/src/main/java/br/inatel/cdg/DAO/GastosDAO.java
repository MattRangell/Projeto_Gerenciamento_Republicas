package br.inatel.cdg.DAO;

import br.inatel.cdg.Gastos;
import br.inatel.cdg.Morador;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class GastosDAO extends ConnectionDAO {
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertGasto(Gastos gasto, int idMorador) {

        connectToDB();

        String sql = "INSERT INTO Gastos (nome, descricao, data, valor, isGastoFixo, Pagamento_idPagamento) values(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, gasto.getNome());
            pst.setString(2, gasto.getDescricao());
            pst.setDate(3, gasto.getData());
            pst.setDouble(4, gasto.getValor());
            pst.setBoolean(5, gasto.isGastoFixo());
            pst.setNull(6, Types.NULL);

            pst.executeUpdate();

            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()){
                int primaryKey = generatedKeys.getInt(1);
                sql = "INSERT INTO Morador_tem_Gastos (Morador_idMorador, Gastos_idGastos) values(?,?)";
                pst = con.prepareStatement(sql);
                pst.setInt(1, idMorador);
                pst.setInt(2, primaryKey);

                pst.execute();
            }

            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
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
    public ArrayList<Gastos> selectGasto() {
        ArrayList<Gastos> gastos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Gastos";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Gastos GastoAux = new Gastos(rs.getString("nome"), rs.getString("descricao"), rs.getDate("data"), rs.getDouble("valor"), rs.getBoolean("isGastoFixo"));
                gastos.add(GastoAux);
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
        return gastos;
    }
}
