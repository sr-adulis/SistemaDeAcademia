/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import java.util.Scanner;

/**
 *
 * @author Pedro Henrique
 */
public class Controlador {

    static Personal[] personal = new Personal[5];

    public static void menuPrincipal() {
        Scanner in = new Scanner(System.in);
        String menuP;
        System.out.println("Projeto agendamento de academia Windows academic");
        System.out.println("\n MENU PRINCIPAL"/*Mostra Todos + opções:selecionar(remover/alterar/adicionar/adicionarCompromisso)*/
                + "\n 1- Lista de Personal treiners "
                + "\n 2- Adicionbar novo personal"
                + "\n 2- Buscar Personais disponiveis por data"/*Mostra somente os disponiveis + opções : selecionar(adicionar compromisso)*/
                + "");
        System.out.println("Enter com a opção desejada");
        menuP = in.nextLine();
        switch (menuP) {
            case ("1"):
                printListaPersonal();
            case("2"):    
        }

    }

    public static void addPersonal() {
        System.out.println("Opção adicionar personal selecionada");
        Scanner in = new Scanner(System.in);
        
    }

    public static String printListaPersonal() {
        if (Personal.getQuantidade() > 0) {
            int i = 0;
            String resultado = "\n\n\n Nº do personal: " + i + "nome: " + personal[i].getNome() + "\n";
            i++;
            if (Personal.getQuantidade() > i) {
                return resultado + printListaPersonal(i);
            }
            return resultado;
        }
        return "Não há Personal treiner algum cadastrado, cadastre um personal na opção 1";
    }

    public static String printListaPersonal(int i) {

        String resultado = "Nº do personal: " + i + "nome: " + personal[i].getNome();
        i++;
        if (Personal.getQuantidade() > i) {
            return resultado + printListaPersonal(i);
        }
        return resultado;
    }
}
