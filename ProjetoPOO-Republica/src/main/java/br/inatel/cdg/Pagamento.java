package br.inatel.cdg;

import br.inatel.cdg.DAO.PagamentoDAO;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Pagamento extends PagamentoDAO {
    private Date data; // horario e data do pagamento
    private double valor; // valor do pagamento

    public Pagamento(Date data, double valor) {
        this.data = data;
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public static ArrayList<Pagamento> mostrarPagamento(){
        PagamentoDAO pagamento = new PagamentoDAO();
        return pagamento.mostraPagamentos();
    }
}
