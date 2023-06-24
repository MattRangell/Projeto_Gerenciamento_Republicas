package br.inatel.cdg;

import br.inatel.cdg.DAO.MoradorDAO;

import java.util.ArrayList;

public class Morador extends MoradorDAO{
    private int rep; //republica em que o morador se encontra
    private String nome; //nome do morador
    private int age; //idade do morador

    public Morador(String nome, int age, int rep ) {
        this.nome = nome;
        this.age = age;
        this.rep = rep;
    }

    public static void updateMorador(int idMorador, Morador morador){
        MoradorDAO user = new MoradorDAO();
        user.updateUser(idMorador, morador);
    }

    public static ArrayList<Morador> showMoradores(){
        MoradorDAO user = new MoradorDAO();
        return user.selectMorador();
    }

    public static void removeMorador(int id) {
        MoradorDAO mora = new MoradorDAO();

        mora.deleteMorador(id);
    }

    public String getName() {
        return nome;
    }

    public int getAge() {
        return age;
    }

    public int getRepID() {
        return rep;
    }

    public static void AddMorador(Morador morador) {
        MoradorDAO.insertMorador(morador);
    }
}
