package org.example;

import br.inatel.cdg.Gastos;
import br.inatel.cdg.Morador;
import br.inatel.cdg.Pagamento;
import br.inatel.cdg.Republica;

import java.sql.Date;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Flags
        int menu = 0;
        int morador = 0;
        int pagamento = 0;
        int gastos = 0;
        int republica = 0;

        while (menu != 5) {
            System.out.println("1 - Morador");
            System.out.println("2 - Pagamento");
            System.out.println("3 - Gastos");
            System.out.println("4 - República");
            System.out.println("5 - Sair");
            menu = in.nextInt();

            switch (menu) {
                case 1 -> {
                    // Morador
                    while (morador != 5) {
                        System.out.println("1 - Adicionar morador");
                        System.out.println("2 - Atualizar morador");
                        System.out.println("3 - Listar moradores");
                        System.out.println("4 - Deletar moradores");
                        System.out.println("5 - Sair");
                        morador = in.nextInt();
                        in.nextLine();

                        switch (morador) {
                            case 1 -> {
                                System.out.println("------ Cadastro Morador ------");
                                System.out.print("Informe o nome: ");
                                String nome = in.nextLine();

                                System.out.print("Informe a idade: ");
                                int idade = in.nextInt();

                                System.out.print("Informe o id da república: ");
                                int rep = in.nextInt();
                                Morador.AddMorador(new Morador(nome, idade, rep));
                                System.out.println("------------------------------");
                            }
                            case 2 -> {
                                System.out.println("------ Atualizar Morador ------");
                                System.out.print("Informe o id: ");
                                int id = in.nextInt();
                                in.nextLine();

                                System.out.print("Informe o nome: ");
                                String nome = in.nextLine();

                                System.out.print("Informe a idade: ");
                                int idade = in.nextInt();

                                System.out.print("Informe o id da república: ");
                                int rep = in.nextInt();
                                Morador.updateMorador(id, new Morador(nome, idade, rep));
                                System.out.println("------------------------------");
                            }
                            case 3 -> {
                                System.out.println("------ Listagem de Moradores ------");
                                for(Morador m: Morador.showMoradores()){
                                    System.out.println("Nome: " + m.getName());
                                    System.out.println("Idade: " + m.getAge());
                                    System.out.println("------------------------------");
                                }
                            }
                            case 4 -> {
                                System.out.println("------ Deletar Morador ------");
                                System.out.print("Informe o id: ");
                                int id = in.nextInt();
                                Morador.removeMorador(id);
                                System.out.println("------------------------------");
                            }
                            case 5 -> {
                            }
                            default -> System.out.println("Opção não encontrada");
                        }
                    }
                }
                case 2 -> {
                    // Pagamento
                    while (pagamento != 2) {
                        System.out.println("1 - Listar Pagamentos");
                        System.out.println("2 - Sair");
                        pagamento = in.nextInt();

                        switch (pagamento) {
                            case 1 -> {
                                System.out.println("------ Listagem Pagamentos ------");
                                for(Pagamento pag: Pagamento.mostrarPagamento()){
                                    System.out.println("Data: " + pag.getData());
                                    System.out.println("Valor: " + pag.getValor());
                                    System.out.println("------------------------------");
                                }
                            }
                            case 2 -> {
                            }
                            default -> System.out.println("Opção não encontrada");
                        }
                    }
                }
                case 3 -> {
                    // Gastos
                    while (gastos != 2) {
                        System.out.println("1 - Listar Gastos");
                        System.out.println("2 - Sair");
                        gastos = in.nextInt();
                        in.nextLine();

                        switch (gastos) {
                            case 1 -> {
                                System.out.println("------ Listagem Gasto ------");
                                for(Gastos gasto: Gastos.mostrarGastos()){
                                    System.out.println("Nome: " + gasto.getNome());
                                    System.out.println("Descrição: " + gasto.getDescricao());
                                    System.out.println("Data: " + gasto.getData());
                                    System.out.println("Valor: " + gasto.getValor());
                                    System.out.println("Gasto Fixo: " + gasto.isGastoFixo());
                                    System.out.println("------------------------------");
                                }
                            }
                            case 2 -> {
                            }
                            default -> System.out.println("Opção não encontrada");
                        }
                    }
                }
                case 4 -> {
                    // República
                    while (republica != 3) {
                        System.out.println("1 - Adicionar República");
                        System.out.println("2 - Listar República");
                        System.out.println("3 - Sair");
                        republica = in.nextInt();
                        in.nextLine();

                        switch (republica) {
                            case 1 -> {
                                System.out.println("------ Cadastro República ------");
                                System.out.print("Nome: ");
                                String nome = in.nextLine();
                                Republica.addRep(new Republica(nome));
                                System.out.println("------------------------------");
                            }
                            case 2 -> {
                                System.out.println("------ Listagem de Repúblicas ------");
                                for(Republica rep: Republica.showRep()){
                                    System.out.println("Nome: " + rep.getName());
                                    System.out.println("------------------------------");
                                }
                            }
                            case 3 -> {
                            }
                            default -> System.out.println("Opção não encontrada");
                        }
                    }
                }
                case 5 -> {
                }
                default -> System.out.println("Opção não disponível");
            }
        }
    }
}