package br.inatel.cdg.DAO;

import br.inatel.cdg.Morador;
import br.inatel.cdg.Pagamento;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class PagamentoDAO extends ConnectionDAO {
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //SELECT
    public ArrayList<Pagamento> mostraPagamentos() {
        ArrayList<Pagamento> bills = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM pagamento";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Pagamento payAux = new Pagamento(rs.getDate("data"), rs.getInt("valor"));
                bills.add(payAux);
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
        return bills;
    }


}
