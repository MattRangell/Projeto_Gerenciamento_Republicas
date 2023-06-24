package br.inatel.cdg;

import br.inatel.cdg.DAO.GastosDAO;

import java.util.ArrayList;
import java.util.Date;

public class Gastos extends GastosDAO {
    private String nome; // nome de classificacao do gasto
    private String descricao; //descricao mais detalhada do gasto
    private Date data; //data e horario em que o gasto ocorreu
    private double valor; //valor do gasto
    private boolean isGastoFixo; // flag que indica se o gasto adicionado e gasto fixo


    public Gastos(String nome, String descricao, Date data, double valor, boolean isGastoFixo) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.isGastoFixo = isGastoFixo;
    }

    public static ArrayList<Gastos> mostrarGastos() {
        GastosDAO gasto = new GastosDAO();
        return gasto.selectGasto();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }


    public java.sql.Date getData() {
        return (java.sql.Date) data;
    }


    public double getValor() {
        return valor;
    }


    public boolean isGastoFixo() {
        return isGastoFixo;
    }
}
