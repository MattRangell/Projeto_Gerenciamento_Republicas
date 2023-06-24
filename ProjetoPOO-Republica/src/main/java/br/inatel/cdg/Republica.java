package br.inatel.cdg;

import br.inatel.cdg.DAO.RepublicaDAO;

import java.util.ArrayList;

public class Republica extends RepublicaDAO {
    private String name; //nome da republica
    private String endereco; //endereco da republica

    public Republica(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public static void addRep(Republica rep){
        RepublicaDAO add = new RepublicaDAO();
        add.insertRep(rep);
    }

    public static ArrayList<Republica> showRep(){
        RepublicaDAO show = new RepublicaDAO();
        return show.selectRep();
    }
}
